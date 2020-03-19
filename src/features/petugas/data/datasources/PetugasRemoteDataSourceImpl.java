package features.petugas.data.datasources;

import cores.entities.Pembayaran;
import cores.entities.Petugas;
import cores.exceptions.IllegalOrphanException;
import cores.exceptions.NonexistentEntityException;
import cores.exceptions.ServerException;
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
    final EntityManagerFactory entityManagerFactory;
    final AuthRemoteDataSource authRemoteDataSource;

    public PetugasRemoteDataSourceImpl(EntityManagerFactory entityManagerFactory,
            AuthRemoteDataSource authRemoteDataSource) {
        this.entityManagerFactory = entityManagerFactory;
        this.authRemoteDataSource = authRemoteDataSource;
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
        if (petugas.getPembayaranList() == null) {
            petugas.setPembayaranList(new ArrayList<>());
        }
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            final var attachedPembayaranList = new ArrayList<Pembayaran>();

            for (final var pembayaran : petugas.getPembayaranList()) {
                var pembayaranListPembayaranToAttach = pembayaran;

                pembayaranListPembayaranToAttach
                        = entityManager.getReference(
                                pembayaranListPembayaranToAttach.getClass(),
                                pembayaranListPembayaranToAttach.getId());
                attachedPembayaranList.add(pembayaranListPembayaranToAttach);
            }
            petugas.setPembayaranList(attachedPembayaranList);
            entityManager.persist(petugas);

            for (final var pembayaran : petugas.getPembayaranList()) {
                var pembayaranListPembayaran = pembayaran;
                var oldIdPetugasOfPembayaranListPembayaran
                        = pembayaranListPembayaran.getIdPetugas();

                pembayaranListPembayaran.setIdPetugas(petugas);
                pembayaranListPembayaran = entityManager.merge(
                        pembayaranListPembayaran);

                if (oldIdPetugasOfPembayaranListPembayaran != null) {
                    oldIdPetugasOfPembayaranListPembayaran.getPembayaranList()
                            .remove(pembayaranListPembayaran);
                    oldIdPetugasOfPembayaranListPembayaran
                            = entityManager.merge(
                                    oldIdPetugasOfPembayaranListPembayaran);
                }
            }
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
    public void updatePetugas(Petugas petugasValue) throws
            IllegalOrphanException, NonexistentEntityException, ServerException {
        EntityManager entityManager = null;
        var petugas = petugasValue;
        final var result = authRemoteDataSource.login(petugas.getNamaPengguna(),
                petugas.getKataSandi());
        if (result == null) {
            throw new NonexistentEntityException(
                    Strings.ERROR_DIALOG_WRONG_PASSWORD);
        }
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            final var illegalOrphanMessages = new ArrayList<String>();
            final var persistentPetugas
                    = entityManager.find(Petugas.class, petugas.getId());
            final var pembayaranListOld
                    = persistentPetugas.getPembayaranList();
            var pembayaranListNew = petugas.getPembayaranList();

            for (Pembayaran pembayaranListOldPembayaran : pembayaranListOld) {
                if (!pembayaranListNew.contains(pembayaranListOldPembayaran)) {
                    illegalOrphanMessages.add("You must retain Pembayaran "
                            + pembayaranListOldPembayaran
                            + " since its idPetugas field is not nullable.");
                }
            }
            if (!illegalOrphanMessages.isEmpty()) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }

            final var attachedPembayaranListNew = new ArrayList<Pembayaran>();
            for (final var pembayaran : pembayaranListNew) {
                final var pembayaranListNewPembayaranToAttach
                        = entityManager.getReference(
                                pembayaran.getClass(),
                                pembayaran.getId());
                attachedPembayaranListNew.add(
                        pembayaranListNewPembayaranToAttach);
            }
            pembayaranListNew = attachedPembayaranListNew;
            petugas.setPembayaranList(pembayaranListNew);
            petugas = entityManager.merge(petugas);

            for (final var pembayaran : pembayaranListNew) {
                var pembayaranListNewPembayaran = pembayaran;
                if (!pembayaranListOld.contains(pembayaranListNewPembayaran)) {
                    var oldIdPetugasOfPembayaranListNewPembayaran
                            = pembayaranListNewPembayaran.getIdPetugas();
                    pembayaranListNewPembayaran.setIdPetugas(petugas);
                    pembayaranListNewPembayaran = entityManager.merge(
                            pembayaranListNewPembayaran);
                    if (oldIdPetugasOfPembayaranListNewPembayaran != null
                            && !oldIdPetugasOfPembayaranListNewPembayaran
                                    .equals(petugas)) {
                        oldIdPetugasOfPembayaranListNewPembayaran
                                .getPembayaranList()
                                .remove(pembayaranListNewPembayaran);
                        oldIdPetugasOfPembayaranListNewPembayaran
                                = entityManager.merge(
                                        oldIdPetugasOfPembayaranListNewPembayaran);
                    }
                }
            }
            entityManager.getTransaction().commit();
        } catch (IllegalOrphanException ex) {
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
            final var illegalOrphanMessages = new ArrayList<String>();
            final var pembayaranListOrphanCheck = petugas.getPembayaranList();

            pembayaranListOrphanCheck.forEach(
                    (pembayaranListOrphanCheckPembayaran) -> {
                illegalOrphanMessages.add("This Petugas (" + petugas
                        + ") cannot be destroyed since the Pembayaran "
                        + pembayaranListOrphanCheckPembayaran
                        + " in its pembayaranList field has a non-nullable idPetugas field.");
            });
            if (!illegalOrphanMessages.isEmpty()) {
                throw new IllegalOrphanException(illegalOrphanMessages);
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
