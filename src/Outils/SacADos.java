package Outils;
import java.util.ArrayList;

public class SacADos {
	private ArrayList<Objet> ListeObjets;
	private double capaciteMax;
	
	//Constructeur d'un sac vide 
	public SacADos(double cap) {
		this.capaciteMax = cap;
		this.ListeObjets = new ArrayList<Objet>();
	}
	
	//Constructeur d'un sac avec une liste d'objet
	public SacADos(String chemin, float cap) {
		this.capaciteMax = cap;
		//à compléter avec la récup des objets dans le fichier
	}
	
	public ArrayList<Objet> getListeObjets() {
		return this.ListeObjets;
	}
	
	public double getCapacite() {
		return this.capaciteMax;
	}
}
