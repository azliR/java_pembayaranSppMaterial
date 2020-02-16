package main;

import cores.styles.Colors;
import cores.styles.Constants;
import cores.styles.Fonts;
import cores.utils.Navigator;
import cores.widgets.RoundedPanel;
import cores.widgets.a_SideNavigation;
import features.auth.pages.LoginPage;
import features.auth.repositories.AuthRepositoryImpl;
import features.home.pages.HomePage;
import features.student.pages.ListSiswaPage;
import features.student.repositories.SiswaRepositoryImpl;
import java.awt.Frame;
import javax.swing.JFrame;

/**
 *
 * @author rizal
 */
public class MainFrame extends javax.swing.JFrame {

    final AuthRepositoryImpl authRepositoryImpl;
    final SiswaRepositoryImpl siswaRepositoryImpl;

    boolean isSearchFilled = false;

    public MainFrame(AuthRepositoryImpl authRepositoryImpl, SiswaRepositoryImpl siswaRepositoryImpl) {
        this.authRepositoryImpl = authRepositoryImpl;
        this.siswaRepositoryImpl = siswaRepositoryImpl;
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        content.add(new LoginPage(authRepositoryImpl));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sideBarGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        tv_title = new javax.swing.JLabel();
        content = new javax.swing.JPanel();
        sideBar = new javax.swing.JPanel();
        nav_beranda = new a_SideNavigation(sideBarGroup);
        nav_laporan = new a_SideNavigation(sideBarGroup);
        topBar = new javax.swing.JPanel();
        jPanel3 = new RoundedPanel(Constants.BORDER_RADIUS);
        jLabel1 = new javax.swing.JLabel();
        et_search = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel6.setBackground(Colors.BACKGROUND_COLOR);

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/titlebutton-close.png"))); // NOI18N
        jButton7.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 12, 2, 12));
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.setFocusPainted(false);
        jButton7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/titlebutton-close-hover.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/titlebutton-minimize.png"))); // NOI18N
        jButton8.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 12, 2, 12));
        jButton8.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);
        jButton8.setFocusPainted(false);
        jButton8.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/titlebutton-minimize-hover.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        tv_title.setFont(Fonts.GOOGLE_SANS.deriveFont(16f)
        );
        tv_title.setForeground(new java.awt.Color(0, 24, 44));
        tv_title.setText("Pembayaran SPP");
        tv_title.setBorder(javax.swing.BorderFactory.createEmptyBorder(6, 0, 0, 0));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(611, 611, 611)
                .addComponent(tv_title)
                .addContainerGap(618, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(tv_title)
                .addGap(8, 8, 8))
            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        content.setBackground(Colors.BACKGROUND_COLOR);
        content.setLayout(new java.awt.CardLayout());

        sideBar.setBackground(Colors.BACKGROUND_COLOR);

        nav_beranda.setBackground(Colors.BLUE_BACKGROUND_COLOR);
        sideBarGroup.add(nav_beranda);
        nav_beranda.setSelected(true);
        nav_beranda.setText("Beranda");
        nav_beranda.setBorder(null);
        nav_beranda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/ic_home-variant-outline_grey.png"))); // NOI18N
        nav_beranda.setIconTextGap(20);
        nav_beranda.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/ic_home-variant.png"))); // NOI18N
        nav_beranda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nav_berandaActionPerformed(evt);
            }
        });

        nav_laporan.setBackground(Colors.BACKGROUND_COLOR);
        sideBarGroup.add(nav_laporan);
        nav_laporan.setForeground(Colors.GREY_TEXT_COLOR);
        nav_laporan.setText("Laporan");
        nav_laporan.setBorder(null);
        nav_laporan.setIconTextGap(20);
        nav_laporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nav_laporanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sideBarLayout = new javax.swing.GroupLayout(sideBar);
        sideBar.setLayout(sideBarLayout);
        sideBarLayout.setHorizontalGroup(
            sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nav_beranda, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
            .addComponent(nav_laporan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        sideBarLayout.setVerticalGroup(
            sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideBarLayout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(nav_beranda, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(nav_laporan, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(384, Short.MAX_VALUE))
        );

        topBar.setBackground(Colors.BACKGROUND_COLOR);

        jPanel3.setBackground(new java.awt.Color(241, 243, 244));

        jLabel1.setFont(new java.awt.Font("Product Sans Light", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(111, 112, 112));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/ic_magnify.png"))); // NOI18N

        et_search.setFont(Fonts.GOOGLE_SANS.deriveFont(17f));
        et_search.setForeground(Colors.GREY_TEXT_COLOR);
        et_search.setText("Telusuri Pesanan");
        et_search.setBorder(null);
        et_search.setOpaque(false);
        et_search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                et_searchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                et_searchFocusLost(evt);
            }
        });
        et_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                et_searchActionPerformed(evt);
            }
        });
        et_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                et_searchKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(et_search, javax.swing.GroupLayout.DEFAULT_SIZE, 921, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(et_search, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout topBarLayout = new javax.swing.GroupLayout(topBar);
        topBar.setLayout(topBarLayout);
        topBarLayout.setHorizontalGroup(
            topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topBarLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        topBarLayout.setVerticalGroup(
            topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topBarLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(sideBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(topBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sideBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(topBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        sideBar.setVisible(false);
        topBar.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void nav_berandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nav_berandaActionPerformed
        Navigator.push(new HomePage());
    }//GEN-LAST:event_nav_berandaActionPerformed

    private void nav_laporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nav_laporanActionPerformed
        Navigator.push(new ListSiswaPage(siswaRepositoryImpl));
    }//GEN-LAST:event_nav_laporanActionPerformed

    private void et_searchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_et_searchFocusGained
        if (!isSearchFilled) {
            et_search.setText(null);
            et_search.setForeground(Colors.TEXT_COLOR);
        }
    }//GEN-LAST:event_et_searchFocusGained

    private void et_searchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_et_searchFocusLost
        if (et_search.getText().isBlank()) {
            et_search.setText("Telusuri Pesanan");
            et_search.setForeground(Colors.GREY_TEXT_COLOR);

            isSearchFilled = false;
        } else {
            isSearchFilled = true;
        }
    }//GEN-LAST:event_et_searchFocusLost

    private void et_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_et_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_et_searchActionPerformed

    private void et_searchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_et_searchKeyTyped

    }//GEN-LAST:event_et_searchKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel content;
    private javax.swing.JTextField et_search;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JRadioButton nav_beranda;
    private javax.swing.JRadioButton nav_laporan;
    public static javax.swing.JPanel sideBar;
    private javax.swing.ButtonGroup sideBarGroup;
    public static javax.swing.JPanel topBar;
    public static javax.swing.JLabel tv_title;
    // End of variables declaration//GEN-END:variables
}
