/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package features.auth.entities;

import cores.exceptions.NonexistentEntityException;
import cores.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author rizal
 */
public class PetugasJpaController implements Serializable {

    public PetugasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Petugas login(String namaPengguna, String kataSandi) {
        EntityManager em = getEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Petugas> cq = cb.createQuery(Petugas.class);
            Root<Petugas> rt = cq.from(Petugas.class);
            cq.select(rt);
            cq.where(cb.equal(rt.get("namaPengguna"), namaPengguna));
            cq.where(cb.equal(rt.get("kataSandi"), kataSandi));
            TypedQuery<Petugas> q = em.createQuery(cq);

            if (q.getResultList().size() <= 0) {
                return null;
            }
            return q.getSingleResult();
        } finally {
            em.close();
        }
    }

    public void create(Petugas petugas) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(petugas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPetugas(petugas.getId()) != null) {
                throw new PreexistingEntityException("Petugas " + petugas + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Petugas petugas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            petugas = em.merge(petugas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = petugas.getId();
                if (findPetugas(id) == null) {
                    throw new NonexistentEntityException("The petugas with id " + id + " no longer exists.");
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
            Petugas petugas;
            try {
                petugas = em.getReference(Petugas.class, id);
                petugas.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The petugas with id " + id + " no longer exists.", enfe);
            }
            em.remove(petugas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Petugas> findPetugasEntities() {
        return findPetugasEntities(true, -1, -1);
    }

    public List<Petugas> findPetugasEntities(int maxResults, int firstResult) {
        return findPetugasEntities(false, maxResults, firstResult);
    }

    private List<Petugas> findPetugasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Petugas.class));
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

    public Petugas findPetugas(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Petugas.class, id);
        } finally {
            em.close();
        }
    }

    public int getPetugasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Petugas> rt = cq.from(Petugas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
