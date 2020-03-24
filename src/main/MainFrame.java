package main;

import cores.provider.SharedPreferences;
import cores.styles.Colors;
import cores.styles.Fonts;
import cores.styles.Strings;
import cores.utils.ImageProcessor;
import cores.utils.Navigator;
import cores.utils.Scalr;
import cores.widgets.RoundedPanel;
import features.auth.data.repositories.AuthRepository;
import features.auth.presentation.pages.LoginPage;
import features.home.pages.HomePage;
import features.petugas.data.repositories.PetugasRepository;
import features.petugas.presentation.pages.DetailPetugasPage;
import features.petugas.presentation.pages.ListPetugasPage;
import features.siswa.data.repositories.SiswaRepository;
import features.siswa.presentation.pages.ListSiswaPage;
import java.awt.Color;
import java.awt.Frame;
import java.util.Random;
import javax.swing.ImageIcon;
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
    private final SharedPreferences preferences;

    private boolean isSearchFilled = false;

    public MainFrame(AuthRepository authRepository,
            SiswaRepository siswaRepository,
            PetugasRepository petugasRepository,
            SharedPreferences preferences) {
        this.authRepository = authRepository;
        this.siswaRepository = siswaRepository;
        this.petugasRepository = petugasRepository;
        this.preferences = preferences;
        initComponents();
        init();
    }

    private void init() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        content.add(new LoginPage(authRepository));
    }

    public void setProfile() {
        final var petugas = preferences.getLoggedInPetugas();
        if (petugas == null) {
            return;
        }
        if (petugas.getFoto() == null) {
            final var random = new Random();
            final var red = random.nextInt(256);
            final var green = random.nextInt(256);
            final var blue = random.nextInt(256);
            final var color = new Color(red, green, blue);
            p_profile.setBackground(color.darker());
            tv_profile.setText(String
                    .valueOf(petugas.getNamaPetugas().charAt(0)).toUpperCase());
            return;
        }
        final var maxWidth = 38;
        final var maxHeight = 38;

        var image = ImageProcessor.byteArrayToBufferedImage(petugas.getFoto());
        if (image.getWidth(null) > maxWidth || image.getHeight(null) > maxHeight) {
            image = Scalr.resize(image, Scalr.Mode.FIT_TO_WIDTH, maxWidth,
                    maxHeight);
        }
        final var croppedImage = Scalr.crop(image, maxWidth, maxHeight);
        final var roundedImage = ImageProcessor.roundImage(croppedImage,
                maxWidth);

        tv_profile.setIcon(new ImageIcon(roundedImage));
    }

    @Override
    public void dispose() {
        if (preferences.isLoggedIn()) {
            authRepository.updateStatus(Strings.DATABASE_TIDAK_AKTIF);
        }
        super.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sideBarGroup = new javax.swing.ButtonGroup();
        mainPage = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        tv_title = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        content = new javax.swing.JPanel();
        sideBar = new javax.swing.JPanel();
        nav_beranda = new cores.widgets.AppDrawer(sideBarGroup);
        nav_kelas = new cores.widgets.AppDrawer(sideBarGroup);
        nav_siswa = new cores.widgets.AppDrawer(sideBarGroup);
        nav_spp = new cores.widgets.AppDrawer(sideBarGroup);
        nav_petugas = new cores.widgets.AppDrawer(sideBarGroup);
        nav_laporan = new cores.widgets.AppDrawer(sideBarGroup);
        topBar = new javax.swing.JPanel();
        jPanel3 = new RoundedPanel(cores.styles.Consts.MEDIUM_BORDER_RADIUS);
        jLabel1 = new javax.swing.JLabel();
        et_search = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        p_profile = new RoundedPanel(46);
        tv_profile = new javax.swing.JLabel();

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
        nav_beranda.setForeground(Colors.ACTIVE_TEXT_COLOR);
        nav_beranda.setSelected(true);
        nav_beranda.setText("Beranda");
        nav_beranda.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 36, 0, 0, Colors.BLUE_BACKGROUND_COLOR));
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
        nav_kelas.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 36, 0, 0, Colors.BACKGROUND_COLOR));
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
        nav_siswa.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 36, 0, 0, Colors.BACKGROUND_COLOR));
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
        nav_spp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 36, 0, 0, Colors.BACKGROUND_COLOR));
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
        nav_petugas.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 36, 0, 0, Colors.BACKGROUND_COLOR));
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
        nav_laporan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 36, 0, 0, Colors.BACKGROUND_COLOR));
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
                .addContainerGap(364, Short.MAX_VALUE))
        );

        topBar.setBackground(Colors.BACKGROUND_COLOR);
        topBar.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                topBarComponentShown(evt);
            }
        });

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
                .addComponent(et_search, javax.swing.GroupLayout.DEFAULT_SIZE, 1031, Short.MAX_VALUE)
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
        jLabel2.setForeground(Colors.GREY_TEXT_COLOR);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/a_ logo.png"))); // NOI18N
        jLabel2.setText("αzliR");
        jLabel2.setIconTextGap(12);

        p_profile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p_profileMouseClicked(evt);
            }
        });
        p_profile.setLayout(new java.awt.CardLayout());

        tv_profile.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(18f)
        );
        tv_profile.setForeground(Colors.WHITE_TEXT_COLOR);
        tv_profile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p_profile.add(tv_profile, "card2");

        javax.swing.GroupLayout topBarLayout = new javax.swing.GroupLayout(topBar);
        topBar.setLayout(topBarLayout);
        topBarLayout.setHorizontalGroup(
            topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topBarLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24)
                .addComponent(p_profile, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addComponent(jSeparator1)
        );
        topBarLayout.setVerticalGroup(
            topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topBarLayout.createSequentialGroup()
                .addGroup(topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(topBarLayout.createSequentialGroup()
                        .addGroup(topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topBarLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(p_profile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout mainPageLayout = new javax.swing.GroupLayout(mainPage);
        mainPage.setLayout(mainPageLayout);
        mainPageLayout.setHorizontalGroup(
            mainPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(mainPageLayout.createSequentialGroup()
                .addComponent(sideBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(topBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mainPageLayout.setVerticalGroup(
            mainPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPageLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(topBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(mainPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sideBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        sideBar.setVisible(false);
        topBar.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        Navigator.push(new ListPetugasPage(petugasRepository, preferences));
    }//GEN-LAST:event_nav_petugasActionPerformed

    private void topBarComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_topBarComponentShown
        setProfile();
    }//GEN-LAST:event_topBarComponentShown

    private void p_profileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_profileMouseClicked
        Navigator.push(new DetailPetugasPage(petugasRepository, preferences,
                preferences.getLoggedInPetugas()));
    }//GEN-LAST:event_p_profileMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel content;
    private javax.swing.JTextField et_search;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel mainPage;
    private javax.swing.JRadioButton nav_beranda;
    private javax.swing.JRadioButton nav_kelas;
    private javax.swing.JRadioButton nav_laporan;
    private javax.swing.JRadioButton nav_petugas;
    private javax.swing.JRadioButton nav_siswa;
    private javax.swing.JRadioButton nav_spp;
    private javax.swing.JPanel p_profile;
    public static javax.swing.JPanel sideBar;
    private javax.swing.ButtonGroup sideBarGroup;
    public static javax.swing.JPanel topBar;
    private javax.swing.JLabel tv_profile;
    public static javax.swing.JLabel tv_title;
    // End of variables declaration//GEN-END:variables
}
