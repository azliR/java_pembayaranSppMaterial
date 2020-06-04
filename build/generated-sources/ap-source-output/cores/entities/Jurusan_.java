package cores.entities;

import cores.entities.Kelas;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-03-24T09:59:57", comments="EclipseLink-2.7.6.v20200131-rNA")
@StaticMetamodel(Jurusan.class)
public class Jurusan_ { 

    public static volatile ListAttribute<Jurusan, Kelas> kelasList;
    public static volatile SingularAttribute<Jurusan, String> namaJurusan;
    public static volatile SingularAttribute<Jurusan, String> akronim;
    public static volatile SingularAttribute<Jurusan, Integer> id;

}