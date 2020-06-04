package cores.entities;

import cores.entities.Jurusan;
import cores.entities.Siswa;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-03-24T09:59:57", comments="EclipseLink-2.7.6.v20200131-rNA")
@StaticMetamodel(Kelas.class)
public class Kelas_ { 

    public static volatile SingularAttribute<Kelas, Integer> noKelas;
    public static volatile ListAttribute<Kelas, Siswa> siswaList;
    public static volatile SingularAttribute<Kelas, Integer> kelas;
    public static volatile SingularAttribute<Kelas, Integer> id;
    public static volatile SingularAttribute<Kelas, Jurusan> idJurusan;

}