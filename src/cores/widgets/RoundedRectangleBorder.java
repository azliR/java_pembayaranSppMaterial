package cores.widgets;

import cores.styles.Colors;
import cores.styles.Consts;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.beans.ConstructorProperties;
import java.io.Serializable;
import javax.swing.border.AbstractBorder;

/**
 *
 * @author a_lpha
 */
@SuppressWarnings("serial")
public class RoundedRectangleBorder extends AbstractBorder implements Serializable {

    protected int borderRadius = Consts.BORDER_RADIUS;
    protected Insets borderInsets = new Insets(8, 8, 8, 8);
    protected Color borderColor = Colors.BORDER_COLOR;

    public RoundedRectangleBorder() {
    }

    @ConstructorProperties({"borderRadius", "borderInsets", "borderColor"})
    public RoundedRectangleBorder(int borderRadius, Insets borderInsets,
            Color borderColor) {
        this.borderInsets = borderInsets;
        this.borderRadius = borderRadius;
        this.borderColor = borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public void setBorderInsets(Insets borderInsets) {
        this.borderInsets = borderInsets;
    }

    public void setBorderRadius(int borderRadius) {
        this.borderRadius = borderRadius;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }

    public int getBorderRadius() {
        return borderRadius;
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(borderInsets.top, borderInsets.left,
                borderInsets.bottom, borderInsets.right);
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        return new Insets(borderInsets.top, borderInsets.left,
                borderInsets.bottom, borderInsets.right);
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width,
            int height) {
        final var arcs = new Dimension(borderRadius, borderRadius);
        final var graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(borderColor);
        graphics.drawRoundRect(x, y, width - 1, height - 1, arcs.width,
                arcs.height);
    }
}
