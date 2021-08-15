package Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import POJO.Organisateur;
import POJO.Reservation;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.ListSelectionModel;

public class AccueilOrga extends JFrame {

	private JPanel contentPane;
	DefaultListModel<Reservation> model= new DefaultListModel<>();
    private List<Reservation> reservations;

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
	public AccueilOrga(Organisateur p) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 922, 614);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Organisateur : " + p.getPrenom() + " " + p.getNom());
		lblNewLabel.setBounds(10, 11, 256, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Reserver Salle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlanningFrame frame = new PlanningFrame(p);
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(714, 541, 182, 23);
		contentPane.add(btnNewButton);
		
		JList<Reservation> list = new JList<Reservation>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBackground(Color.ORANGE);
        list.setBounds(10, 111, 720, 407);
        contentPane.add(list);
        list.setModel(model);
       
        reservations = p.afficherReservations();
        if(reservations != null) {
        	for(Reservation r : reservations){
        		model.addElement(r);
        	}
        }
        
        
        JButton btn_spec = new JButton("AjouterSpectacle");
        btn_spec.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Reservation r = list.getSelectedValue();
        		if (r != null) {
        			AjouterSpectacleFrame frame = new AjouterSpectacleFrame(r, p);
        			frame.setVisible(true);
        		}
        	}
        });
        btn_spec.setBounds(740, 111, 156, 23);
        contentPane.add(btn_spec);
		
	}
}
