package features.petugas.presentation.widgets;

import cores.entities.Petugas;
import cores.styles.Colors;
import cores.styles.Fonts;
import cores.styles.Strings;
import cores.utils.ImageProcessor;
import cores.utils.Scalr;
import cores.widgets.RoundedPanel;
import features.petugas.presentation.pages.ListPetugasPage;
import java.awt.Color;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author rizal
 */
public class ListPetugasTile extends javax.swing.JPanel {
    private static final long serialVersionUID = 1L;

    private final Petugas petugas;
    private boolean isSelected = false;

    private final ListPetugasPage context;

    public ListPetugasTile(Petugas petugas, ListPetugasPage context) {
        this.context = context;
        this.petugas = petugas;
        initComponents();
        init();
    }

    private void init() {
        setFoto(petugas.getFoto());
        tv_namaPetugas.setText(petugas.getNamaPetugas());
        tv_namaPengguna.setText(petugas.getNamaPengguna());
        tv_hakAkses.setText(petugas.getHakAkses());
        tv_status.setText(petugas.getStatus());
        tv_status.setIcon(new ImageIcon(getClass().getResource(
                Strings.DATABASE_SEDANG_AKTIF.equals(petugas.getStatus())
                ? "/assets/images/ic_dot_green_8px.png"
                : "/assets/images/ic_dot_red_8px.png")));
    }

    public void setFoto(byte[] foto) {
        if (foto == null) {
            final var random = new Random();
            final var red = random.nextInt(256);
            final var green = random.nextInt(256);
            final var blue = random.nextInt(256);
            final var color = new Color(red, green, blue);
            jPanel1.setBackground(color.darker());
            tv_foto.setText(String.valueOf(petugas.getNamaPetugas().charAt(0))
                    .toUpperCase());
            return;
        }
        final var maxWidth = 34;
        final var maxHeight = 34;

        var image = ImageProcessor.byteArrayToBufferedImage(foto);
        if (image.getWidth(null) > maxWidth || image.getHeight(null) > maxHeight) {
            image = Scalr.resize(image, Scalr.Mode.FIT_TO_WIDTH, maxWidth,
                    maxHeight);
        }
        final var croppedImage = Scalr.crop(image, maxWidth, maxHeight);
        final var roundedImage = ImageProcessor.roundImage(croppedImage,
                maxWidth);

        tv_foto.setIcon(new ImageIcon(roundedImage));
        petugas.setFoto(foto);
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;

        if (isSelected) {
            setBackground(Colors.BLUE_BACKGROUND_COLOR);
            tv_namaPetugas.setForeground(Colors.ACTIVE_TEXT_COLOR);
            tv_namaPengguna.setForeground(Colors.ACTIVE_TEXT_COLOR);
            tv_hakAkses.setForeground(Colors.ACTIVE_TEXT_COLOR);
            tv_status.setForeground(Colors.ACTIVE_TEXT_COLOR);
        } else {
            setBackground(Colors.BACKGROUND_COLOR);
            tv_namaPetugas.setForeground(Colors.TEXT_COLOR);
            tv_namaPengguna.setForeground(Colors.GREY_TEXT_COLOR);
            tv_hakAkses.setForeground(Colors.GREY_TEXT_COLOR);
            tv_status.setForeground(Colors.GREY_TEXT_COLOR);
        }
    }

    public boolean isSelected() {
        return isSelected;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tv_namaPetugas = new javax.swing.JLabel();
        tv_namaPengguna = new javax.swing.JLabel();
        tv_hakAkses = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        tv_status = new javax.swing.JLabel();
        jPanel1 = new RoundedPanel(36);
        tv_foto = new javax.swing.JLabel();

        setBackground(Colors.BACKGROUND_COLOR);
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

        tv_namaPetugas.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(13f)
        );
        tv_namaPetugas.setForeground(Colors.TEXT_COLOR);
        tv_namaPetugas.setText("Rizal Hadiyansah");
        tv_namaPetugas.setIconTextGap(12);

        tv_namaPengguna.setFont(Fonts.ROBOTO_REGULAR.deriveFont(13f)
        );
        tv_namaPengguna.setForeground(Colors.GREY_TEXT_COLOR);
        tv_namaPengguna.setText("a_lpha");

        tv_hakAkses.setFont(Fonts.ROBOTO_REGULAR.deriveFont(13f)
        );
        tv_hakAkses.setForeground(Colors.GREY_TEXT_COLOR);
        tv_hakAkses.setText("Administrator");

        jSeparator1.setForeground(Colors.BORDER_COLOR);

        tv_status.setFont(Fonts.ROBOTO_REGULAR.deriveFont(13f)
        );
        tv_status.setForeground(Colors.GREY_TEXT_COLOR);
        tv_status.setText("Sedang Aktif");
        tv_status.setIconTextGap(8);

        jPanel1.setLayout(new java.awt.CardLayout());

        tv_foto.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(16f)
        );
        tv_foto.setForeground(Colors.WHITE_TEXT_COLOR);
        tv_foto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(tv_foto, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(tv_namaPetugas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(16, 16, 16)
                .addComponent(tv_namaPengguna, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(16, 16, 16)
                .addComponent(tv_hakAkses, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(16, 16, 16)
                .addComponent(tv_status, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tv_hakAkses, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tv_namaPetugas, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tv_namaPengguna, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tv_status, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        setBackground(isSelected
                ? Colors.BLUE_BACKGROUND_COLOR
                : Colors.GREY_BACKGROUND_COLOR);
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        setBackground(isSelected
                ? Colors.BLUE_BACKGROUND_COLOR
                : Colors.BACKGROUND_COLOR);
    }//GEN-LAST:event_formMouseExited

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        context.showSidebar(this, petugas);
    }//GEN-LAST:event_formMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel tv_foto;
    private javax.swing.JLabel tv_hakAkses;
    private javax.swing.JLabel tv_namaPengguna;
    private javax.swing.JLabel tv_namaPetugas;
    public javax.swing.JLabel tv_status;
    // End of variables declaration//GEN-END:variables
}
