package features.siswa.data.repositories;

import cores.entities.Kelas;
import cores.entities.Siswa;
import cores.entities.Spp;
import features.siswa.presentation.pages.AddSiswaPage;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 *
 * @author rizal
 */
public interface SiswaRepository {
    public abstract List<Siswa> getListSiswaWithoutThumbnail(int maxResults,
            int firstResult);

    public abstract List<Siswa> getListSiswaByJenisKelaminWithoutThumbnail(
            char keyword, int maxResults, int firstResult);

    public abstract List<Siswa> getListSiswaByNameWithoutThumbnail(
            String keyword, int maxResults, int firstResult);

    public abstract List<Kelas> getListKelas();

    public abstract List<Spp> getListSpp();

    public abstract Siswa getSiswa(int id);

    public abstract byte[] getSiswaThumbnail(int id);

    public abstract BufferedImage getImageFromDisk(int width, int height);

    public abstract void insertSiswa(AddSiswaPage context);

    public abstract void deleteSiswa(int id);

    public abstract void clear(AddSiswaPage context);
}
