package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import POJO.Categorie;
import POJO.Organisateur;
import POJO.PlanningSalle;
import POJO.Reservation;

public class ReservationDAO extends DAO<Reservation>{

	public ReservationDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Reservation obj) {
		try {
			String insertion = "INSERT INTO Reservation (Solde, IdSalle, IdOrganisateur, Statut, Accompte, Prix) "
					+ "values ('" + obj.getSolde() + "','" + obj.getPlanningSalle().getId() + "','" + obj.getO().getId() + "','" + obj.getStatut() + "','" + obj.getAccompte() + "','" + obj.getPrix() + "');";
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
	public boolean delete(Reservation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Reservation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Reservation find(int Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation find(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation find(Reservation t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservation> getAll(int i) {
		return null;
	
	}

	@Override
	public List<Reservation> findAll(int id) {
		return null;
	}

	@Override
	public List<Reservation> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservation> findAll(Object obj) {
		List<Reservation> lr = new ArrayList<Reservation>();		
		try {
	
			String query = "SELECT IdReservation, Solde, r.IdSalle, Statut, Accompte, Prix, DateDebut, DateFin FROM Reservation r INNER JOIN PlanningSalle p ON r.IdSalle = p.IdSalle WHERE IdOrganisateur = " + ((Organisateur) obj).getId() + ";";
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery(query);
				while(result.next()) {
					Reservation r = new Reservation(result.getInt("IdReservation"), result.getDouble("Solde"), new PlanningSalle(result.getInt("IdSalle"), result.getDate("DateDebut"), result.getDate("DateFin")), ((Organisateur) obj), result.getString("Statut"), result.getDouble("Accompte"), result.getDouble("Prix"));
					lr.add(r);
				}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lr;
	}

}
