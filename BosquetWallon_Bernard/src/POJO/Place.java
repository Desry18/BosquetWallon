package POJO;

import DAO.AbstractDAOFactory;
import DAO.DAO;

public class Place {
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Place> placeDAO = adf.getPlaceDAO();
	
	private int numPlace;
	private double prix;
	private Representation representation;
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
	
	
}
