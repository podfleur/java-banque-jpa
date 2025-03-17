package fr.epsi.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
class AssuranceVie extends Compte {
    private Date dateFin;
    private double taux;
}