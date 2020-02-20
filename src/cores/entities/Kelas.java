package cores.entities;

import cores.utils.Intl;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rizal
 */
@Entity
@Table(name = "kelas", catalog = "pembayaran_spp", schema = "")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Kelas.findAll", query
            = "SELECT k FROM Kelas k"),
    @NamedQuery(name = "Kelas.findById", query
            = "SELECT k FROM Kelas k WHERE k.id = :id"),
    @NamedQuery(name = "Kelas.findByKelas", query
            = "SELECT k FROM Kelas k WHERE k.kelas = :kelas"),
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
    @Column(name = "kelas", nullable = false)
    private int kelas;
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
    @JoinColumn(name = "id_jurusan", referencedColumnName = "id", nullable
            = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Jurusan idJurusan;

    public Kelas() {
    }

    public Kelas(Integer id) {
        this.id = id;
    }

    public Kelas(Integer id, int kelas, int noKelas, int jumlahSiswa) {
        this.id = id;
        this.kelas = kelas;
        this.noKelas = noKelas;
        this.jumlahSiswa = jumlahSiswa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getKelas() {
        return kelas;
    }

    public void setKelas(int kelas) {
        this.kelas = kelas;
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

    public Jurusan getIdJurusan() {
        return idJurusan;
    }

    public void setIdJurusan(Jurusan idJurusan) {
        this.idJurusan = idJurusan;
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
        return !((this.id == null && other.id != null) || (this.id != null
                && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return Intl.toRoman(kelas) + " " + idJurusan.getAlias() + " " + noKelas;
    }

}
