package fr.epsi;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnexionBanqueJpa {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPABanque");
        emf.close();
    }
}