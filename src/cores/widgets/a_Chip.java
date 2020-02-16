package cores.widgets;

import cores.styles.Colors;
import cores.styles.Fonts;
import java.awt.Color;
import java.awt.Cursor;

/**
 *
 * @author a_lpha
 */
public class a_Chip extends RoundedButton {

    private final Color activeTextColor = Colors.ACTIVE_TEXT_COLOR;
    private final Color activeBackgroundColor = Colors.BLUE_BACKGROUND_COLOR;
    private final Color inactiveTextColor = Colors.GREY_TEXT_COLOR;
    private final Color inactiveBackgroundColor = Colors.BACKGROUND_COLOR;
    private final Color activeBorderColor = Colors.ACTIVE_BORDER_COLOR;
    private final Color inactiveBorderColor = Colors.BORDER_COLOR;

    private final int[] insets = {9, 12, 9, 12};

    public a_Chip(String text) {
        super(32);
        setFont(Fonts.ROBOTO_MEDIUM.deriveFont(10f));
        setBackground(isSelected() ? activeBackgroundColor : inactiveBackgroundColor);
        setForeground(isSelected() ? activeTextColor : inactiveTextColor);
        setText(text.toUpperCase());
        setBorder(new RoundedBorder(32, insets, isSelected() ? activeBorderColor : inactiveBorderColor));
        setFocusPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setContentAreaFilled(false);
    }
}
