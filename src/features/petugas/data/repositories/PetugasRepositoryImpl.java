package features.petugas.data.repositories;

import cores.entities.Petugas;
import cores.exceptions.IllegalOrphanException;
import cores.exceptions.NonexistentEntityException;
import cores.exceptions.ServerException;
import cores.exceptions.UnexpectedException;
import cores.provider.SharedPreferences;
import cores.styles.Strings;
import cores.utils.AlertDialog;
import cores.utils.Navigator;
import cores.utils.Scalr;
import cores.utils.Scalr.Mode;
import cores.widgets.RoundedRectangleBorder;
import features.petugas.data.datasources.PetugasLocalDataSource;
import features.petugas.data.datasources.PetugasRemoteDataSource;
import features.petugas.presentation.pages.AddPetugasPage;
import features.petugas.presentation.pages.DetailPetugasPage;
import features.petugas.presentation.pages.ListPetugasPage;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author rizal
 */
public class PetugasRepositoryImpl implements PetugasRepository {
    private static final Logger LOG = Logger.getLogger(
            PetugasRepositoryImpl.class.getName());

    private final PetugasRemoteDataSource remoteDataSource;
    private final PetugasLocalDataSource localDataSource;
    private final SharedPreferences preferences;

    public PetugasRepositoryImpl(PetugasRemoteDataSource remoteDataSource,
            PetugasLocalDataSource localDataSource,
            SharedPreferences preferences) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
        this.preferences = preferences;
    }

    @Override
    public boolean login(String namaPengguna, String kataSandi) {
        try {
            final var result = remoteDataSource.login(namaPengguna, kataSandi);

            return result != null;
        } catch (NonexistentEntityException | ServerException ex) {
            AlertDialog.showErrorDialog(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public List<Petugas> getListPetugas(int maxResults, int firstResult) {
        try {
            return remoteDataSource.getListPetugas(maxResults,
                    firstResult);
        } catch (ServerException ex) {
            AlertDialog.showErrorDialog(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Petugas getPetugas(int id) {
        try {
            return remoteDataSource.getPetugas(id);
        } catch (ServerException ex) {
            AlertDialog.showErrorDialog(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void insertPetugas(AddPetugasPage context) {
        final var id = context.petugas.getId();
        final var foto = context.petugas.getFoto();
        final var namaLengkap = context.et_namaPetugas.getText().strip();
        final var namaPengguna = context.et_namaPengguna.getText().strip();
        final var noTelepon = context.et_noTelepon.getText().strip();
        final var kataSandi = String.valueOf(context.et_kataSandi.getPassword());
        final var konfirmasiKataSandi = String.valueOf(
                context.et_konfirmasiKataSandi.getPassword());
        final var hakAkses = context.cb_hakAkses.getSelectedItem().toString();

        if (namaLengkap.isBlank() || namaPengguna.isBlank()
                || noTelepon.isBlank() || kataSandi.isBlank()
                || konfirmasiKataSandi.isBlank()) {
            AlertDialog.showErrorDialog(Strings.ERROR_DIALOG_EMPTY_FIELD);
            return;
        }

        if (kataSandi.length() < 8) {
            AlertDialog.showErrorDialog(Strings.ERROR_DIALOG_PASSWORD_LENGTH);
            return;
        }

        if (!kataSandi.equals(konfirmasiKataSandi)) {
            AlertDialog.showErrorDialog(Strings.ERROR_DIALOG_PASSWORD_NOT_MATCH);
            return;
        }

        final var petugas = new Petugas();
        petugas.setId(id);
        petugas.setFoto(foto);
        petugas.setNamaPetugas(namaLengkap);
        petugas.setNamaPengguna(namaPengguna);
        petugas.setNoTelepon(noTelepon);
        petugas.setKataSandi(kataSandi);
        petugas.setHakAkses(hakAkses);
        petugas.setStatus(Strings.DATABASE_TIDAK_AKTIF);

        try {
            if (petugas.getId() == null) {
                remoteDataSource.insertPetugas(petugas);

                clear(context);
                Navigator.push(new ListPetugasPage(this, preferences));
            } else {
                throw new Exception(Strings.ERROR_DIALOG_ID_IS_NOT_NULL);
            }
        } catch (ServerException ex) {
            AlertDialog.showErrorDialog(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            AlertDialog.showErrorDialog(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean updatePetugas(DetailPetugasPage context, Petugas petugas) {
        try {
            if (petugas.getId() != null) {
                remoteDataSource.updatePetugas(petugas);
                return true;
            } else {
                throw new Exception(Strings.ERROR_DIALOG_ID_IS_NULL);
            }
        } catch (IllegalOrphanException | NonexistentEntityException
                | ServerException ex) {
            AlertDialog.showErrorDialog(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            AlertDialog.showErrorDialog(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean deletePetugas(int id) {
        try {
            remoteDataSource.deletePetugas(id);
            return true;
        } catch (IllegalOrphanException | NonexistentEntityException
                | ServerException ex) {
            AlertDialog.showErrorDialog(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public BufferedImage getImageFromDisk(int width, int height) {
        try {
            final var result = localDataSource.getImageFromDisk();
            if (result == null) {
                return null;
            }
            final var image = ImageIO.read(result);

            var mode = Mode.FIT_TO_HEIGHT;
            if (image.getWidth() < image.getHeight()) {
                mode = Mode.FIT_TO_WIDTH;
            }
            final var resizedImage = Scalr.resize(image, mode, width, height);
            final var croppedImage = Scalr.crop(resizedImage, width, height);
            return croppedImage;

        } catch (IOException | UnexpectedException ex) {
            AlertDialog.showErrorDialog(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void clear(AddPetugasPage context) {
        context.b_addImage.setText("Tambah foto");
        context.b_addImage.setBorder(new RoundedRectangleBorder());
        context.b_addImage.setIcon(null);

        context.et_namaPetugas.setText(null);
        context.et_namaPengguna.setText(null);
        context.et_noTelepon.setText(null);
        context.et_kataSandi.setText(null);
        context.et_konfirmasiKataSandi.setText(null);
    }

}
