package features.auth.data.datasources;

import cores.entities.Petugas;
import cores.exceptions.NonexistentEntityException;
import cores.exceptions.ServerException;

/**
 *
 * @author rizal
 */
public interface AuthRemoteDataSource {
    public abstract Petugas login(String namaPengguna, String kataSandi) throws
            NonexistentEntityException, ServerException;

    public abstract void updateStatus(int id, String status) throws
            NonexistentEntityException, ServerException;
}
