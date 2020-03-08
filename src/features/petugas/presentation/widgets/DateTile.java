package features.petugas.presentation.widgets;

import cores.styles.Colors;
import cores.styles.Fonts;
import java.util.Date;

/**
 *
 * @author rizal
 */
public class DateTile extends javax.swing.JPanel {
    private static final long serialVersionUID = 1L;

    private final Date date;

    public DateTile(Date date) {
        this.date = date;
        initComponents();
        init();
    }

    private void init() {
        tv_date.setText(date.toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tv_date = new javax.swing.JLabel();

        setBackground(Colors.BACKGROUND_COLOR);

        tv_date.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(12f));
        tv_date.setForeground(Colors.GREY_TEXT_COLOR);
        tv_date.setText("28 Januari 2020");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(tv_date)
                .addContainerGap(307, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(tv_date)
                .addGap(8, 8, 8))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel tv_date;
    // End of variables declaration//GEN-END:variables
}
