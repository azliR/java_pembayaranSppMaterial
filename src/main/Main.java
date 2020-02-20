package main;

import cores.connection.PersistenceManager;
import cores.styles.Fonts;
import features.auth.data.datasources.AuthRemoteDataSource;
import features.auth.data.datasources.AuthRemoteDataSourceImpl;
import features.auth.data.repositories.AuthRepository;
import features.auth.data.repositories.AuthRepositoryImpl;
import features.siswa.data.datasources.SiswaLocalDataSource;
import features.siswa.data.datasources.SiswaLocalDataSourceImpl;
import features.siswa.data.datasources.SiswaRemoteDataSource;
import features.siswa.data.datasources.SiswaRemoteDataSourceImpl;
import features.siswa.data.repositories.SiswaRepository;
import features.siswa.data.repositories.SiswaRepositoryImpl;
import javax.persistence.EntityManagerFactory;
import javax.swing.UIManager;

/**
 *
 * @author rizal
 */
public class Main {
    public static EntityManagerFactory entityManagerFactory;

    public static AuthRemoteDataSource authRemoteDataSource;
    public static SiswaLocalDataSource siswaLocalDataSource;
    public static SiswaRemoteDataSource siswaRemoteDataSource;

    public static AuthRepository authRepository;
    public static SiswaRepository siswaRepository;

    public static void main(String[] args) {
        Fonts.registerFont(Main.class);

        entityManagerFactory = PersistenceManager.instance
                .getEntityManagerFactory();

        authRemoteDataSource
                = new AuthRemoteDataSourceImpl(entityManagerFactory);
        siswaLocalDataSource = new SiswaLocalDataSourceImpl();
        siswaRemoteDataSource = new SiswaRemoteDataSourceImpl(
                entityManagerFactory);

        authRepository = new AuthRepositoryImpl(authRemoteDataSource);
        siswaRepository = new SiswaRepositoryImpl(siswaRemoteDataSource,
                siswaLocalDataSource);

        new MainFrame(authRepository, siswaRepository).setVisible(true);

        try {
            for (UIManager.LookAndFeelInfo info : UIManager
                    .getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException
                | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        }
    }
}
