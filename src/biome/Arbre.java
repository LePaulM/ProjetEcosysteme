package biome;

import gestion.Gestionnaire;

/**
 * Cette classe sert à décrire les cases de type eau
 * @author Paul, Armand et Louise
 *
 */
public class Arbre extends Case{
	/**
	 * stock de nourriture que contient la foret
	 */
	private int nourriture;

	/**
	 * Constructeur
	 * @param position : position de la case
	 */
	public Arbre(int[] position) {
		super(3, true, false, position);
		this.nourriture=20;
	}
	
	/**
	 * Constructeur
	 * @param typeOccupation : type d'occupation de la case (ici eau = 2)
	 * @param estvide : la case contient-elle un animal ?
	 * @param cadavre : la case contient-elle un cadavre ? 
	 * @param position : position de la case
	 */
	public Arbre(int typeOccupation, boolean estvide, boolean cadavre, int[] position) {
		super(3, estvide, cadavre, position);
		this.nourriture=20;
	}


	/**
	 * Getter
	 * @return
	 */
	public int getNourriture() {
		return nourriture;
	}


	/**
	 * Setter
	 * @param nourriture
	 */
	public void setNourriture(int nourriture) {
		this.nourriture = nourriture;
	}
	



	/**
	 * méthode qui recharge le stock de nouriiture que contient le buisson si il est vide
	 */
	public void recuperation() {

		if (nourriture==0) {

			int tourDeRecup = Gestionnaire.getTour();

			int recuperation=0;

			while(recuperation <= 3) {
				recuperation = Gestionnaire.getTour() - tourDeRecup;
				if(recuperation==3) {
					this.nourriture=20;
				}
			}
		}
	}

	/**
	 * getter
	 */
	@Override
	public int getTypeOccupation() {
		return 3;
	}
	
}
