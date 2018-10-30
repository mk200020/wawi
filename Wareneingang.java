package kasmi.wawi.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "wareneingang", catalog = "wawi", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wareneingang.findAll", query = "SELECT w FROM Wareneingang w")
    , @NamedQuery(name = "Wareneingang.findByWaenr", query = "SELECT w FROM Wareneingang w WHERE w.waenr = :waenr")
    , @NamedQuery(name = "Wareneingang.findByDatum", query = "SELECT w FROM Wareneingang w WHERE w.datum = :datum")
    , @NamedQuery(name = "Wareneingang.findByLsnr", query = "SELECT w FROM Wareneingang w WHERE w.lsnr = :lsnr")})
public class Wareneingang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "waenr")
    private Integer waenr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datum")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datum;
    @Size(max = 20)
    @Column(name = "lsnr")
    private String lsnr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wareneingang")
    private Collection<Wareneingangspositionen> wareneingangspositionenCollection;
    @JoinColumn(name = "lieferant", referencedColumnName = "liefnr")
    @ManyToOne(optional = false)
    private Lieferanten lieferant;
    @JoinColumn(name = "bearbeiter", referencedColumnName = "persnr")
    @ManyToOne(optional = false)
    private Personal bearbeiter;
    @JoinColumn(name = "status", referencedColumnName = "stid")
    @ManyToOne(optional = false)
    private Status status;

    public Wareneingang() {
    }

    public Wareneingang(Integer waenr) {
        this.waenr = waenr;
    }

    public Wareneingang(Integer waenr, Date datum) {
        this.waenr = waenr;
        this.datum = datum;
    }

    public Integer getWaenr() {
        return waenr;
    }

    public void setWaenr(Integer waenr) {
        this.waenr = waenr;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getLsnr() {
        return lsnr;
    }

    public void setLsnr(String lsnr) {
        this.lsnr = lsnr;
    }

    @XmlTransient
    public Collection<Wareneingangspositionen> getWareneingangspositionenCollection() {
        return wareneingangspositionenCollection;
    }

    public void setWareneingangspositionenCollection(Collection<Wareneingangspositionen> wareneingangspositionenCollection) {
        this.wareneingangspositionenCollection = wareneingangspositionenCollection;
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
        hash += (waenr != null ? waenr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wareneingang)) {
            return false;
        }
        Wareneingang other = (Wareneingang) object;
        if ((this.waenr == null && other.waenr != null) || (this.waenr != null && !this.waenr.equals(other.waenr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kasmi.wawi.model.Wareneingang[ waenr=" + waenr + " ]";
    }
    
}
