package biome;

public class Sable extends Case{

	public Sable(int[] position) {
		super(4, true, false, position);
	}
	
	public Sable(int typeOccupation, boolean estvide, boolean cadavre, int[] position) {
		super(4, estvide, cadavre, position);
	}

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
