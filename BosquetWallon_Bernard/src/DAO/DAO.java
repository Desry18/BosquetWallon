package DAO;

import java.sql.Connection;
import java.util.List;

import POJO.Categorie;

public abstract class DAO<T> {
	protected Connection connect = null;
	
	public DAO(Connection conn){
		this.connect = conn;
	}
	
	public abstract boolean create(T obj);
	
	public abstract boolean delete(T obj);
	
	public abstract boolean update(T obj);
	
	public abstract T find(int Id);
	
	public abstract T find (String nom);

	public abstract List<T> getAll(int i);
}
