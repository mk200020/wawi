
package kasmi.wawi.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "bestellpositionen", catalog = "wawi", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bestellpositionen.findAll", query = "SELECT b FROM Bestellpositionen b")
    , @NamedQuery(name = "Bestellpositionen.findByBestnr", query = "SELECT b FROM Bestellpositionen b WHERE b.bestellpositionenPK.bestnr = :bestnr")
    , @NamedQuery(name = "Bestellpositionen.findByPos", query = "SELECT b FROM Bestellpositionen b WHERE b.bestellpositionenPK.pos = :pos")
    , @NamedQuery(name = "Bestellpositionen.findByText", query = "SELECT b FROM Bestellpositionen b WHERE b.text = :text")
    , @NamedQuery(name = "Bestellpositionen.findByMenge", query = "SELECT b FROM Bestellpositionen b WHERE b.menge = :menge")
    , @NamedQuery(name = "Bestellpositionen.findByPreis", query = "SELECT b FROM Bestellpositionen b WHERE b.preis = :preis")
    , @NamedQuery(name = "Bestellpositionen.findByRabatt", query = "SELECT b FROM Bestellpositionen b WHERE b.rabatt = :rabatt")})
public class Bestellpositionen implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BestellpositionenPK bestellpositionenPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "text")
    private String text;
    @Basic(optional = false)
    @NotNull
    @Column(name = "menge")
    private int menge;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "preis")
    private BigDecimal preis;
    @Column(name = "rabatt")
    private BigDecimal rabatt;
    @JoinColumn(name = "artikel", referencedColumnName = "artnr")
    @ManyToOne(optional = false)
    private Artikel artikel;
    @JoinColumn(name = "bestnr", referencedColumnName = "bestnr", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Bestellungen bestellungen;

    public Bestellpositionen() {
    }

    public Bestellpositionen(BestellpositionenPK bestellpositionenPK) {
        this.bestellpositionenPK = bestellpositionenPK;
    }

    public Bestellpositionen(BestellpositionenPK bestellpositionenPK, String text, int menge, BigDecimal preis) {
        this.bestellpositionenPK = bestellpositionenPK;
        this.text = text;
        this.menge = menge;
        this.preis = preis;
    }

    public Bestellpositionen(int bestnr, short pos) {
        this.bestellpositionenPK = new BestellpositionenPK(bestnr, pos);
    }

    public BestellpositionenPK getBestellpositionenPK() {
        return bestellpositionenPK;
    }

    public void setBestellpositionenPK(BestellpositionenPK bestellpositionenPK) {
        this.bestellpositionenPK = bestellpositionenPK;
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

    public BigDecimal getPreis() {
        return preis;
    }

    public void setPreis(BigDecimal preis) {
        this.preis = preis;
    }

    public BigDecimal getRabatt() {
        return rabatt;
    }

    public void setRabatt(BigDecimal rabatt) {
        this.rabatt = rabatt;
    }

    public Artikel getArtikel() {
        return artikel;
    }

    public void setArtikel(Artikel artikel) {
        this.artikel = artikel;
    }

    public Bestellungen getBestellungen() {
        return bestellungen;
    }

    public void setBestellungen(Bestellungen bestellungen) {
        this.bestellungen = bestellungen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bestellpositionenPK != null ? bestellpositionenPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bestellpositionen)) {
            return false;
        }
        Bestellpositionen other = (Bestellpositionen) object;
        if ((this.bestellpositionenPK == null && other.bestellpositionenPK != null) || (this.bestellpositionenPK != null && !this.bestellpositionenPK.equals(other.bestellpositionenPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kasmi.wawi.model.Bestellpositionen[ bestellpositionenPK=" + bestellpositionenPK + " ]";
    }
    
}
