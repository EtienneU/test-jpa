/**
 * 
 */
package fr.diginamic.biblio.entites;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 * @author Etienne URBANO
 *
 */
@Entity
@Table(name="EMPRUNT")
public class Emprunt {
	
	@Id
	@Column(name="ID")
	private Integer id;
	
	//@Temporal
	@Column(name="DATE_DEBUT")
	private Date dateDebut;
	
	//@Temporal
	@Column(name="DATE_FIN")
	private Date dateFin;
	
	@Column(name="DELAI")
	private Integer delai;
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Client client;
	
	@ManyToMany
	@JoinTable(name="COMPO",
		joinColumns=@JoinColumn(name="ID_EMP", referencedColumnName="ID"),
		inverseJoinColumns=@JoinColumn(name="ID_LIV", referencedColumnName="ID"))
	private Set <Livre> livres;

	public Emprunt() {
	}

	@Override
	public String toString() {
		return " - Emprunt id=" + id + " --> dateDebut: " + dateDebut + ", dateFin: " + dateFin 
				+ ", delai: " + delai
				+ ", \n   client: " + client + ", \n   livres:" + livres + "\n";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Integer getDelai() {
		return delai;
	}

	public void setDelai(Integer delai) {
		this.delai = delai;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Set<Livre> getLivres() {
		return livres;
	}

	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}

}
