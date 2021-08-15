package POJO;

import java.util.List;

import DAO.AbstractDAOFactory;
import DAO.DAO;

public class Spectacle {
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Spectacle> spectacleDAO = adf.getSpectacleDAO();

	private String titre;
	private List<Artiste> Artistes;
	private int nbrPlaceParClient;
	private Configuration configuration;
	private List<Representation> representations;
	private int IdSpectacle;
	private PlanningSalle planningSalle;
	
	public Spectacle(String Titre, int idSpectacle, int nbrPlaceMax) {
		titre = Titre;
		nbrPlaceParClient = nbrPlaceMax;
		IdSpectacle = idSpectacle;
	}
	
	public Spectacle() {
		// TODO Auto-generated constructor stub
	}

	public Spectacle(PlanningSalle planningSalle2, String titre2, int places) {
		planningSalle = planningSalle2;
		titre = titre2;
		nbrPlaceParClient = places;
	}

	public Spectacle(String titre2, int int2, int places, PlanningSalle planningSalle2) {
		planningSalle = planningSalle2;
		titre = titre2;
		nbrPlaceParClient = places;	
		IdSpectacle = int2;
		
	}

	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public List<Artiste> getArtistes() {
		return Artistes;
	}
	public void setArtistes(List<Artiste> artistes) {
		Artistes = artistes;
	}
	public int getNbrPlaceParClient() {
		return nbrPlaceParClient;
	}
	public void setNbrPlaceParClient(int nbrPlaceParClient) {
		this.nbrPlaceParClient = nbrPlaceParClient;
	}
	public Configuration getConfiguration() {
		return configuration;
	}
	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}
	public List<Representation> getRepresentations() {
		return representations;
	}
	public void setRepresentations(List<Representation> representations) {
		this.representations = representations;
	}
	public int getIdSpectacle() {
		return IdSpectacle;
	}
	public void setIdSpectacle(int idSpectacle) {
		IdSpectacle = idSpectacle;
	}

	@Override
	public String toString() {
		return titre + " || " + nbrPlaceParClient + " places dispo";
	}

	public List<Spectacle> getAll() {
		return spectacleDAO.getAll();
	}
	
	public List<Representation> afficherRepresentation (){
		Representation r = new Representation();
		 return r.find(this.IdSpectacle);
	}

	public List<Spectacle> find(int id) {
		return spectacleDAO.findAll(id);
	}
	
	public List<Configuration> afficherConfig(){
		Configuration c = new Configuration();
		return c.findAll(this.IdSpectacle);
	}

	public List<Spectacle> getAll(int id) {
		// TODO Auto-generated method stub
		return spectacleDAO.getAll(id);
	}

	public PlanningSalle getPlanningSalle() {
		return planningSalle;
	}

	public void setPlanningSalle(PlanningSalle planningSalle) {
		this.planningSalle = planningSalle;
	}

	public boolean creer() {
		return spectacleDAO.create(this);
	}

	public Spectacle find() {
		return spectacleDAO.find(this);
	}



}
