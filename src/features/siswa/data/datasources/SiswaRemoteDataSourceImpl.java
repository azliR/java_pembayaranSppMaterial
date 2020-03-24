package features.siswa.data.datasources;

import cores.entities.Kelas;
import cores.entities.Kelas_;
import cores.entities.Siswa;
import static cores.entities.Siswa_.*;
import cores.entities.Spp;
import cores.entities.Spp_;
import cores.exceptions.IllegalOrphanException;
import cores.exceptions.NonexistentEntityException;
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

    private List<Siswa> getListSiswa(String namaKeyword,
            String jenisKelaminKeyword, int maxResults, int firstResult) throws
            ServerException {
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

            if (namaKeyword != null && jenisKelaminKeyword != null) {
                criteriaQuery.where(
                        criteriaBuilder.like(
                                root.get(nama).as(String.class), "%"
                                + namaKeyword + "%"),
                        criteriaBuilder.equal(root.get(jenisKelamin),
                                jenisKelaminKeyword));
            } else if (namaKeyword != null) {
                criteriaQuery.where(
                        criteriaBuilder.like(root.get(nama).as(String.class),
                                "%" + namaKeyword + "%"));
            } else if (jenisKelaminKeyword != null) {
                criteriaQuery.where(criteriaBuilder
                        .equal(root.get(jenisKelamin), jenisKelaminKeyword));
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
        return getListSiswa(null, null, maxResults, firstResult);
    }

    @Override
    public List<Siswa> getListSiswaByKeywordWithoutThumbnail(String keyword,
            String jenisKelamin, int maxResults, int firstResult) throws
            ServerException {
        return getListSiswa(keyword, jenisKelamin, maxResults, firstResult);
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
    public void insertSiswa(Siswa siswa) throws ServerException {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(siswa);
            entityManager.getTransaction().commit();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public void updateSiswa(Siswa siswa) throws NonexistentEntityException,
            ServerException {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(siswa);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            final var msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                final var id = siswa.getId();
                if (getSiswa(id) == null) {
                    throw new NonexistentEntityException("Siswa dengan ID "
                            + id + " tidak tersedia.");
                }
            }
            throw ex;
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public void deleteSiswa(int id) throws IllegalOrphanException,
            NonexistentEntityException, ServerException {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Siswa siswa;
            try {
                siswa = entityManager.getReference(Siswa.class, id);
                siswa.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("Siswa dengan ID " + id
                        + " tidak tersedia.", enfe);
            }
            final var illegalOrphanIds = new ArrayList<Integer>();
            final var pembayaranListOrphanCheck = siswa.getPembayaranList();
            pembayaranListOrphanCheck.forEach((
                    pembayaranListOrphanCheckPembayaran) -> {
                illegalOrphanIds
                        .add(pembayaranListOrphanCheckPembayaran.getId());
            });
            if (!illegalOrphanIds.isEmpty()) {
                throw new IllegalOrphanException("Siswa " + siswa.getNama()
                        + " tidak dapat dihapus karena data pembayaran dengan ID "
                        + illegalOrphanIds.toString()
                        + " masih tersedia. Silahkan hapus semua data pembayaran untuk siswa ini terlebih dahulu untuk melanjutkan.");
            }
            entityManager.remove(siswa);
            entityManager.getTransaction().commit();
        } catch (IllegalOrphanException | NonexistentEntityException ex) {
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
