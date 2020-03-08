package features.petugas.presentation.pages;

import cores.entities.Pembayaran;
import cores.entities.Petugas;
import cores.styles.Colors;
import cores.styles.Constants;
import cores.styles.Fonts;
import cores.utils.Intl;
import cores.widgets.RoundedButton;
import cores.widgets.a_ScrollPane;
import features.petugas.data.repositories.PetugasRepository;
import features.petugas.presentation.widgets.ListPembayaranByDateTile;
import features.petugas.presentation.widgets.PetugasTile;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.AdjustmentEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import main.MainFrame;

/**
 *
 * @author rizal
 */
public class ListPetugasPage extends javax.swing.JPanel {
    private static final long serialVersionUID = 1L;

    private final PetugasRepository repository;

    private final List<Petugas> listPetugases = new ArrayList<>();
    private final List<PetugasTile> listPetugasTiles = new ArrayList<>();

    private final int maxResult = 15;
    private boolean isLoading = false;
    private boolean isLasIndex = false;
    private int currentIndex = 0;

    public ListPetugasPage(PetugasRepository repository) {
        this.repository = repository;
        initComponents();
        init();
    }

    private void init() {
        initScrollListener();
    }

    private void initScrollListener() throws HeadlessException {
        scrollPane.getVerticalScrollBar().addAdjustmentListener((e) -> {
            initListPetugasWhenScroll(e);
        });
    }

    private void initListPetugasWhenScroll(AdjustmentEvent e) {
        final var max = scrollPane.getVerticalScrollBar().getModel()
                .getMaximum();
        final var extent = scrollPane.getVerticalScrollBar().getModel()
                .getExtent();
        final var loadingArea = max - extent - 20;

        if (e.getValue() > loadingArea && !isLasIndex && !isLoading) {
            initListPetugas(repository.getListPetugas(maxResult, currentIndex));
        }
    }

    private void initListPetugas(final List<Petugas> listPetugasesNew) {
        if (listPetugasesNew == null) {
            isLasIndex = true;
            return;
        }
        for (int i = 0; i < listPetugasesNew.size(); i++) {
            final var petugas = listPetugasesNew.get(i);
            final var petugasTile = new PetugasTile(petugas, this);
            petugasTile.setPreferredSize(new Dimension(MainFrame.content
                    .getWidth(), petugasTile.getPreferredSize().height));

            if (i + 1 == listPetugasesNew.size()) {
                petugasTile.addComponentListener(new ComponentAdapter() {
                    @Override
                    public void componentResized(ComponentEvent e) {
                        isLoading = false;
                        super.componentResized(e);
                    }
                });
            }
            p_listPetugas.add(petugasTile);
            listPetugasTiles.add(petugasTile);
        }
        listPetugases.addAll(listPetugasesNew);
        currentIndex += listPetugasesNew.size();
        isLasIndex = listPetugasesNew.size() < maxResult;
    }

    public void showSidebar(Petugas petugas) {
        final var newWidthTile = MainFrame.content.getWidth() - p_sideBar
                .getPreferredSize().width;
        listPetugasTiles.forEach((petugasTile) -> {
            final var newSize = new Dimension(newWidthTile, petugasTile.getHeight());
            petugasTile.setPreferredSize(newSize);
            petugasTile.validate();
        });
        p_listPetugas.revalidate();
        p_sideBar.setVisible(true);
        initListPembayaran(petugas.getPembayaranList());
    }

    private void initListPembayaran(List<Pembayaran> listPembayarans) {
        Date currentDate = null;
        final var listPembayaransByDate = new ArrayList<Pembayaran>();

        for (int i = 0; i < listPembayarans.size(); i++) {
            final var pembayaran = listPembayarans.get(i);

            if (currentDate == null) {
                currentDate = pembayaran.getTanggalBayar();
            }
            final var tanggalBayar = Intl.convertSimpleTimestamp(pembayaran
                    .getTanggalBayar());
            final var lastDate = Intl.convertSimpleTimestamp(currentDate);

            if (i == listPembayarans.size() - 1) {
                listPembayaransByDate.add(pembayaran);
            }
            if (!tanggalBayar.equals(lastDate)
                    || i == listPembayarans.size() - 1) {
                if (!listPembayaransByDate.isEmpty()) {
                    final var listPembayaranByDateTile
                            = new ListPembayaranByDateTile(
                                    listPembayaransByDate, currentDate);
                    p_listPembayaran.add(listPembayaranByDateTile);
                    listPembayaransByDate.clear();
                }
                currentDate = pembayaran.getTanggalBayar();
            }
            listPembayaransByDate.add(pembayaran);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p_appBar = new javax.swing.JPanel();
        b_add = new RoundedButton(Constants.XLARGE_BORDER_RADIUS);
        jSeparator4 = new javax.swing.JSeparator();
        tv_title = new javax.swing.JLabel();
        chipsPanel = new javax.swing.JPanel();
        chipsPanel3 = new javax.swing.JPanel();
        p_main = new javax.swing.JPanel();
        scrollPane = new a_ScrollPane(jPanel1);
        jPanel1 = new javax.swing.JPanel();
        p_listPetugas = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        p_sideBar = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        b_closeSidebar = new RoundedButton(Constants.XLARGE_BORDER_RADIUS);
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new a_ScrollPane(jPanel4);
        jPanel4 = new javax.swing.JPanel();
        p_listPembayaran = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();

        p_appBar.setBackground(Colors.BACKGROUND_COLOR);

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

        jSeparator4.setForeground(Colors.BORDER_COLOR);

        tv_title.setFont(Fonts.GOOGLE_SANS.deriveFont(16f)
        );
        tv_title.setText("Daftar Petugas");

        chipsPanel.setBackground(Colors.BACKGROUND_COLOR);
        chipsPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 0, 2, 0));
        chipsPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 4, 0));

        chipsPanel3.setBackground(Colors.BACKGROUND_COLOR);
        chipsPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 0, 2, 0));
        chipsPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 4, 0));
        chipsPanel.add(chipsPanel3);

        javax.swing.GroupLayout p_appBarLayout = new javax.swing.GroupLayout(p_appBar);
        p_appBar.setLayout(p_appBarLayout);
        p_appBarLayout.setHorizontalGroup(
            p_appBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator4)
            .addGroup(p_appBarLayout.createSequentialGroup()
                .addComponent(tv_title)
                .addGap(8, 8, 8)
                .addComponent(chipsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16)
                .addComponent(b_add)
                .addContainerGap())
        );
        p_appBarLayout.setVerticalGroup(
            p_appBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_appBarLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(p_appBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chipsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(p_appBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(b_add, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tv_title, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        p_main.setBackground(Colors.BACKGROUND_COLOR);

        scrollPane.setBackground(Colors.BACKGROUND_COLOR);
        scrollPane.setBorder(null);
        scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel1.setBackground(Colors.BACKGROUND_COLOR);
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        p_listPetugas.setBackground(Colors.BACKGROUND_COLOR);
        p_listPetugas.setLayout(new java.awt.GridLayout(0, 1));
        jPanel1.add(p_listPetugas);

        scrollPane.setViewportView(jPanel1);

        jLabel1.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(12f)
        );
        jLabel1.setForeground(Colors.GREY_TEXT_COLOR);
        jLabel1.setText("Nama Petugas");

        jLabel2.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(12f)
        );
        jLabel2.setForeground(Colors.GREY_TEXT_COLOR);
        jLabel2.setText("Nama Pengguna");

        jSeparator1.setForeground(Colors.BORDER_COLOR);

        jLabel3.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(12f)
        );
        jLabel3.setForeground(Colors.GREY_TEXT_COLOR);
        jLabel3.setText("Hak Akses");

        javax.swing.GroupLayout p_mainLayout = new javax.swing.GroupLayout(p_main);
        p_main.setLayout(p_mainLayout);
        p_mainLayout.setHorizontalGroup(
            p_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane)
            .addGroup(p_mainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addGap(16, 16, 16)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addGap(16, 16, 16)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        p_mainLayout.setVerticalGroup(
            p_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_mainLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(p_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(12, 12, 12)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scrollPane))
        );

        scrollPane.getVerticalScrollBar().setUnitIncrement(12);

        p_sideBar.setBackground(Colors.BACKGROUND_COLOR);

        jLabel41.setFont(Fonts.GOOGLE_SANS.deriveFont(20f));
        jLabel41.setForeground(Colors.TEXT_COLOR);
        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/ic_information-outline_black.png"))); // NOI18N
        jLabel41.setText("Aktivitas");
        jLabel41.setIconTextGap(16);

        b_closeSidebar.setBackground(Colors.BACKGROUND_COLOR);
        b_closeSidebar.setFont(Fonts.PRODUCT_SANS_MEDIUM.deriveFont(14f)
        );
        b_closeSidebar.setForeground(Colors.WHITE_TEXT_COLOR);
        b_closeSidebar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/ic_close_grey.png"))); // NOI18N
        b_closeSidebar.setBorder(null);
        b_closeSidebar.setBorderPainted(false);
        b_closeSidebar.setContentAreaFilled(false);
        b_closeSidebar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b_closeSidebar.setFocusPainted(false);
        b_closeSidebar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/ic_close_black.png"))); // NOI18N
        b_closeSidebar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_closeSidebarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b_closeSidebarMouseExited(evt);
            }
        });
        b_closeSidebar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_closeSidebarActionPerformed(evt);
            }
        });

        jSeparator2.setForeground(Colors.BORDER_COLOR);

        jScrollPane1.setBackground(Colors.BACKGROUND_COLOR);
        jScrollPane1.setBorder(null);

        jPanel4.setBackground(Colors.BACKGROUND_COLOR);
        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 8));

        p_listPembayaran.setLayout(new java.awt.GridLayout(0, 1));
        jPanel4.add(p_listPembayaran);

        jScrollPane1.setViewportView(jPanel4);

        javax.swing.GroupLayout p_sideBarLayout = new javax.swing.GroupLayout(p_sideBar);
        p_sideBar.setLayout(p_sideBarLayout);
        p_sideBarLayout.setHorizontalGroup(
            p_sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_sideBarLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addGap(4, 4, 4)
                .addComponent(b_closeSidebar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jSeparator2)
            .addComponent(jScrollPane1)
        );
        p_sideBarLayout.setVerticalGroup(
            p_sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_sideBarLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(p_sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(b_closeSidebar, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE))
        );

        jSeparator3.setForeground(Colors.BORDER_COLOR);
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p_appBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(p_main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(p_sideBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(p_appBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p_main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p_sideBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator3)))
        );

        p_sideBar.setVisible(false);
    }// </editor-fold>//GEN-END:initComponents

    private void b_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_addActionPerformed

    }//GEN-LAST:event_b_addActionPerformed

    private void b_closeSidebarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_closeSidebarMouseEntered
        b_closeSidebar.setBackground(Colors.GREY_BACKGROUND_COLOR);
    }//GEN-LAST:event_b_closeSidebarMouseEntered

    private void b_closeSidebarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_closeSidebarMouseExited
        b_closeSidebar.setBackground(Colors.BACKGROUND_COLOR);
    }//GEN-LAST:event_b_closeSidebarMouseExited

    private void b_closeSidebarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_closeSidebarActionPerformed
        p_sideBar.setVisible(false);
    }//GEN-LAST:event_b_closeSidebarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_add;
    private javax.swing.JButton b_closeSidebar;
    private javax.swing.JPanel chipsPanel;
    private javax.swing.JPanel chipsPanel3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JPanel p_appBar;
    private javax.swing.JPanel p_listPembayaran;
    private javax.swing.JPanel p_listPetugas;
    private javax.swing.JPanel p_main;
    private javax.swing.JPanel p_sideBar;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JLabel tv_title;
    // End of variables declaration//GEN-END:variables
}
