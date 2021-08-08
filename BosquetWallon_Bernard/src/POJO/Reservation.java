package POJO;

import DAO.AbstractDAOFactory;
import DAO.DAO;

public class Reservation {

	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Reservation> reservationDAO = adf.getReservationDAO();
	
	private double accompte;
	private double solde;
	private String statut;
	private double prix;
	private PlanningSalle planningSalle;
	public double getAccompte() {
		return accompte;
	}
	public void setAccompte(double accompte) {
		this.accompte = accompte;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public PlanningSalle getPlanningSalle() {
		return planningSalle;
	}
	public void setPlanningSalle(PlanningSalle planningSalle) {
		this.planningSalle = planningSalle;
	}
	
}
