package project;

import java.io.Serializable;

public class Mensagem {

	private static final long serialVersionUID = 1L;
	private Tipo tipo;
	private Long id;
	private String text;
	private String sender;
	private String subject=null;
	private String date;

	public Mensagem(Tipo tipo) {
		this.tipo = tipo;

	}

	@Override
	public String toString() {
		if(tipo.equals(Tipo.TWITTER))
			return sender + " " + date + ": " + text;
		if(tipo.equals(Tipo.MAIL))
			return text;
		if(tipo.equals(Tipo.FACE))
			return text;

		return " [tipo=" + tipo + ", text=" + text + ", sender=" + sender + ", subject=" + subject
				+ "]";
	}

	public Mensagem(Tipo tipo, Long id, String text, String sender, String date) {
		super();
		this.tipo = tipo;
		this.id = id;
		this.text = text;
		this.sender = sender;
		this.date = date;
	}

	public String getText() {
		return text;
	}


	public String getSender() {
		return sender;
	}

	public Tipo getTipo() {
		return tipo;
	}


	public String getSubject() {
		return subject;
	}


	public String getDate() {
		return date;
	}

	public Long getId() {
		return id;
	}


	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public void setId(Long id) {
		this.id=id;
	}


	public void setText(String text) {
		this.text = text;
	}


	public void setSender(String sender) {
		this.sender = sender;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public enum Tipo{
		FACE, TWITTER, MAIL
	}




}
