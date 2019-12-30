package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Repository.CommentaireRepository;
import com.Service.CommentaireService;
import com.model.Session;
import com.model.User;
import com.model.commentaire;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CommentaireController {
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	@Autowired
	private CommentaireService comService;
	@Autowired
	private CommentaireRepository commentRepository;

	@RequestMapping(value = "commentaire/all", method = RequestMethod.GET)
	public List<commentaire> getAllcomment(commentaire comment) {
		LOG.info("Getting all comment.");
		return commentRepository.findAll();
	}

	@PutMapping(value = "/commentaire/{id}")
	public ResponseEntity<commentaire> updateTodo(@RequestBody commentaire comm, @PathVariable long id) {

		commentaire c = comService.save(comm);

		return new ResponseEntity<commentaire>(comm, HttpStatus.OK);
	}

	@RequestMapping(value = "/commentaire", method = RequestMethod.POST)
	public commentaire add(@RequestBody commentaire comment) {

		LOG.info("saving comment");

		return comService.addcomment(comment);

	}

	@DeleteMapping("commentaire/{id}")
	public ResponseEntity<Void> deleteComment(@PathVariable long id) {
		commentaire comment = comService.deleteComm(id);
		if (comment != null) {
			return ResponseEntity.noContent().build();

		}
		return ResponseEntity.notFound().build();
	}

}
