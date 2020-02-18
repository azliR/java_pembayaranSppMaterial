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

//    public static Image scaleImage(Image image, int maxImageWidth,
//            int maxImageHeight) {
//        int width = image.getWidth(null);
//        int height = image.getHeight(null);
//
//        double currentRatio = (double) width / height;
//        double aspectRatio = (double) maxImageWidth / maxImageHeight;
//
//        if (currentRatio < aspectRatio) {
//            height = (int) (height * ((double) maxImageWidth / width));
//            width = maxImageWidth;
//        } else {
//            width = (int) (width / ((double) height / maxImageHeight));
//            height = maxImageHeight;
//        }
//        return image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
//    }
//    public static BufferedImage cropImage(final BufferedImage image,
//            int maxImageWidth, int maxImageHeight) {
//        final var width = image.getWidth();
//        final var height = image.getHeight();
//        var x = 0;
//        var y = 0;
//        var maxWidth = maxImageWidth;
//        var maxHeigth = maxImageHeight;
//
//        if (width > maxImageWidth) {
////            x = (width - maxImageWidth) / 2;
//        } else {
//            maxWidth = width;
//        }
//        if (height > maxImageHeight) {
////            y = (height - maxImageHeight) / 2;
//        } else {
//            maxHeigth = height;
//        }
//
//        return image.getSubimage(x, y, maxWidth, maxHeigth);
//    }
    public static BufferedImage roundImage(Image image, int borderRadius) {
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

    public static BufferedImage toBufferedImage(Image img) {
        BufferedImage buffImage = new BufferedImage(
                img.getWidth(null),
                img.getHeight(null),
                BufferedImage.TYPE_INT_RGB);

        buffImage.getGraphics().drawImage(img, 0, 0, null);

        return buffImage;
    }

    public static File toFile(Image image) {
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
