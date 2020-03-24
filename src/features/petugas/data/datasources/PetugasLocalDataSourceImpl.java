package features.petugas.data.datasources;

import cores.exceptions.UnexpectedException;
import cores.styles.Strings;
import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;

/**
 *
 * @author rizal
 */
public class PetugasLocalDataSourceImpl implements PetugasLocalDataSource {
    @Override
    public File getImageFromDisk() throws UnexpectedException {
        try {
            final var fileDialog = new FileDialog((Frame) null,
                    "Pilih Gambar Produk", FileDialog.LOAD);
            fileDialog.setFilenameFilter((dir, name) -> {
                return name.endsWith(".jpeg") || name.endsWith(".jpg") || name
                        .endsWith(".png");
            });
            fileDialog.setAlwaysOnTop(true);
            fileDialog.setLocationRelativeTo(null);
            fileDialog.setVisible(true);
            fileDialog.toFront();

            final var fileDirectory
                    = fileDialog.getDirectory() + fileDialog.getFile();

            if (fileDialog.getFile() == null) {
                fileDialog.dispose();
                return null;
            }
            fileDialog.dispose();

            final var selectedFile = new File(fileDirectory);
            return selectedFile;
        } catch (SecurityException ex) {
            throw new UnexpectedException(
                    Strings.ERROR_DIALOG_FAILED_GET_IMAGE_FROM_DISK, ex);
        }
    }
}
