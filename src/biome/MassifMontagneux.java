package biome;

/**
 * Classe permettant de gérer le biome de type Massif Montagneux
 * @author Paul,Armand et Louise
 *
 */
public class MassifMontagneux extends Grille{
	
	/**
	 * Le constructeur de la classe, reutilisant le constructeur de la classe mere
	 * @param taille
	 */
	public MassifMontagneux(int taille) {
		super(taille);// appel au constructeur de sa classe mere : ''Grille''
	}
	
	/**
	 * Une methode qui cree la zone montagneuse de notre grille, l'explication de cette methode sera detaillee sur le rapport
	 */
	@Override
	public void creationMontagne() {
		// premier bloc
		double premiere=2*getTaille()/3; //premiere sequence, grand axe
		for(int x=0;x<=premiere;x++) {
			double a=(x*x);
			double b=(Math.pow(premiere,2));
			for(int y=0;y<=(int)(getTaille()/4)*Math.sqrt(1-(a/b));y++) { 
				int[] coord = new int[2];
				coord[0]=x;
				coord[1]=y;
				Montagne montagne = new Montagne(coord);
				getGrille().get(x).set(y, montagne);
			}
			}
		// deuxieme bloc
		for(int x=0;x<=3*getTaille()/4;x++) {
			double a=(x*x);
			double b=(Math.pow(3*getTaille()/4,2));
			for(int y=(int)(-(getTaille()/4)*Math.sqrt(1-(a/b))+2*(getTaille()/4)); y<=(getTaille()/2);y++) {
				
				int[] coord = new int[2];
				coord[0]=x;
				coord[1]=y;
				Montagne montagne = new Montagne(coord);
				getGrille().get(x).set(y, montagne);
			}
			}
		// troisieme bloc
		for(int x=0;x<=3*getTaille()/4;x++) {
			double a=(x*x);
			double b=(Math.pow(3*getTaille()/4,2));
			for(int y=getTaille()/2;y<=(int)(getTaille()/4)*Math.sqrt(1-(a/b))+getTaille()/2;y++) {
				
				int[] coord = new int[2];
				coord[0]=x;
				coord[1]=y;
				Montagne montagne = new Montagne(coord);
				getGrille().get(x).set(y, montagne);
			}
			}
		// quatrieme bloc
		for(int x=0;x<=4*getTaille()/5;x++) {
			double a=(x*x);
			double b=(Math.pow(4*getTaille()/5,2));
			for(int y=(int)((getTaille()/4)-(getTaille()/4)*Math.sqrt(1-(a/b))+3*getTaille()/4); y<getTaille();y++) {
				
				int[] coord = new int[2];
				coord[0]=x;
				coord[1]=y;
				Montagne montagne = new Montagne(coord);
				getGrille().get(x).set(y, montagne);
			}
			}
	}
	
	/**
	 * Une methode qui creer les rivieres qui partent de la montagne. Elles seront larges de trois cases sauf quand celles-ci sont sur une zone de montagne ou une zone de neige elles seront larges d'une case
	 */
	@Override
	public void creationEau() {
		//premiere riviere
		int y=(int)this.getTaille()/4;
		for(int x=(int)this.getTaille()/9;x<this.getTaille();x++) {
			if(getGrille().get(x).get(y-1).getTypeOccupation()==7 ||
				getGrille().get(x).get(y-1).getTypeOccupation()==5) {
				int[] coord = new int[2];
				coord[0]=x;
				coord[1]=y;
				Eau eau = new Eau(coord);
				getGrille().get(x).set(y, eau);
			}
			else {
				int[] coord = new int[2];
				coord[0]=x;
				coord[1]=y;
				Eau eau = new Eau(coord);
				getGrille().get(x).set(y-1, eau);
				getGrille().get(x).set(y, eau);
				getGrille().get(x).set(y+1, eau);
			}
		}
		//seconde riviere
		int v=(int)3*this.getTaille()/4;
		for(int x=(int)this.getTaille()/9;x<this.getTaille();x++) {
			if(getGrille().get(x).get(v-1).getTypeOccupation()==7 ||
				getGrille().get(x).get(v-1).getTypeOccupation()==5) {
				int[] coord = new int[2];
				coord[0]=x;
				coord[1]=y;
				Eau eau = new Eau(coord);
				getGrille().get(x).set(v, eau);
			}
			else {
				int[] coord = new int[2];
				coord[0]=x;
				coord[1]=y;
				Eau eau = new Eau(coord);
				getGrille().get(x).set(v-1, eau);
				getGrille().get(x).set(v, eau);
				getGrille().get(x).set(v+1, eau);
			}
		}
	}
	
	/**
	 * Une methode qui cree le glacier au sommet de la montagne et un peu de neige dans les versants.
	 */
	public void creationNeige() {
		//creation du glacier
		for(int x=0;x<=(int)(this.getTaille()/4)*0.6;x++) {
			for(int y=0;y<(int)(this.getTaille());y++){
				int[] coord = new int[2];
				coord[0]=x;
				coord[1]=y;
				Neige neige = new Neige(coord);
				getGrille().get(x).set(y, neige);
			}
		}
		//creation de neige de facon aleatoire dans la montagne.
		int neige=(int)(getTaille()*100/30);
		int i=0;
		while(i<neige) {
			double a=Math.random()*this.getTaille();
			double b=Math.random()*this.getTaille();
			int x=(int)a;
			int y=(int)b;
			if(getGrille().get(x).get(y).getTypeOccupation()==5) {
				continue;
			}
			if (getGrille().get(x).get(y).getTypeOccupation()==7) {
				int[] coord = new int[2];
				coord[0]=x;
				coord[1]=y;
				Neige neige1 = new Neige(coord);
				getGrille().get(x).set(y, neige1);
			}
			i=i+1;
		}
	}
	
	/**
	 * Quantitee de buissons et d'arbres dans l'ecosysteme MassifMontagneux ---> a mettre absolument dans une methode ??
	 */
	int arbre = (int)(Math.pow(getTaille(),2)*5/(21*100));
	int buisson=(int)70*getTaille()/100;
	
	/**
	 * Methode qui cree la grille avec ses composantes, l'ajout successif des sols suit un ordre bien precis
	 */
	@Override
	public void creationGrille() {
		
		MassifMontagneux massif = new MassifMontagneux(getTaille());
		
		massif.creationMontagne();	
		massif.creationNeige();
		massif.creationArbre(arbre);
		massif.creationBuisson(buisson);
		massif.creationEau();
		massif.afficher();
	}
	
	

	
	
	
}
