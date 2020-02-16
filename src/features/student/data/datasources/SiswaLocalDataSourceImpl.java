/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package features.student.data.datasources;

import cores.exceptions.UnexpectedException;
import cores.styles.Strings;
import cores.utils.ImageProcessor;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author rizal
 */
public class SiswaLocalDataSourceImpl implements SiswaLocalDataSource {
    @Override
    public Image getImageFromDisk(int width, int height) throws
            UnexpectedException {
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
            final var image = ImageIO.read(selectedFile);
            final var resizedImage = ImageProcessor.scaleImage(image, width, height);
            final var croppedImage = ImageProcessor.cropImage(ImageProcessor
                    .toBufferedImage(resizedImage), width, height);

            return croppedImage;
        } catch (IOException ex) {
            throw new UnexpectedException(
                    Strings.ERROR_DIALOG_FAILED_GET_IMAGE_FROM_DISK, ex);
        }
    }
}
