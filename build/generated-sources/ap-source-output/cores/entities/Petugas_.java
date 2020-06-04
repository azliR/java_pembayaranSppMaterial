package cores.entities;

import cores.entities.Pembayaran;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-03-24T09:59:57", comments="EclipseLink-2.7.6.v20200131-rNA")
@StaticMetamodel(Petugas.class)
public class Petugas_ { 

    public static volatile SingularAttribute<Petugas, String> namaPengguna;
    public static volatile SingularAttribute<Petugas, byte[]> foto;
    public static volatile SingularAttribute<Petugas, String> noTelepon;
    public static volatile SingularAttribute<Petugas, Date> dibuatPada;
    public static volatile SingularAttribute<Petugas, String> kataSandi;
    public static volatile SingularAttribute<Petugas, String> hakAkses;
    public static volatile ListAttribute<Petugas, Pembayaran> pembayaranList;
    public static volatile SingularAttribute<Petugas, Date> terakhirMasuk;
    public static volatile SingularAttribute<Petugas, Integer> id;
    public static volatile SingularAttribute<Petugas, String> namaPetugas;
    public static volatile SingularAttribute<Petugas, String> status;

}