package features.student.entities;

import cores.exceptions.NonexistentEntityException;
import cores.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author rizal
 */
public class SiswaJpaController implements Serializable {

    public SiswaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Siswa siswa) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(siswa);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSiswa(siswa.getNisn()) != null) {
                throw new PreexistingEntityException("Siswa " + siswa + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Siswa siswa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            siswa = em.merge(siswa);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = siswa.getNisn();
                if (findSiswa(id) == null) {
                    throw new NonexistentEntityException("The siswa with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Siswa siswa;
            try {
                siswa = em.getReference(Siswa.class, id);
                siswa.getNisn();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The siswa with id " + id + " no longer exists.", enfe);
            }
            em.remove(siswa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

//    public List<Siswa> findSiswaWithoutThumbnail(int maxResults, int firstResult) {
//        EntityManager em = getEntityManager();
//        try {
//            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
//            Root<Siswa> r = cq.from(Siswa.class);
//            cq.select(Siswa.class);
//            Query q = em.createQuery(cq);
//            q.setMaxResults(maxResults);
//            q.setFirstResult(firstResult);
//
//            return q.getResultList();
//        } finally {
//            em.close();
//        }
//    }
    public List<Siswa> findSiswaEntities() {
        return findSiswaEntities(true, -1, -1);
    }

    public List<Siswa> findSiswaEntities(int maxResults, int firstResult) {
        return findSiswaEntities(false, maxResults, firstResult);
    }

    private List<Siswa> findSiswaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Siswa.class));
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

    public Siswa findSiswa(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Siswa.class, id);
        } finally {
            em.close();
        }
    }

    public int getSiswaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Siswa> rt = cq.from(Siswa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
