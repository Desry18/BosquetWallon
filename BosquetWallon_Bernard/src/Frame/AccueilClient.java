package Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import POJO.Client;
import POJO.Representation;
import POJO.Spectacle;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccueilClient extends JFrame {

	private JPanel contentPane;
	
	DefaultListModel<Spectacle> model= new DefaultListModel<>();
	private List<Spectacle> spectacles;
	
	DefaultListModel<Representation> model2= new DefaultListModel<>();
	private List<Representation> representations;
	
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
	public AccueilClient(Client p) {
	
		setTitle("Client");
		setBackground(Color.PINK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 909, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Client : " + p.getPrenom() + " " + p.getNom());
		lblNewLabel.setBounds(10, 11, 199, 14);
		contentPane.add(lblNewLabel);
		
		JList<Spectacle> list = new JList<Spectacle>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBackground(Color.ORANGE);
		
		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 111, 340, 238);
        contentPane.add(scrollPane);
        scrollPane.setViewportView(list);
		
		JList<Representation> list_1 = new JList<Representation>();
		list_1.setBackground(Color.ORANGE);
		
		JScrollPane scrollPane2 = new JScrollPane();
        scrollPane2.setBounds(367, 111, 510, 238);
        contentPane.add(scrollPane2);
        scrollPane2.setViewportView(list_1);
		
		list.setModel(model);
		spectacles = p.getSpectacle();
		
		list_1.setModel(model2);
		
		
		for(int i = 0; i < spectacles.size(); i++){
			model.addElement(spectacles.get(i));
		
		}
		
		 list.getSelectionModel().addListSelectionListener(new ListSelectionListener() {			
			public void valueChanged(ListSelectionEvent e) {
				model2.clear();
				Spectacle s = list.getSelectedValue();
				representations = s.afficherRepresentation();
				if(representations != null)
				{
					for (Representation r : representations) {
						model2.addElement(r);					
						}
				}
			}
		});
	
		
		
		JLabel lblNewLabel_1 = new JLabel("Spectacles : ");
		lblNewLabel_1.setBounds(10, 47, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Représentations :");
		lblNewLabel_2.setBounds(367, 47, 151, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Titre");
		lblNewLabel_3.setBackground(Color.CYAN);
		lblNewLabel_3.setBounds(10, 90, 90, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Places Disponibles");
		lblNewLabel_4.setBackground(Color.CYAN);
		lblNewLabel_4.setBounds(100, 90, 109, 20);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Heure Debut");
		lblNewLabel_5.setBounds(438, 90, 89, 20);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Heure Fin");
		lblNewLabel_6.setBounds(581, 90, 55, 20);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Date");
		lblNewLabel_7.setBounds(367, 90, 46, 20);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Heure Ouverture");
		lblNewLabel_8.setBounds(705, 90, 134, 20);
		contentPane.add(lblNewLabel_8);
		
		JButton btnNewButton = new JButton("Continuer");
		btnNewButton.setBounds(726, 360, 151, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Deconnexion");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConnexionFrame frame = new ConnexionFrame();
        		dispose();
        		frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(726, 394, 151, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Spectacle s = list.getSelectedValue();
				Representation r = list_1.getSelectedValue();
				if(r != null && s != null) {
					ConfigurationFrame frame = new ConfigurationFrame(r,s, p);
					frame.setVisible(true);
				}
			}
		});
	}
}