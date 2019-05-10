package biome;

/**
 * Classe permettant de gérer le biome de type Steppe
 * @author Paul,Armand et Louise
 *
 */
public class Steppe extends Grille{

	/**
	 * Le constructeur de la classe, reutilisant le constructeur de la classe mere
	 * @param taille
	 */
	public Steppe(int taille) {
		super(taille);
	}

	@Override
	/**
	 * methode qui creer des petits lacs. Le nombre de lacs dependant directement de la taille de la grille donc pas de parametres en entree.
	 * Ces lacs sont de taille 3*3, repartits aleatoirement dans l'espace, ce lac ne peuvent pas entierement se superposer.
	 */
	public void creationEau() {
		int i=0;
		while(i<(int)getTaille()/10) {
			double a=Math.random()*getTaille();
			double b=Math.random()*getTaille();
			int x=(int)a;
			int y=(int)b;
			if(getGrille().get(x).get(y).getTypeOccupation()==2) {
				continue;
			}
			if((x-1)<0 || (x+1)>(getTaille()-1) || (y-1)<0 || (y+1)>(getTaille()-1)) { //gestion des bordures
				continue;
			}
			
			int[] coord = new int[2];
			coord[0]=x;
			coord[1]=y;
			Eau eau = new Eau(coord);
			getGrille().get(x-1).set(y-1, eau);
			getGrille().get(x-1).set(y, eau);
			getGrille().get(x-1).set(y+1, eau);
			getGrille().get(x).set(y-1, eau);
			getGrille().get(x).set(y, eau);
			getGrille().get(x).set(y+1, eau);
			getGrille().get(x+1).set(y-1, eau);
			getGrille().get(x+1).set(y, eau);
			getGrille().get(x+1).set(y+1, eau);
			
			i=i+1;
		}
	}

	/**
	 * Méthode permettant de créer de la neige
	 */
	@Override
	public void creationNeige() {
		// TODO Auto-generated method stub
		//	Methode vide car il n'y a pas de neige dans la steppe
	}
	
	/**
	 * Méthode permettant de créer des montagnes
	 */
	@Override
	public void creationMontagne() {
		// TODO Auto-generated method stub
		//	Methode vide car il n'y a pas de montagnes dans la steppe
	}
	

	/**
	 * Methode qui cree la grille avec ses composantes, l'ajout successif des sols suit un ordre bien precis
	 */
	@Override
	public void creationGrille() {
		int buisson = (int)Math.pow(getTaille(),2)*5/100;
		Steppe  steppe= new Steppe(getTaille());

		steppe.creationBuisson(buisson);
		steppe.creationEau();
		steppe.afficher();
	}



}
