
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
@Table(name = "anreden", catalog = "wawi", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Anreden.findAll", query = "SELECT a FROM Anreden a")
    , @NamedQuery(name = "Anreden.findByAnrnr", query = "SELECT a FROM Anreden a WHERE a.anrnr = :anrnr")
    , @NamedQuery(name = "Anreden.findByText", query = "SELECT a FROM Anreden a WHERE a.text = :text")
    , @NamedQuery(name = "Anreden.findByBriefkopf", query = "SELECT a FROM Anreden a WHERE a.briefkopf = :briefkopf")
    , @NamedQuery(name = "Anreden.findByBriefanrede", query = "SELECT a FROM Anreden a WHERE a.briefanrede = :briefanrede")})
public class Anreden implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "anrnr")
    private Short anrnr;
    @Size(max = 20)
    @Column(name = "text")
    private String text;
    @Size(max = 20)
    @Column(name = "briefkopf")
    private String briefkopf;
    @Size(max = 40)
    @Column(name = "briefanrede")
    private String briefanrede;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "geschlecht")
    private Collection<Personal> personalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "geschlecht")
    private Collection<Kunden> kundenCollection;

    public Anreden() {
    }

    public Anreden(Short anrnr) {
        this.anrnr = anrnr;
    }

    public Short getAnrnr() {
        return anrnr;
    }

    public void setAnrnr(Short anrnr) {
        this.anrnr = anrnr;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getBriefkopf() {
        return briefkopf;
    }

    public void setBriefkopf(String briefkopf) {
        this.briefkopf = briefkopf;
    }

    public String getBriefanrede() {
        return briefanrede;
    }

    public void setBriefanrede(String briefanrede) {
        this.briefanrede = briefanrede;
    }

    @XmlTransient
    public Collection<Personal> getPersonalCollection() {
        return personalCollection;
    }

    public void setPersonalCollection(Collection<Personal> personalCollection) {
        this.personalCollection = personalCollection;
    }

    @XmlTransient
    public Collection<Kunden> getKundenCollection() {
        return kundenCollection;
    }

    public void setKundenCollection(Collection<Kunden> kundenCollection) {
        this.kundenCollection = kundenCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (anrnr != null ? anrnr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anreden)) {
            return false;
        }
        Anreden other = (Anreden) object;
        if ((this.anrnr == null && other.anrnr != null) || (this.anrnr != null && !this.anrnr.equals(other.anrnr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kasmi.wawi.model.Anreden[ anrnr=" + anrnr + " ]";
    }
    
}
