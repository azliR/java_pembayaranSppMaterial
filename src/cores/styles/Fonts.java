package cores.styles;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rizal
 */
public class Fonts {

    public static Font GOOGLE_SANS;

    public static Font PRODUCT_SANS_REGULAR;
    public static Font PRODUCT_SANS_MEDIUM;

    public static Font ROBOTO_REGULAR;
    public static Font ROBOTO_LIGHT;
    public static Font ROBOTO_MEDIUM;

    private static final GraphicsEnvironment GRAPHICS_ENVIRONMENT
            = GraphicsEnvironment
                    .getLocalGraphicsEnvironment();

    public static void registerAllFont(Class<?> c) {
        registerGoogleSans(c);
        registerProductSansRegular(c);
        registerProductSansMedium(c);
        registerRobotoRegular(c);
        registerRobotoLight(c);
        registerRobotoMedium(c);
    }

    public static Font registerGoogleSans(Class<?> c) {
        try {
            GOOGLE_SANS = Font.createFont(Font.TRUETYPE_FONT, c
                    .getResourceAsStream("/assets/fonts/GoogleSans-Regular.ttf"));
            GRAPHICS_ENVIRONMENT.registerFont(GOOGLE_SANS);
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(Fonts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return GOOGLE_SANS;
    }

    public static Font registerProductSansRegular(Class<?> c) {
        try {
            PRODUCT_SANS_REGULAR = Font.createFont(Font.TRUETYPE_FONT, c
                    .getResourceAsStream("/assets/fonts/ProductSans-Regular.ttf"));
            GRAPHICS_ENVIRONMENT.registerFont(PRODUCT_SANS_REGULAR);
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(Fonts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return PRODUCT_SANS_REGULAR;
    }

    public static Font registerProductSansMedium(Class<?> c) {
        try {
            PRODUCT_SANS_MEDIUM = Font.createFont(Font.TRUETYPE_FONT, c
                    .getResourceAsStream("/assets/fonts/ProductSans-Medium.ttf"));
            GRAPHICS_ENVIRONMENT.registerFont(PRODUCT_SANS_MEDIUM);
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(Fonts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return PRODUCT_SANS_MEDIUM;
    }

    public static Font registerRobotoRegular(Class<?> c) {
        try {
            ROBOTO_REGULAR = Font.createFont(Font.TRUETYPE_FONT, c
                    .getResourceAsStream("/assets/fonts/Roboto-Regular.ttf"));
            GRAPHICS_ENVIRONMENT.registerFont(ROBOTO_REGULAR);
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(Fonts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ROBOTO_REGULAR;
    }

    public static Font registerRobotoLight(Class<?> c) {
        try {
            ROBOTO_LIGHT = Font.createFont(Font.TRUETYPE_FONT, c
                    .getResourceAsStream("/assets/fonts/Roboto-Light.ttf"));
            GRAPHICS_ENVIRONMENT.registerFont(ROBOTO_LIGHT);
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(Fonts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ROBOTO_LIGHT;
    }

    public static Font registerRobotoMedium(Class<?> c) {
        try {
            ROBOTO_MEDIUM = Font.createFont(Font.TRUETYPE_FONT, c
                    .getResourceAsStream("/assets/fonts/Roboto-Medium.ttf"));
            GRAPHICS_ENVIRONMENT.registerFont(ROBOTO_MEDIUM);
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(Fonts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ROBOTO_MEDIUM;
    }

    private Fonts() {
    }
}
