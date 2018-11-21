package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FacebookFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	//public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FacebookFrame frame = new FacebookFrame();
					frame.setVisible(true);
					frame.setTitle("Facebook");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FacebookFrame() {
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


		//////////FOTO FACEBOOK
		JLabel faceLabel = new JLabel("");
		faceLabel.setBackground(Color.WHITE);
		faceLabel.setBounds(33, 35, 97, 97);
		ImageIcon facelogo = new ImageIcon("imagens/face.png");

		/////////RESIZE DA FOTO
		Image img1 = facelogo.getImage();
		Image resizedImg1 = img1.getScaledInstance(faceLabel.getWidth(), faceLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon newLogoFace = new ImageIcon(resizedImg1);

		faceLabel.setIcon(newLogoFace);
		contentPane.add(faceLabel);

		////////////TEXTO DE PESQUISA
		textField = new JTextField();
		textField.setBounds(8, 172, 146, 33);
		contentPane.add(textField);
		textField.setColumns(10);

		/////////BOTOES
		JButton btnNewButton = new JButton("GO");
		btnNewButton.setBounds(164, 172, 55, 33);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				//getText()

			}
		});
		
		
		JButton btnRetweet = new JButton("POST");
		btnRetweet.setBounds(102, 216, 117, 33);
		contentPane.add(btnRetweet);
		//ImageIcon arrowIcon = new ImageIcon("backarrow.png");

		JButton backButton = new JButton();
		backButton.setBounds(8, 216, 87, 33);
		contentPane.add(backButton);
		backButton.setText("BACK");
		//backButton.setIcon(new ImageIcon("backarrow.png"));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				closeFrame();

			}
		});

		JPanel panel = new JPanel();
		panel.setBounds(164, 11, 260, 150);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JList list = new JList();
		list.setBackground(Color.WHITE);
		list.setForeground(Color.BLACK);
		panel.add(list);

	}
	
	public String getText() {
		return textField.getText();
	}
	
	public void closeFrame(){
	    super.dispose();
	}
	
}