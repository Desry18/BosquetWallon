package Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import POJO.Categorie;
import POJO.Configuration;
import POJO.Organisateur;
import POJO.Reservation;
import POJO.Spectacle;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AjouterSpectacleFrame extends JFrame {

	private JPanel contentPane;
	DefaultListModel<Spectacle> model= new DefaultListModel<>();
    private List<Spectacle> spectacles;
    private JTextField tf_titre;
	private JComboBox<Object> comboBox;
	private JTextField tf_bronze;
	private JTextField tf_argent;
	private JTextField tf_or;
	private JTextField tf_diams;
	private JTextField tf_libre;
	private String titre;
	private int places;
	private String type;
	private String desc;
	private String type2;
	private double prix;
	private int dispo;
	private int max;
	private List<Categorie> cat = new ArrayList<Categorie>();
	private JTextField tf_places;

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
	 * @param p 
	 */
	public AjouterSpectacleFrame(Reservation r, Organisateur p) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 888, 677);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList<Spectacle> list = new JList<Spectacle>();
		list.setBackground(Color.ORANGE);
        //list.setBounds(10, 11, 665, 404);
        //contentPane.add(list);
        list.setModel(model);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 628, 404);
        contentPane.add(scrollPane);
        list.setModel(model);
        scrollPane.setViewportView(list);

        
        tf_titre = new JTextField();
        tf_titre.setBounds(10, 451, 129, 20);
        contentPane.add(tf_titre);
        tf_titre.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("Titre : ");
        lblNewLabel.setBounds(10, 426, 60, 14);
        contentPane.add(lblNewLabel);
        
        String [] discrimObj = { "Debout", "Cirque", "Concert"};
		comboBox = new JComboBox<Object>(discrimObj);
		comboBox.setMaximumRowCount(3);
		comboBox.setBounds(10, 507, 129, 22);
		comboBox.setSelectedItem(0);
		contentPane.add(comboBox);
        
       
        
        JLabel lblNewLabel_2 = new JLabel("Configuration : ");
        lblNewLabel_2.setBounds(10, 482, 104, 14);
        contentPane.add(lblNewLabel_2);
        
        tf_bronze = new JTextField();
        tf_bronze.setBounds(463, 565, 86, 20);
        contentPane.add(tf_bronze);
        tf_bronze.setColumns(10);
        tf_bronze.setVisible(false);
        
        tf_argent = new JTextField();
        tf_argent.setBounds(463, 537, 86, 20);
        contentPane.add(tf_argent);
        tf_argent.setColumns(10);
        tf_argent.setVisible(false);
        
        tf_or = new JTextField();
        tf_or.setBounds(463, 508, 86, 20);
        contentPane.add(tf_or);
        tf_or.setColumns(10);
        tf_or.setVisible(false);
        
        tf_diams = new JTextField();
        tf_diams.setBounds(463, 479, 86, 20);
        contentPane.add(tf_diams);
        tf_diams.setColumns(10);
        tf_diams.setVisible(false);
        
        tf_libre = new JTextField();
        tf_libre.setBounds(463, 451, 86, 20);
        contentPane.add(tf_libre);
        tf_libre.setColumns(10);
        tf_libre.setVisible(true);
        
        JLabel lblLibre = new JLabel("Libre :");
        lblLibre.setBounds(323, 454, 130, 14);
        contentPane.add(lblLibre);
        lblLibre.setVisible(true);
        
        JLabel lblDiams = new JLabel("Diamant : ");
        lblDiams.setBounds(323, 482, 130, 14);
        contentPane.add(lblDiams);
        lblDiams.setVisible(false);
        
        JLabel lblOr = new JLabel("Or :");
        lblOr.setBounds(323, 511, 46, 14);
        contentPane.add(lblOr);
        lblOr.setVisible(false);
        
        JLabel lblArgent = new JLabel("Argent :");
        lblArgent.setBounds(323, 540, 130, 14);
        contentPane.add(lblArgent);
        lblArgent.setVisible(false);
        
        JLabel lblBronze = new JLabel("Bronze :");
        lblBronze.setBounds(323, 568, 130, 14);
        contentPane.add(lblBronze);
        lblBronze.setVisible(false);
        
        JLabel lblPrix = new JLabel("Prix :");
        lblPrix.setBounds(463, 426, 46, 14);
        contentPane.add(lblPrix);
        
        
        
        
        spectacles = r.afficherSpectacle();
        if(spectacles != null) {
        	for (Spectacle s : spectacles) {
        		s.setPlanningSalle(r.getPlanningSalle());
        		model.addElement(s);
        	}
        }
        
        
        
        comboBox.addActionListener(new ActionListener() { 
        	public void actionPerformed(ActionEvent e) {
        		switch (comboBox.getSelectedItem().toString()) {
        		case "Debout" :         	
        			tf_libre.setVisible(true);
        			lblLibre.setVisible(true);
        	        lblBronze.setVisible(false);
        	        lblArgent.setVisible(false);
        	        lblOr.setVisible(false);
        	        lblDiams.setVisible(false);
        	        tf_diams.setVisible(false);
        	        tf_or.setVisible(false);
        	        tf_argent.setVisible(false);
        	        tf_bronze.setVisible(false);

        			break;
        		case "Concert" :
        			tf_libre.setVisible(false);
        			lblLibre.setVisible(false);
        	        lblBronze.setVisible(true);
        	        lblArgent.setVisible(true);
        	        lblOr.setVisible(true);
        	        lblDiams.setVisible(false);
        	        tf_diams.setVisible(false);
        	        tf_or.setVisible(true);
        	        tf_argent.setVisible(true);
        	        tf_bronze.setVisible(true);
        			break;

        		case "Cirque" :
        			tf_libre.setVisible(false);
        			lblLibre.setVisible(false);
        	        lblBronze.setVisible(true);
        	        lblArgent.setVisible(true);
        	        lblOr.setVisible(true);
        	        lblDiams.setVisible(true);
        	        tf_diams.setVisible(true);
        	        tf_or.setVisible(true);
        	        tf_argent.setVisible(true);
        	        tf_bronze.setVisible(true);     
        	        break;

        		
        		}
        	}
        });
        
        tf_places = new JTextField();
        tf_places.setBounds(10, 565, 86, 20);
        contentPane.add(tf_places);
        tf_places.setColumns(10);
        
        JButton btnNewButton = new JButton("Ajouter Spectacle");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		

        		switch (comboBox.getSelectedItem().toString()) {
        		case "Debout" : 
        			type = "Debout";
        			desc = "Travaillez vos jambes !";
        			if(tf_titre.getText().isEmpty() || tf_places.getText().isEmpty() || tf_libre.getText().isEmpty()) {
        				JOptionPane.showMessageDialog(null, "Veuillez renseigner tous les champs ");
        				
        			}       				
        			    			
        			else {
        				titre = tf_titre.getText();
            			places = Integer.parseInt(tf_places.getText());
        				Spectacle s = new Spectacle(r.getPlanningSalle(), titre, places);
        				p.creerSpectacle(s);
        				s = s.find();
        				Configuration co = new Configuration(type, desc, s);
        				p.creerConfig(co);
        				co = co.find();
        				prix = Double.parseDouble(tf_libre.getText());
        				Categorie cate = new Categorie("Libre", prix, 8000, 8000, co);
        				p.creerCategorie(cate);
        				model.addElement(s);

    							
        			}
        			break;
        			
        		case "Concert" : 
        			type = "Concert";
        			desc = "Assis comme pour un concert";
        			if(tf_titre.getText().isEmpty() || tf_places.getText().isEmpty() || tf_bronze.getText().isEmpty() || tf_argent.getText().isEmpty()  || tf_or.getText().isEmpty()) {
    					JOptionPane.showMessageDialog(null, "Veuillez renseigner tous les champs " + titre + " " + tf_places.getText() + " " + tf_libre.getText());		

        				
        			}
        			else {
        				titre = tf_titre.getText();
            			places = Integer.parseInt(tf_places.getText());
        				Spectacle s = new Spectacle(r.getPlanningSalle(), titre, places);
        				p.creerSpectacle(s);
        				s = s.find();
        				Configuration co = new Configuration(type, desc, s);
        				p.creerConfig(co);
        				co = co.find();
        				Categorie cate = new Categorie("Or", Double.parseDouble(tf_or.getText()), 500, 500, co);
        				p.creerCategorie(cate);
        				Categorie cate2 = new Categorie("Argent", Double.parseDouble(tf_argent.getText()), 1500, 1500, co);
        				p.creerCategorie(cate2);
        				Categorie cate3 = new Categorie("Bronze", Double.parseDouble(tf_bronze.getText()), 3000, 3000, co);
        				p.creerCategorie(cate3);
        				model.addElement(s);
        			}
        			break;
        			
        		case "Cirque" : 
        			type = "Cirque";
        			desc = "Assis comme dans un cirque";
        			if(tf_titre.getText().isEmpty() || tf_places.getText().isEmpty() || tf_bronze.getText().isEmpty() || tf_argent.getText().isEmpty()  || tf_or.getText().isEmpty() || tf_diams.getText().isEmpty() ) {
    					JOptionPane.showMessageDialog(null, "Veuillez renseigner tous les champs " + titre + " " + tf_places.getText() + " " + tf_libre.getText());		


        			}
        			else {

        				titre = tf_titre.getText();
            			places = Integer.parseInt(tf_places.getText());
        				Spectacle s = new Spectacle(r.getPlanningSalle(), titre, places);
        				p.creerSpectacle(s);
        				s = s.find();
        				Configuration co = new Configuration(type, desc, s);
        				p.creerConfig(co);
        				co = co.find();
        				Categorie cate = new Categorie("Or", Double.parseDouble(tf_or.getText()), 2000, 2000, co);
        				p.creerCategorie(cate);
        				Categorie cate2 = new Categorie("Argent", Double.parseDouble(tf_argent.getText()), 1500, 1500, co);
        				p.creerCategorie(cate2);
        				Categorie cate3 = new Categorie("Bronze", Double.parseDouble(tf_bronze.getText()), 1500, 1500, co);
        				p.creerCategorie(cate3);
        				Categorie cate4 = new Categorie("Diamant", Double.parseDouble(tf_diams.getText()), 1000, 1000, co);
        				p.creerCategorie(cate4);
        				
        				model.addElement(s);
        			}
        			break;
        			
        		}
        		
        	}
        });
        btnNewButton.setBounds(10, 596, 158, 23);
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel_1 = new JLabel("Places par client :");
        lblNewLabel_1.setBounds(10, 540, 104, 14);
        contentPane.add(lblNewLabel_1);
        
        JButton btn_repres = new JButton("Ajouter representation");
        btn_repres.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Spectacle spec = list.getSelectedValue();
        		if(spec != null) {

        			AjouterRepresentationFrame frame = new AjouterRepresentationFrame(spec);
        			frame.setVisible(true);
        		}
        		else {
					JOptionPane.showMessageDialog(null, "Sélectionnez un spectacle");		
        		}
        		
        	}
        });
        btn_repres.setBounds(668, 8, 194, 23);
        contentPane.add(btn_repres);
        
        JButton btnNewButton_1 = new JButton("Accueil");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        btnNewButton_1.setBounds(773, 596, 89, 23);
        contentPane.add(btnNewButton_1);
        
        
        
	}
}
