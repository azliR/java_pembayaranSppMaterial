package features.auth.data.repositories;

/**
 *
 * @author rizal
 */
public interface AuthRepository {
    public abstract void login(String namaPengguna, String kataSandi);

    public abstract void updateStatus(String status);
}
