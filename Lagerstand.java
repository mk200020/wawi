
package kasmi.wawi.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mohamed
 */
@Entity
@Table(name = "lagerstand", catalog = "wawi", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lagerstand.findAll", query = "SELECT l FROM Lagerstand l")
    , @NamedQuery(name = "Lagerstand.findByArtnr", query = "SELECT l FROM Lagerstand l WHERE l.lagerstandPK.artnr = :artnr")
    , @NamedQuery(name = "Lagerstand.findByLagnr", query = "SELECT l FROM Lagerstand l WHERE l.lagerstandPK.lagnr = :lagnr")
    , @NamedQuery(name = "Lagerstand.findByMenge", query = "SELECT l FROM Lagerstand l WHERE l.menge = :menge")
    , @NamedQuery(name = "Lagerstand.findByReserviert", query = "SELECT l FROM Lagerstand l WHERE l.reserviert = :reserviert")})
public class Lagerstand implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LagerstandPK lagerstandPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "menge")
    private int menge;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reserviert")
    private int reserviert;
    @JoinColumn(name = "artnr", referencedColumnName = "artnr", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Artikel artikel;
    @JoinColumn(name = "lagnr", referencedColumnName = "lagnr", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Lager lager;

    public Lagerstand() {
    }

    public Lagerstand(LagerstandPK lagerstandPK) {
        this.lagerstandPK = lagerstandPK;
    }

    public Lagerstand(LagerstandPK lagerstandPK, int menge, int reserviert) {
        this.lagerstandPK = lagerstandPK;
        this.menge = menge;
        this.reserviert = reserviert;
    }

    public Lagerstand(int artnr, short lagnr) {
        this.lagerstandPK = new LagerstandPK(artnr, lagnr);
    }

    public LagerstandPK getLagerstandPK() {
        return lagerstandPK;
    }

    public void setLagerstandPK(LagerstandPK lagerstandPK) {
        this.lagerstandPK = lagerstandPK;
    }

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }

    public int getReserviert() {
        return reserviert;
    }

    public void setReserviert(int reserviert) {
        this.reserviert = reserviert;
    }

    public Artikel getArtikel() {
        return artikel;
    }

    public void setArtikel(Artikel artikel) {
        this.artikel = artikel;
    }

    public Lager getLager() {
        return lager;
    }

    public void setLager(Lager lager) {
        this.lager = lager;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lagerstandPK != null ? lagerstandPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lagerstand)) {
            return false;
        }
        Lagerstand other = (Lagerstand) object;
        if ((this.lagerstandPK == null && other.lagerstandPK != null) || (this.lagerstandPK != null && !this.lagerstandPK.equals(other.lagerstandPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kasmi.wawi.model.Lagerstand[ lagerstandPK=" + lagerstandPK + " ]";
    }
    
}
