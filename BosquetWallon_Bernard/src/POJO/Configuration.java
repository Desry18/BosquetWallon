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
	private Spectacle s;
	public Configuration(String Type, String Description, int id) {
		type = Type;
		description = Description;
		Id = id;
	}
	public Configuration() {
		// TODO Auto-generated constructor stub
	}
	public Configuration(String type2, String desc, Spectacle s1) {
		type = type2;
		description = desc;
		s = s1;
		
	}
	public Configuration(String type2, String desc, Spectacle s1, int int1) {
		type = type2;
		description = desc;
		s = s1;
		Id = int1;
	}
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
	public List<Configuration> findAll(int idSpectacle) {
		return configurationDAO.findAll(idSpectacle);
	}
	@Override
	public String toString() {
		return "type=" + type + ", description=" + description + ", categorie=" + categorie + ", Id="
				+ Id ;
	}
	
	public List<Categorie> afficherCat(){
		Categorie c = new Categorie();
		return c.findAll(this.Id);
	}
	public Spectacle getS() {
		return s;
	}
	public void setS(Spectacle s) {
		this.s = s;
	}
	public boolean creer() {
		return configurationDAO.create(this);
	}
	public Configuration find() {
		// TODO Auto-generated method stub
		return configurationDAO.find(this);
	}
	
	
	
	
}
