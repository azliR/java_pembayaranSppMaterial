package features.petugas.presentation.widgets;

import cores.entities.Pembayaran;
import cores.styles.Colors;
import java.util.Date;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import main.MainFrame;

/**
 *
 * @author rizal
 */
public class ListPembayaranByDateTile extends javax.swing.JPanel {
    private static final long serialVersionUID = 1L;

    final List<Pembayaran> listPembayarans;
    final Date date;

    public ListPembayaranByDateTile(List<Pembayaran> listPembayarans, Date date) {
        this.listPembayarans = listPembayarans;
        this.date = date;
        initComponents();
        init();
    }

    private void init() {
        p_listTile.add(new DateTile(date));
        listPembayarans.forEach((pembayaran) -> {
            p_listTile.add(new PembayaranTile(pembayaran));
        });
        final var panel = new JPanel();
        panel.setSize(0, 16);
        p_listTile.add(panel);

        final var separator = new JSeparator();
        separator.setForeground(Colors.BORDER_COLOR);
        separator.setSize(MainFrame.content.getWidth(), 1);
        p_listTile.add(separator);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p_listTile = new javax.swing.JPanel();

        setBackground(Colors.BACKGROUND_COLOR);
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        p_listTile.setBackground(Colors.BACKGROUND_COLOR
        );
        p_listTile.setLayout(new java.awt.GridLayout(0, 1));
        add(p_listTile);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel p_listTile;
    // End of variables declaration//GEN-END:variables
}
