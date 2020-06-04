package cores.entities;

import cores.entities.Kelas;
import cores.entities.Pembayaran;
import cores.entities.Spp;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-03-24T09:59:57", comments="EclipseLink-2.7.6.v20200131-rNA")
@StaticMetamodel(Siswa.class)
public class Siswa_ { 

    public static volatile SingularAttribute<Siswa, byte[]> foto;
    public static volatile SingularAttribute<Siswa, String> nama;
    public static volatile SingularAttribute<Siswa, String> noTelepon;
    public static volatile SingularAttribute<Siswa, String> nisn;
    public static volatile ListAttribute<Siswa, Pembayaran> pembayaranList;
    public static volatile SingularAttribute<Siswa, String> nis;
    public static volatile SingularAttribute<Siswa, Kelas> idKelas;
    public static volatile SingularAttribute<Siswa, Character> jenisKelamin;
    public static volatile SingularAttribute<Siswa, Integer> id;
    public static volatile SingularAttribute<Siswa, String> sppBulanIni;
    public static volatile SingularAttribute<Siswa, Spp> idSpp;
    public static volatile SingularAttribute<Siswa, String> alamat;

}