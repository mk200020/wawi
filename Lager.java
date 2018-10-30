
package kasmi.wawi.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author mohamed
 */
@Entity
@Table(name = "lager", catalog = "wawi", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lager.findAll", query = "SELECT l FROM Lager l")
    , @NamedQuery(name = "Lager.findByLagnr", query = "SELECT l FROM Lager l WHERE l.lagnr = :lagnr")
    , @NamedQuery(name = "Lager.findByName", query = "SELECT l FROM Lager l WHERE l.name = :name")})
public class Lager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "lagnr")
    private Short lagnr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lager")
    private Collection<Lagerstand> lagerstandCollection;

    public Lager() {
    }

    public Lager(Short lagnr) {
        this.lagnr = lagnr;
    }

    public Lager(Short lagnr, String name) {
        this.lagnr = lagnr;
        this.name = name;
    }

    public Short getLagnr() {
        return lagnr;
    }

    public void setLagnr(Short lagnr) {
        this.lagnr = lagnr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Lagerstand> getLagerstandCollection() {
        return lagerstandCollection;
    }

    public void setLagerstandCollection(Collection<Lagerstand> lagerstandCollection) {
        this.lagerstandCollection = lagerstandCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lagnr != null ? lagnr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lager)) {
            return false;
        }
        Lager other = (Lager) object;
        if ((this.lagnr == null && other.lagnr != null) || (this.lagnr != null && !this.lagnr.equals(other.lagnr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kasmi.wawi.model.Lager[ lagnr=" + lagnr + " ]";
    }
    
}
