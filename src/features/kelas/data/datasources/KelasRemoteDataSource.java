package features.kelas.data.datasources;

import cores.entities.Kelas;
import cores.exceptions.ServerException;
import java.util.List;

/**
 *
 * @author rizal
 */
public interface KelasRemoteDataSource {
    public abstract List<Kelas> getListKelas(int maxResults, int firstResult)
            throws ServerException;
}
