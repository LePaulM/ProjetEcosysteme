package gestion;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;

import affichageGraphique.BoutonDemarrage;
import affichageGraphique.ZDialog;
import animaux.Animal;
import animaux.Bouquetin;
import animaux.Chacal;
import animaux.Cheval;
import animaux.Condor;
import animaux.Crocodile;
import animaux.Girafe;
import animaux.Hyene;
import animaux.Loup;
import animaux.Mammouth;
import animaux.Mouche;
import animaux.Ours;
import animaux.Renard;
import animaux.Singe;
import animaux.Tigre;
import animaux.Vautour;
import biome.AffichageGrille;
import biome.Grille;
import biome.Jungle;
import biome.MassifMontagneux;
import biome.Savane;
import biome.Steppe;
import biome.Syberie;
/**
*	Classe permettant d'initialiser le jeu
*	@author Paul, Armand et Louise
*/
public class Initialisation {
	private String environnementChoisi;
	private int tPlateau;
	private int animauxTot;
	private String nomSimu;
	private BoutonDemarrage demarrage;
	private boolean sendData;

	/**
	*getters et setters
	*/
	public int getAnimauxTot() {
		return animauxTot;
	}

	public void setAnimauxTot(int animauxTot) {
		this.animauxTot = animauxTot;
	}

	public String getEnvironnementChoisi() {
		return environnementChoisi;
	}

	public void setEnvironnementChoisi(String environnementChoisi) {
		this.environnementChoisi = environnementChoisi;
	}

	public int getTaille() {
		return tPlateau;
	}

	public void setTaille(int tPlateau) {
		this.tPlateau = tPlateau;
	}

	/**
	 * 
	 * @return
	 */
	public BoutonDemarrage showDemarre(){     
		return this.demarrage;      
	}



	public Initialisation(String environnementChoisi, int tPlateau, int animauxTot, String nomSimu){
		this.environnementChoisi = environnementChoisi;
		this.tPlateau = tPlateau;
		this.animauxTot = animauxTot;
		this.nomSimu = nomSimu;
		int tps = Integer.parseInt(ZDialog.getTps());

		//		Gère l'affichage des environnements et des animaux en fonction
		if (environnementChoisi.equals("Savane")){
			Gestionnaire savaneGes = new Gestionnaire();
			Savane sav = new Savane(getTaille());
			sav.creationGrille();
			for (int i = 0; i < getAnimauxTot()/3; i++) {
				boolean nonPositionne=true;
				while (nonPositionne) {																			// Tant que l'animal n'a pas pu être positionné
					int x = (int) (getTaille()* Math.random());
					int y = (int) (getTaille()* Math.random());

					if (Grille.getCase(x, y).getEstVide() == true && Grille.getCase(x, y).getTypeOccupation()!=2) { // vérifie que la case n'est pas déjà occupée ou remplie par de l'eau
						Girafe girafe = new Girafe(0, sav.getCase(x, y), true, i);
						girafe.getEmplacement().setEstVide(false);
						savaneGes.addAnimal(girafe);
						nonPositionne=false;}
				}
			}

			for (int i = 0; i < getAnimauxTot()/3; i++) {
				boolean nonPositionne=true;
				while (nonPositionne) {
					int x = (int) (getTaille()* Math.random());
					int y = (int) (getTaille()* Math.random());
					if (Grille.getCase(x, y).getEstVide() == true && Grille.getCase(x, y).getTypeOccupation()!=2) {
						Crocodile crocodile = new Crocodile(0, sav.getCase(x, y), true, i);
						crocodile.getEmplacement().setEstVide(false);
						savaneGes.addAnimal(crocodile);
						nonPositionne = false;
					}}
			}

			for (int i = 0; i < (getAnimauxTot()-(2*getAnimauxTot()/3)); i++) {
				boolean nonPositionne = true;
				while (nonPositionne) {
					int x = (int) (getTaille()* Math.random());
					int y = (int) (getTaille()* Math.random());
					if (Grille.getCase(x, y).getEstVide() == true && Grille.getCase(x, y).getTypeOccupation()!=2) {
						Chacal chacal = new Chacal(0, sav.getCase(x, y), true, i);
						chacal.getEmplacement().setEstVide(false);
						savaneGes.addAnimal(chacal);
						nonPositionne = false;
					}
				}
			}

			String animal1 = "Girafe";
			String animal2 = "Crocodile";
			String animal3 = "Chacal";

			JFrame window = new JFrame("Simulation d'ecosysteme : " + nomSimu + ", Savane");
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.getContentPane().add(new AffichageGrille(sav));
			//		Recup taille ecran
			Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize(); 
			int hauteur = (int)tailleEcran.getHeight(); 
			int largeur = (int)tailleEcran.getWidth();
			window.setSize(largeur/2,hauteur);
			window.setVisible(true);

			BoutonDemarrage demarrage = new BoutonDemarrage();
			demarrage.importDonnees(window, savaneGes, sav, tps, animal1, animal2, animal3);

		}

		if (environnementChoisi.equals("Jungle")){
			Gestionnaire jungleGes = new Gestionnaire();
			Jungle jun = new Jungle(getTaille());
			jun.creationGrille();
			for (int i = 0; i < getAnimauxTot()/3; i++) {
				boolean nonPositionne = true;
				while (nonPositionne) {
					int x = (int) (getTaille()* Math.random());
					int y = (int) (getTaille()* Math.random());
					if (Grille.getCase(x, y).getEstVide() == true && Grille.getCase(x, y).getTypeOccupation()!=2) {
						Singe singe = new Singe(0, Grille.getCase(x, y), true, i);
						singe.getEmplacement().setEstVide(false);
						jungleGes.addAnimal(singe);
						nonPositionne = false;
					}
				}
			}

			for (int i = 0; i < getAnimauxTot()/3; i++) {
				boolean nonPositionne=true;
				while (nonPositionne) {
					int x = (int) (getTaille()* Math.random());
					int y = (int) (getTaille()* Math.random());
					if (Grille.getCase(x, y).getEstVide() == true && Grille.getCase(x, y).getTypeOccupation()!=2) {
						Ours ours = new Ours(0, Grille.getCase(x, y), true, i);
						ours.getEmplacement().setEstVide(false);
						jungleGes.addAnimal(ours);}
					nonPositionne=false;
				}
			}

			for (int i = 0; i < getAnimauxTot()/3; i++) {
				boolean nonPositionne=true;
				while (nonPositionne) {
					int x = (int) (getTaille()* Math.random());
					int y = (int) (getTaille()* Math.random());
					if (Grille.getCase(x, y).getEstVide() == true && Grille.getCase(x, y).getTypeOccupation()!=2) {
						Hyene hyene = new Hyene(0, Grille.getCase(x, y), true, i);
						hyene.getEmplacement().setEstVide(false);
						jungleGes.addAnimal(hyene);
						nonPositionne=false;
					}
				}
			}

			String animal1 = "Singe";
			String animal2 = "Ours";
			String animal3 = "Hyene";

			JFrame window = new JFrame("Simulation d'ecosysteme : " + nomSimu + ", Jungle");
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.getContentPane().add(new AffichageGrille(jun));
			//		Recup taille ecran
			Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize(); 
			int hauteur = (int)tailleEcran.getHeight(); 
			int largeur = (int)tailleEcran.getWidth();
			window.setSize(largeur/2,hauteur);
			window.setVisible(true);

			BoutonDemarrage demarrage = new BoutonDemarrage();
			demarrage.importDonnees(window, jungleGes, jun, tps, animal1, animal2, animal3);
		}

		if (environnementChoisi.equals("Sibérie")){
			Gestionnaire siberieGes = new Gestionnaire();
			Syberie sib = new Syberie(getTaille());
			sib.creationGrille();
			for (int i = 0; i < getAnimauxTot()/3; i++) {
				boolean nonPositionne=true;
				while (nonPositionne) {
					int x = (int) (getTaille()* Math.random());
					int y = (int) (getTaille()* Math.random());
					if (Grille.getCase(x, y).getEstVide() == true && Grille.getCase(x, y).getTypeOccupation()!=2) {
						Mammouth mammouth = new Mammouth(0, Grille.getCase(x, y), true, i);
						mammouth.getEmplacement().setEstVide(false);
						siberieGes.addAnimal(mammouth);
						nonPositionne=false;
					}}
			}

			for (int i = 0; i < getAnimauxTot()/3; i++) {
				boolean nonPositionne=true;
				while (nonPositionne) {
					int x = (int) (getTaille()* Math.random());
					int y = (int) (getTaille()* Math.random());
					if (Grille.getCase(x, y).getEstVide() == true && Grille.getCase(x, y).getTypeOccupation()!=2) {
						Tigre tigre = new Tigre(0, Grille.getCase(x, y), true, i);
						tigre.getEmplacement().setEstVide(false);
						siberieGes.addAnimal(tigre);
						nonPositionne=false;
					}}
			}

			for (int i = 0; i < getAnimauxTot()/3; i++) {
				boolean nonPositionne=true;
				while (nonPositionne) {
					int x = (int) (getTaille()* Math.random());
					int y = (int) (getTaille()* Math.random());
					if (Grille.getCase(x, y).getEstVide() == true && Grille.getCase(x, y).getTypeOccupation()!=2) {
						Condor condor = new Condor(0, Grille.getCase(x, y), true, i);
						condor.getEmplacement().setEstVide(false);
						siberieGes.addAnimal(condor);
						nonPositionne=false;
					}
				}
			}

			String animal1 = "Mammouth";
			String animal2 = "Tigre";
			String animal3 = "Condor";

			JFrame window = new JFrame("Simulation d'ecosysteme : " + nomSimu + ", Sibérie");
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.getContentPane().add(new AffichageGrille(sib));
			//		Recup taille ecran
			Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize(); 
			int hauteur = (int)tailleEcran.getHeight(); 
			int largeur = (int)tailleEcran.getWidth();
			window.setSize(largeur/2,hauteur);
			window.setVisible(true);

			BoutonDemarrage demarrage = new BoutonDemarrage();
			demarrage.importDonnees(window, siberieGes, sib, tps, animal1, animal2, animal3);
		}

		if (environnementChoisi.equals("Montagnes")){
			Gestionnaire montagneGes = new Gestionnaire();
			MassifMontagneux massif = new MassifMontagneux(getTaille());
			massif.creationGrille();
			for (int i = 0; i < getAnimauxTot()/3; i++) {
				boolean nonPositionne=true;
				while (nonPositionne) {
					int x = (int) (getTaille()* Math.random());
					int y = (int) (getTaille()* Math.random());
					if (Grille.getCase(x, y).getEstVide() == true && Grille.getCase(x, y).getTypeOccupation()!=2) {
						Bouquetin bouquetin = new Bouquetin(0, MassifMontagneux.getCase(x, y), true, 10);
						bouquetin.getEmplacement().setEstVide(false);
						montagneGes.addAnimal(bouquetin);
						nonPositionne=false;
					}}
			}

			for (int i = 0; i < getAnimauxTot()/3; i++) {
				boolean nonPositionne=true;
				while (nonPositionne) {
					int x = (int) (getTaille()* Math.random());
					int y = (int) (getTaille()* Math.random());
					if (Grille.getCase(x, y).getEstVide() == true && Grille.getCase(x, y).getTypeOccupation()!=2) {
						Loup loup = new Loup(0, massif.getCase(x, y), true, i);
						loup.getEmplacement().setEstVide(false);
						montagneGes.addAnimal(loup);
						nonPositionne=false;}
				}
			}

			for (int i = 0; i < getAnimauxTot()/3; i++) {
				boolean nonPositionne=true;
				while (nonPositionne) {
					int x = (int) (getTaille()* Math.random());
					int y = (int) (getTaille()* Math.random());
					if (Grille.getCase(x, y).getEstVide() == true && Grille.getCase(x, y).getTypeOccupation()!=2) {
						Vautour vautour = new Vautour(0, massif.getCase(x, y), true, i);
						vautour.getEmplacement().setEstVide(false);
						montagneGes.addAnimal(vautour);
						nonPositionne=false;}
				}
			}

			String animal1 = "Bouquetin";
			String animal2 = "Loup";
			String animal3 = "Vautour";

			JFrame window = new JFrame("Simulation d'ecosysteme : " + nomSimu + ", Montagnes");

			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.getContentPane().add(new AffichageGrille(massif));
			window.setBounds(1200,1200,1200,1200);
			//		Recup taille ecran
			Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize(); 
			int hauteur = (int)tailleEcran.getHeight(); 
			int largeur = (int)tailleEcran.getWidth();
			window.setSize(largeur/2,hauteur);
			window.setVisible(true);

			BoutonDemarrage demarrage = new BoutonDemarrage();
			demarrage.importDonnees(window, montagneGes, massif, tps, animal1, animal2, animal3);
		}

		if (environnementChoisi.equals("Steppes")){
			Gestionnaire steppeGes = new Gestionnaire();
			Steppe steppe = new Steppe (getTaille());
			steppe.creationGrille();
			for (int i = 0; i < getAnimauxTot()/3; i++) {
				boolean nonPositionne=true;
				while (nonPositionne) {
					int x = (int) (getTaille()* Math.random());
					int y = (int) (getTaille()* Math.random());
					if (Grille.getCase(x, y).getEstVide() == true && Grille.getCase(x, y).getTypeOccupation()!=2) {
						Cheval cheval = new Cheval(0, Grille.getCase(x, y), true, i);
						steppeGes.addAnimal(cheval);
						nonPositionne=false;}
				}
			}

			for (int i = 0; i < getAnimauxTot()/3; i++) {
				boolean nonPositionne=true;
				while (nonPositionne) {
					int x = (int) (getTaille()* Math.random());
					int y = (int) (getTaille()* Math.random());
					if (Grille.getCase(x, y).getEstVide() == true && Grille.getCase(x, y).getTypeOccupation()!=2) {
						Renard renard = new Renard(0, Grille.getCase(x, y), true, i);
						steppeGes.addAnimal(renard);
						nonPositionne=false;}
				}
			}

			for (int i = 0; i < getAnimauxTot()/3; i++) {
				boolean nonPositionne=true;
				while (nonPositionne) {
					int x = (int) (getTaille()* Math.random());
					int y = (int) (getTaille()* Math.random());
					if (Grille.getCase(x, y).getEstVide() == true && Grille.getCase(x, y).getTypeOccupation()!=2) {
						Mouche mouche = new Mouche(0, Grille.getCase(x, y), true, i);
						steppeGes.addAnimal(mouche);
						nonPositionne=false;}
				}
			}

			String animal1 = "Cheval";
			String animal2 = "Renard";
			String animal3 = "Mouche";

			System.out.println(steppeGes.getAnimaux());
			JFrame window = new JFrame("Simulation d'ecosysteme : " + nomSimu + ", Steppes");

			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.getContentPane().add(new AffichageGrille(steppe));
			window.setBounds(1200,1200,1200,1200);
			//		Recup taille ecran
			Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize(); 
			int hauteur = (int)tailleEcran.getHeight(); 
			int largeur = (int)tailleEcran.getWidth();
			window.setSize(largeur/2,hauteur);
			window.setVisible(true);

			BoutonDemarrage demarrage = new BoutonDemarrage();
			demarrage.importDonnees(window, steppeGes, steppe, tps, animal1, animal2, animal3);
		}

	}

}
