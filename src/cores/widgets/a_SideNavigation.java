package cores.widgets;

import cores.styles.Colors;
import cores.styles.Constants;
import cores.styles.Fonts;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Collections;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import main.MainFrame;

/**
 *
 * @author a_lpha
 */
public class a_SideNavigation extends JRadioButton {

    private final int borderRadius = Constants.SIDEBAR_RADIUS;

    public a_SideNavigation(ButtonGroup sideBarGroup) {
        super();
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setContentAreaFilled(false);
        setOpaque(false);
        setBorderPainted(true);
        setFocusPainted(false);
        setIconTextGap(20);
        setFont(Fonts.ROBOTO_MEDIUM.deriveFont(13f));
        setBorder(BorderFactory.createMatteBorder(0, 36, 0, 0, getBackground()));
        addActionListener((e) -> {
            List<AbstractButton> listButtons = Collections.list(sideBarGroup.getElements());

            listButtons.forEach((button) -> {
                setColor(button);
            });
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (!isSelected()) {
                    setBackground(Colors.GREY_BACKGROUND_COLOR);
                    setBorder(BorderFactory.createMatteBorder(0, 36, 0, 0, Colors.GREY_BACKGROUND_COLOR));
                }
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (!isSelected()) {
                    setBackground(Colors.BACKGROUND_COLOR);
                    setBorder(BorderFactory.createMatteBorder(0, 36, 0, 0, Colors.BACKGROUND_COLOR));
                }
            }
        });
    }

    private void setColor(AbstractButton button) {
        if (button.isSelected()) {
            MainFrame.tv_title.setText(button.getText());
            button.setForeground(Colors.ACTIVE_TEXT_COLOR);
            button.setBackground(Colors.BLUE_BACKGROUND_COLOR);
            button.setBorder(BorderFactory.createMatteBorder(0, 36, 0, 0, Colors.BLUE_BACKGROUND_COLOR));

        } else {
            button.setForeground(Colors.GREY_TEXT_COLOR);
            button.setBackground(Colors.BACKGROUND_COLOR);
            button.setBorder(BorderFactory.createMatteBorder(0, 36, 0, 0, Colors.BACKGROUND_COLOR));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Dimension arcs = new Dimension(borderRadius, borderRadius);
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        graphics.setColor(getBackground());
        graphics.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arcs.width, arcs.height);
        graphics.setColor(getForeground());
        super.paintComponent(g);
    }
}
