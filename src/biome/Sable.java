package biome;

/**
 * Cette classe sert à décrire les cases de type eau
 * @author Paul, Armand et Louise
 *
 */
public class Sable extends Case{

	/**
	 * Constructeur
	 * @param position : position de la case
	 */
	public Sable(int[] position) {
		super(4, true, false, position);
	}
	
	/**
	 * Constructeur
	 * @param typeOccupation : type d'occupation de la case (ici eau = 2)
	 * @param estvide : la case contient-elle un animal ?
	 * @param cadavre : la case contient-elle un cadavre ? 
	 * @param position : position de la case
	 */
	public Sable(int typeOccupation, boolean estvide, boolean cadavre, int[] position) {
		super(4, estvide, cadavre, position);
	}

	/**
	 * getters et setters
	 */
	@Override
	public int getTypeOccupation() {
		return 4;
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
