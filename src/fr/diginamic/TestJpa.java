package fr.diginamic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.entites.Livre;

public class TestJpa {

	public static void main(String[] args) {

		// Creation de l'entity Manager à partir du peristence unit "pu_essai" de mon
		// fichier persistence.xml
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_essai");
		EntityManager em = emf.createEntityManager();

		Livre livre = em.find(Livre.class, 2);
		if (livre != null) {
			System.out.println(livre);
		}

		TypedQuery<Livre> query1 = em.createQuery("select l from Livre l ", Livre.class);

		List<Livre> resultLivre = query1.getResultList();
		
		int n = 1;
		for (Livre l : resultLivre) {
			System.out.println(n++ + ") " +l);
		}
		
	}

}
