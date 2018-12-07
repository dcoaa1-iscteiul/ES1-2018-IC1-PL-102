package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField passwordField;
	private JTextPane txtpnUsername;

	
	public LoginFrame() {
		
		//JFrame frame = new Frame();
		
		Dimension dimensao = new Dimension(250,424);
		
		
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
				
				MenuPrincipal menu= new MenuPrincipal();
			
				menu.run();
				
			}
		});
		btnLogin.setBounds(53, 231, 120, 37);
		contentPane.add(btnLogin);
		
		
		JButton btnRegistar = new JButton("REGISTAR");
		btnRegistar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JOptionPane.showMessageDialog(contentPane, "Utilizador guardado! Insira os tokens na opção 'MUDAR DADOS'");
			}
		});
		
		btnRegistar.setBounds(53, 279, 120, 37);
		contentPane.add(btnRegistar);
		
		JButton btnMudarDados = new JButton("MUDAR DADOS");
		btnMudarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TokensFrame tf= new TokensFrame();
			}
		});
		
		btnMudarDados.setBounds(53, 333, 120, 37);
		contentPane.add(btnMudarDados);
		
		this.setPreferredSize(dimensao);
		this.pack();
		this.setResizable(false);	
		this.setVisible(true);
		
	}
	
	
	public String getUsername(){
		return username.getText();
	}
	
	
}
