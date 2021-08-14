package Frame;

import java.lang.module.Configuration;
import java.util.List;

import javax.swing.JOptionPane;

import DAO.AbstractDAOFactory;
import DAO.DAO;
import POJO.*;


public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a;
		
		Client c = new Client();
		List<Spectacle> ls = c.getSpectacle();
		
		for(Spectacle s : ls) {
			System.out.println(s.getTitre());
			if(s.afficherRepresentation() != null) {
				for(Representation r : s.afficherRepresentation())
					System.out.println("---- Representation spectale num : " + s.getIdSpectacle() + " : " + r.toString());
			}
			if(s.afficherConfig() != null) {
				for(POJO.Configuration c1 : s.afficherConfig()) {
					System.out.println("-------------- Confiuguration spectacle num : " + s.getIdSpectacle() + " : " + c1.toString());
					if(c1.afficherCat() != null) {
						for(Categorie c2 : c1.afficherCat())
							System.out.println("------------------------Categorie pour spectacle num : " + s.getIdSpectacle() + " : " + c2.toString());
					}
				}
				
			}
		
		}
	}
}
