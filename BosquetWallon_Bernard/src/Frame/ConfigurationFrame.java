package Frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import POJO.Categorie;
import POJO.Client;
import POJO.Configuration;
import POJO.Place;
import POJO.Representation;
import POJO.Spectacle;

import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfigurationFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4938467430519108515L;

	private JPanel contentPane;
	
	DefaultListModel<Configuration> model= new DefaultListModel<>();
	private List<Configuration> configurations;
	
	DefaultListModel<Categorie> model2= new DefaultListModel<>();
	private List<Categorie> categories;
	
	private List<Place> places = new ArrayList<Place>();
	private int cpt = 0;

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
	 * @param s 
	 * @param r 
	 * @param p 
	 */
	public ConfigurationFrame(Representation r, Spectacle s, Client p) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1172, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JList<Configuration> list = new JList<Configuration>();
		list.setBackground(Color.ORANGE);
		list.setBounds(10, 111, 534, 238);
		contentPane.add(list);
		
		JList<Categorie> list_1 = new JList<Categorie>();
		list_1.setBackground(Color.ORANGE);
		list_1.setBounds(554, 111, 592, 238);
		contentPane.add(list_1);
		
		list.setModel(model);
		list_1.setModel(model2);
		configurations = s.afficherConfig();
		
		for(Configuration c : configurations)
			model.addElement(c);
		
		 list.getSelectionModel().addListSelectionListener(new ListSelectionListener() {			
			public void valueChanged(ListSelectionEvent e) {
				model2.clear();
				Configuration c = list.getSelectedValue();
				categories = c.afficherCat();
				if(categories != null)
				{
					for (Categorie ca : categories) {
						model2.addElement(ca);					
						}
				}
			}
		});
		
		
		
		JLabel lblNewLabel = new JLabel("Configurations : ");
		lblNewLabel.setBounds(10, 86, 91, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Catégories : ");
		lblNewLabel_1.setBounds(554, 86, 91, 14);
		contentPane.add(lblNewLabel_1);
		
	
		
	
		
		JLabel lblNewLabel_2 = new JLabel("Nombre de places : ");
		lblNewLabel_2.setBounds(177, 360, 124, 23);
		contentPane.add(lblNewLabel_2);
		
		JLabel lbl_cpt = new JLabel("0");
		lbl_cpt.setBounds(334, 364, 46, 14);
		contentPane.add(lbl_cpt);
		
		
		JButton btnNewButton_1 = new JButton("Ajouter place");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Categorie c = list_1.getSelectedValue();
				Configuration co = list.getSelectedValue();
				if(c != null && co != null) {
					Place p = new Place(r, c.getPrix());
					places.add(p);
					cpt++;
					lbl_cpt.setText(cpt + "");
				}
			}
		});
		btnNewButton_1.setBounds(10, 360, 124, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Commander");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(places != null) {
					CommandeFrame frame = new CommandeFrame(r, places, p);
					frame.setVisible(true);
				}
			}
			
		});
		btnNewButton.setBounds(10, 394, 124, 23);
		contentPane.add(btnNewButton);
		
	}

}
