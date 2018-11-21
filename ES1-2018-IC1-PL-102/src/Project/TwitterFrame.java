package Project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TwitterFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TwitterFrame frame = new TwitterFrame();
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
	public TwitterFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(198, 172, 226, 78);
		contentPane.add(textArea);
		
		JList list = new JList();
		list.setBounds(412, 150, -271, -140);
		contentPane.add(list);
		
		//////////FOTO TWITTER
		JLabel twitterLabel = new JLabel("");
		twitterLabel.setBackground(Color.WHITE);
		twitterLabel.setBounds(21, 39, 97, 97);
		ImageIcon twitterLogo = new ImageIcon("imagens/twitter.png");

		/////////RESIZE DA FOTO
		Image img2 = twitterLogo.getImage();
		Image resizedImg2 = img2.getScaledInstance(twitterLabel.getWidth(), twitterLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon newLogoTwitter = new ImageIcon(resizedImg2);

		twitterLabel.setIcon(newLogoTwitter);
		contentPane.add(twitterLabel);
		
		textField = new JTextField();
		textField.setBounds(8, 172, 133, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(151, 172, 37, 33);
		contentPane.add(btnNewButton);
		
		JButton btnRetweet = new JButton("RETWEET");
		btnRetweet.setBounds(55, 217, 133, 33);
		contentPane.add(btnRetweet);
		
		ImageIcon voltar = new ImageIcon("backarrow.png");
		JButton button = new JButton(voltar);
		button.setBounds(10, 217, 37, 33);
		contentPane.add(button);
	}
}
