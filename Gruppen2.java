
package kasmi.wawi.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mohamed
 */
@Entity
@Table(name = "gruppen2", catalog = "wawi", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gruppen2.findAll", query = "SELECT g FROM Gruppen2 g")
    , @NamedQuery(name = "Gruppen2.findById", query = "SELECT g FROM Gruppen2 g WHERE g.id = :id")
    , @NamedQuery(name = "Gruppen2.findByBezeichnung", query = "SELECT g FROM Gruppen2 g WHERE g.bezeichnung = :bezeichnung")})
public class Gruppen2 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "bezeichnung")
    private String bezeichnung;

    public Gruppen2() {
    }

    public Gruppen2(String id) {
        this.id = id;
    }

    public Gruppen2(String id, String bezeichnung) {
        this.id = id;
        this.bezeichnung = bezeichnung;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
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
        if (!(object instanceof Gruppen2)) {
            return false;
        }
        Gruppen2 other = (Gruppen2) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kasmi.wawi.model.Gruppen2[ id=" + id + " ]";
    }
    
}
