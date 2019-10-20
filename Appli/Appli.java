package Appli;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import MethodeResolution.Dynamique;
import MethodeResolution.Gloutonne;
import Outils.Objet;
import Outils.SacADos;

public class Appli {

	public static void main(String[] args) throws IOException{
		
		Path chemin = Paths.get("./items.txt");
		
		ArrayList<Objet> liste = new ArrayList<>();
		
		List<String> lignes = new ArrayList<>();
		
		lignes = Files.readAllLines(chemin);
		
		for (String ligne : lignes) {
			String[] decoupé = ligne.split(";");
			Objet unObjet = new Objet(decoupé[0],Double.parseDouble(decoupé[1]),Double.parseDouble(decoupé[2]));
			liste.add(unObjet);
		}
		
		SacADos sac = new SacADos(12);
		
		/*Objet A = new Objet("A", 2.0,5.0);
		Objet B = new Objet("B", 3.0,8.0);
		Objet C = new Objet("C", 5.0,14.0);
		Objet D = new Objet("D", 2.0,6.0);
		Objet E = new Objet("E", 4.0,13.0);
		Objet F = new Objet("F", 6.0,17.0);
		Objet G = new Objet("G", 3.0,10.0);
		Objet H = new Objet("H", 1.0,4.0);
		
		liste.add(A);
		liste.add(B);
		liste.add(C);
		liste.add(D);
		liste.add(E);
		liste.add(F);
		liste.add(G);
		liste.add(H);*/
		
		/*Gloutonne methodeGlou = new Gloutonne(liste,sac);
		
		methodeGlou.resoudre();
		System.out.println(methodeGlou.toString());*/
		
		/*Dynamique methodeDyna = new Dynamique(sac,liste);
		
		methodeDyna.resoudre();
		System.out.println(methodeDyna.toString());*/
		

		for(Objet objet :sac.methodePSE(liste)){
			System.out.println(objet.getNom());
		}

	} 

}
