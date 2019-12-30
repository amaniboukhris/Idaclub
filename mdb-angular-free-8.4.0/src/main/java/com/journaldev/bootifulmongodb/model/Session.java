package com.journaldev.bootifulmongodb.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Session {

	@Id
	private long id;
	private String titre;
	private String formation;
	private int nbreHeures;
	private int effectif;
	private String programme;
	private int prix;
	
	private List<User> users;

	
	public Session() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Session(String titre, String formation, int nbreHeures, int effectif, String programme, int prix,
			List<User> users) {
		super();
		this.titre = titre;
		this.formation = formation;
		this.nbreHeures = nbreHeures;
		this.effectif = effectif;
		this.programme = programme;
		this.prix = prix;
		this.users = users;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getFormation() {
		return formation;
	}

	public void setFormation(String formation) {
		this.formation = formation;
	}

	public int getNbreHeures() {
		return nbreHeures;
	}

	public void setNbreHeures(int nbreHeures) {
		this.nbreHeures = nbreHeures;
	}

	public int getEffectif() {
		return effectif;
	}

	public void setEffectif(int effectif) {
		this.effectif = effectif;
	}

	public String getProgramme() {
		return programme;
	}

	public void setProgramme(String programme) {
		this.programme = programme;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	

}
