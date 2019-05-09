package biome;


public class Syberie extends Grille{

	/**
	 * Le constructeur de la classe, reutilisant le constructeur de la classe mere
	 * @param taille
	 */
	public Syberie(int taille) {
		super(taille);
	}

	/**
	 * Methode qui cree une repartition aleatoire de neige dans la grille, la neige va remplir 70% de la grille. Seule regle : lors de la generation de case neige, la neige ne peut pas aller sur de la neige deja presente
	 */
	@Override
	public void creationNeige() {
		int neige=(int)(Math.pow(getTaille(), 2)*70/100);
		int i=0;
		while(i<neige) {
			double a=Math.random()*getTaille();
			double b=Math.random()*getTaille();
			int x=(int)a;
			int y=(int)b;
			if(getGrille().get(x).get(y).getTypeOccupation()==5) {
				continue;
			}
			if (getGrille().get(x).get(y).getTypeOccupation()==2) {
				continue;
			}
			int[] coord = new int[2];
			coord[0]=x;
			coord[1]=y;
			Neige neige1 = new Neige(coord);
			getGrille().get(x).set(y, neige1);

			i=i+1;
		}
	}
	
	/**
	 * Methode qui cree une petite zone de montagne dans le coin en haut a gauche
	 */
	@Override
	public void creationMontagne() {
		double a = getTaille()*0.2;//axe des x
		double b = getTaille()*0.8;//axe des y
		for(int x=0;x<=(int)(a);x++) {
			for(int y=0;y<=(int)(b*Math.sqrt(1-((x*x)/(a*a))));y++){
				int[] coord = new int[2];
				coord[0]=x;
				coord[1]=y;
				Montagne montagne = new Montagne(coord);
				getGrille().get(x).set(y, montagne);
			}
		}
	}
	
	
	/**
	 * methode qui creer un cours d'eau avec plusieurs ramifications, crees independemments sous forme de troncons
	 */
	@Override
	public void creationEau() {
	/**
	* troncon 1
	*/
	for(int x=(int)getTaille()/7;x<=(int)3*getTaille()/7;x++) {
			int y=(int)getTaille()/4;
			int[] coord = new int[2];
			coord[0]=x;
			coord[1]=y;
			Eau eau = new Eau(coord);
			getGrille().get(x).set(y-1, eau);
			getGrille().get(x).set(y, eau);
			getGrille().get(x).set(y+1, eau);
			
		}
	/**
	 * troncon 2
	*/
	for(int x=(int)3*getTaille()/7-2;x<=(int)5*getTaille()/7;x++) {
		int y=(int)getTaille()/4+3;
		int[] coord = new int[2];
		coord[0]=x;
		coord[1]=y;
		Eau eau = new Eau(coord);
		getGrille().get(x).set(y-1, eau);
		getGrille().get(x).set(y, eau);
		getGrille().get(x).set(y+1, eau);
	}
	/**
	 * troncon 3
	 */
	for(int y=(int)getTaille()/4+5;y<=(int)2*getTaille()/4;y++) {
		int x=(int)5*getTaille()/7-1;
		int[] coord = new int[2];
		coord[0]=x;
		coord[1]=y;
		Eau eau = new Eau(coord);
		getGrille().get(x-1).set(y, eau);
		getGrille().get(x).set(y, eau);
		getGrille().get(x+1).set(y, eau);
	}
	/**
	 * troncon 4
	 */
	for(int x=(int)5*getTaille()/7-2;x<(int)getTaille();x++) {
		int y=(int)2*getTaille()/4+2;
		int[] coord = new int[2];
		coord[0]=x;
		coord[1]=y;
		Eau eau = new Eau(coord);
		getGrille().get(x).set(y-1, eau);
		getGrille().get(x).set(y, eau);
		getGrille().get(x).set(y+1, eau);
	}
	/**
	 * troncon 5
	 */
	for(int y=(int)getTaille()/4+3;y<=(int)3*getTaille()/4;y++) {
		int x=(int)getTaille()/2;
		int[] coord = new int[2];
		coord[0]=x;
		coord[1]=y;
		Eau eau = new Eau(coord);
		getGrille().get(x-1).set(y, eau);
		getGrille().get(x).set(y, eau);
		getGrille().get(x+1).set(y, eau);
	}
}
	
	/**
	 * Quantitee de arbres l'ecosysteme Siberie ---> a mettre absolument dans une methode ??
	 */
	int arbre = (int)Math.pow(getTaille(),2)*70/(21*100);
	
	/**
	 * Methode qui cree la grille avec ses composantes, l'ajout successif des sols suit un ordre bien precis
	 */
	@Override
	public void creationGrille() {
		Syberie syberie = new Syberie(getTaille());
		
		syberie.creationMontagne();	
		syberie.creationArbre(arbre);
		syberie.creationNeige();
		syberie.creationEau();
		syberie.afficher();
	}
	
}
