package com.journaldev.bootifulmongodb.dal;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;


import com.journaldev.bootifulmongodb.model.User;
import genrateSequence.GenrateSequence;



@Repository
public class UserDALImpl implements UserDAL {
	private GenrateSequence genrateSequence;
	
	@Autowired
	private  MongoTemplate mongoTemplate;

	@Override
	public List<User> getAllUser() {
		return mongoTemplate.findAll(User.class);
	}

	@Override
	public User getUserById(String userId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(userId));
		
		return mongoTemplate.findOne(query, User.class);
	}
	
	@Override
	public User addNewUser(User user) {
		
		user.setUserId(genrateSequence.generateSequence(User.SEQUENCE_NAME));
		
		mongoTemplate.save(user);
		
		return user;
	}
	

	@Override
	 public User findOneByName(String nom) {
		 
		 Query query = new Query();
		   query.addCriteria(Criteria.where("nom").is(nom));
		   return mongoTemplate.findOne(query, User.class);

		 
	 }
	@Override
	 public List<User> findByName(String nom){
		  Query query = new Query();
		   query.addCriteria(Criteria.where("nom").is(nom));
		   return mongoTemplate.find(query, User.class);
	}
	
		

	
	@Override
	public Object update(String nom ,int CIN) {
		Query query = new Query();
		query.addCriteria(Criteria.where("CIN").is(CIN));
		Update update = new Update();
		update.set("nom", nom);
		return  mongoTemplate.updateFirst(query,update, User.class);
	}
		

		@Override
		public Object findAndModify(String name ) {
			Query query = new Query();
			query.addCriteria(Criteria.where("nom").is(name));
			Update update = new Update();
			update.set("nom", name);
			return  mongoTemplate.findAndModify(query,update, User.class);
			
			
		
	}
		
		

		
		
		
	@Override
	public void deletePerson(User user) {
	   mongoTemplate.remove(user);

	
}
} 