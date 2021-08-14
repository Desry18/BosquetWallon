package Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import POJO.Organisateur;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccueilOrga extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 450, 300);
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
		btnNewButton.setBounds(242, 227, 182, 23);
		contentPane.add(btnNewButton);
	}
}
