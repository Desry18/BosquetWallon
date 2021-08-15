package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import POJO.Commande;

public class CommandeDAO extends DAO<Commande>{

	public CommandeDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Commande obj) {
		try {
		String insertion = "INSERT INTO Commande (IdPersonne, ModeLivraison, ModePayement, CoutTotal) "
				+ "values ('" + obj.getC().getId() + "','" + obj.getModeLivraison() + "','" + obj.getModePayement() + "','"
				+ obj.getCout() +"');";
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
	public boolean delete(Commande obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Commande obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Commande find(int Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commande find(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commande> getAll(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commande> findAll(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commande> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commande find(Commande t) {
		Commande c = new Commande();
		ResultSet result;
		try {
			result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
			        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Commande WHERE ModePayement = '" + t.getModePayement()
			                                                    + "' AND ModeLivraison = '" + t.getModeLivraison()
			                                                    + "' AND CoutTotal = '" + t.getCout()
			                                                    + "' AND IdPersonne = '" + t.getC().getId() + "'");
	        if(result.last())
	            c = new Commande(result.getInt("IdCommande"), result.getString("ModePayement"), result.getString("ModeLivraison"), result.getDouble("CoutTotal"));
	        return c;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		
	}

	@Override
	public List<Commande> findAll(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
