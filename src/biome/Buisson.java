package biome;

import gestion.Gestionnaire;

public class Buisson extends Case{

	/**
	 * stock de nourriture que contient le buisson
	 */
	private int nourriture;

	/**
	 * Constructeur
	 */
	public Buisson(int[] position) {
		super(1, true, false, position);
		this.nourriture=10;
	}
	
	public Buisson(int typeOccupation, boolean estvide, boolean cadavre, int[] position) {
		super(typeOccupation, estvide, cadavre, position);
		this.nourriture=10;
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
	 * methode qui recharge le stock de nouriiture que contient le buisson si il est vide
	 */
	public void recuperation() {

		if (nourriture==0) {

			int tourDeRecup = Gestionnaire.getTour();

			int recuperation=0;

			while(recuperation <= 3) {
				recuperation = Gestionnaire.getTour() - tourDeRecup;
				if(recuperation==3) {
					this.nourriture=10;
				}
			}
		}
	}
	
	public int getTypeOccupation() {
		return 1;
	}
	
}
