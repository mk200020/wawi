
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
public class BestellpositionenPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "bestnr")
    private int bestnr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pos")
    private short pos;

    public BestellpositionenPK() {
    }

    public BestellpositionenPK(int bestnr, short pos) {
        this.bestnr = bestnr;
        this.pos = pos;
    }

    public int getBestnr() {
        return bestnr;
    }

    public void setBestnr(int bestnr) {
        this.bestnr = bestnr;
    }

    public short getPos() {
        return pos;
    }

    public void setPos(short pos) {
        this.pos = pos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) bestnr;
        hash += (int) pos;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BestellpositionenPK)) {
            return false;
        }
        BestellpositionenPK other = (BestellpositionenPK) object;
        if (this.bestnr != other.bestnr) {
            return false;
        }
        if (this.pos != other.pos) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kasmi.wawi.model.BestellpositionenPK[ bestnr=" + bestnr + ", pos=" + pos + " ]";
    }
    
}
