
package kasmi.wawi.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author mohamed
 */
@Embeddable
public class LagerstandPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "artnr")
    private int artnr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lagnr")
    private short lagnr;

    public LagerstandPK() {
    }

    public LagerstandPK(int artnr, short lagnr) {
        this.artnr = artnr;
        this.lagnr = lagnr;
    }

    public int getArtnr() {
        return artnr;
    }

    public void setArtnr(int artnr) {
        this.artnr = artnr;
    }

    public short getLagnr() {
        return lagnr;
    }

    public void setLagnr(short lagnr) {
        this.lagnr = lagnr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) artnr;
        hash += (int) lagnr;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LagerstandPK)) {
            return false;
        }
        LagerstandPK other = (LagerstandPK) object;
        if (this.artnr != other.artnr) {
            return false;
        }
        if (this.lagnr != other.lagnr) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kasmi.wawi.model.LagerstandPK[ artnr=" + artnr + ", lagnr=" + lagnr + " ]";
    }
    
}
