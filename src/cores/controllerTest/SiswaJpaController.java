package cores.controllerTest;

import cores.controllerTest.exceptions.IllegalOrphanException;
import cores.controllerTest.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import cores.entities.Kelas;
import cores.entities.Spp;
import cores.entities.Pembayaran;
import cores.entities.Siswa;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

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

    public void create(Siswa siswa) {
        if (siswa.getPembayaranList() == null) {
            siswa.setPembayaranList(new ArrayList<Pembayaran>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
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
            for (Pembayaran pembayaranListPembayaranToAttach : siswa.getPembayaranList()) {
                pembayaranListPembayaranToAttach
                        = em.getReference(pembayaranListPembayaranToAttach.getClass(),
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

    public void edit(Siswa siswa) throws IllegalOrphanException,
            NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
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
                    illegalOrphanMessages.add("You must retain Pembayaran " +
                            pembayaranListOldPembayaran +
                            " since its idSiswa field is not nullable.");
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
            for (Pembayaran pembayaranListNewPembayaranToAttach : pembayaranListNew) {
                pembayaranListNewPembayaranToAttach
                        = em.getReference(pembayaranListNewPembayaranToAttach.getClass(),
                        pembayaranListNewPembayaranToAttach.getId());
                attachedPembayaranListNew.add(pembayaranListNewPembayaranToAttach);
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
                    if (oldIdSiswaOfPembayaranListNewPembayaran != null &&
                            !oldIdSiswaOfPembayaranListNewPembayaran.equals(siswa)) {
                        oldIdSiswaOfPembayaranListNewPembayaran.getPembayaranList()
                                .remove(pembayaranListNewPembayaran);
                        oldIdSiswaOfPembayaranListNewPembayaran
                                = em.merge(oldIdSiswaOfPembayaranListNewPembayaran);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = siswa.getId();
                if (findSiswa(id) == null) {
                    throw new NonexistentEntityException("The siswa with id " +
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
            Siswa siswa;
            try {
                siswa = em.getReference(Siswa.class, id);
                siswa.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The siswa with id " + id +
                        " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Pembayaran> pembayaranListOrphanCheck
                    = siswa.getPembayaranList();
            for (Pembayaran pembayaranListOrphanCheckPembayaran : pembayaranListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Siswa (" + siswa +
                        ") cannot be destroyed since the Pembayaran " +
                        pembayaranListOrphanCheckPembayaran +
                        " in its pembayaranList field has a non-nullable idSiswa field.");
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

    public List<Siswa> findSiswaEntities() {
        return findSiswaEntities(true, -1, -1);
    }

    public List<Siswa> findSiswaEntities(int maxResults, int firstResult) {
        return findSiswaEntities(false, maxResults, firstResult);
    }

    private List<Siswa> findSiswaEntities(boolean all, int maxResults,
            int firstResult) {
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

    public Siswa findSiswa(Integer id) {
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
