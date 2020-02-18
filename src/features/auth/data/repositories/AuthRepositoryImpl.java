package features.auth.data.repositories;

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
    private static final Logger LOG
            = Logger.getLogger(AuthRepositoryImpl.class.getName());

    final AuthRemoteDataSource authRemoteDataSource;

    public AuthRepositoryImpl(AuthRemoteDataSource authRemoteDataSource) {
        this.authRemoteDataSource = authRemoteDataSource;
    }

    @Override
    public void login(String namaPengguna, String kataSandi) {
        try {
            final var result = authRemoteDataSource.login(namaPengguna, kataSandi);

            if (result != null) {
                Navigator.push(new HomePage(), true);
            } else {
                AlertDialog.showErrorDialog(Strings.ERROR_DIALOG_WRONG_PASSWORD);
            }
        } catch (ServerException ex) {
            AlertDialog.showErrorDialog(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        }
    }
}
