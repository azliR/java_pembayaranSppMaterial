package cores.utils;

import javax.swing.JPanel;
import main.MainFrame;

/**
 *
 * @author rizal
 */
public class Navigator {

    public static void push(JPanel page) {
        MainFrame.content.removeAll();
        MainFrame.content.add(page);
        MainFrame.content.repaint();
        MainFrame.content.revalidate();
    }

    public static void push(JPanel content, JPanel page) {
        content.removeAll();
        content.add(page);
        content.repaint();
        content.revalidate();
    }

    public static void push(JPanel page, boolean isBarVisible) {
        MainFrame.sideBar.setVisible(isBarVisible);
        MainFrame.topBar.setVisible(isBarVisible);
        MainFrame.sideBar.repaint();
        MainFrame.sideBar.revalidate();
        MainFrame.content.removeAll();
        MainFrame.content.add(page);
        MainFrame.content.repaint();
        MainFrame.content.revalidate();
    }
}
