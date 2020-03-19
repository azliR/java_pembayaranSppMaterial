package features.siswa.data.repositories;

import cores.entities.Kelas;
import cores.entities.Siswa;
import cores.entities.Spp;
import cores.exceptions.IllegalOrphanException;
import cores.exceptions.NonexistentEntityException;
import cores.exceptions.PreexistingEntityException;
import cores.exceptions.ServerException;
import cores.exceptions.UnexpectedException;
import cores.styles.Strings;
import cores.utils.AlertDialog;
import cores.utils.Navigator;
import cores.utils.Scalr;
import cores.widgets.RoundedBorder;
import features.siswa.data.datasources.SiswaLocalDataSource;
import features.siswa.data.datasources.SiswaRemoteDataSource;
import features.siswa.presentation.pages.AddSiswaPage;
import features.siswa.presentation.pages.DetailSiswaPage;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author rizal
 */
public class SiswaRepositoryImpl implements SiswaRepository {
    private static final Logger LOG = Logger.getLogger(
            SiswaRepositoryImpl.class.getName());

    final SiswaRemoteDataSource remoteDataSource;
    final SiswaLocalDataSource localDataSource;

    public SiswaRepositoryImpl(
            SiswaRemoteDataSource siswaRemoteDataSource,
            SiswaLocalDataSource localDataSource) {
        this.remoteDataSource = siswaRemoteDataSource;
        this.localDataSource = localDataSource;
    }

    @Override
    public List<Siswa> getListSiswaWithoutThumbnail(int maxResults,
            int firstResult) {
        try {
            return remoteDataSource.getListSiswaWithoutThumbnail(
                    maxResults, firstResult);
        } catch (ServerException ex) {
            AlertDialog.showErrorDialog(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Siswa> getListSiswaByKeywordWithoutThumbnail(String keyword,
            String jenisKelamin, int maxResults, int firstResult) {
        try {
            return remoteDataSource.getListSiswaByKeywordWithoutThumbnail(
                    keyword, jenisKelamin, maxResults, firstResult);
        } catch (ServerException ex) {
            AlertDialog.showErrorDialog(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Kelas> getListKelas() {
        try {
            return remoteDataSource.getListKelas();
        } catch (ServerException ex) {
            AlertDialog.showErrorDialog(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Spp> getListSpp() {
        try {
            return remoteDataSource.getListSpp();
        } catch (ServerException ex) {
            AlertDialog.showErrorDialog(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Siswa getSiswa(int id) {
        try {
            return remoteDataSource.getSiswa(id);
        } catch (ServerException ex) {
            AlertDialog.showErrorDialog(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public byte[] getSiswaThumbnail(int id) {
        try {
            return remoteDataSource.getSiswaThumbnail(id);
        } catch (ServerException ex) {
            AlertDialog.showErrorDialog(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public BufferedImage getImageFromDisk(int width, int height) {
        try {
            final var result = localDataSource.getImageFromDisk();
            if (result == null) {
                return null;
            }
            final var resizedImage = Scalr.resize(ImageIO.read(result), height,
                    height);
            final var croppedImage = Scalr.crop(resizedImage, width, height);
            return croppedImage;

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
        return null;
    }

    @Override
    public void insertOrUpdateSiswa(AddSiswaPage context) {
        final var id = context.siswa == null ? null : context.siswa.getId();
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
                || spp == null) {
            AlertDialog.showErrorDialog(Strings.ERROR_DIALOG_EMPTY_FIELD);
            return;
        }

        if (nisn.length() < 10 || nis.length() < 8) {

        }

        try {
            final var siswa = new Siswa();
            siswa.setId(id);
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
    public void deleteSiswa(int id) {
        try {
            remoteDataSource.deleteSiswa(id);
        } catch (IllegalOrphanException | NonexistentEntityException
                | ServerException ex) {
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
