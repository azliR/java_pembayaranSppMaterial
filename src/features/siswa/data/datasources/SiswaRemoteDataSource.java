package features.siswa.data.datasources;

import cores.entities.Kelas;
import cores.entities.Siswa;
import cores.entities.Spp;
import cores.exceptions.IllegalOrphanException;
import cores.exceptions.NonexistentEntityException;
import cores.exceptions.PreexistingEntityException;
import cores.exceptions.ServerException;
import java.util.List;

/**
 *
 * @author rizal
 */
public interface SiswaRemoteDataSource {
    public abstract List<Siswa> getListSiswaWithoutThumbnail(int maxResults,
            int firstResult) throws ServerException;

    public abstract List<Siswa> getListSiswaByJenisKelaminWithoutThumbnail(
            char keyword, int maxResults,
            int firstResult) throws ServerException;

    public abstract byte[] getSiswaThumbnail(int id) throws ServerException;

    public abstract Siswa getSiswa(int id) throws ServerException;

    public abstract List<Kelas> getListKelas() throws ServerException;

    public abstract List<Spp> getListSpp() throws ServerException;

    public abstract void insertSiswa(Siswa siswa) throws
            PreexistingEntityException, ServerException;

    public abstract void updateSiswa(Siswa siswa) throws IllegalOrphanException,
            NonexistentEntityException, ServerException;

    public abstract void deleteSiswa(int id) throws IllegalOrphanException,
            NonexistentEntityException;
}
