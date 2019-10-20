package ABR;

import java.util.ArrayList;
import java.util.Iterator;

import Outils.Objet;


public class ABR{
		 	private ArrayList<Objet> listeObj;
		    private ABR filsDroit;
		    private ABR filsGauche;
			private ABR racine;
			private double borneInf;

		    public ABR(){
		        listeObj = new ArrayList<Objet>();
		        filsDroit = null;
		        filsGauche = null;
				racine = null;
				borneInf = 0;
			}
			
			/**
			 * Renvoit "True" si le noeud actuel est une feuille
			 * @return
			 */
			public boolean estFeuille(){
				return filsDroit == null && filsGauche == null;
			}

			public boolean estNoeud(){
				return !estFeuille();
			}

			/**
			 * construction de l'arbre à partir d'une liste d'objet donné
			 * @param listeObjSac
			 */
			public void init(ArrayList<Objet> listeObjSac){
				Iterator<Objet> it = listeObjSac.iterator();
				while(it.hasNext()){
					this.ajout(it.next());
				}
			}

			public void setBorneInf(){
				Iterator<Objet> it = listeObj.iterator();
				while(it.hasNext()){
					borneInf += it.next().getVal();
				}

			}
			
			/**
			 * Initialise la racine de du noeud (le père)
			 * @param racine
			 */
		    public void setRacine(ABR racine) {
				this.racine = racine;
				this.setListeObj(racine.getListeObj());
			}
			
			/**
			 * Initialise la liste d'objet actuel en prenant en paramètre la liste d'objet de sa racine
			 * @param listeObj
			 */
			public void setListeObj(ArrayList<Objet> listeObj){
				Iterator<Objet> it = listeObj.iterator();
				while(it.hasNext()){
					this.listeObj.add(it.next());
				}
			}

			/**
			 * ajoute un objet o dans l'arbre, si le noeud actuel n'est pas une feuille, la fonction
			 * est appellé récursivement sur ses fils droits & gauche
			 * @param o
			 */
		    public void ajout(Objet o){
		        if(this.estFeuille()){
					filsGauche = new ABR();
					filsGauche.setRacine(this);
					filsGauche.setBorneInf();
		            filsDroit = new ABR();
		            filsDroit.setRacine(this);
					filsDroit.addObjet(o);
					filsDroit.setBorneInf();
		        }
		        else{
		            filsDroit.ajout(o);
		            filsGauche.ajout(o);
		        }
		    }

		    public ABR getFilsDroit(){
		        return filsDroit;
		    }

		    public ABR getFilsGauche(){
		        return filsGauche;
			}
			

		    public ArrayList<Objet> getListeObj(){
		        return listeObj;
		    }

			/**
			 * fonction qui ajoute le nouvelle objet o à la liste d'objet
			 * Uniquement appellé pour les fils Droits
			 * @param o
			 */
		    public void addObjet(Objet o) {
				listeObj = racine.getListeObj();
		    	listeObj.add(o);
			}
			
			/*Affichage selon un parcous prefixe*/
			public String toString(){
				Iterator<Objet> it = this.listeObj.iterator();
				String s = new String();
				if(this.estFeuille()){
					s+="[";
					while(it.hasNext()){
						s+= it.next().getNom()+",";
					}
					s+="]";
				}
				

				if(getFilsGauche() != null){
					s+= filsGauche.toString();
				}

				if(filsDroit != null){
					s+= filsDroit.toString();
				}
				return s;
			}

			public boolean estRealisable(double poidMax){
				double poidActuel = 0;
				for (Objet objet : listeObj) {
					poidActuel += objet.getPoids();
				}
				return poidActuel <= poidMax;
			}

			public double getBorneInf(){
				return borneInf;
			}

			public ABR solutionOpti(double capMax){
				if(this.estNoeud()){
					if(filsDroit.solutionOpti(capMax).estRealisable(capMax)){
						if(filsDroit.solutionOpti(capMax).getBorneInf() >= filsGauche.solutionOpti(capMax).getBorneInf())
							return filsDroit.solutionOpti(capMax);
						else
							return filsGauche.solutionOpti(capMax);
					} else
						return filsGauche.solutionOpti(capMax);
				} else
					return this;
			}

			public ArrayList<Objet> sacOpti(double capMax){
				System.out.println(this.solutionOpti(capMax).getBorneInf());
				return this.solutionOpti(capMax).getListeObj();
			}

	
	}