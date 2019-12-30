package com.journaldev.bootifulmongodb.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.journaldev.bootifulmongodb.dal.UserDAL;
import com.journaldev.bootifulmongodb.dal.UserRepository;
import com.journaldev.bootifulmongodb.model.User;

@RestController
@RequestMapping(value ="/users")
public class UserController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());
	@Autowired
	private  UserRepository userRepository;
	@Autowired
	private  UserDAL userDAL;

	

	public UserController(UserRepository userRepository, UserDAL userDAL) {
		this.userRepository = userRepository;
		this.userDAL = userDAL;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public User addNewUsers(@RequestBody User user) {
		LOG.info("Saving user.");
		return userRepository.save(user);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<User> getAllUser(User user) {
		LOG.info("Getting all users.");
		return userRepository.findAll();
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public User getUserById(@PathVariable String userId) {
		LOG.info("Getting user with ID: {}.", userId);
		return userRepository.findOne(userId);
	}
	@RequestMapping(value = "/{nom}", method = RequestMethod.GET)
	 public User findOneByName(@PathVariable String nom) {
		
		LOG.info("Getting user with nom: {}.", nom);
		return userRepository.findOne(nom);
		
	}
	@RequestMapping(value = "/{nom}", method = RequestMethod.GET)
	 public List<User> findByName(String nom){
		LOG.info("Getting user with nom: {}.", nom);
		return userRepository.findAll();
	}
	@RequestMapping(value = "/{CIN}", method = RequestMethod.GET)
	public Object update(String nom , @PathVariable int CIN) {
		LOG.info("Getting user with nom: {}.", nom);
		return  userRepository.updateFirst(nom);
	}
}