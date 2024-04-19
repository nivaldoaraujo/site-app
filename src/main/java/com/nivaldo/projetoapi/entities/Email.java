package com.nivaldo.projetoapi.entities;

import java.time.LocalDateTime;

import com.nivaldo.projetoapi.enums.StatusEmail;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Email {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long emailId;
	private String emailFrom;
	private String emailTo;
	private String tituloEmail;
	@Column(columnDefinition="TEXT")
	private String corpoEmail;
	private LocalDateTime sendDateEmail;
	private StatusEmail statusEmail;
	
	public Email () {}

	public Email(Long emailId, String emailFrom, String emailTo, String tituloEmail, String corpoEmail,
			LocalDateTime sendDateEmail, StatusEmail statusEmail) {
		super();
		this.emailId = emailId;
		this.emailFrom = emailFrom;
		this.emailTo = emailTo;
		this.tituloEmail = tituloEmail;
		this.corpoEmail = corpoEmail;
		this.sendDateEmail = sendDateEmail;
		this.statusEmail = statusEmail;
	}

	public Long getEmailId() {
		return emailId;
	}

	public void setEmailId(Long emailId) {
		this.emailId = emailId;
	}

	public String getEmailFrom() {
		return emailFrom;
	}

	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}

	public String getEmailTo() {
		return emailTo;
	}

	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}

	public String getTituloEmail() {
		return tituloEmail;
	}

	public void setTituloEmail(String tituloEmail) {
		this.tituloEmail = tituloEmail;
	}

	public String getCorpoEmail() {
		return corpoEmail;
	}

	public void setCorpoEmail(String corpoEmail) {
		this.corpoEmail = corpoEmail;
	}

	public LocalDateTime getSendDateEmail() {
		return sendDateEmail;
	}

	public void setSendDateEmail(LocalDateTime sendDateEmail) {
		this.sendDateEmail = sendDateEmail;
	}

	public StatusEmail getStatusEmail() {
		return statusEmail;
	}

	public void setStatusEmail(StatusEmail statusEmail) {
		this.statusEmail = statusEmail;
	}
	
	
}
