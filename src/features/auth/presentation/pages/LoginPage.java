package features.auth.presentation.pages;

import cores.styles.Colors;
import cores.styles.Constants;
import cores.styles.Fonts;
import cores.widgets.RoundedBorder;
import cores.widgets.RoundedButton;
import cores.widgets.a_PasswordField;
import cores.widgets.a_TextField;
import features.auth.data.repositories.AuthRepository;

/**
 *
 * @author rizal
 */
public class LoginPage extends javax.swing.JPanel {
    private static final long serialVersionUID = 1L;

    final AuthRepository authRepository;

    public LoginPage(AuthRepository authRepository) {
        this.authRepository = authRepository;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        b_login = new RoundedButton(Constants.BORDER_RADIUS);
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tv_error = new javax.swing.JLabel();
        tv_loading = new javax.swing.JLabel();
        et_namaPengguna = new a_TextField("Nama Pengguna");
        et_kataSandi = new a_PasswordField("Kata Sandi");

        jPanel1.setBackground(Colors.BACKGROUND_COLOR);
        jPanel1.setForeground(new java.awt.Color(104, 87, 176));
        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentResized(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentShown(evt);
            }
        });
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel4.setBackground(Colors.CARD_COLOR);
        jPanel4.setBorder(new RoundedBorder(12, Constants.ALL_8_BORDER_INSETS, Colors.BORDER_COLOR));
        jPanel4.setPreferredSize(new java.awt.Dimension(460, 540));

        b_login.setBackground(Colors.PRIMARY_COLOR);
        b_login.setFont(Fonts.PRODUCT_SANS_MEDIUM.deriveFont(14f)
        );
        b_login.setForeground(Colors.WHITE_TEXT_COLOR);
        b_login.setText("Masuk");
        b_login.setBorder(null);
        b_login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b_login.setFocusPainted(false);
        b_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_loginActionPerformed(evt);
            }
        });

        jLabel2.setFont(Fonts.PRODUCT_SANS_REGULAR.deriveFont(24f)
        );
        jLabel2.setForeground(Colors.TEXT_COLOR);
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Masuk");

        jLabel3.setFont(Fonts.ROBOTO_REGULAR.deriveFont(16f)
        );
        jLabel3.setForeground(Colors.TEXT_COLOR);
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Selamat datang kembali!");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/a_ logo.png"))); // NOI18N

        tv_error.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tv_error.setForeground(new java.awt.Color(217, 48, 37));
        tv_error.setText("Tidak dapat terhubung dengan jaringan server");
        tv_error.setIconTextGap(6);

        tv_loading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        et_namaPengguna.setBackground(Colors.BACKGROUND_COLOR);
        et_namaPengguna.setFont(Fonts.ROBOTO_REGULAR.deriveFont(16f)
        );

        et_kataSandi.setBackground(Colors.BACKGROUND_COLOR);
        et_kataSandi.setFont(Fonts.ROBOTO_REGULAR.deriveFont(16f)
        );
        et_kataSandi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                et_kataSandiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 50, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                    .addComponent(b_login, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                    .addComponent(tv_error, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tv_loading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(et_namaPengguna)
                    .addComponent(et_kataSandi))
                .addGap(0, 50, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(24, 24, 24)
                .addComponent(et_namaPengguna, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(et_kataSandi, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tv_error)
                .addGap(48, 48, 48)
                .addComponent(b_login, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(tv_loading)
                .addGap(48, 48, 48))
        );

        tv_error.setVisible(false);
        tv_loading.setVisible(false);

        jPanel1.add(jPanel4, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1366, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void b_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_loginActionPerformed
        final var namaPengguna = et_namaPengguna.getText();
        final var kataSandi = String.valueOf(et_kataSandi.getPassword());
        authRepository.login(namaPengguna, kataSandi);
    }//GEN-LAST:event_b_loginActionPerformed

    private void et_kataSandiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_et_kataSandiActionPerformed
        b_login.doClick();
    }//GEN-LAST:event_et_kataSandiActionPerformed

    private void jPanel1ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentResized
        et_namaPengguna.requestFocus();
    }//GEN-LAST:event_jPanel1ComponentResized

    private void jPanel1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentShown
        System.out.println(getHeight());
    }//GEN-LAST:event_jPanel1ComponentShown

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_login;
    private javax.swing.JPasswordField et_kataSandi;
    private javax.swing.JTextField et_namaPengguna;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    public javax.swing.JLabel tv_error;
    private javax.swing.JLabel tv_loading;
    // End of variables declaration//GEN-END:variables
}
