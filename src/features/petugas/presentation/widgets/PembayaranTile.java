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

    public PembayaranTile(Pembayaran pembayaran) {
        this.pembayaran = pembayaran;
        initComponents();
        init();
    }

    private void init() {
        tv_namaSiswa.setText(pembayaran.getIdSiswa().getNama());
        tv_waktu.setText(new SimpleDateFormat("HH:mm")
                .format(pembayaran.getTanggalBayar()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tv_namaSiswa = new javax.swing.JLabel();
        tv_waktu = new javax.swing.JLabel();

        setBackground(Colors.BACKGROUND_COLOR);

        tv_namaSiswa.setFont(Fonts.ROBOTO_REGULAR.deriveFont(13f)
        );
        tv_namaSiswa.setForeground(Colors.GREY_TEXT_COLOR);
        tv_namaSiswa.setText("Rizal Hadiyansah");

        tv_waktu.setFont(Fonts.ROBOTO_REGULAR.deriveFont(13f)
        );
        tv_waktu.setForeground(Colors.GREY_TEXT_COLOR);
        tv_waktu.setText("10:24");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(tv_namaSiswa, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tv_waktu)
                .addGap(8, 8, 8))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tv_namaSiswa)
                    .addComponent(tv_waktu))
                .addGap(8, 8, 8))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel tv_namaSiswa;
    private javax.swing.JLabel tv_waktu;
    // End of variables declaration//GEN-END:variables
}
