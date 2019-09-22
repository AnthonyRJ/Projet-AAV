package Outils;

public class Objet {
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

	public void setRapport(double r) {
		this.rapport = r; 
	}
}
