package features.petugas.data.datasources;

import features.siswa.data.datasources.*;
import cores.exceptions.UnexpectedException;
import java.io.File;

/**
 *
 * @author rizal
 */
public interface PetugasLocalDataSource {
    public abstract File getImageFromDisk() throws UnexpectedException;
}
