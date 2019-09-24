package Appli;
import MethodeResolution.Gloutonne;
import Outils.Objet;
import Outils.SacADos;

public class Appli {

	public static void main(String[] args) {
		Objet lampe = new Objet("lampe",2.0,30.0);
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
		System.out.println(methodeGlou.toString());
		
	}

}
