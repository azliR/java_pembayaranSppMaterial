package features.petugas.presentation.widgets;

import cores.entities.Pembayaran;
import cores.styles.Colors;
import cores.styles.Fonts;
import java.text.SimpleDateFormat;

/**
 *
 * @author rizal
 */
public class PembayaranTile extends javax.swing.JPanel {
    private static final long serialVersionUID = 1L;

    private final Pembayaran pembayaran;
    private final boolean isLastTile;

    public PembayaranTile(Pembayaran pembayaran) {
        this.pembayaran = pembayaran;
        this.isLastTile = false;
        initComponents();
        init();
    }

    public PembayaranTile(Pembayaran pembayaran, boolean isLastTile) {
        this.pembayaran = pembayaran;
        this.isLastTile = isLastTile;
        initComponents();
        init();
    }

    private void init() {
        s_main.setVisible(!isLastTile);
        s_last.setVisible(isLastTile);
        tv_namaSiswa.setText(pembayaran.getIdSiswa().getNama());
        tv_waktu.setText(new SimpleDateFormat("HH:mm")
                .format(pembayaran.getTanggalBayar()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tv_namaSiswa = new javax.swing.JLabel();
        tv_waktu = new javax.swing.JLabel();
        s_last = new javax.swing.JSeparator();
        s_main = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();

        setBackground(Colors.BACKGROUND_COLOR);

        tv_namaSiswa.setFont(Fonts.ROBOTO_REGULAR.deriveFont(13f)
        );
        tv_namaSiswa.setForeground(Colors.GREY_TEXT_COLOR);
        tv_namaSiswa.setText("Rizal Hadiyansah");

        tv_waktu.setFont(Fonts.ROBOTO_REGULAR.deriveFont(13f)
        );
        tv_waktu.setForeground(Colors.GREY_TEXT_COLOR);
        tv_waktu.setText("10:24");

        s_last.setForeground(Colors.BORDER_COLOR);
        s_last.setOrientation(javax.swing.SwingConstants.VERTICAL);

        s_main.setForeground(Colors.BORDER_COLOR);
        s_main.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator3.setForeground(Colors.BACKGROUND_COLOR);
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(s_main, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(s_last, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(tv_waktu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tv_namaSiswa)
                .addGap(16, 16, 16))
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(283, 283, 283))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tv_waktu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
            .addComponent(tv_namaSiswa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(s_last)
                .addGap(0, 0, 0)
                .addComponent(jSeparator3))
            .addComponent(s_main)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator s_last;
    private javax.swing.JSeparator s_main;
    private javax.swing.JLabel tv_namaSiswa;
    private javax.swing.JLabel tv_waktu;
    // End of variables declaration//GEN-END:variables
}
