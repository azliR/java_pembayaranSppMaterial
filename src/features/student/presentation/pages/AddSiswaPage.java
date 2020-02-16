package features.student.presentation.pages;

import cores.styles.Colors;
import cores.styles.Constants;
import cores.styles.Fonts;
import cores.widgets.RoundedBorder;
import cores.widgets.RoundedButton;
import cores.widgets.a_TextField;
import features.student.data.entities.Siswa;
import features.student.data.repositories.SiswaRepository;

/**
 *
 * @author rizal
 */
public class AddSiswaPage extends javax.swing.JPanel {
    private static final long serialVersionUID = 1L;

    private final SiswaRepository siswaRepository;

    public final Siswa siswa = new Siswa();

    public AddSiswaPage(SiswaRepository siswaRepository) {
        this.siswaRepository = siswaRepository;
        initComponents();
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
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        b_clear = new RoundedButton(Constants.BORDER_RADIUS);
        b_save = new RoundedButton(Constants.BORDER_RADIUS);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(Colors.BACKGROUND_COLOR);

        b_addImage.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(14f)
        );
        b_addImage.setForeground(Colors.GREY_TEXT_COLOR);
        b_addImage.setText("Tambah Foto");
        b_addImage.setBorder(new cores.widgets.RoundedBorder());
        b_addImage.setContentAreaFilled(false);
        b_addImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_addImageActionPerformed(evt);
            }
        });

        et_namaSiswa.setBackground(Colors.BACKGROUND_COLOR);
        et_namaSiswa.setFont(Fonts.ROBOTO_REGULAR.deriveFont(16f)
        );

        et_nisn.setBackground(Colors.BACKGROUND_COLOR);
        et_nisn.setFont(Fonts.ROBOTO_REGULAR.deriveFont(16f)
        );

        et_nis.setBackground(Colors.BACKGROUND_COLOR);
        et_nis.setFont(Fonts.ROBOTO_REGULAR.deriveFont(16f)
        );

        et_noTelepon.setBackground(Colors.BACKGROUND_COLOR);
        et_noTelepon.setFont(Fonts.ROBOTO_REGULAR.deriveFont(16f)
        );

        et_alamat.setBackground(Colors.BACKGROUND_COLOR);
        et_alamat.setFont(Fonts.ROBOTO_REGULAR.deriveFont(16f)
        );

        jComboBox1.setBackground(Colors.BACKGROUND_COLOR);
        jComboBox1.setFont(Fonts.ROBOTO_REGULAR.deriveFont(16f)
        );
        jComboBox1.setForeground(Colors.TEXT_COLOR);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setBackground(Colors.BACKGROUND_COLOR);
        jComboBox2.setFont(Fonts.ROBOTO_REGULAR.deriveFont(16f)
        );
        jComboBox2.setForeground(Colors.TEXT_COLOR);
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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

        jLabel1.setText("Kelas");

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(et_namaSiswa, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                            .addComponent(et_nisn)
                            .addComponent(et_nis)
                            .addComponent(et_noTelepon))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(b_addImage, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))))
                .addGap(80, 80, 80))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addComponent(et_namaSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(et_nisn, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(et_nis, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(b_addImage, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(et_noTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(et_alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_save, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void b_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_clearActionPerformed

    }//GEN-LAST:event_b_clearActionPerformed

    private void b_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_saveActionPerformed
        siswaRepository.insertSiswa(siswa);
    }//GEN-LAST:event_b_saveActionPerformed

    private void b_addImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_addImageActionPerformed
        siswaRepository.getImageFromDisk(this, 144, 144);
    }//GEN-LAST:event_b_addImageActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton b_addImage;
    private javax.swing.JButton b_clear;
    private javax.swing.JButton b_save;
    private javax.swing.JTextField et_alamat;
    private javax.swing.JTextField et_namaSiswa;
    private javax.swing.JTextField et_nis;
    private javax.swing.JTextField et_nisn;
    private javax.swing.JTextField et_noTelepon;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
