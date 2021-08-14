package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import POJO.Artiste;
import POJO.Representation;
import POJO.Spectacle;

public class SpectacleDAO extends DAO<Spectacle>{

	public SpectacleDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Spectacle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Spectacle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Spectacle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Spectacle find(int Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Spectacle find(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Spectacle> getAll(int i) {
		return null;
	
		}


	@Override
	public List<Spectacle> getAll() {
	List<Spectacle> ls = new ArrayList<Spectacle>();
	
		
		try {
	
			String query = "SELECT Titre, IdSpectacle, NbrePlaceMAx FROM Spectacle ;";
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery(query);
				while(result.next()) {
					Spectacle spectacle = new Spectacle(result.getString("Titre"), result.getInt("IdSpectacle"), result.getInt("NbrePlaceMax"));
					ls.add(spectacle);
				}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ls;
	}

	@Override
	public List<Spectacle> findAll(int id) {
	List<Spectacle> ls = new ArrayList<Spectacle>();
	
		
		try {
	
			String query = "SELECT Titre, s.IdSpectacle, NbrePlaceMax from Spectacle s INNER JOIN ArtisteSpectacle a ON a.Idspectacle = s.IdSpectacle WHERE IdArtiste = " + id + ";";
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery(query);
				while(result.next()) {
					Spectacle spectacle = new Spectacle(result.getString("Titre"), result.getInt("IdSpectacle"), result.getInt("NbrePlaceMax"));
					ls.add(spectacle);
				}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ls;
	}

	@Override
	public Spectacle find(Spectacle t) {
		// TODO Auto-generated method stub
		return null;
	}

}

	

	


