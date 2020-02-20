package features.siswa.data.datasources;

import cores.entities.Kelas;
import cores.entities.Siswa;
import static cores.entities.Siswa_.*;
import cores.entities.Spp;
import cores.exceptions.PreexistingEntityException;
import cores.exceptions.ServerException;
import cores.styles.Strings;
import java.util.ArrayList;
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
            final var criteriaBuilder = entityManager.getCriteriaBuilder();
            final var criteriaQuery = criteriaBuilder.createTupleQuery();
            final var root = criteriaQuery.from(Siswa.class);
            criteriaQuery.multiselect(root.get(nisn).alias(nisn.getName()), root
                    .get(nama).alias(nama.getName()), root.get(sppBulanIni)
                    .alias(sppBulanIni.getName()));
            criteriaQuery.orderBy(criteriaBuilder.asc(root.get(nama)));

            final var query = entityManager.createQuery(criteriaQuery);
            query.setMaxResults(maxResults);
            query.setFirstResult(firstResult);
            final var listSiswa = new ArrayList<Siswa>();
            query.getResultList().forEach((tuple) -> {
                final var siswa = new Siswa();
                siswa.setNama(tuple.get(nama.getName(), String.class));
                siswa.setNisn(tuple.get(nisn.getName(), String.class));
                siswa.setSppBulanIni(tuple.get(sppBulanIni.getName(),
                        String.class));
                listSiswa.add(siswa);
            });
            return listSiswa;
        } catch (Exception ex) {
            throw new ServerException(Strings.ERROR_DIALOG_CONNECTION,
                    ex);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public byte[] getSiswaThumbnail(String nisnId) throws ServerException {
        final var entityManager = entityManagerFactory.createEntityManager();
        try {
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
            entityManager.close();
        }
    }

    @Override
    public Siswa getSiswa(String nisn) throws ServerException {
        final var entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.find(Siswa.class, nisn);
        } catch (Exception ex) {
            throw new ServerException(Strings.ERROR_DIALOG_CONNECTION,
                    ex);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Kelas> getListKelas() throws ServerException {
        final var entityManager = entityManagerFactory.createEntityManager();
        try {
            final var criteriaQuery = entityManager.getCriteriaBuilder()
                    .createQuery(Kelas.class);
            criteriaQuery.select(criteriaQuery.from(Kelas.class));
            final var query = entityManager.createQuery(criteriaQuery);
            return query.getResultList();
        } catch (Exception ex) {
            throw new ServerException(Strings.ERROR_DIALOG_CONNECTION,
                    ex);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Spp> getListSpp() throws ServerException {
        final var entityManager = entityManagerFactory.createEntityManager();
        try {
            final var criteriaQuery = entityManager.getCriteriaBuilder()
                    .createQuery(Spp.class);
            criteriaQuery.select(criteriaQuery.from(Spp.class));
            final var query = entityManager.createQuery(criteriaQuery);
            return query.getResultList();
        } catch (Exception ex) {
            throw new ServerException(Strings.ERROR_DIALOG_CONNECTION,
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
                        Strings.ERROR_DIALOG_EXISTING_NISN, ex);
            }
            throw new ServerException(Strings.ERROR_DIALOG_CONNECTION,
                    ex);
        } finally {
            entityManager.close();
        }
    }
}
