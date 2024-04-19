package com.nivaldo.projetoapi.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.nivaldo.projetoapi.entities.Email;
import com.nivaldo.projetoapi.enums.StatusEmail;
import com.nivaldo.projetoapi.repositories.EmailRepository;

@Service
public class EmailService {

	@Autowired
	private EmailRepository repository;
	
	@Autowired
	private JavaMailSender emailSender;
	
	public Email enviarEmail(Email email) {
		email.setSendDateEmail(LocalDateTime.now());
		
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(email.getEmailFrom());
			message.setTo(email.getEmailTo());
			message.setSubject(email.getTituloEmail());
			message.setText(email.getCorpoEmail());
			emailSender.send(message);
			
			email.setStatusEmail(StatusEmail.ENVIADO);
		} catch(MailException ex) {
			email.setStatusEmail(StatusEmail.ERRO);
		} finally {
			return repository.save(email);
		}
	}
}
