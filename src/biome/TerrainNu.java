package biome;

public class TerrainNu extends Case{
	
	public TerrainNu(int[] position) {
		super(6, true, false, position);
	}

	public TerrainNu(int typeOccupation, boolean estvide, boolean cadavre, int[] position) {
		super(6, estvide, cadavre, position);
	}

	@Override
	public int getTypeOccupation() {
		return 6;
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
