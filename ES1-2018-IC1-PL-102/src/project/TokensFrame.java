package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Popup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Window.Type;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class TokensFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JLabel lblAuthconsumersecret;
	private JLabel lblAuthaccesstoken;
	private JLabel lblAuthaccesstokensecret;
	private JLabel lblFacebook;
	private JLabel lblTwitter;


	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TokensFrame frame = new TokensFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public TokensFrame() {
		setTitle("Tokens");
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 465, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTokens = new JLabel(" TOKENS");
		lblTokens.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTokens.setBounds(175, 0, 81, 24);
		contentPane.add(lblTokens);
		
		textField = new JTextField();
		textField.setBounds(205, 68, 234, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(205, 98, 234, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(205, 129, 234, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(205, 185, 234, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(205, 214, 234, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(205, 245, 234, 20);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(205, 276, 234, 20);
		contentPane.add(textField_6);
		
		JButton btnNewButton = new JButton("GUARDAR");
	//	btnNewButton.setAction(action);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(contentPane, "Dados Guardados!");
			
			}
		});
		btnNewButton.setBounds(175, 327, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Access Token");
		lblNewLabel.setBounds(10, 71, 185, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblAppid = new JLabel("AppID");
		lblAppid.setBounds(10, 101, 185, 14);
		contentPane.add(lblAppid);
		
		JLabel lblAppSecret = new JLabel("App Secret");
		lblAppSecret.setBounds(10, 132, 185, 14);
		contentPane.add(lblAppSecret);
		
		JLabel lblAuthconsumerkey = new JLabel("AuthConsumerKey");
		lblAuthconsumerkey.setBounds(10, 188, 185, 14);
		contentPane.add(lblAuthconsumerkey);
		
		lblAuthconsumersecret = new JLabel("AuthConsumerSecret");
		lblAuthconsumersecret.setBounds(10, 217, 185, 14);
		contentPane.add(lblAuthconsumersecret);
		
		lblAuthaccesstoken = new JLabel("AuthAccessToken");
		lblAuthaccesstoken.setBounds(10, 248, 185, 14);
		contentPane.add(lblAuthaccesstoken);
		
		lblAuthaccesstokensecret = new JLabel("AuthAccessTokenSecret");
		lblAuthaccesstokensecret.setBounds(10, 279, 185, 14);
		contentPane.add(lblAuthaccesstokensecret);
		
		lblFacebook = new JLabel("Facebook");
		lblFacebook.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFacebook.setBounds(188, 43, 54, 14);
		contentPane.add(lblFacebook);
		
		lblTwitter = new JLabel("  Twitter");
		lblTwitter.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTwitter.setBounds(188, 160, 68, 14);
		contentPane.add(lblTwitter);
		this.setVisible(true);
	}
	/*private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "GUARDAR");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}*/
}
