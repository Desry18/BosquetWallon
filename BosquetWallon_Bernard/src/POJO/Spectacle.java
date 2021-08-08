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


}
