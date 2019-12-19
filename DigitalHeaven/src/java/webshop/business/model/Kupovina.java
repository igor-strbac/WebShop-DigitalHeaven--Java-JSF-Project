package webshop.business.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Igor Strbac <mail@igorstrbac.com>
 */
@Entity
@Table(name = "kupovina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kupovina.findAll", query = "SELECT k FROM Kupovina k")
    , @NamedQuery(name = "Kupovina.findById", query = "SELECT k FROM Kupovina k WHERE k.id = :id")
    , @NamedQuery(name = "Kupovina.findByIme", query = "SELECT k FROM Kupovina k WHERE k.ime = :ime")
    , @NamedQuery(name = "Kupovina.findByPrezime", query = "SELECT k FROM Kupovina k WHERE k.prezime = :prezime")
    , @NamedQuery(name = "Kupovina.findByBrojKartice", query = "SELECT k FROM Kupovina k WHERE k.brojKartice = :brojKartice")
    , @NamedQuery(name = "Kupovina.findByCena", query = "SELECT k FROM Kupovina k WHERE k.cena = :cena")})
public class Kupovina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ime")
    private String ime;
    @Size(max = 45)
    @Column(name = "prezime")
    private String prezime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "broj_kartice")
    private String brojKartice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cena")
    private int cena;
    @Size(max = 45)
    @Column(name = "telefon")
    private String telefon;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kupovinaId")
    private List<KupovinaProizvodi> kupovinaProizvodiList;
    @JoinColumn(name = "id_korisnik", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Korisnik idKorisnik;

    public Kupovina() {
    }

    public Kupovina(Integer id) {
        this.id = id;
    }

    public Kupovina(Integer id, String ime, String brojKartice, int cena) {
        this.id = id;
        this.ime = ime;
        this.brojKartice = brojKartice;
        this.cena = cena;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getBrojKartice() {
        return brojKartice;
    }

    public void setBrojKartice(String brojKartice) {
        this.brojKartice = brojKartice;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    @XmlTransient
    public List<KupovinaProizvodi> getKupovinaProizvodiList() {
        return kupovinaProizvodiList;
    }

    public void setKupovinaProizvodiList(List<KupovinaProizvodi> kupovinaProizvodiList) {
        this.kupovinaProizvodiList = kupovinaProizvodiList;
    }

    public Korisnik getIdKorisnik() {
        return idKorisnik;
    }

    public void setIdKorisnik(Korisnik idKorisnik) {
        this.idKorisnik = idKorisnik;
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
        if (!(object instanceof Kupovina)) {
            return false;
        }
        Kupovina other = (Kupovina) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webshop.business.model.Kupovina[ id=" + id + " ]";
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    
}
