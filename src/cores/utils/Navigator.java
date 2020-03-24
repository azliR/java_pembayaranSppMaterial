package cores.utils;

import javax.swing.JPanel;
import main.MainFrame;

/**
 *
 * @author rizal
 */
public class Navigator {

    public static void push(JPanel page) {
        MainFrame.sideBar.setVisible(true);
        MainFrame.topBar.setVisible(true);
        MainFrame.content.removeAll();
        MainFrame.content.add(page);
        MainFrame.content.repaint();
        MainFrame.content.revalidate();
    }

    public static void push(JPanel page, boolean isTopBarVisible,
            boolean isSideBarVisibe) {
        MainFrame.sideBar.setVisible(isSideBarVisibe);
        MainFrame.topBar.setVisible(isTopBarVisible);
        MainFrame.sideBar.repaint();
        MainFrame.sideBar.revalidate();
        MainFrame.content.removeAll();
        MainFrame.content.add(page);
        MainFrame.content.repaint();
        MainFrame.content.revalidate();
    }

    private Navigator() {
    }
}
