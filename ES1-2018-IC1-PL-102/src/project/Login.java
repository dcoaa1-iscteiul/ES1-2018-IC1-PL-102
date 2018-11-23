package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField passwordField;
	private JTextPane txtpnUsername;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					Dimension dimensao = new Dimension(250,330);
					frame.setPreferredSize(dimensao);
					frame.pack();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.out.println(getUsername());
				System.out.println(getPassword());
			}
		});
		btnNewButton.setBounds(53, 231, 120, 37);
		contentPane.add(btnNewButton);
		
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
		
		try {
			authenticate();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void authenticate() throws IOException {
		
		//while(!interrupted()) {
		if (getUsername().equals("h") && getPassword().equals("h")) { //não irá ser assim pois terá que funcionar com ficheiro XML
		    System.out.println("Login successful");
		} else {
		    System.out.println("login failed");
		}		
}
	
	public String getUsername(){
		return username.getText();
	}
	
	public String getPassword(){
		return passwordField.getText();
	}

}
