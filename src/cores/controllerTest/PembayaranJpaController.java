package cores.controllerTest;

import cores.controllerTest.exceptions.NonexistentEntityException;
import cores.entities.Pembayaran;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import cores.entities.Petugas;
import cores.entities.Spp;
import cores.entities.Siswa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author rizal
 */
public class PembayaranJpaController implements Serializable {
    public PembayaranJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pembayaran pembayaran) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Petugas idPetugas = pembayaran.getIdPetugas();
            if (idPetugas != null) {
                idPetugas
                        = em.getReference(idPetugas.getClass(),
                        idPetugas.getId());
                pembayaran.setIdPetugas(idPetugas);
            }
            Spp idSpp = pembayaran.getIdSpp();
            if (idSpp != null) {
                idSpp = em.getReference(idSpp.getClass(), idSpp.getId());
                pembayaran.setIdSpp(idSpp);
            }
            Siswa nisn = pembayaran.getNisn();
            if (nisn != null) {
                nisn = em.getReference(nisn.getClass(), nisn.getNisn());
                pembayaran.setNisn(nisn);
            }
            em.persist(pembayaran);
            if (idPetugas != null) {
                idPetugas.getPembayaranList().add(pembayaran);
                idPetugas = em.merge(idPetugas);
            }
            if (idSpp != null) {
                idSpp.getPembayaranList().add(pembayaran);
                idSpp = em.merge(idSpp);
            }
            if (nisn != null) {
                nisn.getPembayaranList().add(pembayaran);
                nisn = em.merge(nisn);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pembayaran pembayaran) throws NonexistentEntityException,
            Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pembayaran persistentPembayaran
                    = em.find(Pembayaran.class, pembayaran.getId());
            Petugas idPetugasOld = persistentPembayaran.getIdPetugas();
            Petugas idPetugasNew = pembayaran.getIdPetugas();
            Spp idSppOld = persistentPembayaran.getIdSpp();
            Spp idSppNew = pembayaran.getIdSpp();
            Siswa nisnOld = persistentPembayaran.getNisn();
            Siswa nisnNew = pembayaran.getNisn();
            if (idPetugasNew != null) {
                idPetugasNew
                        = em.getReference(idPetugasNew.getClass(),
                        idPetugasNew.getId());
                pembayaran.setIdPetugas(idPetugasNew);
            }
            if (idSppNew != null) {
                idSppNew
                        = em.getReference(idSppNew.getClass(), idSppNew.getId());
                pembayaran.setIdSpp(idSppNew);
            }
            if (nisnNew != null) {
                nisnNew = em.getReference(nisnNew.getClass(), nisnNew.getNisn());
                pembayaran.setNisn(nisnNew);
            }
            pembayaran = em.merge(pembayaran);
            if (idPetugasOld != null && !idPetugasOld.equals(idPetugasNew)) {
                idPetugasOld.getPembayaranList().remove(pembayaran);
                idPetugasOld = em.merge(idPetugasOld);
            }
            if (idPetugasNew != null && !idPetugasNew.equals(idPetugasOld)) {
                idPetugasNew.getPembayaranList().add(pembayaran);
                idPetugasNew = em.merge(idPetugasNew);
            }
            if (idSppOld != null && !idSppOld.equals(idSppNew)) {
                idSppOld.getPembayaranList().remove(pembayaran);
                idSppOld = em.merge(idSppOld);
            }
            if (idSppNew != null && !idSppNew.equals(idSppOld)) {
                idSppNew.getPembayaranList().add(pembayaran);
                idSppNew = em.merge(idSppNew);
            }
            if (nisnOld != null && !nisnOld.equals(nisnNew)) {
                nisnOld.getPembayaranList().remove(pembayaran);
                nisnOld = em.merge(nisnOld);
            }
            if (nisnNew != null && !nisnNew.equals(nisnOld)) {
                nisnNew.getPembayaranList().add(pembayaran);
                nisnNew = em.merge(nisnNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = pembayaran.getId();
                if (findPembayaran(id) == null) {
                    throw new NonexistentEntityException("The pembayaran with id " +
                            id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pembayaran pembayaran;
            try {
                pembayaran = em.getReference(Pembayaran.class, id);
                pembayaran.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pembayaran with id " +
                        id + " no longer exists.", enfe);
            }
            Petugas idPetugas = pembayaran.getIdPetugas();
            if (idPetugas != null) {
                idPetugas.getPembayaranList().remove(pembayaran);
                idPetugas = em.merge(idPetugas);
            }
            Spp idSpp = pembayaran.getIdSpp();
            if (idSpp != null) {
                idSpp.getPembayaranList().remove(pembayaran);
                idSpp = em.merge(idSpp);
            }
            Siswa nisn = pembayaran.getNisn();
            if (nisn != null) {
                nisn.getPembayaranList().remove(pembayaran);
                nisn = em.merge(nisn);
            }
            em.remove(pembayaran);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pembayaran> findPembayaranEntities() {
        return findPembayaranEntities(true, -1, -1);
    }

    public List<Pembayaran> findPembayaranEntities(int maxResults,
            int firstResult) {
        return findPembayaranEntities(false, maxResults, firstResult);
    }

    private List<Pembayaran> findPembayaranEntities(boolean all, int maxResults,
            int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pembayaran.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Pembayaran findPembayaran(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pembayaran.class, id);
        } finally {
            em.close();
        }
    }

    public int getPembayaranCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pembayaran> rt = cq.from(Pembayaran.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
