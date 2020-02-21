package cores.widgets;

import cores.styles.Colors;
import cores.styles.Fonts;
import java.awt.Color;
import java.awt.Cursor;
import java.util.Collections;
import javax.swing.ButtonGroup;

/**
 *
 * @author a_lpha
 */
public class a_Chip extends RoundedButton {
    private static final long serialVersionUID = 1L;

    private final Color activeTextColor = Colors.ACTIVE_TEXT_COLOR;
    private final Color activeBackgroundColor = Colors.BLUE_BACKGROUND_COLOR;
    private final Color inactiveTextColor = Colors.GREY_TEXT_COLOR;
    private final Color inactiveBackgroundColor = Colors.BACKGROUND_COLOR;
    private final Color activeBorderColor = Colors.BLUE_BACKGROUND_COLOR;
    private final Color inactiveBorderColor = Colors.BORDER_COLOR;

    private final int[] insets = {9, 12, 9, 12};

    private final String label;
    private final ButtonGroup chipGroup;

    public a_Chip(String label, ButtonGroup chipGroup) {
        super(32);
        this.label = label;
        this.chipGroup = chipGroup;
        init();
    }

    private void init() {
        setSelected(this);
        setFont(Fonts.ROBOTO_MEDIUM.deriveFont(10f));
        setText(label.toUpperCase());
        setFocusPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setContentAreaFilled(false);

        addActionListener((e) -> {
            chipGroup.setSelected(getModel(), true);
            final var chips = Collections.list(chipGroup.getElements());

            chips.forEach((_chip) -> {
                setSelected((a_Chip) _chip);
            });
        });

    }

    public void setSelected(a_Chip chip) {
        chip.setBackground(chip.isSelected() ? activeBackgroundColor
                : inactiveBackgroundColor);
        chip.setForeground(chip.isSelected() ? activeTextColor
                : inactiveTextColor);
        chip.setBorder(new RoundedBorder(32, insets, chip.isSelected()
                ? activeBorderColor : inactiveBorderColor));
    }
}
