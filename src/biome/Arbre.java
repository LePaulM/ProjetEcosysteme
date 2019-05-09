package biome;

import gestion.Gestionnaire;

public class Arbre extends Case{
	/**
	 * stock de nourriture que contient la foret
	 */
	private int nourriture;

	/**
	 * Constructeur
	 */
	public Arbre(int[] position) {
		super(3, true, false, position);
		this.nourriture=20;
	}
	
	
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

	@Override
	public int getTypeOccupation() {
		return 3;
	}
	
}
