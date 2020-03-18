package main;

import cores.styles.Colors;
import cores.styles.Constants;
import cores.styles.Fonts;
import cores.styles.Strings;
import cores.utils.Navigator;
import cores.widgets.RoundedPanel;
import cores.widgets.a_SideNavigation;
import features.auth.data.repositories.AuthRepository;
import features.auth.presentation.pages.LoginPage;
import features.home.pages.HomePage;
import features.petugas.data.repositories.PetugasRepository;
import features.petugas.presentation.pages.ListPetugasPage;
import features.siswa.data.repositories.SiswaRepository;
import features.siswa.presentation.pages.ListSiswaPage;
import java.awt.Frame;
import javax.swing.JFrame;

/**
 *
 * @author rizal
 */
public class MainFrame extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;

    private final AuthRepository authRepository;
    private final SiswaRepository siswaRepository;
    private final PetugasRepository petugasRepository;

    boolean isSearchFilled = false;

    public MainFrame(AuthRepository authRepository,
            SiswaRepository siswaRepository,
            PetugasRepository petugasRepository) {
        this.authRepository = authRepository;
        this.siswaRepository = siswaRepository;
        this.petugasRepository = petugasRepository;
        initComponents();
        init();
    }

    private void init() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        content.add(new LoginPage(authRepository));
    }

    @Override
    public void dispose() {
        authRepository.updateStatus(Strings.DATABASE_TIDAK_AKTIF);
        super.dispose();
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
        jPanel4 = new javax.swing.JPanel();
        content = new javax.swing.JPanel();
        sideBar = new javax.swing.JPanel();
        nav_beranda = new a_SideNavigation(sideBarGroup);
        nav_kelas = new a_SideNavigation(sideBarGroup);
        nav_siswa = new a_SideNavigation(sideBarGroup);
        nav_spp = new a_SideNavigation(sideBarGroup);
        nav_petugas = new a_SideNavigation(sideBarGroup);
        nav_laporan = new a_SideNavigation(sideBarGroup);
        topBar = new javax.swing.JPanel();
        jPanel3 = new RoundedPanel(Constants.LARGE_BORDER_RADIUS);
        jLabel1 = new javax.swing.JLabel();
        et_search = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel6.setBackground(Colors.BACKGROUND_COLOR);

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/titlebutton-close.png"))); // NOI18N
        jButton7.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 12, 2, 12));
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.setFocusPainted(false);
        jButton7.setFocusable(false);
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
        jButton8.setFocusable(false);
        jButton8.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/titlebutton-minimize-hover.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        tv_title.setFont(Fonts.PRODUCT_SANS_MEDIUM.deriveFont(14f)
        );
        tv_title.setForeground(Colors.TEXT_COLOR);
        tv_title.setText("Pembayaran SPP");
        tv_title.setBorder(javax.swing.BorderFactory.createEmptyBorder(6, 0, 0, 0));

        jPanel4.setOpaque(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tv_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tv_title))
                .addGap(4, 4, 4))
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

        nav_kelas.setBackground(Colors.BACKGROUND_COLOR);
        sideBarGroup.add(nav_kelas);
        nav_kelas.setForeground(Colors.GREY_TEXT_COLOR);
        nav_kelas.setText("Kelas");
        nav_kelas.setBorder(null);
        nav_kelas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/ic_google-classroom_grey.png"))); // NOI18N
        nav_kelas.setIconTextGap(20);
        nav_kelas.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/ic_google-classroom.png"))); // NOI18N
        nav_kelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nav_kelasActionPerformed(evt);
            }
        });

        nav_siswa.setBackground(Colors.BACKGROUND_COLOR);
        sideBarGroup.add(nav_siswa);
        nav_siswa.setForeground(Colors.GREY_TEXT_COLOR);
        nav_siswa.setText("Siswa");
        nav_siswa.setBorder(null);
        nav_siswa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/ic_account-group-outline_grey.png"))); // NOI18N
        nav_siswa.setIconTextGap(20);
        nav_siswa.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/ic_account-group.png"))); // NOI18N
        nav_siswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nav_siswaActionPerformed(evt);
            }
        });

        nav_spp.setBackground(Colors.BACKGROUND_COLOR);
        sideBarGroup.add(nav_spp);
        nav_spp.setForeground(Colors.GREY_TEXT_COLOR);
        nav_spp.setText("Spp");
        nav_spp.setBorder(null);
        nav_spp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/ic_text-box-check-outline_grey.png"))); // NOI18N
        nav_spp.setIconTextGap(20);
        nav_spp.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/ic_text-box-check.png"))); // NOI18N
        nav_spp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nav_sppActionPerformed(evt);
            }
        });

        nav_petugas.setBackground(Colors.BACKGROUND_COLOR);
        sideBarGroup.add(nav_petugas);
        nav_petugas.setForeground(Colors.GREY_TEXT_COLOR);
        nav_petugas.setText("Petugas");
        nav_petugas.setBorder(null);
        nav_petugas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/ic_card-account-details-outline_grey.png"))); // NOI18N
        nav_petugas.setIconTextGap(20);
        nav_petugas.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/ic_card-account-details_grey.png"))); // NOI18N
        nav_petugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nav_petugasActionPerformed(evt);
            }
        });

        nav_laporan.setBackground(Colors.BACKGROUND_COLOR);
        sideBarGroup.add(nav_laporan);
        nav_laporan.setForeground(Colors.GREY_TEXT_COLOR);
        nav_laporan.setText("Laporan");
        nav_laporan.setBorder(null);
        nav_laporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/ic_poll-box-outline_grey.png"))); // NOI18N
        nav_laporan.setIconTextGap(20);
        nav_laporan.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/ic_poll-box.png"))); // NOI18N
        nav_laporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nav_laporanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sideBarLayout = new javax.swing.GroupLayout(sideBar);
        sideBar.setLayout(sideBarLayout);
        sideBarLayout.setHorizontalGroup(
            sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sideBarLayout.createSequentialGroup()
                .addGroup(sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nav_kelas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nav_beranda, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(nav_siswa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nav_laporan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nav_spp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nav_petugas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        sideBarLayout.setVerticalGroup(
            sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideBarLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(nav_beranda, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(nav_kelas, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(nav_siswa, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(nav_spp, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(nav_petugas, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(nav_laporan, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        topBar.setBackground(Colors.BACKGROUND_COLOR);

        jPanel3.setBackground(new java.awt.Color(241, 243, 244));

        jLabel1.setFont(new java.awt.Font("Product Sans Light", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(111, 112, 112));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/ic_magnify_grey.png"))); // NOI18N

        et_search.setFont(Fonts.GOOGLE_SANS.deriveFont(16f));
        et_search.setForeground(Colors.GREY_TEXT_COLOR);
        et_search.setText(Strings.SEARCH_HINT);
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
        et_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                et_searchKeyReleased(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/ic_close_grey.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/ic_close_black.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addComponent(et_search)
                .addGap(16, 16, 16)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(et_search)
            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jSeparator1.setForeground(Colors.BORDER_COLOR);

        jLabel2.setFont(Fonts.PRODUCT_SANS_REGULAR.deriveFont(24f)
        );
        jLabel2.setForeground(Colors.TEXT_COLOR);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/a_ logo.png"))); // NOI18N
        jLabel2.setText("Fragile");
        jLabel2.setIconTextGap(12);

        javax.swing.GroupLayout topBarLayout = new javax.swing.GroupLayout(topBar);
        topBar.setLayout(topBarLayout);
        topBarLayout.setHorizontalGroup(
            topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(topBarLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(64, 64, 64))
        );
        topBarLayout.setVerticalGroup(
            topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topBarLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(sideBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE))
            .addComponent(topBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(topBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sideBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
        dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void nav_berandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nav_berandaActionPerformed
        Navigator.push(new HomePage());
    }//GEN-LAST:event_nav_berandaActionPerformed

    private void nav_kelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nav_kelasActionPerformed

    }//GEN-LAST:event_nav_kelasActionPerformed

    private void et_searchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_et_searchFocusGained
        if (!isSearchFilled) {
            et_search.setText(null);
            et_search.setForeground(Colors.TEXT_COLOR);
        }
    }//GEN-LAST:event_et_searchFocusGained

    private void et_searchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_et_searchFocusLost
        if (et_search.getText().isBlank()) {
            et_search.setText(Strings.SEARCH_HINT);
            et_search.setForeground(Colors.GREY_TEXT_COLOR);

            if (content.getComponent(0) instanceof ListSiswaPage) {
                final var listSiswaPage = (ListSiswaPage) content.getComponent(0);
                listSiswaPage.isSearching = false;
            }

            isSearchFilled = false;
        } else {
            isSearchFilled = true;
        }
    }//GEN-LAST:event_et_searchFocusLost

    private void nav_siswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nav_siswaActionPerformed
        Navigator.push(new ListSiswaPage(siswaRepository));
    }//GEN-LAST:event_nav_siswaActionPerformed

    private void nav_laporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nav_laporanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nav_laporanActionPerformed

    private void nav_sppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nav_sppActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nav_sppActionPerformed

    private void et_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_et_searchKeyReleased
        ListSiswaPage listSiswaPage;
        if (content.getComponent(0) instanceof ListSiswaPage) {
            listSiswaPage = (ListSiswaPage) content.getComponent(0);
        } else {
            listSiswaPage = new ListSiswaPage(siswaRepository);
            Navigator.push(listSiswaPage);
        }
        listSiswaPage.currentIndex = 0;
        listSiswaPage.currentSearchKeyword = et_search.getText();
        listSiswaPage.isSearching = true;
        listSiswaPage.scrollPane.getVerticalScrollBar().setValue(0);
        listSiswaPage.gridLayout.removeAll();
        listSiswaPage.initListSiswaByKeyword();
        listSiswaPage.gridLayout.repaint();
        listSiswaPage.gridLayout.revalidate();
    }//GEN-LAST:event_et_searchKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void nav_petugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nav_petugasActionPerformed
        Navigator.push(new ListPetugasPage(petugasRepository));
    }//GEN-LAST:event_nav_petugasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel content;
    private javax.swing.JTextField et_search;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton nav_beranda;
    private javax.swing.JRadioButton nav_kelas;
    private javax.swing.JRadioButton nav_laporan;
    private javax.swing.JRadioButton nav_petugas;
    private javax.swing.JRadioButton nav_siswa;
    private javax.swing.JRadioButton nav_spp;
    public static javax.swing.JPanel sideBar;
    private javax.swing.ButtonGroup sideBarGroup;
    public static javax.swing.JPanel topBar;
    public static javax.swing.JLabel tv_title;
    // End of variables declaration//GEN-END:variables
}
