package Appli;
import java.util.ArrayList;

import MethodeResolution.Dynamique;
import MethodeResolution.Gloutonne;
import Outils.Objet;
import Outils.SacADos;

public class Appli {

	public static void main(String[] args) {
		/* TEST METHODE GLOUTONNE*/
		/*Objet lampe = new Objet("lampe",2.0,30.0);
		Objet SacDeCouchage = new Objet("SacDeCouchage",1.0,20.0);
		Objet CampingGaz = new Objet("CampingGaz", 3.0, 40.0);
		Objet CouteauSuisse = new Objet("CouteauSuisse",0.2,50.0);
		
		SacADos sac = new SacADos(5.0);
		
		Objet[] liste = new Objet[4];
		
		liste[0] = lampe;
		liste[1] = SacDeCouchage;
		liste[2] = CampingGaz;
		liste[3] = CouteauSuisse;
		
		Gloutonne methodeGlou = new Gloutonne(liste,sac);
		
		methodeGlou.resoudre();
		System.out.println(methodeGlou.toString());*/
		
		/*TEST METHODE DYNAMIQUE*/
		Objet lampe = new Objet("lampe",2.0,5.0);
		Objet SacDeCouchage = new Objet("SacDeCouchage",3.0,8.0);
		Objet CampingGaz = new Objet("CampingGaz", 5.0, 14.0);
		Objet CouteauSuisse = new Objet("CouteauSuisse",2.0,6.0);
		Objet Snickers = new Objet("Snickers",4.0,13.0);
		Objet Tente = new Objet("Tente",6.0,17.0);
		Objet Briquet = new Objet("Briquet",3.0,10.0);
		Objet Coca = new Objet("Coca", 1.0,4.0);
		
		SacADos sac = new SacADos(12.0);
		
		ArrayList<Objet> liste = new ArrayList<>();
		
		liste.add(lampe);
		liste.add(SacDeCouchage);
		liste.add(CampingGaz);
		liste.add(CouteauSuisse);
		liste.add(Snickers);
		liste.add(Tente);
		liste.add(Briquet);
		liste.add(Coca);
		
		Dynamique methodeDyna = new Dynamique(sac,liste);
		
		methodeDyna.resoudre();
		System.out.println(methodeDyna.toString());
	}

}
