package fr.diginamic;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.entites.Client;
import fr.diginamic.entites.Emprunt;
import fr.diginamic.entites.Livre;

public class TestJpa {

	public static void main(String[] args) {

		// Creation de l'entity Manager à partir du peristence unit "pu_essai" de mon
		// fichier persistence.xml
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_essai");
		EntityManager em = emf.createEntityManager();

		// Récupération du livre dont l'id est passé en paramètre
		Livre livre = em.find(Livre.class, 2);
		if (livre != null) {
			System.out.println(livre + "\n");
		}

		// Récupération puis affichage des livres résultant da la requête
		TypedQuery<Livre> query1 = em.createQuery("select l from Livre l ", Livre.class);
		List<Livre> resultLivre = query1.getResultList();
		int n = 1;
		System.out.println("En DB, je dispose de " + resultLivre.size() + " livre(s) : ");
		for (Livre l : resultLivre) {
			System.out.println(n++ + ") " +l);
		}
		System.out.println("");
		
		// Récupération puis affichage de tous les emprunts
		TypedQuery<Emprunt> query2 = em.createQuery("select emprunt from Emprunt emprunt ", Emprunt.class);
		List<Emprunt> resultEmprunt = query2.getResultList();
		n = 1;
		System.out.println("La DB présente " + resultLivre.size() + " emprunt(s) enregistré(s): ");
		for (Emprunt emp : resultEmprunt) {
			System.out.println(n++ + ") " + emp);
		}
		
		// Récupération de tous les livres associés à un emprunt sélectionné
		Emprunt emprunt = em.find(Emprunt.class, 2);
		System.out.println("Livre(s) associé(s) à l'emprunt dont l'id est 2 :");
		for (Livre livreAssocies : emprunt.getLivres()) {
			System.out.println(livreAssocies);
		}
		
		// Récupération de tous les emprunts d'une client donné
		Scanner sc = new Scanner(System.in);
	    int i = 0;
	    while (i < 1 || i > 3) {
	    	System.out.println("\nSaisir l'id d'un Client : ");
    		i = sc.nextInt();
	    }
		Client client = em.find(Client.class, i);
		System.out.println("Emprunt(s) du " + client + " : ");
		for (Emprunt emp : client.getEmprunts()) {
			System.out.println(emp);
		}

	}

}
