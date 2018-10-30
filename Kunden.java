
package kasmi.wawi.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "kunden", catalog = "wawi", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kunden.findAll", query = "SELECT k FROM Kunden k")
    , @NamedQuery(name = "Kunden.findByKdnr", query = "SELECT k FROM Kunden k WHERE k.kdnr = :kdnr")
    , @NamedQuery(name = "Kunden.findByNachname", query = "SELECT k FROM Kunden k WHERE k.nachname = :nachname")
    , @NamedQuery(name = "Kunden.findByVorname", query = "SELECT k FROM Kunden k WHERE k.vorname = :vorname")
    , @NamedQuery(name = "Kunden.findByTitel", query = "SELECT k FROM Kunden k WHERE k.titel = :titel")
    , @NamedQuery(name = "Kunden.findByAkadgrad", query = "SELECT k FROM Kunden k WHERE k.akadgrad = :akadgrad")
    , @NamedQuery(name = "Kunden.findByFirma1", query = "SELECT k FROM Kunden k WHERE k.firma1 = :firma1")
    , @NamedQuery(name = "Kunden.findByFirma2", query = "SELECT k FROM Kunden k WHERE k.firma2 = :firma2")
    , @NamedQuery(name = "Kunden.findByStrasse", query = "SELECT k FROM Kunden k WHERE k.strasse = :strasse")
    , @NamedQuery(name = "Kunden.findByLand", query = "SELECT k FROM Kunden k WHERE k.land = :land")
    , @NamedQuery(name = "Kunden.findByPlz", query = "SELECT k FROM Kunden k WHERE k.plz = :plz")
    , @NamedQuery(name = "Kunden.findByOrt", query = "SELECT k FROM Kunden k WHERE k.ort = :ort")
    , @NamedQuery(name = "Kunden.findByTelefon", query = "SELECT k FROM Kunden k WHERE k.telefon = :telefon")
    , @NamedQuery(name = "Kunden.findByFax", query = "SELECT k FROM Kunden k WHERE k.fax = :fax")
    , @NamedQuery(name = "Kunden.findByMobil", query = "SELECT k FROM Kunden k WHERE k.mobil = :mobil")
    , @NamedQuery(name = "Kunden.findByEmail", query = "SELECT k FROM Kunden k WHERE k.email = :email")
    , @NamedQuery(name = "Kunden.findByWeb", query = "SELECT k FROM Kunden k WHERE k.web = :web")
    , @NamedQuery(name = "Kunden.findByErfasst", query = "SELECT k FROM Kunden k WHERE k.erfasst = :erfasst")
    , @NamedQuery(name = "Kunden.findBySkonto", query = "SELECT k FROM Kunden k WHERE k.skonto = :skonto")
    , @NamedQuery(name = "Kunden.findBySkontotage", query = "SELECT k FROM Kunden k WHERE k.skontotage = :skontotage")
    , @NamedQuery(name = "Kunden.findByZiel", query = "SELECT k FROM Kunden k WHERE k.ziel = :ziel")
    , @NamedQuery(name = "Kunden.findByLieferschein", query = "SELECT k FROM Kunden k WHERE k.lieferschein = :lieferschein")
    , @NamedQuery(name = "Kunden.findByGesperrt", query = "SELECT k FROM Kunden k WHERE k.gesperrt = :gesperrt")
    , @NamedQuery(name = "Kunden.findByHinweis", query = "SELECT k FROM Kunden k WHERE k.hinweis = :hinweis")})
public class Kunden implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "kdnr")
    private Integer kdnr;
    @Size(max = 50)
    @Column(name = "nachname")
    private String nachname;
    @Size(max = 50)
    @Column(name = "vorname")
    private String vorname;
    @Size(max = 15)
    @Column(name = "titel")
    private String titel;
    @Size(max = 15)
    @Column(name = "akadgrad")
    private String akadgrad;
    @Size(max = 50)
    @Column(name = "firma1")
    private String firma1;
    @Size(max = 50)
    @Column(name = "firma2")
    private String firma2;
    @Size(max = 50)
    @Column(name = "strasse")
    private String strasse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "land")
    private String land;
    @Size(max = 5)
    @Column(name = "plz")
    private String plz;
    @Size(max = 50)
    @Column(name = "ort")
    private String ort;
    @Size(max = 20)
    @Column(name = "telefon")
    private String telefon;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "fax")
    private String fax;
    @Size(max = 20)
    @Column(name = "mobil")
    private String mobil;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 60)
    @Column(name = "email")
    private String email;
    @Size(max = 10)
    @Column(name = "web")
    private String web;
    @Basic(optional = false)
    @NotNull
    @Column(name = "erfasst")
    @Temporal(TemporalType.TIMESTAMP)
    private Date erfasst;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "skonto")
    private BigDecimal skonto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "skontotage")
    private short skontotage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ziel")
    private short ziel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lieferschein")
    private short lieferschein;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gesperrt")
    private short gesperrt;
    @Size(max = 300)
    @Column(name = "hinweis")
    private String hinweis;
    @ManyToMany(mappedBy = "kundenCollection")
    private Collection<Interessen> interessenCollection;
    @JoinColumn(name = "geschlecht", referencedColumnName = "anrnr")
    @ManyToOne(optional = false)
    private Anreden geschlecht;

    public Kunden() {
    }

    public Kunden(Integer kdnr) {
        this.kdnr = kdnr;
    }

    public Kunden(Integer kdnr, String land, Date erfasst, BigDecimal skonto, short skontotage, short ziel, short lieferschein, short gesperrt) {
        this.kdnr = kdnr;
        this.land = land;
        this.erfasst = erfasst;
        this.skonto = skonto;
        this.skontotage = skontotage;
        this.ziel = ziel;
        this.lieferschein = lieferschein;
        this.gesperrt = gesperrt;
    }

    public Integer getKdnr() {
        return kdnr;
    }

    public void setKdnr(Integer kdnr) {
        this.kdnr = kdnr;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getAkadgrad() {
        return akadgrad;
    }

    public void setAkadgrad(String akadgrad) {
        this.akadgrad = akadgrad;
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

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getMobil() {
        return mobil;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public Date getErfasst() {
        return erfasst;
    }

    public void setErfasst(Date erfasst) {
        this.erfasst = erfasst;
    }

    public BigDecimal getSkonto() {
        return skonto;
    }

    public void setSkonto(BigDecimal skonto) {
        this.skonto = skonto;
    }

    public short getSkontotage() {
        return skontotage;
    }

    public void setSkontotage(short skontotage) {
        this.skontotage = skontotage;
    }

    public short getZiel() {
        return ziel;
    }

    public void setZiel(short ziel) {
        this.ziel = ziel;
    }

    public short getLieferschein() {
        return lieferschein;
    }

    public void setLieferschein(short lieferschein) {
        this.lieferschein = lieferschein;
    }

    public short getGesperrt() {
        return gesperrt;
    }

    public void setGesperrt(short gesperrt) {
        this.gesperrt = gesperrt;
    }

    public String getHinweis() {
        return hinweis;
    }

    public void setHinweis(String hinweis) {
        this.hinweis = hinweis;
    }

    @XmlTransient
    public Collection<Interessen> getInteressenCollection() {
        return interessenCollection;
    }

    public void setInteressenCollection(Collection<Interessen> interessenCollection) {
        this.interessenCollection = interessenCollection;
    }

    public Anreden getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(Anreden geschlecht) {
        this.geschlecht = geschlecht;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kdnr != null ? kdnr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kunden)) {
            return false;
        }
        Kunden other = (Kunden) object;
        if ((this.kdnr == null && other.kdnr != null) || (this.kdnr != null && !this.kdnr.equals(other.kdnr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kasmi.wawi.model.Kunden[ kdnr=" + kdnr + " ]";
    }
    
}
