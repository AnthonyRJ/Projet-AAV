package MethodeResolution;

import java.util.ArrayList;

import Outils.Objet;
import Outils.SacADos;

public class Gloutonne {
	
	private SacADos sac;
	private ArrayList<Objet> Objets;
	
	public Gloutonne(ArrayList<Objet> liste, SacADos sac) {
		this.Objets = new ArrayList<Objet>();
		this.Objets = liste;
		this.sac = sac;
	}
	
	public ArrayList<Objet> getObjets(){
		return this.Objets;
	}
	
	//Fonction qui calcule le rapport valeurs/poids de chaque objet de la liste
	public void calculRapportObjet() {
		//Pour chaque objet dans la liste on lui affecte son rapport valeur/poids
		for (Objet obj : this.getObjets()) {
			obj.setRapport(obj.calculRapport());
		}
	}
	
	public void trier() {
		/*Utiliser n'importe quel algo de tri dans un premier temps puis voir 
		  plus tardlequel est le plus optimisé*/
	}
	
	public void ajouterDansSac() {
		/*Code qui va ajouter les objets dans le sac après avoir été trié
		  attention ! A chaque ajout controller la capacité du sac*/
	}
	
	public String toString() {
		//Methode à surcharger pour afficher le contenu du sac une fois "plein"
		return "aaaa";
	}
	
	//Methode à appeler pour résoudre le problème du sac à dos avec la méthode Gloutonne
	public void resoudre() {
		calculRapportObjet();
		trier();
		ajouterDansSac();
		toString();
	}
}
