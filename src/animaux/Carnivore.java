package animaux;
import java.awt.Color;
/**
 * 
 * @author formation
 *
 */
import java.util.ArrayList;

import biome.Case;
import biome.Grille;

/**
 * Classe décrivant les carnivores
 * @author Paul,Armand et Louise 
 *
 */
public abstract class Carnivore extends Animal{

	/**
	 * Constructeur
	 * @param dateNaissance : tour où l'animal est né
	 * @param emplacement : Case où se situe l'animal
	 * @param aProcree : Indique si l'animal s'est reproduit il y a un certain nombre de tours
	 * @param meurtFaim : indique si l'animal est en état de famine
	 */
	public Carnivore(int dateNaissance, Case emplacement, boolean aProcree,int meurtFaim) {
		super(dateNaissance,emplacement, aProcree,meurtFaim);
	}

	@Override
	public void seNourrir(){
		if (getEstVivant() == true) {
			if (this.getRemplissageEstomac() < this.getTailleEstomac()) {
				ArrayList<Case> cases = new ArrayList<Case>();	// Création de la liste des cases adjacentes
				// Définition des cases adjacentes à l'animal
				Case case1 = Grille.getCase(this.getEmplacement().getX()-1,this.getEmplacement().getY()-1);	// marche avec les coordonnées de la case
				cases.add(case1);
				Case case2 = Grille.getCase(this.getEmplacement().getX(),this.getEmplacement().getY()-1);
				cases.add(case2);
				Case case3 = Grille.getCase(this.getEmplacement().getX()+1,this.getEmplacement().getY()-1);
				cases.add(case3);
				Case case4 = Grille.getCase(this.getEmplacement().getX()-1,this.getEmplacement().getY());
				cases.add(case4);
				Case case5 = Grille.getCase(this.getEmplacement().getX()+1,this.getEmplacement().getY());
				cases.add(case5);
				Case case6 = Grille.getCase(this.getEmplacement().getX()-1,this.getEmplacement().getY()+1);
				cases.add(case6);
				Case case7 = Grille.getCase(this.getEmplacement().getX(),this.getEmplacement().getY()+1);
				cases.add(case7);
				Case case8 = Grille.getCase(this.getEmplacement().getX()+1,this.getEmplacement().getY()+1);
				cases.add(case8);
				for (Case c : cases) {
					// si la case contient un animal, et que l'animal n'est pas un autre carnivore, 
					// le carnivore le tue
					if(c.getEstVide() == false &&  !c.getAnimal().getEspece().contentEquals(this.getEspece())) {
						c.getAnimal().decede();	
						if (getRemplissageEstomac() < getTailleEstomac()) {
							// si l'animal tué contient plus de nourriture que l'animal n'a de place dans son estomac, 
							// alors il mange juste à sa faim
							if (c.getAnimal().getViande() > (this.getTailleEstomac() - this.getRemplissageEstomac())) {
								c.getAnimal().setViande(c.getAnimal().getViande() - (this.getTailleEstomac() - this.getRemplissageEstomac()));
								this.setRemplissageEstomac(this.getTailleEstomac());
							} 
							// sinon si l'animal a suffisament faim et que la case ne contient pas suffisament ou juste assez
							// de nourriture pour le rassasier, il mange tout la nourriture présente sur la case
							// le stock de nourriture tombe donc à 0
							else{
								this.setRemplissageEstomac(getRemplissageEstomac() + c.getAnimal().getViande());
								c.getAnimal().setViande(this.getTailleEstomac() - this.getRemplissageEstomac());
								c.getAnimal().setViande(0);
								c.setACadavre(false); 
							}
						}
					}			
					break;	// une fois que l'animal s'est nourri on arrête la boucle (un animal ne se nourrit qu'une seule fois par tour
				}

			}
		}
	}
	
	@Override
	public abstract void seReproduire();
}
