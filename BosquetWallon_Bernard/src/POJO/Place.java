package POJO;

import DAO.AbstractDAOFactory;
import DAO.DAO;

public class Place {
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Place> placeDAO = adf.getPlaceDAO();
	
	private int numPlace;
	private double prix;
	private Representation representation;
	private Commande commande;
	public Place(Representation r, double prix2) {
		prix = prix2;
		representation = r;
	}
	public int getNumPlace() {
		return numPlace;
	}
	public void setNumPlace(int numPlace) {
		this.numPlace = numPlace;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Representation getRepresentation() {
		return representation;
	}
	public void setRepresentation(Representation representation) {
		this.representation = representation;
	}
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	
	public boolean creer() {
		return placeDAO.create(this);
	}
	
}
