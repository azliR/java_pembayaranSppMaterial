package features.petugas.presentation.widgets;

import cores.entities.Petugas;
import cores.styles.Colors;
import cores.styles.Fonts;
import features.petugas.presentation.pages.ListPetugasPage;

/**
 *
 * @author rizal
 */
public class PetugasTile extends javax.swing.JPanel {
    private static final long serialVersionUID = 1L;

    private final Petugas petugas;

    private final ListPetugasPage context;

    public PetugasTile(Petugas petugas, ListPetugasPage context) {
        this.context = context;
        this.petugas = petugas;
        initComponents();
        init();
    }

    private void init() {
        tv_namaPetugas.setText(petugas.getNamaPetugas());
        tv_namaPengguna.setText(petugas.getNamaPengguna());
        tv_hakAkses.setText(petugas.getHakAkses());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tv_namaPetugas = new javax.swing.JLabel();
        tv_namaPengguna = new javax.swing.JLabel();
        tv_hakAkses = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(Colors.BACKGROUND_COLOR);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });

        tv_namaPetugas.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(13f)
        );
        tv_namaPetugas.setForeground(Colors.TEXT_COLOR);
        tv_namaPetugas.setText("Rizal Hadiyansah");

        tv_namaPengguna.setFont(Fonts.ROBOTO_REGULAR.deriveFont(13f)
        );
        tv_namaPengguna.setForeground(Colors.GREY_TEXT_COLOR);
        tv_namaPengguna.setText("a_lpha");

        tv_hakAkses.setFont(Fonts.ROBOTO_REGULAR.deriveFont(13f)
        );
        tv_hakAkses.setForeground(Colors.GREY_TEXT_COLOR);
        tv_hakAkses.setText("Administrator");

        jSeparator1.setForeground(Colors.BORDER_COLOR);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tv_namaPetugas, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addGap(16, 16, 16)
                .addComponent(tv_namaPengguna, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addGap(16, 16, 16)
                .addComponent(tv_hakAkses, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jSeparator1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tv_namaPetugas)
                    .addComponent(tv_namaPengguna)
                    .addComponent(tv_hakAkses))
                .addGap(16, 16, 16)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        setBackground(Colors.BLUE_BACKGROUND_COLOR);
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        setBackground(Colors.BACKGROUND_COLOR);
    }//GEN-LAST:event_formMouseExited

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        context.showSidebar(petugas);
    }//GEN-LAST:event_formMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel tv_hakAkses;
    private javax.swing.JLabel tv_namaPengguna;
    private javax.swing.JLabel tv_namaPetugas;
    // End of variables declaration//GEN-END:variables
}
