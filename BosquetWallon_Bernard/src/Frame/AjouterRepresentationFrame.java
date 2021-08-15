package Frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import POJO.PlanningSalle;
import POJO.Representation;
import POJO.Spectacle;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.awt.event.ActionEvent;

public class AjouterRepresentationFrame extends JFrame {

	private JPanel contentPane;

	DefaultListModel<Representation> model2= new DefaultListModel<>();
	private List<Representation> representations;
	private JTextField tf_debutH;
	private JTextField tf_debutM;
	private JTextField tf_finH;
	private JTextField tf_finM;
	private JTextField tf_ouvH;
	private JTextField tf_ouvM;
	private JButton btnNewButton_1;
	
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
	public AjouterRepresentationFrame(Spectacle s) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 964, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList<Representation> list = new JList<Representation>();
		list.setBackground(Color.ORANGE);
		//list.setBounds(10, 11, 933, 251);
		list.setModel(model2);
		//contentPane.add(list);
		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 933, 251);
        contentPane.add(scrollPane);
        list.setModel(model2);
        scrollPane.setViewportView(list);
		
		JLabel lblNewLabel = new JLabel("Date representation : ");
		lblNewLabel.setBounds(10, 337, 137, 14);
		contentPane.add(lblNewLabel);
		representations = s.afficherRepresentation();
		if(representations != null)
		{
			for (Representation r : representations) {
				model2.addElement(r);					
				}
		}
		
		
		JDateChooser DateRepresentation = new JDateChooser();
		DateRepresentation.setBounds(157, 337, 146, 19);
		DateRepresentation.setSelectableDateRange(s.getPlanningSalle().getDateDebutReservation(), s.getPlanningSalle().getDateFinReservation());
		contentPane.add(DateRepresentation);
		
		JLabel lblNewLabel_1 = new JLabel("Heure debut : ");
		lblNewLabel_1.setBounds(10, 362, 137, 14);
		contentPane.add(lblNewLabel_1);
		
		tf_debutH = new JTextField();
		tf_debutH.setBounds(157, 359, 30, 20);
		contentPane.add(tf_debutH);
		tf_debutH.setColumns(10);
		
		tf_debutM = new JTextField();
		tf_debutM.setBounds(199, 359, 30, 20);
		contentPane.add(tf_debutM);
		tf_debutM.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Heure de fin : ");
		lblNewLabel_2.setBounds(10, 387, 137, 14);
		contentPane.add(lblNewLabel_2);
		
		tf_finH = new JTextField();
		tf_finH.setBounds(157, 384, 30, 20);
		contentPane.add(tf_finH);
		tf_finH.setColumns(10);
		
		tf_finM = new JTextField();
		tf_finM.setBounds(199, 384, 30, 20);
		contentPane.add(tf_finM);
		tf_finM.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Ouverture :");
		lblNewLabel_3.setBounds(10, 412, 137, 14);
		contentPane.add(lblNewLabel_3);
		
		tf_ouvH = new JTextField();
		tf_ouvH.setBounds(157, 409, 30, 20);
		contentPane.add(tf_ouvH);
		tf_ouvH.setColumns(10);
		
		tf_ouvM = new JTextField();
		tf_ouvM.setBounds(199, 409, 30, 20);
		contentPane.add(tf_ouvM);
		tf_ouvM.setColumns(10);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				Date d = new java.sql.Date(DateRepresentation.getDate().getTime());
				int heure1 = Integer.parseInt(tf_debutH.getText());
				int minute1 = Integer.parseInt(tf_debutM.getText());
				Timestamp heureDebut = new Timestamp(new java.util.Date(d.getYear(),d.getMonth(),d.getDate(),heure1,minute1).getTime());
				

				int heure2 = Integer.parseInt(tf_finH.getText());
				int minute2 = Integer.parseInt(tf_finM.getText());
				Timestamp heureFin = new Timestamp(new java.util.Date(d.getYear(),d.getMonth(),d.getDate(),heure2,minute2).getTime());
				

				int heure3 = Integer.parseInt(tf_ouvH.getText());
				int minute3 = Integer.parseInt(tf_ouvM.getText());
				Timestamp heureOuverture = new Timestamp(new java.util.Date(d.getYear(),d.getMonth(),d.getDate(),heure3,minute3).getTime());
				if((0<=heure1&&heure1<=23)&&(0<=heure2&&heure2<=23)&&(0<=heure3&&heure3<=23)&&(0<=minute1&&minute1<=59)&&(0<=minute2&&minute2<=59)&&(0<=minute3&&minute3<=59))
				{
					Representation r = new Representation((java.sql.Date)d, s, heureDebut, heureFin, heureOuverture);
					if(r.verifierHeure(s.getPlanningSalle()))
					{
						r.creer();
						tf_debutH.setText(null);
						tf_finH.setText(null);
						tf_ouvH.setText(null);
						tf_debutM.setText(null);
						tf_finM.setText(null);
						tf_ouvM.setText(null);
						JOptionPane.showMessageDialog(null, "Ajout avec succès");
					}
					else
						JOptionPane.showMessageDialog(null, "Les heures choisies sont en dehors de la r�servation de la salle");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Veuillez ins�rer une heure correcte");
					tf_debutH.setText(null);
					tf_finH.setText(null);
					tf_ouvH.setText(null);
					tf_debutM.setText(null);
					tf_finM.setText(null);
					tf_ouvM.setText(null);
				}
			}
				
			
		});
		btnNewButton.setBounds(10, 437, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		btnNewButton_1.setBounds(849, 437, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
