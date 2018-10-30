
package kasmi.wawi.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "artikel", catalog = "wawi", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Artikel.findAll", query = "SELECT a FROM Artikel a")
    , @NamedQuery(name = "Artikel.findByArtnr", query = "SELECT a FROM Artikel a WHERE a.artnr = :artnr")
    , @NamedQuery(name = "Artikel.findByBezeichnung", query = "SELECT a FROM Artikel a WHERE a.bezeichnung = :bezeichnung")
    , @NamedQuery(name = "Artikel.findByVkpreis", query = "SELECT a FROM Artikel a WHERE a.vkpreis = :vkpreis")
    , @NamedQuery(name = "Artikel.findByEkpreis", query = "SELECT a FROM Artikel a WHERE a.ekpreis = :ekpreis")
    , @NamedQuery(name = "Artikel.findByLieferzeit", query = "SELECT a FROM Artikel a WHERE a.lieferzeit = :lieferzeit")
    , @NamedQuery(name = "Artikel.findByMindbestand", query = "SELECT a FROM Artikel a WHERE a.mindbestand = :mindbestand")
    , @NamedQuery(name = "Artikel.findByHinweis", query = "SELECT a FROM Artikel a WHERE a.hinweis = :hinweis")
    , @NamedQuery(name = "Artikel.findByMengebestellt", query = "SELECT a FROM Artikel a WHERE a.mengebestellt = :mengebestellt")
    , @NamedQuery(name = "Artikel.findByMwst", query = "SELECT a FROM Artikel a WHERE a.mwst = :mwst")
    , @NamedQuery(name = "Artikel.findByAktiv", query = "SELECT a FROM Artikel a WHERE a.aktiv = :aktiv")
    , @NamedQuery(name = "Artikel.findByInaktivam", query = "SELECT a FROM Artikel a WHERE a.inaktivam = :inaktivam")
    , @NamedQuery(name = "Artikel.findByInaktivvon", query = "SELECT a FROM Artikel a WHERE a.inaktivvon = :inaktivvon")})
public class Artikel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "artnr")
    private Integer artnr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "bezeichnung")
    private String bezeichnung;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "vkpreis")
    private BigDecimal vkpreis;
    @Column(name = "ekpreis")
    private BigDecimal ekpreis;
    @Column(name = "lieferzeit")
    private Short lieferzeit;
    @Column(name = "mindbestand")
    private Integer mindbestand;
    @Size(max = 300)
    @Column(name = "hinweis")
    private String hinweis;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mengebestellt")
    private int mengebestellt;
    @Column(name = "mwst")
    private Short mwst;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aktiv")
    private short aktiv;
    @Column(name = "inaktivam")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inaktivam;
    @Size(max = 30)
    @Column(name = "inaktivvon")
    private String inaktivvon;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artikel")
    private Collection<Bestellpositionen> bestellpositionenCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artikel")
    private Collection<Wareneingangspositionen> wareneingangspositionenCollection;
    @JoinColumn(name = "gruppe", referencedColumnName = "artgr")
    @ManyToOne(optional = false)
    private Artikelgruppen gruppe;
    @JoinColumn(name = "lief", referencedColumnName = "liefnr")
    @ManyToOne(optional = false)
    private Lieferanten lief;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artikel")
    private Collection<Setartikel> setartikelCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artikel1")
    private Collection<Setartikel> setartikelCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artikel")
    private Collection<Lagerstand> lagerstandCollection;

    public Artikel() {
    }

    public Artikel(Integer artnr) {
        this.artnr = artnr;
    }

    public Artikel(Integer artnr, String bezeichnung, BigDecimal vkpreis, int mengebestellt, short aktiv) {
        this.artnr = artnr;
        this.bezeichnung = bezeichnung;
        this.vkpreis = vkpreis;
        this.mengebestellt = mengebestellt;
        this.aktiv = aktiv;
    }

    public Integer getArtnr() {
        return artnr;
    }

    public void setArtnr(Integer artnr) {
        this.artnr = artnr;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public BigDecimal getVkpreis() {
        return vkpreis;
    }

    public void setVkpreis(BigDecimal vkpreis) {
        this.vkpreis = vkpreis;
    }

    public BigDecimal getEkpreis() {
        return ekpreis;
    }

    public void setEkpreis(BigDecimal ekpreis) {
        this.ekpreis = ekpreis;
    }

    public Short getLieferzeit() {
        return lieferzeit;
    }

    public void setLieferzeit(Short lieferzeit) {
        this.lieferzeit = lieferzeit;
    }

    public Integer getMindbestand() {
        return mindbestand;
    }

    public void setMindbestand(Integer mindbestand) {
        this.mindbestand = mindbestand;
    }

    public String getHinweis() {
        return hinweis;
    }

    public void setHinweis(String hinweis) {
        this.hinweis = hinweis;
    }

    public int getMengebestellt() {
        return mengebestellt;
    }

    public void setMengebestellt(int mengebestellt) {
        this.mengebestellt = mengebestellt;
    }

    public Short getMwst() {
        return mwst;
    }

    public void setMwst(Short mwst) {
        this.mwst = mwst;
    }

    public short getAktiv() {
        return aktiv;
    }

    public void setAktiv(short aktiv) {
        this.aktiv = aktiv;
    }

    public Date getInaktivam() {
        return inaktivam;
    }

    public void setInaktivam(Date inaktivam) {
        this.inaktivam = inaktivam;
    }

    public String getInaktivvon() {
        return inaktivvon;
    }

    public void setInaktivvon(String inaktivvon) {
        this.inaktivvon = inaktivvon;
    }

    @XmlTransient
    public Collection<Bestellpositionen> getBestellpositionenCollection() {
        return bestellpositionenCollection;
    }

    public void setBestellpositionenCollection(Collection<Bestellpositionen> bestellpositionenCollection) {
        this.bestellpositionenCollection = bestellpositionenCollection;
    }

    @XmlTransient
    public Collection<Wareneingangspositionen> getWareneingangspositionenCollection() {
        return wareneingangspositionenCollection;
    }

    public void setWareneingangspositionenCollection(Collection<Wareneingangspositionen> wareneingangspositionenCollection) {
        this.wareneingangspositionenCollection = wareneingangspositionenCollection;
    }

    public Artikelgruppen getGruppe() {
        return gruppe;
    }

    public void setGruppe(Artikelgruppen gruppe) {
        this.gruppe = gruppe;
    }

    public Lieferanten getLief() {
        return lief;
    }

    public void setLief(Lieferanten lief) {
        this.lief = lief;
    }

    @XmlTransient
    public Collection<Setartikel> getSetartikelCollection() {
        return setartikelCollection;
    }

    public void setSetartikelCollection(Collection<Setartikel> setartikelCollection) {
        this.setartikelCollection = setartikelCollection;
    }

    @XmlTransient
    public Collection<Setartikel> getSetartikelCollection1() {
        return setartikelCollection1;
    }

    public void setSetartikelCollection1(Collection<Setartikel> setartikelCollection1) {
        this.setartikelCollection1 = setartikelCollection1;
    }

    @XmlTransient
    public Collection<Lagerstand> getLagerstandCollection() {
        return lagerstandCollection;
    }

    public void setLagerstandCollection(Collection<Lagerstand> lagerstandCollection) {
        this.lagerstandCollection = lagerstandCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (artnr != null ? artnr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Artikel)) {
            return false;
        }
        Artikel other = (Artikel) object;
        if ((this.artnr == null && other.artnr != null) || (this.artnr != null && !this.artnr.equals(other.artnr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kasmi.wawi.model.Artikel[ artnr=" + artnr + " ]";
    }
    
}
