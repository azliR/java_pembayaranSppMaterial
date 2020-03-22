package features.petugas.presentation.pages;

import cores.entities.Petugas;
import cores.styles.Colors;
import cores.styles.Fonts;
import cores.styles.Strings;
import cores.utils.Navigator;
import features.petugas.data.repositories.PetugasRepository;

/**
 *
 * @author rizal
 */
public class AddPetugasPage extends javax.swing.JPanel {
    private static final long serialVersionUID = 1L;

    private final PetugasRepository repository;

    public Petugas petugas;

    public AddPetugasPage(PetugasRepository repository, Petugas petugas) {
        this.repository = repository;
        this.petugas = petugas;
        initComponents();
        init();
    }

    public AddPetugasPage(PetugasRepository repository) {
        this.repository = repository;
        this.petugas = null;
        initComponents();
        init();
    }

    private void init() {
        if (petugas != null) {
            et_namaPetugas.setText(petugas.getNamaPetugas());
            et_namaPengguna.setText(petugas.getNamaPengguna());
            cb_jenisKelamin.setSelectedItem(petugas.getHakAkses());
            b_save.setText("Perbarui");
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
        jLabel4 = new javax.swing.JLabel();
        cb_jenisKelamin = new javax.swing.JComboBox<>();
        b_save = new cores.widgets.MaterialButton();
        b_clear = new cores.widgets.MaterialButton();
        et_namaPetugas = new cores.widgets.TextField();
        et_namaPengguna = new cores.widgets.TextField();
        et_kataSandi = new cores.widgets.PasswordField();
        et_konfirmasiKataSandi = new cores.widgets.PasswordField();

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
        tv_title.setText(petugas == null ? "Tambah Petugas" : "Edit Petugas");

        b_back.setBorderRadius(36);
        b_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/ic_arrow-left_grey.png"))); // NOI18N
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        appbarLayout.setVerticalGroup(
            appbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appbarLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(appbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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

        jLabel4.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(14f)
        );
        jLabel4.setForeground(Colors.GREY_TEXT_COLOR);
        jLabel4.setText(Strings.HAK_AKSES);

        cb_jenisKelamin.setBackground(Colors.BACKGROUND_COLOR);
        cb_jenisKelamin.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(14f)
        );
        cb_jenisKelamin.setForeground(Colors.TEXT_COLOR);
        cb_jenisKelamin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { Strings.PETUGAS, Strings.ADMINISTRATOR }));
        cb_jenisKelamin.setBorder(null);

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

        et_namaPetugas.setLabel("Nama Petugas");
        et_namaPetugas.setMaxLength(36);

        et_namaPengguna.setLabel("Nama Pengguna");
        et_namaPengguna.setMaxLength(26);

        et_kataSandi.setLabel("Kata Sandi");

        et_konfirmasiKataSandi.setLabel("Konfirmasi Kata Sandi");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(b_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(b_save, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4)
                        .addComponent(cb_jenisKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(et_namaPetugas, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                        .addComponent(et_namaPengguna, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                        .addComponent(et_kataSandi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(et_konfirmasiKataSandi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 270, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(et_namaPetugas, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(et_namaPengguna, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(et_kataSandi, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(et_konfirmasiKataSandi, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_jenisKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jScrollPane1)
            .addComponent(appbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(appbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        et_namaPetugas.requestFocus();
    }//GEN-LAST:event_formComponentResized

    private void b_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_backActionPerformed
        Navigator.push(new ListPetugasPage(repository));
    }//GEN-LAST:event_b_backActionPerformed

    private void b_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_saveActionPerformed
        repository.insertOrUpdatePetugas(this);
    }//GEN-LAST:event_b_saveActionPerformed

    private void b_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_clearActionPerformed
        repository.clear(this);
    }//GEN-LAST:event_b_clearActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel appbar;
    private cores.widgets.MaterialButton b_back;
    private cores.widgets.MaterialButton b_clear;
    private cores.widgets.MaterialButton b_save;
    public javax.swing.JComboBox<String> cb_jenisKelamin;
    public cores.widgets.PasswordField et_kataSandi;
    public cores.widgets.PasswordField et_konfirmasiKataSandi;
    public cores.widgets.TextField et_namaPengguna;
    public cores.widgets.TextField et_namaPetugas;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel tv_title;
    // End of variables declaration//GEN-END:variables
}
