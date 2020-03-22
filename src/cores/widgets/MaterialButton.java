package cores.widgets;

import cores.styles.Colors;
import cores.styles.Consts;
import cores.styles.Fonts;
import cores.utils.Intl;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.beans.BeanProperty;
import java.beans.JavaBean;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ButtonUI;

/**
 *
 * @author a_lpha
 */
@JavaBean()
public class MaterialButton extends JButton {
    private static final long serialVersionUID = 1L;

    private int borderRadius = Consts.BORDER_RADIUS;
    private RoundedRectangleBorder border = null;
    private Color borderColor = null;
    private Color backgroundColor = Colors.BACKGROUND_COLOR;

    public MaterialButton() {
        init();
    }

    private void init() {
        setFont(Fonts.registerProductSansMedium(this.getClass()).deriveFont(14f));
        setBorder(new EmptyBorder(new Insets(8, 16, 8, 16)));
        setBorderRadius(borderRadius);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);
        setBackground(backgroundColor);
        setForeground(Colors.PRIMARY_COLOR);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setUI((ButtonUI) UIManager.getUI(this));
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (isEnabled()) {
                    setBackgroundColor(Intl.getDarker(backgroundColor));
                }
                super.mouseEntered(evt);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (isEnabled()) {
                    setBackgroundColor(backgroundColor);
                }
                super.mouseExited(evt);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (isEnabled()) {
                    if (border != null && borderColor != null) {
                        border.setBorderColor(Colors.PRIMARY_COLOR);
                    } else {
                        setBackgroundColor(backgroundColor.darker());
                    }
                }
                super.mousePressed(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (isEnabled()) {
                    if (border != null && borderColor != null) {
                        border.setBorderColor(borderColor);
                    } else {
                        setBackgroundColor(backgroundColor);
                    }
                }
                super.mouseReleased(e);
            }
        });

    }

    private void setBackgroundColor(Color bg) {
        super.setBackground(bg);
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    @Override
    public void setBackground(Color bg) {
        this.backgroundColor = bg;
        super.setBackground(bg);
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    @Override
    public void setBorder(Border border) {
        if (border instanceof RoundedRectangleBorder) {
            this.border = (RoundedRectangleBorder) border;
            this.borderColor = ((RoundedRectangleBorder) border)
                    .getBorderColor();
        }
        super.setBorder(border);
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    public void setBorderRadius(int borderRadius) {
        final var oldValue = this.borderRadius;
        this.borderRadius = borderRadius;
        firePropertyChange("borderRadius", oldValue, borderRadius);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        final var arcs = new Dimension(borderRadius, borderRadius);
        final var graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        graphics.setColor(getBackground());
        graphics.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1,
                arcs.width, arcs.height);
        graphics.setColor(getForeground());
        super.paintComponent(g);
    }
}
