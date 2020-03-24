package features.petugas.data.repositories;

import cores.entities.Petugas;
import features.petugas.presentation.pages.AddPetugasPage;
import features.petugas.presentation.pages.EditPetugasPasswordPage;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 *
 * @author rizal
 */
public interface PetugasRepository {
    public abstract boolean login(String namaPengguna, String kataSandi);

    public abstract List<Petugas> getListPetugas(int maxResults, int firstResult);

    public abstract Petugas getPetugas(int id);

    public abstract void insertPetugas(AddPetugasPage context);

    public abstract void updatePetugas(AddPetugasPage context, String kataSandi);

    public abstract void updatePassword(EditPetugasPasswordPage context);

    public abstract boolean deletePetugas(int id);

    public abstract void clear(AddPetugasPage context);

    public abstract BufferedImage getImageFromDisk(int width, int height);

}
