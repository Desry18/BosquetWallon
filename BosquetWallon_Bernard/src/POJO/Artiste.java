package POJO;

import DAO.AbstractDAOFactory;
import DAO.DAO;

public class Artiste extends Personne{
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Artiste> artisteDAO = adf.getArtisteDAO();
	
	public Artiste(String nom, String prenom, String email, String adresse, String mdp, int id) {
		super(nom, prenom, email, adresse, mdp, id);
		// TODO Auto-generated constructor stub
	}
	
	

	public Artiste(String nom, String prenom, String email, String adresse, String mdp) {
		super(nom, prenom, email, adresse, mdp);
		// TODO Auto-generated constructor stub
	}



	public Artiste() {
		// TODO Auto-generated constructor stub
	}


	
	@Override
	public String toString() {
		return "Artiste [personneDAO=" + personneDAO + ", Nom=" + Nom + ", Prenom=" + Prenom + ", Email=" + Email
				+ ", Adresse=" + Adresse + ", Mdp=" + Mdp + ", Id=" + Id + "]";
	}

}
