
package kasmi.wawi.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mohamed
 */
@Entity
@Table(name = "bestellungen", catalog = "wawi", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bestellungen.findAll", query = "SELECT b FROM Bestellungen b")
    , @NamedQuery(name = "Bestellungen.findByBestnr", query = "SELECT b FROM Bestellungen b WHERE b.bestnr = :bestnr")
    , @NamedQuery(name = "Bestellungen.findByDatum", query = "SELECT b FROM Bestellungen b WHERE b.datum = :datum")
    , @NamedQuery(name = "Bestellungen.findByBemerkung", query = "SELECT b FROM Bestellungen b WHERE b.bemerkung = :bemerkung")})
public class Bestellungen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bestnr")
    private Integer bestnr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datum")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datum;
    @Size(max = 300)
    @Column(name = "bemerkung")
    private String bemerkung;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bestellungen")
    private Collection<Bestellpositionen> bestellpositionenCollection;
    @JoinColumn(name = "lieferant", referencedColumnName = "liefnr")
    @ManyToOne(optional = false)
    private Lieferanten lieferant;
    @JoinColumn(name = "bearbeiter", referencedColumnName = "persnr")
    @ManyToOne(optional = false)
    private Personal bearbeiter;
    @JoinColumn(name = "status", referencedColumnName = "stid")
    @ManyToOne(optional = false)
    private Status status;

    public Bestellungen() {
    }

    public Bestellungen(Integer bestnr) {
        this.bestnr = bestnr;
    }

    public Bestellungen(Integer bestnr, Date datum) {
        this.bestnr = bestnr;
        this.datum = datum;
    }

    public Integer getBestnr() {
        return bestnr;
    }

    public void setBestnr(Integer bestnr) {
        this.bestnr = bestnr;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getBemerkung() {
        return bemerkung;
    }

    public void setBemerkung(String bemerkung) {
        this.bemerkung = bemerkung;
    }

    @XmlTransient
    public Collection<Bestellpositionen> getBestellpositionenCollection() {
        return bestellpositionenCollection;
    }

    public void setBestellpositionenCollection(Collection<Bestellpositionen> bestellpositionenCollection) {
        this.bestellpositionenCollection = bestellpositionenCollection;
    }

    public Lieferanten getLieferant() {
        return lieferant;
    }

    public void setLieferant(Lieferanten lieferant) {
        this.lieferant = lieferant;
    }

    public Personal getBearbeiter() {
        return bearbeiter;
    }

    public void setBearbeiter(Personal bearbeiter) {
        this.bearbeiter = bearbeiter;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bestnr != null ? bestnr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bestellungen)) {
            return false;
        }
        Bestellungen other = (Bestellungen) object;
        if ((this.bestnr == null && other.bestnr != null) || (this.bestnr != null && !this.bestnr.equals(other.bestnr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kasmi.wawi.model.Bestellungen[ bestnr=" + bestnr + " ]";
    }
    
}
