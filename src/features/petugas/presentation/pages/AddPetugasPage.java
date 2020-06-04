package features.petugas.presentation.pages;

import cores.entities.Petugas;
import cores.provider.SharedPreferences;
import cores.styles.Colors;
import cores.styles.Consts;
import cores.styles.Fonts;
import cores.styles.Strings;
import cores.utils.ImageProcessor;
import cores.utils.Navigator;
import features.petugas.data.repositories.PetugasRepository;
import javax.swing.ImageIcon;

/**
 *
 * @author rizal
 */
public class AddPetugasPage extends javax.swing.JPanel {
    private static final long serialVersionUID = 1L;

    private final PetugasRepository repository;
    private final SharedPreferences preferences;

    public final Petugas petugas;

    public AddPetugasPage(PetugasRepository repository,
            SharedPreferences preferences) {
        this.preferences = preferences;
        this.repository = repository;
        this.petugas = new Petugas();
        initComponents();
        init();
    }

    private void init() {
        tv_title.setText("Tambah Petugas");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p_appbar = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        tv_title = new javax.swing.JLabel();
        b_back = new cores.widgets.MaterialButton();
        jScrollPane1 = new cores.widgets.ScrollView(jPanel2);
        jPanel2 = new javax.swing.JPanel();
        tv_hakAkses = new javax.swing.JLabel();
        cb_hakAkses = new javax.swing.JComboBox<>();
        b_save = new cores.widgets.MaterialButton();
        b_clear = new cores.widgets.MaterialButton();
        b_addImage = new cores.widgets.MaterialButton();
        et_noTelepon = new cores.widgets.TextField();
        jPanel1 = new javax.swing.JPanel();
        et_namaPetugas = new cores.widgets.TextField();
        et_namaPengguna = new cores.widgets.TextField();
        p_ubahKataSandi = new javax.swing.JPanel();
        et_kataSandi = new cores.widgets.PasswordField();
        et_konfirmasiKataSandi = new cores.widgets.PasswordField();

        setBackground(Colors.BACKGROUND_COLOR);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        p_appbar.setBackground(Colors.BACKGROUND_COLOR);

        jSeparator1.setForeground(Colors.BORDER_COLOR);

        tv_title.setFont(Fonts.GOOGLE_SANS.deriveFont(16f)
        );
        tv_title.setText("Tambah Petugas");

        b_back.setBorderRadius(36);
        b_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/ic_arrow-left_grey.png"))); // NOI18N
        b_back.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/ic_arrow-left_black.png"))); // NOI18N
        b_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p_appbarLayout = new javax.swing.GroupLayout(p_appbar);
        p_appbar.setLayout(p_appbarLayout);
        p_appbarLayout.setHorizontalGroup(
            p_appbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(p_appbarLayout.createSequentialGroup()
                .addComponent(b_back, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(tv_title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        p_appbarLayout.setVerticalGroup(
            p_appbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_appbarLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(p_appbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tv_title, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_back, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jScrollPane1.setBackground(Colors.BACKGROUND_COLOR
        );
        jScrollPane1.setBorder(null);

        jPanel2.setBackground(Colors.BACKGROUND_COLOR
        );

        tv_hakAkses.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(14f)
        );
        tv_hakAkses.setForeground(Colors.GREY_TEXT_COLOR);
        tv_hakAkses.setText(Strings.HAK_AKSES);

        cb_hakAkses.setBackground(Colors.BACKGROUND_COLOR);
        cb_hakAkses.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(14f)
        );
        cb_hakAkses.setForeground(Colors.TEXT_COLOR);
        cb_hakAkses.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { Strings.PETUGAS, Strings.ADMINISTRATOR }));
        cb_hakAkses.setBorder(null);

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

        b_addImage.setBorder(new cores.widgets.RoundedRectangleBorder());
        b_addImage.setText("Tambah Foto");
        b_addImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_addImageActionPerformed(evt);
            }
        });

        et_noTelepon.setIsDigitOnly(true);
        et_noTelepon.setLabel("No. Telepon");
        et_noTelepon.setMaxLength(13);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridLayout(0, 2, 8, 16));

        et_namaPetugas.setLabel("Nama Petugas");
        et_namaPetugas.setMaxLength(36);
        jPanel1.add(et_namaPetugas);

        et_namaPengguna.setLabel("Nama Pengguna");
        et_namaPengguna.setMaxLength(26);
        jPanel1.add(et_namaPengguna);

        p_ubahKataSandi.setOpaque(false);
        p_ubahKataSandi.setLayout(new java.awt.GridLayout(0, 2, 16, 8));

        et_kataSandi.setLabel("Kata Sandi");
        p_ubahKataSandi.add(et_kataSandi);

        et_konfirmasiKataSandi.setLabel("Konfirmasi Kata Sandi");
        et_konfirmasiKataSandi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                et_konfirmasiKataSandiActionPerformed(evt);
            }
        });
        p_ubahKataSandi.add(et_konfirmasiKataSandi);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(b_save, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(b_addImage, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tv_hakAkses)
                                    .addComponent(cb_hakAkses, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 347, Short.MAX_VALUE))
                            .addComponent(p_ubahKataSandi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(et_noTelepon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(54, 54, 54))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(et_noTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(p_ubahKataSandi, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(b_addImage, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(tv_hakAkses)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_hakAkses, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_save, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(139, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
            .addComponent(p_appbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(p_appbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        et_namaPetugas.requestFocus();
    }//GEN-LAST:event_formComponentResized

    private void b_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_backActionPerformed
        Navigator.push(new ListPetugasPage(repository, preferences));
    }//GEN-LAST:event_b_backActionPerformed

    private void b_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_saveActionPerformed
        repository.insertPetugas(this);
    }//GEN-LAST:event_b_saveActionPerformed

    private void b_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_clearActionPerformed
        repository.clear(this);
    }//GEN-LAST:event_b_clearActionPerformed

    private void b_addImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_addImageActionPerformed
        final var result = repository.getImageFromDisk(144, 192);
        if (result != null) {
            b_addImage.setIcon(new ImageIcon(ImageProcessor.roundImage(result,
                    Consts.BORDER_RADIUS)));
            b_addImage.setText(null);
            b_addImage.setBorder(null);

            petugas.setFoto(ImageProcessor.toByteArray(result));
        }
    }//GEN-LAST:event_b_addImageActionPerformed

    private void et_konfirmasiKataSandiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_et_konfirmasiKataSandiActionPerformed
        b_save.doClick();
    }//GEN-LAST:event_et_konfirmasiKataSandiActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public cores.widgets.MaterialButton b_addImage;
    private cores.widgets.MaterialButton b_back;
    private cores.widgets.MaterialButton b_clear;
    private cores.widgets.MaterialButton b_save;
    public javax.swing.JComboBox<String> cb_hakAkses;
    public cores.widgets.PasswordField et_kataSandi;
    public cores.widgets.PasswordField et_konfirmasiKataSandi;
    public cores.widgets.TextField et_namaPengguna;
    public cores.widgets.TextField et_namaPetugas;
    public cores.widgets.TextField et_noTelepon;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel p_appbar;
    private javax.swing.JPanel p_ubahKataSandi;
    private javax.swing.JLabel tv_hakAkses;
    private javax.swing.JLabel tv_title;
    // End of variables declaration//GEN-END:variables
}
