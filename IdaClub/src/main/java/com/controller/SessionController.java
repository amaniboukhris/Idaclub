package com.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Repository.SessionRepository;
import com.Service.SessionService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Response;
import com.model.Session;
import com.model.commentaire;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "")
public class SessionController {
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	@Autowired
	private SessionRepository sessionRepository;
	@Autowired
	private SessionService SessionS;
	@Autowired
	ServletContext context;

	public SessionController(SessionRepository sessionRepository) {
		this.sessionRepository = sessionRepository;

	}

	@PostMapping(value = "SaveSessionProfil")
	public ResponseEntity<Response> SaveSession(@RequestParam("files") MultipartFile file,
			@RequestParam("photo") String photo) throws JsonParseException, JsonMappingException, IOException {
		Session ss = new ObjectMapper().readValue(photo, Session.class);
		ss.setPhoto(file.getBytes());
		ss.setFileName(file.getOriginalFilename());

		Session S = SessionS.save(ss);
		if (S != null) {
			return new ResponseEntity<Response>(new Response(" user is saved successfully"), HttpStatus.OK);
		} else {

			return new ResponseEntity<Response>(new Response("user is  not saved"), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping(value = "SaveSessionServer")
	public ResponseEntity<Response> SaveSessionServer(@RequestParam("files") MultipartFile file,
			@RequestParam("photo") String photo) throws JsonParseException, JsonMappingException, IOException {
		Session ss = new ObjectMapper().readValue(photo, Session.class);
		boolean isExist = new File(context.getRealPath("/sessionprofile/")).exists();

		if (!isExist) {
			new File(context.getRealPath("/sessionprofile/")).mkdir();

		}
		String filename = file.getOriginalFilename();
		String modifierfilename = ss.getId() + "." + FilenameUtils.getExtension(filename);
		File serverFile = new File(context.getRealPath("/sessionprofile/" + File.separator + modifierfilename));
		try {
			FileUtils.writeByteArrayToFile(serverFile, file.getBytes());

		} catch (Exception e) {
			e.printStackTrace();
		}
		ss.setFileName(modifierfilename);

		Session S = SessionS.save(ss);
		if (S != null) {
			return new ResponseEntity<Response>(new Response(" user is saved successfully"), HttpStatus.OK);
		} else {

			return new ResponseEntity<Response>(new Response("user is  not saved"), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/imageSession", method = RequestMethod.GET)
	public ResponseEntity<List<String>> getImage() {
		List<String> images = new ArrayList<String>();
		String filesPath = context.getRealPath("/sessionprofile");
		File fileFolder = new File(filesPath);
		if (fileFolder != null) {
			for (final File file : fileFolder.listFiles()) {
				if (!file.isDirectory()) {
					String encode = null;
					try {

						String extension = FilenameUtils.getExtension(file.getName());

						FileInputStream FileInputStream = new FileInputStream(file);
						byte[] bytes = new byte[(int) file.length()];
						FileInputStream.read(bytes);
						encode = Base64.getEncoder().encodeToString(bytes);
						images.add("data:image/" + extension + ";base64," + encode);
						FileInputStream.close();
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		}
		return new ResponseEntity<List<String>>(images, HttpStatus.OK);
	}

	// Find All Session

	@RequestMapping(value = "/sessions/all", method = RequestMethod.GET)
	public List<Session> getSession(Session session) {
		LOG.info("Getting all Session.");
		return sessionRepository.findAll();
	}

	// Find Session by id

	@RequestMapping(value = "/sessions/{id}", method = RequestMethod.GET)
	public Session getAllSession(@PathVariable long id) {
		LOG.info("Getting all Session.");
		return SessionS.getById(id);
	}

	/// DELETE /user/{username}/todos/{id}

	@DeleteMapping("/sessions/{id}")
	public ResponseEntity<Void> deleteSession(@PathVariable long id) {
		Session ses = SessionS.deleteById(id);
		if (ses != null) {
			return ResponseEntity.noContent().build();

		}
		return ResponseEntity.notFound().build();
	}

//Modifier Session avec methode PUT

	@PutMapping(value = "/sessions/{id}")
	public ResponseEntity<Session> updateSession(@RequestBody Session session, @PathVariable long id) {

		Session sessionUpdated = SessionS.save(session);

		return new ResponseEntity<Session>(session, HttpStatus.OK);
	}

// cree une session avec methode POST

	@PostMapping("/sessions")
	public ResponseEntity<Session> updateSession(@RequestBody Session session) {

		Session createdSession = SessionS.save(session);

		// Location
		// Get currnt ressource url
		// {id}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdSession.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@PostMapping("/sessions/{id}/comment")
	public ResponseEntity<Void> ajoutComment(@PathVariable int id, @RequestBody commentaire comment) {

		SessionS.addComment(id, comment);
		if (comment != null) {
			return ResponseEntity.noContent().build();

		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping("/sessions/{id}/newcomment")
	public ResponseEntity<Void> ajoutCommentsession(@PathVariable int id, @RequestBody commentaire newcomment) {

		SessionS.addcommtoSession(id, newcomment);

		if (newcomment != null) {
			return ResponseEntity.noContent().build();

		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/sessions/{idS}/commentaire/{id}")
	public ResponseEntity<Void> deleteSUser(@PathVariable long idS, @PathVariable long id) {
		Session s1 = SessionS.deleteSessioncomment(idS, id);
		if (s1 != null) {
			return ResponseEntity.noContent().build();

		}
		return ResponseEntity.notFound().build();

	}

}
