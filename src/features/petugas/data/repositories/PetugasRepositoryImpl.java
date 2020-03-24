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
import cores.widgets.RoundedRectangleBorder;
import features.petugas.data.datasources.PetugasLocalDataSource;
import features.petugas.data.datasources.PetugasRemoteDataSource;
import features.petugas.presentation.pages.AddPetugasPage;
import features.petugas.presentation.pages.EditPetugasPasswordPage;
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

            if (result != null) {
                return true;
            }
            return false;
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
    public void updatePetugas(AddPetugasPage context, String kataSandi) {
        final var id = context.petugas.getId();
        final var foto = context.petugas.getFoto();
        final var namaLengkap = context.et_namaPetugas.getText().strip();
        final var namaPengguna = context.et_namaPengguna.getText().strip();
        final var noTelepon = context.et_noTelepon.getText().strip();
        final var hakAkses = context.cb_hakAkses.isVisible()
                ? context.cb_hakAkses.getSelectedItem().toString()
                : context.petugas.getHakAkses();
        final var status = context.petugas.getStatus();

        if (namaLengkap.isBlank() || namaPengguna.isBlank()
                || noTelepon.isBlank()) {
            AlertDialog.showErrorDialog(Strings.ERROR_DIALOG_EMPTY_FIELD);
            return;
        }

        final var petugas = new Petugas();
        petugas.setId(id);
        petugas.setFoto(foto);
        petugas.setNamaPetugas(namaLengkap);
        petugas.setNamaPengguna(namaPengguna);
        petugas.setNoTelepon(noTelepon);
        petugas.setHakAkses(hakAkses);
        petugas.setStatus(status);
        petugas.setKataSandi(context.petugas.getKataSandi());

        try {
            if (petugas.getId() != null) {
                if (login(preferences.getLoggedInPetugas().getNamaPengguna(),
                        kataSandi)) {
                    remoteDataSource.updatePetugas(petugas);
                    Navigator.push(new ListPetugasPage(this, preferences));
                } else {
                    throw new NonexistentEntityException(
                            Strings.ERROR_DIALOG_WRONG_PASSWORD);
                }
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
    }

    @Override
    public void updatePassword(EditPetugasPasswordPage context) {
        final var id = context.petugas.getId();
        final var kataSandiLama = String.valueOf(context.et_kataSandiLama
                .getPassword());
        final var kataSandiBaru = String.valueOf(context.et_kataSandiBaru
                .getPassword());

        if (kataSandiBaru.isBlank() || kataSandiLama.isBlank()) {
            AlertDialog.showErrorDialog(Strings.ERROR_DIALOG_EMPTY_FIELD);
        }

        try {
            if (id != null) {
                if (!login(preferences.getLoggedInPetugas()
                        .getNamaPengguna(), kataSandiLama)) {
                    throw new Exception(Strings.ERROR_DIALOG_PASSWORD_NOT_MATCH);
                }
                remoteDataSource.updatePassword(id, kataSandiBaru);
                Navigator.push(new AddPetugasPage(this, preferences,
                        context.petugas));
            } else {
                throw new Exception(Strings.ERROR_DIALOG_ID_IS_NULL);
            }
        } catch (NonexistentEntityException | ServerException ex) {
            AlertDialog.showErrorDialog(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            AlertDialog.showErrorDialog(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        }
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
            final var resizedImage = Scalr.resize(ImageIO.read(result), height,
                    height);
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
