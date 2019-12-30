package com.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Repository.UserRepository;
import com.Service.UserService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Response;
import com.model.User;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "")
public class UserController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());
	@Autowired
	private UserRepository UserRepository;
	@Autowired
	private UserService userService;
	@Autowired
	ServletContext context;

	public UserController(UserRepository UserRepository) {
		super();
		this.UserRepository = UserRepository;

	}
	
	
	
	@RequestMapping(value = "user/{email}", method = RequestMethod.GET)
	public User getUserByMail(@PathVariable String email) {
		LOG.info("Getting all users.");
		return userService.getUserByMail(email);
	}

	/// upload photo
	@PostMapping(value = "SaveUserProfil")
	public ResponseEntity<Response> SaveUserProfil(@RequestParam("file") MultipartFile file,
			@RequestParam("person") String person) throws JsonParseException, JsonMappingException, IOException {
		User user = new ObjectMapper().readValue(person, User.class);
		user.setPhoto(file.getBytes());
		user.setFileName(file.getOriginalFilename());

		User US = userService.save(user);
		if (US != null) {
			return new ResponseEntity<Response>(new Response(" user is saved successfully"), HttpStatus.OK);
		} else {

			return new ResponseEntity<Response>(new Response("user is  not saved"), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping(value="SaveUserProfilServer")
	public ResponseEntity<Response> SaveUserProfilServer(@RequestParam ("file")MultipartFile file,@RequestParam ("person") String person ) throws JsonParseException, JsonMappingException, IOException{
		User user =  new ObjectMapper().readValue(person, User.class);
		boolean isExist = new File(context.getRealPath("/userprofile/")).exists();
		
		if(!isExist) {
			new File(context.getRealPath("/userprofile/")).mkdir();
			
		}
		String filename = file.getOriginalFilename();
		String modifierfilename = user.getUserId()+"."+FilenameUtils.getExtension(filename);
	File serverFile = new File(context.getRealPath("/userprofile/"+File.separator+modifierfilename));
		try {
			FileUtils.writeByteArrayToFile(serverFile, file.getBytes());
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			user.setFileName(modifierfilename);
		
		User US = userService.save(user);
		if (US!=null) {
		return new ResponseEntity<Response>(new Response(" user is saved successfully"),HttpStatus.OK);
	}else {
		
		return new ResponseEntity<Response>(new Response("user is  not saved"),HttpStatus.BAD_REQUEST);
		}
	}
	@RequestMapping(value = "/getimage", method = RequestMethod.GET)
	public ResponseEntity<List<String>> getImage() {
		List<String> images = new ArrayList<String>();
		String filesPath = context.getRealPath("/userprofile");
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

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public User update(@RequestBody User user, @PathVariable int userId) {
		user.setUserId(userId);
		LOG.info("update user.");
		UserRepository.save(user);
		return user;
	}

	@RequestMapping(value = "/")
	public User updatebyCIN(@RequestBody User user, @PathVariable String nom) {
		user.setNom(nom);
		LOG.info("update user.");
		UserRepository.save(user);
		return user;
	}

	// getting all users

	@RequestMapping(value = "users/all", method = RequestMethod.GET)
	public List<User> getAllUser(User user) {
		LOG.info("Getting all users.");
		return UserRepository.findAll();
	}

	@RequestMapping(value = "users/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable long id) {
		LOG.info("Getting all users.");
		return userService.getUserById(id);
	}

	// supprimer user
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable long id) {
		User user = userService.deleteById(id);
		if (user != null) {
			return ResponseEntity.noContent().build();

		}
		return ResponseEntity.notFound().build();

	}

	// Modifier utlisateur

	@PutMapping(value = "/users/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable long id) {

		User userUpdated = userService.save(user);

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	// ajouter utilisteur

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public User addNewUsers(@RequestBody User user) {

		LOG.info("Saving user.");

		return userService.addUser(user);

	}
	// Delete session from Users

	@DeleteMapping("/users/{id}/Sessions/{ids}")
	public ResponseEntity<Void> deleteSUser(@PathVariable long id, @PathVariable long ids) {
		User us = userService.deleteSessionUser(id, ids);
		if (us != null) {
			return ResponseEntity.noContent().build();

		}
		return ResponseEntity.notFound().build();

	}

	@PostMapping("/users/{id}/Sessions/{ids}")
	public ResponseEntity<Void> ajoutSUser(@PathVariable long id, @PathVariable long ids) {
		User us = userService.addSessionUser(id, ids);
		if (us != null) {
			return ResponseEntity.noContent().build();

		}
		return ResponseEntity.notFound().build();

	}

}
