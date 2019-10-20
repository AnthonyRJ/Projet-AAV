 package MethodeResolution;

import java.util.ArrayList;

import Outils.Objet;
import Outils.SacADos;

public class Dynamique {
	private SacADos sac;
	private ArrayList<Objet> objets;
	private double[][] matrice;
	
	public Dynamique(SacADos s, ArrayList<Objet> l) {
		this.sac = s;
		this.objets = l;
		this.matrice = new double[l.size()][(int) (s.getCapacite() + 1)];
	}
	
	public void remplissageMatrice() {
		//On remplie la 1er ligne
		for(int j = 0; j <  (int)(this.sac.getCapacite() + 1); j++) {
			if (this.objets.get(0).getPoids() > j) {
				this.matrice[0][j] = 0;
			}
			else {
				this.matrice[0][j] = this.objets.get(0).getVal();
			}
		}
		
		//On remplie le reste du tableau
		for (int i = 1; i < this.objets.size(); i++) {
			for (int k = 0; k < (int)(this.sac.getCapacite() + 1); k++) {
				if (this.objets.get(i).getPoids() > k) {
					this.matrice[i][k] = this.matrice[i - 1][k];
				}
				else {
					int ordonnee = (int) (k - this.objets.get(i).getPoids());
					this.matrice[i][k] = max(this.matrice[i-1][k],this.matrice[i-1][ordonnee] + this.objets.get(i).getVal());
				}
			}
		}	
	}
	
	/*
	 * fonction qui compare 2 valeurs
	 *@return la plus grande valeur entre val1 et val2
	 */
	private double max(double matrice2, double d) {
		if (matrice2 > d) {
			return matrice2;
		}
		else if (matrice2 == d) {
			return matrice2;
		}
		else {
			return d;
		}
	}
	
	/*
	 * fonction qui va récupérer les objets les plus optimisés et les ajouter dans le sac
	 */
	public void recupObjet() {
		//On fixe les indices à la case tout en bas à droite du tableau
		int i = this.objets.size() - 1;
		int j = (int) (this.sac.getCapacite());
		
		while(j > 0 && i >= 0) {
			while(i > 0 && this.matrice[i][j] == this.matrice[i - 1][j]) {
				i--;
			}
			j = (int) (j - this.objets.get(i).getPoids());
			if(j >= 0) {
				this.sac.getListeObjets().add(this.objets.get(i));
			}
			i--;
		}
	}
	
	public String toString() {
		String s = new String();
		
		if (this.sac.getListeObjets().size() == 0) {
			s += "Le sac est vide, vous ne pouvez mettre aucun de vos objets dedans";
		}
		else {
			s += "Voici le contenu du sac : \n";
		}
		
		
		for (Objet obj : this.sac.getListeObjets()) {
			s += obj.getNom() + "\n";
		}
		
		return s;
	}
	
	public void resoudre() {
		this.remplissageMatrice();
		this.recupObjet();
	}
	
	
	
}
