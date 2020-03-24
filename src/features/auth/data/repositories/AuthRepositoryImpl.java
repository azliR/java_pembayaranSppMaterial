package features.auth.data.repositories;

import cores.exceptions.NonexistentEntityException;
import cores.exceptions.ServerException;
import cores.provider.SharedPreferences;
import cores.styles.Strings;
import cores.utils.AlertDialog;
import features.auth.data.datasources.AuthRemoteDataSource;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rizal
 */
public class AuthRepositoryImpl implements AuthRepository {
    private static final Logger LOG = Logger.getLogger(AuthRepositoryImpl.class
            .getName());

    private final AuthRemoteDataSource remoteDataSource;
    private final SharedPreferences preferences;

    public AuthRepositoryImpl(AuthRemoteDataSource authRemoteDataSource,
            SharedPreferences preferences) {
        this.remoteDataSource = authRemoteDataSource;
        this.preferences = preferences;
    }

    @Override
    public boolean login(String namaPengguna, String kataSandi) {
        try {
            final var result = remoteDataSource.login(namaPengguna, kataSandi);
            if (result != null) {
                preferences.setLoggedInPetugas(result);
                updateStatus(Strings.DATABASE_SEDANG_AKTIF);
                return true;
            }
        } catch (NonexistentEntityException | ServerException ex) {
            AlertDialog.showErrorDialog(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void updateStatus(String status) {
        try {
            if (preferences.isLoggedIn()) {
                remoteDataSource.updateStatus(
                        preferences.getLoggedInPetugas().getId(), status);
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
