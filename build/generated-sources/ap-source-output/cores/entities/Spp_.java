package cores.entities;

import cores.entities.Pembayaran;
import cores.entities.Siswa;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-03-24T09:59:57", comments="EclipseLink-2.7.6.v20200131-rNA")
@StaticMetamodel(Spp.class)
public class Spp_ { 

    public static volatile SingularAttribute<Spp, Integer> tahun;
    public static volatile SingularAttribute<Spp, Integer> nominal;
    public static volatile ListAttribute<Spp, Siswa> siswaList;
    public static volatile ListAttribute<Spp, Pembayaran> pembayaranList;
    public static volatile SingularAttribute<Spp, Integer> id;

}