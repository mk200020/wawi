
package kasmi.wawi.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "interessen", catalog = "wawi", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Interessen.findAll", query = "SELECT i FROM Interessen i")
    , @NamedQuery(name = "Interessen.findByIntcode", query = "SELECT i FROM Interessen i WHERE i.intcode = :intcode")
    , @NamedQuery(name = "Interessen.findByText", query = "SELECT i FROM Interessen i WHERE i.text = :text")})
public class Interessen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "intcode")
    private String intcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "text")
    private String text;
    @JoinTable(name = "kundeninteressen", joinColumns = {
        @JoinColumn(name = "intcode", referencedColumnName = "intcode")}, inverseJoinColumns = {
        @JoinColumn(name = "kdnr", referencedColumnName = "kdnr")})
    @ManyToMany
    private Collection<Kunden> kundenCollection;

    public Interessen() {
    }

    public Interessen(String intcode) {
        this.intcode = intcode;
    }

    public Interessen(String intcode, String text) {
        this.intcode = intcode;
        this.text = text;
    }

    public String getIntcode() {
        return intcode;
    }

    public void setIntcode(String intcode) {
        this.intcode = intcode;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
        hash += (intcode != null ? intcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Interessen)) {
            return false;
        }
        Interessen other = (Interessen) object;
        if ((this.intcode == null && other.intcode != null) || (this.intcode != null && !this.intcode.equals(other.intcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kasmi.wawi.model.Interessen[ intcode=" + intcode + " ]";
    }
    
}
