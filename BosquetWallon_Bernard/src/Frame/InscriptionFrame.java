package Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import POJO.Artiste;
import POJO.Client;
import POJO.Organisateur;
import POJO.Personne;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InscriptionFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nom_insc;
	private JTextField prenom_insc;
	private JTextField adresse_insc;
	private JPasswordField mdp_insc;
	private JTextField email_insc;
	private JComboBox comboBox;
	private JLabel lblNewLabel_5;
	private JButton btn_inscription;
	private JButton btn_retour;
	private String discrim;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InscriptionFrame frame = new InscriptionFrame();
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
	public InscriptionFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nom_insc = new JTextField();
		nom_insc.setBounds(138, 8, 129, 20);
		contentPane.add(nom_insc);
		nom_insc.setColumns(10);
		
		
		prenom_insc = new JTextField();
		prenom_insc.setBounds(138, 39, 129, 20);
		contentPane.add(prenom_insc);
		prenom_insc.setColumns(10);
		
		
		adresse_insc = new JTextField();
		adresse_insc.setBounds(138, 69, 129, 20);
		contentPane.add(adresse_insc);
		adresse_insc.setColumns(10);
		
		
		mdp_insc = new JPasswordField();
		mdp_insc.setBounds(138, 128, 129, 20);
		contentPane.add(mdp_insc);
		
		
		JLabel lblNewLabel = new JLabel("Nom :");
		lblNewLabel.setBounds(51, 11, 77, 14);
		contentPane.add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("Prenom : ");
		lblNewLabel_1.setBounds(51, 42, 77, 14);
		contentPane.add(lblNewLabel_1);
		
		
		JLabel lblNewLabel_2 = new JLabel("Adresse : ");
		lblNewLabel_2.setBounds(51, 72, 77, 14);
		contentPane.add(lblNewLabel_2);
		
		
		JLabel lblNewLabel_3 = new JLabel("Email : ");
		lblNewLabel_3.setBounds(51, 103, 98, 14);
		contentPane.add(lblNewLabel_3);
		
		
		email_insc = new JTextField();
		email_insc.setBounds(138, 100, 129, 20);
		contentPane.add(email_insc);
		email_insc.setColumns(10);
		
		
		JLabel lblNewLabel_4 = new JLabel("Mot de passe : ");
		lblNewLabel_4.setBounds(51, 131, 77, 14);
		contentPane.add(lblNewLabel_4);
		
		
		String [] discrimObj = { "Client", "Artiste", "Organisateur"};
		comboBox = new JComboBox<Object>(discrimObj);
		comboBox.setMaximumRowCount(3);
		comboBox.setBounds(138, 159, 129, 22);
		comboBox.setSelectedItem(0);
		contentPane.add(comboBox);
		discrim = comboBox.getSelectedItem().toString();
		
		
		
		lblNewLabel_5 = new JLabel("Discriminator");
		lblNewLabel_5.setBounds(51, 163, 77, 14);
		contentPane.add(lblNewLabel_5);
		
		btn_inscription = new JButton("S'inscrire");
		btn_inscription.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				

				if(nom_insc.getText().isEmpty() || prenom_insc.getText().isEmpty() || email_insc.getText().isEmpty() || adresse_insc.getText().isEmpty() || mdp_insc.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Veuillez renseigner tous les champs");			
					}
				else {
					String nom = nom_insc.getText();
					String mail = email_insc.getText();
					String adr = adresse_insc.getText();
					String mdp = mdp_insc.getText();
					String prenom = prenom_insc.getText();
					switch(comboBox.getSelectedItem().toString()) {
					
					case "Artiste" : 
						Artiste a = new Artiste(nom,prenom,mail,adr,mdp);
						JOptionPane.showMessageDialog(null, a.toString());	
						a.creer();
						break;
						
					case "Client" : 
						Client c = new Client (nom,prenom,mail,adr,mdp);
						JOptionPane.showMessageDialog(null, "Client");	
						c.creer();
						break;
						
					case "Organisateur" : 	
						Organisateur o = new Organisateur(nom,prenom,mail,adr,mdp);
						JOptionPane.showMessageDialog(null, "Organisateur");		
						o.creer();
						break;


					}
					


				}
			}
		});
		btn_inscription.setBounds(179, 192, 89, 23);
		contentPane.add(btn_inscription);
		
		btn_retour = new JButton("Retour");
		btn_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConnexionFrame frame = new ConnexionFrame();
				dispose();
				frame.setVisible(true);
			}
		});
		btn_retour.setBounds(335, 227, 89, 23);
		contentPane.add(btn_retour);
	}
}
