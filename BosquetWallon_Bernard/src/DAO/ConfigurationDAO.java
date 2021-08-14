package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import POJO.Configuration;
import POJO.Representation;

public class ConfigurationDAO extends DAO<Configuration>{

	public ConfigurationDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Configuration obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Configuration obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Configuration obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Configuration find(int Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Configuration find(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Configuration> getAll(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Configuration> findAll(int id) {
	List<Configuration> lc = new ArrayList<Configuration>();
	
		
		try {
	
			String query = "SELECT Type, Description, IdConfiguration FROM Configuration WHERE IdSpectacle = " + id + ";";
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery(query);
				while(result.next()) {
					Configuration config = new Configuration(result.getString("Type"), result.getString("Description"), result.getInt("IdConfiguration"));
					lc.add(config);
				}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lc;
	}

	@Override
	public List<Configuration> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Configuration find(Configuration t) {
		// TODO Auto-generated method stub
		return null;
	}

}
