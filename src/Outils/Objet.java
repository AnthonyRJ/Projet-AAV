package Outils;

public class Objet implements Comparable {
	private String nom;
	private double poids;
	private double valeur;
	private double rapport;
	//private boolean dansSac;
	
	public Objet(String n, double d, double e) {
		this.nom = n;
		this.poids = d;
		this.valeur = e;
		this.rapport = e/d;
	}
	
	public double getVal() {
		return this.valeur;
	}
	
	public double getPoids() {
		return this.poids;
	}
	
	public double getRapport() {
		return this.rapport;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void setRapport(double r) {
		this.rapport = r; 
	}
	
	/*
	 * Méthode CompareTo surchargé de l'interface Comparable
	 * Compare le rapport valeur/poids entre deux objets
	 */
	@Override
	public int compareTo(Object unObjet) {
		if (this.getRapport() < ((Objet) unObjet).getRapport()) {
			return 1;
		}
		else if (this.getRapport() > ((Objet) unObjet).getRapport()) {
			return -1;
		}
		else {
			return 0;
		}
	}
}
