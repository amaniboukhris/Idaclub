package com.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class commentaire {
	@Id
	private long id = 0;
	private String message;
	private Date date;
	private String email;
	@DBRef
	private Session session;
	@DBRef
	private User user;
	private static long idcourant = 0;
	private int iduser;
	public commentaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public commentaire(String message, Date date, String email, Session session, User user, int iduser) {
		super();
		this.id = ++idcourant;
		this.message = message;
		this.date = date;
		this.email = email;
		this.session = session;
		this.user = user;
		this.iduser = iduser;
	}



	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getIdcourant() {
		return idcourant;
	}

	public int getIduser() {
		return iduser;
	}

















	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

















	public static void setIdcourant(long idcourant) {
		commentaire.idcourant = idcourant;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		commentaire other = (commentaire) obj;
		if (id != other.id)
			return false;
		return true;
	}

}