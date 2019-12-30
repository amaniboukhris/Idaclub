package com.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.model.Session;
import com.model.User;
import com.model.commentaire;

@Repository
public class SessionService {

	@Autowired
	private MongoTemplate MongoTemplate;
	@Autowired
	private CommentaireService commService;
// lister les sessions

	public List<Session> getAllSession() {

		return MongoTemplate.findAll(Session.class);
	}

	public Session getById(long id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));

		return MongoTemplate.findOne(query, Session.class);

	}

	// AJOUTER UNE SESSION

	public Session addNewSession(Session session) {

		String titre = session.getTitre();
		Query query = new Query();
		query.addCriteria(Criteria.where("titre").is(session.getTitre()));

		Session fsession = MongoTemplate.findOne(query, Session.class);

		if (fsession != null) {
			System.out.println(" titre:" + titre + " est existe");

		} else
			MongoTemplate.save(session);
		return session;

	}

	public Session findOneByName(String titreS) {

		Query query = new Query();
		query.addCriteria(Criteria.where("titre").is(titreS));
		return MongoTemplate.findOne(query, Session.class);

	}

	public List<Session> findByName(String titreS) {
		Query query = new Query();
		query.addCriteria(Criteria.where("titre").is(titreS));
		return MongoTemplate.find(query, Session.class);

	}

	public Session updateOneSession(Session session) {
		MongoTemplate.save(session);
		return session;
	}

	public Object updateFirst(String titreS, long id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));
		Update update = new Update();
		update.set("titre", titreS);
		return MongoTemplate.updateFirst(query, update, Session.class);

	}

	public void deleteSession(Session session) {
		MongoTemplate.remove(session);

	}

	// AJOUTER OU MODIFIER UNE SESSION
	/****************************************/

	public Session save(Session ses) {

		if (ses.getId() == -1 || ses.getId() == 0) {
			List listSessions = getAllSession();
			int fin = listSessions.size();
			ses.setId(fin + 1);
			addNewSession(ses);
		} else {
			deleteById(ses.getId());
			addNewSession(ses);
		}
		return ses;
	}

	// Supprimer une UNE SESSION

	/**********************************************/

	public Session deleteById(long id) {

		Session sess = getById(id);
		if (sess == null) {
			return null;
		} else {
			deleteSession(sess);
			System.out.println("session " + id + "est suprimer");
			return sess;
		}

	}

	public Void addComment(int id, commentaire comment) {

		Update update = new Update();
		update.addToSet("comments", comment);
		Criteria criteria = Criteria.where("_id").is(id);
		MongoTemplate.updateFirst(Query.query(criteria), update, "session");
		return null;
	}

	Collection<commentaire> list = new ArrayList<commentaire>();

	

	public Session addcommtoSession(long idS, commentaire comm) {
System.out.println(comm.getIduser());
		Session ss = getById(idS);
		commentaire c = commService.save(comm);
		long idu = c.getId();
		list = ss.getCommentaires();
		boolean test = true;

		for (Iterator<commentaire> iterator = list.iterator(); iterator.hasNext();) {
			commentaire value = iterator.next();

			if (value.getId() == idu) {
				System.out.println(value.getId());
				test = false;
			}
		}
		if (test == true) {
			if(list.add(c)) {
				System.out.println(c.getEmail());
				ss.setCounter(list.size ()); 
			};
			
			MongoTemplate.save(ss);

		} else {
			System.out.println("existe");
		}

		return ss;

	}

	// Delet
	
	public Session deleteSessioncomment(long idS,long id) {
		Session s1 =getById(idS);
	
	      list= s1.getCommentaires();
	

		for (Iterator<commentaire> iterator = list.iterator(); iterator.hasNext(); ) {
			commentaire value = iterator.next();
		    if (value.getId()==id) {
		        iterator.remove();
				s1.setCounter(list.size()); 

		        

		    }
		    
		    
		}
		return MongoTemplate.save(s1);
		
		}
}
