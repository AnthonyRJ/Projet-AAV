package Appli;
import java.util.ArrayList;

import MethodeResolution.Gloutonne;
import Outils.Objet;
import Outils.SacADos;

public class Appli {

	public static void main(String[] args) {
		Objet lampe = new Objet("lampe",2.0,30.0);
		Objet SacDeCouchage = new Objet("SacDeCouchage",1.0,20.0);
		Objet CampingGaz = new Objet("CampingGaz", 3.0, 40.0);
		Objet CouteauSuisse = new Objet("CouteauSuisse",0.2,50.0);
		
		SacADos sac = new SacADos(30.0);
		
		ArrayList<Objet> liste = new ArrayList<Objet>();
		
		liste.add(lampe);
		liste.add(SacDeCouchage);
		liste.add(CampingGaz);
		liste.add(CouteauSuisse);
		
		Gloutonne methodeGlou = new Gloutonne(liste,sac);
		
		methodeGlou.calculRapportObjet();
		
	}

}
