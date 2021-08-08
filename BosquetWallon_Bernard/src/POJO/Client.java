package POJO;

import DAO.AbstractDAOFactory;
import DAO.DAO;

public class Client {
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Client> clientDAO = adf.getClientDAO();
}
