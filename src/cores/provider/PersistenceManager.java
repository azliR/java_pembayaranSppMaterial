package cores.provider;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author rizal
 */
public enum PersistenceManager {
    instance;

    private final EntityManagerFactory entityManagerFactory;

    private PersistenceManager() {
        entityManagerFactory = Persistence
                .createEntityManagerFactory("pembayaran_sppPU");
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public void close() {
        entityManagerFactory.close();
    }
}
