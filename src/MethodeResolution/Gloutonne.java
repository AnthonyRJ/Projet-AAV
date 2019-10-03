package MethodeResolution;

import java.util.ArrayList;
import java.util.Arrays;
import Outils.Objet;
import Outils.SacADos;

public class Gloutonne {
	
	private SacADos sac;
	private Objet[] objets;
	
	public Gloutonne(Objet[] liste, SacADos sac) {
		this.objets = new Objet[liste.length];
		for (int i = 0; i<liste.length; ++i) {
			this.objets[i] = liste[i];
		}
		this.sac = sac;
	}
	
	public Objet[] getObjets(){
		return this.objets;
	}
	
	public void trier() {
		/*
		 * Méthode sort() qui va utiliser la méthode CompareTo de l'interface Comparable 
		 * mais qui a été surchargé dans la classe Objet
		 * La méthode de trie de Arrays.sort() utilise le QuickSort
		 */
		Arrays.sort(this.objets);
	}
	
	public void ajouterDansSac() {
		double capaciteSac = this.sac.getCapacite();
		
		for (Objet obj : this.objets) {
			if (obj.getPoids() < capaciteSac) {
				this.sac.getListeObjets().add(obj);
				capaciteSac = capaciteSac - obj.getPoids();
			}
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
	
	//Methode à appeler pour résoudre le problème du sac à dos avec la méthode Dynamique
	public void resoudre() {
		trier();
		ajouterDansSac();
	}
}
