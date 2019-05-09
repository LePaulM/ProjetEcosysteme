package biome;

/**
 * Cette classe sert à décrire les cases de type neige
 * @author Paul, Armand et Louise
 *
 */
public class Neige extends Case{

	/**
	 * Constructeur
	 * @param position : position de la case
	 */
	public Neige(int[] position) {
		super(5, true, false, position);
	}
	
	/**
	 * Constructeur
	 * @param typeOccupation : type d'occupation de la case (ici eau = 2)
	 * @param estvide : la case contient-elle un animal ?
	 * @param cadavre : la case contient-elle un cadavre ? 
	 * @param position : position de la case
	 */
	public Neige(int typeOccupation, boolean estvide, boolean cadavre, int[] position) {
		super(5, estvide, cadavre, position);
	}

	/**
	 * getters et setters
	 */
	@Override
	public int getTypeOccupation() {
		return 5;
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
