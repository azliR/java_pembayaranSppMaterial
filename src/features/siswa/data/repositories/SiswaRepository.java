package features.siswa.data.repositories;

import cores.entities.Kelas;
import cores.entities.Spp;
import features.siswa.presentation.pages.AddSiswaPage;
import features.siswa.presentation.pages.ListSiswaPage;
import java.util.List;

/**
 *
 * @author rizal
 */
public interface SiswaRepository {
    public abstract void getListSiswaWithoutThumbnail(
            ListSiswaPage context, int maxResults,
            int firstResult);

    public abstract List<Kelas> initDropdownKelas(AddSiswaPage context);

    public abstract List<Spp> initDropdownSpp(AddSiswaPage context);

    public abstract byte[] getSiswaThumbnail(String nisn);

    public abstract byte[] getImageFromDisk(AddSiswaPage context, int width,
            int height);

    public abstract void insertSiswa(AddSiswaPage context);

    public abstract void clear(AddSiswaPage context);
}
