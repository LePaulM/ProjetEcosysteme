package gestion;
import java.util.Timer;
import java.util.TimerTask;

import affichageGraphique.Fenetre;

/**
 * Classe main permettant de lancer la simulation
 * @author Paul, Armand et Louise
 *
 */
public class Main {
	public static void main(String[] args) {

		Fenetre fen = new Fenetre();
		Gestionnaire ges=new Gestionnaire();
		ges.jeu();
		
	}
}