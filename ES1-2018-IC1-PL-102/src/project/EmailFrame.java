package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class EmailFrame extends JFrame {

	public JScrollPane endereçosScroll;
	public static JTextField textField;
	public JPanel contentPane;
	public static JList<String> EmailJlist;
	public static JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new EmailFrame();
					frame.setVisible(true);
					frame.setTitle("Email");
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
	public EmailFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 727, 465);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setBounds(231, 343, 343, 72);
		contentPane.add(textArea);


		//////////FOTO EMAIL
		JLabel mailLabel = new JLabel("");
		mailLabel.setBackground(Color.WHITE);
		mailLabel.setBounds(584, 332, 106, 89);

		ImageIcon emailLogo = new ImageIcon("imagens/email.png");

		/////////RESIZE DA FOTO
		Image img1 = emailLogo.getImage();
		Image resizedImg1 = img1.getScaledInstance(mailLabel.getWidth(), mailLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon newLogoEmail = new ImageIcon(resizedImg1);

		mailLabel.setIcon(newLogoEmail);
		contentPane.add(mailLabel);


		textField = new JTextField();
		textField.setBounds(10, 339, 146, 33);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton go = new JButton("GO");
		go.setBounds(166, 339, 55, 33);
		contentPane.add(go);
		go.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EmailMain.authenticate();
			}
		
		});
			
		JButton enviar = new JButton("ENVIAR EMAIL");
		enviar.setBounds(104, 383, 117, 33);
		contentPane.add(enviar);
		enviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EnviarEmail eFrame;
				eFrame = new EnviarEmail();
				eFrame.setVisible(true);
			}
		});
		
		enviar.setBounds(104, 383, 117, 33);
		contentPane.add(enviar);
		//ImageIcon arrowIcon = new ImageIcon("backarrow.png");

		JButton backButton = new JButton("BACK");
		backButton.setBounds(10, 383, 87, 33);
		contentPane.add(backButton);
		//backButton.setIcon(new ImageIcon("backarrow.png"));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				closeFrame();

			}
		});

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 691, 316);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		EmailJlist = new JList<String>();
		EmailJlist.setBackground(Color.WHITE);
		EmailJlist.setForeground(Color.BLACK);
		

		
		endereçosScroll = new JScrollPane(EmailJlist, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel.add(endereçosScroll);

	}
	
	
	
	public static void info2JList() {
		DefaultListModel<String> listModel = new DefaultListModel<String>();
			for (String line : EmailMain.info) {
				listModel.addElement(line);
			}
			EmailJlist.setModel(listModel);
			System.out.println(EmailJlist);
		}
	
	public void closeFrame(){
	    super.dispose();
	}
	
	public String getText() {
		return textField.getText();
	}
}
