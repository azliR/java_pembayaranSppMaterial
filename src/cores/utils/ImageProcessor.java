/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cores.utils;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author rizal
 */
public class ImageProcessor {

    public static Image scaleImage(Image image, int maxImageWidth, int maxImageHeight) {
        int width = image.getWidth(null);
        int height = image.getHeight(null);

        double currentRatio = (double) width / height;
        double aspectRatio = (double) maxImageWidth / maxImageHeight;

        if (currentRatio < aspectRatio) {
            height = (int) (height * ((double) maxImageWidth / width));
            width = maxImageWidth;
        } else {
            width = (int) (width / ((double) height / maxImageHeight));
            height = maxImageHeight;
        }
        return image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }

    public static BufferedImage cropImage(final BufferedImage image, int maxImageWidth, int maxImageHeight) {
        int x = 0;
        int y = 0;
        int width = image.getWidth();
        int height = image.getHeight();

        if (width > maxImageWidth) {
            x = (width - maxImageWidth) / 2;

        }
        if (height > maxImageHeight) {
            y = (height - maxImageHeight) / 2;

        }

        return image.getSubimage(x, y, maxImageWidth, maxImageHeight);
    }

    public static BufferedImage convertRoundedImage(Image image, int borderRadius) {
        int w = image.getWidth(null);
        int h = image.getHeight(null);
        BufferedImage output = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2 = output.createGraphics();

        g2.setComposite(AlphaComposite.Src);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.WHITE);
        g2.fill(new RoundRectangle2D.Float(0, 0, w, h, borderRadius, borderRadius));

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
}
