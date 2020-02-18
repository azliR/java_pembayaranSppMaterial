package cores.utils;

import cores.styles.Strings;
import javax.swing.JOptionPane;

/**
 *
 * @author rizal
 */
public class AlertDialog {

    public static void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(
                null,
                message,
                Strings.ERROR_DIALOG_DEFAULT_TITLE,
                JOptionPane.ERROR_MESSAGE
        );
    }

    public static void showDialog(String title, String message) {
        JOptionPane.showMessageDialog(
                null,
                message,
                title,
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    private AlertDialog() {
    }
}
