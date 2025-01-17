package Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;

import POJO.Organisateur;
import POJO.PlanningSalle;
import POJO.Reservation;
import javax.swing.JTextField;

public class PlanningFrame extends JFrame {

	private JPanel contentPane;
	Date dateDebut = null;
	Date dateFin = null;
	private JTextField tf_acc;
	Reservation r = new Reservation();
	PlanningSalle planning = new PlanningSalle();
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
	public PlanningFrame(Organisateur o) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(10, 10, 220, 160);
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	    contentPane.setLayout(null);
	    contentPane.add(calendar);
	    
	    JLabel LblDateDebut = new JLabel("Debut");
		LblDateDebut.setBounds(145, 181, 85, 13);
		contentPane.add(LblDateDebut);

		JLabel LblDateFin = new JLabel("Fin");
		LblDateFin.setBounds(145, 202, 85, 13);
		contentPane.add(LblDateFin);
		
		JButton btn_date = new JButton("Valider Dates");
		btn_date.setBounds(10, 268, 125, 23);
		contentPane.add(btn_date);
		btn_date.setVisible(false);
		
		
		JButton BtnValider = new JButton("Valider la date de d\u00E9but");
		BtnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (dateDebut == null) {
					dateDebut = new java.sql.Date(calendar.getDate().getTime());
					java.sql.Date now = new java.sql.Date(Calendar.getInstance().getTime().getTime());
					if(dateDebut.before(now))
					{
						dateDebut = null;
					}
					else
					{
						LblDateDebut.setText(dateFormat.format(dateDebut));
					}
				}
				if (dateFin == null && dateDebut!=null) 
				{	
					BtnValider.setText("Valider la date de fin");
					dateFin = new java.sql.Date(calendar.getDate().getTime());
					if(dateDebut.after(dateFin) || dateFin.equals(dateDebut))
					{
						dateFin = null;
					}
					else
					{

						LblDateFin.setText(dateFormat.format(dateFin));
						BtnValider.setVisible(false);
						btn_date.setVisible(true);

					}
				}
			}

		});
		BtnValider.setBounds(10, 236, 200, 21);
		contentPane.add(BtnValider);
		
		JLabel lblNewLabel = new JLabel("Date d�but : ");
		lblNewLabel.setBounds(10, 181, 125, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Date fin : ");
		lblNewLabel_1.setBounds(10, 201, 125, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Prix : ");
		lblNewLabel_2.setBounds(10, 302, 46, 14);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setVisible(false);
		
		JLabel lbl_prix = new JLabel("");
		lbl_prix.setBounds(101, 302, 46, 14);
		contentPane.add(lbl_prix);
		lbl_prix.setVisible(false);

		
		JLabel lbl_acc = new JLabel("Accompte : ");
		lbl_acc.setBounds(216, 302, 84, 14);
		contentPane.add(lbl_acc);
		
		tf_acc = new JTextField();
		tf_acc.setBounds(310, 299, 86, 20);
		contentPane.add(tf_acc);
		tf_acc.setColumns(10);
		
		JButton btn_acc = new JButton("Valider Accompte");
		btn_acc.setBounds(406, 298, 143, 23);
		contentPane.add(btn_acc);
		
		
		
		JButton btn_resa = new JButton("Confirmer Reservation");
		btn_resa.setBounds(10, 358, 200, 23);
		contentPane.add(btn_resa);
		btn_resa.setVisible(false);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccueilOrga frame = new AccueilOrga(o);
				dispose();
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(460, 358, 89, 23);
		contentPane.add(btnNewButton);
		
		
		btn_date.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				planning.setDateDebutReservation((java.sql.Date)dateDebut);
				planning.setDateFinReservation((java.sql.Date)dateFin);
				if(planning.verifDates()) {
					//ReservationFrame frame = new ReservationFrame(o, planning);
					//frame.setVisible(true);
					r.setPlanningSalle(planning);
					r.setO(o);
					r.calculerPrix();
					lbl_prix.setText(r.getPrix() + "");
					lblNewLabel_2.setVisible(true);
					lbl_prix.setVisible(true);
					btn_resa.setVisible(true);
					// Accompte etc a afficher en true puis nouveau bouton pour cr�er mes objets.
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Les dates s�lectionn�es sont d�j� r�serv�es ! ");
					dateDebut = null;
					dateFin=null;
					BtnValider.setVisible(true);
					btn_date.setVisible(false);
					LblDateDebut.setText("");
					LblDateFin.setText("");
					

				}

				
			}
		});
		btn_acc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Integer.parseInt(tf_acc.getText()) > r.getPrix()) {
					JOptionPane.showMessageDialog(null, "L'accompte est sup�rieur au prix total");
					
				}
				else {
					r.addAccompte(Integer.parseInt(tf_acc.getText()));
					JOptionPane.showMessageDialog(null, "Accompte accept�");
					lbl_acc.setVisible(false);
					tf_acc.setVisible(false);

					
				}
			}
		});
		
		btn_resa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r.confResa();
				o.creerPlanning(planning);
				planning = planning.find();
				r.setPlanningSalle(planning);
				o.creerReservation(r);
				JOptionPane.showMessageDialog(null, "r�servation cr��e");
						

			}
		});
		
	}
}
