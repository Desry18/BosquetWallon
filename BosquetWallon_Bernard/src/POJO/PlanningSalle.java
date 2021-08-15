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
	
	
	public PlanningSalle(java.sql.Date dateDebut, java.sql.Date dateFin) {
		dateDebutReservation = dateDebut;
		dateFinReservation = dateFin;
	}
	public PlanningSalle(java.sql.Date date, java.sql.Date date2, int Id) {
		dateDebutReservation = date;
		dateFinReservation = date2;
		id = Id;
	}
	
	public PlanningSalle() {
		// TODO Auto-generated constructor stub
	}
	public PlanningSalle(int int1, java.sql.Date date, java.sql.Date date2) {
		id = int1;
		dateDebutReservation = date;
		dateFinReservation = date2;
	}
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
	
	
	@SuppressWarnings("deprecation")
	public boolean verifDates() {
		List<PlanningSalle> liste = planningSalleDAO.getAll();
		boolean verif = false;
		if(liste.size()==0)
		{
			return true;
		}
		else
		{
			for(var planning : liste)
			{
				Date dateDebut = new Date(planning.dateDebutReservation.getYear(),planning.dateDebutReservation.getMonth(),planning.dateDebutReservation.getDate());
				Date dateFin = new Date(planning.dateFinReservation.getYear(),planning.dateFinReservation.getMonth(),planning.dateFinReservation.getDate());
				Date thisDateDebut = new Date(this.dateDebutReservation.getYear(),this.dateDebutReservation.getMonth(),this.dateDebutReservation.getDate());
				Date thisDateFin = new Date(this.dateFinReservation.getYear(),this.dateFinReservation.getMonth(),this.dateFinReservation.getDate());
				
				long debut = dateDebut.getTime();
				long fin = dateFin.getTime();
				long thisDebut = thisDateDebut.getTime();
				long thisFin = thisDateFin.getTime();
				
				if((thisDebut > debut && thisDebut < fin) || (thisFin > debut && thisFin < fin)||(thisDebut < debut && thisFin > fin))
				{
						return false;
				}
				else
				{
					if(thisDebut==debut && thisFin==fin)
					{
						return false;
					}
					else
					{
						verif = true;
					}
				}
			}
		}
		return verif;
	}
	public boolean creer() {
		return planningSalleDAO.create(this);
	}
	public PlanningSalle find() {
		// TODO Auto-generated method stub
		return planningSalleDAO.find(this);
	}
	
	
}
