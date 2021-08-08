package POJO;

import DAO.AbstractDAOFactory;
import DAO.DAO;

public class Artiste extends Personne{
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Artiste> artisteDAO = adf.getArtisteDAO();
	public Artiste() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
