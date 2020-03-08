package features.auth.data.datasources;

import cores.entities.Petugas;
import cores.exceptions.ServerException;
import cores.styles.Strings;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;

/**
 *
 * @author rizal
 */
public class AuthRemoteDataSourceImpl implements AuthRemoteDataSource {
    final EntityManagerFactory entityManagerFactory;

    public AuthRemoteDataSourceImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public Petugas login(String namaPengguna, String kataSandi) throws
            ServerException {
        final var entityManager = entityManagerFactory.createEntityManager();
        try {
            final var storedProcedureQuery = entityManager
                    .createStoredProcedureQuery("login", Petugas.class);
            storedProcedureQuery.registerStoredProcedureParameter(1,
                    String.class, ParameterMode.IN);
            storedProcedureQuery.registerStoredProcedureParameter(2,
                    String.class, ParameterMode.IN);
            storedProcedureQuery.registerStoredProcedureParameter(3,
                    Integer.class,
                    ParameterMode.OUT);
            storedProcedureQuery.setParameter(1, namaPengguna);
            storedProcedureQuery.setParameter(2, kataSandi);
            storedProcedureQuery.execute();

            final var id = Integer.parseUnsignedInt(storedProcedureQuery
                    .getOutputParameterValue(3).toString());
            if (id <= 0) {
                return null;
            }
            return entityManager.find(Petugas.class, id);
        } catch (NumberFormatException ex) {
            throw new ServerException(Strings.ERROR_DIALOG_CONNECTION, ex);
        } finally {
            entityManager.close();
        }
    }
}
