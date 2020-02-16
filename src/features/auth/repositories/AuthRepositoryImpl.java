package features.auth.repositories;

import cores.utils.Navigator;
import features.auth.entities.PetugasJpaController;
import features.home.pages.HomePage;

/**
 *
 * @author rizal
 */
public class AuthRepositoryImpl extends AuthRepository {

    final PetugasJpaController petugasJpaController;

    public AuthRepositoryImpl(PetugasJpaController petugasJpaController) {
        this.petugasJpaController = petugasJpaController;
    }

    @Override
    public void login(String namaPengguna, String kataSandi) {
        final var result = petugasJpaController.login(namaPengguna, kataSandi);

        if (result != null) {
            Navigator.push(new HomePage(), true);
        } else {

        }
    }
}
