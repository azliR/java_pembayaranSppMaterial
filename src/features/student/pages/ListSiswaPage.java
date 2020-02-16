package features.student.pages;

import cores.styles.Colors;
import cores.widgets.a_ScrollPane;
import features.student.entities.Siswa;
import features.student.repositories.SiswaRepositoryImpl;
import features.student.widgets.SiswaTile;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rizal
 */
public class ListSiswaPage extends javax.swing.JPanel {

    final SiswaRepositoryImpl siswaRepositoryImpl;

    final List<Component> listSiswaTiles = new ArrayList<>();
    final List<Siswa> listSiswa = new ArrayList<>();

    public ListSiswaPage(SiswaRepositoryImpl siswaRepositoryImpl) {
        this.siswaRepositoryImpl = siswaRepositoryImpl;
        initComponents();

        listSiswa.addAll(siswaRepositoryImpl.getListSiswaWithoutThumbnail(20, 0));
        System.out.println(listSiswa.size());
        listSiswa.forEach((siswa) -> {
            final var siswaTile = new SiswaTile(siswa);
            gridLayout.add(siswaTile);
            listSiswaTiles.add(siswaTile);
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
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        gridLayout.setBackground(Colors.BACKGROUND_COLOR);
        gridLayout.setLayout(new java.awt.GridLayout(0, 1, 0, 4));
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
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel gridLayout;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
}
