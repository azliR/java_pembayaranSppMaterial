package main;

import cores.connection.PersistenceManager;
import cores.styles.Fonts;
import features.auth.entities.PetugasJpaController;
import features.auth.repositories.AuthRepositoryImpl;
import features.student.entities.SiswaJpaController;
import features.student.repositories.SiswaRepositoryImpl;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author rizal
 */
public class Main {

    public static EntityManagerFactory entityManagerFactory;
    public static PetugasJpaController petugasJpaController;
    public static SiswaJpaController siswaJpaController;
    public static AuthRepositoryImpl authRepositoryImpl;
    public static SiswaRepositoryImpl siswaRepositoryImpl;

    public static void main(String[] args) {
        Fonts.registerFont(Main.class);

        entityManagerFactory = PersistenceManager.instance.getEntityManagerFactory();
        petugasJpaController = new PetugasJpaController(entityManagerFactory);
        siswaJpaController = new SiswaJpaController(entityManagerFactory);
        authRepositoryImpl = new AuthRepositoryImpl(petugasJpaController);
        siswaRepositoryImpl = new SiswaRepositoryImpl(siswaJpaController);

        new MainFrame(authRepositoryImpl, siswaRepositoryImpl).setVisible(true);
    }
}
