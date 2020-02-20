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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rizal
 */
@Entity
@Table(name = "jurusan", catalog = "pembayaran_spp", schema = "")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Jurusan.findAll", query
            = "SELECT j FROM Jurusan j"),
    @NamedQuery(name = "Jurusan.findById", query
            = "SELECT j FROM Jurusan j WHERE j.id = :id"),
    @NamedQuery(name = "Jurusan.findByNamaJurusan", query
            = "SELECT j FROM Jurusan j WHERE j.namaJurusan = :namaJurusan"),
    @NamedQuery(name = "Jurusan.findByAlias", query
            = "SELECT j FROM Jurusan j WHERE j.alias = :alias")})
public class Jurusan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 48)
    @Column(name = "nama_jurusan", nullable = false, length = 48)
    private String namaJurusan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "alias", nullable = false, length = 8)
    private String alias;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idJurusan", fetch
            = FetchType.LAZY)
    private List<Kelas> kelasList;

    public Jurusan() {
    }

    public Jurusan(Integer id) {
        this.id = id;
    }

    public Jurusan(Integer id, String namaJurusan, String alias) {
        this.id = id;
        this.namaJurusan = namaJurusan;
        this.alias = alias;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamaJurusan() {
        return namaJurusan;
    }

    public void setNamaJurusan(String namaJurusan) {
        this.namaJurusan = namaJurusan;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @XmlTransient
    public List<Kelas> getKelasList() {
        return kelasList;
    }

    public void setKelasList(List<Kelas> kelasList) {
        this.kelasList = kelasList;
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
        if (!(object instanceof Jurusan)) {
            return false;
        }
        Jurusan other = (Jurusan) object;
        if ((this.id == null && other.id != null) ||
                (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cores.entities.Jurusan[ id=" + id + " ]";
    }

}
