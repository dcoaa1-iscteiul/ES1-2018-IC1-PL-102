package project;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.jsoup.Jsoup;

public class EmailMain {

	public static List<String> info = new ArrayList<String>();
	public static Folder emailFolder;
	public static String username;
	public static String password;

	public static void getMail(String pop3Host, String storeType, String user,
			String password) {
		try {
			info.clear();
			// create properties field
			Properties properties = new Properties();
			properties.put("mail.store.protocol", "pop3");
			properties.put("mail.pop3.host", pop3Host);
			properties.put("mail.pop3.port", "995");
			properties.put("mail.pop3.starttls.enable", "true");
			Session emailSession = Session.getDefaultInstance(properties);
			// emailSession.setDebug(true);
			
			

			// create the POP3 store object and connect with the pop server
			Store store = emailSession.getStore("pop3s");

			store.connect(pop3Host, user, password);
			
			//create the folder object and open it
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);
			
			// retrieve the messages from the folder in an array and print it
			Message[] messages = emailFolder.getMessages();
			//System.out.println("messages.length---" + messages.length);



			//verificar tipo de mensagem e transforma-la de mimemultipart para text
			for (int i = 0, n = 10; i < n; i++) {
				Message message = messages[i];

				if (message.isMimeType("text/plain")){
					message.getContent().toString();
				}

				if (message.isMimeType("multipart/*")) {
					String result = "";
					MimeMultipart mimeMultipart = (MimeMultipart)message.getContent();
					int count = mimeMultipart.getCount();
					for (int j = 0; j < count; j ++){
						BodyPart bodyPart = mimeMultipart.getBodyPart(j);
						if (bodyPart.isMimeType("text/plain")){
							result = result + "\n" + bodyPart.getContent();
							if(result.contains(EmailFrame.textField.getText()) || message.getFrom().toString().contains(EmailFrame.textField.getText())
									|| message.getSubject().contains(EmailFrame.textField.getText())) {
								info.add(message.getSubject() + " " + message.getFrom()[0] + " " + result);
								//info.add(message.getSubject() + " " + message.getFrom()[0] + " " + result);

								break;  //aparecem mensagens duplicadas sem o break
							} else if (bodyPart.isMimeType("text/html")){
								String html = (String) bodyPart.getContent();
								result = result + "\n" + Jsoup.parse(html).text();
								info.add(message.getSubject() + " " + message.getFrom()[0] + " " + result);

							}
							//System.out.println("---------------------------------");
							//System.out.println("Email Number " + (i + 1));
							//System.out.println("Subject: " + message.getSubject());
							//System.out.println("From: " + message.getFrom()[0]);
							//System.out.println("Text: " + message.getContent().toString());
							//info.add(message.getSubject() + " " + message.getFrom()[0]);
							//info.add(message.getSentDate().toString());
							//info.add(message.getContent().toString());
							//System.out.println(info + "LISTA AQUI");

						}
					}

				}
			}


			//fechar tudo, store e objetos
			EmailFrame.info2JList();
			emailFolder.close(false);
			store.close();

		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	public static void authenticate() {

		String host = "outlook.office365.com";// change accordingly
		String mailStoreType = "pop3";
		username = "faons@iscte-iul.pt";// change accordingly
		password = "Kironaxe32!!";// change accordingly
		getMail(host, mailStoreType, username, password);
	}
	
	public static void enviarMail(String destinatario, String assunto, String texto) {


		Properties proper = System.getProperties();

		proper.put("mail.smtp.starttls.enable", "true");
		proper.put("mail.smtp.host", "smtp.outlook.com");
		proper.put("mail.smtp.port", "587");
		proper.put("mail.smtp.auth", "true");
		proper.put("mail.smtp.starttls.required", "true");



		Session session = Session.getDefaultInstance(proper, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("faons@iscte-iul.pt", "Kironaxe32!!");
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("faons@iscte-iul.pt"));
			message.setRecipients(Message.RecipientType.TO,  InternetAddress.parse(destinatario));
			message.setSubject(assunto);
			message.setText(texto);
			Transport.send(message);

			System.out.println("\n Your Message was delivered successfully");
		}catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}

