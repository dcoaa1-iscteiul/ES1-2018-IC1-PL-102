package send;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Mensagem implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String text;
	private String sender;
	private String reciver;
	private Action acao;
	private Set<String> userOnline = new HashSet<String>();
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReciver() {
		return reciver;
	}

	public void setReciver(String reciver) {
		this.reciver = reciver;
	}

	public Action getAcao() {
		return acao;
	}

	public void setAcao(Action acao) {
		this.acao = acao;
	}

	public Set<String> getUserOnline() {
		return userOnline;
	}

	public void setUserOnline(Set<String> userOnline) {
		this.userOnline = userOnline;
	}

	public enum Action{
		CONNECT, DISCONNECT, SEND_MESSAGE, UPDATE, STATE
	}
}