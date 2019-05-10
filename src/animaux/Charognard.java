package animaux;
import java.awt.Color;

import biome.Case;
/**
 * Classe décrivant les charognards
 * @author Paul,Armand et Louise 
 *
 */

public abstract class Charognard extends Animal {

	/**
	 * Constructeur
	 * @param dateNaissance : tour où l'animal est né
	 * @param emplacement : Case où se situe l'animal
	 * @param aProcree : Indique si l'animal s'est reproduit il y a un certain nombre de tours
	 * @param meurtFaim : indique si l'animal est en état de famine
	 */
	public Charognard(int dateNaissance, Case emplacement,  boolean aProcree, int meurtFaim) {
		super(dateNaissance,emplacement, aProcree,meurtFaim);
	}

	/**
	 * Cette méthode remplit l'estomac de l'animal s'il n'est pas déjà plein. La case sur laquelle il est diminue également en quantité de nourriture.
	 * Dans le cas d'un charognard, il mange des cadavres présents sur une case
	 */
	@Override
	public void seNourrir(){
		// si l'animal est vivant
		if (getEstVivant() == true) {
			// si l'animal n'est pas rassasi� 
			if (this.getRemplissageEstomac() < this.getTailleEstomac()) {
				// si la case contient un cadavre, le charognard peut manger
				if(this.getEmplacement().getCadavre() == true) {
					if (this.getEmplacement().getAnimal().getViande() > 0) {			// si le cadavre a de la viande
						if (getRemplissageEstomac() < getTailleEstomac()) {
							// si l'animal a suffisament faim et que la case ne contient pas suffisament ou juste assez
							// de nourriture pour le rassasier, il mange tout la nourriture présente sur la case
							// le stock de nourriture tombe donc à 0 et la case ne contient plus de cadavre
							if (getRemplissageEstomac() + this.getEmplacement().getAnimal().getViande() <= getTailleEstomac()){
								this.setRemplissageEstomac(getRemplissageEstomac() + this.getEmplacement().getAnimal().getViande());
								this.getEmplacement().getAnimal().setViande(0);
								this.getEmplacement().setACadavre(false); 
							}
							// sinon si la case contient plus de nourriture que l'animal ne peut en manger, 
							// alors il mange juste à sa faim
							else { 
							this.getEmplacement().getAnimal().setViande(this.getEmplacement().getAnimal().getViande() - (this.getTailleEstomac() - this.getRemplissageEstomac()));
							this.setRemplissageEstomac(this.getTailleEstomac());
							}
						}
					}
				}
			}
		}
	}
	
	@Override
	public abstract void seReproduire();
}
