
package kasmi.wawi.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "lieferanten", catalog = "wawi", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lieferanten.findAll", query = "SELECT l FROM Lieferanten l")
    , @NamedQuery(name = "Lieferanten.findByLiefnr", query = "SELECT l FROM Lieferanten l WHERE l.liefnr = :liefnr")
    , @NamedQuery(name = "Lieferanten.findByFirma1", query = "SELECT l FROM Lieferanten l WHERE l.firma1 = :firma1")
    , @NamedQuery(name = "Lieferanten.findByFirma2", query = "SELECT l FROM Lieferanten l WHERE l.firma2 = :firma2")
    , @NamedQuery(name = "Lieferanten.findByStrasse", query = "SELECT l FROM Lieferanten l WHERE l.strasse = :strasse")
    , @NamedQuery(name = "Lieferanten.findByLand", query = "SELECT l FROM Lieferanten l WHERE l.land = :land")
    , @NamedQuery(name = "Lieferanten.findByPlz", query = "SELECT l FROM Lieferanten l WHERE l.plz = :plz")
    , @NamedQuery(name = "Lieferanten.findByOrt", query = "SELECT l FROM Lieferanten l WHERE l.ort = :ort")
    , @NamedQuery(name = "Lieferanten.findByTel1", query = "SELECT l FROM Lieferanten l WHERE l.tel1 = :tel1")
    , @NamedQuery(name = "Lieferanten.findByTel2", query = "SELECT l FROM Lieferanten l WHERE l.tel2 = :tel2")
    , @NamedQuery(name = "Lieferanten.findByFax1", query = "SELECT l FROM Lieferanten l WHERE l.fax1 = :fax1")
    , @NamedQuery(name = "Lieferanten.findByFax2", query = "SELECT l FROM Lieferanten l WHERE l.fax2 = :fax2")
    , @NamedQuery(name = "Lieferanten.findByAnsprechpartner", query = "SELECT l FROM Lieferanten l WHERE l.ansprechpartner = :ansprechpartner")
    , @NamedQuery(name = "Lieferanten.findByEmail1", query = "SELECT l FROM Lieferanten l WHERE l.email1 = :email1")
    , @NamedQuery(name = "Lieferanten.findByEmail2", query = "SELECT l FROM Lieferanten l WHERE l.email2 = :email2")
    , @NamedQuery(name = "Lieferanten.findByWeb", query = "SELECT l FROM Lieferanten l WHERE l.web = :web")
    , @NamedQuery(name = "Lieferanten.findBySkonto", query = "SELECT l FROM Lieferanten l WHERE l.skonto = :skonto")
    , @NamedQuery(name = "Lieferanten.findBySkontotage", query = "SELECT l FROM Lieferanten l WHERE l.skontotage = :skontotage")
    , @NamedQuery(name = "Lieferanten.findByZiel", query = "SELECT l FROM Lieferanten l WHERE l.ziel = :ziel")
    , @NamedQuery(name = "Lieferanten.findByAktiv", query = "SELECT l FROM Lieferanten l WHERE l.aktiv = :aktiv")
    , @NamedQuery(name = "Lieferanten.findByHinweis", query = "SELECT l FROM Lieferanten l WHERE l.hinweis = :hinweis")
    , @NamedQuery(name = "Lieferanten.findByErfasst", query = "SELECT l FROM Lieferanten l WHERE l.erfasst = :erfasst")})
public class Lieferanten implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "liefnr")
    private Integer liefnr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "firma1")
    private String firma1;
    @Size(max = 50)
    @Column(name = "firma2")
    private String firma2;
    @Size(max = 50)
    @Column(name = "strasse")
    private String strasse;
    @Size(max = 3)
    @Column(name = "land")
    private String land;
    @Size(max = 5)
    @Column(name = "plz")
    private String plz;
    @Size(max = 60)
    @Column(name = "ort")
    private String ort;
    @Size(max = 15)
    @Column(name = "tel1")
    private String tel1;
    @Size(max = 15)
    @Column(name = "tel2")
    private String tel2;
    @Size(max = 15)
    @Column(name = "fax1")
    private String fax1;
    @Size(max = 50)
    @Column(name = "fax2")
    private String fax2;
    @Size(max = 60)
    @Column(name = "ansprechpartner")
    private String ansprechpartner;
    @Size(max = 60)
    @Column(name = "email1")
    private String email1;
    @Size(max = 60)
    @Column(name = "email2")
    private String email2;
    @Size(max = 50)
    @Column(name = "web")
    private String web;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "skonto")
    private BigDecimal skonto;
    @Column(name = "skontotage")
    private Short skontotage;
    @Column(name = "ziel")
    private Short ziel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aktiv")
    private short aktiv;
    @Size(max = 300)
    @Column(name = "hinweis")
    private String hinweis;
    @Basic(optional = false)
    @NotNull
    @Column(name = "erfasst")
    @Temporal(TemporalType.TIMESTAMP)
    private Date erfasst;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lief")
    private Collection<Artikel> artikelCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lieferant")
    private Collection<Bestellungen> bestellungenCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lieferant")
    private Collection<Wareneingang> wareneingangCollection;

    public Lieferanten() {
    }

    public Lieferanten(Integer liefnr) {
        this.liefnr = liefnr;
    }

    public Lieferanten(Integer liefnr, String firma1, short aktiv, Date erfasst) {
        this.liefnr = liefnr;
        this.firma1 = firma1;
        this.aktiv = aktiv;
        this.erfasst = erfasst;
    }

    public Integer getLiefnr() {
        return liefnr;
    }

    public void setLiefnr(Integer liefnr) {
        this.liefnr = liefnr;
    }

    public String getFirma1() {
        return firma1;
    }

    public void setFirma1(String firma1) {
        this.firma1 = firma1;
    }

    public String getFirma2() {
        return firma2;
    }

    public void setFirma2(String firma2) {
        this.firma2 = firma2;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public String getFax1() {
        return fax1;
    }

    public void setFax1(String fax1) {
        this.fax1 = fax1;
    }

    public String getFax2() {
        return fax2;
    }

    public void setFax2(String fax2) {
        this.fax2 = fax2;
    }

    public String getAnsprechpartner() {
        return ansprechpartner;
    }

    public void setAnsprechpartner(String ansprechpartner) {
        this.ansprechpartner = ansprechpartner;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public BigDecimal getSkonto() {
        return skonto;
    }

    public void setSkonto(BigDecimal skonto) {
        this.skonto = skonto;
    }

    public Short getSkontotage() {
        return skontotage;
    }

    public void setSkontotage(Short skontotage) {
        this.skontotage = skontotage;
    }

    public Short getZiel() {
        return ziel;
    }

    public void setZiel(Short ziel) {
        this.ziel = ziel;
    }

    public short getAktiv() {
        return aktiv;
    }

    public void setAktiv(short aktiv) {
        this.aktiv = aktiv;
    }

    public String getHinweis() {
        return hinweis;
    }

    public void setHinweis(String hinweis) {
        this.hinweis = hinweis;
    }

    public Date getErfasst() {
        return erfasst;
    }

    public void setErfasst(Date erfasst) {
        this.erfasst = erfasst;
    }

    @XmlTransient
    public Collection<Artikel> getArtikelCollection() {
        return artikelCollection;
    }

    public void setArtikelCollection(Collection<Artikel> artikelCollection) {
        this.artikelCollection = artikelCollection;
    }

    @XmlTransient
    public Collection<Bestellungen> getBestellungenCollection() {
        return bestellungenCollection;
    }

    public void setBestellungenCollection(Collection<Bestellungen> bestellungenCollection) {
        this.bestellungenCollection = bestellungenCollection;
    }

    @XmlTransient
    public Collection<Wareneingang> getWareneingangCollection() {
        return wareneingangCollection;
    }

    public void setWareneingangCollection(Collection<Wareneingang> wareneingangCollection) {
        this.wareneingangCollection = wareneingangCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (liefnr != null ? liefnr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lieferanten)) {
            return false;
        }
        Lieferanten other = (Lieferanten) object;
        if ((this.liefnr == null && other.liefnr != null) || (this.liefnr != null && !this.liefnr.equals(other.liefnr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kasmi.wawi.model.Lieferanten[ liefnr=" + liefnr + " ]";
    }
    
}
