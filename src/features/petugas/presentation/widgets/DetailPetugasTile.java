package features.petugas.presentation.widgets;

import cores.styles.Colors;
import cores.styles.Fonts;
import features.petugas.presentation.pages.DetailPetugasPage;
import java.awt.Cursor;

/**
 *
 * @author rizal
 */
public class DetailPetugasTile extends javax.swing.JPanel {
    private static final long serialVersionUID = 1L;

    private final DetailPetugasPage context;
    private final String title;
    private String content;
    private Runnable onPressed;
    private int index;
    private boolean isLastIndex = false;

    public DetailPetugasTile(DetailPetugasPage context, String title,
            String content) {
        this.context = context;
        this.title = title.toUpperCase();
        this.content = content;
        initComponents();
        init();
    }

    private void init() {
        s_full.setVisible(false);
        tv_icon.setVisible(false);
        tv_title.setText(title);
        tv_content.setText(content);
    }

    private void onMouseEntered() {
        setSeparatorLength(true);
        setBackground(Colors.GREY_BACKGROUND_COLOR);

        final var result = context.getLastDetailTile(index);
        if (result != null) {
            result.setSeparatorLength(true);
        }
    }

    private void onMouseExited() {
        setSeparatorLength(false);
        setBackground(Colors.BACKGROUND_COLOR);

        final var result = context.getLastDetailTile(index);
        if (result != null) {
            result.setSeparatorLength(false);
        }
    }

    public void setSeparatorLength(boolean isFull) {
        if (!isLastIndex) {
            s_half.setVisible(!isFull);
            s_full.setVisible(isFull);
        }
    }

    public void markAsLastIndex() {
        s_full.setVisible(false);
        s_half.setVisible(false);
        isLastIndex = true;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setContent(String content) {
        this.content = content;
        tv_content.setText(content);
    }

    public void setOnPressed(Runnable onPressed) {
        this.onPressed = onPressed;
        tv_icon.setVisible(true);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tv_title = new javax.swing.JLabel();
        tv_content = new javax.swing.JLabel();
        s_half = new javax.swing.JSeparator();
        s_full = new javax.swing.JSeparator();
        tv_icon = new javax.swing.JLabel();

        setBackground(Colors.BACKGROUND_COLOR);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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

        tv_title.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(11f)
        );
        tv_title.setForeground(Colors.GREY_TEXT_COLOR);
        tv_title.setText("Nama Lengkap");
        tv_title.setIconTextGap(12);

        tv_content.setFont(Fonts.ROBOTO_REGULAR.deriveFont(16f)
        );
        tv_content.setForeground(Colors.TEXT_COLOR);
        tv_content.setText("a_lpha");

        s_half.setForeground(Colors.BORDER_COLOR);

        s_full.setForeground(Colors.BORDER_COLOR);

        tv_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/ic_chevron-right_grey.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(s_full, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(s_half, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tv_title, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(tv_content, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                        .addGap(8, 8, 8)
                        .addComponent(tv_icon)
                        .addGap(24, 24, 24))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tv_content, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tv_title, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tv_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(s_half, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(s_full, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        if (onPressed != null) {
            onMouseEntered();
        }
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        if (onPressed != null) {
            onMouseExited();
        }
    }//GEN-LAST:event_formMouseExited

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if (onPressed != null) {
            onMouseExited();
            onPressed.run();
        }
    }//GEN-LAST:event_formMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator s_full;
    private javax.swing.JSeparator s_half;
    private javax.swing.JLabel tv_content;
    private javax.swing.JLabel tv_icon;
    private javax.swing.JLabel tv_title;
    // End of variables declaration//GEN-END:variables
}
