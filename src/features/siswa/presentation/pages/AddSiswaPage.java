package features.siswa.presentation.pages;

import cores.entities.Kelas;
import cores.entities.Siswa;
import cores.entities.Spp;
import cores.styles.Colors;
import cores.styles.Consts;
import cores.styles.Fonts;
import cores.styles.Strings;
import cores.utils.ImageProcessor;
import cores.utils.Navigator;
import features.siswa.data.repositories.SiswaRepository;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

/**
 *
 * @author rizal
 */
public class AddSiswaPage extends javax.swing.JPanel {
    private static final long serialVersionUID = 1L;

    private final SiswaRepository repository;

    public Siswa siswa;
    public byte[] foto;

    public AddSiswaPage(SiswaRepository repository, Siswa siswa) {
        this.repository = repository;
        this.siswa = siswa;
        initComponents();
        init();
    }

    public AddSiswaPage(SiswaRepository repository) {
        this.repository = repository;
        this.siswa = null;
        initComponents();
        init();
    }

    private void init() {
        initDropdownJenisKelamin();
        initDropdownKelas();
        initDropdownSpp();

        if (siswa != null) {
            if (siswa.getFoto() != null) {
                final var roundedImage = ImageProcessor.roundImage(ImageProcessor
                        .byteArrayToBufferedImage(siswa.getFoto()),
                        Consts.BORDER_RADIUS);
                foto = siswa.getFoto();
                b_addImage.setIcon(new ImageIcon(roundedImage));
                b_addImage.setText(null);
                b_addImage.setBorder(null);
            }
            et_namaSiswa.setText(siswa.getNama());
            et_nisn.setText(siswa.getNisn());
            et_nis.setText(siswa.getNis());
            et_noTelepon.setText(siswa.getNoTelepon());
            et_alamat.setText(siswa.getAlamat());
            cb_kelas.setSelectedItem(siswa.getIdKelas());
            cb_spp.setSelectedItem(siswa.getIdSpp());
            cb_jenisKelamin.setSelectedItem(siswa.getJenisKelamin());
            b_save.setText("Perbarui");
        }
    }

    private void initDropdownJenisKelamin() {
        final var result = new String[]{Strings.LAKI_LAKI, Strings.PEREMPUAN};
        if (result != null) {
            cb_jenisKelamin.setModel(new DefaultComboBoxModel<>(result));
        }
    }

    private void initDropdownKelas() {
        final var result = repository.getListKelas();
        if (result != null) {
            cb_kelas.setModel(new DefaultComboBoxModel<>(result
                    .toArray(new Kelas[result.size()])));
        }
    }

    private void initDropdownSpp() {
        final var result = repository.getListSpp();
        if (result != null) {
            cb_spp.setModel(new DefaultComboBoxModel<>(result
                    .toArray(new Spp[result.size()])));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        appbar = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        tv_title = new javax.swing.JLabel();
        b_back = new cores.widgets.MaterialButton();
        jScrollPane1 = new cores.widgets.ScrollView(jPanel2);
        jPanel2 = new javax.swing.JPanel();
        cb_kelas = new javax.swing.JComboBox<>();
        cb_spp = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cb_jenisKelamin = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        et_nisn = new cores.widgets.TextField();
        et_nis = new cores.widgets.TextField();
        et_namaSiswa = new cores.widgets.TextField();
        et_noTelepon = new cores.widgets.TextField();
        b_addImage = new cores.widgets.MaterialButton();
        b_save = new cores.widgets.MaterialButton();
        b_clear = new cores.widgets.MaterialButton();
        et_alamat = new cores.widgets.TextField();

        setBackground(Colors.BACKGROUND_COLOR);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        appbar.setBackground(Colors.BACKGROUND_COLOR);

        jSeparator1.setForeground(Colors.BORDER_COLOR);

        tv_title.setFont(Fonts.GOOGLE_SANS.deriveFont(16f)
        );
        tv_title.setText(siswa == null ? "Tambah Siswa" : "Edit Siswa");

        b_back.setBorderRadius(36);
        b_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/ic_arrow-left_grey.png"))); // NOI18N
        b_back.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/ic_arrow-left_black.png"))); // NOI18N
        b_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_backActionPerformed(evt);
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
                .addContainerGap(477, Short.MAX_VALUE))
        );
        appbarLayout.setVerticalGroup(
            appbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appbarLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(appbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tv_title, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_back, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jScrollPane1.setBackground(Colors.BACKGROUND_COLOR
        );
        jScrollPane1.setBorder(null);

        jPanel2.setBackground(Colors.BACKGROUND_COLOR
        );

        cb_kelas.setBackground(Colors.BACKGROUND_COLOR);
        cb_kelas.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(14f)
        );
        cb_kelas.setForeground(Colors.TEXT_COLOR);
        cb_kelas.setBorder(null);

        cb_spp.setBackground(Colors.BACKGROUND_COLOR);
        cb_spp.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(14f)
        );
        cb_spp.setForeground(Colors.TEXT_COLOR);
        cb_spp.setBorder(null);

        jLabel3.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(14f)
        );
        jLabel3.setForeground(Colors.GREY_TEXT_COLOR);
        jLabel3.setText("Kelas");

        jLabel4.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(14f)
        );
        jLabel4.setForeground(Colors.GREY_TEXT_COLOR);
        jLabel4.setText("Jenis Kelamin");

        cb_jenisKelamin.setBackground(Colors.BACKGROUND_COLOR);
        cb_jenisKelamin.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(14f)
        );
        cb_jenisKelamin.setForeground(Colors.TEXT_COLOR);
        cb_jenisKelamin.setBorder(null);

        jLabel2.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(14f)
        );
        jLabel2.setForeground(Colors.GREY_TEXT_COLOR);
        jLabel2.setText("Tipe SPP");

        jPanel1.setBackground(Colors.BACKGROUND_COLOR);
        jPanel1.setLayout(new java.awt.GridLayout(0, 2, 8, 6));

        et_nisn.setIsDigitOnly(true);
        et_nisn.setLabel("NISN");
        et_nisn.setMaxLength(10);
        jPanel1.add(et_nisn);

        et_nis.setIsDigitOnly(true);
        et_nis.setLabel("NIS");
        et_nis.setMaxLength(8);
        jPanel1.add(et_nis);

        et_namaSiswa.setLabel("Nama Siswa");
        et_namaSiswa.setMaxLength(36);
        jPanel1.add(et_namaSiswa);

        et_noTelepon.setIsDigitOnly(true);
        et_noTelepon.setLabel("No. Telepon");
        et_noTelepon.setMaxLength(13);
        jPanel1.add(et_noTelepon);

        b_addImage.setBorder(new cores.widgets.RoundedRectangleBorder());
        b_addImage.setText("Tambah Foto");
        b_addImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_addImageActionPerformed(evt);
            }
        });

        b_save.setBackground(Colors.PRIMARY_COLOR);
        b_save.setForeground(Colors.WHITE_TEXT_COLOR);
        b_save.setText("Simpan");
        b_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_saveActionPerformed(evt);
            }
        });

        b_clear.setBorder(new cores.widgets.RoundedRectangleBorder());
        b_clear.setText("Bersihkan");
        b_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_clearActionPerformed(evt);
            }
        });

        et_alamat.setLabel("Alamat");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(b_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(b_save, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(b_addImage, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cb_jenisKelamin, 0, 114, Short.MAX_VALUE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cb_kelas, 0, 116, Short.MAX_VALUE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cb_spp, 0, 115, Short.MAX_VALUE)
                                    .addComponent(jLabel2)))
                            .addComponent(et_alamat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(54, 54, 54))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b_addImage, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(et_alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_spp, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_kelas, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_jenisKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_save, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
            .addComponent(appbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(appbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        et_nisn.requestFocus();
    }//GEN-LAST:event_formComponentResized

    private void b_addImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_addImageActionPerformed
        final var result = repository.getImageFromDisk(144, 192);
        if (result != null) {
            b_addImage.setIcon(new ImageIcon(ImageProcessor.roundImage(result,
                    Consts.BORDER_RADIUS)));
            b_addImage.setText(null);
            b_addImage.setBorder(null);
            foto = ImageProcessor.toByteArray(result);
        }
    }//GEN-LAST:event_b_addImageActionPerformed

    private void b_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_backActionPerformed
        if (siswa == null) {
            Navigator.push(new ListSiswaPage(repository));
        } else {
            Navigator.push(new DetailSiswaPage(repository, siswa));
        }
    }//GEN-LAST:event_b_backActionPerformed

    private void b_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_saveActionPerformed
        repository.insertOrUpdateSiswa(this);
    }//GEN-LAST:event_b_saveActionPerformed

    private void b_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_clearActionPerformed
        repository.clear(this);
    }//GEN-LAST:event_b_clearActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel appbar;
    public cores.widgets.MaterialButton b_addImage;
    private cores.widgets.MaterialButton b_back;
    private cores.widgets.MaterialButton b_clear;
    private cores.widgets.MaterialButton b_save;
    public javax.swing.JComboBox<String> cb_jenisKelamin;
    public javax.swing.JComboBox<Kelas> cb_kelas;
    public javax.swing.JComboBox<Spp> cb_spp;
    public cores.widgets.TextField et_alamat;
    public cores.widgets.TextField et_namaSiswa;
    public cores.widgets.TextField et_nis;
    public cores.widgets.TextField et_nisn;
    public cores.widgets.TextField et_noTelepon;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel tv_title;
    // End of variables declaration//GEN-END:variables
}
