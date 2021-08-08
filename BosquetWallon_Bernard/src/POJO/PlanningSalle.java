package POJO;

import java.util.Date;
import java.util.List;

import DAO.AbstractDAOFactory;
import DAO.DAO;

public class PlanningSalle {
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<PlanningSalle> planningSalleDAO = adf.getPlanningSalleDAO();

	private int id;
	private Date dateDebutReservation;
	private Date dateFinReservation;
	private List<Spectacle> spectacle;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDateDebutReservation() {
		return dateDebutReservation;
	}
	public void setDateDebutReservation(Date dateDebutReservation) {
		this.dateDebutReservation = dateDebutReservation;
	}
	public Date getDateFinReservation() {
		return dateFinReservation;
	}
	public void setDateFinReservation(Date dateFinReservation) {
		this.dateFinReservation = dateFinReservation;
	}
	public List<Spectacle> getSpectacle() {
		return spectacle;
	}
	public void setSpectacle(List<Spectacle> spectacle) {
		this.spectacle = spectacle;
	}
	
	
}
