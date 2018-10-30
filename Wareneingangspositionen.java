
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mohamed
 */
@Entity
@Table(name = "wareneingangspositionen", catalog = "wawi", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wareneingangspositionen.findAll", query = "SELECT w FROM Wareneingangspositionen w")
    , @NamedQuery(name = "Wareneingangspositionen.findByWaenr", query = "SELECT w FROM Wareneingangspositionen w WHERE w.wareneingangspositionenPK.waenr = :waenr")
    , @NamedQuery(name = "Wareneingangspositionen.findByPos", query = "SELECT w FROM Wareneingangspositionen w WHERE w.wareneingangspositionenPK.pos = :pos")
    , @NamedQuery(name = "Wareneingangspositionen.findByText", query = "SELECT w FROM Wareneingangspositionen w WHERE w.text = :text")
    , @NamedQuery(name = "Wareneingangspositionen.findByMenge", query = "SELECT w FROM Wareneingangspositionen w WHERE w.menge = :menge")
    , @NamedQuery(name = "Wareneingangspositionen.findByLager", query = "SELECT w FROM Wareneingangspositionen w WHERE w.lager = :lager")})
public class Wareneingangspositionen implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WareneingangspositionenPK wareneingangspositionenPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "text")
    private String text;
    @Basic(optional = false)
    @NotNull
    @Column(name = "menge")
    private int menge;
    @Column(name = "lager")
    private Short lager;
    @JoinColumn(name = "artikel", referencedColumnName = "artnr")
    @ManyToOne(optional = false)
    private Artikel artikel;
    @JoinColumn(name = "waenr", referencedColumnName = "waenr", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Wareneingang wareneingang;

    public Wareneingangspositionen() {
    }

    public Wareneingangspositionen(WareneingangspositionenPK wareneingangspositionenPK) {
        this.wareneingangspositionenPK = wareneingangspositionenPK;
    }

    public Wareneingangspositionen(WareneingangspositionenPK wareneingangspositionenPK, String text, int menge) {
        this.wareneingangspositionenPK = wareneingangspositionenPK;
        this.text = text;
        this.menge = menge;
    }

    public Wareneingangspositionen(int waenr, short pos) {
        this.wareneingangspositionenPK = new WareneingangspositionenPK(waenr, pos);
    }

    public WareneingangspositionenPK getWareneingangspositionenPK() {
        return wareneingangspositionenPK;
    }

    public void setWareneingangspositionenPK(WareneingangspositionenPK wareneingangspositionenPK) {
        this.wareneingangspositionenPK = wareneingangspositionenPK;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }

    public Short getLager() {
        return lager;
    }

    public void setLager(Short lager) {
        this.lager = lager;
    }

    public Artikel getArtikel() {
        return artikel;
    }

    public void setArtikel(Artikel artikel) {
        this.artikel = artikel;
    }

    public Wareneingang getWareneingang() {
        return wareneingang;
    }

    public void setWareneingang(Wareneingang wareneingang) {
        this.wareneingang = wareneingang;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wareneingangspositionenPK != null ? wareneingangspositionenPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wareneingangspositionen)) {
            return false;
        }
        Wareneingangspositionen other = (Wareneingangspositionen) object;
        if ((this.wareneingangspositionenPK == null && other.wareneingangspositionenPK != null) || (this.wareneingangspositionenPK != null && !this.wareneingangspositionenPK.equals(other.wareneingangspositionenPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kasmi.wawi.model.Wareneingangspositionen[ wareneingangspositionenPK=" + wareneingangspositionenPK + " ]";
    }
    
}
