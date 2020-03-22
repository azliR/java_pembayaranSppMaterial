package cores.widgets;

import cores.styles.Colors;
import cores.styles.Consts;
import cores.styles.Fonts;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.BeanProperty;
import javax.swing.BorderFactory;
import javax.swing.JPasswordField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author a_lpha
 */
public class PasswordField extends JPasswordField {
    private static final long serialVersionUID = 1L;

    private final Insets insets = new Insets(2, 8, 2, 8);
    private final Font font = Fonts.registerRobotoRegular(this.getClass());

    private String label;

    public PasswordField() {
        init();
    }

    public PasswordField(String label) {
        super();
        this.label = label;
        init();
    }

    private void init() {
        borderFocusLost();
        setFont(font.deriveFont(16f));
        setForeground(Colors.TEXT_COLOR);
        setCaretColor(Colors.TEXT_COLOR);
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
        final var oldValue = this.label;
        this.label = label;
        firePropertyChange("label", oldValue, label);
        borderFocusLost();
    }

    public String getLabel() {
        return label;
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
