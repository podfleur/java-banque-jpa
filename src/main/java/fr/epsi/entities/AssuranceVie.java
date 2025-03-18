package fr.epsi.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class AssuranceVie extends Compte {
    private Date dateFin;
    private double taux;

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
}