package POJO;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import DAO.AbstractDAOFactory;
import DAO.DAO;

public class Representation {
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Representation> representationDAO = adf.getRepresentationDAO();

	private Date date;
	private Spectacle spectacle;
	private Date heureDebut;
	private Date heureFin;
	private Date heureOuverture;
	private int IdRepresentation;
	
	public Representation(Timestamp Debut, Timestamp Fin, java.sql.Date Date, int id,
			Timestamp Ouverture) {
			date = Date; 
			heureDebut = Debut;
			heureFin = Fin;
			heureOuverture = Ouverture;
			IdRepresentation = id;
	}
	public Representation() {
		// TODO Auto-generated constructor stub
	}
	public Representation(java.sql.Date d, Spectacle s, Timestamp Debut, Timestamp Fin,
			Timestamp Ouverture) {
		date = d; 
		heureDebut = Debut;
		heureFin = Fin;
		heureOuverture = Ouverture;	
		spectacle = s;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Spectacle getSpectacle() {
		return spectacle;
	}
	public void setSpectacle(Spectacle spectacle) {
		this.spectacle = spectacle;
	}
	public Date getHeureDebut() {
		return heureDebut;
	}
	public void setHeureDebut(Date heureDebut) {
		this.heureDebut = heureDebut;
	}
	public Date getHeureFin() {
		return heureFin;
	}
	public void setHeureFin(Date heureFin) {
		this.heureFin = heureFin;
	}
	public Date getHeureOuverture() {
		return heureOuverture;
	}
	public void setHeureOuverture(Date heureOuverture) {
		this.heureOuverture = heureOuverture;
	}
	public int getIdRepresentation() {
		return IdRepresentation;
	}
	public void setIdRepresentation(int idRepresentation) {
		IdRepresentation = idRepresentation;
	}
	public List<Representation> find(int idSpectacle) {
		return representationDAO.findAll(idSpectacle);
	}
	@Override
	public String toString() {
		return date + " || " + heureDebut + " || " + heureFin + " || " + heureOuverture;
	}
	public boolean verifierHeure(PlanningSalle ps) {
		{
			
			if(this.heureOuverture.before(this.heureDebut))
			{
				if(this.heureDebut.before(this.heureFin))
				{
					if(this.heureOuverture.after(ps.getDateDebutReservation()))
					{
						if(this.heureFin.before(ps.getDateFinReservation()))
							return true;
						else
							return false;
					}
					else
						return false;
				}
				else
					return false;
			}
			else
				return false;
		}
	}
	public boolean creer() {
		return representationDAO.create(this);
	}
	
	
	
	
	
}
