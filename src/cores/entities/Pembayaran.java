package cores.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rizal
 */
@Entity
@Table(name = "pembayaran", catalog = "pembayaran_spp", schema = "")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Pembayaran.findAll", query
            = "SELECT p FROM Pembayaran p"),
    @NamedQuery(name = "Pembayaran.findById", query
            = "SELECT p FROM Pembayaran p WHERE p.id = :id"),
    @NamedQuery(name = "Pembayaran.findByTanggalBayar", query
            = "SELECT p FROM Pembayaran p WHERE p.tanggalBayar = :tanggalBayar"),
    @NamedQuery(name = "Pembayaran.findByJumlahBayar", query
            = "SELECT p FROM Pembayaran p WHERE p.jumlahBayar = :jumlahBayar")})
public class Pembayaran implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tanggal_bayar", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date tanggalBayar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "jumlah_bayar", nullable = false)
    private int jumlahBayar;
    @JoinColumn(name = "id_petugas", referencedColumnName = "id", nullable
            = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Petugas idPetugas;
    @JoinColumn(name = "id_siswa", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Siswa idSiswa;
    @JoinColumn(name = "id_spp", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Spp idSpp;

    public Pembayaran() {
    }

    public Pembayaran(Integer id) {
        this.id = id;
    }

    public Pembayaran(Integer id, Date tanggalBayar, int jumlahBayar) {
        this.id = id;
        this.tanggalBayar = tanggalBayar;
        this.jumlahBayar = jumlahBayar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTanggalBayar() {
        return tanggalBayar;
    }

    public void setTanggalBayar(Date tanggalBayar) {
        this.tanggalBayar = tanggalBayar;
    }

    public int getJumlahBayar() {
        return jumlahBayar;
    }

    public void setJumlahBayar(int jumlahBayar) {
        this.jumlahBayar = jumlahBayar;
    }

    public Petugas getIdPetugas() {
        return idPetugas;
    }

    public void setIdPetugas(Petugas idPetugas) {
        this.idPetugas = idPetugas;
    }

    public Siswa getIdSiswa() {
        return idSiswa;
    }

    public void setIdSiswa(Siswa idSiswa) {
        this.idSiswa = idSiswa;
    }

    public Spp getIdSpp() {
        return idSpp;
    }

    public void setIdSpp(Spp idSpp) {
        this.idSpp = idSpp;
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
        if (!(object instanceof Pembayaran)) {
            return false;
        }
        Pembayaran other = (Pembayaran) object;
        if ((this.id == null && other.id != null) ||
                (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cores.entities.Pembayaran[ id=" + id + " ]";
    }

}
