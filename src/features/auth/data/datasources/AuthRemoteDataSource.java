package features.auth.data.datasources;

import cores.entities.Petugas;
import cores.exceptions.ServerException;

/**
 *
 * @author rizal
 */
public interface AuthRemoteDataSource {
    public abstract Petugas login(String namaPengguna, String kataSandi) throws
            ServerException;
}
