package com;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;


import com.Repository.SessionRepository;
import com.Repository.UserRepository;
import com.Service.SessionService;
import com.Service.UserService;
import com.controller.SessionController;
import com.controller.UserController;
import com.model.Session;
import com.model.User;

@Configuration
@SpringBootApplication
public class IdaClubApplication implements CommandLineRunner {

	
		 
		@Autowired
		private  UserController usercontroller;
		@Autowired
		private SessionService sessionS;
		@Autowired
		private UserService userS;
		@Autowired
		private  SessionController sessionC;
		@Autowired
		private UserRepository userRep;
		@Autowired
		private SessionRepository sessionRep;
		
	
		
	public static void main(String[] args) {
		SpringApplication.run(IdaClubApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {
		
	

	      /* sessionRep.deleteAll();
		   Session S1= new Session("Session Janvier", "PHP", 10, 20, "programme 1", 300,new ArrayList<>());
		   sessionC .addNewSession(S1);
	
		   
         
		   Session S2= new Session("Session fevrier", "oracle", 20, 30, "programme 2", 400,new ArrayList<>());
         sessionC .addNewSession(S2);
       
         
         Session S3= new Session("Session Mars", "Angular", 30, 40, "programme 3", 600,new ArrayList<>());
         sessionC .addNewSession(S3);*/
       
		
		
		
         /*userRep.deleteAll();
			User us1 = new User(84025802, "ovvvvbb", "Ahmed", new Date(), "ah@gmail.com", "statut", "type","jouini", "diplome"," universite", "adresse",new ArrayList<>());
			User us2 = new User(88021425, "mrad", "Nermine", new Date(), "mail", "statut", "type","mrad", "diplome"," universite", "adresse",new ArrayList<>());
			User us3= new User(00211477, "zami125", "Nermine", new Date(), "mail", "statut", "type","zami", "diplome"," universite", "adresse",new ArrayList<>());
			User us4= new User(00211477, "bahri14", "Nermine", new Date(), "mail", "statut", "type","zami", "diplome"," universite", "adresse",new ArrayList<>());
			
			usercontroller.addNewUsers(us1);
			usercontroller.addNewUsers(us2);
			usercontroller.addNewUsers(us3);
			usercontroller.addNewUsers(us4);
			
			
			S1.getUsers().add(us1);
	           sessionRep.save(S1);
	           S2.getUsers().add(us2);
	           sessionRep.save(S2);
	           S3.getUsers().add(us3);
	           sessionRep.save(S3);



		   us2.getSessions().add(S2);
	         userRep.save(us2); 
	  	   us1.getSessions().add(S1);
	         userRep.save(us1);
	         us1.getSessions().add(S2);
	         userRep.save(us1);
	         us3.getSessions().add(S3);
	         userRep.save(us3);
	                 
	    
	         userS.deleteSessionUser(1, 2);
	        
	         userS.addSessionUser(1,3); */
		
		
	}

}
