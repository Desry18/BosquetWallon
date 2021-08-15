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

	@Override
	public List<Artiste> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Artiste> findAll(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Artiste find(Artiste t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Artiste> findAll(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
