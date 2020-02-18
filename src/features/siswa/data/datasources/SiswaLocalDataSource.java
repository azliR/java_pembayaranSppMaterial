package features.siswa.data.datasources;

import cores.exceptions.UnexpectedException;
import java.io.File;

/**
 *
 * @author rizal
 */
public interface SiswaLocalDataSource {
    public abstract File getImageFromDisk() throws UnexpectedException;
}
