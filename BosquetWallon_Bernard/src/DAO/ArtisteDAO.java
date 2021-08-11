package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import POJO.Artiste;
import POJO.Representation;
import POJO.Spectacle;

public class ArtisteDAO extends DAO<Artiste>{

	public ArtisteDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Artiste obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Artiste obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Artiste obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Artiste find(int Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Artiste find(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Artiste> getAll(int i) {
		
		
		return null;
	}
	public List<Spectacle> findS(int i){
		List<Spectacle> ls = new ArrayList<Spectacle>();
	
		
		try {
	
			String query = "SELECT Titre, s.IdSpectacle, NbrePlaceMax from Spectacle s INNER JOIN ArtisteSpectacle a ON a.Idspectacle = s.IdSpectacle WHERE IdArtiste = " + i + ";";
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
	

}
