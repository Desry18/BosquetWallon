package POJO;

import DAO.AbstractDAOFactory;
import DAO.DAO;

public class Client extends Personne{
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Client> clientDAO = adf.getClientDAO();
	
	public Client(String nom, String prenom, String email, String adresse, String mdp, int id) {
		super(nom, prenom, email, adresse, mdp, id);
		// TODO Auto-generated constructor stub
	}

	public Client() {
		// TODO Auto-generated constructor stub
	}

	public Client(String nom, String prenom, String email, String adresse, String mdp) {
		super(nom, prenom, email, adresse, mdp);
		// TODO Auto-generated constructor stub
	}
	
	
}
