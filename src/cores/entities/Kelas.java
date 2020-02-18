package cores.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rizal
 */
@Entity
@Table(name = "kelas", catalog = "pembayaran_spp", schema = "",
        uniqueConstraints
        = {@UniqueConstraint(columnNames = {"nama_kelas"})})
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Kelas.findAll", query
            = "SELECT k FROM Kelas k"),
    @NamedQuery(name = "Kelas.findById", query
            = "SELECT k FROM Kelas k WHERE k.id = :id"),
    @NamedQuery(name = "Kelas.findByNamaKelas", query
            = "SELECT k FROM Kelas k WHERE k.namaKelas = :namaKelas"),
    @NamedQuery(name = "Kelas.findByTingkat", query
            = "SELECT k FROM Kelas k WHERE k.tingkat = :tingkat"),
    @NamedQuery(name = "Kelas.findByKompetensiKeahlian", query
            = "SELECT k FROM Kelas k WHERE k.kompetensiKeahlian = :kompetensiKeahlian"),
    @NamedQuery(name = "Kelas.findByNoKelas", query
            = "SELECT k FROM Kelas k WHERE k.noKelas = :noKelas"),
    @NamedQuery(name = "Kelas.findByJumlahSiswa", query
            = "SELECT k FROM Kelas k WHERE k.jumlahSiswa = :jumlahSiswa")})
public class Kelas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "nama_kelas", nullable = false, length = 10)
    private String namaKelas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tingkat", nullable = false)
    private int tingkat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 48)
    @Column(name = "kompetensi_keahlian", nullable = false, length = 48)
    private String kompetensiKeahlian;
    @Basic(optional = false)
    @NotNull
    @Column(name = "no_kelas", nullable = false)
    private int noKelas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "jumlah_siswa", nullable = false)
    private int jumlahSiswa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idKelas", fetch
            = FetchType.LAZY)
    private List<Siswa> siswaList;

    public Kelas() {
    }

    public Kelas(Integer id) {
        this.id = id;
    }

    public Kelas(Integer id, String namaKelas, int tingkat,
            String kompetensiKeahlian, int noKelas, int jumlahSiswa) {
        this.id = id;
        this.namaKelas = namaKelas;
        this.tingkat = tingkat;
        this.kompetensiKeahlian = kompetensiKeahlian;
        this.noKelas = noKelas;
        this.jumlahSiswa = jumlahSiswa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }

    public int getTingkat() {
        return tingkat;
    }

    public void setTingkat(int tingkat) {
        this.tingkat = tingkat;
    }

    public String getKompetensiKeahlian() {
        return kompetensiKeahlian;
    }

    public void setKompetensiKeahlian(String kompetensiKeahlian) {
        this.kompetensiKeahlian = kompetensiKeahlian;
    }

    public int getNoKelas() {
        return noKelas;
    }

    public void setNoKelas(int noKelas) {
        this.noKelas = noKelas;
    }

    public int getJumlahSiswa() {
        return jumlahSiswa;
    }

    public void setJumlahSiswa(int jumlahSiswa) {
        this.jumlahSiswa = jumlahSiswa;
    }

    @XmlTransient
    public List<Siswa> getSiswaList() {
        return siswaList;
    }

    public void setSiswaList(List<Siswa> siswaList) {
        this.siswaList = siswaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kelas)) {
            return false;
        }
        Kelas other = (Kelas) object;
        if ((this.id == null && other.id != null) || (this.id != null
                && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return namaKelas;
    }

}
