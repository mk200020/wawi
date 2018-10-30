
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
@Table(name = "status", catalog = "wawi", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Status.findAll", query = "SELECT s FROM Status s")
    , @NamedQuery(name = "Status.findByStid", query = "SELECT s FROM Status s WHERE s.stid = :stid")
    , @NamedQuery(name = "Status.findByText", query = "SELECT s FROM Status s WHERE s.text = :text")})
public class Status implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "stid")
    private Short stid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "text")
    private String text;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private Collection<Bestellungen> bestellungenCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private Collection<Wareneingang> wareneingangCollection;

    public Status() {
    }

    public Status(Short stid) {
        this.stid = stid;
    }

    public Status(Short stid, String text) {
        this.stid = stid;
        this.text = text;
    }

    public Short getStid() {
        return stid;
    }

    public void setStid(Short stid) {
        this.stid = stid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @XmlTransient
    public Collection<Bestellungen> getBestellungenCollection() {
        return bestellungenCollection;
    }

    public void setBestellungenCollection(Collection<Bestellungen> bestellungenCollection) {
        this.bestellungenCollection = bestellungenCollection;
    }

    @XmlTransient
    public Collection<Wareneingang> getWareneingangCollection() {
        return wareneingangCollection;
    }

    public void setWareneingangCollection(Collection<Wareneingang> wareneingangCollection) {
        this.wareneingangCollection = wareneingangCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stid != null ? stid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Status)) {
            return false;
        }
        Status other = (Status) object;
        if ((this.stid == null && other.stid != null) || (this.stid != null && !this.stid.equals(other.stid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kasmi.wawi.model.Status[ stid=" + stid + " ]";
    }
    
}
