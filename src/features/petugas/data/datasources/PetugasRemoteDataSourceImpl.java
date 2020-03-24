package features.petugas.data.datasources;

import cores.entities.Petugas;
import cores.exceptions.IllegalOrphanException;
import cores.exceptions.NonexistentEntityException;
import cores.exceptions.ServerException;
import cores.provider.SharedPreferences;
import cores.styles.Strings;
import features.auth.data.datasources.AuthRemoteDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author rizal
 */
public class PetugasRemoteDataSourceImpl implements PetugasRemoteDataSource {
    private final EntityManagerFactory entityManagerFactory;
    private final AuthRemoteDataSource authRemoteDataSource;
    private final SharedPreferences preferences;

    public PetugasRemoteDataSourceImpl(EntityManagerFactory entityManagerFactory,
            AuthRemoteDataSource authRemoteDataSource,
            SharedPreferences preferences) {
        this.entityManagerFactory = entityManagerFactory;
        this.authRemoteDataSource = authRemoteDataSource;
        this.preferences = preferences;
    }

    @Override
    public Petugas login(String namaPengguna, String kataSandi) throws
            NonexistentEntityException, ServerException {
        return authRemoteDataSource.login(namaPengguna, kataSandi);
    }

    @Override
    public List<Petugas> getListPetugas(int maxResults, int firstResult)
            throws ServerException {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();

            final var criteriaQuery = entityManager.getCriteriaBuilder()
                    .createQuery(Petugas.class);
            criteriaQuery.select(criteriaQuery.from(Petugas.class));
            final var query = entityManager.createQuery(criteriaQuery);
            query.setMaxResults(maxResults);
            query.setFirstResult(firstResult);

            return query.getResultList();
        } catch (Exception ex) {
            throw new ServerException(Strings.ERROR_DIALOG_CONNECTION, ex);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public Petugas getPetugas(int id) throws ServerException {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            return entityManager.find(Petugas.class, id);
        } catch (Exception ex) {
            throw new ServerException(Strings.ERROR_DIALOG_CONNECTION, ex);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public void insertPetugas(Petugas petugas) throws ServerException {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(petugas);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            throw new ServerException(Strings.ERROR_DIALOG_CONNECTION, ex);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public void updatePetugas(Petugas petugas) throws
            NonexistentEntityException, ServerException {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(petugas);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = petugas.getId();
                if (getPetugas(id) == null) {
                    throw new NonexistentEntityException("Petugas dengan id "
                            + id + " tidak tersedia.");
                }
            }
            if (ex instanceof IllegalOrphanException) {
                throw ex;
            }
            throw new ServerException(Strings.ERROR_DIALOG_CONNECTION, ex);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public void updatePassword(int id, String kataSandi) throws
            NonexistentEntityException, ServerException {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            final var petugas = entityManager.find(Petugas.class, id);
            petugas.setKataSandi(kataSandi);

            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                if (getPetugas(id) == null) {
                    throw new NonexistentEntityException("Petugas dengan ID "
                            + id + " tidak tersedia.");
                }
            }
            throw new ServerException(Strings.ERROR_DIALOG_CONNECTION, ex);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public void deletePetugas(int id) throws IllegalOrphanException,
            NonexistentEntityException, ServerException {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Petugas petugas;
            try {
                petugas = entityManager.getReference(Petugas.class, id);
                petugas.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("Petugas dengan ID " + id
                        + " tidak tersedia.", enfe);
            }
            final var illegalOrphanIds = new ArrayList<Integer>();
            final var pembayaranListOrphanCheck = petugas.getPembayaranList();

            pembayaranListOrphanCheck.forEach(
                    (pembayaranListOrphanCheckPembayaran) -> {
                illegalOrphanIds
                        .add(pembayaranListOrphanCheckPembayaran.getId());
            });
            if (!illegalOrphanIds.isEmpty()) {
                throw new IllegalOrphanException("Petugas " + petugas
                        .getNamaPetugas()
                        + " tidak dapat dihapus karena data pembayaran dengan ID "
                        + illegalOrphanIds.toString()
                        + " masih tersedia. Silahkan hapus semua data pembayaran untuk siswa ini terlebih dahulu untuk melanjutkan.");
            }
            entityManager.remove(petugas);
            entityManager.getTransaction().commit();
        } catch (NonexistentEntityException | IllegalOrphanException ex) {
            if (ex instanceof NonexistentEntityException
                    || ex instanceof IllegalOrphanException) {
                throw ex;
            }
            throw new ServerException(Strings.ERROR_DIALOG_CONNECTION, ex);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

}
