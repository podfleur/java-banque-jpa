package fr.epsi;

import fr.epsi.entities.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

public class ConnexionBanqueJpa {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPABanque");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Client client1 = new Client();
        client1.setNom("Dupont");
        client1.setPrenom("Jean");

        Client client2 = new Client();
        client2.setNom("Durand");
        client2.setPrenom("Marie");

        Compte compte1 = new LivretA();
        compte1.setNumero("12345");
        compte1.setSolde(5000);
        ((LivretA) compte1).setTaux(1.2);

        compte1.getClients().add(client1);
        compte1.getClients().add(client2);
        client1.getComptes().add(compte1);
        client2.getComptes().add(compte1);

        em.persist(client1);
        em.persist(client2);
        em.persist(compte1);

        Client client3 = new Client();
        client3.setNom("Martin");
        client3.setPrenom("Paul");

        AssuranceVie assuranceVie = new AssuranceVie();
        assuranceVie.setNumero("67890");
        assuranceVie.setSolde(8000);
        assuranceVie.setTaux(2.5);
        assuranceVie.setDateFin(new Date());

        LivretA livretA = new LivretA();
        livretA.setNumero("54321");
        livretA.setSolde(2000);
        livretA.setTaux(0.8);

        client3.getComptes().add(assuranceVie);
        client3.getComptes().add(livretA);
        assuranceVie.getClients().add(client3);
        livretA.getClients().add(client3);

        em.persist(client3);
        em.persist(assuranceVie);
        em.persist(livretA);

        Virement virement = new Virement();
        virement.setMontant(100);
        virement.setMotif("Remboursement prêt");
        virement.setDate(LocalDateTime.now());
        virement.setCompte(compte1);
        virement.setBeneficiaire("Jean Dupont");

        Operation operation = new Operation();
        operation.setMontant(50);
        operation.setMotif("Paiement facture");
        operation.setDate(LocalDateTime.now());
        operation.setCompte(compte1);

        em.persist(virement);
        em.persist(operation);

        tx.commit();
        em.close();
        emf.close();
    }
}