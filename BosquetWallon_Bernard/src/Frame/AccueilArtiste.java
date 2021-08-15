package Frame;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import POJO.Artiste;
import POJO.Representation;
import POJO.Spectacle;

import javax.swing.JLabel;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.util.List;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AccueilArtiste extends JFrame {

	private JPanel contentPane;
	
	private List<Spectacle> spectacles;
	JList<Spectacle> list = new JList<>();
	DefaultListModel<Spectacle> model= new DefaultListModel<>();
	private List<Representation> representations;
	JList<Representation> list2 = new JList<>();
	DefaultListModel<Representation> model2= new DefaultListModel<>();
	
	JLabel label = new JLabel();
	JPanel panel = new JPanel();
	JSplitPane splitPane = new JSplitPane();
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
	public AccueilArtiste(Artiste p) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		p.getAllSpectacle();
		
		JLabel lblNewLabel = new JLabel("Artiste : " + p.getPrenom() + " " + p.getNom());
		lblNewLabel.setBounds(10, 11, 202, 14);
		contentPane.add(lblNewLabel);
		
		
		list.setBackground(Color.ORANGE);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		list.setModel(model);
		list2.setBackground(Color.ORANGE);
		list2.setModel(model2);
		spectacles = p.getSpectacles();
		for(int i = 0; i < spectacles.size(); i++){
			model.addElement(spectacles.get(i));
		}
		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 69, 217, 130);
        contentPane.add(scrollPane);
        scrollPane.setViewportView(list);
        
        JScrollPane scrollPane2 = new JScrollPane();
        scrollPane2.setBounds(237, 69, 217, 130);
        contentPane.add(scrollPane2);
        scrollPane2.setViewportView(list2);

		
		
		list.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				Spectacle s = list.getSelectedValue();
				representations = s.afficherRepresentation();
				for (Representation r : representations) {
					model2.addElement(r);
				}
			}
		});
		
		
		
		
	
		
		JButton btnNewButton = new JButton("Deconnexion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConnexionFrame frame = new ConnexionFrame();
        		dispose();
        		frame.setVisible(true);
			}
			
		});
		btnNewButton.setBounds(279, 227, 145, 23);
		contentPane.add(btnNewButton);
		
		
		
	}
}
