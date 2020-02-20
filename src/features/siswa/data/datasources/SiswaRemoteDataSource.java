package features.siswa.data.datasources;

import cores.entities.Kelas;
import cores.entities.Siswa;
import cores.entities.Spp;
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

    public abstract byte[] getSiswaThumbnail(String nisn) throws ServerException;

    public abstract Siswa getSiswa(String nisn) throws ServerException;

    public abstract List<Kelas> getListKelas() throws ServerException;

    public abstract List<Spp> getListSpp() throws ServerException;

    public abstract void insertSiswa(Siswa siswa) throws
            PreexistingEntityException, ServerException;
}
