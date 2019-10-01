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
	
	/*probleme si la capacite du sac est supérieur au nombre d'objet*/
	public void remplissageMatrice() {
		for(int j = 0; j <  this.sac.getCapacite(); j++) {
			if (this.objets.get(j).getPoids() > j) {
				this.matrice[0][j] = 0;
			}
			else {
				this.matrice[0][j] = (int) this.objets.get(j).getVal();
			}
			
			for (int i = 1; i < this.sac.getCapacite() + 1; i++) {
				if (this.objets.get(i).getPoids() > j) {
					this.matrice[i][j] = this.matrice[i-1][j];
				}
				else {
					this.matrice[i][j] = max(this.matrice[i-1][j], 
					this.matrice[i-1][(int) (j-this.objets.get(i).getPoids() + 
					this.objets.get(i).getVal())]);
				}
			}
			
		}
		
		
	}
	
	/*
	 * retourne la plus grande valeur entre val1 et val2
	 */
	private int max(int val1, int val2) {
		if (val1 > val2) {
			return val1;
		}
		else {
			return val2;
		}
	}
	
	
	
}
