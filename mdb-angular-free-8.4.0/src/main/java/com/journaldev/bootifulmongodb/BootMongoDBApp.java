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
public class BootMongoDBApp implements CommandLineRunner {
	@Autowired
	private  UserController usercontroller;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private  SessionController sessioncontroller;
	
	@Autowired
	private  SessionRepository sessionRepository  ;
	
	public static void main(String[] args) {
		SpringApplication.run(BootMongoDBApp.class, args);
	 
	  
	
	}
	@Override
	public void run(String... args) throws Exception {

        	 
  User us = new User( 0233, "bahri", "Nermine", new Date(), 30, "ing", "m","m","m","",null)	;	
   userRepository.save(us);
   userRepository.save(new User( 022523, "bahri", "nidhal", new Date(), 30, "ing", "m","m","zz","zz",null));  				
 ////////////
   Session S= new Session("janvier", "java", 30, 8, "programme", 50,null);
   Session S1= new Session("septembre", "php", 30, 8, "programme", 50,null);
   Session S2= new Session("octobre", "oracle", 30, 8, "programme", 50,null);
   sessionRepository.save(S);
   sessionRepository.save(S1);
   sessionRepository.save(S2);
	

		 
	
	}

	
}