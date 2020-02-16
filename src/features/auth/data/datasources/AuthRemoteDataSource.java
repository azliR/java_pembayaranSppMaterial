package features.auth.data.datasources;

import cores.exceptions.ServerException;
import features.auth.data.entities.Petugas;

/**
 *
 * @author rizal
 */
public interface AuthRemoteDataSource {
    public abstract Petugas login(String namaPengguna, String kataSandi) throws
            ServerException;
}
