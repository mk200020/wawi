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
public class WareneingangspositionenPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "waenr")
    private int waenr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pos")
    private short pos;

    public WareneingangspositionenPK() {
    }

    public WareneingangspositionenPK(int waenr, short pos) {
        this.waenr = waenr;
        this.pos = pos;
    }

    public int getWaenr() {
        return waenr;
    }

    public void setWaenr(int waenr) {
        this.waenr = waenr;
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
        hash += (int) waenr;
        hash += (int) pos;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WareneingangspositionenPK)) {
            return false;
        }
        WareneingangspositionenPK other = (WareneingangspositionenPK) object;
        if (this.waenr != other.waenr) {
            return false;
        }
        if (this.pos != other.pos) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kasmi.wawi.model.WareneingangspositionenPK[ waenr=" + waenr + ", pos=" + pos + " ]";
    }
    
}
