package Frame;

import java.util.List;

import javax.swing.JOptionPane;

import DAO.AbstractDAOFactory;
import DAO.DAO;
import POJO.Artiste;
import POJO.Categorie;
import POJO.Personne;

public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a;
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DAO<Categorie> DAOCategorie = adf.getCategorieDAO();
		DAO<Personne> DAOPersonne = adf.getPersonneDAO();
		Categorie cat;
		Personne p = new Artiste();
		p = DAOPersonne.find(7);
		cat = DAOCategorie.find(8);
		List<Categorie> liste = DAOCategorie.getAll(10);
		a = liste.get(0).toString();
		System.out.println("couilles " + a);
		System.out.println("couilles " + liste.get(1).toString());

		JOptionPane.showMessageDialog(null, p.getEmail());
		
		
	}

}
