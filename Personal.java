
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
@Table(name = "personal", catalog = "wawi", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personal.findAll", query = "SELECT p FROM Personal p")
    , @NamedQuery(name = "Personal.findByPersnr", query = "SELECT p FROM Personal p WHERE p.persnr = :persnr")
    , @NamedQuery(name = "Personal.findByNachname", query = "SELECT p FROM Personal p WHERE p.nachname = :nachname")
    , @NamedQuery(name = "Personal.findByVorname", query = "SELECT p FROM Personal p WHERE p.vorname = :vorname")
    , @NamedQuery(name = "Personal.findByTitel", query = "SELECT p FROM Personal p WHERE p.titel = :titel")
    , @NamedQuery(name = "Personal.findByAkadgrad", query = "SELECT p FROM Personal p WHERE p.akadgrad = :akadgrad")
    , @NamedQuery(name = "Personal.findBySozversnr", query = "SELECT p FROM Personal p WHERE p.sozversnr = :sozversnr")
    , @NamedQuery(name = "Personal.findByGebdatum", query = "SELECT p FROM Personal p WHERE p.gebdatum = :gebdatum")
    , @NamedQuery(name = "Personal.findByFamstand", query = "SELECT p FROM Personal p WHERE p.famstand = :famstand")
    , @NamedQuery(name = "Personal.findByStrasse", query = "SELECT p FROM Personal p WHERE p.strasse = :strasse")
    , @NamedQuery(name = "Personal.findByLand", query = "SELECT p FROM Personal p WHERE p.land = :land")
    , @NamedQuery(name = "Personal.findByPlz", query = "SELECT p FROM Personal p WHERE p.plz = :plz")
    , @NamedQuery(name = "Personal.findByOrt", query = "SELECT p FROM Personal p WHERE p.ort = :ort")
    , @NamedQuery(name = "Personal.findByTelefon", query = "SELECT p FROM Personal p WHERE p.telefon = :telefon")
    , @NamedQuery(name = "Personal.findByMobil", query = "SELECT p FROM Personal p WHERE p.mobil = :mobil")
    , @NamedQuery(name = "Personal.findByBank", query = "SELECT p FROM Personal p WHERE p.bank = :bank")
    , @NamedQuery(name = "Personal.findByBlz", query = "SELECT p FROM Personal p WHERE p.blz = :blz")
    , @NamedQuery(name = "Personal.findByKtonr", query = "SELECT p FROM Personal p WHERE p.ktonr = :ktonr")
    , @NamedQuery(name = "Personal.findByEintritt", query = "SELECT p FROM Personal p WHERE p.eintritt = :eintritt")
    , @NamedQuery(name = "Personal.findByAustritt", query = "SELECT p FROM Personal p WHERE p.austritt = :austritt")
    , @NamedQuery(name = "Personal.findByHinweis", query = "SELECT p FROM Personal p WHERE p.hinweis = :hinweis")
    , @NamedQuery(name = "Personal.findByGehalt", query = "SELECT p FROM Personal p WHERE p.gehalt = :gehalt")})
public class Personal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "persnr")
    private Integer persnr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nachname")
    private String nachname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "vorname")
    private String vorname;
    @Size(max = 15)
    @Column(name = "titel")
    private String titel;
    @Size(max = 15)
    @Column(name = "akadgrad")
    private String akadgrad;
    @Size(max = 4)
    @Column(name = "sozversnr")
    private String sozversnr;
    @Column(name = "gebdatum")
    @Temporal(TemporalType.TIMESTAMP)
    private Date gebdatum;
    @Column(name = "famstand")
    private Short famstand;
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
    @Size(max = 20)
    @Column(name = "telefon")
    private String telefon;
    @Size(max = 20)
    @Column(name = "mobil")
    private String mobil;
    @Size(max = 30)
    @Column(name = "bank")
    private String bank;
    @Size(max = 10)
    @Column(name = "blz")
    private String blz;
    @Size(max = 15)
    @Column(name = "ktonr")
    private String ktonr;
    @Column(name = "eintritt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eintritt;
    @Column(name = "austritt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date austritt;
    @Size(max = 300)
    @Column(name = "hinweis")
    private String hinweis;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "gehalt")
    private BigDecimal gehalt;
    @JoinColumn(name = "abtlg", referencedColumnName = "abtnr")
    @ManyToOne(optional = false)
    private Abteilungen abtlg;
    @JoinColumn(name = "geschlecht", referencedColumnName = "anrnr")
    @ManyToOne(optional = false)
    private Anreden geschlecht;
    @OneToMany(mappedBy = "vorgesetzter")
    private Collection<Personal> personalCollection;
    @JoinColumn(name = "vorgesetzter", referencedColumnName = "persnr")
    @ManyToOne
    private Personal vorgesetzter;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bearbeiter")
    private Collection<Bestellungen> bestellungenCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bearbeiter")
    private Collection<Wareneingang> wareneingangCollection;

    public Personal() {
    }

    public Personal(Integer persnr) {
        this.persnr = persnr;
    }

    public Personal(Integer persnr, String nachname, String vorname, BigDecimal gehalt) {
        this.persnr = persnr;
        this.nachname = nachname;
        this.vorname = vorname;
        this.gehalt = gehalt;
    }

    public Integer getPersnr() {
        return persnr;
    }

    public void setPersnr(Integer persnr) {
        this.persnr = persnr;
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

    public String getSozversnr() {
        return sozversnr;
    }

    public void setSozversnr(String sozversnr) {
        this.sozversnr = sozversnr;
    }

    public Date getGebdatum() {
        return gebdatum;
    }

    public void setGebdatum(Date gebdatum) {
        this.gebdatum = gebdatum;
    }

    public Short getFamstand() {
        return famstand;
    }

    public void setFamstand(Short famstand) {
        this.famstand = famstand;
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

    public String getMobil() {
        return mobil;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBlz() {
        return blz;
    }

    public void setBlz(String blz) {
        this.blz = blz;
    }

    public String getKtonr() {
        return ktonr;
    }

    public void setKtonr(String ktonr) {
        this.ktonr = ktonr;
    }

    public Date getEintritt() {
        return eintritt;
    }

    public void setEintritt(Date eintritt) {
        this.eintritt = eintritt;
    }

    public Date getAustritt() {
        return austritt;
    }

    public void setAustritt(Date austritt) {
        this.austritt = austritt;
    }

    public String getHinweis() {
        return hinweis;
    }

    public void setHinweis(String hinweis) {
        this.hinweis = hinweis;
    }

    public BigDecimal getGehalt() {
        return gehalt;
    }

    public void setGehalt(BigDecimal gehalt) {
        this.gehalt = gehalt;
    }

    public Abteilungen getAbtlg() {
        return abtlg;
    }

    public void setAbtlg(Abteilungen abtlg) {
        this.abtlg = abtlg;
    }

    public Anreden getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(Anreden geschlecht) {
        this.geschlecht = geschlecht;
    }

    @XmlTransient
    public Collection<Personal> getPersonalCollection() {
        return personalCollection;
    }

    public void setPersonalCollection(Collection<Personal> personalCollection) {
        this.personalCollection = personalCollection;
    }

    public Personal getVorgesetzter() {
        return vorgesetzter;
    }

    public void setVorgesetzter(Personal vorgesetzter) {
        this.vorgesetzter = vorgesetzter;
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
        hash += (persnr != null ? persnr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personal)) {
            return false;
        }
        Personal other = (Personal) object;
        if ((this.persnr == null && other.persnr != null) || (this.persnr != null && !this.persnr.equals(other.persnr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kasmi.wawi.model.Personal[ persnr=" + persnr + " ]";
    }
    
}
