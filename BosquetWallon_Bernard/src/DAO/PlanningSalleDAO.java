package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import POJO.PlanningSalle;

public class PlanningSalleDAO extends DAO<PlanningSalle>{

	public PlanningSalleDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(PlanningSalle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(PlanningSalle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(PlanningSalle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PlanningSalle find(int Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlanningSalle find(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlanningSalle find(PlanningSalle t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlanningSalle> getAll(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlanningSalle> findAll(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlanningSalle> getAll() {
		List<PlanningSalle> PlanningSalles = new ArrayList<PlanningSalle>();
		try {

			String query = "SELECT * FROM PlanningSalle";
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery(query);
				while(result.next()) {
					PlanningSalle planning = new PlanningSalle(result.getDate("DateDebut"),result.getDate("DateFin"),result.getInt("IdSalle"));
					PlanningSalles.add(planning);
				}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return PlanningSalles;	}

}
