package cores.widgets;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.beans.BeanProperty;
import javax.swing.JButton;

/**
 *
 * @author a_lpha
 */
public class RoundedButton extends JButton {
    private static final long serialVersionUID = 1L;

    private int borderRadius = 15;

    public RoundedButton() {
        super();
    }

    public RoundedButton(int borderRadius) {
        super();
        this.borderRadius = borderRadius;
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    public void setBorderRadius(int borderRadius) {
        this.borderRadius = borderRadius;
    }

    @Override
    public boolean isOpaque() {
        return false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Dimension arcs = new Dimension(borderRadius, borderRadius);
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        graphics.setColor(getBackground());
        graphics.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1,
                arcs.width, arcs.height);
        graphics.setColor(getForeground());
        super.paintComponent(g);
    }
}
