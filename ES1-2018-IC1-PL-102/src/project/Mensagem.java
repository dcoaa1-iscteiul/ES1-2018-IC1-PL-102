/*
 * Classe utilizada para tratamento das mensagens e posts recebidos das plataformas.
 */
package project;

/**
 * @author BRUNO
 *
 */
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

	/**
	 * @param tipo
	 * @param id
	 * @param text
	 * @param sender
	 * @param date
	 * Construtor da mensagem.
	 */
	public Mensagem(Tipo tipo, Long id, String text, String sender, String date) {
		super();
		this.tipo = tipo;
		this.id = id;
		this.text = text;
		this.sender = sender;
		this.date = date;
	}

	/**
	 * @return
	 * Devolve o texto obtido.
	 */
	public String getText() {
		return text;
	}


	/**
	 * @return
	 * Devolve o sender.
	 */
	public String getSender() {
		return sender;
	}

	/**
	 * @return
	 * Devolve o tipo de mensagem.
	 */
	public Tipo getTipo() {
		return tipo;
	}


	/**
	 * @return
	 * Devolve o assunto 
	 */
	public String getSubject() {
		return subject;
	}


	/**
	 * @return
	 * Devolve a data da mensagem.
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @return
	 * Devolve o id da mensagem.
	 */
	public Long getId() {
		return id;
	}


	/**
	 * @param tipo
	 * Função para definir o tipo.
	 */
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	/**
	 * @param id
	 * Função para definir o id.
	 */
	public void setId(Long id) {
		this.id=id;
	}


	/**
	 * @param text
	 * Função para definir o text.
	 */
	public void setText(String text) {
		this.text = text;
	}


	/**
	 * @param sender
	 * Função para definir o sender.
	 */
	public void setSender(String sender) {
		this.sender = sender;
	}

	/**
	 * @param subject
	 * Função para definir o subject.
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @param date
	 * Função para definir o date.
	 */
	public void setDate(String date) {
		this.date = date;
	}

	public enum Tipo{
		FACE, TWITTER, MAIL
	}




}
