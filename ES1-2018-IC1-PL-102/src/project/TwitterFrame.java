package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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
	public JTextField textField;
	private JButton button;
	public JTextArea textArea;

	/**
	 * Launch the application.
	 */
	
	/*public TwitterFrame(TwitterMain frame) {
	}
		*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TwitterFrame frame = new TwitterFrame();
					frame.setVisible(true);
					frame.setTitle("Twitter");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public TwitterFrame() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setBounds(229, 172, 195, 78);
		contentPane.add(textArea);
		
		
		//////////FOTO TWITTER
		JLabel twitterLabel = new JLabel("");
		twitterLabel.setBackground(Color.WHITE);
		twitterLabel.setBounds(33, 35, 97, 97);
		ImageIcon twitterLogo = new ImageIcon("imagens/twitter.png");

		/////////RESIZE DA FOTO
		Image img2 = twitterLogo.getImage();
		Image resizedImg2 = img2.getScaledInstance(twitterLabel.getWidth(), twitterLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon newLogoTwitter = new ImageIcon(resizedImg2);

		twitterLabel.setIcon(newLogoTwitter);
		contentPane.add(twitterLabel);

		
		textField = new JTextField();
		textField.setBounds(8, 172, 146, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("GO");
		btnNewButton.setBounds(164, 172, 55, 33);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				startSearch();
				

			}
		});
		
		startSearch();
		
		JButton btnRetweet = new JButton("RETWEET");
		btnRetweet.setBounds(102, 216, 117, 33);
		contentPane.add(btnRetweet);
		//ImageIcon arrowIcon = new ImageIcon("backarrow.png");
		btnRetweet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TwitterMain.retweet();
				

			}
		});
		
		JButton backButton = new JButton();
		backButton.setBounds(8, 216, 87, 33);
		contentPane.add(backButton);
		backButton.setText("BACK");
		backButton.setIcon(new ImageIcon("backarrow.png"));
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
	
	public void startSearch() {
		
		if(getText().contains("123"))
			System.out.println(getText());
		
	}
	
	public void closeFrame(){
	    super.dispose();
	}
	
	public String getText() {
		return textField.getText();
	}
	
	public String getTweet() {
		return textArea.getText();
	}
	
	

}
