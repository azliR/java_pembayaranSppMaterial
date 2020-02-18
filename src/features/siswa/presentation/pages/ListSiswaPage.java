package features.siswa.presentation.pages;

import cores.entities.Siswa;
import cores.styles.Colors;
import cores.widgets.a_ScrollPane;
import features.siswa.data.repositories.SiswaRepository;
import features.siswa.presentation.widgets.SiswaTile;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import main.MainFrame;

/**
 *
 * @author rizal
 */
public class ListSiswaPage extends javax.swing.JPanel {
    private static final long serialVersionUID = 1L;

    private final SiswaRepository repository;

    public final List<SiswaTile> listSiswaTiles = new ArrayList<>();
    public final List<Siswa> listSiswa = new ArrayList<>();

    public final int maxResult = 15;
    public boolean isLoading = false;
    public boolean isLasIndex = false;
    public int currentIndex = 0;

    public ListSiswaPage(SiswaRepository siswaRepository) {
        this.repository = siswaRepository;
        initComponents();
        init();
    }

    private void init() {
        final var screenHeigth
                = Toolkit.getDefaultToolkit().getScreenSize().height;
        final var appBarHeight = screenHeigth - MainFrame.content.getHeight();

        scrollPane.getVerticalScrollBar().addAdjustmentListener((e) -> {
            final var max = scrollPane.getVerticalScrollBar().getModel()
                    .getMaximum();
            final var extent = scrollPane.getVerticalScrollBar().getModel()
                    .getExtent();
            final var loadingArea = max - extent - 20;

            if (e.getValue() > loadingArea && !isLoading) {
                repository.getListSiswaWithoutThumbnail(
                        this, maxResult, currentIndex);
            }

            listSiswaTiles.forEach((siswaTiles) -> {
                final var location = siswaTiles.getLocationOnScreen().y
                        - appBarHeight - 49;

                if (siswaTiles.siswa.getFoto() == null && location >= 0
                        && location <= screenHeigth) {
                    final var foto = repository.getSiswaThumbnail(
                            siswaTiles.siswa.getNisn());
                    siswaTiles.tv_image.setIcon(new ImageIcon(foto));
                    siswaTiles.siswa.setFoto(foto);
                    siswaTiles.setFoto(foto);
                }
            });
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane = new a_ScrollPane(jPanel1);
        jPanel1 = new javax.swing.JPanel();
        gridLayout = new javax.swing.JPanel();

        scrollPane.setBackground(Colors.BACKGROUND_COLOR);
        scrollPane.setBorder(null);

        jPanel1.setBackground(Colors.BACKGROUND_COLOR);
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 8));

        gridLayout.setBackground(Colors.BACKGROUND_COLOR);
        gridLayout.setLayout(new java.awt.GridLayout(0, 3, 8, 8));
        jPanel1.add(gridLayout);

        scrollPane.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
        );

        scrollPane.getVerticalScrollBar().setUnitIncrement(12);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel gridLayout;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
}
