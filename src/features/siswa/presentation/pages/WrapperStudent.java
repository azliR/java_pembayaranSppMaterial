package features.siswa.presentation.pages;

import cores.styles.Colors;
import cores.styles.Constants;
import cores.styles.Fonts;
import cores.utils.Navigator;
import cores.widgets.RoundedButton;
import cores.widgets.a_Chip;
import features.siswa.data.repositories.SiswaRepository;
import java.util.ArrayList;

/**
 *
 * @author rizal
 */
public class WrapperStudent extends javax.swing.JPanel {
    private static final long serialVersionUID = 1L;

    private final SiswaRepository repository;

    final ListSiswaPage listSiswaPage;

    public WrapperStudent(SiswaRepository siswaRepository) {
        this.repository = siswaRepository;
        initComponents();
        listSiswaPage = new ListSiswaPage(repository);
        init();
    }

    private void init() {
        content.add(listSiswaPage);

        final var listJenisKelamin = new ArrayList<String>();
        listJenisKelamin.add("Semua");
        listJenisKelamin.add("Laki-Laki");
        listJenisKelamin.add("Perempuan");
        listJenisKelamin.forEach((jenisKelamin) -> {
            final var chip = new a_Chip(jenisKelamin, jenisKelaminGroup);
            jenisKelaminGroup.add(chip);
            jenisKelaminGroup.setSelected(chip.getModel(), jenisKelamin.equals(
                    "Semua"));

            chip.addActionListener((ae) -> {
                System.out.println(ae.paramString());
            });
            chipsPanel.add(chip);
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jenisKelaminGroup = new javax.swing.ButtonGroup();
        sppGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        b_add = new RoundedButton(Constants.XLARGE_BORDER_RADIUS);
        jSeparator1 = new javax.swing.JSeparator();
        b_back = new RoundedButton(Constants.XLARGE_BORDER_RADIUS);
        tv_title = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        chipsPanel = new javax.swing.JPanel();
        content = new javax.swing.JPanel();

        jPanel1.setBackground(Colors.BACKGROUND_COLOR);

        b_add.setBackground(Colors.PRIMARY_COLOR);
        b_add.setFont(Fonts.PRODUCT_SANS_MEDIUM.deriveFont(14f)
        );
        b_add.setForeground(Colors.WHITE_TEXT_COLOR);
        b_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/ic_plus_white.png"))); // NOI18N
        b_add.setText("Tambah");
        b_add.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 8, 0, 16));
        b_add.setBorderPainted(false);
        b_add.setContentAreaFilled(false);
        b_add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b_add.setFocusPainted(false);
        b_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_addActionPerformed(evt);
            }
        });

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
        tv_title.setText("Daftar Siswa");

        jPanel3.setBackground(Colors.BACKGROUND_COLOR);
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        chipsPanel.setBackground(Colors.BACKGROUND_COLOR);
        chipsPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 0, 2, 0));
        chipsPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 4, 0));
        jPanel3.add(chipsPanel);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(b_back, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(tv_title)
                .addGap(16, 16, 16)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16)
                .addComponent(b_add)
                .addContainerGap())
            .addComponent(jSeparator1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_add, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_back, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tv_title, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        b_back.setVisible(false);

        content.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                contentComponentAdded(evt);
            }
        });
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

    private void b_backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_backMouseEntered
        b_back.setBackground(Colors.GREY_BACKGROUND_COLOR);
    }//GEN-LAST:event_b_backMouseEntered

    private void b_backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_backMouseExited
        b_back.setBackground(Colors.BACKGROUND_COLOR);
    }//GEN-LAST:event_b_backMouseExited

    private void contentComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_contentComponentAdded
        if (evt.getChild() instanceof ListSiswaPage) {
            tv_title.setText("Daftar Siswa");
            chipsPanel.setVisible(true);
            b_back.setVisible(false);
            b_add.setVisible(true);
            b_add.setText("Tambah");

        } else if (evt.getChild() instanceof AddSiswaPage) {
            final var child = (AddSiswaPage) evt.getChild();

            tv_title.setText(child.siswa == null
                    ? "Tambah Siswa"
                    : "Edit Siswa");
            chipsPanel.setVisible(false);
            b_back.setVisible(true);
            b_add.setVisible(false);

        } else if (evt.getChild() instanceof DetailSiswaPage) {
            tv_title.setText("Detail Siswa");
            chipsPanel.setVisible(false);
            b_back.setVisible(true);
            b_add.setVisible(true);
            b_add.setText("Edit");
        }
    }//GEN-LAST:event_contentComponentAdded

    private void b_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_addActionPerformed
        final var child = content.getComponent(0);

        if (child instanceof DetailSiswaPage) {
            Navigator.push(content, new AddSiswaPage(repository,
                    ((DetailSiswaPage) child).siswa));
        } else if (child instanceof ListSiswaPage) {
            Navigator.push(content, new AddSiswaPage(repository, null));
        }
    }//GEN-LAST:event_b_addActionPerformed

    private void b_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_backActionPerformed
        final var child = content.getComponent(0);

        if (child instanceof AddSiswaPage) {
            final var siswa = ((AddSiswaPage) child).siswa;
            if (siswa == null) {
                Navigator.push(content, listSiswaPage);
            } else {
                Navigator.push(content, new DetailSiswaPage(siswa));
            }
        } else if (child instanceof DetailSiswaPage) {
            Navigator.push(content, listSiswaPage);
        }
    }//GEN-LAST:event_b_backActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton b_add;
    public javax.swing.JButton b_back;
    public javax.swing.JPanel chipsPanel;
    public static javax.swing.JPanel content;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.ButtonGroup jenisKelaminGroup;
    private javax.swing.ButtonGroup sppGroup;
    public javax.swing.JLabel tv_title;
    // End of variables declaration//GEN-END:variables
}
