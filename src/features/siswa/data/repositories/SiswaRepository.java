package features.siswa.data.repositories;

import features.siswa.presentation.pages.AddSiswaPage;
import features.siswa.presentation.pages.ListSiswaPage;
import features.siswa.presentation.widgets.SiswaTile;

/**
 *
 * @author rizal
 */
public interface SiswaRepository {
    public abstract void initListSiswaWithoutThumbnail(
            ListSiswaPage context, int maxResults,
            int firstResult);

    public abstract void initListSiswaByJenisKelaminWithoutThumbnail(
            ListSiswaPage context, char keyword, int maxResults,
            int firstResult);

    public abstract void initDetailSiswa(String nisn);

    public abstract void initDropdownKelas(AddSiswaPage context);

    public abstract void initDropdownSpp(AddSiswaPage context);

    public abstract void initSiswaThumbnail(SiswaTile siswaTile);

    public abstract void getImageFromDisk(AddSiswaPage context, int width,
            int height);

    public abstract void insertSiswa(AddSiswaPage context);

    public abstract void deleteSiswa(String nisn);

    public abstract void clear(AddSiswaPage context);
}
