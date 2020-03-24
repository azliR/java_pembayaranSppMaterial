package features.petugas.presentation.pages;

import cores.entities.Petugas;
import cores.provider.SharedPreferences;
import cores.styles.Colors;
import cores.styles.Consts;
import cores.styles.Fonts;
import cores.utils.Navigator;
import cores.widgets.RoundedPanel;
import features.petugas.data.repositories.PetugasRepository;

/**
 *
 * @author rizal
 */
public class EditPetugasPasswordPage extends javax.swing.JPanel {
    private static final long serialVersionUID = 1L;

    private final PetugasRepository repository;
    private final SharedPreferences preferences;
    public final Petugas petugas;

    public EditPetugasPasswordPage(PetugasRepository repository,
            SharedPreferences preferences, Petugas petugas) {
        this.repository = repository;
        this.preferences = preferences;
        this.petugas = petugas;
        initComponents();
        init();
    }

    private void init() {
        if (preferences.isAdministrator()) {
            et_kataSandiLama.setLabel("Kata Sandi Akun Anda");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tv_title = new javax.swing.JLabel();
        b_back = new cores.widgets.MaterialButton();
        p_ubahKataSandi = new RoundedPanel(Consts.MEDIUM_BORDER_RADIUS);
        et_kataSandiLama = new cores.widgets.PasswordField();
        et_kataSandiBaru = new cores.widgets.PasswordField();
        b_save = new cores.widgets.MaterialButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 24));

        jPanel1.setBackground(Colors.BACKGROUND_COLOR);

        jLabel1.setFont(Fonts.ROBOTO_REGULAR.deriveFont(14f)
        );
        jLabel1.setForeground(Colors.GREY_TEXT_COLOR);
        jLabel1.setText("Untuk keamanan, pilih sandi yang kuat dan jangan gunakan lagi untuk akun lain.");

        tv_title.setFont(Fonts.PRODUCT_SANS_REGULAR.deriveFont(21f)
        );
        tv_title.setForeground(Colors.TEXT_COLOR);
        tv_title.setText("Ubah Sandi");

        b_back.setBorderRadius(36);
        b_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/ic_arrow-left_grey.png"))); // NOI18N
        b_back.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/ic_arrow-left_black.png"))); // NOI18N
        b_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_backActionPerformed(evt);
            }
        });

        p_ubahKataSandi.setBackground(Colors.BACKGROUND_COLOR);
        p_ubahKataSandi.setBorder(new cores.widgets.RoundedRectangleBorder(Consts.MEDIUM_BORDER_RADIUS, Consts.ZERO_BORDER_INSETS, Colors.BORDER_COLOR));
        p_ubahKataSandi.setOpaque(false);

        et_kataSandiLama.setLabel("Sandi Baru");

        et_kataSandiBaru.setLabel("Konfirmasi Sandi Baru");
        et_kataSandiBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                et_kataSandiBaruActionPerformed(evt);
            }
        });

        b_save.setBackground(Colors.PRIMARY_COLOR);
        b_save.setForeground(Colors.WHITE_TEXT_COLOR);
        b_save.setText("Ubah Sandi");
        b_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_saveActionPerformed(evt);
            }
        });

        jLabel2.setFont(Fonts.ROBOTO_REGULAR.deriveFont(14f)
        );
        jLabel2.setForeground(Colors.GREY_TEXT_COLOR);
        jLabel2.setText("<html>Gunakan sedikitnya 8 karakter. Jangan gunakan sandi dari situs lain atau sesuatu yang mudah ditebak seperti nama hewan peliharaan Anda.</html>");

        jLabel3.setFont(Fonts.ROBOTO_REGULAR.deriveFont(14f)
        );
        jLabel3.setForeground(Colors.GREY_TEXT_COLOR.darker());
        jLabel3.setText("Kerumitan sandi:");

        javax.swing.GroupLayout p_ubahKataSandiLayout = new javax.swing.GroupLayout(p_ubahKataSandi);
        p_ubahKataSandi.setLayout(p_ubahKataSandiLayout);
        p_ubahKataSandiLayout.setHorizontalGroup(
            p_ubahKataSandiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_ubahKataSandiLayout.createSequentialGroup()
                .addGroup(p_ubahKataSandiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, p_ubahKataSandiLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(p_ubahKataSandiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(p_ubahKataSandiLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(p_ubahKataSandiLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(p_ubahKataSandiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(b_save, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(et_kataSandiBaru, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(et_kataSandiLama, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(36, 36, 36))
        );
        p_ubahKataSandiLayout.setVerticalGroup(
            p_ubahKataSandiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_ubahKataSandiLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(et_kataSandiLama, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addGap(4, 4, 4)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(et_kataSandiBaru, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(b_save, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(b_back, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(tv_title))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p_ubahKataSandi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tv_title, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_back, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addComponent(p_ubahKataSandi, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void et_kataSandiBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_et_kataSandiBaruActionPerformed
        b_save.doClick();
    }//GEN-LAST:event_et_kataSandiBaruActionPerformed

    private void b_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_backActionPerformed
        Navigator.push(new AddPetugasPage(repository, preferences, petugas));
    }//GEN-LAST:event_b_backActionPerformed

    private void b_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_saveActionPerformed
        repository.updatePassword(this);
    }//GEN-LAST:event_b_saveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private cores.widgets.MaterialButton b_back;
    private cores.widgets.MaterialButton b_save;
    public cores.widgets.PasswordField et_kataSandiBaru;
    public cores.widgets.PasswordField et_kataSandiLama;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel p_ubahKataSandi;
    private javax.swing.JLabel tv_title;
    // End of variables declaration//GEN-END:variables
}
