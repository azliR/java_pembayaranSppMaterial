package features.petugas.presentation.widgets;

import cores.styles.Colors;
import cores.styles.Fonts;
import cores.utils.Intl;
import java.util.Date;

/**
 *
 * @author rizal
 */
public class DateTile extends javax.swing.JPanel {
    private static final long serialVersionUID = 1L;

    private final Date date;
    private final boolean withBorder;

    public DateTile(Date date) {
        this.date = date;
        this.withBorder = true;
        initComponents();
        init();
    }

    private void init() {
        tv_date.setText(Intl.convertTimestamp(date));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tv_date = new javax.swing.JLabel();

        setBackground(Colors.BACKGROUND_COLOR);

        tv_date.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(12f));
        tv_date.setForeground(Colors.GREY_TEXT_COLOR);
        tv_date.setText("28 September 2020");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(tv_date)
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 13, Short.MAX_VALUE)
                .addComponent(tv_date)
                .addGap(8, 8, 8))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel tv_date;
    // End of variables declaration//GEN-END:variables
}
