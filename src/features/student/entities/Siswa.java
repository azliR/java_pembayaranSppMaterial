/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package features.student.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rizal
 */
@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nis"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Siswa.findAll", query = "SELECT s FROM Siswa s"),
    @NamedQuery(name = "Siswa.findByNisn", query = "SELECT s FROM Siswa s WHERE s.nisn = :nisn"),
    @NamedQuery(name = "Siswa.findByNis", query = "SELECT s FROM Siswa s WHERE s.nis = :nis"),
    @NamedQuery(name = "Siswa.findByNama", query = "SELECT s FROM Siswa s WHERE s.nama = :nama"),
    @NamedQuery(name = "Siswa.findByNoTelepon", query = "SELECT s FROM Siswa s WHERE s.noTelepon = :noTelepon")})
public class Siswa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(nullable = false, length = 10)
    private String nisn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(nullable = false, length = 8)
    private String nis;
    @Lob
    private byte[] foto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 36)
    @Column(nullable = false, length = 36)
    private String nama;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "no_telepon", nullable = false, length = 13)
    private String noTelepon;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(nullable = false, length = 65535)
    private String alamat;
    @JoinColumn(name = "id_kelas", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Kelas idKelas;
    @JoinColumn(name = "id_spp", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Spp idSpp;

    public Siswa() {
    }

    public Siswa(String nisn) {
        this.nisn = nisn;
    }

    public Siswa(String nisn, String nis, String nama, String noTelepon, String alamat) {
        this.nisn = nisn;
        this.nis = nis;
        this.nama = nama;
        this.noTelepon = noTelepon;
        this.alamat = alamat;
    }

    public String getNisn() {
        return nisn;
    }

    public void setNisn(String nisn) {
        this.nisn = nisn;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Kelas getIdKelas() {
        return idKelas;
    }

    public void setIdKelas(Kelas idKelas) {
        this.idKelas = idKelas;
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
        hash += (nisn != null ? nisn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Siswa)) {
            return false;
        }
        Siswa other = (Siswa) object;
        if ((this.nisn == null && other.nisn != null) || (this.nisn != null && !this.nisn.equals(other.nisn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "features.student.entities.Siswa[ nisn=" + nisn + " ]";
    }

}
