package com.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document

public class User {

	@Id
	private long userId = 0;
	private String CIN;
	private String nom;
	private String prenom;
	private Date DateDeNaissance = new Date();
	private String mail;
	private String statut;
	private String type;
	private String mdp;

	private String diplome;
	private String universite;
	private String adresse;
	private byte[] photo;
	private String fileName;
	private String codeConfirmation;

	private static Integer idcourant = 0;

	@DBRef(lazy = true)
	private Collection<Session> Sessions = new ArrayList<>();

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	


	public User(long userId, String cIN, String nom, String prenom, Date dateDeNaissance, String mail, String statut,
			String type, String mdp, String diplome, String universite, String adresse, byte[] photo, String fileName,
			String codeConfirmation, Collection<Session> sessions) {
		super();
		this.userId = userId;
		CIN = cIN;
		this.nom = nom;
		this.prenom = prenom;
		DateDeNaissance = dateDeNaissance;
		this.mail = mail;
		this.statut = statut;
		this.type = type;
		this.mdp = mdp;
		this.diplome = diplome;
		this.universite = universite;
		this.adresse = adresse;
		this.photo = photo;
		this.fileName = fileName;
		this.codeConfirmation = codeConfirmation;
		Sessions = sessions;
	}




	public String getCodeConfirmation() {
		return codeConfirmation;
	}




	public void setCodeConfirmation(String codeConfirmation) {
		this.codeConfirmation = codeConfirmation;
	}




	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public long getUserId() {
		return userId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getCIN() {
		return CIN;
	}

	public void setCIN(String cIN) {
		CIN = cIN;
	}

	public String getNom() {
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
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

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getDiplome() {
		return diplome;
	}

	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}

	public String getUniversite() {
		return universite;
	}

	public void setUniversite(String universite) {
		this.universite = universite;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public static Integer getIdcourant() {
		return idcourant;
	}

	public static void setIdcourant(Integer idcourant) {
		User.idcourant = idcourant;
	}

	public Collection<Session> getSessions() {
		return Sessions;
	}

	public void setSessions(Collection<Session> sessions) {
		Sessions = sessions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (userId ^ (userId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userId != other.userId)
			return false;
		return true;
	}

}
