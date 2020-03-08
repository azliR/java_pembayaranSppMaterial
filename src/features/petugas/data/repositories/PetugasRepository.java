package features.petugas.data.repositories;

import cores.entities.Petugas;
import java.util.List;

/**
 *
 * @author rizal
 */
public interface PetugasRepository {
    public abstract List<Petugas> getListPetugas(int maxResults, int firstResult);

    public abstract Petugas getPetugas(int id);

    public abstract void insertPetugas(Petugas petugas);

    public abstract void updatePetugas(Petugas petugas);

    public abstract void deletePetugas(int id);
}
