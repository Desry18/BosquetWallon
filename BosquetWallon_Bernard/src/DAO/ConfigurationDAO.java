package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import POJO.Configuration;
import POJO.Representation;
import POJO.Spectacle;

public class ConfigurationDAO extends DAO<Configuration>{

	public ConfigurationDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Configuration obj) {
		try {
			String insertion = "INSERT INTO Configuration (Type, Description, IdSpectacle) "
					+ "values ('" + obj.getType() + "','" + obj.getDescription() + "','" + obj.getS().getIdSpectacle() + "');";
			System.out.println(insertion);
			
				connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
						.executeUpdate(insertion);
			return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
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
		Configuration s = new Configuration();
		ResultSet result;
		try {
			result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
			        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Configuration WHERE Type = '" + t.getType()
			                                                    + "' AND IdSpectacle = '" + t.getS().getIdSpectacle()
			                                                    +  "'");
	        if(result.last())
	            s = new Configuration(result.getString("Type"), result.getString("Description"), t.getS(), result.getInt("IdConfiguration"));
	        return s;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			}	
		}

	@Override
	public List<Configuration> findAll(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
