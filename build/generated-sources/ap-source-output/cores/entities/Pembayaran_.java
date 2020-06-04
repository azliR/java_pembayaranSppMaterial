package cores.entities;

import cores.entities.Petugas;
import cores.entities.Siswa;
import cores.entities.Spp;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-03-24T09:59:57", comments="EclipseLink-2.7.6.v20200131-rNA")
@StaticMetamodel(Pembayaran.class)
public class Pembayaran_ { 

    public static volatile SingularAttribute<Pembayaran, Date> tanggalBayar;
    public static volatile SingularAttribute<Pembayaran, Integer> jumlahBayar;
    public static volatile SingularAttribute<Pembayaran, Petugas> idPetugas;
    public static volatile SingularAttribute<Pembayaran, Siswa> idSiswa;
    public static volatile SingularAttribute<Pembayaran, Integer> id;
    public static volatile SingularAttribute<Pembayaran, Spp> idSpp;

}