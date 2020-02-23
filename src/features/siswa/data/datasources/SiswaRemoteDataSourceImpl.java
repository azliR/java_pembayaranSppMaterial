package features.siswa.data.datasources;

import cores.entities.Kelas;
import cores.entities.Kelas_;
import cores.entities.Pembayaran;
import cores.entities.Siswa;
import static cores.entities.Siswa_.*;
import cores.entities.Spp;
import cores.entities.Spp_;
import cores.exceptions.IllegalOrphanException;
import cores.exceptions.NonexistentEntityException;
import cores.exceptions.PreexistingEntityException;
import cores.exceptions.ServerException;
import cores.styles.Strings;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author rizal
 */
public class SiswaRemoteDataSourceImpl implements SiswaRemoteDataSource {
    final EntityManagerFactory entityManagerFactory;

    public SiswaRemoteDataSourceImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    private List<Siswa> getListSiswa(char keyword, int maxResults,
            int firstResult) throws ServerException {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            final var listSiswa = new ArrayList<Siswa>();
            final var criteriaBuilder = entityManager.getCriteriaBuilder();
            final var criteriaQuery = criteriaBuilder.createTupleQuery();
            final var root = criteriaQuery.from(Siswa.class);
            if (firstResult == 0) {
                criteriaQuery.multiselect(
                        root.get(id).alias(id.getName()),
                        root.get(nisn).alias(nisn.getName()),
                        root.get(nama).alias(nama.getName()),
                        root.get(foto).alias(foto.getName()),
                        root.get(sppBulanIni).alias(sppBulanIni.getName()));
            } else {
                criteriaQuery.multiselect(
                        root.get(id).alias(id.getName()),
                        root.get(nisn).alias(nisn.getName()),
                        root.get(nama).alias(nama.getName()),
                        root.get(sppBulanIni).alias(sppBulanIni.getName()));
            }
            criteriaQuery.orderBy(criteriaBuilder.asc(root.get(nama)));
            if (keyword != '0') {
                criteriaQuery.where(criteriaBuilder
                        .equal(root.get(jenisKelamin), keyword));
            }

            final var query = entityManager.createQuery(criteriaQuery);
            query.setMaxResults(maxResults);
            query.setFirstResult(firstResult);
            query.getResultList().forEach((tuple) -> {
                final var siswa = new Siswa();
                siswa.setId(tuple.get(id.getName(), Integer.class));
                siswa.setNama(tuple.get(nama.getName(), String.class));
                siswa.setNisn(tuple.get(nisn.getName(), String.class));
                siswa.setSppBulanIni(tuple.get(sppBulanIni.getName(),
                        String.class));
                if (firstResult == 0) {
                    siswa.setFoto(tuple.get(foto.getName(), byte[].class));
                }
                listSiswa.add(siswa);
            });
            return listSiswa;
        } catch (Exception ex) {
            throw new ServerException(Strings.ERROR_DIALOG_CONNECTION,
                    ex);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public List<Siswa> getListSiswaWithoutThumbnail(int maxResults,
            int firstResult) throws ServerException {
        return getListSiswa('0', maxResults, firstResult);
    }

    @Override
    public List<Siswa> getListSiswaByJenisKelaminWithoutThumbnail(char keyword,
            int maxResults, int firstResult) throws ServerException {
        return getListSiswa(keyword, maxResults, firstResult);
    }

    @Override
    public byte[] getSiswaThumbnail(int idValue) throws ServerException {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            final var criteriaBuilder = entityManager.getCriteriaBuilder();
            final var criteriaQuery = criteriaBuilder.createTupleQuery();
            final var root = criteriaQuery.from(Siswa.class);
            criteriaQuery.multiselect(root.get(foto).alias(foto.getName()));
            criteriaQuery.where(criteriaBuilder.equal(root.get(id), idValue));

            final var query = entityManager.createQuery(criteriaQuery);
            return query.getSingleResult().get(foto.getName(), byte[].class);
        } catch (Exception ex) {
            throw new ServerException(Strings.ERROR_DIALOG_CONNECTION, ex);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public Siswa getSiswa(int id) throws ServerException {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            return entityManager.find(Siswa.class, id);
        } catch (Exception ex) {
            throw new ServerException(Strings.ERROR_DIALOG_CONNECTION, ex);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public List<Kelas> getListKelas() throws ServerException {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            final var criteriaBuilder = entityManager.getCriteriaBuilder();
            final var criteriaQuery = criteriaBuilder.createQuery(Kelas.class);
            final var root = criteriaQuery.from(Kelas.class);
            criteriaQuery.select(root);
            criteriaQuery.orderBy(criteriaBuilder.asc(root.get(Kelas_.kelas)));

            final var query = entityManager.createQuery(criteriaQuery);
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
    public List<Spp> getListSpp() throws ServerException {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            final var criteriaBuilder = entityManager.getCriteriaBuilder();
            final var criteriaQuery = criteriaBuilder.createQuery(Spp.class);
            final var root = criteriaQuery.from(Spp.class);
            criteriaQuery.select(root);
            criteriaQuery.orderBy(criteriaBuilder.desc(root.get(Spp_.tahun)));

            final var query = entityManager.createQuery(criteriaQuery);
            return query.getResultList();
        } catch (Exception ex) {
            throw new ServerException(Strings.ERROR_DIALOG_CONNECTION,
                    ex);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public void insertSiswa(Siswa siswa) throws PreexistingEntityException,
            ServerException {
        if (siswa.getPembayaranList() == null) {
            siswa.setPembayaranList(new ArrayList<>());
        }
        EntityManager em = null;
        try {
            em = entityManagerFactory.createEntityManager();
            em.getTransaction().begin();
            Kelas idKelas = siswa.getIdKelas();
            if (idKelas != null) {
                idKelas = em.getReference(idKelas.getClass(), idKelas.getId());
                siswa.setIdKelas(idKelas);
            }
            Spp idSpp = siswa.getIdSpp();
            if (idSpp != null) {
                idSpp = em.getReference(idSpp.getClass(), idSpp.getId());
                siswa.setIdSpp(idSpp);
            }
            List<Pembayaran> attachedPembayaranList
                    = new ArrayList<Pembayaran>();
            for (Pembayaran pembayaranListPembayaranToAttach : siswa
                    .getPembayaranList()) {
                pembayaranListPembayaranToAttach
                        = em.getReference(pembayaranListPembayaranToAttach
                                .getClass(),
                                pembayaranListPembayaranToAttach.getId());
                attachedPembayaranList.add(pembayaranListPembayaranToAttach);
            }
            siswa.setPembayaranList(attachedPembayaranList);
            em.persist(siswa);
            if (idKelas != null) {
                idKelas.getSiswaList().add(siswa);
                idKelas = em.merge(idKelas);
            }
            if (idSpp != null) {
                idSpp.getSiswaList().add(siswa);
                idSpp = em.merge(idSpp);
            }
            for (Pembayaran pembayaranListPembayaran : siswa.getPembayaranList()) {
                Siswa oldIdSiswaOfPembayaranListPembayaran
                        = pembayaranListPembayaran.getIdSiswa();
                pembayaranListPembayaran.setIdSiswa(siswa);
                pembayaranListPembayaran = em.merge(pembayaranListPembayaran);
                if (oldIdSiswaOfPembayaranListPembayaran != null) {
                    oldIdSiswaOfPembayaranListPembayaran.getPembayaranList()
                            .remove(pembayaranListPembayaran);
                    oldIdSiswaOfPembayaranListPembayaran
                            = em.merge(oldIdSiswaOfPembayaranListPembayaran);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void updateSiswa(Siswa siswa) throws IllegalOrphanException,
            NonexistentEntityException, ServerException {
        if (siswa.getPembayaranList() == null) {
            siswa.setPembayaranList(new ArrayList<>());
        }
        EntityManager em = null;
        try {
            em = entityManagerFactory.createEntityManager();
            em.getTransaction().begin();
            Siswa persistentSiswa = em.find(Siswa.class, siswa.getId());
            Kelas idKelasOld = persistentSiswa.getIdKelas();
            Kelas idKelasNew = siswa.getIdKelas();
            Spp idSppOld = persistentSiswa.getIdSpp();
            Spp idSppNew = siswa.getIdSpp();
            List<Pembayaran> pembayaranListOld
                    = persistentSiswa.getPembayaranList();
            List<Pembayaran> pembayaranListNew = siswa.getPembayaranList();
            List<String> illegalOrphanMessages = null;
            for (Pembayaran pembayaranListOldPembayaran : pembayaranListOld) {
                if (!pembayaranListNew.contains(pembayaranListOldPembayaran)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Pembayaran "
                            + pembayaranListOldPembayaran
                            + " since its idSiswa field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idKelasNew != null) {
                idKelasNew
                        = em.getReference(idKelasNew.getClass(),
                                idKelasNew.getId());
                siswa.setIdKelas(idKelasNew);
            }
            if (idSppNew != null) {
                idSppNew
                        = em.getReference(idSppNew.getClass(), idSppNew.getId());
                siswa.setIdSpp(idSppNew);
            }
            List<Pembayaran> attachedPembayaranListNew
                    = new ArrayList<Pembayaran>();
            for (Pembayaran pembayaranListNewPembayaranToAttach
                    : pembayaranListNew) {
                pembayaranListNewPembayaranToAttach
                        = em.getReference(pembayaranListNewPembayaranToAttach
                                .getClass(),
                                pembayaranListNewPembayaranToAttach.getId());
                attachedPembayaranListNew.add(
                        pembayaranListNewPembayaranToAttach);
            }
            pembayaranListNew = attachedPembayaranListNew;
            siswa.setPembayaranList(pembayaranListNew);
            siswa = em.merge(siswa);
            if (idKelasOld != null && !idKelasOld.equals(idKelasNew)) {
                idKelasOld.getSiswaList().remove(siswa);
                idKelasOld = em.merge(idKelasOld);
            }
            if (idKelasNew != null && !idKelasNew.equals(idKelasOld)) {
                idKelasNew.getSiswaList().add(siswa);
                idKelasNew = em.merge(idKelasNew);
            }
            if (idSppOld != null && !idSppOld.equals(idSppNew)) {
                idSppOld.getSiswaList().remove(siswa);
                idSppOld = em.merge(idSppOld);
            }
            if (idSppNew != null && !idSppNew.equals(idSppOld)) {
                idSppNew.getSiswaList().add(siswa);
                idSppNew = em.merge(idSppNew);
            }
            for (Pembayaran pembayaranListNewPembayaran : pembayaranListNew) {
                if (!pembayaranListOld.contains(pembayaranListNewPembayaran)) {
                    Siswa oldIdSiswaOfPembayaranListNewPembayaran
                            = pembayaranListNewPembayaran.getIdSiswa();
                    pembayaranListNewPembayaran.setIdSiswa(siswa);
                    pembayaranListNewPembayaran
                            = em.merge(pembayaranListNewPembayaran);
                    if (oldIdSiswaOfPembayaranListNewPembayaran != null
                            && !oldIdSiswaOfPembayaranListNewPembayaran.equals(
                                    siswa)) {
                        oldIdSiswaOfPembayaranListNewPembayaran
                                .getPembayaranList()
                                .remove(pembayaranListNewPembayaran);
                        oldIdSiswaOfPembayaranListNewPembayaran
                                = em.merge(
                                        oldIdSiswaOfPembayaranListNewPembayaran);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = siswa.getId();
                if (getSiswa(id) == null) {
                    throw new NonexistentEntityException("The siswa with id "
                            + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void deleteSiswa(int id) throws IllegalOrphanException,
            NonexistentEntityException {
        EntityManager em = null;
        try {
            em = entityManagerFactory.createEntityManager();
            em.getTransaction().begin();
            Siswa siswa;
            try {
                siswa = em.getReference(Siswa.class, id);
                siswa.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The siswa with id " + id
                        + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Pembayaran> pembayaranListOrphanCheck
                    = siswa.getPembayaranList();
            for (Pembayaran pembayaranListOrphanCheckPembayaran
                    : pembayaranListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Siswa (" + siswa
                        + ") cannot be destroyed since the Pembayaran "
                        + pembayaranListOrphanCheckPembayaran
                        + " in its pembayaranList field has a non-nullable idSiswa field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Kelas idKelas = siswa.getIdKelas();
            if (idKelas != null) {
                idKelas.getSiswaList().remove(siswa);
                idKelas = em.merge(idKelas);
            }
            Spp idSpp = siswa.getIdSpp();
            if (idSpp != null) {
                idSpp.getSiswaList().remove(siswa);
                idSpp = em.merge(idSpp);
            }
            em.remove(siswa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
