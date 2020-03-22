package features.auth.data.repositories;

import cores.exceptions.NonexistentEntityException;
import cores.exceptions.ServerException;
import cores.styles.Strings;
import cores.utils.AlertDialog;
import features.auth.data.datasources.AuthRemoteDataSource;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.MainFrame;

/**
 *
 * @author rizal
 */
public class AuthRepositoryImpl implements AuthRepository {
    private static final Logger LOG = Logger.getLogger(AuthRepositoryImpl.class
            .getName());

    final AuthRemoteDataSource remoteDataSource;

    public AuthRepositoryImpl(AuthRemoteDataSource authRemoteDataSource) {
        this.remoteDataSource = authRemoteDataSource;
    }

    @Override
    public boolean login(String namaPengguna, String kataSandi) {
        try {
            final var result = remoteDataSource.login(namaPengguna, kataSandi);

            if (result != null) {
                MainFrame.loggedInPetugas = result;
                updateStatus(Strings.DATABASE_SEDANG_AKTIF);
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
    public void updateStatus(String status) {
        try {
            if (MainFrame.loggedInPetugas != null) {
                remoteDataSource.updateStatus(
                        MainFrame.loggedInPetugas.getId(), status);
            } else {
                AlertDialog
                        .showErrorDialog(Strings.ERROR_DIALOG_DEFAULT_MESSAGE);
            }
        } catch (NonexistentEntityException | ServerException ex) {
            AlertDialog.showErrorDialog(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        }
    }
}
