package main;

import cores.connection.PersistenceManager;
import cores.styles.Fonts;
import features.auth.data.datasources.AuthRemoteDataSource;
import features.auth.data.datasources.AuthRemoteDataSourceImpl;
import features.auth.data.repositories.AuthRepository;
import features.auth.data.repositories.AuthRepositoryImpl;
import features.student.data.datasources.SiswaLocalDataSource;
import features.student.data.datasources.SiswaLocalDataSourceImpl;
import features.student.data.datasources.SiswaRemoteDataSource;
import features.student.data.datasources.SiswaRemoteDataSourceImpl;
import features.student.data.repositories.SiswaRepository;
import features.student.data.repositories.SiswaRepositoryImpl;
import javax.persistence.EntityManagerFactory;

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
    }
}
