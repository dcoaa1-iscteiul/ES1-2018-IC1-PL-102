package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JLabel;

public class EnviarEmail extends JFrame {

	private JPanel contentPane;
	public static JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new EnviarEmail();
					frame.setVisible(true);
					frame.setTitle("Email");
					frame.setResizable(false);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EnviarEmail() {
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 290, 299);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea destinatario = new JTextArea();
		destinatario.setBounds(70, 11, 194, 28);
		contentPane.add(destinatario);
		
		JTextArea assunto = new JTextArea();
		assunto.setBounds(70, 50, 194, 28);
		contentPane.add(assunto);
		
		JTextArea texto = new JTextArea();
		texto.setBounds(70, 89, 194, 132);
		contentPane.add(texto);
		
		JButton btnEnviar = new JButton("ENVIAR");
		btnEnviar.setBounds(119, 232, 89, 23);
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EmailMain.enviarMail(destinatario.getText().toString(), assunto.getText().toString(), texto.getText().toString());
			}
		});
		contentPane.add(btnEnviar);
		
		JLabel lblDestinatario = new JLabel("Destinatario");
		lblDestinatario.setBounds(10, 16, 67, 14);
		contentPane.add(lblDestinatario);
		
		JLabel lblAssunto = new JLabel("Assunto");
		lblAssunto.setBounds(10, 55, 67, 14);
		contentPane.add(lblAssunto);
		
		JLabel lblTexto = new JLabel("Texto");
		lblTexto.setBounds(10, 89, 67, 14);
		contentPane.add(lblTexto);
	}
	
	
}
