/*
 * Classe usada para a criação e uso de todos os componentes da interface relativa ao Login
 */
package project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.Node;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField passwordField;
	private JTextPane txtpnUsername;

	
	/**
	 * Função usada para inicializar a frame.
	 */
	public LoginFrame() {
		
		Dimension dimensao = new Dimension(250,325);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
	
		JTextPane txtpnPassword = new JTextPane();
		txtpnPassword.setText("Password");
		txtpnPassword.setEditable(false);
		txtpnPassword.setBackground(Color.WHITE);
		txtpnPassword.setBounds(81, 183, 60, 20);
		contentPane.add(txtpnPassword);
		
		username = new JTextField();
		username.setForeground(new Color(0, 0, 0));
		username.setColumns(10);
		username.setBounds(53, 149, 120, 20);
		contentPane.add(username);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon logo = new ImageIcon("imagens/logosmall.png");

		lblNewLabel.setIcon(logo);
		lblNewLabel.setBounds(0, 0, 234, 126);
		contentPane.add(lblNewLabel);
		
		txtpnUsername = new JTextPane();
		txtpnUsername.setText("Username");
		txtpnUsername.setEditable(false);
		txtpnUsername.setBackground(Color.WHITE);
		txtpnUsername.setBounds(81, 129, 105, 20);
		contentPane.add(txtpnUsername);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(53, 203, 120, 20);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(authentication(username.getText())==true) {
					MenuPrincipal menu= new MenuPrincipal();			
					menu.run();
					return;
				}else {
					JOptionPane.showMessageDialog(contentPane, "Utilizador não existente!");
				}
				
			}

			private boolean authentication(String a) {		
				System.out.println(a);
				String aux= "faons@iscte-iul.pt";
				if(a.equals(aux)) { 
					System.out.println("here");
					return true;
				}
				return false;
			}
		
			
		});
		btnLogin.setBounds(53, 231, 120, 37);
		contentPane.add(btnLogin);
		
		this.setPreferredSize(dimensao);
		this.pack();
		this.setResizable(false);	
		this.setVisible(true);
		
	}
	
	
	/**
	 * @return
	 * Função para obter o nome de utilizador inserido e comparar.
	 */
	public String getUsername(){
		return username.getText();
	}
	
	
}
