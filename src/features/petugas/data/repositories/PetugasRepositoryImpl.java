package features.petugas.data.repositories;

import cores.entities.Petugas;
import cores.exceptions.IllegalOrphanException;
import cores.exceptions.NonexistentEntityException;
import cores.exceptions.ServerException;
import cores.utils.AlertDialog;
import features.petugas.data.datasources.PetugasRemoteDataSource;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rizal
 */
public class PetugasRepositoryImpl implements PetugasRepository {
    private static final Logger LOG = Logger.getLogger(
            PetugasRepositoryImpl.class.getName());

    final PetugasRemoteDataSource petugasRemoteDataSource;

    public PetugasRepositoryImpl(PetugasRemoteDataSource petugasRemoteDataSource) {
        this.petugasRemoteDataSource = petugasRemoteDataSource;
    }

    @Override
    public List<Petugas> getListPetugas(int maxResults, int firstResult) {
        try {
            return petugasRemoteDataSource.getListPetugas(maxResults,
                    firstResult);
        } catch (ServerException ex) {
            AlertDialog.showErrorDialog(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Petugas getPetugas(int id) {
        try {
            return petugasRemoteDataSource.getPetugas(id);
        } catch (ServerException ex) {
            AlertDialog.showErrorDialog(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void insertPetugas(Petugas petugas) {
        try {
            petugasRemoteDataSource.insertPetugas(petugas);
        } catch (ServerException ex) {
            AlertDialog.showErrorDialog(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updatePetugas(Petugas petugas) {
        try {
            petugasRemoteDataSource.updatePetugas(petugas);
        } catch (IllegalOrphanException | NonexistentEntityException
                | ServerException ex) {
            AlertDialog.showErrorDialog(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deletePetugas(int id) {
        try {
            petugasRemoteDataSource.deletePetugas(id);
        } catch (IllegalOrphanException | NonexistentEntityException
                | ServerException ex) {
            AlertDialog.showErrorDialog(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
        }
    }

}
