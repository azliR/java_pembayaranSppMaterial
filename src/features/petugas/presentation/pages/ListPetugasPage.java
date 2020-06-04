package features.petugas.presentation.pages;

import cores.entities.Pembayaran;
import cores.entities.Petugas;
import cores.provider.SharedPreferences;
import cores.styles.Colors;
import cores.styles.Fonts;
import cores.styles.Strings;
import cores.utils.AlertDialog;
import cores.utils.Navigator;
import features.petugas.data.repositories.PetugasRepository;
import features.petugas.presentation.widgets.DateTile;
import features.petugas.presentation.widgets.ListPetugasTile;
import features.petugas.presentation.widgets.PembayaranTile;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.AdjustmentEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;
import main.MainFrame;

/**
 *
 * @author rizal
 */
public class ListPetugasPage extends javax.swing.JPanel {
    private static final long serialVersionUID = 1L;

    private final PetugasRepository repository;
    private final SharedPreferences preferences;

    private final List<Petugas> listPetugases = new ArrayList<>();
    private final List<ListPetugasTile> listPetugasTiles = new ArrayList<>();
    private final int maxResult = 15;

    private ListPetugasTile selectedPetugasTile = null;
    private Petugas selectedPetugas = null;

    private boolean isLoading = false;
    private boolean isLasIndex = false;
    private int currentIndex = 0;

    public ListPetugasPage(PetugasRepository repository,
            SharedPreferences preferences) {
        this.repository = repository;
        this.preferences = preferences;
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
            final var petugasTile = new ListPetugasTile(petugas, this);
            petugasTile.setPreferredSize(new Dimension(MainFrame.content
                    .getWidth() - 2, petugasTile.getPreferredSize().height));

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

    private void initListPembayaran(List<Pembayaran> listPembayarans) {
        p_listPembayaran.removeAll();

        if (listPembayarans.isEmpty()) {
            jPanel4.setLayout(new GridBagLayout());
            p_listPembayaran.add(p_noData);
            p_listPembayaran.revalidate();
            return;
        }
        jPanel4.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        PembayaranTile lastTile = null;
        int lastTanggal = 0;
        for (var i = listPembayarans.size() - 1; i >= 0; i--) {
            final var pembayaran = listPembayarans.get(i);
            final var tanggalBayar = pembayaran.getTanggalBayar().getDate();

            if (lastTanggal == 0 || tanggalBayar != lastTanggal) {
                lastTanggal = tanggalBayar;

                if (lastTile != null) {
                    lastTile.setLastTile(true);
                    p_listPembayaran.add(lastTile);
                }

                final var dateTile = new DateTile(pembayaran.getTanggalBayar());
                final var tileSize = new Dimension(
                        p_sideBar.getPreferredSize().width,
                        dateTile.getPreferredSize().height);
                dateTile.setPreferredSize(tileSize);
                p_listPembayaran.add(dateTile);
            } else {
                p_listPembayaran.add(lastTile);
            }
            final var pembayaranTile = new PembayaranTile(pembayaran);
            final var tileSize = new Dimension(p_sideBar.getPreferredSize().width,
                    pembayaranTile.getPreferredSize().height);
            pembayaranTile.setPreferredSize(tileSize);

            if (i != 0) {
                lastTile = pembayaranTile;
            } else {
                if (lastTile != null) {
                    lastTile.setLastTile(true);
                }
                p_listPembayaran.add(lastTile);
            }
        }
        p_listPembayaran.revalidate();
    }

    public void showSidebar(ListPetugasTile context, Petugas petugas) {
        final var newWidthTile = MainFrame.content.getWidth()
                - p_sideBar.getPreferredSize().width - 2;

        listPetugasTiles.forEach((petugasTile) -> {
            if (!p_sideBar.isVisible()) {
                final var newSize = new Dimension(newWidthTile, petugasTile
                        .getHeight());

                petugasTile.tv_status.setVisible(false);
                petugasTile.setPreferredSize(newSize);
            }
            petugasTile.setSelected(context.equals(petugasTile));
        });
        p_listPetugas.revalidate();
        p_sideBar.setVisible(true);
        b_edit.setVisible(true);
        b_delete.setVisible(true);
        tv_status.setVisible(false);

        selectedPetugasTile = context;
        selectedPetugas = petugas;

        initListPembayaran(petugas.getPembayaranList());
    }

    private void hideSidebar() {
        b_edit.setVisible(false);
        b_delete.setVisible(false);
        p_sideBar.setVisible(false);
        tv_status.setVisible(true);
        listPetugasTiles.forEach((petugasTile) -> {
            final var newSize = new Dimension(MainFrame.content.getWidth(),
                    petugasTile.getHeight());
            petugasTile.tv_status.setVisible(true);
            petugasTile.setPreferredSize(newSize);
            petugasTile.setSelected(false);
            petugasTile.setBackground(Colors.BACKGROUND_COLOR);
        });
        p_listPetugas.revalidate();

        selectedPetugasTile = null;
        selectedPetugas = null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p_noData = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        p_appBar = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        tv_title = new javax.swing.JLabel();
        chipsPanel = new javax.swing.JPanel();
        chipsPanel3 = new javax.swing.JPanel();
        b_add = new cores.widgets.MaterialButton();
        b_edit = new cores.widgets.MaterialButton();
        b_delete = new cores.widgets.MaterialButton();
        p_main = new javax.swing.JPanel();
        scrollPane = new cores.widgets.ScrollView(jPanel1);
        jPanel1 = new javax.swing.JPanel();
        p_listPetugas = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        tv_status = new javax.swing.JLabel();
        p_sideBar = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new cores.widgets.ScrollView(jPanel4);
        jPanel4 = new javax.swing.JPanel();
        p_listPembayaran = new javax.swing.JPanel();
        b_back = new cores.widgets.MaterialButton();
        jSeparator3 = new javax.swing.JSeparator();

        p_noData.setOpaque(false);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/img_no-data.png"))); // NOI18N

        jLabel5.setFont(Fonts.PRODUCT_SANS_MEDIUM.deriveFont(16f)
        );
        jLabel5.setForeground(Colors.TEXT_COLOR);
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Data tidak ditemukan");

        javax.swing.GroupLayout p_noDataLayout = new javax.swing.GroupLayout(p_noData);
        p_noData.setLayout(p_noDataLayout);
        p_noDataLayout.setHorizontalGroup(
            p_noDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_noDataLayout.createSequentialGroup()
                .addGroup(p_noDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        p_noDataLayout.setVerticalGroup(
            p_noDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_noDataLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel4)
                .addGap(16, 16, 16)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        p_appBar.setBackground(Colors.BACKGROUND_COLOR);

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

        b_add.setBorder(new cores.widgets.RoundedRectangleBorder());
        b_add.setForeground(Colors.PRIMARY_COLOR);
        b_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/ic_plus.png"))); // NOI18N
        b_add.setText("Tambah");
        b_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_addActionPerformed(evt);
            }
        });

        b_edit.setBorder(new cores.widgets.RoundedRectangleBorder());
        b_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/ic_pencil-outline.png"))); // NOI18N
        b_edit.setText("Edit");
        b_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_editActionPerformed(evt);
            }
        });

        b_delete.setBorder(new cores.widgets.RoundedRectangleBorder());
        b_delete.setForeground(Colors.ERROR_TEXT_COLOR);
        b_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/ic_trash-can-outline_red.png"))); // NOI18N
        b_delete.setText("Hapus");
        b_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p_appBarLayout = new javax.swing.GroupLayout(p_appBar);
        p_appBar.setLayout(p_appBarLayout);
        p_appBarLayout.setHorizontalGroup(
            p_appBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator4)
            .addGroup(p_appBarLayout.createSequentialGroup()
                .addComponent(tv_title)
                .addGap(8, 8, 8)
                .addComponent(chipsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(b_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(b_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        p_appBarLayout.setVerticalGroup(
            p_appBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_appBarLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(p_appBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chipsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tv_title, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(p_appBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(b_add, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(b_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(b_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        b_edit.setVisible(false);
        b_delete.setVisible(false);

        p_main.setBackground(Colors.BACKGROUND_COLOR);

        scrollPane.setBackground(Colors.BACKGROUND_COLOR);
        scrollPane.setBorder(null);

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

        tv_status.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(12f)
        );
        tv_status.setForeground(Colors.GREY_TEXT_COLOR);
        tv_status.setText("Status");

        javax.swing.GroupLayout p_mainLayout = new javax.swing.GroupLayout(p_main);
        p_main.setLayout(p_mainLayout);
        p_mainLayout.setHorizontalGroup(
            p_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(p_mainLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                .addGap(62, 62, 62)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                .addGap(16, 16, 16)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                .addGap(16, 16, 16)
                .addComponent(tv_status, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                .addContainerGap())
        );
        p_mainLayout.setVerticalGroup(
            p_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_mainLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(p_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(tv_status))
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

        jSeparator2.setForeground(Colors.BORDER_COLOR);

        jScrollPane1.setBackground(Colors.BACKGROUND_COLOR);
        jScrollPane1.setBorder(null);

        jPanel4.setBackground(Colors.BACKGROUND_COLOR);
        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        p_listPembayaran.setBackground(Colors.BACKGROUND_COLOR);
        p_listPembayaran.setLayout(new java.awt.GridLayout(0, 1));
        jPanel4.add(p_listPembayaran);

        jScrollPane1.setViewportView(jPanel4);

        b_back.setBorderRadius(36);
        b_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/ic_close_grey.png"))); // NOI18N
        b_back.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/ic_close_black.png"))); // NOI18N
        b_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p_sideBarLayout = new javax.swing.GroupLayout(p_sideBar);
        p_sideBar.setLayout(p_sideBarLayout);
        p_sideBarLayout.setHorizontalGroup(
            p_sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_sideBarLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addGap(16, 16, 16)
                .addComponent(b_back, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jSeparator2)
            .addComponent(jScrollPane1)
        );
        p_sideBarLayout.setVerticalGroup(
            p_sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_sideBarLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(p_sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_back, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE))
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
                    .addComponent(p_sideBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator3)
                    .addComponent(p_main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        p_sideBar.setVisible(false);
    }// </editor-fold>//GEN-END:initComponents

    private void b_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_backActionPerformed
        hideSidebar();
    }//GEN-LAST:event_b_backActionPerformed

    private void b_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_addActionPerformed
        Navigator.push(new AddPetugasPage(repository, preferences));
    }//GEN-LAST:event_b_addActionPerformed

    private void b_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_editActionPerformed
        Navigator.push(new AddPetugasPage(repository, preferences));
    }//GEN-LAST:event_b_editActionPerformed

    private void b_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_deleteActionPerformed
        final var result = AlertDialog.showConfirmDialog(
                Strings.DIALOG_DELETE_TITLE,
                "Hapus "
                + selectedPetugas.getNamaPetugas()
                + " dari database secara permanen? Tindakan ini tidak dapat diurungkan.");
        if (result) {
            if (repository.deletePetugas(selectedPetugas.getId())) {
                listPetugases.remove(selectedPetugas);
                listPetugasTiles.remove(selectedPetugasTile);
                p_listPetugas.remove(selectedPetugasTile);
                p_listPetugas.revalidate();
                hideSidebar();
            }
        }
    }//GEN-LAST:event_b_deleteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private cores.widgets.MaterialButton b_add;
    private cores.widgets.MaterialButton b_back;
    private cores.widgets.MaterialButton b_delete;
    private cores.widgets.MaterialButton b_edit;
    private javax.swing.JPanel chipsPanel;
    private javax.swing.JPanel chipsPanel3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
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
    private javax.swing.JPanel p_noData;
    private javax.swing.JPanel p_sideBar;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JLabel tv_status;
    private javax.swing.JLabel tv_title;
    // End of variables declaration//GEN-END:variables
}
