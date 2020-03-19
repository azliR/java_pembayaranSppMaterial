package features.petugas.data.repositories;

import cores.entities.Petugas;
import cores.exceptions.IllegalOrphanException;
import cores.exceptions.NonexistentEntityException;
import cores.exceptions.ServerException;
import cores.styles.Strings;
import cores.utils.AlertDialog;
import cores.utils.Navigator;
import features.petugas.data.datasources.PetugasRemoteDataSource;
import features.petugas.presentation.pages.AddPetugasPage;
import features.petugas.presentation.pages.ListPetugasPage;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rizal
 */
public class PetugasRepositoryImpl implements PetugasRepository {
    private static final Logger LOG = Logger.getLogger(
            PetugasRepositoryImpl.class.getName());

    private final PetugasRemoteDataSource remoteDataSource;

    public PetugasRepositoryImpl(PetugasRemoteDataSource petugasRemoteDataSource) {
        this.remoteDataSource = petugasRemoteDataSource;
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
    public void insertOrUpdatePetugas(AddPetugasPage context) {
        final var id = context.petugas == null ? null : context.petugas.getId();
        final var namaLengkap = context.et_namaPetugas.getText();
        final var namaPengguna = context.et_namaPengguna.getText();
        final var kataSandi = context.et_kataSandi.getText();
        final var konfirmasiKataSandi = context.et_konfirmasiKataSandi.getText();
        final var hakAkses = context.cb_jenisKelamin.getSelectedItem().toString();

        if (namaLengkap.isBlank() || namaPengguna.isBlank()
                || kataSandi.isBlank() || konfirmasiKataSandi.isBlank()) {
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

        try {
            final var petugas = new Petugas();
            petugas.setId(id);
            petugas.setNamaPetugas(namaLengkap);
            petugas.setNamaPengguna(namaPengguna);
            petugas.setKataSandi(kataSandi);
            petugas.setHakAkses(hakAkses);
            petugas.setStatus(Strings.DATABASE_TIDAK_AKTIF);

            if (context.petugas == null) {
                remoteDataSource.insertPetugas(petugas);

                clear(context);
                AlertDialog.showDialog(Strings.SUCCESS_DIALOG_DEFAULT,
                        Strings.SUCCESS_DIALOG_INSERT);
            } else {
                remoteDataSource.updatePetugas(petugas);
                Navigator.push(new ListPetugasPage(this));
            }
        } catch (ServerException | IllegalOrphanException
                | NonexistentEntityException ex) {
            AlertDialog.showErrorDialog(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deletePetugas(int id) {
        try {
            remoteDataSource.deletePetugas(id);
        } catch (IllegalOrphanException | NonexistentEntityException
                | ServerException ex) {
            AlertDialog.showErrorDialog(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void clear(AddPetugasPage context) {
        context.et_namaPetugas.setText(null);
        context.et_namaPengguna.setText(null);
        context.et_kataSandi.setText(null);
        context.et_konfirmasiKataSandi.setText(null);
    }

}
