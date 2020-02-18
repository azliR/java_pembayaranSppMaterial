package features.siswa.presentation.pages;

import cores.entities.Kelas;
import cores.entities.Spp;
import cores.styles.Colors;
import cores.styles.Constants;
import cores.styles.Fonts;
import cores.widgets.RoundedBorder;
import cores.widgets.RoundedButton;
import cores.widgets.a_TextField;
import features.siswa.data.repositories.SiswaRepository;

/**
 *
 * @author rizal
 */
public class AddSiswaPage extends javax.swing.JPanel {
    private static final long serialVersionUID = 1L;

    private final SiswaRepository siswaRepository;

    public byte[] foto;

    public AddSiswaPage(SiswaRepository siswaRepository) {
        this.siswaRepository = siswaRepository;
        initComponents();
        init();
    }

    private void init() {
        siswaRepository.initDropdownKelas(this);
        siswaRepository.initDropdownSpp(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        b_addImage = new javax.swing.JButton();
        et_namaSiswa = new a_TextField("Nama Siswa");
        et_nisn = new a_TextField("NISN");
        et_nis = new a_TextField("NIS");
        et_noTelepon = new a_TextField("No. Telepon");
        et_alamat = new a_TextField("Alamat");
        cb_kelas = new javax.swing.JComboBox<>();
        cb_spp = new javax.swing.JComboBox<>();
        b_clear = new RoundedButton(Constants.BORDER_RADIUS);
        b_save = new RoundedButton(Constants.BORDER_RADIUS);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(Colors.BACKGROUND_COLOR);

        b_addImage.setBackground(Colors.BACKGROUND_COLOR);
        b_addImage.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(14f)
        );
        b_addImage.setForeground(Colors.GREY_TEXT_COLOR);
        b_addImage.setText("Tambah Foto");
        b_addImage.setBorder(new cores.widgets.RoundedBorder());
        b_addImage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b_addImage.setFocusPainted(false);
        b_addImage.setOpaque(false);
        b_addImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_addImageActionPerformed(evt);
            }
        });

        et_namaSiswa.setBackground(Colors.BACKGROUND_COLOR);
        et_namaSiswa.setFont(Fonts.ROBOTO_REGULAR.deriveFont(16f)
        );
        et_namaSiswa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                et_namaSiswaKeyTyped(evt);
            }
        });

        et_nisn.setBackground(Colors.BACKGROUND_COLOR);
        et_nisn.setFont(Fonts.ROBOTO_REGULAR.deriveFont(16f)
        );
        et_nisn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                et_nisnKeyTyped(evt);
            }
        });

        et_nis.setBackground(Colors.BACKGROUND_COLOR);
        et_nis.setFont(Fonts.ROBOTO_REGULAR.deriveFont(16f)
        );
        et_nis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                et_nisKeyTyped(evt);
            }
        });

        et_noTelepon.setBackground(Colors.BACKGROUND_COLOR);
        et_noTelepon.setFont(Fonts.ROBOTO_REGULAR.deriveFont(16f)
        );
        et_noTelepon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                et_noTeleponKeyTyped(evt);
            }
        });

        et_alamat.setBackground(Colors.BACKGROUND_COLOR);
        et_alamat.setFont(Fonts.ROBOTO_REGULAR.deriveFont(16f)
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

        b_clear.setBackground(Colors.BACKGROUND_COLOR);
        b_clear.setFont(Fonts.PRODUCT_SANS_MEDIUM.deriveFont(14f)
        );
        b_clear.setForeground(Colors.TEXT_COLOR);
        b_clear.setText("Bersihkan");
        b_clear.setBorder(new RoundedBorder());
        b_clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b_clear.setFocusPainted(false);
        b_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_clearActionPerformed(evt);
            }
        });

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

        jLabel1.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(14f)
        );
        jLabel1.setForeground(Colors.GREY_TEXT_COLOR);
        jLabel1.setText("Kelas");

        jLabel2.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(14f)
        );
        jLabel2.setForeground(Colors.GREY_TEXT_COLOR);
        jLabel2.setText("Tipe SPP");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(et_alamat)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(cb_kelas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(b_addImage, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_spp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(et_nis)
                            .addComponent(et_namaSiswa)
                            .addComponent(et_nisn)
                            .addComponent(et_noTelepon, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(80, 80, 80))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(456, Short.MAX_VALUE)
                .addComponent(b_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(b_save, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(b_addImage, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(cb_kelas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2)
                        .addGap(7, 7, 7)
                        .addComponent(cb_spp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(et_namaSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(et_nisn, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(et_nis, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(et_noTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addComponent(et_alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_save, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void b_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_clearActionPerformed
        siswaRepository.clear(this);
    }//GEN-LAST:event_b_clearActionPerformed

    private void b_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_saveActionPerformed
        siswaRepository.insertSiswa(this);
    }//GEN-LAST:event_b_saveActionPerformed

    private void b_addImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_addImageActionPerformed
        siswaRepository.getImageFromDisk(this, 144, 144);
    }//GEN-LAST:event_b_addImageActionPerformed

    private void et_namaSiswaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_et_namaSiswaKeyTyped
        final var nama = et_namaSiswa.getText();
        if (nama.length() >= 36) {
            evt.consume();
        }
    }//GEN-LAST:event_et_namaSiswaKeyTyped

    private void et_nisnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_et_nisnKeyTyped
        final var nisn = et_nisn.getText();
        if (nisn.length() >= 10) {
            evt.consume();
        }
        char newChar = evt.getKeyChar();
        if (!(Character.isDigit(newChar))) {
            evt.consume();
        }
    }//GEN-LAST:event_et_nisnKeyTyped

    private void et_nisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_et_nisKeyTyped
        final var nis = et_nis.getText();
        if (nis.length() >= 8) {
            evt.consume();
        }
        char newChar = evt.getKeyChar();
        if (!(Character.isDigit(newChar))) {
            evt.consume();
        }
    }//GEN-LAST:event_et_nisKeyTyped

    private void et_noTeleponKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_et_noTeleponKeyTyped
        final var noTelepon = et_noTelepon.getText();
        if (noTelepon.length() >= 13) {
            evt.consume();
        }
        char newChar = evt.getKeyChar();
        if (!(Character.isDigit(newChar))) {
            evt.consume();
        }
    }//GEN-LAST:event_et_noTeleponKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton b_addImage;
    private javax.swing.JButton b_clear;
    private javax.swing.JButton b_save;
    public javax.swing.JComboBox<Kelas> cb_kelas;
    public javax.swing.JComboBox<Spp> cb_spp;
    public javax.swing.JTextField et_alamat;
    public javax.swing.JTextField et_namaSiswa;
    public javax.swing.JTextField et_nis;
    public javax.swing.JTextField et_nisn;
    public javax.swing.JTextField et_noTelepon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
