package MethodeResolution;

import java.util.ArrayList;
import java.util.Arrays;
import Outils.Objet;
import Outils.SacADos;

public class Gloutonne {
	
	private SacADos sac;
	private Objet[] objets;
	
	public Gloutonne(ArrayList<Objet> liste, SacADos sac) {
		
		this.objets = new Objet[liste.size()];
		
		for (int i = 0; i<liste.size(); ++i) {
			this.objets[i] = liste.get(i);
		}
		
		this.sac = sac;
	}
	
	public Objet[] getObjets(){
		return this.objets;
	}
	
	public void trier() {
		/*
		 * M�thode sort() qui va utiliser la m�thode CompareTo de l'interface Comparable 
		 * mais qui a �t� surcharg� dans la classe Objet
		 * La m�thode de trie de Arrays.sort() utilise le QuickSort
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
	
	//Methode � appeler pour r�soudre le probl�me du sac � dos avec la m�thode Dynamique
	public void resoudre() {
		trier();
		ajouterDansSac();
	}
}
