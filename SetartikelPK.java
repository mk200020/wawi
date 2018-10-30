
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
public class SetartikelPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "setartnr")
    private int setartnr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "teilartnr")
    private int teilartnr;

    public SetartikelPK() {
    }

    public SetartikelPK(int setartnr, int teilartnr) {
        this.setartnr = setartnr;
        this.teilartnr = teilartnr;
    }

    public int getSetartnr() {
        return setartnr;
    }

    public void setSetartnr(int setartnr) {
        this.setartnr = setartnr;
    }

    public int getTeilartnr() {
        return teilartnr;
    }

    public void setTeilartnr(int teilartnr) {
        this.teilartnr = teilartnr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) setartnr;
        hash += (int) teilartnr;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SetartikelPK)) {
            return false;
        }
        SetartikelPK other = (SetartikelPK) object;
        if (this.setartnr != other.setartnr) {
            return false;
        }
        if (this.teilartnr != other.teilartnr) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kasmi.wawi.model.SetartikelPK[ setartnr=" + setartnr + ", teilartnr=" + teilartnr + " ]";
    }
    
}
