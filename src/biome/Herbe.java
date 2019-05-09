package biome;

import gestion.Gestionnaire;

public class Herbe extends Case{
	
	/**
	 * stock de nourriture que contient l'herbe
	 */
	private int nourriture;

	/**
	 * Constructeur
	 */
	public Herbe(int[] position) {
		super(0, true, false, position);
		this.nourriture=10;
	}
	
	public Herbe(int typeOccupation, boolean estvide, boolean cadavre, int[] position) {
		super(0, estvide, cadavre, position);
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
	 * methode qui recharge le stock de nourriture que contient le buisson si il est vide
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
		return 0;
	}
	
}
/*
 public void afficher() {
	 System.out.println(nourriture);
 }
*/