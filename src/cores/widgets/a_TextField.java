package cores.widgets;

import cores.styles.Colors;
import cores.styles.Fonts;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author a_lpha
 */
public class a_TextField extends JTextField {
    private static final long serialVersionUID = 1L;

    private final Color focusGainedColor = Colors.ACTIVE_BORDER_COLOR;
    private final Color focusLostColor = Colors.BORDER_COLOR;
    private final Color focusLostTextColor = new Color(128, 134, 139);
    private final int borderRadius = 8;
    private final int inset[] = {2, 8, 2, 8};

    private final String label;

    public a_TextField(String label) {
        super();
        this.label = label;
        init();
    }

    private void init() {
        borderFocusLost();
        setFont(Fonts.ROBOTO_REGULAR.deriveFont(16f));
        setForeground(new Color(0, 0, 0));
        setCaretColor(new Color(0, 0, 0));
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

    private void borderFocusGained() {
        setBorder(BorderFactory.createTitledBorder(new RoundedBorder(
                borderRadius, inset, focusGainedColor),
                label, TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION, Fonts.ROBOTO_REGULAR.deriveFont(
                        12f), focusGainedColor));
    }

    private void borderFocusLost() {
        setBorder(BorderFactory.createTitledBorder(new RoundedBorder(
                borderRadius, inset, focusLostColor),
                label, TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION, Fonts.ROBOTO_REGULAR.deriveFont(
                        12f), focusLostTextColor));
    }
}
