package features.siswa.presentation.widgets;

import cores.entities.Siswa;
import cores.styles.Colors;
import cores.styles.Constants;
import cores.styles.Fonts;
import cores.utils.ImageProcessor;
import cores.utils.Scalr;
import cores.widgets.RoundedBorder;
import cores.widgets.RoundedPanel;
import features.siswa.data.repositories.SiswaRepository;
import java.awt.image.BufferedImageOp;
import javax.swing.ImageIcon;

/**
 *
 * @author a_lpha
 */
public class SiswaTile extends RoundedPanel {
    private static final long serialVersionUID = 1L;

    private final SiswaRepository repository;
    public final Siswa siswa;

    public SiswaTile(SiswaRepository repository,
            Siswa siswa) {
        super(Constants.MEDIUM_BORDER_RADIUS);
        this.repository = repository;
        this.siswa = siswa;
        initComponents();
        init();
    }

    private void init() {
        if (siswa.getFoto() != null) {
            setFoto(siswa.getFoto());
        }
        tv_namaSiswa.setText("<html>" + siswa.getNama() + "</html>");
        tv_nisn.setText(siswa.getNisn());
        tv_bulanIni.setText(siswa.getSppBulanIni());
    }

    public void setFoto(byte[] foto) {
        final var maxWidth = 120;
        final var maxHeight = 120;

        var image = ImageProcessor.byteArrayToBufferedImage(foto);
        if (image.getWidth(null) > maxWidth
                || image.getHeight(null) > maxHeight) {
            image = Scalr.resize(image, Scalr.Mode.FIT_TO_WIDTH, maxWidth,
                    maxHeight, (BufferedImageOp) null);
        }
        final var croppedImage = Scalr.crop(image, maxWidth, maxHeight,
                (BufferedImageOp) null);
        final var roundedImage = ImageProcessor.roundImage(
                croppedImage, Constants.MEDIUM_BORDER_RADIUS);

        tv_image.setIcon(new ImageIcon(roundedImage));
    }

    public void setSelected(boolean isSelected) {
        setBackground(isSelected ? Colors.BLUE_BACKGROUND_COLOR
                : Colors.CARD_COLOR);
        setBorder(new RoundedBorder(
                Constants.MEDIUM_BORDER_RADIUS,
                Constants.ALL_4_BORDER_INSETS,
                isSelected ? Colors.ACTIVE_BORDER_COLOR : Colors.BORDER_COLOR));
        tv_namaSiswa.setForeground(isSelected ? Colors.ACTIVE_TEXT_COLOR
                : Colors.TEXT_COLOR);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tv_image = new javax.swing.JLabel();
        tv_namaSiswa = new javax.swing.JLabel();
        tv_nisn = new javax.swing.JLabel();
        jTextView = new javax.swing.JLabel();
        tv_bulanIni = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new RoundedBorder(
            Constants.MEDIUM_BORDER_RADIUS,
            Constants.ALL_4_BORDER_INSETS,
            Colors.BORDER_COLOR));
    setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            formMouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            formMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            formMouseExited(evt);
        }
    });

    tv_image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    tv_image.setIconTextGap(0);
    tv_image.setMaximumSize(new java.awt.Dimension(260, 140));

    tv_namaSiswa.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(16f)
    );
    tv_namaSiswa.setForeground(Colors.TEXT_COLOR);
    tv_namaSiswa.setText("Rizal Hadiyansah");

    tv_nisn.setFont(Fonts.ROBOTO_REGULAR.deriveFont(14f)
    );
    tv_nisn.setForeground(Colors.TEXT_COLOR);
    tv_nisn.setText("121286271871");

    jTextView.setFont(Fonts.ROBOTO_REGULAR.deriveFont(14f)
    );
    jTextView.setForeground(Colors.TEXT_COLOR);
    jTextView.setText("Bulan ini:");

    tv_bulanIni.setFont(Fonts.ROBOTO_REGULAR.deriveFont(14f)
    );
    tv_bulanIni.setForeground(Colors.TEXT_COLOR);
    tv_bulanIni.setText("Belum Dibayar");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(tv_image, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(16, 16, 16)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tv_nisn)
                .addComponent(tv_namaSiswa)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jTextView)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(tv_bulanIni)))
            .addContainerGap(241, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(12, 12, 12)
            .addComponent(tv_namaSiswa)
            .addGap(8, 8, 8)
            .addComponent(tv_nisn)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jTextView)
                .addComponent(tv_bulanIni))
            .addGap(20, 20, 20))
        .addGroup(layout.createSequentialGroup()
            .addComponent(tv_image, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
    );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        if (getBackground() != Colors.BLUE_BACKGROUND_COLOR) {
            setBorder(new RoundedBorder(
                    Constants.MEDIUM_BORDER_RADIUS,
                    Constants.ALL_4_BORDER_INSETS,
                    Colors.ACTIVE_BORDER_COLOR));
        }
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        if (getBackground() != Colors.BLUE_BACKGROUND_COLOR) {
            setBorder(new RoundedBorder(
                    Constants.MEDIUM_BORDER_RADIUS,
                    Constants.ALL_4_BORDER_INSETS,
                    Colors.BORDER_COLOR));
        }
    }//GEN-LAST:event_formMouseExited

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        repository.initDetailSiswa(siswa.getNisn());
    }//GEN-LAST:event_formMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jTextView;
    private javax.swing.JLabel tv_bulanIni;
    public javax.swing.JLabel tv_image;
    private javax.swing.JLabel tv_namaSiswa;
    private javax.swing.JLabel tv_nisn;
    // End of variables declaration//GEN-END:variables
}
