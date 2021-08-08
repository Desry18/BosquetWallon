package DAO;

import java.sql.Connection;

import POJO.Categorie;

public class DAOFactory extends AbstractDAOFactory{
	protected static final Connection conn = connexion.Connexion.getInstance();
	
	public DAO<Categorie> getCategorieDAO() {
		return new CategorieDAO(conn);
	}
}
