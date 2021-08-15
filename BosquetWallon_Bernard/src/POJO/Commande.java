package POJO;

import java.util.List;

import DAO.AbstractDAOFactory;
import DAO.DAO;

public class Commande {

	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Commande> commandeDAO = adf.getCommandeDAO();
	
	private String modePayement;
	private String modeLivraison;
	private double cout;
	private List<Place> places;
	private Client c;
	private int IdCommande;
	
	
	
	public Commande(double somme, String payement, String livraison, Client p) {
		cout = somme;
		modePayement = payement;
		modeLivraison = livraison;
		c = p;
		
	}
	public Commande() {
		// TODO Auto-generated constructor stub
	}
	public Commande(int id, String Payement, String Livraison, double somme) {
		IdCommande = id;
		modePayement = Payement;
		modeLivraison = Livraison;
		cout = somme;
	}
	
	public Client getC() {
		return c;
	}
	public void setC(Client c) {
		this.c = c;
	}
	public String getModePayement() {
		return modePayement;
	}
	public void setModePayement(String modePayement) {
		this.modePayement = modePayement;
	}
	public String getModeLivraison() {
		return modeLivraison;
	}
	public void setModeLivraison(String modeLivraison) {
		this.modeLivraison = modeLivraison;
	}
	public double getCout() {
		return cout;
	}
	public void setCout(double cout) {
		this.cout = cout;
	}
	public List<Place> getPlaces() {
		return places;
	}
	public void setPlaces(List<Place> places) {
		this.places = places;
	}
	
	
	@Override
	public String toString() {
		return "Commande [modePayement=" + modePayement + ", modeLivraison=" + modeLivraison + ", cout=" + cout
				+ ", places=" + places + "]";
	}
	
	public boolean creer(Commande c2) {
		return commandeDAO.create(c2);
		
	}
	public int getIdCommande() {
		return IdCommande;
	}
	public void setIdCommande(int idCommande) {
		IdCommande = idCommande;
	}
	
	public Commande find() {
		return commandeDAO.find(this);
	}
	
}
