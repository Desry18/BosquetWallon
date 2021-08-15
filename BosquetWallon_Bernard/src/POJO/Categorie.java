package POJO;

import java.util.List;

import DAO.AbstractDAOFactory;
import DAO.DAO;

public class Categorie {
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Categorie> categorieDAO = adf.getCategorieDAO();
	
	private String type;
	private double prix;
	private int nbrPlaceDispo;
	private int nbrPlaceMax;
	private int IdCategorie;
	private Configuration config;
	public int getIdCategorie() {
		return IdCategorie;
	}
	public void setIdCategorie(int idCategorie) {
		IdCategorie = idCategorie;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getNbrPlaceDispo() {
		return nbrPlaceDispo;
	}
	public void setNbrPlaceDispo(int nbrPlaceDispo) {
		this.nbrPlaceDispo = nbrPlaceDispo;
	}
	public int getNbrPlaceMax() {
		return nbrPlaceMax;
	}
	public void setNbrPlaceMax(int nbrPlaceMax) {
		this.nbrPlaceMax = nbrPlaceMax;
	}
	public Categorie(String type, double prix, int nbrPlaceDispo, int nbrPlaceMax) {
		this.type = type;
		this.prix = prix;
		this.nbrPlaceDispo = nbrPlaceDispo;
		this.nbrPlaceMax = nbrPlaceMax;
	}
	public Categorie(String type, double prix, int nbrPlaceDispo, int nbrPlaceMax, int idCategorie) {
		this.type = type;
		this.prix = prix;
		this.nbrPlaceDispo = nbrPlaceDispo;
		this.nbrPlaceMax = nbrPlaceMax;
		IdCategorie = idCategorie;
	}
	public Categorie() {
	}
	public Categorie(String string, double prix2, int i, int j, Configuration co) {
		type = string;
		prix = prix2;
		nbrPlaceDispo = i;
		nbrPlaceMax = j;
		config = co;
	}
	@Override
	public String toString() {
		return "Categorie [type=" + type + ", prix=" + prix + ", nbrPlaceDispo=" + nbrPlaceDispo + ", nbrPlaceMax="
				+ nbrPlaceMax + "]";
	}
	/*public void ajouterCategorie(Configuration configuration)
	{
		categorieDAO.create(this);
		((CategorieDAO)categorieDAO).ajouterConfiguration(configuration.getId());
	}
	public void diminuerNombreDePlace()
	{
		categorieDAO.update(this);
	}*/
	public List<Categorie> findAll(int id) {
		return categorieDAO.findAll(id);
	}
	public Configuration getConfig() {
		return config;
	}
	public void setConfig(Configuration config) {
		this.config = config;
	}
	public boolean creer() {
		return categorieDAO.create(this);
	}
	
}
