package features.petugas.presentation.pages;

import cores.styles.Colors;
import cores.styles.Consts;
import cores.styles.Fonts;
import cores.styles.Strings;
import cores.utils.AlertDialog;
import cores.widgets.RoundedPanel;
import features.auth.data.repositories.AuthRepository;
import java.util.function.Consumer;

/**
 *
 * @author rizal
 */
public class EditPetugasPasswordPage extends javax.swing.JPanel {
    private static final long serialVersionUID = 1L;

    private final AuthRepository authRepository;
    private Consumer<String> onSave;
    private Runnable onBack;

    public EditPetugasPasswordPage(AuthRepository authRepository) {
        this.authRepository = authRepository;
        initComponents();
        init();
    }

    private void init() {
        tv_title.setText(Strings.UBAH_KATA_SANDI);
        tv_desc.setText(Strings.UBAH_KATA_SANDI_DESC);
        tv_kerumitanSandi.setText(Strings.KERUMITAN_KATA_SANDI + ":");
        tv_kerumitanSandiContent.setText("<html>"
                + Strings.KERUMITAN_KATA_SANDI_CONTENT + "</html>");
        et_sandiBaru.setLabel(Strings.KATA_SANDI_BARU);
        et_konfirmasiSandi.setLabel(Strings.KONFIRMASI_KATA_SANDI_BARU);
        b_save.setText(Strings.UBAH_KATA_SANDI);
    }

    public void setOnBack(Runnable onBack) {
        this.onBack = onBack;
    }

    public void setOnSave(Consumer<String> onSave) {
        this.onSave = onSave;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tv_desc = new javax.swing.JLabel();
        tv_title = new javax.swing.JLabel();
        b_back = new cores.widgets.MaterialButton();
        p_ubahKataSandi = new RoundedPanel(Consts.MEDIUM_BORDER_RADIUS);
        et_sandiBaru = new cores.widgets.PasswordField();
        et_konfirmasiSandi = new cores.widgets.PasswordField();
        b_save = new cores.widgets.MaterialButton();
        tv_kerumitanSandiContent = new javax.swing.JLabel();
        tv_kerumitanSandi = new javax.swing.JLabel();

        setOpaque(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 24));

        jPanel1.setBackground(Colors.BACKGROUND_COLOR);

        tv_desc.setFont(Fonts.ROBOTO_REGULAR.deriveFont(14f)
        );
        tv_desc.setForeground(Colors.GREY_TEXT_COLOR);
        tv_desc.setText("Untuk keamanan, pilih sandi yang kuat dan jangan gunakan lagi untuk akun lain.");

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

        et_sandiBaru.setLabel("Sandi Baru");

        et_konfirmasiSandi.setLabel("Konfirmasi Sandi Baru");
        et_konfirmasiSandi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                et_konfirmasiSandiActionPerformed(evt);
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

        tv_kerumitanSandiContent.setFont(Fonts.ROBOTO_REGULAR.deriveFont(14f)
        );
        tv_kerumitanSandiContent.setForeground(Colors.GREY_TEXT_COLOR);
        tv_kerumitanSandiContent.setText("Contoh");

        tv_kerumitanSandi.setFont(Fonts.ROBOTO_REGULAR.deriveFont(14f)
        );
        tv_kerumitanSandi.setForeground(Colors.DARKER_GREY_TEXT_COLOR);
        tv_kerumitanSandi.setText("Kerumitan sandi:");

        javax.swing.GroupLayout p_ubahKataSandiLayout = new javax.swing.GroupLayout(p_ubahKataSandi);
        p_ubahKataSandi.setLayout(p_ubahKataSandiLayout);
        p_ubahKataSandiLayout.setHorizontalGroup(
            p_ubahKataSandiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_ubahKataSandiLayout.createSequentialGroup()
                .addGroup(p_ubahKataSandiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, p_ubahKataSandiLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(p_ubahKataSandiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tv_kerumitanSandiContent, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(p_ubahKataSandiLayout.createSequentialGroup()
                                .addComponent(tv_kerumitanSandi)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(p_ubahKataSandiLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(p_ubahKataSandiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(b_save, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(et_konfirmasiSandi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                            .addComponent(et_sandiBaru, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(36, 36, 36))
        );
        p_ubahKataSandiLayout.setVerticalGroup(
            p_ubahKataSandiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_ubahKataSandiLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(et_sandiBaru, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(tv_kerumitanSandi)
                .addGap(4, 4, 4)
                .addComponent(tv_kerumitanSandiContent)
                .addGap(24, 24, 24)
                .addComponent(et_konfirmasiSandi, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(tv_desc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p_ubahKataSandi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(tv_desc)
                .addGap(24, 24, 24)
                .addComponent(p_ubahKataSandi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void et_konfirmasiSandiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_et_konfirmasiSandiActionPerformed
        b_save.doClick();
    }//GEN-LAST:event_et_konfirmasiSandiActionPerformed

    private void b_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_backActionPerformed
        if (onBack != null) {
            onBack.run();
        }
    }//GEN-LAST:event_b_backActionPerformed

    private void b_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_saveActionPerformed
        if (onSave != null) {
            final var sandiBaru = et_sandiBaru.getPassword();
            final var konfirmasiSAndi = et_konfirmasiSandi.getPassword();
            if (sandiBaru.length < 8) {
                AlertDialog.showErrorDialog(
                        Strings.ERROR_DIALOG_PASSWORD_LENGTH);
                return;
            }
            if (!sandiBaru.equals(konfirmasiSAndi)) {
                AlertDialog.showErrorDialog(
                        Strings.ERROR_DIALOG_PASSWORD_NOT_MATCH);
                return;
            }
            onSave.accept(String.valueOf(et_sandiBaru.getPassword()));
        }
    }//GEN-LAST:event_b_saveActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        et_sandiBaru.requestFocus();
    }//GEN-LAST:event_formComponentResized

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        et_sandiBaru.setText(null);
        et_konfirmasiSandi.setText(null);
    }//GEN-LAST:event_formComponentShown

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private cores.widgets.MaterialButton b_back;
    private cores.widgets.MaterialButton b_save;
    public cores.widgets.PasswordField et_konfirmasiSandi;
    public cores.widgets.PasswordField et_sandiBaru;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel p_ubahKataSandi;
    private javax.swing.JLabel tv_desc;
    private javax.swing.JLabel tv_kerumitanSandi;
    private javax.swing.JLabel tv_kerumitanSandiContent;
    private javax.swing.JLabel tv_title;
    // End of variables declaration//GEN-END:variables
}
