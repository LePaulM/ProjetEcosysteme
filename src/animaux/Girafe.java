package animaux;

import java.awt.Color;
import java.util.ArrayList;

import biome.Case;
import biome.Grille;
import gestion.Gestionnaire;

/**
 * Classe décrivant les girafes
 * @author Paul,Armand et Louise 
 *
 */

public class Girafe extends Herbivore{

	/**
	 * Constructeur
	 * @param dateNaissance : tour où l'animal est né
	 * @param emplacement : Case où se situe l'animal
	 * @param maturite : Tour à partir duquel l'animal peut se reproduire 
	 * @param aProcree : Indique si l'animal s'est reproduit il y a un certain nombre de tours
	 * @param meurtFaim : indique si l'animal est en état de famine
	 */
	public Girafe(int dateNaissance,  Case emplacement, boolean aProcree,int meurtFaim) {
		super(dateNaissance,emplacement, aProcree,meurtFaim);

		// on donne un id à l'animal
		this.id = Gestionnaire.getAnimaux().size() + 1;

		//	donne une espérance de vie d'au moins 20 tours et pouvant aller jusqu'à 1/5 de plus
		esperanceVie = 20;
		esperanceVie = esperanceVie + (int)(Math.random() * this.esperanceVie/5);

		// la girafe a une vitesse de 3
		vitesse = 3;
		
		espece = "Girafe";
	}

	/**
	 * 	Cette méthode permet à 2 animaux de la même espèce de se reproduire s'ils sont sur des cases adjacentes et de produire ainsi 
	 *  un nouvel animal de la même espèce.
	 */
	public void seReproduire() {
		if (this.getEstVivant() == false) {					// on vérifie que l'animal est vivant (on ne se reproduit que vivant, c'est la règle...)
		} else {
			if (this.getAProcree() == true) {				// on vérifie que l'animal est mature et ne s'est pas reproduit récemment
			} else {

				// il faut mettre la reproduction dans les classes des animaux 
				// car Animal est une classe abstraite (on ne peut pas instancier un objet d'une classe abstraite
				// Création de la liste des cases adjacentes
				ArrayList<Case> cases = new ArrayList<Case>();
				// Définition des cases adjacentes
				Case case1 = Grille.getCase(this.getEmplacement().getX()-1, this.getEmplacement().getY()-1);
				cases.add(case1);
				Case case2 = Grille.getCase(this.getEmplacement().getX(), this.getEmplacement().getY()-1);
				cases.add(case2);
				Case case3 = Grille.getCase(this.getEmplacement().getX()+1, this.getEmplacement().getY()-1);
				cases.add(case3);
				Case case4 = Grille.getCase(this.getEmplacement().getX()-1, this.getEmplacement().getY());
				cases.add(case4);
				Case case5 = Grille.getCase(this.getEmplacement().getX()+1, this.getEmplacement().getY());
				cases.add(case5);
				Case case6 = Grille.getCase(this.getEmplacement().getX()-1, this.getEmplacement().getY()+1);
				cases.add(case6);
				Case case7 = Grille.getCase(this.getEmplacement().getX(), this.getEmplacement().getY()+1);
				cases.add(case7);
				Case case8 = Grille.getCase(this.getEmplacement().getX()+1, this.getEmplacement().getY()+1);
				cases.add(case8);
				for (Case c : cases){ 
					if (c.getEstVide() == false) {											//			Si une des cases adjacentes n'est pas vide, 
					}																		
					if (c.getAnimal().getEstVivant() == true )								// si l'animal présent sur la case adjacente est vivant
						if (c.getAnimal().getEspece().equals(this.getEspece()))	{			// si l'animal présent sur la case adjacente est de la même espèce, 
							if (c.getAnimal().getAProcree() == false) {						// et enfin si l'autre animal n'a pas déjà procréé récemment 
								this.setAProcree(true);											// 			la variable permettant de savoir si l'animal a procree devient true
								for (Case cbis : cases){											// 			on cherche ensuite  
									if (cbis.getEstVide() == true) {									//			une case vide 
										Animal girafe = new Girafe (Gestionnaire.getTour(),cbis, 	// pour créer un nouvel individu
												this.getAProcree(),this.getMeurtFaim());
										Gestionnaire.addAnimal(girafe);								//			on ajoute l'animal au gestionnaire
										break;														//			l'animal se reproduit et arrête de vérifier 
									}
								}
							}
						}
				}
			}
		}
	}

	/**
	 * Méthode qui modifie la taille de l'estomac de l'animal ainsi que la quantité de viande qu'il peut fournir au fil de l'age
	 */
	public void croissance() {
		
		if ((Gestionnaire.getTour()-getDateNaissance())<=(esperanceVie/4)) {
			setViande(3);
			setTailleEstomac(2);
		}
		else if((Gestionnaire.getTour()-getDateNaissance())<=(esperanceVie/2)) {
			setViande(6);
			setTailleEstomac(4);
		}
		else {
			setTailleEstomac(8);
			setViande(12);
		}
	}

}
