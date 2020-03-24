package cores.provider;

import cores.entities.Petugas;
import cores.styles.Strings;

/**
 *
 * @author rizal
 */
public class SharedPreferences {
    private Petugas petugas;

    public boolean isLoggedIn() {
        return petugas != null;
    }

    public boolean isAdministrator() {
        if (petugas != null) {
            return Strings.ADMINISTRATOR.equals(petugas.getHakAkses());
        }
        return false;
    }

    public Petugas getLoggedInPetugas() {
        return petugas;
    }

    public void setLoggedInPetugas(Petugas petugas) {
        this.petugas = petugas;
    }
}
