package biome;

import animaux.Animal;
import gestion.Gestionnaire;

public abstract class Case {
	
	private /*abstract*/ int typeOccupation;//pk quand jmets abstract il gueule
	private boolean estVide;
	private boolean cadavre;
	private int position[];
	
	
	
	public Case(int typeOccupation, boolean estvide, boolean cadavre, int[] position) {
		super();
		this.typeOccupation = typeOccupation;
		this.estVide = estvide;
		this.cadavre = cadavre;
		this.position = position;
	}
	/*
	public int getTypeOccupation() {
		return typeOccupation;
	}
*/
	public boolean getEstVide() {
		return estVide;
	}
	
	public void setEstVide(boolean b) {
		// TODO Auto-generated method stub
		this.estVide = b;
	}

	public boolean getCadavre() {
		return cadavre;
	}
	
	public void setACadavre(boolean b) {
		this.cadavre = b;
	}

	public int[] getPosition() {
		return position;
	}
	
	public int getX() {
		return position[0];
	}

	public int getY() {
		return position[1];
	}
	
	public abstract int getNourriture();
	
	public abstract void setNourriture(int nourriture);
	
	public abstract void recuperation();

	
	public Animal getAnimal() {
		Animal animalRetour = null;
		if (this.getEstVide() == false) {
			for (Animal animal : Gestionnaire.getAnimaux()) {
				if (animal.getEmplacement().getPosition().equals(this.getPosition())){
					animalRetour = animal;
				}
			}
		}
		return animalRetour;
	}

	public abstract int getTypeOccupation();// mettre les return ''sable, ou 0 etc'' dans les classes filles
	
	
}
