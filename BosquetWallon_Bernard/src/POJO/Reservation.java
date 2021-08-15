package POJO;

import java.util.Date;
import java.util.List;

import DAO.AbstractDAOFactory;
import DAO.DAO;

public class Reservation {

	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Reservation> reservationDAO = adf.getReservationDAO();
	
	private int id;
	private double accompte;
	private double solde;
	private String statut;
	private double prix;
	private PlanningSalle planningSalle;
	private Organisateur o;
	
	public Reservation(PlanningSalle planning, Organisateur orga) {
		planningSalle = planning;
		setO(orga);
		
	}
	public Reservation() {
		// TODO Auto-generated constructor stub
	}
	public Reservation(int int1, double double1, PlanningSalle planningSalle2, Organisateur organisateur, String string,
			double double2, double double3) {
		id = int1;
		planningSalle = planningSalle2;
		o = organisateur;
		solde = double1;
		statut = string;
		accompte = double2;
		prix = double3;
		
	}
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
	
	@SuppressWarnings("deprecation")
	public void calculerPrix() {
			int cpt=0;
			Date date=new Date();
			date=this.planningSalle.getDateDebutReservation();
			do
			{
				if(date.getDay()-1>=0 && date.getDay()-1<5)
				{
					this.prix+=3000;
				}
				else
				{
					this.prix+=4500;
				}
				date.setDate(date.getDate()+1);
				cpt++;
			}
			while(date.before(this.planningSalle.getDateFinReservation()));
			date.setDate(date.getDate()-cpt);
			if(cpt==2)
				this.prix*=0.95;
			else if(cpt>=3 && cpt<7)
				this.prix*=0.9;
			else if(cpt>=7 && cpt<15)
				this.prix*=0.80;
			else if(cpt>=15)
				this.prix*=0.7;
			
			this.solde = this.prix;	
		}
	public Organisateur getO() {
		return o;
	}
	public void setO(Organisateur o) {
		this.o = o;
	}
	public void addAccompte(int acc) {
		this.accompte = acc;
		this.solde-= acc;
		}
	
	@Override
	public String toString() {
		return "Reservation [accompte=" + accompte + ", solde=" + solde + ", statut=" + statut + ", prix=" + prix
				+ ", planningSalle=" + planningSalle + ", o=" + o + "]";
	}
	public void confResa() {
		if (this.solde > 0 ) {
			this.statut = "A payer";
		}
		else {
			this.statut = "Payé" ;
		}
		
	}
	public boolean creer() {
		return reservationDAO.create(this);
	}
	public List<Reservation> findAll(Object obj) {
		// TODO Auto-generated method stub
		return reservationDAO.findAll(obj);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Spectacle> afficherSpectacle() {
		Spectacle s = new Spectacle();
		return s.getAll(this.planningSalle.getId());
	}
	
	
	}
	

