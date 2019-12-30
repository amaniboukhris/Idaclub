package com.journaldev.bootifulmongodb.dal;

import java.util.List;

import com.journaldev.bootifulmongodb.model.User;

public interface UserDAL {

	List<User> getAllUser();

	User getUserById(String userId);
	
	User addNewUser(User user);

	 User findOneByName(String nom);
	
	 List<User> findByName(String nom);
	     
	
	 
	 Object update(String nom ,int CIN);
	 
	 Object findAndModify(String name );
	 
	  void deletePerson(User user);



}