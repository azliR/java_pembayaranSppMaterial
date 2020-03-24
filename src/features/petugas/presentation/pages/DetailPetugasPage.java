package features.petugas.presentation.pages;

import cores.entities.Petugas;
import cores.provider.SharedPreferences;
import cores.styles.Colors;
import cores.styles.Consts;
import cores.styles.Fonts;
import cores.utils.ImageProcessor;
import cores.utils.Navigator;
import cores.utils.Scalr;
import cores.widgets.RoundedPanel;
import cores.widgets.ScrollView;
import features.petugas.data.repositories.PetugasRepository;
import features.petugas.presentation.widgets.DetailPetugasTile;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import main.MainFrame;

/**
 *
 * @author rizal
 */
public class DetailPetugasPage extends javax.swing.JPanel {
    private static final long serialVersionUID = 1L;

    private final List<DetailPetugasTile> detailPetugasTiles = new ArrayList<>();

    private final PetugasRepository repository;
    private final SharedPreferences preferences;
    private final Petugas petugas;

    public DetailPetugasPage(PetugasRepository repository,
            SharedPreferences preferences, Petugas petugas) {
        this.repository = repository;
        this.preferences = preferences;
        this.petugas = petugas;
        initComponents();
        init();
    }

    private void init() {
        setFoto(petugas.getFoto());
        detailPetugasTiles.add(new DetailPetugasTile(
                this, 0, "NAMA LENGKAP", petugas.getNamaPetugas(),
                null));
        detailPetugasTiles.add(new DetailPetugasTile(
                this, 1, "NAMA PENGGUNA", petugas.getNamaPengguna(), null));
        detailPetugasTiles.add(new DetailPetugasTile(
                this, 2, "NO. TELEPON", petugas.getNoTelepon(), null));

        detailPetugasTiles.add(new DetailPetugasTile(
                this, 3, "KATA SANDI", "••••••••",
                () -> {
            Navigator.push(new EditPetugasPasswordPage(repository,
                    preferences, petugas), true, false);
        }));

        final var paddingLeft = 48;
        final var paddingRight = 208;
        final var borderSize = 1 * 2;
        final var totalPadding = paddingLeft + paddingRight + borderSize;
        final var width = MainFrame.content.getWidth() - totalPadding;
        detailPetugasTiles.forEach((detailPetugasTile) -> {
            final var height = detailPetugasTile.getPreferredSize().height;
            final var newSize = new Dimension(width, height);
            detailPetugasTile.setPreferredSize(newSize);
            p_listDetail.add(detailPetugasTile);
        });
    }

    private DetailPetugasTile getNamaTile() {
        final var properties = new EditGeneralPetugasDataPage.Properties();
        properties.setTitle("Ubah Nama");
        properties.setDecription("Perubahan nama akan diterapkan di akun Anda.");
        properties.setInitialValue(petugas.getNamaPetugas());
        properties.setLabel("Nama Baru");
        properties.setOnSave((data) -> {
            petugas.setNamaPetugas(data);
//            repository.updatePetugas(context, data);
        });
        return new DetailPetugasTile(this, WIDTH, TOOL_TIP_TEXT_KEY,
                TOOL_TIP_TEXT_KEY, null);
    }

    public DetailPetugasTile getLastDetailTile(int index) {
        if (index != 0) {
            final var result = detailPetugasTiles.get(index - 1);
            return result;
        }
        return null;
    }

    private void setFoto(byte[] foto) {
        if (foto == null) {
            final var random = new Random();
            final var red = random.nextInt(256);
            final var green = random.nextInt(256);
            final var blue = random.nextInt(256);
            final var color = new Color(red, green, blue);
            p_profile.setBackground(color.darker());
            tv_profile.setText(String
                    .valueOf(petugas.getNamaPetugas().charAt(0))
                    .toUpperCase());
            return;
        }
        final var maxWidth = 84;
        final var maxHeight = 84;

        var image = ImageProcessor.byteArrayToBufferedImage(foto);
        if (image.getWidth(null) > maxWidth || image.getHeight(null) > maxHeight) {
            image = Scalr.resize(image, Scalr.Mode.FIT_TO_WIDTH, maxWidth,
                    maxHeight);
        }
        final var croppedImage = Scalr.crop(image, maxWidth, maxHeight);
        final var roundedImage = ImageProcessor.roundImage(croppedImage,
                maxWidth);

        tv_profile.setIcon(new ImageIcon(roundedImage));
        petugas.setFoto(foto);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new ScrollView(jPanel3);
        jPanel3 = new javax.swing.JPanel();
        p_card = new RoundedPanel(Consts.MEDIUM_BORDER_RADIUS);
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        p_listDetail = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        p_profile = new RoundedPanel(84);
        tv_profile = new javax.swing.JLabel();

        setBackground(Colors.BACKGROUND_COLOR);
        setOpaque(false);

        jScrollPane1.setBackground(Colors.BACKGROUND_COLOR);
        jScrollPane1.setBorder(null);

        jPanel3.setBackground(Colors.BACKGROUND_COLOR);

        p_card.setBackground(Colors.CARD_COLOR);
        p_card.setBorder(new cores.widgets.RoundedRectangleBorder(Consts.MEDIUM_BORDER_RADIUS, Consts.ZERO_BORDER_INSETS, Colors.BORDER_COLOR));

        jLabel3.setFont(Fonts.PRODUCT_SANS_REGULAR.deriveFont(21f));
        jLabel3.setForeground(Colors.TEXT_COLOR);
        jLabel3.setText("Profil");

        jPanel1.setBackground(Colors.CARD_COLOR);
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        p_listDetail.setLayout(new java.awt.GridLayout(0, 1));
        jPanel1.add(p_listDetail);

        jLabel2.setFont(Fonts.ROBOTO_REGULAR.deriveFont(14f)
        );
        jLabel2.setForeground(Colors.GREY_TEXT_COLOR);
        jLabel2.setText("Info ini akan ditampilkan ketika Anda melakukan transaksi pembayaran.");

        javax.swing.GroupLayout p_cardLayout = new javax.swing.GroupLayout(p_card);
        p_card.setLayout(p_cardLayout);
        p_cardLayout.setHorizontalGroup(
            p_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(p_cardLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(p_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        p_cardLayout.setVerticalGroup(
            p_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_cardLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(Fonts.PRODUCT_SANS_REGULAR.deriveFont(27f));
        jLabel1.setForeground(Colors.TEXT_COLOR);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Rizal Hadiyansah");

        jPanel4.setBackground(Colors.BACKGROUND_COLOR);
        jPanel4.setOpaque(false);

        p_profile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        p_profile.setLayout(new java.awt.CardLayout());

        tv_profile.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(28f));
        tv_profile.setForeground(Colors.WHITE_TEXT_COLOR);
        tv_profile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p_profile.add(tv_profile, "card2");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(153, Short.MAX_VALUE)
                .addComponent(p_profile, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(154, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(p_profile, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p_card, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(208, 208, 208))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addComponent(p_card, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(36, 36, 36))
        );

        jScrollPane1.setViewportView(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel p_card;
    private javax.swing.JPanel p_listDetail;
    private javax.swing.JPanel p_profile;
    private javax.swing.JLabel tv_profile;
    // End of variables declaration//GEN-END:variables
}
