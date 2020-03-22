package cores.widgets;

import cores.styles.Colors;
import cores.styles.Consts;
import cores.styles.Fonts;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.BeanProperty;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author a_lpha
 */
public class TextField extends JTextField {
    private static final long serialVersionUID = 1L;

    private final Insets insets = new Insets(2, 8, 2, 8);
    private final Font font = Fonts.registerRobotoRegular(this.getClass());

    private String label = "Label";
    private int maxLength = Integer.MAX_VALUE;
    private boolean isDigitOnly = false;

    public TextField() {
        init();
    }

    public TextField(String label) {
        super();
        this.label = label;
        init();
    }

    private void init() {
        borderFocusLost();
        setFont(font.deriveFont(16f));
        setForeground(Colors.TEXT_COLOR);
        setCaretColor(Colors.TEXT_COLOR);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (getText().length() >= maxLength) {
                    e.consume();
                }
                if (isDigitOnly) {
                    char newChar = e.getKeyChar();
                    if (!(Character.isDigit(newChar))) {
                        e.consume();
                    }
                }
                super.keyTyped(e);
            }
        });
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent fe) {
                borderFocusGained();
            }

            @Override
            public void focusLost(FocusEvent fe) {
                borderFocusLost();
            }
        });
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    public void setLabel(String label) {
        this.label = label;
        final var oldValue = this.label;
        firePropertyChange("label", oldValue, label);
        borderFocusLost();
    }

    @BeanProperty(preferred = true, visualUpdate = false)
    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
        final var oldValue = this.maxLength;
        firePropertyChange("maxLength", oldValue, maxLength);
    }

    @BeanProperty(preferred = true, visualUpdate = false)
    public void setIsDigitOnly(boolean isDigitOnly) {
        this.isDigitOnly = isDigitOnly;
        final var oldValue = this.isDigitOnly;
        firePropertyChange("isDigitOnly", oldValue, isDigitOnly);
    }

    private void borderFocusGained() {
        setBorder(BorderFactory.createTitledBorder(
                new RoundedRectangleBorder(
                        Consts.BORDER_RADIUS,
                        insets,
                        Colors.ACTIVE_BORDER_COLOR),
                label,
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                font.deriveFont(12f),
                Colors.ACTIVE_TEXT_COLOR));
    }

    private void borderFocusLost() {
        setBorder(BorderFactory.createTitledBorder(
                new RoundedRectangleBorder(
                        Consts.BORDER_RADIUS,
                        insets,
                        Colors.BORDER_COLOR),
                label,
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                font.deriveFont(12f),
                Colors.LABEL_TEXT_FIELD_LOST_FOCUS_COLOR));
    }
}
