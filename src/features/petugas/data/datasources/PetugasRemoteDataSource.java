package features.petugas.data.datasources;

import cores.entities.Petugas;
import cores.exceptions.IllegalOrphanException;
import cores.exceptions.NonexistentEntityException;
import cores.exceptions.ServerException;
import java.util.List;

/**
 *
 * @author rizal
 */
public interface PetugasRemoteDataSource {
    public abstract List<Petugas> getListPetugas(int maxResults, int firstResult)
            throws ServerException;

    public abstract Petugas getPetugas(int id) throws ServerException;

    public abstract void insertPetugas(Petugas petugas) throws ServerException;

    public abstract void updatePetugas(Petugas petugas) throws
            IllegalOrphanException,
            NonexistentEntityException, ServerException;

    public abstract void deletePetugas(int id) throws IllegalOrphanException,
            NonexistentEntityException, ServerException;
}
