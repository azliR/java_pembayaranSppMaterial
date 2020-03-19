package features.petugas.presentation.pages;

import cores.entities.Petugas;
import cores.styles.Colors;
import cores.styles.Constants;
import cores.styles.Fonts;
import cores.styles.Strings;
import cores.utils.Navigator;
import cores.widgets.RoundedBorder;
import cores.widgets.RoundedButton;
import cores.widgets.a_PasswordField;
import cores.widgets.a_ScrollPane;
import cores.widgets.a_TextField;
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
        b_back = new RoundedButton(Constants.XLARGE_BORDER_RADIUS);
        tv_title = new javax.swing.JLabel();
        jScrollPane1 = new a_ScrollPane(jPanel2);
        jPanel2 = new javax.swing.JPanel();
        b_clear = new RoundedButton(Constants.BORDER_RADIUS);
        jLabel4 = new javax.swing.JLabel();
        b_save = new RoundedButton(Constants.BORDER_RADIUS);
        cb_jenisKelamin = new javax.swing.JComboBox<>();
        et_namaPetugas = new a_TextField(Strings.NAMA_LENGKAP);
        et_namaPengguna = new a_TextField(Strings.NAMA_PENGGUNA);
        et_kataSandi = new a_PasswordField(petugas == null ? Strings.KATA_SANDI : Strings.KATA_SANDI_LAMA);
        et_konfirmasiKataSandi = new a_PasswordField(petugas == null ? Strings.KONFIRMASI_KATA_SANDI : Strings.KATA_SANDI_BARU);

        setBackground(Colors.BACKGROUND_COLOR);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        appbar.setBackground(Colors.BACKGROUND_COLOR);

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
        tv_title.setText(petugas == null ? "Tambah Petugas" : "Edit Petugas");

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
                .addGroup(appbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_back, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tv_title, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jScrollPane1.setBackground(Colors.BACKGROUND_COLOR
        );
        jScrollPane1.setBorder(null);

        jPanel2.setBackground(Colors.BACKGROUND_COLOR
        );

        b_clear.setBackground(Colors.BACKGROUND_COLOR);
        b_clear.setFont(Fonts.PRODUCT_SANS_MEDIUM.deriveFont(14f)
        );
        b_clear.setForeground(Colors.TEXT_COLOR);
        b_clear.setText("Bersihkan");
        b_clear.setBorder(new RoundedBorder());
        b_clear.setContentAreaFilled(false);
        b_clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b_clear.setFocusPainted(false);
        b_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_clearActionPerformed(evt);
            }
        });

        jLabel4.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(14f)
        );
        jLabel4.setForeground(Colors.GREY_TEXT_COLOR);
        jLabel4.setText(Strings.HAK_AKSES);

        b_save.setBackground(Colors.PRIMARY_COLOR);
        b_save.setFont(Fonts.PRODUCT_SANS_MEDIUM.deriveFont(14f)
        );
        b_save.setForeground(Colors.WHITE_TEXT_COLOR);
        b_save.setText("Simpan");
        b_save.setBorder(null);
        b_save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b_save.setFocusPainted(false);
        b_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_saveActionPerformed(evt);
            }
        });

        cb_jenisKelamin.setBackground(Colors.BACKGROUND_COLOR);
        cb_jenisKelamin.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(14f)
        );
        cb_jenisKelamin.setForeground(Colors.TEXT_COLOR);
        cb_jenisKelamin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { Strings.PETUGAS, Strings.ADMINISTRATOR }));
        cb_jenisKelamin.setBorder(null);

        et_namaPetugas.setBackground(Colors.BACKGROUND_COLOR);
        et_namaPetugas.setFont(Fonts.ROBOTO_REGULAR.deriveFont(16f)
        );

        et_namaPengguna.setBackground(Colors.BACKGROUND_COLOR);
        et_namaPengguna.setFont(Fonts.ROBOTO_REGULAR.deriveFont(16f)
        );

        et_kataSandi.setBackground(Colors.BACKGROUND_COLOR);
        et_kataSandi.setFont(Fonts.ROBOTO_REGULAR.deriveFont(16f)
        );
        et_kataSandi.setText("Kata Sandi");

        et_konfirmasiKataSandi.setBackground(Colors.BACKGROUND_COLOR);
        et_konfirmasiKataSandi.setFont(Fonts.ROBOTO_REGULAR.deriveFont(16f)
        );
        et_konfirmasiKataSandi.setText("Kata Sandi");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(287, 287, 287)
                        .addComponent(b_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(b_save, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(et_namaPetugas, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                            .addComponent(et_namaPengguna)
                            .addComponent(et_kataSandi)
                            .addComponent(cb_jenisKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(et_konfirmasiKataSandi))
                        .addGap(0, 94, Short.MAX_VALUE)))
                .addGap(54, 54, 54))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(et_namaPetugas, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(et_namaPengguna, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(et_kataSandi, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(et_konfirmasiKataSandi, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_jenisKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_save, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
            .addComponent(appbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(appbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        et_namaPetugas.requestFocus();
    }//GEN-LAST:event_formComponentResized

    private void b_backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_backMouseEntered
        b_back.setBackground(Colors.GREY_BACKGROUND_COLOR);
    }//GEN-LAST:event_b_backMouseEntered

    private void b_backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_backMouseExited
        b_back.setBackground(Colors.BACKGROUND_COLOR);
    }//GEN-LAST:event_b_backMouseExited

    private void b_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_backActionPerformed
        Navigator.push(new ListPetugasPage(repository));
    }//GEN-LAST:event_b_backActionPerformed

    private void b_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_saveActionPerformed
        repository.insertOrUpdatePetugas(this);
    }//GEN-LAST:event_b_saveActionPerformed

    private void b_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_clearActionPerformed

    }//GEN-LAST:event_b_clearActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel appbar;
    private javax.swing.JButton b_back;
    private javax.swing.JButton b_clear;
    private javax.swing.JButton b_save;
    public javax.swing.JComboBox<String> cb_jenisKelamin;
    public javax.swing.JTextField et_kataSandi;
    public javax.swing.JTextField et_konfirmasiKataSandi;
    public javax.swing.JTextField et_namaPengguna;
    public javax.swing.JTextField et_namaPetugas;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel tv_title;
    // End of variables declaration//GEN-END:variables
}
