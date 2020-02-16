package cores.widgets;

import cores.styles.Colors;
import cores.styles.Constants;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.border.Border;

/**
 *
 * @author a_lpha
 */
public class RoundedBorder implements Border {

    private int borderRadius = Constants.BORDER_RADIUS;
    private int[] borderInsets = Constants.ZERO_BORDER_INSETS;
    private Color borderColor = Colors.BORDER_COLOR;

    public RoundedBorder(int borderRadius, int[] insets, Color borderColor) {
        super();
        this.borderRadius = borderRadius;
        this.borderInsets = insets;
        this.borderColor = borderColor;
    }

    public RoundedBorder(int borderRadius, Color borderColor) {
        super();
        this.borderRadius = borderRadius;
        this.borderColor = borderColor;
    }

    public RoundedBorder(int borderRadius) {
        super();
        this.borderRadius = borderRadius;
    }

    public RoundedBorder() {
        super();
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(borderInsets[0], borderInsets[1], borderInsets[2], borderInsets[3]);
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Dimension arcs = new Dimension(borderRadius, borderRadius);
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(borderColor);
        graphics.drawRoundRect(x, y, width - 1, height - 1, arcs.width, arcs.height);
    }
}
