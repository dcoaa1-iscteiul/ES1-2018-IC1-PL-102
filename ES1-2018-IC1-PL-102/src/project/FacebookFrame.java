/*
 * Classe usada para a criação e uso de todos os componentes da interface relativa ao Facebook
 */
package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

public class FacebookFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	public static JList<String> FacebookJlist;
	private JScrollPane endereçosScroll;
	public static JFrame frame;

	/**
	 * Main usado para inicializar a frame.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new FacebookFrame();
					frame.setVisible(true);
					frame.setTitle("Facebook");
					frame.pack();
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Criação da frame com os critérios que o grupo achou mais adequado.
	 */
	public FacebookFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 727, 466);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setBounds(231, 343, 343, 78);
		contentPane.add(textArea);


		//////////FOTO FACEBOOK
		JLabel faceLabel = new JLabel("");
		faceLabel.setBackground(Color.WHITE);
		faceLabel.setBounds(584, 332, 106, 89);
		ImageIcon facelogo = new ImageIcon("imagens/face.png");

		/////////RESIZE DA FOTO
		Image img1 = facelogo.getImage();
		Image resizedImg1 = img1.getScaledInstance(faceLabel.getWidth(), faceLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon newLogoFace = new ImageIcon(resizedImg1);

		faceLabel.setIcon(newLogoFace);
		contentPane.add(faceLabel);

		////////////TEXTO DE PESQUISA
		textField = new JTextField();
		textField.setBounds(10, 339, 146, 33);
		contentPane.add(textField);
		textField.setColumns(10);

		/////////BOTOES
		JButton go = new JButton("GO");
		go.setBounds(166, 339, 55, 33);
		contentPane.add(go);
		go.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FacebookAPI.search(textField.getText());
			}
		});
		
		
		JButton btnPost = new JButton("POST");
		btnPost.setBounds(104, 383, 117, 33);
		contentPane.add(btnPost);
		btnPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				FacebookAPI.post(textArea.getText());
			}
		});

		JButton backButton = new JButton();
		backButton.setBounds(10, 383, 87, 33);
		contentPane.add(backButton);
		backButton.setText("BACK");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				closeFrame();
			}
		});

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 691, 316);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		FacebookJlist = new JList<String>();
		FacebookJlist.setBackground(Color.WHITE);
		FacebookJlist.setForeground(Color.BLACK);
		panel.add(FacebookJlist);
		FacebookJlist.addMouseListener(new MouseAdapter(){
	          @Override
	          public void mouseClicked(MouseEvent e) {
	        	  JOptionPane.showMessageDialog(FacebookFrame.frame, FacebookJlist.getSelectedValue());	              
	              System.out.println("Mouse click.");
	          }
		});

		endereçosScroll = new JScrollPane(FacebookJlist, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		panel.add(endereçosScroll);
	}
	
	/**
	 * @return
	 * Devolve o texto inserido no textfield para pesquisa
	 */
	public String getText() {
		return textField.getText();
	}
	
	public void closeFrame(){
	    super.dispose();
	}
	
	/**
	 * Função que converte a lista com os posts para a JList (interface) 
	 */
	public static void info2JList() {
		DefaultListModel<String> listModel = new DefaultListModel<String>();
			for (String line : FacebookAPI.getInfo()) {
				listModel.addElement(line);
			}
			FacebookJlist.setModel(listModel);
		}
	
}