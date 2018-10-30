
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
@Table(name = "artikelgruppen", catalog = "wawi", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Artikelgruppen.findAll", query = "SELECT a FROM Artikelgruppen a")
    , @NamedQuery(name = "Artikelgruppen.findByArtgr", query = "SELECT a FROM Artikelgruppen a WHERE a.artgr = :artgr")
    , @NamedQuery(name = "Artikelgruppen.findByGrtext", query = "SELECT a FROM Artikelgruppen a WHERE a.grtext = :grtext")})
public class Artikelgruppen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "artgr")
    private String artgr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "grtext")
    private String grtext;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gruppe")
    private Collection<Artikel> artikelCollection;

    public Artikelgruppen() {
    }

    public Artikelgruppen(String artgr) {
        this.artgr = artgr;
    }

    public Artikelgruppen(String artgr, String grtext) {
        this.artgr = artgr;
        this.grtext = grtext;
    }

    public String getArtgr() {
        return artgr;
    }

    public void setArtgr(String artgr) {
        this.artgr = artgr;
    }

    public String getGrtext() {
        return grtext;
    }

    public void setGrtext(String grtext) {
        this.grtext = grtext;
    }

    @XmlTransient
    public Collection<Artikel> getArtikelCollection() {
        return artikelCollection;
    }

    public void setArtikelCollection(Collection<Artikel> artikelCollection) {
        this.artikelCollection = artikelCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (artgr != null ? artgr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Artikelgruppen)) {
            return false;
        }
        Artikelgruppen other = (Artikelgruppen) object;
        if ((this.artgr == null && other.artgr != null) || (this.artgr != null && !this.artgr.equals(other.artgr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kasmi.wawi.model.Artikelgruppen[ artgr=" + artgr + " ]";
    }
    
}
