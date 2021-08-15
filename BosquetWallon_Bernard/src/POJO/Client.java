package POJO;

import java.util.List;

import DAO.AbstractDAOFactory;
import DAO.DAO;

public class Client extends Personne{
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Client> clientDAO = adf.getClientDAO();
	private List<Commande> commandes;

	
	public Client(String nom, String prenom, String email, String adresse, String mdp, int id) {
		super(nom, prenom, email, adresse, mdp, id);
		// TODO Auto-generated constructor stub
	}

	public Client() {
		// TODO Auto-generated constructor stub
	}

	public Client(String nom, String prenom, String email, String adresse, String mdp) {
		super(nom, prenom, email, adresse, mdp);
		// TODO Auto-generated constructor stub
	}
	
	public List<Spectacle> getSpectacle(){
		Spectacle s = new Spectacle();
		return s.getAll();
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public boolean creerCommande(Commande c) {
		return c.creer(c);
		
	}

	public boolean creerPlaces(Place place) {
		return place.creer();
	}
	
	
}
