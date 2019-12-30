package com.Service;

import java.security.SecureRandom;
import java.text.NumberFormat;
import java.util.Random;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.model.User;

@Service
public class MailService {

	private JavaMailSender javaMailSender;
	  private static volatile SecureRandom numberGenerator = null;
	   private static final long MSB = 0x8000000000000000L;
	public MailService(JavaMailSender javaMailSender) {
		super();
		this.javaMailSender = javaMailSender;
	}


	public void sendEmail(User user) throws MailException {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getMail());
		mail.setSubject("email adresse confirmation ");
		System.out.println("gggggggg"+user.getCodeConfirmation());
		mail.setText(user.getCodeConfirmation());
		javaMailSender.send(mail);
	}
	

}
