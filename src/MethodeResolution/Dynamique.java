 package MethodeResolution;

import java.util.ArrayList;

import Outils.Objet;
import Outils.SacADos;

public class Dynamique {
	private SacADos sac;
	private ArrayList<Objet> objets;
	private int[][] matrice;
	
	public Dynamique(SacADos s, ArrayList<Objet> l) {
		this.sac = s;
		this.objets = l;
		this.matrice = new int[l.size()][(int) (s.getCapacite() + 1)];
	}
	
	public void remplissageMatrice() {
		//On remplie la 1er ligne
		for(int j = 0; j <  this.sac.getCapacite() + 1; j++) {
			if (this.objets.get(0).getPoids() > j) {
				this.matrice[0][j] = 0;
			}
			else {
				this.matrice[0][j] = (int) this.objets.get(0).getVal();
			}
		}
		
		//On remplie le reste du tableau
		for (int i = 1; i < this.objets.size(); i++) {
			for (int k = 0; k < this.sac.getCapacite() + 1; k++) {
				if (this.objets.get(i).getPoids() > k) {
					this.matrice[i][k] = this.matrice[i - 1][k];
				}
				else {
					int ordonnee = (int) (k - this.objets.get(i).getPoids());
					this.matrice[i][k] = max(this.matrice[i-1][k],(int) (this.matrice[i-1][ordonnee] + this.objets.get(i).getVal()));
				}
			}
		}	
	}
	
	/*
	 * fonction qui compare 2 valeurs
	 *@return la plus grande valeur entre val1 et val2
	 */
	private int max(int val1, int val2) {
		if (val1 > val2) {
			return val1;
		}
		else if (val1 == val2) {
			return val1;
		}
		else {
			return val2;
		}
	}
	
	/*
	 * fonction qui va récupérer les objets les plus optimisés et les ajouter dans le sac
	 */
	public void recupObjet() {
		//On fixe les indices à la case tout en bas à droite du tableau
		int i = this.objets.size() - 1;
		int j = (int) (this.sac.getCapacite());
		
		while(j > 0) {
			while(i > 0 && this.matrice[i][j] == this.matrice[i - 1][j]) {
				i--;
			}
			j = (int) (j - this.objets.get(i).getPoids());
			if(j > 0) {
				this.sac.getListeObjets().add(this.objets.get(i));
			}
			i--;
		}
	}
	
	public String toString() {
		String s = new String();
		s += "Voici le contenu du sac : \n";
		
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
