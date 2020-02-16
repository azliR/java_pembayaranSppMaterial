package features.student.repositories;

import features.student.entities.Siswa;
import java.util.List;

/**
 *
 * @author rizal
 */
public abstract class SiswaRepository {

    public abstract List<Siswa> getListSiswaWithoutThumbnail(int maxResults, int firstResult);

    public abstract byte[] getSiswaThumbnail(int id);
}
