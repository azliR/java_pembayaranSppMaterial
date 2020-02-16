package features.student.data.repositories;

import cores.exceptions.PreexistingEntityException;
import cores.exceptions.ServerException;
import cores.exceptions.UnexpectedException;
import cores.utils.AlertDialog;
import features.student.data.datasources.SiswaLocalDataSource;
import features.student.data.datasources.SiswaRemoteDataSource;
import features.student.data.entities.Siswa;
import features.student.presentation.pages.AddSiswaPage;
import java.awt.Image;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author rizal
 */
public class SiswaRepositoryImpl implements SiswaRepository {
    private static final Logger LOG = Logger.getLogger(SiswaRepositoryImpl.class
            .getName());

    final SiswaRemoteDataSource siswaRemoteDataSource;
    final SiswaLocalDataSource localDataSource;

    public SiswaRepositoryImpl(
            SiswaRemoteDataSource siswaRemoteDataSource,
            SiswaLocalDataSource localDataSource) {
        this.siswaRemoteDataSource = siswaRemoteDataSource;
        this.localDataSource = localDataSource;
    }

    @Override
    public List<Siswa> getListSiswaWithoutThumbnail(int maxResults,
            int firstResult) {
        try {
            return siswaRemoteDataSource.getListSiswaWithoutThumbnail(
                    maxResults, firstResult);
        } catch (ServerException ex) {
            AlertDialog.showErrorDialog(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public byte[] getSiswaThumbnail(int id) {
        return null;
    }

    @Override
    public Image getImageFromDisk(AddSiswaPage context, int width, int height) {
        try {
            final var result = localDataSource.getImageFromDisk(width, height);
            context.b_addImage.setIcon(new ImageIcon(result));
            context.b_addImage.setText(null);
            context.b_addImage.setBorder(null);
            return result;
        } catch (UnexpectedException ex) {
            AlertDialog.showErrorDialog(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void insertSiswa(Siswa siswa) {
        try {
            siswaRemoteDataSource.insertSiswa(siswa);
        } catch (PreexistingEntityException | ServerException ex) {
            AlertDialog.showErrorDialog(ex.getMessage());
            Logger.getLogger(SiswaRepositoryImpl.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }
}
