package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Service.MailService;

import com.model.User;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "")
public class RegistrationController {

	@Autowired
	private MailService notificationService;
	

	@RequestMapping(value = "/sendmail", method = RequestMethod.POST)
	public String send(@RequestBody User user ) {
		try {
			notificationService.sendEmail(user );
			
		} catch (MailException mailException) {
			System.out.println(mailException);
		}

		return "Congratulations! Your mail has been send to the user.";
	}

}
