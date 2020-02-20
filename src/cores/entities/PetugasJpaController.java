package cores.entities;

import cores.exceptions.IllegalOrphanException;
import cores.exceptions.NonexistentEntityException;
import cores.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.ArrayList;
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
public class PetugasJpaController implements Serializable {
    public PetugasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Petugas petugas) throws PreexistingEntityException,
            Exception {
        if (petugas.getPembayaranList() == null) {
            petugas.setPembayaranList(new ArrayList<Pembayaran>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Pembayaran> attachedPembayaranList
                    = new ArrayList<Pembayaran>();
            for (Pembayaran pembayaranListPembayaranToAttach : petugas
                    .getPembayaranList()) {
                pembayaranListPembayaranToAttach
                        = em.getReference(pembayaranListPembayaranToAttach
                                .getClass(),
                                pembayaranListPembayaranToAttach.getId());
                attachedPembayaranList.add(pembayaranListPembayaranToAttach);
            }
            petugas.setPembayaranList(attachedPembayaranList);
            em.persist(petugas);
            for (Pembayaran pembayaranListPembayaran : petugas
                    .getPembayaranList()) {
                Petugas oldIdPetugasOfPembayaranListPembayaran
                        = pembayaranListPembayaran.getIdPetugas();
                pembayaranListPembayaran.setIdPetugas(petugas);
                pembayaranListPembayaran = em.merge(pembayaranListPembayaran);
                if (oldIdPetugasOfPembayaranListPembayaran != null) {
                    oldIdPetugasOfPembayaranListPembayaran.getPembayaranList()
                            .remove(pembayaranListPembayaran);
                    oldIdPetugasOfPembayaranListPembayaran
                            = em.merge(oldIdPetugasOfPembayaranListPembayaran);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPetugas(petugas.getId()) != null) {
                throw new PreexistingEntityException("Petugas " + petugas
                        + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Petugas petugas) throws IllegalOrphanException,
            NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Petugas persistentPetugas = em.find(Petugas.class, petugas.getId());
            List<Pembayaran> pembayaranListOld
                    = persistentPetugas.getPembayaranList();
            List<Pembayaran> pembayaranListNew = petugas.getPembayaranList();
            List<String> illegalOrphanMessages = null;
            for (Pembayaran pembayaranListOldPembayaran : pembayaranListOld) {
                if (!pembayaranListNew.contains(pembayaranListOldPembayaran)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Pembayaran "
                            + pembayaranListOldPembayaran
                            + " since its idPetugas field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
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
            petugas.setPembayaranList(pembayaranListNew);
            petugas = em.merge(petugas);
            for (Pembayaran pembayaranListNewPembayaran : pembayaranListNew) {
                if (!pembayaranListOld.contains(pembayaranListNewPembayaran)) {
                    Petugas oldIdPetugasOfPembayaranListNewPembayaran
                            = pembayaranListNewPembayaran.getIdPetugas();
                    pembayaranListNewPembayaran.setIdPetugas(petugas);
                    pembayaranListNewPembayaran
                            = em.merge(pembayaranListNewPembayaran);
                    if (oldIdPetugasOfPembayaranListNewPembayaran != null
                            && !oldIdPetugasOfPembayaranListNewPembayaran
                                    .equals(petugas)) {
                        oldIdPetugasOfPembayaranListNewPembayaran
                                .getPembayaranList()
                                .remove(pembayaranListNewPembayaran);
                        oldIdPetugasOfPembayaranListNewPembayaran
                                = em.merge(
                                        oldIdPetugasOfPembayaranListNewPembayaran);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = petugas.getId();
                if (findPetugas(id) == null) {
                    throw new NonexistentEntityException("The petugas with id "
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

    public void destroy(Integer id) throws IllegalOrphanException,
            NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Petugas petugas;
            try {
                petugas = em.getReference(Petugas.class, id);
                petugas.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The petugas with id " + id
                        + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Pembayaran> pembayaranListOrphanCheck
                    = petugas.getPembayaranList();
            for (Pembayaran pembayaranListOrphanCheckPembayaran
                    : pembayaranListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Petugas (" + petugas
                        + ") cannot be destroyed since the Pembayaran "
                        + pembayaranListOrphanCheckPembayaran
                        + " in its pembayaranList field has a non-nullable idPetugas field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
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

    private List<Petugas> findPetugasEntities(boolean all, int maxResults,
            int firstResult) {
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
