
package kasmi.wawi.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "gehaltstufen", catalog = "wawi", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gehaltstufen.findAll", query = "SELECT g FROM Gehaltstufen g")
    , @NamedQuery(name = "Gehaltstufen.findByStufe", query = "SELECT g FROM Gehaltstufen g WHERE g.stufe = :stufe")
    , @NamedQuery(name = "Gehaltstufen.findByVon", query = "SELECT g FROM Gehaltstufen g WHERE g.von = :von")
    , @NamedQuery(name = "Gehaltstufen.findByBis", query = "SELECT g FROM Gehaltstufen g WHERE g.bis = :bis")})
public class Gehaltstufen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "stufe")
    private String stufe;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "von")
    private BigDecimal von;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bis")
    private BigDecimal bis;

    public Gehaltstufen() {
    }

    public Gehaltstufen(String stufe) {
        this.stufe = stufe;
    }

    public Gehaltstufen(String stufe, BigDecimal von, BigDecimal bis) {
        this.stufe = stufe;
        this.von = von;
        this.bis = bis;
    }

    public String getStufe() {
        return stufe;
    }

    public void setStufe(String stufe) {
        this.stufe = stufe;
    }

    public BigDecimal getVon() {
        return von;
    }

    public void setVon(BigDecimal von) {
        this.von = von;
    }

    public BigDecimal getBis() {
        return bis;
    }

    public void setBis(BigDecimal bis) {
        this.bis = bis;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stufe != null ? stufe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gehaltstufen)) {
            return false;
        }
        Gehaltstufen other = (Gehaltstufen) object;
        if ((this.stufe == null && other.stufe != null) || (this.stufe != null && !this.stufe.equals(other.stufe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kasmi.wawi.model.Gehaltstufen[ stufe=" + stufe + " ]";
    }
    
}
