package com.sash.helloworldspringcourseone.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class SmtpMailSender2 implements MailSender {

	private static Log log= LogFactory.getLog(SmtpMailSender2.class);
	
	private JavaMailSender javaMailSender;
	
	public SmtpMailSender2(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@Override
	public void send(String to, String subject, String body) throws MessagingException{
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper;
		
		helper= new MimeMessageHelper(message,true);
		
		helper.setSubject(subject);
		helper.setTo(to);
		helper.setText(body,true);
		javaMailSender.send(message);
		// TODO Auto-generated method stub
//		log.info("sending smtp mail");
//		log.info("with sun "+ subject);
//		log.info(" and body "+body);
	}

}
