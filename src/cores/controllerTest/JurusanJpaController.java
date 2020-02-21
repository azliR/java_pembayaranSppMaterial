package cores.controllerTest;

import cores.controllerTest.exceptions.IllegalOrphanException;
import cores.controllerTest.exceptions.NonexistentEntityException;
import cores.entities.Jurusan;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import cores.entities.Kelas;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author rizal
 */
public class JurusanJpaController implements Serializable {
    public JurusanJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Jurusan jurusan) {
        if (jurusan.getKelasList() == null) {
            jurusan.setKelasList(new ArrayList<Kelas>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Kelas> attachedKelasList = new ArrayList<Kelas>();
            for (Kelas kelasListKelasToAttach : jurusan.getKelasList()) {
                kelasListKelasToAttach
                        = em.getReference(kelasListKelasToAttach.getClass(),
                        kelasListKelasToAttach.getId());
                attachedKelasList.add(kelasListKelasToAttach);
            }
            jurusan.setKelasList(attachedKelasList);
            em.persist(jurusan);
            for (Kelas kelasListKelas : jurusan.getKelasList()) {
                Jurusan oldIdJurusanOfKelasListKelas
                        = kelasListKelas.getIdJurusan();
                kelasListKelas.setIdJurusan(jurusan);
                kelasListKelas = em.merge(kelasListKelas);
                if (oldIdJurusanOfKelasListKelas != null) {
                    oldIdJurusanOfKelasListKelas.getKelasList()
                            .remove(kelasListKelas);
                    oldIdJurusanOfKelasListKelas
                            = em.merge(oldIdJurusanOfKelasListKelas);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Jurusan jurusan) throws IllegalOrphanException,
            NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Jurusan persistentJurusan = em.find(Jurusan.class, jurusan.getId());
            List<Kelas> kelasListOld = persistentJurusan.getKelasList();
            List<Kelas> kelasListNew = jurusan.getKelasList();
            List<String> illegalOrphanMessages = null;
            for (Kelas kelasListOldKelas : kelasListOld) {
                if (!kelasListNew.contains(kelasListOldKelas)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Kelas " +
                            kelasListOldKelas +
                            " since its idJurusan field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Kelas> attachedKelasListNew = new ArrayList<Kelas>();
            for (Kelas kelasListNewKelasToAttach : kelasListNew) {
                kelasListNewKelasToAttach
                        = em.getReference(kelasListNewKelasToAttach.getClass(),
                        kelasListNewKelasToAttach.getId());
                attachedKelasListNew.add(kelasListNewKelasToAttach);
            }
            kelasListNew = attachedKelasListNew;
            jurusan.setKelasList(kelasListNew);
            jurusan = em.merge(jurusan);
            for (Kelas kelasListNewKelas : kelasListNew) {
                if (!kelasListOld.contains(kelasListNewKelas)) {
                    Jurusan oldIdJurusanOfKelasListNewKelas
                            = kelasListNewKelas.getIdJurusan();
                    kelasListNewKelas.setIdJurusan(jurusan);
                    kelasListNewKelas = em.merge(kelasListNewKelas);
                    if (oldIdJurusanOfKelasListNewKelas != null &&
                            !oldIdJurusanOfKelasListNewKelas.equals(jurusan)) {
                        oldIdJurusanOfKelasListNewKelas.getKelasList()
                                .remove(kelasListNewKelas);
                        oldIdJurusanOfKelasListNewKelas
                                = em.merge(oldIdJurusanOfKelasListNewKelas);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = jurusan.getId();
                if (findJurusan(id) == null) {
                    throw new NonexistentEntityException("The jurusan with id " +
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

    public void destroy(Integer id) throws IllegalOrphanException,
            NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Jurusan jurusan;
            try {
                jurusan = em.getReference(Jurusan.class, id);
                jurusan.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The jurusan with id " + id +
                        " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Kelas> kelasListOrphanCheck = jurusan.getKelasList();
            for (Kelas kelasListOrphanCheckKelas : kelasListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Jurusan (" + jurusan +
                        ") cannot be destroyed since the Kelas " +
                        kelasListOrphanCheckKelas +
                        " in its kelasList field has a non-nullable idJurusan field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(jurusan);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Jurusan> findJurusanEntities() {
        return findJurusanEntities(true, -1, -1);
    }

    public List<Jurusan> findJurusanEntities(int maxResults, int firstResult) {
        return findJurusanEntities(false, maxResults, firstResult);
    }

    private List<Jurusan> findJurusanEntities(boolean all, int maxResults,
            int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Jurusan.class));
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

    public Jurusan findJurusan(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Jurusan.class, id);
        } finally {
            em.close();
        }
    }

    public int getJurusanCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Jurusan> rt = cq.from(Jurusan.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
