package Appli;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import MethodeResolution.Dynamique;
import MethodeResolution.Gloutonne;
import Outils.Objet;
import Outils.SacADos;

public class Appli {

	public static void main(String[] args) throws IOException{
		for(int i = 0; i < args.length; ++i) {
			System.out.println(args[i]);
		}
		
		try{
			Path chemin = Paths.get(args[0]);
			ArrayList<Objet> liste = new ArrayList<>();
			
			List<String> lignes = new ArrayList<>();
			
			lignes = Files.readAllLines(chemin);
			
			for (String ligne : lignes) {
				String[] decoup� = ligne.split(";");
				Objet unObjet = new Objet(decoup�[0],Double.parseDouble(decoup�[1]),Double.parseDouble(decoup�[2]));
				liste.add(unObjet);
			}
			
			try {
				int capMax = Integer.parseInt(args[1]);
				SacADos sac = new SacADos(capMax);
				try {
					sac.resoudre(args[2], liste);
				} catch(Exception ex) {
					
				}
			} catch (Exception ex) {
				System.out.println("Erreur : le sac n'a pas pu �tre instanci�, la capacit� maximal du sac indiqu� est invalide");
			}
		} catch(Exception ex){
			System.out.println("Le fichier indiqu� est introuvable / n'existe pas");
		}
		
	} 

}
