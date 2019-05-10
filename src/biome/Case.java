package biome;

import animaux.Animal;
import gestion.Gestionnaire;

/**
 * Classe permettant de gérer les cases
 * @author Paul, Armand et Louise
 *
 */
public abstract class Case {
	
	/**
	 * Le type d'occupation de la case (Herbe, eau, etc..)
	 */
	private  int typeOccupation;
	/**
	 * La case contient-elle un animal ? 
	 */
	private boolean estVide;
	/**
	 * La case contient-elle un cadavre ? 
	 */
	private boolean cadavre;
	/**
	 * La position de la case
	 */
	private int position[];
	
	
	/**
	 * Constructeur
	 * @param typeOccupation : Le type d'occupation de la case (Herbe, eau, etc..)
	 * @param estvide : La case contient-elle un animal ? 
	 * @param cadavre :La case contient-elle un cadavre ? 
	 * @param position : La position de la case
	 */
	public Case(int typeOccupation, boolean estvide, boolean cadavre, int[] position) {
		super();
		this.typeOccupation = typeOccupation;
		this.estVide = estvide;
		this.cadavre = cadavre;
		this.position = position;
	}
	
	/**
	 * getters et setters
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
					//System.out.println("Position animal"+animal.getEmplacement().getX()+" "+animal.getEmplacement().getY()+" "+animal.getEmplacement().getPosition());	
					//System.out.println("Position case"+this.getX()+" "+this.getY()+" "+this.getPosition());		
				}
			}
		}
		//System.out.println(animalRetour);
		return animalRetour;
	}

	public abstract int getTypeOccupation();// mettre les return ''sable, ou 0 etc'' dans les classes filles
	
	
}
