package features.auth.repositories;

/**
 *
 * @author rizal
 */
public abstract class AuthRepository {

    public abstract void login(String namaPengguna, String kataSandi);
}
