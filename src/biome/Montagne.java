package biome;

public class Montagne extends Case{

	public Montagne(int[] position) {
		super(7, true, false, position);
	}
	
	public Montagne(int typeOccupation, boolean estvide, boolean cadavre, int[] position) {
		super(7, estvide, cadavre, position);
	}

	@Override
	public int getTypeOccupation() {
		return 7;
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
