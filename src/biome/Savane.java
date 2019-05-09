package biome;

public class Savane extends Grille{

	/**
	 * Le constructeur de la classe, reutilisant le constructeur de la classe mere
	 * @param taille
	 */
	public Savane(int taille) {
		super(taille);
	}
	

	/**
	 * creation des zones d'eau, dans ce biome ce sera un lac en forme de cercle. Ce cercle est cree en quatres parties, une meilleure explication dans le rapport
	 */
	@Override
	public void creationEau() {
		
		//quart en haut a gauche
		for(int x=(int)(0.325*getTaille());x>=(int)(0.2*getTaille());x--) {
			for(int y=(int)(0.325-Math.sqrt(Math.pow(0.125*getTaille(),2)-Math.pow(x-0.325*getTaille(),2))+0.2*getTaille());y<=(int)(0.325*getTaille());y++) {
				int[] coord = new int[2];
				coord[0]=x;
				coord[1]=y;
				Eau eau = new Eau(coord);
				getGrille().get(x).set(y, eau);
			}
			}
		//quart en bas a gauche
		for(int x=(int)(0.325*getTaille());x<=(int)(0.45*getTaille());x++) {
			for(int y=(int)(0.325-Math.sqrt(Math.pow(0.125*getTaille(),2)-Math.pow(x-0.325*getTaille(),2))+0.2*getTaille());y<=(int)(0.325*getTaille());y++) {
				int[] coord = new int[2];
				coord[0]=x;
				coord[1]=y;
				Eau eau = new Eau(coord);
				getGrille().get(x).set(y, eau);
			}
			}
		//quart en haut a droite
		for(int x=(int)(0.325*getTaille());x>=(int)(0.2*getTaille());x--){
			for(int y=(int)(0.325*getTaille());y<=(int)(Math.sqrt(Math.pow(0.125*getTaille(),2)-Math.pow(x-0.325*getTaille(),2))+0.325*getTaille());y++) { 
				int[] coord = new int[2];
				coord[0]=x;
				coord[1]=y;
				Eau eau = new Eau(coord);
				getGrille().get(x).set(y, eau);
			}
			}
		//quart en bas a droite
		for(int x=(int)(0.325*getTaille());x<=(int)(0.45*getTaille());x++) {
			for(int y=(int)(0.325*getTaille());y<=(int)(Math.sqrt(Math.pow(0.125*getTaille(),2)-Math.pow(x-0.325*getTaille(),2))+0.325*getTaille());y++) { 
				int[] coord = new int[2];
				coord[0]=x;
				coord[1]=y;
				Eau eau = new Eau(coord);
				getGrille().get(x).set(y, eau);
			}
			}
			
	}
	
	@Override
	public void creationNeige() {
		// TODO Auto-generated method stub
		//		Methode vide car il n'y a pas de neige dans la savane
	}


	@Override
	public void creationMontagne() {
		// TODO Auto-generated method stub
		//		Methode vide car il n'y a pas de montagne dans la savane
	}
	
	/**
	 * Quantitee de buissons et d'arbres dans l'ecosysteme Savane ---> a mettre absolument dans une methode ??
	 */
	int arbre = (int)Math.pow(getTaille(),2)*5/(21*100);
	int buisson=(int)70*getTaille()/100;
	
	
	/**
	 * Methode qui cree la grille avec ses composantes, l'ajout successif des sols suit un ordre bien precis
	 */
	@Override
	public void creationGrille() {
		Savane savane = new Savane(getTaille());
		
		savane.creationArbre(arbre);
		savane.creationBuisson(buisson);
		savane.creationSable();
		savane.creationEau();
		savane.afficher();
	}
	
}
