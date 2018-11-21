package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
					Dimension dimensao = new Dimension(450,400);
					frame.setPreferredSize(dimensao);
					frame.pack();
					frame.setResizable(false);
					frame.setTitle("Menu Principal");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		//////////////////////////CHECKBOXES
		JCheckBox faceCheckBox = new JCheckBox("");
		faceCheckBox.setBackground(Color.WHITE);
		faceCheckBox.setBounds(68, 256, 21, 23);
		contentPane.add(faceCheckBox);

		JCheckBox twitterCheckBox = new JCheckBox("");
		twitterCheckBox.setBackground(Color.WHITE);
		twitterCheckBox.setBounds(209, 256, 21, 23);
		contentPane.add(twitterCheckBox);

		JCheckBox emailCheckBox = new JCheckBox("");
		emailCheckBox.setBackground(Color.WHITE);
		emailCheckBox.setBounds(351, 256, 21, 23);
		contentPane.add(emailCheckBox);




		JTextPane txtpnAsdasd = new JTextPane();
		txtpnAsdasd.setEditable(false);
		txtpnAsdasd.setBackground(Color.WHITE);
		txtpnAsdasd.setText("FACEBOOK");
		txtpnAsdasd.setBounds(41, 226, 79, 23);
		contentPane.add(txtpnAsdasd);

		JTextPane txtpnTwitter = new JTextPane();
		txtpnTwitter.setEditable(false);
		txtpnTwitter.setBackground(Color.WHITE);
		txtpnTwitter.setText("TWITTER");
		txtpnTwitter.setBounds(189, 226, 60, 23);
		contentPane.add(txtpnTwitter);

		JTextPane txtpnEmail = new JTextPane();
		txtpnEmail.setEditable(false);
		txtpnEmail.setBackground(Color.WHITE);
		txtpnEmail.setText("E-MAIL");
		txtpnEmail.setBounds(341, 226, 60, 23);
		contentPane.add(txtpnEmail);


		//////////FOTO FACEBOOK
		JLabel faceLabel = new JLabel("");
		faceLabel.setBackground(Color.WHITE);
		faceLabel.setBounds(27, 125, 97, 97);
		ImageIcon facelogo = new ImageIcon("imagens/face.png");

		/////////RESIZE DA FOTO
		Image img1 = facelogo.getImage();
		Image resizedImg1 = img1.getScaledInstance(faceLabel.getWidth(), faceLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon newLogoFace = new ImageIcon(resizedImg1);

		faceLabel.setIcon(newLogoFace);
		contentPane.add(faceLabel);


		//////////FOTO TWITTER
		JLabel twitterLabel = new JLabel("");
		twitterLabel.setBackground(Color.WHITE);
		twitterLabel.setBounds(166, 125, 97, 97);
		ImageIcon twitterLogo = new ImageIcon("imagens/twitter.png");

		/////////RESIZE DA FOTO
		Image img2 = twitterLogo.getImage();
		Image resizedImg2 = img2.getScaledInstance(twitterLabel.getWidth(), twitterLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon newLogoTwitter = new ImageIcon(resizedImg2);

		twitterLabel.setIcon(newLogoTwitter);
		contentPane.add(twitterLabel);

		//////////FOTO EMAIL
		JLabel emailLabel = new JLabel("");
		emailLabel.setBackground(Color.WHITE);
		emailLabel.setBounds(311, 125, 97, 97);
		ImageIcon emailLogo = new ImageIcon("imagens/email.png");

		/////////RESIZE DA FOTO
		Image img3 = emailLogo.getImage();
		Image resizedImg3 = img3.getScaledInstance(emailLabel.getWidth(), emailLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon newLogoEmail = new ImageIcon(resizedImg3);

		emailLabel.setIcon(newLogoEmail);
		contentPane.add(emailLabel);

		JButton btnOk = new JButton("OK");
		btnOk.setBounds(174, 324, 89, 23);
		contentPane.add(btnOk);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if(faceCheckBox.isSelected() && !twitterCheckBox.isSelected() && !emailCheckBox.isSelected()) {
					FacebookFrame fFrame = new FacebookFrame();
					fFrame.setVisible(true);
					//frame.setVisible(false);
				} else if(!faceCheckBox.isSelected() && twitterCheckBox.isSelected() && !emailCheckBox.isSelected()) {
					TwitterFrame tFrame;
					try {
						tFrame = new TwitterFrame();
						tFrame.setVisible(true);
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else if (!faceCheckBox.isSelected() && !twitterCheckBox.isSelected() && emailCheckBox.isSelected()) {
					EmailFrame eFrame = new EmailFrame();
					eFrame.setVisible(true);
				} else if (!faceCheckBox.isSelected() && !twitterCheckBox.isSelected() && !emailCheckBox.isSelected()) {
					JOptionPane.showMessageDialog(frame, "Escolha uma opção válida!");
				}
				else
					JOptionPane.showMessageDialog(frame, "Escolha apenas um!");
			}
		});


		JTextPane txtpnBemVindo = new JTextPane();
		txtpnBemVindo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 29));
		txtpnBemVindo.setText("BEM VINDO, + USERNAME");
		txtpnBemVindo.setEditable(false);
		txtpnBemVindo.setBackground(Color.WHITE);
		txtpnBemVindo.setBounds(128, 11, 222, 81);
		contentPane.add(txtpnBemVindo);



	}
}
