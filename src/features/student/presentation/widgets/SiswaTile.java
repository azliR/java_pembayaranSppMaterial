package features.student.presentation.widgets;

import cores.styles.Colors;
import cores.styles.Constants;
import cores.styles.Fonts;
import cores.utils.ImageProcessor;
import cores.widgets.RoundedBorder;
import cores.widgets.RoundedPanel;
import features.student.data.entities.Siswa;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author a_lpha
 */
public class SiswaTile extends RoundedPanel {
    private static final long serialVersionUID = 1L;

    private final Siswa siswa;

    public SiswaTile(Siswa siswa) {
        super(Constants.MEDIUM_BORDER_RADIUS);
        this.siswa = siswa;
        initComponents();

        final int maxWidth = 140;
        final int maxHeight = 140;

        Image image = new ImageIcon(siswa.getFoto()).getImage();
        if (image.getWidth(null) > maxWidth || image.getHeight(null) > maxHeight) {
            image = ImageProcessor.scaleImage(image, maxWidth, maxHeight);
        }
        Image resizedImage = ImageProcessor.cropImage(
                ImageProcessor.toBufferedImage(new ImageIcon(image).getImage()),
                maxWidth,
                maxHeight);
        BufferedImage roundedImage = ImageProcessor.convertRoundedImage(
                resizedImage,
                Constants.MEDIUM_BORDER_RADIUS);

        tv_image.setIcon(new ImageIcon(roundedImage));
        tv_namaBarang.setText(siswa.getNama());
        tv_hargaBarang.setText(siswa.getNisn());
    }

    public void setSelected(boolean isSelected) {
        setBackground(isSelected ? Colors.BLUE_BACKGROUND_COLOR
                : Colors.CARD_COLOR);
        setBorder(new RoundedBorder(
                Constants.MEDIUM_BORDER_RADIUS,
                Constants.LIGHT_BORDER_INSETS,
                isSelected ? Colors.ACTIVE_BORDER_COLOR : Colors.BORDER_COLOR));
        tv_namaBarang.setForeground(isSelected ? Colors.ACTIVE_TEXT_COLOR
                : Colors.TEXT_COLOR);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tv_image = new javax.swing.JLabel();
        tv_namaBarang = new javax.swing.JLabel();
        tv_hargaBarang = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new RoundedBorder(
            Constants.MEDIUM_BORDER_RADIUS,
            Constants.LIGHT_BORDER_INSETS,
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

    tv_namaBarang.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(14f)
    );
    tv_namaBarang.setForeground(Colors.TEXT_COLOR);
    tv_namaBarang.setText("<html>Coca Cola Zero</html>");

    tv_hargaBarang.setFont(Fonts.PRODUCT_SANS_MEDIUM.deriveFont(18f)
    );
    tv_hargaBarang.setForeground(Colors.TEXT_COLOR);
    tv_hargaBarang.setText("Rp. 8.000");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(1, 1, 1)
            .addComponent(tv_image, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(tv_namaBarang)
                    .addContainerGap())
                .addGroup(layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(tv_hargaBarang)
                    .addContainerGap(143, Short.MAX_VALUE))))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(1, 1, 1)
            .addComponent(tv_image, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(1, 1, 1))
        .addGroup(layout.createSequentialGroup()
            .addGap(16, 16, 16)
            .addComponent(tv_namaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tv_hargaBarang)
            .addGap(30, 30, 30))
    );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        if (getBackground() != Colors.BLUE_BACKGROUND_COLOR) {
            setBorder(new RoundedBorder(
                    Constants.MEDIUM_BORDER_RADIUS,
                    Constants.LIGHT_BORDER_INSETS,
                    Colors.ACTIVE_BORDER_COLOR));
        }
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        if (getBackground() != Colors.BLUE_BACKGROUND_COLOR) {
            setBorder(new RoundedBorder(
                    Constants.MEDIUM_BORDER_RADIUS,
                    Constants.LIGHT_BORDER_INSETS,
                    Colors.BORDER_COLOR));
        }
    }//GEN-LAST:event_formMouseExited

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

    }//GEN-LAST:event_formMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel tv_hargaBarang;
    private javax.swing.JLabel tv_image;
    private javax.swing.JLabel tv_namaBarang;
    // End of variables declaration//GEN-END:variables
}
