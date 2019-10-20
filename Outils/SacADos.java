package Outils;
import java.util.ArrayList;
import ABR.ABR;

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
	
	public ArrayList<Objet> methodePSE(ArrayList<Objet> listeObjets){
		ABR arbre = new ABR();
		arbre.init(listeObjets);
		return arbre.sacOpti(this.capaciteMax);
	}
}
