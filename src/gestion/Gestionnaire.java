package gestion;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import affichageGraphique.ZDialog;
import animaux.Animal;
import biome.AffichageGrille;
import biome.Grille;
/**
 * Classe permettant de gérer le temps et les tours
 * @author Paul,Armand et Louise
 *
 */
public class Gestionnaire {

	/**
	 * tour actuel du jeu
	 */
	protected static int tour;


	/**
	 * durée d'un tour en millisecondes
	 */
	private static int cadence;
	private static ArrayList<Animal> animaux = new ArrayList<Animal>();

	/**
	 * identifiant de l'animal
	 */
	private int id;

	/**
	 * getters et setters
	 * 
	 */

	public static int getTour() {
		return tour;
	}

	public void setTour(int tour) {
		Gestionnaire.tour = tour;
	}



	public int getCadence() {
		return cadence;
	}

	public void setCadence(int newCadence) {
		Gestionnaire.cadence = newCadence;
	}

	public Animal getAnimal(int id) {
		return animaux.get(id);
	}

	public static  ArrayList<Animal> getAnimaux(){
		return animaux;
	}

	public static  void addAnimal(Animal animal) {
		animaux.add(animal);
	}

	/**
	 * Méthode créant un nouveau tour et appelant toutes les méthodes avec les actions des animaux
	 */
	public static void nouveauTour(int tailleGrille) {
		for (Animal animal : animaux) {							// pour chaque animal présent dans la simulation
			if (animal.getEstVivant() == false){				// si l'animal est decedé,
				animal.seDecomposer();							// on applique la fonction seDecomposer()
				continue;										// et on termine le tour de l'animal
			}
			else {												// sinon,
				if (animal.getEsperanceVie() <= (tour - animal.getDateNaissance()) ) {	//si l'animal a atteint son esperance de vie, ou si il est en famine avancée
					animal.decede();													// il décede
					continue;															// et on termine le tour de l'animal
				}else {																	//sinon,

					animal.seDeplacer(tailleGrille);									// l'animal se déplace,
					animal.seNourrir();													// se nourrit si il le peut
					animal.seReproduire();												// et se reproduit si il le peut
				}
			}

		}
	}

	/**
	 * Méthode créant un nouveau tour et appelant toutes les méthodes avec les actions des animaux
	 * Elle fait appel à un timer qui permet de visualiser la 
	 */
	public void lancerJeu(JFrame window, Grille grille, int tps) {

		for (tour = 0; tour <= tps; tour++) {
			//System.out.println("boucle du nombre de tour de gestionnaire");
			System.out.println(tour);
			Gestionnaire.nouveauTour(grille.getTaille());
			window.repaint();

			//System.out.println("je suis dans le timer");
		};

	}
}

