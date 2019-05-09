package biome;

public class Eau extends Case{
	
	public Eau(int[] position) {
		super(2, true, false, position);
	}

	public Eau(int typeOccupation, boolean estvide, boolean cadavre, int[] position) {
		super(2, estvide, cadavre, position);
	}

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
