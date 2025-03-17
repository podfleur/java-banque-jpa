package fr.epsi.entities;

import jakarta.persistence.*;


@Entity
class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String numero;
    private String rue;
    private String codePostal;
    private String ville;

    @OneToOne(mappedBy = "adresse")
    private Client client;
}
