package fr.epsi.entities;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("VIREMENT")
class Virement extends Operation {
    private String beneficiaire;
}
