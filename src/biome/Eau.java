package biome;

/**
 * Cette classe sert à décrire les cases de type eau
 * @author Paul, Armand et Louise
 *
 */
public class Eau extends Case{
	
	/**
	 * Constructeur
	 * @param position : position de la case
	 */
	public Eau(int[] position) {
		super(2, true, false, position);
	}

	/**
	 * Constructeur
	 * @param typeOccupation : type d'occupation de la case (ici eau = 2)
	 * @param estvide : la case contient-elle un animal ?
	 * @param cadavre : la case contient-elle un cadavre ? 
	 * @param position : position de la case
	 */
	public Eau(int typeOccupation, boolean estvide, boolean cadavre, int[] position) {
		super(2, estvide, cadavre, position);
	}

	/**
	 * getters et setters
	 */
	@Override
	public int getTypeOccupation() {
		return 2;
	}

	@Override
	public int getNourriture() {
		return 0;
	}

	@Override
	public void setNourriture(int nourriture) {		
	}

	@Override
	public void recuperation() {
	}
	
}
