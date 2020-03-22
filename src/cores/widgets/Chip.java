package cores.widgets;

import cores.styles.Colors;
import cores.styles.Fonts;
import java.awt.Cursor;
import java.awt.Insets;
import java.util.Collections;
import javax.swing.ButtonGroup;

/**
 *
 * @author a_lpha
 */
public class Chip extends MaterialButton {
    private static final long serialVersionUID = 1L;

    private final Insets insets = new Insets(9, 12, 9, 12);

    private final String label;
    private final ButtonGroup chipGroup;

    public Chip(String label, ButtonGroup chipGroup) {
        super();
        this.label = label;
        this.chipGroup = chipGroup;
        init();
    }

    private void init() {
        setBorderRadius(32);
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
                setSelected((Chip) _chip);
            });
        });

    }

    public void setSelected(Chip chip) {
        chip.setBackground(chip.isSelected()
                ? Colors.BLUE_BACKGROUND_COLOR
                : Colors.BACKGROUND_COLOR);
        chip.setForeground(chip.isSelected()
                ? Colors.ACTIVE_TEXT_COLOR
                : Colors.GREY_TEXT_COLOR);
        chip.setBorder(new RoundedRectangleBorder(32, insets, chip.isSelected()
                ? Colors.BLUE_BACKGROUND_COLOR
                : Colors.BORDER_COLOR));
    }
}
