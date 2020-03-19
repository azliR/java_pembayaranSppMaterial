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
    private boolean isLastTile = false;

    public PembayaranTile(Pembayaran pembayaran) {
        this.pembayaran = pembayaran;
        initComponents();
        init();
    }

    private void init() {
        s_bottom.setForeground(isLastTile
                ? Colors.BACKGROUND_COLOR
                : Colors.BORDER_COLOR);
        s_last.setVisible(isLastTile);
        tv_namaSiswa.setText(pembayaran.getIdSiswa().getNama());
        tv_waktu.setText(new SimpleDateFormat("HH:mm")
                .format(pembayaran.getTanggalBayar()));
    }

    public void setLastTile(boolean isLastTile) {
        this.isLastTile = isLastTile;
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tv_namaSiswa = new javax.swing.JLabel();
        tv_waktu = new javax.swing.JLabel();
        s_top = new javax.swing.JSeparator();
        s_last = new javax.swing.JSeparator();
        s_bottom = new javax.swing.JSeparator();

        setBackground(Colors.BACKGROUND_COLOR);

        tv_namaSiswa.setFont(Fonts.ROBOTO_REGULAR.deriveFont(13f)
        );
        tv_namaSiswa.setForeground(Colors.GREY_TEXT_COLOR);
        tv_namaSiswa.setText("Rizal Hadiyansah");

        tv_waktu.setFont(Fonts.ROBOTO_REGULAR.deriveFont(13f)
        );
        tv_waktu.setForeground(Colors.GREY_TEXT_COLOR);
        tv_waktu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/ic_dot_grey_6px.png"))); // NOI18N
        tv_waktu.setText("10:24");
        tv_waktu.setIconTextGap(8);

        s_top.setForeground(Colors.BORDER_COLOR);
        s_top.setOrientation(javax.swing.SwingConstants.VERTICAL);

        s_last.setForeground(Colors.BORDER_COLOR);

        s_bottom.setForeground(Colors.BORDER_COLOR);
        s_bottom.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(s_last, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(s_bottom, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(s_top, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(tv_waktu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 215, Short.MAX_VALUE)
                        .addComponent(tv_namaSiswa)
                        .addGap(16, 16, 16))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tv_waktu, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(tv_namaSiswa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(s_top)
                        .addGap(0, 0, 0)
                        .addComponent(s_bottom)))
                .addComponent(s_last, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator s_bottom;
    private javax.swing.JSeparator s_last;
    private javax.swing.JSeparator s_top;
    private javax.swing.JLabel tv_namaSiswa;
    private javax.swing.JLabel tv_waktu;
    // End of variables declaration//GEN-END:variables
}
