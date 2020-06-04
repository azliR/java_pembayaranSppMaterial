package features.petugas.presentation.pages;

import cores.entities.Petugas;
import cores.styles.Colors;
import cores.styles.Consts;
import cores.styles.Fonts;
import cores.styles.Strings;
import cores.utils.ImageProcessor;
import cores.utils.Intl;
import cores.utils.Navigator;
import cores.utils.Scalr;
import cores.widgets.RoundedPanel;
import cores.widgets.ScrollView;
import features.auth.data.repositories.AuthRepository;
import features.auth.presentation.pages.LoginPage;
import features.petugas.data.repositories.PetugasRepository;
import features.petugas.presentation.widgets.DetailPetugasTile;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import main.MainFrame;

/**
 *
 * @author rizal
 */
public class DetailPetugasPage extends javax.swing.JPanel {
    private static final long serialVersionUID = 1L;

    private final List<DetailPetugasTile> profilTiles = new ArrayList<>();
    private final List<DetailPetugasTile> infoLainnyaTiles = new ArrayList<>();

    private final PetugasRepository repository;
    private final AuthRepository authRepository;
    private final Petugas petugas;

    public DetailPetugasPage(PetugasRepository repository,
            AuthRepository authRepository,
            Petugas petugas) {
        this.repository = repository;
        this.authRepository = authRepository;
        this.petugas = petugas;
        initComponents();
        init();
    }

    private void init() {
        setFoto(petugas.getFoto());

        tv_hakAkses.setText(petugas.getHakAkses());
        tv_profil.setText(Strings.PROFIL);
        tv_profilDesc.setText(Strings.PROFIL_DESC);
        tv_infoLainnya.setText(Strings.INFO_LAINNYA);
        tv_infoLainnyaDesc.setText(Strings.INFO_LAINNYA_DESC);

        initProfil();
        initInfoLainnya();
    }

    private void initInfoLainnya() {
        infoLainnyaTiles.add(new DetailPetugasTile(this,
                Strings.DIBUAT_PADA,
                Intl.convertTimestamp(petugas.getDibuatPada())));
        infoLainnyaTiles.add(new DetailPetugasTile(this,
                Strings.TERAKHIR_MASUK,
                Intl.convertTimestamp(petugas.getTerakhirMasuk())));
        infoLainnyaTiles.add(new DetailPetugasTile(this,
                Strings.TERAKHIR_UBAH_SANDI,
                Intl.convertTimestamp(petugas.getTerakhirUbahSandi())));
        infoLainnyaTiles.add(new DetailPetugasTile(this,
                Strings.STATUS,
                petugas.getStatus()));
        addAllTiles(infoLainnyaTiles, p_listInfoLainnya);
    }

    private void initProfil() {
        profilTiles.add(getNamaLengkapTile());
        profilTiles.add(getNamaPenggunaTile());
        profilTiles.add(getNoTeleponTile());
        profilTiles.add(getSandiTile());
        addAllTiles(profilTiles, p_listProfil);
    }

    private void addAllTiles(List<DetailPetugasTile> tiles,
            JComponent destination) {
        final var paddingLeft = 48;
        final var paddingRight = 208;
        final var totalPadding = paddingLeft + paddingRight;
        final var width = MainFrame.content.getWidth() - totalPadding;

        for (int i = 0; i < tiles.size(); i++) {
            final var detailPetugasTile = tiles.get(i);
            final var height = detailPetugasTile.getPreferredSize().height;
            final var newSize = new Dimension(width, height);
            detailPetugasTile.setIndex(i);
            detailPetugasTile.setPreferredSize(newSize);

            if (i == tiles.size() - 1) {
                detailPetugasTile.markAsLastIndex();
            }
            destination.add(detailPetugasTile);
        }
    }

    private DetailPetugasTile getNamaLengkapTile() {
        final var tile = new DetailPetugasTile(
                this, Strings.NAMA_LENGKAP, petugas.getNamaPetugas());
        final var properties = new EditGeneralPetugasDataPage.Properties();
        properties.setTitle(Strings.UBAH_NAMA);
        properties.setDecription(Strings.UBAH_NAMA_DESC);
        properties.setInitialValue(petugas.getNamaPetugas());
        properties.setLabel(Strings.NAMA_BARU);
        properties.setMaxLength(36);
        properties.setOnBack(() -> launchBackTile());
        properties.setOnSave((data) -> {
            petugas.setNamaPetugas(data);
            final var result = repository.updatePetugas(this, petugas);
            if (result) {
                properties.setInitialValue(data);
                tile.setContent(data);
                Navigator.push(this);
            }
        });
        tile.setOnPressed(() -> launchTile(properties));
        return tile;
    }

    private DetailPetugasTile getNamaPenggunaTile() {
        final var tile = new DetailPetugasTile(
                this, Strings.NAMA_PENGGUNA, petugas.getNamaPengguna());
        final var properties = new EditGeneralPetugasDataPage.Properties();
        properties.setTitle(Strings.UBAH_NAMA_PENGGUNA);
        properties.setDecription(Strings.UBAH_NAMA_PENGGUNA_DESC);
        properties.setInitialValue(petugas.getNamaPengguna());
        properties.setLabel(Strings.NAMA_PENGGUNA_BARU);
        properties.setIsWhiteSpace(false);
        properties.setMaxLength(26);
        properties.setOnBack(() -> launchBackTile());
        properties.setOnSave((data) -> {
            petugas.setNamaPengguna(data);
            final var result = repository.updatePetugas(this, petugas);
            if (result) {
                properties.setInitialValue(data);
                tile.setContent(data);
                Navigator.push(this);
            }
        });
        tile.setOnPressed(() -> launchTile(properties));
        return tile;
    }

    private DetailPetugasTile getNoTeleponTile() {
        final var tile = new DetailPetugasTile(
                this, Strings.NOMOR_TELEPON, petugas.getNoTelepon());
        final var properties = new EditGeneralPetugasDataPage.Properties();
        properties.setTitle(Strings.UBAH_NOMOR_TELEPON);
        properties.setDecription(Strings.UBAH_NOMOR_TELEPON_DESC);
        properties.setInitialValue(petugas.getNoTelepon());
        properties.setLabel(Strings.NOMOR_TELEPON_BARU);
        properties.setIsDigitOnly(true);
        properties.setMaxLength(13);
        properties.setOnBack(() -> launchBackTile());
        properties.setOnSave((data) -> {
            petugas.setNoTelepon(data);
            final var result = repository.updatePetugas(this, petugas);
            if (result) {
                properties.setInitialValue(data);
                tile.setContent(data);
                Navigator.push(this);
            }
        });

        tile.setOnPressed(() -> launchTile(properties));
        return tile;
    }

    private DetailPetugasTile getSandiTile() {
        final var tile = new DetailPetugasTile(this, Strings.KATA_SANDI, "••••••••");
        final var editPasswordPage = new EditPetugasPasswordPage(authRepository);
        editPasswordPage.setOnBack(() -> launchBackTile());
        editPasswordPage.setOnSave((data) -> {
            petugas.setKataSandi(data);
            final var result = repository.updatePetugas(this, petugas);
            if (result) {
                Navigator.push(this);
            }
        });

        tile.setOnPressed(() -> {
            Navigator.push(new LoginPage(authRepository, () -> {
                Navigator.push(editPasswordPage, true, false);
            }), false, false);
        });
        return tile;
    }

    private void launchTile(EditGeneralPetugasDataPage.Properties properties) {
        Navigator.push(new EditGeneralPetugasDataPage(properties), true, false);
    }

    private void launchBackTile() {
        Navigator.push(this);
    }

    public DetailPetugasTile getLastDetailTile(int index) {
        if (index != 0) {
            final var result = profilTiles.get(index - 1);
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
            tv_foto.setText(String
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

        tv_foto.setIcon(new ImageIcon(roundedImage));
        petugas.setFoto(foto);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new ScrollView(jPanel3);
        jPanel3 = new javax.swing.JPanel();
        p_card = new RoundedPanel(Consts.MEDIUM_BORDER_RADIUS);
        tv_profil = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        p_listProfil = new javax.swing.JPanel();
        tv_profilDesc = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        p_profile = new RoundedPanel(84);
        tv_foto = new javax.swing.JLabel();
        tv_hakAkses = new javax.swing.JLabel();
        p_card1 = new RoundedPanel(Consts.MEDIUM_BORDER_RADIUS);
        tv_infoLainnya = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        p_listInfoLainnya = new javax.swing.JPanel();
        tv_infoLainnyaDesc = new javax.swing.JLabel();

        setBackground(Colors.BACKGROUND_COLOR);
        setOpaque(false);

        jScrollPane1.setBackground(Colors.BACKGROUND_COLOR);
        jScrollPane1.setBorder(null);

        jPanel3.setBackground(Colors.BACKGROUND_COLOR);

        p_card.setBackground(Colors.CARD_COLOR);
        p_card.setBorder(new cores.widgets.RoundedRectangleBorder(Consts.MEDIUM_BORDER_RADIUS, Consts.INSETS_1, Colors.BORDER_COLOR));

        tv_profil.setFont(Fonts.PRODUCT_SANS_REGULAR.deriveFont(21f));
        tv_profil.setForeground(Colors.TEXT_COLOR);
        tv_profil.setText("Profil");

        jPanel1.setBackground(Colors.CARD_COLOR);
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        p_listProfil.setLayout(new java.awt.GridLayout(0, 1));
        jPanel1.add(p_listProfil);

        tv_profilDesc.setFont(Fonts.ROBOTO_REGULAR.deriveFont(14f)
        );
        tv_profilDesc.setForeground(Colors.GREY_TEXT_COLOR);
        tv_profilDesc.setText("Info ini akan ditampilkan ketika Anda melakukan transaksi pembayaran.");

        javax.swing.GroupLayout p_cardLayout = new javax.swing.GroupLayout(p_card);
        p_card.setLayout(p_cardLayout);
        p_cardLayout.setHorizontalGroup(
            p_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(p_cardLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(p_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tv_profilDesc)
                    .addComponent(tv_profil))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        p_cardLayout.setVerticalGroup(
            p_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_cardLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(tv_profil)
                .addGap(12, 12, 12)
                .addComponent(tv_profilDesc)
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );

        jLabel1.setFont(Fonts.PRODUCT_SANS_REGULAR.deriveFont(25f));
        jLabel1.setForeground(Colors.TEXT_COLOR);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Rizal Hadiyansah");

        jPanel4.setBackground(Colors.BACKGROUND_COLOR);
        jPanel4.setOpaque(false);

        p_profile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        p_profile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p_profileMouseClicked(evt);
            }
        });
        p_profile.setLayout(new java.awt.CardLayout());

        tv_foto.setFont(Fonts.ROBOTO_MEDIUM.deriveFont(32f));
        tv_foto.setForeground(Colors.WHITE_TEXT_COLOR);
        tv_foto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p_profile.add(tv_foto, "card2");

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

        tv_hakAkses.setFont(Fonts.ROBOTO_REGULAR.deriveFont(16f)
        );
        tv_hakAkses.setForeground(Colors.DARKER_GREY_TEXT_COLOR);
        tv_hakAkses.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tv_hakAkses.setText("Petugas");

        p_card1.setBackground(Colors.CARD_COLOR);
        p_card1.setBorder(new cores.widgets.RoundedRectangleBorder(Consts.MEDIUM_BORDER_RADIUS, Consts.INSETS_1, Colors.BORDER_COLOR));

        tv_infoLainnya.setFont(Fonts.PRODUCT_SANS_REGULAR.deriveFont(21f));
        tv_infoLainnya.setForeground(Colors.TEXT_COLOR);
        tv_infoLainnya.setText("Info lainnya");

        jPanel2.setBackground(Colors.CARD_COLOR);
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        p_listInfoLainnya.setLayout(new java.awt.GridLayout(0, 1));
        jPanel2.add(p_listInfoLainnya);

        tv_infoLainnyaDesc.setFont(Fonts.ROBOTO_REGULAR.deriveFont(14f)
        );
        tv_infoLainnyaDesc.setForeground(Colors.GREY_TEXT_COLOR);
        tv_infoLainnyaDesc.setText("Info ini akan ditampilkan ketika Anda melakukan transaksi pembayaran.");

        javax.swing.GroupLayout p_card1Layout = new javax.swing.GroupLayout(p_card1);
        p_card1.setLayout(p_card1Layout);
        p_card1Layout.setHorizontalGroup(
            p_card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(p_card1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(p_card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tv_infoLainnyaDesc)
                    .addComponent(tv_infoLainnya))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        p_card1Layout.setVerticalGroup(
            p_card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_card1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(tv_infoLainnya)
                .addGap(12, 12, 12)
                .addComponent(tv_infoLainnyaDesc)
                .addGap(24, 24, 24)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tv_hakAkses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p_card, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p_card1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(208, 208, 208))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addComponent(tv_hakAkses)
                .addGap(24, 24, 24)
                .addComponent(p_card, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(p_card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(158, Short.MAX_VALUE))
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

    private void p_profileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_profileMouseClicked
        final var result = repository.getImageFromDisk(84, 84);
        if (result != null) {
            petugas.setFoto(ImageProcessor.toByteArray(result));
            final var isSuccess = repository.updatePetugas(this, petugas);

            if (isSuccess) {
                final var roundedImage = ImageProcessor.roundImage(result, 84);
                tv_foto.setIcon(new ImageIcon(roundedImage));
                tv_foto.setText(null);
            }
        }
    }//GEN-LAST:event_p_profileMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel p_card;
    private javax.swing.JPanel p_card1;
    private javax.swing.JPanel p_listInfoLainnya;
    private javax.swing.JPanel p_listProfil;
    private javax.swing.JPanel p_profile;
    private javax.swing.JLabel tv_foto;
    private javax.swing.JLabel tv_hakAkses;
    private javax.swing.JLabel tv_infoLainnya;
    private javax.swing.JLabel tv_infoLainnyaDesc;
    private javax.swing.JLabel tv_profil;
    private javax.swing.JLabel tv_profilDesc;
    // End of variables declaration//GEN-END:variables
}
