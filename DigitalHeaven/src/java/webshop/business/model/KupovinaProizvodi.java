package webshop.business.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Igor Strbac <mail@igorstrbac.com>
 */
@Entity
@Table(name = "kupovina_proizvodi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KupovinaProizvodi.findAll", query = "SELECT k FROM KupovinaProizvodi k")
    , @NamedQuery(name = "KupovinaProizvodi.findById", query = "SELECT k FROM KupovinaProizvodi k WHERE k.id = :id")
    , @NamedQuery(name = "KupovinaProizvodi.findByKolicina", query = "SELECT k FROM KupovinaProizvodi k WHERE k.kolicina = :kolicina")})
public class KupovinaProizvodi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "kolicina")
    private int kolicina;
    @JoinColumn(name = "kupovina_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Kupovina kupovinaId;
    @JoinColumn(name = "proizvod_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Proizvod proizvodId;

    public KupovinaProizvodi() {
    }

    public KupovinaProizvodi(Integer id) {
        this.id = id;
    }

    public KupovinaProizvodi(Integer id, int kolicina) {
        this.id = id;
        this.kolicina = kolicina;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public Kupovina getKupovinaId() {
        return kupovinaId;
    }

    public void setKupovinaId(Kupovina kupovinaId) {
        this.kupovinaId = kupovinaId;
    }

    public Proizvod getProizvodId() {
        return proizvodId;
    }

    public void setProizvodId(Proizvod proizvodId) {
        this.proizvodId = proizvodId;
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
        if (!(object instanceof KupovinaProizvodi)) {
            return false;
        }
        KupovinaProizvodi other = (KupovinaProizvodi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webshop.business.model.KupovinaProizvodi[ id=" + id + " ]";
    }
    
}
