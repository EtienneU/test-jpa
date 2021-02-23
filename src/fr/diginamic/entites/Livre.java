package fr.diginamic.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="livre")
public class Livre {

	@Id
	private Integer id;
	
	@Column(name = "TITRE")
	private String titre;
	
	@Column(name = "AUTEUR")
	private String auteur;
	
	public Livre() {
		
	}

	@Override
	public String toString() {
		return titre.toUpperCase() + " (id = " + id + "), auteur : " + auteur;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	
}
