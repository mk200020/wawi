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
@Table(name = "abteilungen", catalog = "wawi", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Abteilungen.findAll", query = "SELECT a FROM Abteilungen a")
    , @NamedQuery(name = "Abteilungen.findByAbtnr", query = "SELECT a FROM Abteilungen a WHERE a.abtnr = :abtnr")
    , @NamedQuery(name = "Abteilungen.findByText", query = "SELECT a FROM Abteilungen a WHERE a.text = :text")})
public class Abteilungen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "abtnr")
    private String abtnr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "text")
    private String text;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "abtlg")
    private Collection<Personal> personalCollection;

    public Abteilungen() {
    }

    public Abteilungen(String abtnr) {
        this.abtnr = abtnr;
    }

    public Abteilungen(String abtnr, String text) {
        this.abtnr = abtnr;
        this.text = text;
    }

    public String getAbtnr() {
        return abtnr;
    }

    public void setAbtnr(String abtnr) {
        this.abtnr = abtnr;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @XmlTransient
    public Collection<Personal> getPersonalCollection() {
        return personalCollection;
    }

    public void setPersonalCollection(Collection<Personal> personalCollection) {
        this.personalCollection = personalCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (abtnr != null ? abtnr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof Abteilungen)) {
            return false;
        }
        Abteilungen other = (Abteilungen) object;
        if ((this.abtnr == null && other.abtnr != null) || (this.abtnr != null && !this.abtnr.equals(other.abtnr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kasmi.wawi.model.Abteilungen[ abtnr=" + abtnr + " ]";
    }
    
}
