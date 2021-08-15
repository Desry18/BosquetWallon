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
        list.setBounds(10, 11, 665, 404);
        contentPane.add(list);
        list.setModel(model);
        
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
        		titre = tf_titre.getText();
    			places =Integer.parseInt(tf_places.getText());

        		switch (comboBox.getSelectedItem().toString()) {
        		case "Debout" : 
        			type = "Debout";
        			desc = "Travaillez vos jambes !";
        			if(titre != null && tf_places.getText() != null && tf_libre.getText()!=null) {
        				Spectacle s = new Spectacle(r.getPlanningSalle(), titre, places);
        				s.creer();
        				s = s.find();
        				Configuration co = new Configuration(type, desc, s);
        				co.creer();
        				co = co.find();
        				prix = Double.parseDouble(tf_libre.getText());
        				Categorie cate = new Categorie("Libre", prix, 8000, 8000, co);
        				cate.creer();
        				model.addElement(s);

        			}    			
        			
        			else {
    					JOptionPane.showMessageDialog(null, "Veuillez renseigner tous les champs " + titre + " " + tf_places.getText() + " " + tf_libre.getText());		
        			}
        			break;
        			
        		case "Concert" : 
        			type = "Concert";
        			desc = "Assis comme pour un concert";
        			if(titre != null && tf_places.getText() != null && tf_bronze.getText()!=null && tf_argent.getText() != null && tf_or.getText() != null) {
        				Spectacle s = new Spectacle(r.getPlanningSalle(), titre, places);
        				s.creer();
        				s = s.find();
        				Configuration co = new Configuration(type, desc, s);
        				co.creer();
        				co = co.find();
        				Categorie cate = new Categorie("Or", Double.parseDouble(tf_or.getText()), 500, 500, co);
        				cate.creer();
        				Categorie cate2 = new Categorie("Argent", Double.parseDouble(tf_argent.getText()), 1500, 1500, co);
        				cate2.creer();
        				Categorie cate3 = new Categorie("Bronze", Double.parseDouble(tf_bronze.getText()), 3000, 3000, co);
        				cate3.creer();
        				model.addElement(s);
        			}
        			else {
    					JOptionPane.showMessageDialog(null, "Veuillez renseigner tous les champs " + titre + " " + tf_places.getText() + " " + tf_libre.getText());		
        			}
        			break;
        			
        		case "Cirque" : 
        			type = "Cirque";
        			desc = "Assis comme dans un cirque";
        			if(titre != null && tf_places.getText() != null && tf_bronze.getText()!=null && tf_argent.getText() != null && tf_or.getText() != null && tf_diams.getText() != null) {
        				Spectacle s = new Spectacle(r.getPlanningSalle(), titre, places);
        				s.creer();
        				s = s.find();
        				Configuration co = new Configuration(type, desc, s);
        				co.creer();
        				co = co.find();
        				Categorie cate = new Categorie("Or", Double.parseDouble(tf_or.getText()), 2000, 2000, co);
        				cate.creer();
        				Categorie cate2 = new Categorie("Argent", Double.parseDouble(tf_argent.getText()), 1500, 1500, co);
        				cate2.creer();
        				Categorie cate3 = new Categorie("Bronze", Double.parseDouble(tf_bronze.getText()), 1500, 1500, co);
        				cate3.creer();
        				Categorie cate4 = new Categorie("Diamant", Double.parseDouble(tf_diams.getText()), 1000, 1000, co);
        				cate4.creer();
        				
        				model.addElement(s);

        			}
        			else {
    					JOptionPane.showMessageDialog(null, "Veuillez renseigner tous les champs " + titre + " " + tf_places.getText() + " " + tf_libre.getText());		
        			}
        			break;
        			
        		}
        		
        	}
        });
        btnNewButton.setBounds(704, 580, 158, 23);
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel_1 = new JLabel("Places par client :");
        lblNewLabel_1.setBounds(10, 540, 104, 14);
        contentPane.add(lblNewLabel_1);
        
        JButton btn_repres = new JButton("Ajouter representation");
        btn_repres.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Spectacle spec = list.getSelectedValue();
        		if(spec != null) {
					JOptionPane.showMessageDialog(null, spec.getPlanningSalle().toString());	

        			AjouterRepresentationFrame frame = new AjouterRepresentationFrame(spec);
        			frame.setVisible(true);
        		}
        		else {
					JOptionPane.showMessageDialog(null, "Sélectionnez un spectacle");		
        		}
        		
        	}
        });
        btn_repres.setBounds(704, 8, 158, 23);
        contentPane.add(btn_repres);
        
        
        
	}
}
