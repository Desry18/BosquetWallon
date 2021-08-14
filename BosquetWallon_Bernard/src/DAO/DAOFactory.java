package DAO;

import java.sql.Connection;

import POJO.Artiste;
import POJO.Categorie;
import POJO.Client;
import POJO.Commande;
import POJO.Configuration;
import POJO.Gestionnaire;
import POJO.Organisateur;
import POJO.Personne;
import POJO.Place;
import POJO.PlanningSalle;
import POJO.Representation;
import POJO.Reservation;
import POJO.Spectacle;

public class DAOFactory extends AbstractDAOFactory{
	protected static final Connection conn = connexion.Connexion.getInstance();
	
	public DAO<Categorie> getCategorieDAO() {
		return new CategorieDAO(conn);
	}

	@Override
	public DAO<Artiste> getArtisteDAO() {
		return new ArtisteDAO(conn);
	}

	@Override
	public DAO<Client> getClientDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DAO<Commande> getCommandeDAO() {
		// TODO Auto-generated method stub
		return new CommandeDAO(conn);
	}

	@Override
	public DAO<Configuration> getConfigurationDAO() {
		// TODO Auto-generated method stub
		return new ConfigurationDAO(conn);
	}

	@Override
	public DAO<Gestionnaire> getGestionnaireDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DAO<Organisateur> getOrganisateurDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DAO<Place> getPlaceDAO() {
		// TODO Auto-generated method stub
		return new PlaceDAO(conn);
	}

	@Override
	public DAO<PlanningSalle> getPlanningSalleDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DAO<Representation> getRepresentationDAO() {
		// TODO Auto-generated method stub
		return new RepresentationDAO(conn);
	}

	@Override
	public DAO<Reservation> getReservationDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DAO<Spectacle> getSpectacleDAO() {
		// TODO Auto-generated method stub
		return new SpectacleDAO(conn);
	}

	@Override
	public DAO<Personne> getPersonneDAO() {
		// TODO Auto-generated method stub
		return new PersonneDAO(conn);
	}
}
