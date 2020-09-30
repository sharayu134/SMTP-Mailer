package com.sash.helloworldspringcourseone.controllers;


import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sash.helloworldspringcourseone.mail.MailSender;

@RestController
public class MailController {

	
	private MailSender mailSender;
	@RequestMapping("/mail")
	public String hello() throws MessagingException {
		mailSender.send("ysharayu81@gmail.com","test mail","body of mail");
		return "mail sent";
	}
	
	@Autowired
	public void setMailSender(MailSender smtp) {
		this.mailSender = smtp;
	}
}