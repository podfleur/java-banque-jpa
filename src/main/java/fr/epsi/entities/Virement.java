package fr.epsi.entities;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("VIREMENT")
public class Virement extends Operation {
    private String beneficiaire;

    public String getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }
}
