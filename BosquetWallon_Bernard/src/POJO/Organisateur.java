package POJO;

import java.util.List;

import DAO.AbstractDAOFactory;
import DAO.DAO;

public class Organisateur extends Personne{
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Organisateur> organisateurDAO = adf.getOrganisateurDAO();
	
	private List<Reservation> reservations;

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Organisateur(String nom, String prenom, String email, String adresse, String mdp, int id) {
		super(nom, prenom, email, adresse, mdp, id);
		// TODO Auto-generated constructor stub
	}

	public Organisateur(String nom, String prenom, String email, String adresse, String mdp) {
		super(nom, prenom, email, adresse, mdp);
		// TODO Auto-generated constructor stub
	}
	
	public Organisateur() {
		
	}
	
	public List<Reservation> afficherReservations(){
		Reservation r = new Reservation();
		return r.findAll(this);
		
	}

	public boolean creerPlanning(PlanningSalle planning) {
		return planning.creer();
	}

	public boolean creerReservation(Reservation r) {
		return r.creer();
		
	}

	public boolean creerSpectacle(Spectacle s) {
		return s.creer();
	}

	public boolean creerConfig(Configuration co) {
		return co.creer();
	}

	public boolean creerCategorie(Categorie cate) {
		return cate.creer();
	}
	
}
