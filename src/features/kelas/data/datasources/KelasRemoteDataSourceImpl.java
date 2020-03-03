package features.kelas.data.datasources;

import cores.entities.Kelas;
import cores.exceptions.ServerException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author rizal
 */
public class KelasRemoteDataSourceImpl implements KelasRemoteDataSource {
    final EntityManagerFactory entityManagerFactory;

    public KelasRemoteDataSourceImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public List<Kelas> getListKelas(int maxResults, int firstResult) throws
            ServerException {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            final var criteriaBuilder = entityManager.getCriteriaBuilder();
            final var criteriaQuery = criteriaBuilder.createQuery(Kelas.class);
            criteriaQuery.select(criteriaQuery.from(Kelas.class));

            final var typedQuery = entityManager.createQuery(criteriaQuery);
            typedQuery.setMaxResults(maxResults);
            typedQuery.setFirstResult(firstResult);

            return typedQuery.getResultList();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
}
