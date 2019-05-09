package animaux;

import java.awt.Color;

import biome.Case;
import biome.Grille;
import gestion.Gestionnaire;



public abstract class Animal {
	int id;
	private int dateNaissance;
	private int dateDeces;
	protected boolean accesForet;
	protected int esperanceVie;
	private Case emplacement;
	protected int vitesse;
	private boolean estVivant;
	private String espece;
	protected int tailleEstomac;
	private int remplissageEstomac;
	protected int viande;
	private boolean maturite;
	private boolean aProcree;
	private int meurtFaim;

	/**
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


	// il faut changer famine() de place dans les diagrammes de sequence
	//ca ne sert à rien de faire des tests sur des animaux mort - Paul

	public Animal(int dateNaissance,  Case emplacement,  boolean maturite,
			boolean aProcree,int meurtFaim) {

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
	 * des cases alentours) et de sa vitesse
	 */
	public void seDeplacer() {
		int direction=(int)(Math.random() * 9);					// 		on choisit un nombre entre 1 et 9 qui determinera quelle direction suivra l'animal
		if (direction==1) {
			Case caseSuivante = Grille.getCase(this.getEmplacement().getX() - this.vitesse,this.getEmplacement().getY() + this.vitesse);		//		on définit ce qui sera la prochaine case
			if (caseSuivante.getEstVide() == true) {				//		si la case est vide
				if (caseSuivante.getTypeOccupation() != 2) {
					this.setEmplacement(caseSuivante);				//		on y va
					caseSuivante.setEstVide(false);					//		la case n'est plus vide
					}					
			} else {
				this.seDeplacer();								//		si la case n'est pas vide on recommence
			}
		}
		if(direction==2) {
			int nouveauX = this.getEmplacement().getX();
			int nouveauY = this.getEmplacement().getY() + this.vitesse;
			Case caseSuivante = Grille.getCase(nouveauX,nouveauY);
			if (caseSuivante.getEstVide() == true) {
				if (caseSuivante.getTypeOccupation() != 2) {
					this.setEmplacement(caseSuivante);
					caseSuivante.setEstVide(false);
					}
			} else {
				this.seDeplacer();
			}
		}
		
		if(direction==3) {
			Case caseSuivante = Grille.getCase(this.getEmplacement().getX()+this.vitesse,this.getEmplacement().getY()+this.vitesse);
			if (caseSuivante.getEstVide() == true) {
				if (caseSuivante.getTypeOccupation() != 2) {
				this.setEmplacement(caseSuivante);
				caseSuivante.setEstVide(false);
				}
			} else {
				this.seDeplacer();
			}
		}
		
		if(direction==4) {
			Case caseSuivante = Grille.getCase(this.getEmplacement().getX()-this.vitesse,this.getEmplacement().getY());
			if (caseSuivante.getEstVide() == true) {
				if (caseSuivante.getTypeOccupation() != 2) {
					this.setEmplacement(caseSuivante);
					caseSuivante.setEstVide(false);
					}
			}else {
				this.seDeplacer();
			}
		}
		if(direction==5) {
			Case caseSuivante = Grille.getCase(this.getEmplacement().getX()+this.vitesse,this.getEmplacement().getY());
			if (caseSuivante.getEstVide() == true) {
				if (caseSuivante.getTypeOccupation() != 2) {
					this.setEmplacement(caseSuivante);
					caseSuivante.setEstVide(false);
					}
			} else {
				this.seDeplacer();
			}
		}
		
		if (direction==6) {
			Case caseSuivante = Grille.getCase(this.getEmplacement().getX()-this.vitesse,this.getEmplacement().getY()-this.vitesse);
			if (caseSuivante.getEstVide() == true) {
				if (caseSuivante.getTypeOccupation() != 2) {
					this.setEmplacement(caseSuivante);
					caseSuivante.setEstVide(false);
					}
			} else {
				this.seDeplacer();
			}
		}
		
		if(direction==7) {
			Case caseSuivante = Grille.getCase(this.getEmplacement().getX(),this.getEmplacement().getY()-this.vitesse);
			if (caseSuivante.getEstVide() == true) {
				if (caseSuivante.getTypeOccupation() != 2) {
					this.setEmplacement(caseSuivante);
					caseSuivante.setEstVide(false);
					}
			} else {
				this.seDeplacer();
			}
		}
		
		Case caseSuivante = Grille.getCase(this.getEmplacement().getX()+this.vitesse,this.getEmplacement().getY()-this.vitesse);
		if (caseSuivante.getEstVide() == true) {
			if (caseSuivante.getTypeOccupation() != 2) {
				this.setEmplacement(caseSuivante);
				caseSuivante.setEstVide(false);
				}
			
			Grille.getCase(caseSuivante.getPosition()[0],caseSuivante.getPosition()[1]);
		
		} else {
			this.seDeplacer();
		}
	}				

	public abstract void seReproduire();

	/**
	 * Cette méthode s'active si l'estomac de l'animal est vide. Elle lui compte un certain nombre de tours avant qu'il 
	 * ne meure de faim.
	 */
	public boolean famine() {
		if (estVivant == false) {					// si l'animal est decedé 
			return false;							// on passe à la suite du tour
		} else if (remplissageEstomac == 0) {		// sinon si l'estomac est vide
			meurtFaim = meurtFaim - 1;				// le compteur qui dit combien de temps l'animal peut vivre sans manger prend - 1
			if (meurtFaim == 0) {					// si ce compteur atteint zéro
				return true;						// cette fonction renvoie true et il mourra au prochain tour
			}					
			else return false;						// sinon on passe à la suite du tour

		}
		return aProcree;
	}

	public void afficherAnimal() {
		//Jpanel.repaint()
		//JPanel.revalidate()
		//
		// protected void paintComponent(Graphics g) {
		//	public void rafraichir (){
		// on vide le jpanel
		// this.getContentPane().removeAll();
		// on le reconstuit a partir de la grille mise a jour
		// ((JPanelGrille)this.getContentPane()).construire();
		// this.getContentPane().revalidate();
	//}
		//
		// y a des trucs à faire avec tout ça, peut-êtr evoir avec hugo
	}
	

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