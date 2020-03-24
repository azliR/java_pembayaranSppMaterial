package main;

import cores.provider.PersistenceManager;
import cores.provider.SharedPreferences;
import cores.styles.Fonts;
import features.auth.data.datasources.AuthRemoteDataSource;
import features.auth.data.datasources.AuthRemoteDataSourceImpl;
import features.auth.data.repositories.AuthRepository;
import features.auth.data.repositories.AuthRepositoryImpl;
import features.petugas.data.datasources.PetugasLocalDataSource;
import features.petugas.data.datasources.PetugasLocalDataSourceImpl;
import features.petugas.data.datasources.PetugasRemoteDataSource;
import features.petugas.data.datasources.PetugasRemoteDataSourceImpl;
import features.petugas.data.repositories.PetugasRepository;
import features.petugas.data.repositories.PetugasRepositoryImpl;
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
    private static EntityManagerFactory entityManagerFactory;

    private static SharedPreferences preferences;

    private static AuthRemoteDataSource authRemoteDataSource;
    private static SiswaLocalDataSource siswaLocalDataSource;
    private static SiswaRemoteDataSource siswaRemoteDataSource;
    private static PetugasRemoteDataSource petugasRemoteDataSource;
    private static PetugasLocalDataSource petugasLocalDataSource;

    private static AuthRepository authRepository;
    private static SiswaRepository siswaRepository;
    private static PetugasRepository petugasRepository;

    public static void main(String[] args) {
        Fonts.registerAllFont(Main.class);
        entityManagerFactory = PersistenceManager.instance
                .getEntityManagerFactory();

        preferences = new SharedPreferences();

        authRemoteDataSource = new AuthRemoteDataSourceImpl(
                entityManagerFactory);
        siswaLocalDataSource = new SiswaLocalDataSourceImpl();
        siswaRemoteDataSource = new SiswaRemoteDataSourceImpl(
                entityManagerFactory);
        petugasRemoteDataSource = new PetugasRemoteDataSourceImpl(
                entityManagerFactory, authRemoteDataSource, preferences);
        petugasLocalDataSource = new PetugasLocalDataSourceImpl();

        authRepository = new AuthRepositoryImpl(authRemoteDataSource,
                preferences);
        siswaRepository = new SiswaRepositoryImpl(siswaRemoteDataSource,
                siswaLocalDataSource);
        petugasRepository = new PetugasRepositoryImpl(petugasRemoteDataSource,
                petugasLocalDataSource, preferences);

        new MainFrame(authRepository, siswaRepository, petugasRepository,
                preferences).setVisible(true);

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
