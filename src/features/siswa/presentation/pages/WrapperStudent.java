package features.siswa.presentation.pages;

import cores.styles.Colors;
import cores.styles.Constants;
import cores.styles.Fonts;
import cores.utils.Navigator;
import cores.widgets.RoundedButton;
import features.siswa.data.repositories.SiswaRepository;

/**
 *
 * @author rizal
 */
public class WrapperStudent extends javax.swing.JPanel {
    private static final long serialVersionUID = 1L;

    final SiswaRepository siswaRepository;

    final ListSiswaPage listSiswaPage;

    public WrapperStudent(SiswaRepository siswaRepository) {
        this.siswaRepository = siswaRepository;

        listSiswaPage = new ListSiswaPage(siswaRepository);
        initComponents();
        init();
    }

    private void init() {
        content.add(listSiswaPage);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        b_addSiswa = new RoundedButton(Constants.XLARGE_BORDER_RADIUS);
        jSeparator1 = new javax.swing.JSeparator();
        b_back = new RoundedButton(Constants.XLARGE_BORDER_RADIUS);
        tv_title = new javax.swing.JLabel();
        content = new javax.swing.JPanel();

        jPanel1.setBackground(Colors.BACKGROUND_COLOR);

        b_addSiswa.setBackground(Colors.PRIMARY_COLOR);
        b_addSiswa.setFont(Fonts.PRODUCT_SANS_MEDIUM.deriveFont(14f)
        );
        b_addSiswa.setForeground(Colors.WHITE_TEXT_COLOR);
        b_addSiswa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/ic_plus.png"))); // NOI18N
        b_addSiswa.setText("Tambah");
        b_addSiswa.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 8, 0, 16));
        b_addSiswa.setBorderPainted(false);
        b_addSiswa.setContentAreaFilled(false);
        b_addSiswa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b_addSiswa.setFocusPainted(false);
        b_addSiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_addSiswaActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(Colors.BORDER_COLOR);

        b_back.setBackground(Colors.BACKGROUND_COLOR);
        b_back.setFont(Fonts.PRODUCT_SANS_MEDIUM.deriveFont(14f)
        );
        b_back.setForeground(Colors.WHITE_TEXT_COLOR);
        b_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/ic_plus.png"))); // NOI18N
        b_back.setBorder(null);
        b_back.setBorderPainted(false);
        b_back.setContentAreaFilled(false);
        b_back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b_back.setFocusPainted(false);
        b_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_backActionPerformed(evt);
            }
        });

        tv_title.setFont(Fonts.GOOGLE_SANS.deriveFont(16f)
        );
        tv_title.setText("Daftar Siswa");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(b_back, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tv_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 423, Short.MAX_VALUE)
                .addComponent(b_addSiswa)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_addSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_back, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tv_title, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        b_back.setVisible(false);

        content.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void b_addSiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_addSiswaActionPerformed
        Navigator.push(content, new AddSiswaPage(siswaRepository));

        b_addSiswa.setVisible(false);
        b_back.setVisible(true);
        tv_title.setText("Tambah Siswa");
    }//GEN-LAST:event_b_addSiswaActionPerformed

    private void b_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_backActionPerformed
        Navigator.push(content, listSiswaPage);

        b_addSiswa.setVisible(true);
        b_back.setVisible(false);
        tv_title.setText("Daftar Siswa");
    }//GEN-LAST:event_b_backActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_addSiswa;
    private javax.swing.JButton b_back;
    private javax.swing.JPanel content;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel tv_title;
    // End of variables declaration//GEN-END:variables
}
