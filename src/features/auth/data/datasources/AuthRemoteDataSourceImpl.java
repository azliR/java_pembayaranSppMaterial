package features.auth.data.datasources;

import cores.exceptions.ServerException;
import cores.styles.Strings;
import features.auth.data.entities.Petugas;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author rizal
 */
public class AuthRemoteDataSourceImpl implements AuthRemoteDataSource {
    final EntityManagerFactory entityManagerFactory;

    public AuthRemoteDataSourceImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public Petugas login(String namaPengguna, String kataSandi) throws
            ServerException {
        final var entityManager = entityManagerFactory.createEntityManager();
        try {
            final var criteriaBuilder = entityManager.getCriteriaBuilder();
            final var criteriaQuery = criteriaBuilder.createQuery(Petugas.class);
            final var root = criteriaQuery.from(Petugas.class);
            criteriaQuery.select(root);
            criteriaQuery.where(criteriaBuilder.equal(root.get("namaPengguna"),
                    namaPengguna));
            criteriaQuery.where(criteriaBuilder.equal(root.get("kataSandi"),
                    kataSandi));
            TypedQuery<Petugas> q = entityManager.createQuery(criteriaQuery);

            if (q.getResultList().size() <= 0) {
                return null;
            }
            return q.getSingleResult();
        } catch (Exception ex) {
            throw new ServerException(Strings.ERROR_DIALOG_CONNECTION_MESSAGE,
                    ex);
        } finally {
            entityManager.close();
        }
    }
}
