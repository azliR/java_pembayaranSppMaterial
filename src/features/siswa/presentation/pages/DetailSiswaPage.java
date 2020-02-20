package features.siswa.presentation.pages;

import cores.entities.Siswa;
import cores.styles.Colors;
import cores.styles.Constants;
import cores.styles.Fonts;
import cores.utils.ImageProcessor;
import cores.utils.Intl;
import javax.swing.ImageIcon;

/**
 *
 * @author rizal
 */
public class DetailSiswaPage extends javax.swing.JPanel {
    private static final long serialVersionUID = 1L;

    public final Siswa siswa;

    public DetailSiswaPage(Siswa siswa) {
        this.siswa = siswa;
        initComponents();
        init(siswa);
    }

    private void init(Siswa siswa) {
        final var roundedImage = ImageProcessor.roundImage(ImageProcessor
                .byteArrayToBufferedImage(siswa.getFoto()),
                Constants.BORDER_RADIUS);

        tv_foto.setIcon(new ImageIcon(roundedImage));
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

        tv_foto = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tv_namaSiswa = new javax.swing.JLabel();
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
        jLabel7 = new javax.swing.JLabel();
        tv_alamat = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        tv_spp = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        tv_kelas = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();

        setBackground(Colors.BACKGROUND_COLOR);

        jLabel2.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(11f)
        );
        jLabel2.setForeground(Colors.GREY_TEXT_COLOR);
        jLabel2.setText("NAMA SISWA");

        tv_namaSiswa.setFont(Fonts.ROBOTO_REGULAR.deriveFont(14f)
        );
        tv_namaSiswa.setForeground(Colors.TEXT_COLOR);
        tv_namaSiswa.setText("Rizal Hadiyansah");

        jSeparator2.setForeground(Colors.BORDER_COLOR);
        jSeparator2.setOpaque(true);

        jSeparator3.setForeground(Colors.BORDER_COLOR);
        jSeparator3.setOpaque(true);

        tv_nisn.setFont(Fonts.ROBOTO_REGULAR.deriveFont(14f)
        );
        tv_nisn.setForeground(Colors.TEXT_COLOR);
        tv_nisn.setText("1265176810");

        jLabel3.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(11f)
        );
        jLabel3.setForeground(Colors.GREY_TEXT_COLOR);
        jLabel3.setText("NISN");

        jLabel4.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(11f)
        );
        jLabel4.setForeground(Colors.GREY_TEXT_COLOR);
        jLabel4.setText("NIS");

        tv_nis.setFont(Fonts.ROBOTO_REGULAR.deriveFont(14f)
        );
        tv_nis.setForeground(Colors.TEXT_COLOR);
        tv_nis.setText("99727262");

        jSeparator4.setForeground(Colors.BORDER_COLOR);
        jSeparator4.setOpaque(true);

        jLabel5.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(11f)
        );
        jLabel5.setForeground(Colors.GREY_TEXT_COLOR);
        jLabel5.setText("NO. TELEPON");

        tv_noTelepon.setFont(Fonts.ROBOTO_REGULAR.deriveFont(14f)
        );
        tv_noTelepon.setForeground(Colors.TEXT_COLOR);
        tv_noTelepon.setText("089624422737");

        jSeparator5.setForeground(Colors.BORDER_COLOR);
        jSeparator5.setOpaque(true);

        jLabel6.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(11f)
        );
        jLabel6.setForeground(Colors.GREY_TEXT_COLOR);
        jLabel6.setText("JENIS KELAMIN");

        tv_jenisKelamin.setFont(Fonts.ROBOTO_REGULAR.deriveFont(14f)
        );
        tv_jenisKelamin.setForeground(Colors.TEXT_COLOR);
        tv_jenisKelamin.setText("LAKI-LAKI");

        jSeparator6.setForeground(Colors.BORDER_COLOR);
        jSeparator6.setOpaque(true);

        jLabel7.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(11f)
        );
        jLabel7.setForeground(Colors.GREY_TEXT_COLOR);
        jLabel7.setText("ALAMAT");

        tv_alamat.setFont(Fonts.ROBOTO_REGULAR.deriveFont(14f)
        );
        tv_alamat.setForeground(Colors.TEXT_COLOR);
        tv_alamat.setText("Desa Nanggela");

        jSeparator7.setForeground(Colors.BORDER_COLOR);
        jSeparator7.setOpaque(true);

        jLabel8.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(11f)
        );
        jLabel8.setForeground(Colors.GREY_TEXT_COLOR);
        jLabel8.setText("SPP");

        tv_spp.setFont(Fonts.ROBOTO_REGULAR.deriveFont(14f)
        );
        tv_spp.setForeground(Colors.TEXT_COLOR);
        tv_spp.setText("Rp. 200.000");

        jSeparator8.setForeground(Colors.BORDER_COLOR);
        jSeparator8.setOpaque(true);

        jLabel9.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(11f)
        );
        jLabel9.setForeground(Colors.GREY_TEXT_COLOR);
        jLabel9.setText("KELAS");

        tv_kelas.setFont(Fonts.ROBOTO_REGULAR.deriveFont(14f)
        );
        tv_kelas.setForeground(Colors.TEXT_COLOR);
        tv_kelas.setText("XII RPL 2");

        jSeparator9.setForeground(Colors.BORDER_COLOR);
        jSeparator9.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(tv_foto, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tv_namaSiswa, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                    .addComponent(tv_nisn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tv_nis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tv_noTelepon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tv_jenisKelamin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tv_alamat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tv_spp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tv_kelas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(8, 8, 8)
                        .addComponent(tv_namaSiswa)
                        .addGap(14, 14, 14)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3)
                        .addGap(8, 8, 8)
                        .addComponent(tv_nisn)
                        .addGap(14, 14, 14)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4)
                        .addGap(8, 8, 8)
                        .addComponent(tv_nis)
                        .addGap(14, 14, 14)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel9)
                        .addGap(8, 8, 8)
                        .addComponent(tv_kelas)
                        .addGap(14, 14, 14)
                        .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel5)
                        .addGap(8, 8, 8)
                        .addComponent(tv_noTelepon)
                        .addGap(14, 14, 14)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel6)
                        .addGap(8, 8, 8)
                        .addComponent(tv_jenisKelamin)
                        .addGap(14, 14, 14)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel7)
                        .addGap(8, 8, 8)
                        .addComponent(tv_alamat)
                        .addGap(14, 14, 14)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel8)
                        .addGap(8, 8, 8)
                        .addComponent(tv_spp)
                        .addGap(14, 14, 14)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tv_foto, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
    // End of variables declaration//GEN-END:variables
}
