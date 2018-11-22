package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
	public static JList<String> twitterJlist;
	private JScrollPane endereçosScroll;

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
		setBounds(100, 100, 727, 466);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setBounds(231, 343, 343, 78);
		contentPane.add(textArea);
		
		
		//////////FOTO TWITTER
		JLabel twitterLabel = new JLabel("");
		twitterLabel.setBackground(Color.WHITE);
		twitterLabel.setBounds(584, 332, 106, 89);
		ImageIcon twitterLogo = new ImageIcon("imagens/twitter.png");

		/////////RESIZE DA FOTO
		Image img2 = twitterLogo.getImage();
		Image resizedImg2 = img2.getScaledInstance(twitterLabel.getWidth(), twitterLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon newLogoTwitter = new ImageIcon(resizedImg2);

		twitterLabel.setIcon(newLogoTwitter);
		contentPane.add(twitterLabel);

		
		textField = new JTextField();
		textField.setBounds(10, 339, 146, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("GO");
		btnNewButton.setBounds(166, 339, 55, 33);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TwitterMain.search(textField.getText());
				

			}
		});
		
		
	
		JButton btnRetweet = new JButton("RETWEET");
		btnRetweet.setBounds(104, 383, 117, 33);
		contentPane.add(btnRetweet);
		//ImageIcon arrowIcon = new ImageIcon("backarrow.png");
		btnRetweet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TwitterMain.tweet(textArea.getText());
				

			}
		});
		
		JButton backButton = new JButton();
		backButton.setBounds(10, 383, 87, 33);
		contentPane.add(backButton);
		backButton.setText("BACK");
		backButton.setIcon(new ImageIcon("backarrow.png"));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				closeFrame();

			}
		});
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 691, 316);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		twitterJlist = new JList<String>();
		twitterJlist.setBackground(Color.WHITE);
		twitterJlist.setForeground(Color.BLACK);
		
		endereçosScroll = new JScrollPane(twitterJlist, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		panel.add(endereçosScroll);
		
	}
	
	public static void info2JList() {
		DefaultListModel<String> listModel = new DefaultListModel<String>();
			for (String line : TwitterMain.info) {
				listModel.addElement(line);
			}
			twitterJlist.setModel(listModel);
			System.out.println(twitterJlist);
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
