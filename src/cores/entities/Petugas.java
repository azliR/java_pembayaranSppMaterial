package cores.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "petugas", catalog = "pembayaran_spp", schema = "",
        uniqueConstraints
        = {@UniqueConstraint(columnNames = {"nama_pengguna"})})
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Petugas.findAll", query
            = "SELECT p FROM Petugas p"),
    @NamedQuery(name = "Petugas.findById", query
            = "SELECT p FROM Petugas p WHERE p.id = :id"),
    @NamedQuery(name = "Petugas.findByNamaPetugas", query
            = "SELECT p FROM Petugas p WHERE p.namaPetugas = :namaPetugas"),
    @NamedQuery(name = "Petugas.findByNamaPengguna", query
            = "SELECT p FROM Petugas p WHERE p.namaPengguna = :namaPengguna"),
    @NamedQuery(name = "Petugas.findByHakAkses", query
            = "SELECT p FROM Petugas p WHERE p.hakAkses = :hakAkses")})
public class Petugas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 36)
    @Column(name = "nama_petugas", nullable = false, length = 36)
    private String namaPetugas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 26)
    @Column(name = "nama_pengguna", nullable = false, length = 26)
    private String namaPengguna;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "kata_sandi", nullable = false, length = 65535)
    private String kataSandi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "hak_akses", nullable = false, length = 7)
    private String hakAkses;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPetugas", fetch
            = FetchType.LAZY)
    private List<Pembayaran> pembayaranList;

    public Petugas() {
    }

    public Petugas(Integer id) {
        this.id = id;
    }

    public Petugas(Integer id, String namaPetugas, String namaPengguna,
            String kataSandi, String hakAkses) {
        this.id = id;
        this.namaPetugas = namaPetugas;
        this.namaPengguna = namaPengguna;
        this.kataSandi = kataSandi;
        this.hakAkses = hakAkses;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamaPetugas() {
        return namaPetugas;
    }

    public void setNamaPetugas(String namaPetugas) {
        this.namaPetugas = namaPetugas;
    }

    public String getNamaPengguna() {
        return namaPengguna;
    }

    public void setNamaPengguna(String namaPengguna) {
        this.namaPengguna = namaPengguna;
    }

    public String getKataSandi() {
        return kataSandi;
    }

    public void setKataSandi(String kataSandi) {
        this.kataSandi = kataSandi;
    }

    public String getHakAkses() {
        return hakAkses;
    }

    public void setHakAkses(String hakAkses) {
        this.hakAkses = hakAkses;
    }

    @XmlTransient
    public List<Pembayaran> getPembayaranList() {
        return pembayaranList;
    }

    public void setPembayaranList(List<Pembayaran> pembayaranList) {
        this.pembayaranList = pembayaranList;
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
        if (!(object instanceof Petugas)) {
            return false;
        }
        Petugas other = (Petugas) object;
        if ((this.id == null && other.id != null) ||
                (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cores.entities.Petugas[ id=" + id + " ]";
    }

}
