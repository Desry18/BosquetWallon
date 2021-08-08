package POJO;

import java.util.List;

import DAO.AbstractDAOFactory;
import DAO.DAO;

public class Configuration {

	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Configuration> configurationDAO = adf.getConfigurationDAO();
	
	private String type;
	private String description;
	private List<Categorie> categorie;
	private int Id;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Categorie> getCategorie() {
		return categorie;
	}
	public void setCategorie(List<Categorie> categorie) {
		this.categorie = categorie;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	
}
