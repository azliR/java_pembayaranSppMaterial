/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package features.student.entities;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rizal
 */
@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"tahun"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Spp.findAll", query = "SELECT s FROM Spp s"),
    @NamedQuery(name = "Spp.findById", query = "SELECT s FROM Spp s WHERE s.id = :id"),
    @NamedQuery(name = "Spp.findByTahun", query = "SELECT s FROM Spp s WHERE s.tahun = :tahun"),
    @NamedQuery(name = "Spp.findByNominal", query = "SELECT s FROM Spp s WHERE s.nominal = :nominal")})
public class Spp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int tahun;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int nominal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSpp", fetch = FetchType.LAZY)
    private List<Siswa> siswaList;

    public Spp() {
    }

    public Spp(Integer id) {
        this.id = id;
    }

    public Spp(Integer id, int tahun, int nominal) {
        this.id = id;
        this.tahun = tahun;
        this.nominal = nominal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
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
        if (!(object instanceof Spp)) {
            return false;
        }
        Spp other = (Spp) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "features.student.entities.Spp[ id=" + id + " ]";
    }

}
