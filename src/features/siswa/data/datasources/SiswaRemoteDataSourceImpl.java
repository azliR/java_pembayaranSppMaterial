package features.siswa.data.datasources;

import cores.entities.Kelas;
import cores.entities.Siswa;
import static cores.entities.Siswa_.*;
import cores.entities.Spp;
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

    @Override
    public List<Siswa> getListSiswaWithoutThumbnail(int maxResults,
            int firstResult) throws ServerException {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            final var listSiswa = new ArrayList<Siswa>();
            final var criteriaBuilder = entityManager.getCriteriaBuilder();
            final var criteriaQuery = criteriaBuilder.createTupleQuery();
            final var root = criteriaQuery.from(Siswa.class);
            if (firstResult == 0) {
                criteriaQuery.multiselect(root.get(nisn).alias(nisn.getName()),
                        root.get(nama).alias(nama.getName()),
                        root.get(foto).alias(foto.getName()),
                        root.get(sppBulanIni).alias(sppBulanIni.getName()));
            } else {
                criteriaQuery.multiselect(root.get(nisn).alias(nisn.getName()),
                        root.get(nama).alias(nama.getName()),
                        root.get(sppBulanIni).alias(sppBulanIni.getName()));
            }
            criteriaQuery.orderBy(criteriaBuilder.asc(root.get(nama)));

            final var query = entityManager.createQuery(criteriaQuery);
            query.setMaxResults(maxResults);
            query.setFirstResult(firstResult);
            query.getResultList().forEach((tuple) -> {
                final var siswa = new Siswa();
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
    public List<Siswa> getListSiswaByJenisKelaminWithoutThumbnail(char keyword,
            int maxResults,
            int firstResult) throws ServerException {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            final var listSiswa = new ArrayList<Siswa>();
            final var criteriaBuilder = entityManager.getCriteriaBuilder();
            final var criteriaQuery = criteriaBuilder.createTupleQuery();
            final var root = criteriaQuery.from(Siswa.class);
            if (firstResult == 0) {
                criteriaQuery.multiselect(root.get(nisn).alias(nisn.getName()),
                        root.get(nama).alias(nama.getName()),
                        root.get(foto).alias(foto.getName()),
                        root.get(sppBulanIni).alias(sppBulanIni.getName()));
            } else {
                criteriaQuery.multiselect(root.get(nisn).alias(nisn.getName()),
                        root.get(nama).alias(nama.getName()),
                        root.get(sppBulanIni).alias(sppBulanIni.getName()));
            }
            criteriaQuery.orderBy(criteriaBuilder.asc(root.get(nama)));
            criteriaQuery.where(criteriaBuilder.equal(root.get(jenisKelamin),
                    keyword));

            final var query = entityManager.createQuery(criteriaQuery);
            query.setMaxResults(maxResults);
            query.setFirstResult(firstResult);
            query.getResultList().forEach((tuple) -> {
                final var siswa = new Siswa();
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
    public byte[] getSiswaThumbnail(String nisnId) throws ServerException {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            final var criteriaBuilder = entityManager.getCriteriaBuilder();
            final var criteriaQuery = criteriaBuilder.createTupleQuery();
            final var root = criteriaQuery.from(Siswa.class);
            criteriaQuery.multiselect(root.get(foto).alias(foto.getName()));
            criteriaQuery.where(criteriaBuilder.equal(root.get(nisn), nisnId));

            final var query = entityManager.createQuery(criteriaQuery);
            return query.getSingleResult().get(foto.getName(), byte[].class);
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
    public Siswa getSiswa(String nisn) throws ServerException {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            return entityManager.find(Siswa.class, nisn);
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
    public List<Kelas> getListKelas() throws ServerException {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            final var criteriaQuery = entityManager.getCriteriaBuilder()
                    .createQuery(Kelas.class);
            criteriaQuery.select(criteriaQuery.from(Kelas.class));
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
    public List<Spp> getListSpp() throws ServerException {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            final var criteriaQuery = entityManager.getCriteriaBuilder()
                    .createQuery(Spp.class);
            criteriaQuery.select(criteriaQuery.from(Spp.class));
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
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(siswa);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            if (entityManager != null) {
                if (entityManager.find(siswa.getClass(), siswa.getNisn())
                        != null) {
                    throw new PreexistingEntityException(
                            Strings.ERROR_DIALOG_EXISTING_NISN, ex);
                }
            }
            throw new ServerException(Strings.ERROR_DIALOG_CONNECTION,
                    ex);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public void updateSiswa(Siswa siswaValue) throws IllegalOrphanException,
            NonexistentEntityException, ServerException {
        var siswa = siswaValue;
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            var persistentSiswa = entityManager.find(Siswa.class, siswa.getNisn());
            var idKelasOld = persistentSiswa.getIdKelas();
            var idKelasNew = siswa.getIdKelas();
            var idSppOld = persistentSiswa.getIdSpp();
            var idSppNew = siswa.getIdSpp();

            if (idKelasNew != null) {
                idKelasNew = entityManager.getReference(idKelasNew.getClass(),
                        idKelasNew.getId());
                siswa.setIdKelas(idKelasNew);
            }
            if (idSppNew != null) {
                idSppNew = entityManager.getReference(
                        idSppNew.getClass(), idSppNew.getId());
                siswa.setIdSpp(idSppNew);
            }
            siswa = entityManager.merge(siswa);
            if (idKelasOld != null && !idKelasOld.equals(idKelasNew)) {
                idKelasOld.getSiswaList().remove(siswa);
                idKelasOld = entityManager.merge(idKelasOld);
            }
            if (idKelasNew != null && !idKelasNew.equals(idKelasOld)) {
                idKelasNew.getSiswaList().add(siswa);
                idKelasNew = entityManager.merge(idKelasNew);
            }
            if (idSppOld != null && !idSppOld.equals(idSppNew)) {
                idSppOld.getSiswaList().remove(siswa);
                idSppOld = entityManager.merge(idSppOld);
            }
            if (idSppNew != null && !idSppNew.equals(idSppOld)) {
                idSppNew.getSiswaList().add(siswa);
                idSppNew = entityManager.merge(idSppNew);
            }
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = siswa.getNisn();
                if (getSiswa(id) == null) {
                    throw new NonexistentEntityException("Siswa dengan NISN "
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
    public void deleteSiswa(String nisn) throws IllegalOrphanException,
            NonexistentEntityException {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Siswa siswa;
            try {
                siswa = entityManager.getReference(Siswa.class, nisn);
                siswa.getNisn();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The siswa with id " + nisn
                        + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            final var pembayaranListOrphanCheck
                    = siswa.getPembayaranList();
            for (final var pembayaranListOrphanCheckPembayaran
                    : pembayaranListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<>();
                }
                illegalOrphanMessages.add("This Siswa (" + siswa
                        + ") cannot be destroyed since the Pembayaran "
                        + pembayaranListOrphanCheckPembayaran
                        + " in its pembayaranList field has a non-nullable nisn field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Kelas idKelas = siswa.getIdKelas();
            if (idKelas != null) {
                idKelas.getSiswaList().remove(siswa);
                idKelas = entityManager.merge(idKelas);
            }
            Spp idSpp = siswa.getIdSpp();
            if (idSpp != null) {
                idSpp.getSiswaList().remove(siswa);
                idSpp = entityManager.merge(idSpp);
            }
            entityManager.remove(siswa);
            entityManager.getTransaction().commit();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
}
