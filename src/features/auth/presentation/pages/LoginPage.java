package features.auth.presentation.pages;

import cores.styles.Colors;
import cores.styles.Fonts;
import cores.styles.Strings;
import cores.utils.Navigator;
import features.auth.data.repositories.AuthRepository;
import features.home.pages.HomePage;

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

        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tv_error = new javax.swing.JLabel();
        b_login = new cores.widgets.MaterialButton();
        et_namaPengguna = new cores.widgets.TextField();
        et_kataSandi = new cores.widgets.PasswordField();

        setBackground(Colors.BACKGROUND_COLOR);

        jPanel4.setBackground(Colors.CARD_COLOR);
        jPanel4.setBorder(new cores.widgets.RoundedRectangleBorder());
        jPanel4.setPreferredSize(new java.awt.Dimension(460, 540));

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

        tv_error.setFont(Fonts.ROBOTO_REGULAR.deriveFont(12f)
        );
        tv_error.setForeground(Colors.ERROR_TEXT_COLOR);
        tv_error.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/ic_alert-circle_red_16px.png"))); // NOI18N
        tv_error.setText("Tidak dapat terhubung dengan jaringan server");
        tv_error.setIconTextGap(6);

        b_login.setBackground(Colors.PRIMARY_COLOR);
        b_login.setBorder(null);
        b_login.setForeground(Colors.BACKGROUND_COLOR);
        b_login.setText("Masuk");
        b_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_loginActionPerformed(evt);
            }
        });

        et_namaPengguna.setLabel("Nama Pengguna");
        et_namaPengguna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                et_namaPenggunaActionPerformed(evt);
            }
        });
        et_namaPengguna.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                et_namaPenggunaKeyPressed(evt);
            }
        });

        et_kataSandi.setLabel("Kata Sandi");
        et_kataSandi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                et_kataSandiActionPerformed(evt);
            }
        });
        et_kataSandi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                et_kataSandiKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 42, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(b_login, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                    .addComponent(tv_error, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(et_namaPengguna, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(et_kataSandi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 42, Short.MAX_VALUE))
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
                .addGap(16, 16, 16)
                .addComponent(et_kataSandi, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(tv_error)
                .addGap(36, 36, 36)
                .addComponent(b_login, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        tv_error.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 453, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 453, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 114, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 114, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void b_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_loginActionPerformed
        tv_error.setVisible(false);

        final var namaPengguna = et_namaPengguna.getText();
        final var kataSandi = String.valueOf(et_kataSandi.getPassword());

        if (authRepository.login(namaPengguna, kataSandi)) {
            Navigator.push(new HomePage(), true);

        } else {
            tv_error.setVisible(true);
            tv_error.setText(Strings.ERROR_DIALOG_WRONG_PASSWORD);
        }
    }//GEN-LAST:event_b_loginActionPerformed

    private void et_namaPenggunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_et_namaPenggunaActionPerformed
        et_kataSandi.requestFocus();
    }//GEN-LAST:event_et_namaPenggunaActionPerformed

    private void et_namaPenggunaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_et_namaPenggunaKeyPressed
        tv_error.setVisible(false);
    }//GEN-LAST:event_et_namaPenggunaKeyPressed

    private void et_kataSandiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_et_kataSandiActionPerformed
        b_login.doClick();
    }//GEN-LAST:event_et_kataSandiActionPerformed

    private void et_kataSandiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_et_kataSandiKeyPressed
        tv_error.setVisible(false);
    }//GEN-LAST:event_et_kataSandiKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private cores.widgets.MaterialButton b_login;
    private cores.widgets.PasswordField et_kataSandi;
    private cores.widgets.TextField et_namaPengguna;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel tv_error;
    // End of variables declaration//GEN-END:variables
}
