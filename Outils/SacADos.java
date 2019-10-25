package Outils;
import java.util.ArrayList;

import ABR.ABR;
import MethodeResolution.*;

public class SacADos {
	private ArrayList<Objet> ListeObjets;
	private double capaciteMax;
	
	//Constructeur d'un sac vide 
	public SacADos(double cap) {
		this.capaciteMax = cap;
		this.ListeObjets = new ArrayList<Objet>();
	}
	
	public ArrayList<Objet> getListeObjets() {
		return this.ListeObjets;
	}
	
	public double getCapacite() {
		return this.capaciteMax;
	}
	
	private ArrayList<Objet> methodePSE(ArrayList<Objet> listeObjets){
		ABR arbre = new ABR();
		arbre.init(listeObjets);
		return arbre.sacOpti(this.capaciteMax);
	}
	
	public void resoudre(String méthode, ArrayList<Objet> listeObjets) {
		switch(méthode) {
		case "gloutonne" : 
			Gloutonne methodGlou = new Gloutonne(this,listeObjets);
			methodGlou.resoudre();
			System.out.println(methodGlou.toString());
			break;
		case "prog.dynamique" :
			Dynamique methodDyna = new Dynamique(this, listeObjets);
			methodDyna.resoudre();
			System.out.println(methodDyna.toString());
			break;
		case "pse" : 
			String s = new String(); 
			s+="[";
			for(Objet o : this.methodePSE(listeObjets))
				s+= o.getNom() + ", ";
			s = s.substring(0 , s.length() - 2);
			s+="]";
			System.out.println(s);
			break;
		default : System.out.println("Erreur : la méthode indiqué est invalide ou n'existe pas");
		}
	}
}
