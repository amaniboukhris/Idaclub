package com.journaldev.bootifulmongodb.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.journaldev.bootifulmongodb.dal.SessionDAL;
import com.journaldev.bootifulmongodb.dal.SessionRepository;


import com.journaldev.bootifulmongodb.model.Session;


@RestController
@RequestMapping(value = "/sessions")
public class SessionController {
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	@Autowired
	private  SessionRepository sessionRepository;
	@Autowired
	private SessionDAL sessionDAL;

	public SessionController(SessionRepository sessionRepository, SessionDAL sessionDAL) {
		this.sessionRepository = sessionRepository;
		this.sessionDAL = sessionDAL;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Session addNewSession(@RequestBody Session session) {
		LOG.info("Saving session.");
		return sessionRepository.save(session);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Session> getAllSession(Session session) {
		LOG.info("Getting all Session.");
		return sessionRepository.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public  Session getUserById(@PathVariable Long id) {
		LOG.info("Getting user with ID: {}.", id);
		return sessionRepository.findOne(id);
	}

	

}
