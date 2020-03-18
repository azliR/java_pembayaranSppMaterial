package features.auth.data.datasources;

import cores.entities.Petugas;
import cores.exceptions.NonexistentEntityException;
import cores.exceptions.ServerException;
import cores.styles.Strings;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;

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
            NonexistentEntityException, ServerException {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            final var storedProcedureQuery = entityManager
                    .createStoredProcedureQuery("login", Petugas.class);
            storedProcedureQuery.registerStoredProcedureParameter(1,
                    String.class, ParameterMode.IN);
            storedProcedureQuery.registerStoredProcedureParameter(2,
                    String.class, ParameterMode.IN);
            storedProcedureQuery.registerStoredProcedureParameter(3,
                    Integer.class, ParameterMode.OUT);
            storedProcedureQuery.setParameter(1, namaPengguna);
            storedProcedureQuery.setParameter(2, kataSandi);
            storedProcedureQuery.execute();

            final var id = Integer.parseUnsignedInt(storedProcedureQuery
                    .getOutputParameterValue(3).toString());
            if (id <= 0) {
                return null;
            }
            updateStatus(id, Strings.DATABASE_SEDANG_AKTIF);

            return entityManager.find(Petugas.class, id);
        } catch (NumberFormatException ex) {
            throw new ServerException(Strings.ERROR_DIALOG_CONNECTION, ex);
        } catch (NonexistentEntityException ex) {
            throw ex;
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public void updateStatus(int id, String status) throws
            NonexistentEntityException,
            ServerException {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            var petugas = entityManager.find(Petugas.class, id);
            petugas.setStatus(status);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            final var message = ex.getLocalizedMessage();
            if (entityManager != null
                    && (message == null || message.length() == 0)) {
                if (entityManager.find(Petugas.class, id) == null) {
                    throw new NonexistentEntityException(
                            "The petugas with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
}
