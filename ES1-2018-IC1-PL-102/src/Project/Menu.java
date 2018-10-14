package Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;



public class Menu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	
	
	public Menu() {
		setResizable(false);
		setTitle("Bom Dia Academia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 234);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel RadioButtonPanel = new JPanel();
		RadioButtonPanel.setBounds(5, 5, 424, 42);
		contentPane.add(RadioButtonPanel);
		RadioButtonPanel.setLayout(null);
		
		JRadioButton rdbtnFacebook = new JRadioButton("Facebook");
		rdbtnFacebook.setBounds(54, 12, 113, 23);
		RadioButtonPanel.add(rdbtnFacebook);
		
		JRadioButton rdbtnTwitter = new JRadioButton("Twitter");
		rdbtnTwitter.setBounds(169, 12, 101, 23);
		RadioButtonPanel.add(rdbtnTwitter);
		
		JRadioButton rdbtnOutlook = new JRadioButton("Outlook");
		rdbtnOutlook.setBounds(272, 12, 115, 23);
		RadioButtonPanel.add(rdbtnOutlook);
		
		ButtonGroup group= new ButtonGroup();
		group.add(rdbtnFacebook);
		group.add(rdbtnTwitter);
		group.add(rdbtnOutlook);
		
		JPanel LoginPanel = new JPanel();
		LoginPanel.setBounds(62, 47, 276, 158);
		contentPane.add(LoginPanel);
		LoginPanel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(97, 11, 160, 20);
		LoginPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setBounds(65, 14, 46, 17);
		LoginPanel.add(lblUser);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(97, 42, 160, 20);
		LoginPanel.add(passwordField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(34, 42, 77, 20);
		LoginPanel.add(lblPassword);
		
		JButton btnAccess = new JButton("Access");
		btnAccess.setBounds(97, 114, 91, 33);
		LoginPanel.add(btnAccess);
		
		textField_1 = new JTextField();
		textField_1.setBounds(97, 73, 160, 20);
		LoginPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblToken = new JLabel("Token");
		lblToken.setBounds(55, 76, 56, 14);
		LoginPanel.add(lblToken);
		
		
	}
	
	
}
