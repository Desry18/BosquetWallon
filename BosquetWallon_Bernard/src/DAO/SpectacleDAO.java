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
	public List<Spectacle> findS(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	

	

}
