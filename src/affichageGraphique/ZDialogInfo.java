package affichageGraphique;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import biome.Grille;
import gestion.Gestionnaire;

/**
 * Classe donnant à l'utilisateur les infos qu'il a choisi
 * @author Paul,Armand et Louise
 *
 */
public class ZDialogInfo extends JFrame {
	/**
	 * Les différentes infos à transmettre à l'utilisateur
	 */
	private String nom, tplateau,ecostme, nbreAnimaux,tps;
	JFrame window = new JFrame();
	Gestionnaire ges = new Gestionnaire();
	Grille grille;
	int tpsInt;
	/**
	 * Constructeur vide
	 */
	public ZDialogInfo(){}
	/**
	 * Constucteur
	 * @param nom : nom donné à la simulation
	 * @param tplateau : taille d'un côté du plateau
	 * @param ecostme : type d'ecosystème choisi
	 * @param nbreAnimaux : nombre d'animaux dans la simulation
	 * @param tps : nombre de tours que va durer la simulation
	 */
	public ZDialogInfo(String nom, String tplateau, String ecostme,  String nbreAnimaux,String tps){
		this.nom = nom;
		this.tplateau = tplateau;
		this.ecostme = ecostme;
		this.nbreAnimaux = nbreAnimaux;
		this.tps = tps;
	}

	public void importDonnees(JFrame window, Gestionnaire ges, Grille grille, int tpsInt) {
		this.window = window;
		this.ges = ges;
		this.grille = grille;
		this.tpsInt = tpsInt;
	}

	/**
	 * Cette méthode permet de renvoyer la taille d'un des côtés du plateau. Puisque c'est un plateau carré, cela permettra de calculer sa taille.
	 * @return taille d'un côté : int 
	 */
	public int getTaille() {
		String caracteres[]=tplateau.split("");
		String STPlateau = "";
		int i = 0;
		while (!(caracteres[i].equals("*"))) {
			STPlateau = STPlateau+caracteres[i]; 
			i++;
		}
		Integer taille = Integer.decode(STPlateau);
		return(taille);
	}


	/**
	 * Rédéfinition de la méthode toString. 
	 */
	@Override
	public String toString(){
		String str;
		int nbreAnimauxMax = (getTaille()*getTaille())/2;
		if(this.nom != null && this.tplateau != null && this.ecostme != null && this.nbreAnimaux != null && this.tps != null && Integer.decode(nbreAnimaux)<nbreAnimauxMax){
			str = "Options choisies \n";
			str += "Nom : " + this.nom + "\n";
			str += "taille du plateau " + this.tplateau + "\n";
			str += "Choix des écosystèmes : " + this.ecostme + "\n";
			str += "Temps de simulation : " + this.tps + "\n";
			str += "Nombre d'animaux sur le plateau au départ : " + this.nbreAnimaux + "\n";
		}
		else if(this.nom != null && this.tplateau != null && this.ecostme != null && this.nbreAnimaux != null && this.tps != null){
			str = "Le nombre d'animaux choisi n'est pas cohérent avec la taille du plateau !";
		}
		else {
			str = "Aucune information !";
		}
		return str;
	}
}
