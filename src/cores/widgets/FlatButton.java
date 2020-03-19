package cores.widgets;

import cores.styles.Constants;

/**
 *
 * @author rizal
 */
public class FlatButton extends RoundedButton {
    private static final long serialVersionUID = 1L;

    private final int borderRadius = Constants.MEDIUM_BORDER_RADIUS;

    public FlatButton() {
        super();
        init();
    }

    private void init() {
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setBackground(getBackground().darker());
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                setBackground(getBackground().brighter());
            }
        });
    }
}
