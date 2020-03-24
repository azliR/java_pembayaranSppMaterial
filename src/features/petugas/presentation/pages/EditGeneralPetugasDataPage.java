package features.petugas.presentation.pages;

import cores.styles.Colors;
import cores.styles.Fonts;
import java.util.function.Consumer;

/**
 *
 * @author rizal
 */
public class EditGeneralPetugasDataPage extends javax.swing.JPanel {
    private static final long serialVersionUID = 1L;

    private final Properties properties;

    public EditGeneralPetugasDataPage(Properties properties) {
        this.properties = properties;
        initComponents();
        init();
    }

    private void init() {
        if (properties != null) {
            tv_title.setText(properties.getTitle());
            tv_desc.setText(properties.getDecription());
            et_data.setText(properties.getInitialValue());
            et_data.setLabel(properties.getLabel());
            et_data.setIsDigitOnly(properties.isIsDigitOnly());
            et_data.setIsWhiteSpace(properties.isIsWhiteSpace());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tv_desc = new javax.swing.JLabel();
        tv_title = new javax.swing.JLabel();
        b_back = new cores.widgets.MaterialButton();
        b_save = new cores.widgets.MaterialButton();
        et_data = new cores.widgets.TextField();

        setOpaque(false);
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 24));

        jPanel1.setBackground(Colors.BACKGROUND_COLOR);

        tv_desc.setFont(Fonts.ROBOTO_REGULAR.deriveFont(14f)
        );
        tv_desc.setForeground(Colors.GREY_TEXT_COLOR);
        tv_desc.setText("Perubahan nama akan diterapkan di Akun Anda.");
        tv_desc.setMinimumSize(new java.awt.Dimension(231, 200));

        tv_title.setFont(Fonts.PRODUCT_SANS_REGULAR.deriveFont(21f)
        );
        tv_title.setForeground(Colors.TEXT_COLOR);
        tv_title.setText("Ubah Nama");

        b_back.setBorderRadius(36);
        b_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/ic_arrow-left_grey.png"))); // NOI18N
        b_back.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/ic_arrow-left_black.png"))); // NOI18N
        b_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_backActionPerformed(evt);
            }
        });

        b_save.setBackground(Colors.PRIMARY_COLOR);
        b_save.setForeground(Colors.WHITE_TEXT_COLOR);
        b_save.setText("Simpan");
        b_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_saveActionPerformed(evt);
            }
        });

        et_data.setLabel("Nama");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(b_back, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(tv_title)
                .addContainerGap(379, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(b_save, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(tv_desc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(et_data, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tv_title, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_back, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(tv_desc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(et_data, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(b_save, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void b_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_backActionPerformed
        if (properties != null && properties.onBack != null) {
            properties.onBack.run();
        }
    }//GEN-LAST:event_b_backActionPerformed

    private void b_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_saveActionPerformed
        if (properties != null && properties.onSave != null) {
            properties.onSave.accept(et_data.getText());
        }
    }//GEN-LAST:event_b_saveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private cores.widgets.MaterialButton b_back;
    private cores.widgets.MaterialButton b_save;
    private cores.widgets.TextField et_data;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel tv_desc;
    private javax.swing.JLabel tv_title;
    // End of variables declaration//GEN-END:variables

    public static class Properties {
        private String title;
        private String decription;
        private String label;
        private String initialValue;
        private Consumer<String> onSave;
        private Runnable onBack;
        private boolean isDigitOnly;
        private boolean isWhiteSpace;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDecription() {
            return decription;
        }

        public void setDecription(String decription) {
            this.decription = decription;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getInitialValue() {
            return initialValue;
        }

        public void setInitialValue(String initialValue) {
            this.initialValue = initialValue;
        }

        public Consumer<String> getOnSave() {
            return onSave;
        }

        public void setOnSave(Consumer<String> onSave) {
            this.onSave = onSave;
        }

        public Runnable getOnBack() {
            return onBack;
        }

        public void setOnBack(Runnable onBack) {
            this.onBack = onBack;
        }

        public boolean isIsDigitOnly() {
            return isDigitOnly;
        }

        public void setIsDigitOnly(boolean isDigitOnly) {
            this.isDigitOnly = isDigitOnly;
        }

        public boolean isIsWhiteSpace() {
            return isWhiteSpace;
        }

        public void setIsWhiteSpace(boolean isWhiteSpace) {
            this.isWhiteSpace = isWhiteSpace;
        }

    }
}
