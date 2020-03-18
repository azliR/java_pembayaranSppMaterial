package features.auth.data.repositories;

import cores.exceptions.NonexistentEntityException;
import cores.exceptions.ServerException;
import cores.styles.Strings;
import cores.utils.AlertDialog;
import cores.utils.Navigator;
import features.auth.data.datasources.AuthRemoteDataSource;
import features.home.pages.HomePage;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rizal
 */
public class AuthRepositoryImpl implements AuthRepository {
    private static final Logger LOG = Logger.getLogger(AuthRepositoryImpl.class
            .getName());

    final AuthRemoteDataSource remoteDataSource;
    int loggedInId = 0;

    public AuthRepositoryImpl(AuthRemoteDataSource authRemoteDataSource) {
        this.remoteDataSource = authRemoteDataSource;
    }

    @Override
    public void login(String namaPengguna, String kataSandi) {
        try {
            final var result = remoteDataSource.login(namaPengguna, kataSandi);

            if (result != null) {
                loggedInId = result.getId();
                updateStatus(Strings.DATABASE_SEDANG_AKTIF);
                Navigator.push(new HomePage(), true);
            } else {
                AlertDialog.showErrorDialog(Strings.ERROR_DIALOG_WRONG_PASSWORD);
            }
        } catch (NonexistentEntityException | ServerException ex) {
            AlertDialog.showErrorDialog(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateStatus(String status) {
        try {
            if (loggedInId != 0) {
                remoteDataSource.updateStatus(loggedInId, status);
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
