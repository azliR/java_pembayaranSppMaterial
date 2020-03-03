package features.kelas.data.repositories;

import features.kelas.data.datasources.KelasRemoteDataSource;

/**
 *
 * @author rizal
 */
public class KelasRepositoryImpl implements KelasRepository {
    final KelasRemoteDataSource remoteDataSource;

    public KelasRepositoryImpl(KelasRemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public void getListKelas() {

    }
}
