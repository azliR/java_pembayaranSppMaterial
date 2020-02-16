package features.student.data.repositories;

import features.student.data.entities.Siswa;
import features.student.presentation.pages.AddSiswaPage;
import java.awt.Image;
import java.util.List;

/**
 *
 * @author rizal
 */
public interface SiswaRepository {
    public abstract List<Siswa> getListSiswaWithoutThumbnail(int maxResults,
            int firstResult);

    public abstract byte[] getSiswaThumbnail(int id);

    public abstract Image getImageFromDisk(AddSiswaPage context, int width,
            int height);

    public abstract void insertSiswa(Siswa siswa);
}
