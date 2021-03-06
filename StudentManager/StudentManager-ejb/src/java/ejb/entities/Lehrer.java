package ejb.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author ralph
 */
@Entity
public class Lehrer implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Basic
    private String Vorname;

    @Basic
    private String Nachname;

    @Basic
    @Temporal(TemporalType.DATE)
    private Date Geburtsdatum;

    @OneToOne
    private LogIns logIn;

    @OneToMany(mappedBy = "lehrer")
    private List<Kurse> kurs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVorname() {
        return Vorname;
    }

    public void setVorname(String Vorname) {
        this.Vorname = Vorname;
    }

    public String getNachname() {
        return Nachname;
    }

    public void setNachname(String Nachname) {
        this.Nachname = Nachname;
    }

    public Date getGeburtsdatum() {
        return Geburtsdatum;
    }

    public void setGeburtsdatum(Date Geburtsdatum) {
        this.Geburtsdatum = Geburtsdatum;
    }

    public LogIns getLogIn() {
        return logIn;
    }

    public void setLogIn(LogIns logIn) {
        this.logIn = logIn;
    }

    public List<Kurse> getKurs() {
        if (kurs == null) {
            kurs = new ArrayList<>();
        }
        return kurs;
    }

    public void setKurs(List<Kurse> kurs) {
        this.kurs = kurs;
    }

    public void addKur(Kurse kur) {
        getKurs().add(kur);
        kur.setLehrer(this);
    }

    public void removeKur(Kurse kur) {
        getKurs().remove(kur);
        kur.setLehrer(null);
    }

}