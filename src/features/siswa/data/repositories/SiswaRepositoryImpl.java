package features.siswa.data.repositories;

import cores.entities.Kelas;
import cores.entities.Siswa;
import cores.entities.Spp;
import cores.exceptions.IllegalOrphanException;
import cores.exceptions.NonexistentEntityException;
import cores.exceptions.PreexistingEntityException;
import cores.exceptions.ServerException;
import cores.exceptions.UnexpectedException;
import cores.styles.Constants;
import cores.styles.Strings;
import cores.utils.AlertDialog;
import cores.utils.ImageProcessor;
import cores.utils.Navigator;
import cores.utils.Scalr;
import cores.widgets.RoundedBorder;
import features.siswa.data.datasources.SiswaLocalDataSource;
import features.siswa.data.datasources.SiswaRemoteDataSource;
import features.siswa.presentation.pages.AddSiswaPage;
import features.siswa.presentation.pages.DetailSiswaPage;
import features.siswa.presentation.pages.ListSiswaPage;
import features.siswa.presentation.widgets.SiswaTile;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import main.MainFrame;

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
    public void initListSiswaWithoutThumbnail(ListSiswaPage context,
            int maxResults, int firstResult) {
        context.isLoading = true;
        try {
            final var result = remoteDataSource.getListSiswaWithoutThumbnail(
                    maxResults, firstResult);
            if (result == null) {
                context.isLasIndex = true;
                return;
            }

            final var widthTile = (MainFrame.content.getSize().width / 3) - (4 * 3);
            for (int i = 0; i < result.size(); i++) {
                final var siswa = result.get(i);
                final var siswaTile = new SiswaTile(this, siswa);
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
    public void initListSiswaByJenisKelaminWithoutThumbnail(
            ListSiswaPage context, char keyword, int maxResults, int firstResult) {
        context.isLoading = true;
        try {
            final var result = remoteDataSource
                    .getListSiswaByJenisKelaminWithoutThumbnail(
                            keyword, maxResults, firstResult);
            if (result == null) {
                context.isLasIndex = true;
                return;
            }
            final var widthTile = (MainFrame.content.getSize().width / 3) - (4 * 3);

            for (int i = 0; i < result.size(); i++) {
                final var siswa = result.get(i);
                final var siswaTile = new SiswaTile(this, siswa);
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
    public void initDropdownKelas(AddSiswaPage context) {
        try {
            final var result = remoteDataSource.getListKelas();
            if (result == null) {
                return;
            }
            context.cb_kelas.setModel(new DefaultComboBoxModel<>(result
                    .toArray(new Kelas[result.size()])));
        } catch (ServerException ex) {
            AlertDialog.showErrorDialog(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initDropdownSpp(AddSiswaPage context) {
        try {
            final var result = remoteDataSource.getListSpp();
            if (result == null) {
                return;
            }
            context.cb_spp.setModel(new DefaultComboBoxModel<>(result
                    .toArray(new Spp[result.size()])));
        } catch (ServerException ex) {
            AlertDialog.showErrorDialog(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initDetailSiswa(String nisn) {
        try {
            final var result = remoteDataSource.getSiswa(nisn);
            if (result == null) {
                AlertDialog.showErrorDialog(Strings.ERROR_DIALOG_NULL_DATA);
                return;
            }
            Navigator.push(new DetailSiswaPage(this, result));
        } catch (ServerException ex) {
            AlertDialog.showErrorDialog(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initSiswaThumbnail(SiswaTile siswaTile) {
        try {
            final var result = remoteDataSource.getSiswaThumbnail(
                    siswaTile.siswa.getNisn());
            if (result == null) {
                return;
            }
            siswaTile.tv_image.setIcon(new ImageIcon(result));
            siswaTile.siswa.setFoto(result);
            siswaTile.setFoto(result);
        } catch (ServerException ex) {
            AlertDialog.showErrorDialog(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void getImageFromDisk(AddSiswaPage context, int width, int height) {
        try {
            final var result = localDataSource.getImageFromDisk();
            if (result == null) {
                return;
            }
            final var resizedImage = Scalr.resize(ImageIO.read(result), height,
                    height);
            final var croppedImage = Scalr.crop(resizedImage, width, height);
            final var roundedImage = ImageProcessor.roundImage(croppedImage,
                    Constants.BORDER_RADIUS);

            context.b_addImage.setIcon(new ImageIcon(roundedImage));
            context.b_addImage.setText(null);
            context.b_addImage.setBorder(null);
            context.foto = ImageProcessor.toByteArray(croppedImage);

//            for (var file : result.getParentFile().listFiles()) {
//                final var a = Scalr.resize(ImageIO.read(file),
//                        Scalr.Method.ULTRA_QUALITY,
//                        Scalr.Mode.AUTOMATIC, 180, 180, (BufferedImageOp) null);
//                final var siswa = new Siswa();
//                siswa.setNama(file.getName().replace(".JPG", ""));
//                siswa.setAlamat(file.getPath());
//                siswa.setFoto(ImageProcessor.toByteArray(a));
//                siswa.setIdKelas((Kelas) context.cb_kelas.getSelectedItem());
//                siswa.setSppBulanIni("Belum dibayar");
//                siswa.setJenisKelamin('L');
//                siswa.setIdSpp((Spp) context.cb_spp.getSelectedItem());
//                var nisn = "";
//                var nis = "";
//                for (int i = 0; i < 10; i++) {
//                    nisn += new Random().nextInt(9);
//                }
//                for (int i = 0; i < 8; i++) {
//                    nis += new Random().nextInt(9);
//                }
//                siswa.setNisn(nisn);
//                siswa.setNis(nis);
//                siswa.setNoTelepon(String.valueOf(new Random()
//                        .nextInt(999999999)));
//                siswaRemoteDataSource.insertSiswa(siswa);
//            }
        } catch (IOException | UnexpectedException ex) {
            AlertDialog.showErrorDialog(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        }
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
        final var jenisKelamin = context.cb_jenisKelamin.getSelectedItem()
                .equals(Strings.LAKI_LAKI)
                ? Strings.DATABASE_JENIS_KELAMIN_L
                : Strings.DATABASE_JENIS_KELAMIN_P;

        if (nisn.isBlank() || nis.isBlank() || nama.isBlank()
                || noTelepon.isBlank() || alamat.isBlank() || kelas == null
                || spp == null || nisn.length() < 10 || nis.length() < 8) {
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
            siswa.setJenisKelamin(jenisKelamin);
            siswa.setIdKelas(kelas);
            siswa.setIdSpp(spp);
            siswa.setSppBulanIni(context.siswa == null ? "Belum dibayar"
                    : context.siswa.getSppBulanIni());

            if (context.siswa == null) {
                remoteDataSource.insertSiswa(siswa);

                clear(context);
                AlertDialog.showDialog(Strings.SUCCESS_DIALOG_DEFAULT,
                        Strings.SUCCESS_DIALOG_INSERT);
            } else {
                remoteDataSource.updateSiswa(siswa);
                Navigator.push(new DetailSiswaPage(this, siswa));
            }
        } catch (PreexistingEntityException | ServerException
                | IllegalOrphanException | NonexistentEntityException ex) {
            AlertDialog.showErrorDialog(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteSiswa(String nisn) {
        try {
            remoteDataSource.deleteSiswa(nisn);
            Navigator.push(new ListSiswaPage(this));
        } catch (IllegalOrphanException | NonexistentEntityException ex) {
            AlertDialog.showErrorDialog(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void clear(AddSiswaPage context) {
        context.b_addImage.setText("Tambah foto");
        context.b_addImage.setBorder(new RoundedBorder());
        context.b_addImage.setIcon(null);
        context.siswa = null;

        context.et_nisn.setText(null);
        context.et_nis.setText(null);
        context.et_namaSiswa.setText(null);
        context.et_noTelepon.setText(null);
        context.et_alamat.setText(null);
    }
}
