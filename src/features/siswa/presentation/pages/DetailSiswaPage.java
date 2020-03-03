package features.siswa.presentation.pages;

import cores.entities.Siswa;
import cores.styles.Colors;
import cores.styles.Constants;
import cores.styles.Fonts;
import cores.utils.ImageProcessor;
import cores.utils.Intl;
import cores.utils.Navigator;
import cores.widgets.RoundedButton;
import cores.widgets.a_ScrollPane;
import features.siswa.data.repositories.SiswaRepository;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author rizal
 */
public class DetailSiswaPage extends javax.swing.JPanel {
    private static final long serialVersionUID = 1L;

    private final SiswaRepository repository;

    private final Siswa siswa;

    public DetailSiswaPage(SiswaRepository repository, Siswa siswa) {
        this.repository = repository;
        this.siswa = siswa;
        initComponents();
        init(siswa);
    }

    private void init(Siswa siswa) {
        if (siswa.getFoto() != null) {
            final var roundedImage = ImageProcessor.roundImage(ImageProcessor
                    .byteArrayToBufferedImage(siswa.getFoto()),
                    Constants.BORDER_RADIUS);
            tv_foto.setIcon(new ImageIcon(roundedImage));
        }
        tv_namaSiswa.setText(siswa.getNama());
        tv_nisn.setText(siswa.getNisn());
        tv_nis.setText(siswa.getNis());
        tv_kelas.setText(siswa.getIdKelas().toString());
        tv_noTelepon.setText(siswa.getNoTelepon());
        tv_jenisKelamin.setText(siswa.getJenisKelamin());
        tv_alamat.setText(siswa.getAlamat());
        tv_spp.setText(Intl.convertCurrency(siswa.getIdSpp()
                .getNominal()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        appbar = new javax.swing.JPanel();
        b_edit = new RoundedButton(Constants.XLARGE_BORDER_RADIUS);
        jSeparator1 = new javax.swing.JSeparator();
        b_back = new RoundedButton(Constants.XLARGE_BORDER_RADIUS);
        tv_title = new javax.swing.JLabel();
        b_delete = new RoundedButton(Constants.XLARGE_BORDER_RADIUS);
        jScrollPane1 = new a_ScrollPane(jPanel1);
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        tv_alamat = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        tv_spp = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        tv_foto = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tv_kelas = new javax.swing.JLabel();
        tv_namaSiswa = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        tv_nisn = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tv_nis = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        tv_noTelepon = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        tv_jenisKelamin = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();

        setBackground(Colors.BACKGROUND_COLOR);

        appbar.setBackground(Colors.BACKGROUND_COLOR);

        b_edit.setBackground(Colors.PRIMARY_COLOR);
        b_edit.setFont(Fonts.PRODUCT_SANS_MEDIUM.deriveFont(14f)
        );
        b_edit.setForeground(Colors.WHITE_TEXT_COLOR);
        b_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/ic_pencil-outline_white.png"))); // NOI18N
        b_edit.setText("Edit");
        b_edit.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 8, 0, 16));
        b_edit.setBorderPainted(false);
        b_edit.setContentAreaFilled(false);
        b_edit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b_edit.setFocusPainted(false);
        b_edit.setIconTextGap(8);
        b_edit.setMinimumSize(new java.awt.Dimension(120, 24));
        b_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_editActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(Colors.BORDER_COLOR);

        b_back.setBackground(Colors.BACKGROUND_COLOR);
        b_back.setFont(Fonts.PRODUCT_SANS_MEDIUM.deriveFont(14f)
        );
        b_back.setForeground(Colors.WHITE_TEXT_COLOR);
        b_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/ic_arrow-left_grey.png"))); // NOI18N
        b_back.setBorder(null);
        b_back.setBorderPainted(false);
        b_back.setContentAreaFilled(false);
        b_back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b_back.setFocusPainted(false);
        b_back.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/ic_arrow-left_black.png"))); // NOI18N
        b_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_backMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b_backMouseExited(evt);
            }
        });
        b_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_backActionPerformed(evt);
            }
        });

        tv_title.setFont(Fonts.GOOGLE_SANS.deriveFont(16f)
        );
        tv_title.setText("Detail Siswa");

        b_delete.setBackground(Color.RED);
        b_delete.setFont(Fonts.PRODUCT_SANS_MEDIUM.deriveFont(14f)
        );
        b_delete.setForeground(Colors.WHITE_TEXT_COLOR);
        b_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/ic_trash-can-outline_white.png"))); // NOI18N
        b_delete.setText("Hapus");
        b_delete.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 8, 0, 16));
        b_delete.setBorderPainted(false);
        b_delete.setContentAreaFilled(false);
        b_delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b_delete.setFocusPainted(false);
        b_delete.setIconTextGap(8);
        b_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout appbarLayout = new javax.swing.GroupLayout(appbar);
        appbar.setLayout(appbarLayout);
        appbarLayout.setHorizontalGroup(
            appbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(appbarLayout.createSequentialGroup()
                .addComponent(b_back, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(tv_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(b_delete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        appbarLayout.setVerticalGroup(
            appbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appbarLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(appbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_back, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tv_title, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jScrollPane1.setBackground(Colors.BACKGROUND_COLOR);
        jScrollPane1.setBorder(null);

        jPanel1.setBackground(Colors.BACKGROUND_COLOR);

        jLabel7.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(12f)
        );
        jLabel7.setForeground(Colors.GREY_TEXT_COLOR);
        jLabel7.setText("ALAMAT");

        tv_alamat.setFont(Fonts.ROBOTO_REGULAR.deriveFont(14f)
        );
        tv_alamat.setForeground(Colors.TEXT_COLOR);
        tv_alamat.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        tv_alamat.setText("Desa Nanggela");

        jSeparator7.setForeground(Colors.BORDER_COLOR);
        jSeparator7.setOpaque(true);

        jLabel8.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(12f)
        );
        jLabel8.setForeground(Colors.GREY_TEXT_COLOR);
        jLabel8.setText("SPP");

        tv_spp.setFont(Fonts.ROBOTO_REGULAR.deriveFont(14f)
        );
        tv_spp.setForeground(Colors.TEXT_COLOR);
        tv_spp.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        tv_spp.setText("Rp. 200.000");

        jSeparator8.setForeground(Colors.BORDER_COLOR);
        jSeparator8.setOpaque(true);

        jLabel9.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(12f)
        );
        jLabel9.setForeground(Colors.GREY_TEXT_COLOR);
        jLabel9.setText("KELAS");

        jLabel2.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(12f)
        );
        jLabel2.setForeground(Colors.GREY_TEXT_COLOR);
        jLabel2.setText("NAMA SISWA");

        tv_kelas.setFont(Fonts.ROBOTO_REGULAR.deriveFont(14f)
        );
        tv_kelas.setForeground(Colors.TEXT_COLOR);
        tv_kelas.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        tv_kelas.setText("XII RPL 2");

        tv_namaSiswa.setFont(Fonts.ROBOTO_REGULAR.deriveFont(14f)
        );
        tv_namaSiswa.setForeground(Colors.TEXT_COLOR);
        tv_namaSiswa.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        tv_namaSiswa.setText("Rizal Hadiyansah");

        jSeparator9.setForeground(Colors.BORDER_COLOR);
        jSeparator9.setOpaque(true);

        jSeparator2.setForeground(Colors.BORDER_COLOR);
        jSeparator2.setOpaque(true);

        jSeparator3.setForeground(Colors.BORDER_COLOR);
        jSeparator3.setOpaque(true);

        tv_nisn.setFont(Fonts.ROBOTO_REGULAR.deriveFont(14f)
        );
        tv_nisn.setForeground(Colors.TEXT_COLOR);
        tv_nisn.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        tv_nisn.setText("1265176810");

        jLabel3.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(12f)
        );
        jLabel3.setForeground(Colors.GREY_TEXT_COLOR);
        jLabel3.setText("NISN");

        jLabel4.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(12f)
        );
        jLabel4.setForeground(Colors.GREY_TEXT_COLOR);
        jLabel4.setText("NIS");

        tv_nis.setFont(Fonts.ROBOTO_REGULAR.deriveFont(14f)
        );
        tv_nis.setForeground(Colors.TEXT_COLOR);
        tv_nis.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        tv_nis.setText("99727262");

        jSeparator4.setForeground(Colors.BORDER_COLOR);
        jSeparator4.setOpaque(true);

        jLabel5.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(12f)
        );
        jLabel5.setForeground(Colors.GREY_TEXT_COLOR);
        jLabel5.setText("NO. TELEPON");

        tv_noTelepon.setFont(Fonts.ROBOTO_REGULAR.deriveFont(14f)
        );
        tv_noTelepon.setForeground(Colors.TEXT_COLOR);
        tv_noTelepon.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        tv_noTelepon.setText("089624422737");

        jSeparator5.setForeground(Colors.BORDER_COLOR);
        jSeparator5.setOpaque(true);

        jLabel6.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(12f)
        );
        jLabel6.setForeground(Colors.GREY_TEXT_COLOR);
        jLabel6.setText("JENIS KELAMIN");

        tv_jenisKelamin.setFont(Fonts.ROBOTO_REGULAR.deriveFont(14f)
        );
        tv_jenisKelamin.setForeground(Colors.TEXT_COLOR);
        tv_jenisKelamin.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        tv_jenisKelamin.setText("LAKI-LAKI");

        jSeparator6.setForeground(Colors.BORDER_COLOR);
        jSeparator6.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(tv_foto, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tv_namaSiswa))
                    .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tv_nisn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tv_nis))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tv_kelas))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tv_noTelepon))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tv_jenisKelamin))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tv_alamat))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tv_spp)))
                .addGap(128, 128, 128))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tv_namaSiswa))
                        .addGap(16, 16, 16)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tv_nisn))
                        .addGap(16, 16, 16)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tv_nis))
                        .addGap(16, 16, 16)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(tv_kelas))
                        .addGap(16, 16, 16)
                        .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tv_noTelepon))
                        .addGap(16, 16, 16)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tv_jenisKelamin))
                        .addGap(16, 16, 16)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(tv_alamat))
                        .addGap(16, 16, 16)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(tv_spp))
                        .addGap(16, 16, 16)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tv_foto, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(87, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
            .addComponent(appbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(appbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void b_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_editActionPerformed
        Navigator.push(new AddSiswaPage(repository, siswa));
    }//GEN-LAST:event_b_editActionPerformed

    private void b_backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_backMouseEntered
        b_back.setBackground(Colors.GREY_BACKGROUND_COLOR);
    }//GEN-LAST:event_b_backMouseEntered

    private void b_backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_backMouseExited
        b_back.setBackground(Colors.BACKGROUND_COLOR);
    }//GEN-LAST:event_b_backMouseExited

    private void b_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_backActionPerformed
        Navigator.push(new ListSiswaPage(repository));
    }//GEN-LAST:event_b_backActionPerformed

    private void b_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_deleteActionPerformed
        final var result = JOptionPane.showConfirmDialog(null, "Hapus "
                + siswa.getNama()
                + " dari database secara permanen? Tindakan ini tidak dapat diurungkan.",
                "Hapus data?", JOptionPane.YES_NO_OPTION);
        if (result == 0) {
            repository.deleteSiswa(siswa.getId());
            Navigator.push(new ListSiswaPage(repository));
        }
    }//GEN-LAST:event_b_deleteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel appbar;
    private javax.swing.JButton b_back;
    private javax.swing.JButton b_delete;
    private javax.swing.JButton b_edit;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel tv_alamat;
    private javax.swing.JLabel tv_foto;
    private javax.swing.JLabel tv_jenisKelamin;
    private javax.swing.JLabel tv_kelas;
    private javax.swing.JLabel tv_namaSiswa;
    private javax.swing.JLabel tv_nis;
    private javax.swing.JLabel tv_nisn;
    private javax.swing.JLabel tv_noTelepon;
    private javax.swing.JLabel tv_spp;
    private javax.swing.JLabel tv_title;
    // End of variables declaration//GEN-END:variables
}
