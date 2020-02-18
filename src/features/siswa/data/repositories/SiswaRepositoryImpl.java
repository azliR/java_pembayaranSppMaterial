package features.siswa.data.repositories;

import cores.entities.Kelas;
import cores.entities.Siswa;
import cores.entities.Spp;
import cores.exceptions.PreexistingEntityException;
import cores.exceptions.ServerException;
import cores.exceptions.UnexpectedException;
import cores.styles.Constants;
import cores.styles.Strings;
import cores.utils.AlertDialog;
import cores.utils.ImageProcessor;
import cores.widgets.RoundedBorder;
import features.siswa.data.datasources.SiswaLocalDataSource;
import features.siswa.data.datasources.SiswaRemoteDataSource;
import features.siswa.presentation.pages.AddSiswaPage;
import features.siswa.presentation.pages.ListSiswaPage;
import features.siswa.presentation.widgets.SiswaTile;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImageOp;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import static main.Main.siswaRemoteDataSource;
import main.MainFrame;
import org.imgscalr.Scalr;

/**
 *
 * @author rizal
 */
public class SiswaRepositoryImpl implements SiswaRepository {
    private static final Logger LOG = Logger.getLogger(SiswaRepositoryImpl.class
            .getName());

    final SiswaRemoteDataSource remoteDataSource;
    final SiswaLocalDataSource localDataSource;

    public SiswaRepositoryImpl(
            SiswaRemoteDataSource siswaRemoteDataSource,
            SiswaLocalDataSource localDataSource) {
        this.remoteDataSource = siswaRemoteDataSource;
        this.localDataSource = localDataSource;
    }

    @Override
    public void getListSiswaWithoutThumbnail(ListSiswaPage context,
            int maxResults, int firstResult) {
        context.isLoading = true;
        try {
            final var result = remoteDataSource.getListSiswaWithoutThumbnail(
                    maxResults, firstResult);
            final var widthTile = (MainFrame.content.getSize().width / 3) - (4 * 3);

            for (int i = 0; i < result.size(); i++) {
                final var siswa = result.get(i);
                final var siswaTile = new SiswaTile(siswa);
                siswaTile.setPreferredSize(new Dimension(widthTile,
                        siswaTile.getPreferredSize().height));

                if (i + 1 == result.size()) {
                    siswaTile.addComponentListener(new ComponentAdapter() {
                        @Override
                        public void componentResized(ComponentEvent e) {
                            context.isLoading = false;
                            super.componentResized(e);
                        }
                    });
                }
                context.gridLayout.add(siswaTile);
                context.listSiswaTiles.add(siswaTile);
            }

            context.listSiswa.addAll(result);
            context.currentIndex += result.size();
            context.isLasIndex = result.size() < context.maxResult;
        } catch (ServerException ex) {
            AlertDialog.showErrorDialog(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Kelas> initDropdownKelas(AddSiswaPage context) {
        try {
            final var result = remoteDataSource.getListKelas();
            context.cb_kelas.setModel(new DefaultComboBoxModel<>(result
                    .toArray(new Kelas[result.size()])));
        } catch (ServerException ex) {
            AlertDialog.showErrorDialog(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Spp> initDropdownSpp(AddSiswaPage context) {
        try {
            final var result = remoteDataSource.getListSpp();
            context.cb_spp.setModel(new DefaultComboBoxModel<>(result
                    .toArray(new Spp[result.size()])));
        } catch (ServerException ex) {
            AlertDialog.showErrorDialog(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public byte[] getSiswaThumbnail(String nisn) {
        try {
            return remoteDataSource.getSiswaThumbnail(nisn);
        } catch (ServerException ex) {
            Logger.getLogger(SiswaRepositoryImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public byte[] getImageFromDisk(AddSiswaPage context, int width, int height) {
        try {
            final var result = localDataSource.getImageFromDisk();
            if (result == null) {
                return null;
            }
            final var resizedImage = Scalr.resize(ImageIO.read(result), width,
                    height);
            final var roundedImage = ImageProcessor.roundImage(resizedImage,
                    Constants.BORDER_RADIUS);
            final var compressedImage = Scalr.resize(ImageIO.read(result),
                    Scalr.Method.QUALITY,
                    Scalr.Mode.AUTOMATIC, 720, 720, (BufferedImageOp) null);

            context.b_addImage.setIcon(new ImageIcon(roundedImage));
            context.b_addImage.setText(null);
            context.b_addImage.setBorder(null);
            context.foto = ImageProcessor.toByteArray(compressedImage);

            for (var file : result.getParentFile().listFiles()) {
                final var a = Scalr.resize(ImageIO.read(file),
                        Scalr.Method.ULTRA_QUALITY,
                        Scalr.Mode.AUTOMATIC, 180, 180, (BufferedImageOp) null);
                final var siswa = new Siswa();
                siswa.setNama(file.getName().replace(".JPG", ""));
                siswa.setAlamat(file.getPath());
                siswa.setFoto(ImageProcessor.toByteArray(a));
                siswa.setIdKelas((Kelas) context.cb_kelas.getSelectedItem());
                siswa.setBulanIni("Belum dibayar");
                siswa.setIdSpp((Spp) context.cb_spp.getSelectedItem());
                var nisn = "";
                var nis = "";
                for (int i = 0; i < 10; i++) {
                    nisn += new Random().nextInt(9);
                }
                for (int i = 0; i < 8; i++) {
                    nis += new Random().nextInt(9);
                }
                siswa.setNisn(nisn);
                siswa.setNis(nis);
                siswa.setNoTelepon(String.valueOf(new Random()
                        .nextInt(999999999)));
                siswaRemoteDataSource.insertSiswa(siswa);
            }

            return context.foto;
        } catch (IOException | UnexpectedException ex) {
            AlertDialog.showErrorDialog(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        } catch (PreexistingEntityException ex) {
            Logger.getLogger(SiswaRepositoryImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        } catch (ServerException ex) {
            Logger.getLogger(SiswaRepositoryImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void insertSiswa(AddSiswaPage context) {
        final var foto = context.foto;
        final var nisn = context.et_nisn.getText();
        final var nis = context.et_nis.getText();
        final var nama = context.et_namaSiswa.getText();
        final var noTelepon = context.et_noTelepon.getText();
        final var alamat = context.et_alamat.getText();
        final var kelas = (Kelas) context.cb_kelas.getSelectedItem();
        final var spp = (Spp) context.cb_spp.getSelectedItem();

        if (nisn.isBlank() || nis.isBlank() || nama.isBlank() || noTelepon
                .isBlank() || alamat.isBlank() || kelas == null || spp == null) {
            AlertDialog.showErrorDialog(Strings.ERROR_DIALOG_EMPTY_FIELD);
            return;
        }

        try {
            final var siswa = new Siswa();
            siswa.setNisn(nisn);
            siswa.setNis(nis);
            siswa.setNama(nama);
            siswa.setFoto(foto);
            siswa.setNoTelepon(noTelepon);
            siswa.setAlamat(alamat);
            siswa.setIdKelas(kelas);
            siswa.setIdSpp(spp);
            siswa.setBulanIni("Belum dibayar");

            remoteDataSource.insertSiswa(siswa);

            clear(context);
            AlertDialog.showDialog(Strings.SUCCESS_DIALOG_DEFAULT,
                    Strings.SUCCESS_DIALOG_INSERT);
        } catch (PreexistingEntityException | ServerException ex) {
            AlertDialog.showErrorDialog(ex.getMessage());
            Logger.getLogger(SiswaRepositoryImpl.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }

    @Override
    public void clear(AddSiswaPage context) {
        context.b_addImage.setText("Tambah foto");
        context.b_addImage.setBorder(new RoundedBorder());
        context.b_addImage.setIcon(null);
        context.foto = null;

        context.et_nisn.setText(null);
        context.et_nis.setText(null);
        context.et_namaSiswa.setText(null);
        context.et_noTelepon.setText(null);
        context.et_alamat.setText(null);
    }
}
