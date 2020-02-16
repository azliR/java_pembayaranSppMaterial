package features.student.data.datasources;

import cores.exceptions.UnexpectedException;
import java.awt.Image;

/**
 *
 * @author rizal
 */
public interface SiswaLocalDataSource {
    public abstract Image getImageFromDisk(int width, int height) throws
            UnexpectedException;
}
