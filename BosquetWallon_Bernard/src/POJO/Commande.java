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
	
}
