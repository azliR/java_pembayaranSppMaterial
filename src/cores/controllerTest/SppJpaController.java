package cores.controllerTest;

import cores.controllerTest.exceptions.IllegalOrphanException;
import cores.controllerTest.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import cores.entities.Pembayaran;
import java.util.ArrayList;
import java.util.List;
import cores.entities.Siswa;
import cores.entities.Spp;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author rizal
 */
public class SppJpaController implements Serializable {
    public SppJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Spp spp) {
        if (spp.getPembayaranList() == null) {
            spp.setPembayaranList(new ArrayList<Pembayaran>());
        }
        if (spp.getSiswaList() == null) {
            spp.setSiswaList(new ArrayList<Siswa>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Pembayaran> attachedPembayaranList
                    = new ArrayList<Pembayaran>();
            for (Pembayaran pembayaranListPembayaranToAttach : spp.getPembayaranList()) {
                pembayaranListPembayaranToAttach
                        = em.getReference(pembayaranListPembayaranToAttach.getClass(),
                        pembayaranListPembayaranToAttach.getId());
                attachedPembayaranList.add(pembayaranListPembayaranToAttach);
            }
            spp.setPembayaranList(attachedPembayaranList);
            List<Siswa> attachedSiswaList = new ArrayList<Siswa>();
            for (Siswa siswaListSiswaToAttach : spp.getSiswaList()) {
                siswaListSiswaToAttach
                        = em.getReference(siswaListSiswaToAttach.getClass(),
                        siswaListSiswaToAttach.getId());
                attachedSiswaList.add(siswaListSiswaToAttach);
            }
            spp.setSiswaList(attachedSiswaList);
            em.persist(spp);
            for (Pembayaran pembayaranListPembayaran : spp.getPembayaranList()) {
                Spp oldIdSppOfPembayaranListPembayaran
                        = pembayaranListPembayaran.getIdSpp();
                pembayaranListPembayaran.setIdSpp(spp);
                pembayaranListPembayaran = em.merge(pembayaranListPembayaran);
                if (oldIdSppOfPembayaranListPembayaran != null) {
                    oldIdSppOfPembayaranListPembayaran.getPembayaranList()
                            .remove(pembayaranListPembayaran);
                    oldIdSppOfPembayaranListPembayaran
                            = em.merge(oldIdSppOfPembayaranListPembayaran);
                }
            }
            for (Siswa siswaListSiswa : spp.getSiswaList()) {
                Spp oldIdSppOfSiswaListSiswa = siswaListSiswa.getIdSpp();
                siswaListSiswa.setIdSpp(spp);
                siswaListSiswa = em.merge(siswaListSiswa);
                if (oldIdSppOfSiswaListSiswa != null) {
                    oldIdSppOfSiswaListSiswa.getSiswaList()
                            .remove(siswaListSiswa);
                    oldIdSppOfSiswaListSiswa
                            = em.merge(oldIdSppOfSiswaListSiswa);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Spp spp) throws IllegalOrphanException,
            NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Spp persistentSpp = em.find(Spp.class, spp.getId());
            List<Pembayaran> pembayaranListOld
                    = persistentSpp.getPembayaranList();
            List<Pembayaran> pembayaranListNew = spp.getPembayaranList();
            List<Siswa> siswaListOld = persistentSpp.getSiswaList();
            List<Siswa> siswaListNew = spp.getSiswaList();
            List<String> illegalOrphanMessages = null;
            for (Pembayaran pembayaranListOldPembayaran : pembayaranListOld) {
                if (!pembayaranListNew.contains(pembayaranListOldPembayaran)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Pembayaran " +
                            pembayaranListOldPembayaran +
                            " since its idSpp field is not nullable.");
                }
            }
            for (Siswa siswaListOldSiswa : siswaListOld) {
                if (!siswaListNew.contains(siswaListOldSiswa)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Siswa " +
                            siswaListOldSiswa +
                            " since its idSpp field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Pembayaran> attachedPembayaranListNew
                    = new ArrayList<Pembayaran>();
            for (Pembayaran pembayaranListNewPembayaranToAttach : pembayaranListNew) {
                pembayaranListNewPembayaranToAttach
                        = em.getReference(pembayaranListNewPembayaranToAttach.getClass(),
                        pembayaranListNewPembayaranToAttach.getId());
                attachedPembayaranListNew.add(pembayaranListNewPembayaranToAttach);
            }
            pembayaranListNew = attachedPembayaranListNew;
            spp.setPembayaranList(pembayaranListNew);
            List<Siswa> attachedSiswaListNew = new ArrayList<Siswa>();
            for (Siswa siswaListNewSiswaToAttach : siswaListNew) {
                siswaListNewSiswaToAttach
                        = em.getReference(siswaListNewSiswaToAttach.getClass(),
                        siswaListNewSiswaToAttach.getId());
                attachedSiswaListNew.add(siswaListNewSiswaToAttach);
            }
            siswaListNew = attachedSiswaListNew;
            spp.setSiswaList(siswaListNew);
            spp = em.merge(spp);
            for (Pembayaran pembayaranListNewPembayaran : pembayaranListNew) {
                if (!pembayaranListOld.contains(pembayaranListNewPembayaran)) {
                    Spp oldIdSppOfPembayaranListNewPembayaran
                            = pembayaranListNewPembayaran.getIdSpp();
                    pembayaranListNewPembayaran.setIdSpp(spp);
                    pembayaranListNewPembayaran
                            = em.merge(pembayaranListNewPembayaran);
                    if (oldIdSppOfPembayaranListNewPembayaran != null &&
                            !oldIdSppOfPembayaranListNewPembayaran.equals(spp)) {
                        oldIdSppOfPembayaranListNewPembayaran.getPembayaranList()
                                .remove(pembayaranListNewPembayaran);
                        oldIdSppOfPembayaranListNewPembayaran
                                = em.merge(oldIdSppOfPembayaranListNewPembayaran);
                    }
                }
            }
            for (Siswa siswaListNewSiswa : siswaListNew) {
                if (!siswaListOld.contains(siswaListNewSiswa)) {
                    Spp oldIdSppOfSiswaListNewSiswa
                            = siswaListNewSiswa.getIdSpp();
                    siswaListNewSiswa.setIdSpp(spp);
                    siswaListNewSiswa = em.merge(siswaListNewSiswa);
                    if (oldIdSppOfSiswaListNewSiswa != null &&
                            !oldIdSppOfSiswaListNewSiswa.equals(spp)) {
                        oldIdSppOfSiswaListNewSiswa.getSiswaList()
                                .remove(siswaListNewSiswa);
                        oldIdSppOfSiswaListNewSiswa
                                = em.merge(oldIdSppOfSiswaListNewSiswa);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = spp.getId();
                if (findSpp(id) == null) {
                    throw new NonexistentEntityException("The spp with id " + id +
                            " no longer exists.");
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
            Spp spp;
            try {
                spp = em.getReference(Spp.class, id);
                spp.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The spp with id " + id +
                        " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Pembayaran> pembayaranListOrphanCheck = spp.getPembayaranList();
            for (Pembayaran pembayaranListOrphanCheckPembayaran : pembayaranListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Spp (" + spp +
                        ") cannot be destroyed since the Pembayaran " +
                        pembayaranListOrphanCheckPembayaran +
                        " in its pembayaranList field has a non-nullable idSpp field.");
            }
            List<Siswa> siswaListOrphanCheck = spp.getSiswaList();
            for (Siswa siswaListOrphanCheckSiswa : siswaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Spp (" + spp +
                        ") cannot be destroyed since the Siswa " +
                        siswaListOrphanCheckSiswa +
                        " in its siswaList field has a non-nullable idSpp field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(spp);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Spp> findSppEntities() {
        return findSppEntities(true, -1, -1);
    }

    public List<Spp> findSppEntities(int maxResults, int firstResult) {
        return findSppEntities(false, maxResults, firstResult);
    }

    private List<Spp> findSppEntities(boolean all, int maxResults,
            int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Spp.class));
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

    public Spp findSpp(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Spp.class, id);
        } finally {
            em.close();
        }
    }

    public int getSppCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Spp> rt = cq.from(Spp.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
