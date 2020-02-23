package cores.controllerTest;

import cores.controllerTest.exceptions.IllegalOrphanException;
import cores.controllerTest.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import cores.entities.Jurusan;
import cores.entities.Kelas;
import cores.entities.Siswa;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author rizal
 */
public class KelasJpaController implements Serializable {
    public KelasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Kelas kelas) {
        if (kelas.getSiswaList() == null) {
            kelas.setSiswaList(new ArrayList<Siswa>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Jurusan idJurusan = kelas.getIdJurusan();
            if (idJurusan != null) {
                idJurusan
                        = em.getReference(idJurusan.getClass(),
                        idJurusan.getId());
                kelas.setIdJurusan(idJurusan);
            }
            List<Siswa> attachedSiswaList = new ArrayList<Siswa>();
            for (Siswa siswaListSiswaToAttach : kelas.getSiswaList()) {
                siswaListSiswaToAttach
                        = em.getReference(siswaListSiswaToAttach.getClass(),
                        siswaListSiswaToAttach.getId());
                attachedSiswaList.add(siswaListSiswaToAttach);
            }
            kelas.setSiswaList(attachedSiswaList);
            em.persist(kelas);
            if (idJurusan != null) {
                idJurusan.getKelasList().add(kelas);
                idJurusan = em.merge(idJurusan);
            }
            for (Siswa siswaListSiswa : kelas.getSiswaList()) {
                Kelas oldIdKelasOfSiswaListSiswa = siswaListSiswa.getIdKelas();
                siswaListSiswa.setIdKelas(kelas);
                siswaListSiswa = em.merge(siswaListSiswa);
                if (oldIdKelasOfSiswaListSiswa != null) {
                    oldIdKelasOfSiswaListSiswa.getSiswaList()
                            .remove(siswaListSiswa);
                    oldIdKelasOfSiswaListSiswa
                            = em.merge(oldIdKelasOfSiswaListSiswa);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Kelas kelas) throws IllegalOrphanException,
            NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Kelas persistentKelas = em.find(Kelas.class, kelas.getId());
            Jurusan idJurusanOld = persistentKelas.getIdJurusan();
            Jurusan idJurusanNew = kelas.getIdJurusan();
            List<Siswa> siswaListOld = persistentKelas.getSiswaList();
            List<Siswa> siswaListNew = kelas.getSiswaList();
            List<String> illegalOrphanMessages = null;
            for (Siswa siswaListOldSiswa : siswaListOld) {
                if (!siswaListNew.contains(siswaListOldSiswa)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Siswa " +
                            siswaListOldSiswa +
                            " since its idKelas field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idJurusanNew != null) {
                idJurusanNew
                        = em.getReference(idJurusanNew.getClass(),
                        idJurusanNew.getId());
                kelas.setIdJurusan(idJurusanNew);
            }
            List<Siswa> attachedSiswaListNew = new ArrayList<Siswa>();
            for (Siswa siswaListNewSiswaToAttach : siswaListNew) {
                siswaListNewSiswaToAttach
                        = em.getReference(siswaListNewSiswaToAttach.getClass(),
                        siswaListNewSiswaToAttach.getId());
                attachedSiswaListNew.add(siswaListNewSiswaToAttach);
            }
            siswaListNew = attachedSiswaListNew;
            kelas.setSiswaList(siswaListNew);
            kelas = em.merge(kelas);
            if (idJurusanOld != null && !idJurusanOld.equals(idJurusanNew)) {
                idJurusanOld.getKelasList().remove(kelas);
                idJurusanOld = em.merge(idJurusanOld);
            }
            if (idJurusanNew != null && !idJurusanNew.equals(idJurusanOld)) {
                idJurusanNew.getKelasList().add(kelas);
                idJurusanNew = em.merge(idJurusanNew);
            }
            for (Siswa siswaListNewSiswa : siswaListNew) {
                if (!siswaListOld.contains(siswaListNewSiswa)) {
                    Kelas oldIdKelasOfSiswaListNewSiswa
                            = siswaListNewSiswa.getIdKelas();
                    siswaListNewSiswa.setIdKelas(kelas);
                    siswaListNewSiswa = em.merge(siswaListNewSiswa);
                    if (oldIdKelasOfSiswaListNewSiswa != null &&
                            !oldIdKelasOfSiswaListNewSiswa.equals(kelas)) {
                        oldIdKelasOfSiswaListNewSiswa.getSiswaList()
                                .remove(siswaListNewSiswa);
                        oldIdKelasOfSiswaListNewSiswa
                                = em.merge(oldIdKelasOfSiswaListNewSiswa);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = kelas.getId();
                if (findKelas(id) == null) {
                    throw new NonexistentEntityException("The kelas with id " +
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
            Kelas kelas;
            try {
                kelas = em.getReference(Kelas.class, id);
                kelas.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The kelas with id " + id +
                        " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Siswa> siswaListOrphanCheck = kelas.getSiswaList();
            for (Siswa siswaListOrphanCheckSiswa : siswaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Kelas (" + kelas +
                        ") cannot be destroyed since the Siswa " +
                        siswaListOrphanCheckSiswa +
                        " in its siswaList field has a non-nullable idKelas field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Jurusan idJurusan = kelas.getIdJurusan();
            if (idJurusan != null) {
                idJurusan.getKelasList().remove(kelas);
                idJurusan = em.merge(idJurusan);
            }
            em.remove(kelas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Kelas> findKelasEntities() {
        return findKelasEntities(true, -1, -1);
    }

    public List<Kelas> findKelasEntities(int maxResults, int firstResult) {
        return findKelasEntities(false, maxResults, firstResult);
    }

    private List<Kelas> findKelasEntities(boolean all, int maxResults,
            int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Kelas.class));
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

    public Kelas findKelas(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Kelas.class, id);
        } finally {
            em.close();
        }
    }

    public int getKelasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Kelas> rt = cq.from(Kelas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
