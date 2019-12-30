package com.journaldev.bootifulmongodb;


import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.journaldev.bootifulmongodb.controller.SessionController;
import com.journaldev.bootifulmongodb.controller.UserController;
import com.journaldev.bootifulmongodb.dal.SessionRepository;
import com.journaldev.bootifulmongodb.dal.UserRepository;
import com.journaldev.bootifulmongodb.model.Session;
import com.journaldev.bootifulmongodb.model.User;


@SpringBootApplication
public class idac implements CommandLineRunner {
	
	@Autowired
	private  UserController usercontroller;
	

	
	@Autowired
	private  SessionController sessioncontroller;
	
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(idac.class, args);
	 
	  
	
	}
	@Override
	public void run(String... args) throws Exception {

        	 
  User us = new User()	;	
  usercontroller.addNewUsers(us);
  
  User u1= new User( ); 
  usercontroller .addNewUsers(u1);
 			

   Session S= new Session();
   Session S1= new Session();
   Session S2= new Session();
   sessioncontroller .addNewSession(S);
   sessioncontroller .addNewSession(S1);
   sessioncontroller.addNewSession(S2);
	

		 
	
	}

	
}