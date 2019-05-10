package animaux;

import java.util.ArrayList;
import java.util.Arrays;

import biome.Case;
import biome.Grille;
import gestion.Gestionnaire;



public abstract class Animal {

	/**
	 * identifiant de l'individu, cet identifiant permet au gestionnaire de faire "jouer" les individus
	 */
	int id;

	/**
	 * numéro du tour où l'animal est né
	 */
	private int dateNaissance;

	/**
	 * numéro du tour où l'animal décède (change chaque tour jusqu'à sa mort)
	 */
	private int dateDeces;

	/**
	 * Si l'animal peut accéder à la foret
	 */
	protected boolean accesForet;

	/**
	 * Valeur indiquant l'age jusqu'auquel l'animal peut vivre 
	 */
	protected int esperanceVie;

	/**
	 * objet de type Case sur laquelle se trouve l'animal
	 */
	private Case emplacement;

	/**
	 * indique la vitesse de déplacement de l'animal
	 */
	protected int vitesse;

	/**
	 * Si l'animal est vivant
	 */
	private boolean estVivant;

	/**
	 * définit le nom de l'espèce d'animal
	 */
	protected String espece;

	/**
	 * définit la quantité totale de nourriture que l'animal peut manger
	 */
	protected int tailleEstomac;

	/**
	 * définit l'appétit de l'animal. plus ce nombre est faible plus l'animal aura besoin de nourriture ce nombre décroit chaque tour
	 */
	private int remplissageEstomac;

	/**
	 * 
	 */
	protected int viande;

	/**
	 * définit l'age auquel l'animal est assez grand pour se reproduire
	 */
	private boolean maturite;

	/**
	 * si l'animal a procréé récemment 
	 */
	private boolean aProcree;

	/**
	 *  Indique le nombre de tours restants lorsque l'animal est en état de famine
	 */
	private int meurtFaim;

	/**
	 * Constructeur	
	 * @param id : identifiant de l'individu, cet identifiant permet au gestionnaire de faire "jouer" les individus
	 * @param dateNaissance : int numéro du tour où l'animal est né
	 * @param dateDeces : int numéro du tour où l'animal décède (change chaque tour jusqu'à sa mort)
	 * @param emplacement : objet de type Case sur laquelle se trouve l'animal
	 * @param remplissageEstomac : int définit l'appétit de l'animal. plus ce nombre est faible plus l'animal aura besoin de nourriture ce nombre décroit chaque tour
	 * @param maturite : définit l'age auquel l'animal est assez grand pour se reproduire
	 * @param aProcree : si l'animal a procréé récemment 
	 * @param meurtFaim : Indique le nombre de tours restants lorsque l'animal est en état de famine
	 */
	public Animal(int dateNaissance, Case emplacement, boolean maturite, boolean aProcree, int meurtFaim) {
		this.id = Gestionnaire.getAnimaux().size() + 1;
		this.dateNaissance = dateNaissance;
		this.emplacement = emplacement;
		this.estVivant = true;
		this.remplissageEstomac = tailleEstomac/2 % 1;
		this.maturite = maturite;
		this.aProcree = aProcree;
		this.meurtFaim = meurtFaim;
	}

	/**
	 * getters et setters
	 */
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(int dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public int getDateDeces() {
		return dateDeces;
	}

	public void setDateDeces(int dateDeces) {
		this.dateDeces = dateDeces;
	}

	public int getEsperanceVie() {
		return esperanceVie;
	}

	public void setEsperanceVie(int esperanceVie) {
		this.esperanceVie = esperanceVie;
	}

	public Case getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(Case emplacement){
		this.emplacement = emplacement;
	}

	public int getVistesse() {
		return this.vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public boolean getEstVivant() {
		return estVivant;
	}

	public void setEstVivant(boolean etat) {
		this.estVivant = etat;
	}

	public String getEspece() {
		return this.espece;
	}

	public void setEspece(String espece) {
		this.espece = espece;
	}

	public int getTailleEstomac() {
		return this.tailleEstomac;
	}

	public void setTailleEstomac(int tailleEstomac) {
		if(tailleEstomac < 0) {
			this.tailleEstomac = 0;
		} else {
			this.tailleEstomac = tailleEstomac;
		}
	}

	public int getRemplissageEstomac() {
		return this.remplissageEstomac;
	}

	public void setRemplissageEstomac(int remplissageEstomac) {
		this.remplissageEstomac = this.remplissageEstomac + remplissageEstomac;
		if (remplissageEstomac >= this.tailleEstomac) {
			this.remplissageEstomac = this.tailleEstomac;
		}
		else if(remplissageEstomac < 0) {
			this.remplissageEstomac = 0;
		} 
	}

	public int getViande() {
		return this.viande;
	}

	public void setViande(int viande) {
		this.viande = viande;
	}

	public boolean getMaturite() {
		return this.maturite;
	}

	public void setMaturite(boolean maturite) {
		this.maturite = maturite;
	}

	public boolean getAProcree() {
		return this.aProcree;
	}

	public void setAProcree(boolean aProcree) {
		this.aProcree = aProcree;
	}

	public int getMeurtFaim() {
		return this.meurtFaim;
	}

	public void setMeurtFaim(int meurtFaim) {
		this.meurtFaim = meurtFaim;
	}

	/**
	 * Cette méthode remplit l'estomac de l'animal s'il n'est pas déjà plein. 
	 * La case sur laquelle il est diminue également en quantité de nourriture.
	 * Elle est définie dans les classes Carnivore, Charognard et Herbivore
	 */
	public abstract void seNourrir() ;

	/**
	 * Cette méthode déplace l'animal sur une case, à l'aide d'un Random pour la direction (et en fonction de l'occupation  
	 * des cases alentours) et de sa vitesse, nous allons tester pour chacune des directions alentours
	 */
	public void seDeplacer(int tailleGrille) {
		int direction=(int)(Math.random() * 9);	// on choisit un nombre entre 1 et 9 qui determinera quelle direction suivra l'animal
		Case caseSuivante; 
		if (direction == 1) {
			if(this.getEmplacement().getX() - this.vitesse < 0 && this.getEmplacement().getY() + this.vitesse>(tailleGrille-1)) {
				caseSuivante=Grille.getCase(this.getEmplacement().getX()+tailleGrille-this.vitesse,this.getEmplacement().getY()-tailleGrille+ this.vitesse);
			}
			else if (this.getEmplacement().getX() - this.vitesse<0) {
				caseSuivante=Grille.getCase(this.getEmplacement().getX()+tailleGrille-this.vitesse,this.getEmplacement().getY() + this.vitesse);
			}
			else if (this.getEmplacement().getY() + this.vitesse>(tailleGrille-1)){
				caseSuivante = Grille.getCase(this.getEmplacement().getX() - this.vitesse, this.getEmplacement().getY()-tailleGrille + this.vitesse);
			}
			else {
				caseSuivante = Grille.getCase(this.getEmplacement().getX() - this.vitesse, this.getEmplacement().getY() + this.vitesse);
			}
			
			if(caseSuivante.getEstVide() == false) {
				this.seDeplacer(tailleGrille);
			}
			Grille.getCase(this.getEmplacement().getX(),this.getEmplacement().getY()).setEstVide(true);
			this.setEmplacement(caseSuivante);
			caseSuivante.setEstVide(false);
			
			
		}

		if(direction==2) {
			if(this.getEmplacement().getX() - this.vitesse<0 && this.getEmplacement().getY() + this.vitesse>29) {
				caseSuivante=Grille.getCase(this.getEmplacement().getX()+tailleGrille-this.vitesse,this.getEmplacement().getY()-tailleGrille+ this.vitesse);
			}
			else if (this.getEmplacement().getX() - this.vitesse<0) {
				caseSuivante=Grille.getCase(this.getEmplacement().getX()+tailleGrille-this.vitesse,this.getEmplacement().getY() + this.vitesse);
			}
			else if (this.getEmplacement().getY() + this.vitesse>(tailleGrille-1)){
				caseSuivante = Grille.getCase(this.getEmplacement().getX() - this.vitesse, this.getEmplacement().getY()-tailleGrille + this.vitesse);
			}
			else {
				caseSuivante = Grille.getCase(this.getEmplacement().getX() - this.vitesse, this.getEmplacement().getY() + this.vitesse);
			}
			
			if(caseSuivante.getEstVide() == false) {
				this.seDeplacer(tailleGrille);
			}
			Grille.getCase(this.getEmplacement().getX(),this.getEmplacement().getY()).setEstVide(true);
			this.setEmplacement(caseSuivante);
			caseSuivante.setEstVide(false);
			
		}

		if(direction==3) {
			if(this.getEmplacement().getX() - this.vitesse<0 && this.getEmplacement().getY() + this.vitesse>(tailleGrille-1)) {
				caseSuivante=Grille.getCase(this.getEmplacement().getX()+tailleGrille-this.vitesse,this.getEmplacement().getY()-tailleGrille+ this.vitesse);
			}
			else if (this.getEmplacement().getX() - this.vitesse<0) {
				caseSuivante=Grille.getCase(this.getEmplacement().getX()+tailleGrille-this.vitesse,this.getEmplacement().getY() + this.vitesse);
			}
			else if (this.getEmplacement().getY() + this.vitesse>(tailleGrille-1)){
				caseSuivante = Grille.getCase(this.getEmplacement().getX() - this.vitesse, this.getEmplacement().getY()-tailleGrille + this.vitesse);
			}
			else {
				caseSuivante = Grille.getCase(this.getEmplacement().getX() - this.vitesse, this.getEmplacement().getY() + this.vitesse);
			}
			
			if(caseSuivante.getEstVide() == false) {
				this.seDeplacer(tailleGrille);
			}
			Grille.getCase(this.getEmplacement().getX(),this.getEmplacement().getY()).setEstVide(true);
			this.setEmplacement(caseSuivante);
			caseSuivante.setEstVide(false);
			
		}

		if(direction==4) {
			if(this.getEmplacement().getX() - this.vitesse<0 && this.getEmplacement().getY() + this.vitesse>(tailleGrille-1)) {
				caseSuivante=Grille.getCase(this.getEmplacement().getX()+tailleGrille-this.vitesse,this.getEmplacement().getY()-tailleGrille+ this.vitesse);
			}
			else if (this.getEmplacement().getX() - this.vitesse<0) {
				caseSuivante=Grille.getCase(this.getEmplacement().getX()+tailleGrille-this.vitesse,this.getEmplacement().getY() + this.vitesse);
			}
			else if (this.getEmplacement().getY() + this.vitesse>(tailleGrille-1)){
				caseSuivante = Grille.getCase(this.getEmplacement().getX() - this.vitesse, this.getEmplacement().getY()-tailleGrille + this.vitesse);
			}
			else {
				caseSuivante = Grille.getCase(this.getEmplacement().getX() - this.vitesse, this.getEmplacement().getY() + this.vitesse);
			}
			
			if(caseSuivante.getEstVide() == false) {
				this.seDeplacer(tailleGrille);
			}
			Grille.getCase(this.getEmplacement().getX(),this.getEmplacement().getY()).setEstVide(true);
			this.setEmplacement(caseSuivante);
			caseSuivante.setEstVide(false);
			
		}
		if(direction==5) {
			if(this.getEmplacement().getX() - this.vitesse<0 && this.getEmplacement().getY() + this.vitesse>(tailleGrille-1)) {
				caseSuivante=Grille.getCase(this.getEmplacement().getX()+tailleGrille-this.vitesse,this.getEmplacement().getY()-tailleGrille+ this.vitesse);
			}
			else if (this.getEmplacement().getX() - this.vitesse<0) {
				caseSuivante=Grille.getCase(this.getEmplacement().getX()+tailleGrille-this.vitesse,this.getEmplacement().getY() + this.vitesse);
			}
			else if (this.getEmplacement().getY() + this.vitesse>(tailleGrille-1)){
				caseSuivante = Grille.getCase(this.getEmplacement().getX() - this.vitesse, this.getEmplacement().getY()-tailleGrille + this.vitesse);
			}
			else {
				caseSuivante = Grille.getCase(this.getEmplacement().getX() - this.vitesse, this.getEmplacement().getY() + this.vitesse);
			}
			
			if(caseSuivante.getEstVide() == false) {
				this.seDeplacer(tailleGrille);
			}
			Grille.getCase(this.getEmplacement().getX(),this.getEmplacement().getY()).setEstVide(true);
			this.setEmplacement(caseSuivante);
			caseSuivante.setEstVide(false);
			
		}

		if (direction==6) {
			if(this.getEmplacement().getX() - this.vitesse<0 && this.getEmplacement().getY() + this.vitesse>(tailleGrille-1)) {
				caseSuivante=Grille.getCase(this.getEmplacement().getX()+tailleGrille-this.vitesse,this.getEmplacement().getY()-tailleGrille+ this.vitesse);
			}
			else if (this.getEmplacement().getX() - this.vitesse<0) {
				caseSuivante=Grille.getCase(this.getEmplacement().getX()+tailleGrille-this.vitesse,this.getEmplacement().getY() + this.vitesse);
			}
			else if (this.getEmplacement().getY() + this.vitesse>(tailleGrille-1)){
				caseSuivante = Grille.getCase(this.getEmplacement().getX() - this.vitesse, this.getEmplacement().getY()-tailleGrille + this.vitesse);
			}
			else {
				caseSuivante = Grille.getCase(this.getEmplacement().getX() - this.vitesse, this.getEmplacement().getY() + this.vitesse);
			}
			
			if(caseSuivante.getEstVide() == false) {
				this.seDeplacer(tailleGrille);
			}
			Grille.getCase(this.getEmplacement().getX(),this.getEmplacement().getY()).setEstVide(true);
			this.setEmplacement(caseSuivante);
			caseSuivante.setEstVide(false);
			
		}

		if(direction==7) {
			if(this.getEmplacement().getX() - this.vitesse<0 && this.getEmplacement().getY() + this.vitesse>(tailleGrille-1)) {
				caseSuivante=Grille.getCase(this.getEmplacement().getX()+tailleGrille-this.vitesse,this.getEmplacement().getY()-tailleGrille+ this.vitesse);
			}
			else if (this.getEmplacement().getX() - this.vitesse<0) {
				caseSuivante=Grille.getCase(this.getEmplacement().getX()+tailleGrille-this.vitesse,this.getEmplacement().getY() + this.vitesse);
			}
			else if (this.getEmplacement().getY() + this.vitesse>(tailleGrille-1)){
				caseSuivante = Grille.getCase(this.getEmplacement().getX() - this.vitesse, this.getEmplacement().getY()-tailleGrille + this.vitesse);
			}
			else {
				caseSuivante = Grille.getCase(this.getEmplacement().getX() - this.vitesse, this.getEmplacement().getY() + this.vitesse);
			}
			
			if(caseSuivante.getEstVide() == false) {
				this.seDeplacer(tailleGrille);
			}
			Grille.getCase(this.getEmplacement().getX(),this.getEmplacement().getY()).setEstVide(true);
			this.setEmplacement(caseSuivante);
			caseSuivante.setEstVide(false);
			
		}

		if(direction==8) {
			if(this.getEmplacement().getX() - this.vitesse<0 && this.getEmplacement().getY() + this.vitesse>(tailleGrille-1)) {
				caseSuivante=Grille.getCase(this.getEmplacement().getX()+tailleGrille-this.vitesse,this.getEmplacement().getY()-tailleGrille+ this.vitesse);
			}
			else if (this.getEmplacement().getX() - this.vitesse<0) {
				caseSuivante=Grille.getCase(this.getEmplacement().getX()+tailleGrille-this.vitesse,this.getEmplacement().getY() + this.vitesse);
			}
			else if (this.getEmplacement().getY() + this.vitesse>(tailleGrille-1)){
				caseSuivante = Grille.getCase(this.getEmplacement().getX() - this.vitesse, this.getEmplacement().getY()-tailleGrille + this.vitesse);
			}
			else {
				caseSuivante = Grille.getCase(this.getEmplacement().getX() - this.vitesse, this.getEmplacement().getY() + this.vitesse);
			}
			
			if(caseSuivante.getEstVide() == false) {
				this.seDeplacer(tailleGrille);
			}
			Grille.getCase(this.getEmplacement().getX(),this.getEmplacement().getY()).setEstVide(true);
			this.setEmplacement(caseSuivante);
			caseSuivante.setEstVide(false);
		}
		//ArrayList position=(caseSuivante.getX(),caseSuivante.getY());
	}

	/**
	 * méthode qui permet à l'animal de se reproduire avec un autre animal de la meme espece
	 */
	public abstract void seReproduire();

	/**
	 * Cette méthode s'active si l'estomac de l'animal est vide. Elle lui compte un certain nombre de tours avant qu'il 
	 * ne meure de faim.
	 */
	public boolean famine() {
		boolean famine=false;
		if (estVivant == false) {					// on passe à la suite du tour
		} else if (remplissageEstomac == 0) {		// sinon si l'estomac est vide
			meurtFaim = meurtFaim - 1;				// le compteur qui dit combien de temps l'animal peut vivre sans manger prend - 1
			if (meurtFaim == 0) {                   // si ce compteur atteint zéro		
				famine=true;				        // cette fonction renvoie true et il mourra au prochain tour
			}					
			else {
				famine=false;} // sinon on passe à la suite du tour
		}
		return famine;
	}

	/**
	 * Méthode permettant d'afficher l'animal
	 *//*
	public void afficherAnimal() {
		Jpanel.repaint();
		JPanel.revalidate();
		protected void paintComponent(Graphics g) {
		public void rafraichir (){
		// on vide le jpanel
		this.getContentPane().removeAll();
		// on le reconstuit a partir de la grille mise a jour
		((JPanelGrille)this.getContentPane()).construire();
		this.getContentPane().revalidate();
		}
		//
		// y a des trucs à faire avec tout ça, peut-êtr evoir avec hugo
	}*/


	/**
	 * cette méthode s'active lorsque l'animal décède
	 * elle gère le décès de l'animal
	 */
	public void decede() {

		this.setEstVivant(false);						// on dit que l'animal n'est plus vivant
		this.setDateDeces(Gestionnaire.getTour());		// on enregistre la date du deces
		this.emplacement.setEstVide(true);				// la case devient vide (il n'y a plus d'animal dessus)
		this.emplacement.setACadavre(true);				// il y a maintenant un cadavre sur la case
	}

	/**
	 * 	Une fois qu'un animal est décédé, il a un certain nombre de tours pour se décomposer, qui est réduit si un charognard le mange.
	 * 	Cette méthode gère la décomposition et fait disparaitre l'animal de la case et donc de la grille.
	 * Cette fonction est lancée dans le getionnaire à chaque début de tour
	 */
	public void seDecomposer(){
		if (this.getEmplacement().getCadavre() == true) {		// on vérifie que l'animal ne s'est pas encore décomposé

			//		une fois que la viande arrive à 0 l'animal disparait de la case
			// 		on met le test avant l'action de faire perdre de la viande à l'animal
			//		pour ne pas que le gestionnaire fasse perdre de la viande à un animal déjà décomposé
			// si la viande est déjà à 0 alors on ne décompose pas l'animal et on ne met plus le aCadavre de la case sur false

			if (this.getViande() == 0 || this.getViande() < 0) {
				this.setViande(0);
			}
			//		l'animal perd jusqu'à 2 de viande par tour
			// on met un deucième test ici pour éviter que si il y a 2 animaux morts sur la même case 
			// l'un d'eux ne se décompose pas si aCadavre prend faux à chaque tour
			this.setViande(this.getViande() - (Gestionnaire.getTour() - this.dateDeces)%2);
			if (this.getViande() == 0 || this.getViande() < 0) {
				this.setViande(0);
				this.getEmplacement().setACadavre(false);
			}
		}
	}
}