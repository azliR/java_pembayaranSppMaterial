package features.student.data.datasources;

import cores.exceptions.PreexistingEntityException;
import cores.exceptions.ServerException;
import cores.styles.Strings;
import features.student.data.entities.Siswa;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author rizal
 */
public class SiswaRemoteDataSourceImpl implements SiswaRemoteDataSource {
    final EntityManagerFactory entityManagerFactory;

    public SiswaRemoteDataSourceImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public List<Siswa> getListSiswaWithoutThumbnail(int maxResults,
            int firstResult) throws ServerException {
        final var entityManager = entityManagerFactory.createEntityManager();
        try {
            final var criteriaQuery = entityManager.getCriteriaBuilder()
                    .createQuery(Siswa.class);
            criteriaQuery.select(criteriaQuery.from(Siswa.class));

            final var query = entityManager.createQuery(criteriaQuery);
            query.setMaxResults(maxResults);
            query.setFirstResult(firstResult);
            return query.getResultList();
        } catch (Exception ex) {
            throw new ServerException(Strings.ERROR_DIALOG_CONNECTION_MESSAGE,
                    ex);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void insertSiswa(Siswa siswa) throws PreexistingEntityException,
            ServerException {
        final var entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(siswa);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            if (entityManager.find(siswa.getClass(), siswa.getNisn()) != null) {
                throw new PreexistingEntityException(
                        Strings.ERROR_DIALOG_EXISTING_NISN_MESSAGE, ex);
            }
            throw new ServerException(Strings.ERROR_DIALOG_CONNECTION_MESSAGE,
                    ex);
        } finally {
            entityManager.close();
        }
    }
}
