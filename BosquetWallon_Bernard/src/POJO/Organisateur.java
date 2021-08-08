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
	
	
	
	
}
