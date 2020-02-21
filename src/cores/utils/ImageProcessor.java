package cores.utils;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author rizal
 */
public class ImageProcessor {

    public static BufferedImage roundImage(Image image, int borderRadius) {
        if (image == null) {
            return null;
        }
        int w = image.getWidth(null);
        int h = image.getHeight(null);
        BufferedImage output = new BufferedImage(w, h,
                BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2 = output.createGraphics();

        g2.setComposite(AlphaComposite.Src);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.WHITE);
        g2.fill(new RoundRectangle2D.Float(0, 0, w, h, borderRadius,
                borderRadius));

        g2.setComposite(AlphaComposite.SrcAtop);
        g2.drawImage(image, 0, 0, null);

        g2.dispose();

        return output;
    }

    public static BufferedImage toBufferedImage(Image image) {
        if (image == null) {
            return null;
        }
        BufferedImage buffImage = new BufferedImage(
                image.getWidth(null),
                image.getHeight(null),
                BufferedImage.TYPE_INT_RGB);

        buffImage.getGraphics().drawImage(image, 0, 0, null);

        return buffImage;
    }

    public static File toFile(Image image) {
        if (image == null) {
            return null;
        }
        try {
            File resizedImageFile = new File(System.getProperty("user.dir")
                    + "/bin.png");
            ImageIO.write(toBufferedImage(image), "png", resizedImageFile);

            return resizedImageFile;
        } catch (IOException ex) {
            Logger.getLogger(ImageProcessor.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        return null;
    }

    public static byte[] toByteArray(BufferedImage image) {
        if (image == null) {
            return null;
        }
        try {
            final var byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException ex) {
            Logger.getLogger(ImageProcessor.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static BufferedImage byteArrayToBufferedImage(byte[] byteArrayImage) {
        if (byteArrayImage == null) {
            return null;
        }
        try {
            final var byteArrayInputStream
                    = new ByteArrayInputStream(byteArrayImage);
            final var bufferedImage = ImageIO.read(byteArrayInputStream);
            return bufferedImage;
        } catch (IOException ex) {
            Logger.getLogger(ImageProcessor.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private ImageProcessor() {
    }
}
