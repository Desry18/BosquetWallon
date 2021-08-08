package POJO;

import java.util.List;

import DAO.AbstractDAOFactory;
import DAO.DAO;

public class Gestionnaire extends Personne{
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Gestionnaire> gestionnaireDAO = adf.getGestionnaireDAO();
	
	private List<PlanningSalle> planningSalle;

	public List<PlanningSalle> getPlanningSalle() {
		return planningSalle;
	}

	public void setPlanningSalle(List<PlanningSalle> planningSalle) {
		this.planningSalle = planningSalle;
	}
	
	
}
