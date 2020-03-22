package features.auth.data.repositories;

/**
 *
 * @author rizal
 */
public interface AuthRepository {
    public abstract boolean login(String namaPengguna, String kataSandi);

    public abstract void updateStatus(String status);
}
