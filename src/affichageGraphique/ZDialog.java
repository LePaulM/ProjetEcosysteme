package affichageGraphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

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
import gestion.Gestionnaire;

/**
 * Classe gérant le dialogue avec l'utilisateur et l'affichage du premier plateau
 * @author Paul,Armand et Louise
 *
 */
public class ZDialog extends JDialog{
	private ZDialogInfo zInfo = new ZDialogInfo();
	private BoutonDemarrage demarrage;
	//private Personnalise perso = new Personnalise("Personnalisé"); // Pour la choix personnalisé qui n'a pas eu le temps d'être développé
	private boolean sendData;
	private JLabel nomLabel, tplateauLabel, ecostmeLabel, tpsLabel,tpsLabel2, nbreAnimauxLabel, nbreAnimauxLabel2, icon;
	private JRadioButton tranche1, tranche2, tranche3, tranche4;
	private static JComboBox tplateau;
	private JComboBox ecostme;
	private JTextField nom;
	private static JTextField nbreAnimaux;
	private static JTextField tps;
	private String environnementChoisi, nomSimu;
	boolean okclique = false;
	private static int tPlateauInt;
	private int nbrTotAnimaux;
	private static String nbrAnimauxString;
	private JPanel[] buttons;
	private JButton bouton = new JButton("Démarrer !");


	public JComboBox getEcostme() {
		return ecostme;
	}
	
	

	/**
	 * Constructeur
	 * @param parent
	 * @param title
	 * @param modal
	 */
	public ZDialog(JFrame parent, String title, boolean modal){
		super(parent, title, modal);
		this.setSize(550, 350);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.initComponent();
	}

	/**
	 * 
	 * @return
	 */
	public ZDialogInfo showZDialogI(){
		this.sendData = false;
		this.setVisible(true);      
		return this.zInfo;      
	}
	
	/**
	 * 
	 * @return
	 */
	public BoutonDemarrage showDemarre(){
		this.sendData = false;
		this.setVisible(true);      
		return this.demarrage;      
	}
	
	
	/**
	 * Pour le choix personnalisé, qui n'a pas eu le temps d'être développé jusqu'au bout
	 */
	/*
	public void showPersonnalise(){
		Personnalise perso = new Personnalise(nom.getText());

		perso.setSendData(false);
		perso.setVisible(true);          
	}*/

	/**
	 * getters
	 */
	public static String getNbreAnimaux(){
		nbrAnimauxString = nbreAnimaux.getText();
		return (nbrAnimauxString.equals("")) ? "180" : nbrAnimauxString;
	};

	public static String getTps(){
		return (tps.getText().equals("")) ? "180" : tps.getText();
	};

	public static int getTaille() {
		String tPlateauChoisi = (String) tplateau.getSelectedItem();
		if (tPlateauChoisi.equals("100*100")) {
			tPlateauInt = 100;
			return tPlateauInt;
		} else if (tPlateauChoisi.equals("30*30")) {
			tPlateauInt = 30;
			return tPlateauInt;
		} else {
			tPlateauInt = 60;
			return tPlateauInt;
		}
	}

	public int getAnimauxTot() {
		if (Integer.parseInt(getNbreAnimaux()) > getTaille()*getTaille()/2) {
			return getTaille()*getTaille()/2;
		} else {
			return Integer.parseInt(getNbreAnimaux());
		}
	}

	public void jeu(int tailleGrille) {
		for (int i = 0; i >= Integer.parseInt(ZDialog.getTps()); i++) {
			
			TimerTask task = new TimerTask() {
				public void run() { 
					Gestionnaire.nouveauTour(tailleGrille);
				};
			};
			Timer timer = new Timer(); 
			timer.scheduleAtFixedRate( task,0, 1000); //ce bout de code sert à mettre un timer pour que le tour passe au suivant automatiquement

		}
	}

	
	/**
	 * Méthode gérant le dialogue avec l'utilisateur et l'affichage du premier plateau
	 */
	private void initComponent(){
		//Icône
		icon = new JLabel(new ImageIcon("images/icone.jpg"));
		JPanel panIcon = new JPanel();
		panIcon.setBackground(Color.white);
		panIcon.setLayout(new BorderLayout());
		panIcon.add(icon);

		//Le nom
		JPanel panNom = new JPanel();
		panNom.setBackground(Color.white);
		panNom.setPreferredSize(new Dimension(220, 80));
		nom = new JTextField("Ma Simulation");
		nom.setPreferredSize(new Dimension(100, 25));
		panNom.setBorder(BorderFactory.createTitledBorder("Nom de la simulation"));
		nomLabel = new JLabel("Saisir un nom :");
		panNom.add(nomLabel);
		panNom.add(nom);

		//Taille du plateau
		JPanel taillePlateau = new JPanel();
		taillePlateau.setBackground(Color.white);
		taillePlateau.setPreferredSize(new Dimension(220, 80));
		taillePlateau.setBorder(BorderFactory.createTitledBorder("Taille du plateau"));
		tplateau = new JComboBox();
		tplateau.addItem("30*30");
		tplateau.addItem("60*60");
		tplateau.addItem("100*100");
		tplateauLabel = new JLabel("taille du plateau : ");
		taillePlateau.add(tplateauLabel);
		taillePlateau.add(tplateau);


		//Choix des ecosystèmes
		JPanel ecosysteme = new JPanel();
		ecosysteme.setBackground(Color.white);
		ecosysteme.setPreferredSize(new Dimension(220, 80));
		ecosysteme.setBorder(BorderFactory.createTitledBorder("Choix de l'écosystème"));
		ecostme = new JComboBox();
		ecostme.addItem("Savane");
		ecostme.addItem("Jungle");
		ecostme.addItem("Sibérie");
		ecostme.addItem("Montagnes");
		ecostme.addItem("Steppes");
		//ecostme.addItem("Personnalisé");				//sert dans le cas où l'on veut proposer à l'utilisateur de créer un environnement personnalisé 
		ecostmeLabel = new JLabel("Sélectionnez écosystème : ");
		ecosysteme.add(ecostmeLabel);
		ecosysteme.add(ecostme);


		//Le nombre d'animaux
		JPanel panNbreAnimaux = new JPanel();
		panNbreAnimaux.setBackground(Color.white);
		panNbreAnimaux.setPreferredSize(new Dimension(350, 80));
		panNbreAnimaux.setBorder(BorderFactory.createTitledBorder("Nombre d'animaux de départ"));
		nbreAnimauxLabel = new JLabel("Maximum : (Nombre de cases du plateau/2)" );
		nbreAnimaux = new JTextField("10");
		nbreAnimaux.setPreferredSize(new Dimension(90, 25));
		panNbreAnimaux.add(nbreAnimaux, BorderLayout.NORTH);
		panNbreAnimaux.add(nbreAnimauxLabel, BorderLayout.SOUTH);

		//Le temps de simulation
		JPanel panTps = new JPanel();
		panTps.setBackground(Color.white);
		panTps.setPreferredSize(new Dimension(220, 80));
		panTps.setBorder(BorderFactory.createTitledBorder("Temps de la simulation"));
		tpsLabel = new JLabel("En nombre de tours : ");
		tps = new JTextField("5");
		tps.setPreferredSize(new Dimension(90, 25));
		panTps.add(tpsLabel);
		panTps.add(tps);

		//Les paramètres de la fenêtre
		JPanel content = new JPanel();
		content.setBackground(Color.white);
		content.add(panNom);
		content.add(taillePlateau);
		content.add(ecosysteme);
		content.add(panTps);
		content.add(panNbreAnimaux);
		
		
/*
// 		Animaux et leurs positions
		nomSimu = (String) nom.getText();
		environnementChoisi = (String) ecostme.getSelectedItem();
		if (environnementChoisi.equals("Savane")){
			Savane sav = new Savane(getTaille());
			sav.creationGrille();
			List<Integer> an=new ArrayList<Integer>();
			ArrayList<List<Integer>> positions=new ArrayList<List<Integer>>();
			for (int i = 0; i < getAnimauxTot()/3; i++) {
				boolean nonPositionne=true;
				while (nonPositionne) {																			// Tant que l'animal n'a pas pu être positionné
				int x = (int) (getTaille()* Math.random());
				int y = (int) (getTaille()* Math.random());
				
				if (Grille.getCase(x, y).getEstVide() == true && Grille.getCase(x, y).getTypeOccupation()!=2) { // vérifie que la case n'est pas déjà occupée ou remplie par de l'eau
					Girafe girafe = new Girafe(0, sav.getCase(x, y), true, true, i);
					girafe.getEmplacement().setEstVide(false);
					an.add(girafe.getId());
					List<Integer> position = new ArrayList<Integer>();
					position.add(girafe.getEmplacement().getX());
					position.add(girafe.getEmplacement().getY());
					positions.add(position);
					nonPositionne=false;}
				}
			}

			for (int i = 0; i < getAnimauxTot()/3; i++) {
				boolean nonPositionne=true;
				while (nonPositionne) {
				int x = (int) (getTaille()* Math.random());
				int y = (int) (getTaille()* Math.random());
				if (Grille.getCase(x, y).getEstVide() == true && Grille.getCase(x, y).getTypeOccupation()!=2) {
					Crocodile crocodile = new Crocodile(0, sav.getCase(x, y), true, true, i);
					crocodile.getEmplacement().setEstVide(false);
					an.add(crocodile.getId());
					List<Integer> position = new ArrayList<Integer>();
					position.add(crocodile.getEmplacement().getX());
					position.add(crocodile.getEmplacement().getY());
					positions.add(position);
					nonPositionne=false;
				}}
			}

			for (int i = 0; i < (getAnimauxTot()-(2*getAnimauxTot()/3)); i++) {
				boolean nonPositionne=true;
				while (nonPositionne) {
				int x = (int) (getTaille()* Math.random());
				int y = (int) (getTaille()* Math.random());
				if (Grille.getCase(x, y).getEstVide() == true && Grille.getCase(x, y).getTypeOccupation()!=2) {
					Chacal chacal = new Chacal(0, sav.getCase(x, y), true, true, i);
					chacal.getEmplacement().setEstVide(false);
					an.add(chacal.getId());
					List<Integer> position = new ArrayList<Integer>();
					position.add(chacal.getEmplacement().getX());
					position.add(chacal.getEmplacement().getY());
					positions.add(position);
					nonPositionne=false;
				}}
				
			}*//*
			for(Animal animal : an) {
				animal.seDeplacer((int)getTaille());
			}*/
			/*
			//an.set(0,an.get(0).seDeplacer());
			JFrame window2 = new JFrame("Simulation d'ecosysteme : " + nomSimu + ", Savane");
			window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window2.getContentPane().add(new AffichageGrille(sav));
			window2.setBounds(1200,1200,1200,1200);
			window2.setVisible(true);
			//Ges.nouveauTour();
			System.out.println(an);
			System.out.println(positions);
			
		}*/
		
		JPanel control = new JPanel();
		JButton okBouton = new JButton("OK");


		/**
		 * Méthode "écoutant" le clic sur le bouton "ok", pour nous renvoyer les infos et le plateau
		 */
		okBouton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				okclique = true;
				nomSimu = (String) nom.getText();
				environnementChoisi = (String) ecostme.getSelectedItem();
				zInfo = new ZDialogInfo(nom.getText(), (String)tplateau.getSelectedItem(),(String)ecostme.getSelectedItem(), getNbreAnimaux(),getTps());
				showZDialogI();
				//demarrage=new BoutonDemarrage();
				//showDemarre();
				JOptionPane jop = new JOptionPane();
				jop.showMessageDialog(null, zInfo.toString(), "Options choisies", JOptionPane.INFORMATION_MESSAGE);
				setVisible(false); 
				
				Gestionnaire Ges = new Gestionnaire();
// 				Gère l'affichage des environnements et des animaux en fonction
				if (environnementChoisi.equals("Savane")){
					Ges = new Gestionnaire();
					Savane sav = new Savane(getTaille());
					sav.creationGrille();
					ArrayList<Animal> an=new ArrayList<Animal>();
					for (int i = 0; i < getAnimauxTot()/3; i++) {
						boolean nonPositionne=true;
						while (nonPositionne) {																			// Tant que l'animal n'a pas pu être positionné
						int x = (int) (getTaille()* Math.random());
						int y = (int) (getTaille()* Math.random());
						
						if (Grille.getCase(x, y).getEstVide() == true && Grille.getCase(x, y).getTypeOccupation()!=2) { // vérifie que la case n'est pas déjà occupée ou remplie par de l'eau
							Girafe girafe = new Girafe(0, sav.getCase(x, y), true, i);
							girafe.getEmplacement().setEstVide(false);
							Ges.addAnimal(girafe);
							an.add(girafe);
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
							Ges.addAnimal(crocodile);
							an.add(crocodile);
							nonPositionne = false;
						}}
					}

					for (int i = 0; i < (getAnimauxTot()-(2*getAnimauxTot()/3)); i++) {
						boolean nonPositionne=true;
						while (nonPositionne) {
						int x = (int) (getTaille()* Math.random());
						int y = (int) (getTaille()* Math.random());
						if (Grille.getCase(x, y).getEstVide() == true && Grille.getCase(x, y).getTypeOccupation()!=2) {
							Chacal chacal = new Chacal(0, sav.getCase(x, y), true, i);
							chacal.getEmplacement().setEstVide(false);
							Ges.addAnimal(chacal);
							an.add(chacal);
							nonPositionne = false;
						}}
						
					}
					JFrame window = new JFrame("Simulation d'ecosysteme : " + nomSimu + ", Savane");
					window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					window.getContentPane().add(new AffichageGrille(sav));
//					Recup taille ecran
					Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize(); 
					int hauteur = (int)tailleEcran.getHeight(); 
					int largeur = (int)tailleEcran.getWidth();
					window.setSize(largeur/2,hauteur);
					window.setVisible(true);
					//System.out.println(an);
					
					
					for (int i = 0; i >= Integer.parseInt(ZDialog.getTps()); i++) {
						
						//TimerTask task = new TimerTask() {
							//public void run() { 
								Gestionnaire.nouveauTour(getTaille());
								window.getContentPane().add(new AffichageGrille(sav));
								
								System.out.println("coucou");
							//};
						//};
						//Timer timer = new Timer(); 
						//timer.scheduleAtFixedRate( task,0, 1000); //ce bout de code sert à mettre un timer pour que le tour passe au suivant automatiquement

					}
					
					for(Animal animal : an) {
						//System.out.println("coucou");
						animal.seDeplacer((int)getTaille());
						window.repaint();
						}
					
					
					/*
					Chacal chacal = new Chacal(0, sav.getCase(1, 1), true, true, 11);
					chacal.getEmplacement().setEstVide(false);*/
					//window.getContentPane().add(new AffichageGrille(sav));
					
					/*
					//an.set(0,an.get(0).seDeplacer());
					JFrame window2 = new JFrame("Simulation d'ecosysteme : " + nomSimu + ", Savane");
					window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					window2.getContentPane().add(new AffichageGrille(sav));
					window2.setBounds(1200,1200,1200,1200);
					window2.setVisible(true);
					//Ges.nouveauTour();*/
					
				}

				if (environnementChoisi.equals("Jungle")){
					Gestionnaire jungleGes = new Gestionnaire();
					Jungle jun = new Jungle(getTaille());
					jun.creationGrille();
					for (int i = 0; i < getAnimauxTot()/3; i++) {
						boolean nonPositionne=true;
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
						}}
					}
					JFrame window = new JFrame("Simulation d'ecosysteme : " + nomSimu + ", Jungle");
					window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					window.getContentPane().add(new AffichageGrille(jun));
//					Recup taille ecran
					Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize(); 
					int hauteur = (int)tailleEcran.getHeight(); 
					int largeur = (int)tailleEcran.getWidth();
					window.setSize(largeur/2,hauteur);
					window.setVisible(true);
					window.setVisible(true);
					//jungleGes.jeu();
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
						}}
					}
					JFrame window = new JFrame("Simulation d'ecosysteme : " + nomSimu + ", Sibérie");
					window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					window.getContentPane().add(new AffichageGrille(sib));
//					Recup taille ecran
					Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize(); 
					int hauteur = (int)tailleEcran.getHeight(); 
					int largeur = (int)tailleEcran.getWidth();
					window.setSize(largeur/2,hauteur);
					window.setVisible(true);
					window.setVisible(true);
					
					//siberieGes.jeu();
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
					
					JFrame window = new JFrame("Simulation d'ecosysteme : " + nomSimu + ", Montagnes");
					
					window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					window.getContentPane().add(new AffichageGrille(massif));
					window.setBounds(1200,1200,1200,1200);
//					Recup taille ecran
					Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize(); 
					int hauteur = (int)tailleEcran.getHeight(); 
					int largeur = (int)tailleEcran.getWidth();
					window.setSize(largeur/2,hauteur);
					window.setVisible(true);
					//montagneGes.jeu();
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
					JFrame window = new JFrame("Simulation d'ecosysteme : " + nomSimu + ", Steppes");
					window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					window.getContentPane().add(new AffichageGrille(steppe));
//					Recup taille ecran
					Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize(); 
					int hauteur = (int)tailleEcran.getHeight(); 
					int largeur = (int)tailleEcran.getWidth();
					window.setSize(largeur/2,hauteur);
					window.setVisible(true);
					window.setVisible(true);
					//steppeGes.jeu();
				}
				
			}
		});

		JButton cancelBouton = new JButton("Annuler");
		cancelBouton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}      
		});

		control.add(okBouton);
		control.add(cancelBouton);

		this.getContentPane().add(panIcon, BorderLayout.WEST);
		this.getContentPane().add(content, BorderLayout.CENTER);
		this.getContentPane().add(control, BorderLayout.SOUTH);


	}

}
	