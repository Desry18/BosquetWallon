package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import POJO.Place;

public class PlaceDAO extends DAO<Place>{

	public PlaceDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Place obj) {
		try {
			String insertion = "INSERT INTO Place (Prix, IdRepresentation, IdCommande) "
					+ "values ('" + obj.getPrix() + "','" + obj.getRepresentation().getIdRepresentation() + "','" + obj.getCommande().getIdCommande() +"');";
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
	public boolean delete(Place obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Place obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Place find(int Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Place find(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Place find(Place t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Place> getAll(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Place> findAll(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Place> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Place> findAll(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
