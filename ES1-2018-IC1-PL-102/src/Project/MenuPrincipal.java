package Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBackground(Color.WHITE);
		chckbxNewCheckBox.setBounds(57, 191, 21, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox checkBox = new JCheckBox("");
		checkBox.setBackground(Color.WHITE);
		checkBox.setBounds(203, 191, 21, 23);
		contentPane.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("");
		checkBox_1.setBackground(Color.WHITE);
		checkBox_1.setBounds(348, 191, 21, 23);
		contentPane.add(checkBox_1);
		
		JTextPane txtpnAsdasd = new JTextPane();
		txtpnAsdasd.setBackground(Color.WHITE);
		txtpnAsdasd.setText("FACEBOOK");
		txtpnAsdasd.setBounds(39, 161, 60, 23);
		contentPane.add(txtpnAsdasd);
		
		JTextPane txtpnTwitter = new JTextPane();
		txtpnTwitter.setBackground(Color.WHITE);
		txtpnTwitter.setText("TWITTER");
		txtpnTwitter.setBounds(187, 161, 60, 23);
		contentPane.add(txtpnTwitter);
		
		JTextPane txtpnEmail = new JTextPane();
		txtpnEmail.setBackground(Color.WHITE);
		txtpnEmail.setText("E-MAIL");
		txtpnEmail.setBounds(339, 161, 60, 23);
		contentPane.add(txtpnEmail);
		
		JLabel label = new JLabel("");
		label.setBounds(21, 60, 97, 97);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(164, 60, 97, 97);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(309, 60, 97, 97);
		contentPane.add(label_2);
	}
}
