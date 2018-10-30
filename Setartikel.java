
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
@Table(name = "setartikel", catalog = "wawi", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Setartikel.findAll", query = "SELECT s FROM Setartikel s")
    , @NamedQuery(name = "Setartikel.findBySetartnr", query = "SELECT s FROM Setartikel s WHERE s.setartikelPK.setartnr = :setartnr")
    , @NamedQuery(name = "Setartikel.findByTeilartnr", query = "SELECT s FROM Setartikel s WHERE s.setartikelPK.teilartnr = :teilartnr")
    , @NamedQuery(name = "Setartikel.findByMenge", query = "SELECT s FROM Setartikel s WHERE s.menge = :menge")})
public class Setartikel implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SetartikelPK setartikelPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "menge")
    private int menge;
    @JoinColumn(name = "setartnr", referencedColumnName = "artnr", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Artikel artikel;
    @JoinColumn(name = "teilartnr", referencedColumnName = "artnr", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Artikel artikel1;

    public Setartikel() {
    }

    public Setartikel(SetartikelPK setartikelPK) {
        this.setartikelPK = setartikelPK;
    }

    public Setartikel(SetartikelPK setartikelPK, int menge) {
        this.setartikelPK = setartikelPK;
        this.menge = menge;
    }

    public Setartikel(int setartnr, int teilartnr) {
        this.setartikelPK = new SetartikelPK(setartnr, teilartnr);
    }

    public SetartikelPK getSetartikelPK() {
        return setartikelPK;
    }

    public void setSetartikelPK(SetartikelPK setartikelPK) {
        this.setartikelPK = setartikelPK;
    }

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }

    public Artikel getArtikel() {
        return artikel;
    }

    public void setArtikel(Artikel artikel) {
        this.artikel = artikel;
    }

    public Artikel getArtikel1() {
        return artikel1;
    }

    public void setArtikel1(Artikel artikel1) {
        this.artikel1 = artikel1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (setartikelPK != null ? setartikelPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Setartikel)) {
            return false;
        }
        Setartikel other = (Setartikel) object;
        if ((this.setartikelPK == null && other.setartikelPK != null) || (this.setartikelPK != null && !this.setartikelPK.equals(other.setartikelPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kasmi.wawi.model.Setartikel[ setartikelPK=" + setartikelPK + " ]";
    }
    
}
