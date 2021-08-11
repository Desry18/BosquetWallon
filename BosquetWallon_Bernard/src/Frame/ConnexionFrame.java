package Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.AbstractDAOFactory;
import DAO.DAO;
import DAO.PersonneDAO;

import POJO.Artiste;
import POJO.Client;
import POJO.Organisateur;
import POJO.Personne;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConnexionFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6425393264660558211L;
	private JPanel contentPane;
	private JTextField email_con;
	private JPasswordField mdp_con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnexionFrame frame = new ConnexionFrame();
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
	public ConnexionFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		email_con = new JTextField();
		email_con.setBounds(229, 74, 130, 20);
		contentPane.add(email_con);
		email_con.setColumns(10);

		mdp_con = new JPasswordField();
		mdp_con.setBounds(229, 105, 130, 20);
		contentPane.add(mdp_con);

		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setBounds(88, 77, 97, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Mot de passe");
		lblNewLabel_1.setBounds(88, 108, 97, 14);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Inscription");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InscriptionFrame frame = new InscriptionFrame();
				dispose();
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(255, 200, 104, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Connexion");
		btnNewButton_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				Personne pers = new Client();
				String email = email_con.getText();
				String mdp = mdp_con.getText();
				pers.setEmail(email);
				
				Personne p = pers.find();

				if (email == null && mdp == null) {
					JOptionPane.showMessageDialog(null, "Veuillez compléter les champs");
				}
				else if (p != null) {
					if (p.verifierMotDePasse(mdp)) {
						if (p instanceof Artiste) {
							AccueilArtiste aart = new AccueilArtiste((Artiste) p);
							dispose();
							aart.setVisible(true);
							JOptionPane.showMessageDialog(null, "Artiste");
						} else if (p instanceof Client) {
							 AccueilClient acli= new AccueilClient((Client) p);
							 dispose();
							 acli.setVisible(true);
							JOptionPane.showMessageDialog(null, "Client");

						} else if (p instanceof Organisateur) {
							AccueilOrga aorga = new AccueilOrga((Organisateur) p);
							dispose();
							aorga.setVisible(true);
							JOptionPane.showMessageDialog(null, "Orga");

						} else {
							contentPane.setVisible(false);
							JOptionPane.showMessageDialog(null, "Gestionnaire");
						}
					} else
						JOptionPane.showMessageDialog(null, "Mot de passe incorrect");
				}
				else{
					JOptionPane.showMessageDialog(null, "L'adresse Email n'existe pas, veuillez cr�er un compte");
				}
			}

		});

		btnNewButton_1.setBounds(255, 166, 104, 23);
		contentPane.add(btnNewButton_1);
	}
}
