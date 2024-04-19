package com.nivaldo.projetoapi.dtos;

public class EmailDTO {

	private String emailFrom;
	private String emailTo;
	private String tituloEmail;
	private String corpoEmail;
	
	public EmailDTO() {}
	
	public EmailDTO(String emailFrom, String emailTo, String tituloEmail, String corpoEmail) {
		super();
		this.emailFrom = emailFrom;
		this.emailTo = emailTo;
		this.tituloEmail = tituloEmail;
		this.corpoEmail = corpoEmail;
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
	
	
}
