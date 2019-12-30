package com.journaldev.bootifulmongodb.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
	@Transient
    public static final String SEQUENCE_NAME = "users_sequence";
	@Id 
	private long userId;
	private int CIN ;
	private String nom;
	private String prenom;
	private Date DateDeNaissance = new Date();
	private int age;
	private String statut;
	private String type;
    
	private String diplome;
    private String université;
    private String adresse;
    private List<Session> sessions;
    public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	

    

	public User(int cIN, String nom, String prenom, Date dateDeNaissance, int age, String statut, String type,
			String diplome, String université, String adresse, List<Session> sessions) {
		super();
		CIN = cIN;
		this.nom = nom;
		this.prenom = prenom;
		DateDeNaissance = dateDeNaissance;
		this.age = age;
		this.statut = statut;
		this.type = type;
		this.diplome = diplome;
		this.université = université;
		this.adresse = adresse;
		this.sessions = sessions;
	}



	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public int getCIN() {
		return CIN;
	}
	public void setCIN(int cIN) {
		CIN = cIN;
	}
	public  String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateDeNaissance() {
		return DateDeNaissance;
	}
	public void setDateDeNaissance(Date dateDeNaissance) {
		DateDeNaissance = dateDeNaissance;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getType() {
		return type;
	}
   public void setType(String type) {
		this.type = type;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}
	public String getDiplome() {
		return diplome;
	}
	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}
	public String getUniversité() {
		return université;
	}
	public void setUniversité(String université) {
		this.université = université;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	
}
