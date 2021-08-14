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

public class AccueilArtiste extends JFrame {

	private JPanel contentPane;
	
	private List<Spectacle> spectacles;
	JList<Spectacle> list = new JList<>();
	DefaultListModel<Spectacle> model= new DefaultListModel<>();
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		p.getAllSpectacle();
		
		JLabel lblNewLabel = new JLabel("Artiste : " + p.getPrenom() + " " + p.getNom());
		lblNewLabel.setBounds(10, 11, 202, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(p.getSpectacles().get(0).getTitre());
		lblNewLabel_1.setBounds(10, 36, 340, 22);
		contentPane.add(lblNewLabel_1);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		list.setModel(model);
		//panel.add(label);
		spectacles = p.getSpectacles();
		for(int i = 0; i < spectacles.size(); i++){
			model.addElement(spectacles.get(i));
		}
		
		/*list.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				Spectacle s = list.getSelectedValue();
				lblNewLabel_1.setText("Ici je fous les données de représentation pour " + s.getIdSpectacle());
			}
		});
		*/
		list.setBounds(10, 69, 208, 169);
		contentPane.add(list);
		
		JButton btn_rep = new JButton("Afficher les représentations");
		btn_rep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Spectacle s = list.getSelectedValue();
				lblNewLabel_1.setText(s.getIdSpectacle() +"");
				RepresentationArtiste frame = new RepresentationArtiste(s);
				frame.setVisible(true);
			}
		});
		btn_rep.setToolTipText("");
		btn_rep.setBounds(240, 66, 184, 58);
		contentPane.add(btn_rep);
		
		
	}
}
