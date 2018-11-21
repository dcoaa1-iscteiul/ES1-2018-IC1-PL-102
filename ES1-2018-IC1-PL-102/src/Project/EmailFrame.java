package Project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmailFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmailFrame frame = new EmailFrame();
					frame.setVisible(true);
					frame.setTitle("Email");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	


	/**
	 * Create the frame.
	 */
	public EmailFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setBounds(229, 172, 195, 78);
		contentPane.add(textArea);


		//////////FOTO EMAIL
		JLabel mailLabel = new JLabel("");
		mailLabel.setBackground(Color.WHITE);
		mailLabel.setBounds(33, 35, 97, 97);
		ImageIcon emailLogo = new ImageIcon("imagens/email.png");

		/////////RESIZE DA FOTO
		Image img1 = emailLogo.getImage();
		Image resizedImg1 = img1.getScaledInstance(mailLabel.getWidth(), mailLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon newLogoEmail = new ImageIcon(resizedImg1);

		mailLabel.setIcon(newLogoEmail);
		contentPane.add(mailLabel);


		textField = new JTextField();
		textField.setBounds(8, 172, 146, 33);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("GO");
		btnNewButton.setBounds(164, 172, 55, 33);
		contentPane.add(btnNewButton);

		JButton btnRetweet = new JButton("ENVIAR");
		btnRetweet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRetweet.setBounds(102, 216, 117, 33);
		contentPane.add(btnRetweet);
		//ImageIcon arrowIcon = new ImageIcon("backarrow.png");

		JButton backButton = new JButton();
		backButton.setBounds(8, 216, 87, 33);
		contentPane.add(backButton);
		backButton.setText("BACK");
		//backButton.setIcon(new ImageIcon("backarrow.png"));

		JPanel panel = new JPanel();
		panel.setBounds(164, 11, 260, 150);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JList list = new JList();
		list.setBackground(Color.WHITE);
		list.setForeground(Color.BLACK);
		panel.add(list);

	}
}
