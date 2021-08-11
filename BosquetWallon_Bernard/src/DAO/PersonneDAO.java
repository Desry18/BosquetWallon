package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import POJO.Artiste;
import POJO.Categorie;
import POJO.Client;
import POJO.Gestionnaire;
import POJO.Organisateur;
import POJO.Personne;

public class PersonneDAO extends DAO<Personne>{

	public PersonneDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Personne obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Personne obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Personne obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Personne find(int Id) {
		Personne personne = null;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM Personne WHERE IdPersonne = "+ Id + ";");
			if (result.first())
				personne = new Artiste(result.getString("Nom"), result.getString("Prenom"), result.getString("Adresse"),result.getString("Email"),result.getString("MotDePasse"),result.getInt("IdPersonne"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personne;
	}

	@Override
	public List<Personne> getAll(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public Personne find(String Email) {
		Personne personne = null;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM Personne WHERE Email = '"+ Email + "';");
			if (result.first())
				switch(result.getString("Discriminator"))
				{
				case "Artiste" : personne = new Artiste (result.getString("Nom"), result.getString("Prenom"), result.getString("Adresse"),result.getString("Email"),result.getString("MotDePasse"),result.getInt("IdPersonne"));
					break;
				case "Organisateur" : personne = new Organisateur (result.getString("Nom"), result.getString("Prenom"), result.getString("Adresse"),result.getString("Email"),result.getString("MotDePasse"),result.getInt("IdPersonne"));
					break;
				case "Gestionnaire" : personne = new Gestionnaire (result.getString("Nom"), result.getString("Prenom"), result.getString("Adresse"),result.getString("Email"),result.getString("MotDePasse"),result.getInt("IdPersonne"));
					break;
				default : personne = new Client (result.getString("Nom"), result.getString("Prenom"), result.getString("Adresse"),result.getString("Email"),result.getString("MotDePasse"),result.getInt("IdPersonne"));
					break;
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personne;
	}

}
