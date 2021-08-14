package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import POJO.Representation;
import POJO.Spectacle;

public class RepresentationDAO extends DAO<Representation>{

	public RepresentationDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Representation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Representation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Representation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Representation find(int Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Representation find(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Representation> getAll(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Representation> findAll(int id) {
	List<Representation> lr = new ArrayList<Representation>();
	
		
		try {
	
			String query = "SELECT HeureDebut, HeureFin, Date, IdRepresentation, HeureOuverture FROM Representation WHERE IdSpectacle = " + id + ";";
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery(query);
				while(result.next()) {
					Representation representation = new Representation(result.getTimestamp("HeureDebut"), result.getTimestamp("HeureFin"), result.getDate("Date"), result.getInt("IdRepresentation"), result.getTimestamp("HeureOuverture"));
					lr.add(representation);
				}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lr;
	}


	@Override
	public List<Representation> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Representation find(Representation t) {
		// TODO Auto-generated method stub
		return null;
	}

}
