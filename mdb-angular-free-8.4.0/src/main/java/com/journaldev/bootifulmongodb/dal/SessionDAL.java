package com.journaldev.bootifulmongodb.dal;

import java.util.List;

import com.journaldev.bootifulmongodb.model.Session;


public interface SessionDAL {
	
	List<Session> getAllSession();

	Session getUserById( long id);
	

	Session addNewSession(Session session);

	

	
	Session findOneByName(String titreS);
	
	 List<Session> findByName(String titreS);
	     
	 Session updateOneSession(Session session);
	 
	 Object updateFirst(String titreS,long id);
	 
	  void deleteSession(Session session);

	




}
