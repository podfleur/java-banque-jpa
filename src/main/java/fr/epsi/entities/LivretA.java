package fr.epsi.entities;

import jakarta.persistence.*;

@Entity
public class LivretA extends Compte {
    private double taux;

    public double getTaux() {
        return taux;
    }
    public void setTaux(double taux) {
        this.taux = taux;
    }
}

