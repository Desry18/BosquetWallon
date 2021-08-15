package Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import POJO.Categorie;
import POJO.Client;
import POJO.Commande;
import POJO.Place;
import POJO.Representation;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CommandeFrame extends JFrame {

	private JPanel contentPane;
	private double somme = 0;
	private JComboBox<Object> comboBox;
	private Commande c;
	private JComboBox<Object> comboBox2;

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
	 * @param places 
	 * @param r 
	 * @param p 
	 */
	public CommandeFrame(Representation r, List<Place> places, Client p1) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(20, 80, 436, 14);
		contentPane.add(lblNewLabel);
		lblNewLabel.setText(places.get(0).toString());
		
		JLabel Somme = new JLabel("");
		Somme.setBounds(20, 35, 39, 14);
		contentPane.add(Somme);
		
		for (Place p : places){
			somme+=p.getPrix();		
		}
		
		Somme.setText(somme + "");
		
		String [] discrimObj = { "VISA", "Paypal", "Sepa"};
		comboBox = new JComboBox<Object>(discrimObj);
		comboBox.setMaximumRowCount(3);
		comboBox.setBounds(134, 31, 129, 22);
		comboBox.setSelectedItem(0);
		contentPane.add(comboBox);
		
		String [] discrimObj2 = { "Sur place", "Livraison", "Livraison sécurisée"};
		comboBox2 = new JComboBox<Object>(discrimObj2);
		comboBox2.setMaximumRowCount(3);
		comboBox2.setBounds(321, 31, 129, 22);
		comboBox2.setSelectedItem(0);
		contentPane.add(comboBox2);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox2.getSelectedItem().toString().equals("Livraison Sécurisée")){
					somme+=10;
					Somme.setText(somme + "");	
				}
				c = new Commande(somme, comboBox.getSelectedItem().toString(), comboBox2.getSelectedItem().toString(), p1);
				lblNewLabel.setText(c.toString());
				c.creer();
				c = c.find();
				for (Place place : places) {
					place.setCommande(c);
					place.creer();
				}
			}
		});
		btnNewButton.setBounds(10, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Somme : ");
		lblNewLabel_1.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mode de payement");
		lblNewLabel_2.setBounds(134, 11, 168, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mode de livraison");
		lblNewLabel_3.setBounds(321, 11, 148, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(380, 227, 89, 23);
		contentPane.add(btnNewButton_1);
	
		
	}

}
