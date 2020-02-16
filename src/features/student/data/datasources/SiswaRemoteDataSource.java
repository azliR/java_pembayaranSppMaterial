package features.student.data.datasources;

import cores.exceptions.PreexistingEntityException;
import cores.exceptions.ServerException;
import features.student.data.entities.Siswa;
import java.util.List;

/**
 *
 * @author rizal
 */
public interface SiswaRemoteDataSource {
    public abstract List<Siswa> getListSiswaWithoutThumbnail(int maxResults,
            int firstResult) throws ServerException;

    public abstract void insertSiswa(Siswa siswa) throws
            PreexistingEntityException, ServerException;
}
