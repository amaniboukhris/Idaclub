package com.journaldev.bootifulmongodb.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import com.journaldev.bootifulmongodb.model.Session;


@Repository
public class SessionDALImpl  implements SessionDAL {
	
	
	@Autowired
	private  MongoTemplate MongoTemplate;

	@Override
	public List<Session> getAllSession() {
		
		return MongoTemplate.findAll(Session.class);
	}

	@Override
	public Session getUserById(long id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("Id").is(id));
		
		return MongoTemplate.findOne(query, Session.class);
	}

	@Override
	public Session addNewSession(Session session) {
       MongoTemplate.save(session);
		
		return session;
	}

	@Override
	public Session findOneByName(String titreS) {

		 Query query = new Query();
		   query.addCriteria(Criteria.where("titre").is(titreS));
		   return MongoTemplate.findOne(query, Session.class);

		 
	}

	@Override
	public List<Session> findByName(String titreS) {
		Query query = new Query();
		   query.addCriteria(Criteria.where("titre").is(titreS));
		   return MongoTemplate.find(query, Session.class);

		 
	}

	@Override
	public Session updateOneSession(Session session) {
		MongoTemplate.save(session);
		   return session;
	}

	@Override
	public Object updateFirst(String titreS,long id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("ID").is(id));
		Update update = new Update();
		update.set("titre", titreS);
		return  MongoTemplate.updateFirst(query,update, Session.class);

	}

	@Override
	public void deleteSession(Session session) {
		MongoTemplate.remove(session);
		
	}

}
