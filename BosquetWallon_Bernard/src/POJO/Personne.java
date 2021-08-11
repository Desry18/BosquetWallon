package POJO;

import DAO.AbstractDAOFactory;
import DAO.DAO;

public abstract class Personne {
	
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Personne> personneDAO = adf.getPersonneDAO();
	
	protected String Nom;
	protected String Prenom;
	protected String Email;
	protected String Adresse;
	protected String Mdp;
	protected int Id;
	
	
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getAdresse() {
		return Adresse;
	}
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}
	public String getMdp() {
		return Mdp;
	}
	public void setMdp(String mdp) {
		Mdp = mdp;
	}
	public Personne(String nom, String prenom, String adresse, String email, String mdp, int id) {
		super();
		Nom = nom;
		Prenom = prenom;
		Email = email;
		Adresse = adresse;
		Mdp = mdp;
		Id = id;
	}
	
	
	public Personne() {
		// TODO Auto-generated constructor stub
	}
	public Personne find()
	{
		return personneDAO.find(this.Email);
	}
	
	public Personne find(int i)
	{
		return personneDAO.find(i);
	}
	
	
	public boolean verifierMotDePasse(String mdp)
	{
		return this.getMdp().equals(mdp);
	}
	
}
