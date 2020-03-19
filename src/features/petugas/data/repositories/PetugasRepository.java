package features.petugas.data.repositories;

import cores.entities.Petugas;
import features.petugas.presentation.pages.AddPetugasPage;
import java.util.List;

/**
 *
 * @author rizal
 */
public interface PetugasRepository {
    public abstract List<Petugas> getListPetugas(int maxResults, int firstResult);

    public abstract Petugas getPetugas(int id);

    public abstract void insertOrUpdatePetugas(AddPetugasPage context);

    public abstract void deletePetugas(int id);

    public abstract void clear(AddPetugasPage context);
}
