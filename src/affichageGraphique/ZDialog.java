package affichageGraphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class ZDialog extends JDialog{
	private ZDialogInfo zInfo = new ZDialogInfo();
	//private Personnalise perso = new Personnalise("Personnalisé");
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


	public JComboBox getEcostme() {
		return ecostme;
	}

	public ZDialog(JFrame parent, String title, boolean modal){
		super(parent, title, modal);
		this.setSize(550, 350);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.initComponent();
	}

	public ZDialogInfo showZDialogI(){
		this.sendData = false;
		this.setVisible(true);      
		return this.zInfo;      
	}

	public void showPersonnalise(){
		Personnalise perso = new Personnalise(nom.getText());

		perso.setSendData(false);
		perso.setVisible(true);          
	}

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

	public static int getAnimauxTot() {
		if (Integer.parseInt(getNbreAnimaux()) > getTaille()*getTaille()/2) {
			return getTaille()*getTaille()/2;
		} else {
			return Integer.parseInt(getNbreAnimaux());
		}
	}


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
		//ecostme.addItem("Personnalisé");				//sers dans le cas où l'on veut proposer à l'utilisateur de créer un environnement personnalisé 
		ecostmeLabel = new JLabel("Sélectionnez écosystème : ");
		ecosysteme.add(ecostmeLabel);
		ecosysteme.add(ecostme);


		//Le nombre d'animaux
		JPanel panNbreAnimaux = new JPanel();
		panNbreAnimaux.setBackground(Color.white);
		panNbreAnimaux.setPreferredSize(new Dimension(350, 80));
		panNbreAnimaux.setBorder(BorderFactory.createTitledBorder("Nombre d'animaux de départ"));
		nbreAnimauxLabel = new JLabel("Maximum : (Nombre de cases du plateau/2)" );
		nbreAnimaux = new JTextField("50");
		nbreAnimaux.setPreferredSize(new Dimension(90, 25));
		panNbreAnimaux.add(nbreAnimaux, BorderLayout.NORTH);
		panNbreAnimaux.add(nbreAnimauxLabel, BorderLayout.SOUTH);

		//Le temps de simulation
		JPanel panTps = new JPanel();
		panTps.setBackground(Color.white);
		panTps.setPreferredSize(new Dimension(220, 80));
		panTps.setBorder(BorderFactory.createTitledBorder("Temps de la simulation"));
		tpsLabel = new JLabel("En nombre de tours : ");
		tps = new JTextField("60");
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


		JPanel control = new JPanel();
		JButton okBouton = new JButton("OK");


		okBouton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				okclique = true;
				nomSimu = (String) nom.getText();
				environnementChoisi = (String) ecostme.getSelectedItem();
				zInfo = new ZDialogInfo(nom.getText(), (String)tplateau.getSelectedItem(),(String)ecostme.getSelectedItem(), getNbreAnimaux(),getTps());
				showZDialogI();
				JOptionPane jop = new JOptionPane();
				jop.showMessageDialog(null, zInfo.toString(), "Options choisies", JOptionPane.INFORMATION_MESSAGE);
				setVisible(false); 

				if (environnementChoisi.equals("Savane")){
					Gestionnaire savaneGes = new Gestionnaire();
					Savane sav = new Savane(getTaille());
					sav.creationGrille();
					System.out.println(getAnimauxTot());
					for (int i = 0; i < getAnimauxTot()/3; i++) {
						int x = (int) (getTaille()* Math.random());
						int y = (int) (getTaille()* Math.random());
						if (Grille.getCase(x, y).getEstVide() == true) {
							Girafe girafe = new Girafe(0, sav.getCase(x, y), true, true, i);
							girafe.getEmplacement().setEstVide(false);
							savaneGes.addAnimal(girafe);
						}
					}

					for (int i = 0; i < getAnimauxTot()/3; i++) {
						int x = (int) (getTaille()* Math.random());
						int y = (int) (getTaille()* Math.random());
						if (Grille.getCase(x, y).getEstVide() == true) {
							Crocodile crocodile = new Crocodile(0, sav.getCase(x, y), true, true, i);
							crocodile.getEmplacement().setEstVide(false);
							savaneGes.addAnimal(crocodile);
						}
					}

					for (int i = 0; i < getAnimauxTot()/3; i++) {
						int x = (int) (getTaille()* Math.random());
						int y = (int) (getTaille()* Math.random());
						if (Grille.getCase(x, y).getEstVide() == true) {
							Chacal chacal = new Chacal(0, sav.getCase(x, y), true, true, i);
							chacal.getEmplacement().setEstVide(false);
							savaneGes.addAnimal(chacal);
						}
					}
					JFrame window = new JFrame("Simulation d'ecosysteme : " + nomSimu + ", Savane");
					window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					window.getContentPane().add(new AffichageGrille(sav));
					window.setBounds(1200,1200,1200,1200);
					window.setVisible(true);
					
					savaneGes.jeu();
					//System.out.println(savane.getAnimaux());
				}

				if (environnementChoisi.equals("Jungle")){
					Gestionnaire jungleGes = new Gestionnaire();
					Jungle jun = new Jungle(getTaille());
					jun.creationGrille();
					for (int i = 0; i < getAnimauxTot()/3; i++) {
						int x = (int) (getTaille()* Math.random());
						int y = (int) (getTaille()* Math.random());
						if (Grille.getCase(x, y).getEstVide() == true) {
							Singe singe = new Singe(0, Grille.getCase(x, y), true, true, i);
							singe.getEmplacement().setEstVide(false);
							jungleGes.addAnimal(singe);
						}
					}

					for (int i = 0; i < getAnimauxTot()/3; i++) {
						int x = (int) (getTaille()* Math.random());
						int y = (int) (getTaille()* Math.random());
						if (Grille.getCase(x, y).getEstVide() == true) {
							Ours ours = new Ours(0, Grille.getCase(x, y), true, true, i);
							ours.getEmplacement().setEstVide(false);
							jungleGes.addAnimal(ours);
						}
					}

					for (int i = 0; i < getAnimauxTot()/3; i++) {
						int x = (int) (getTaille()* Math.random());
						int y = (int) (getTaille()* Math.random());
						if (Grille.getCase(x, y).getEstVide() == true) {
							Hyene hyene = new Hyene(0, Grille.getCase(x, y), true, true, i);
							hyene.getEmplacement().setEstVide(false);
							jungleGes.addAnimal(hyene);
						}
					}
					JFrame window = new JFrame("Simulation d'ecosysteme : " + nomSimu + ", Jungle");
					window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					window.getContentPane().add(new AffichageGrille(jun));
					window.setBounds(1200,1200,1200,1200);
					window.setVisible(true);
					
					jungleGes.jeu();
				}

				if (environnementChoisi.equals("Sibérie")){
					Gestionnaire siberieGes = new Gestionnaire();
					Syberie sib = new Syberie(getTaille());
					sib.creationGrille();
					for (int i = 0; i < getAnimauxTot()/3; i++) {
						int x = (int) (getTaille()* Math.random());
						int y = (int) (getTaille()* Math.random());
						if (Grille.getCase(x, y).getEstVide() == true) {
							Mammouth mammouth = new Mammouth(0, Grille.getCase(x, y), true, true, i);
							mammouth.getEmplacement().setEstVide(false);
							siberieGes.addAnimal(mammouth);
						}
					}

					for (int i = 0; i < getAnimauxTot()/3; i++) {
						int x = (int) (getTaille()* Math.random());
						int y = (int) (getTaille()* Math.random());
						if (Grille.getCase(x, y).getEstVide() == true) {
							Tigre tigre = new Tigre(0, Grille.getCase(x, y), true, true, i);
							tigre.getEmplacement().setEstVide(false);
							siberieGes.addAnimal(tigre);
						}
					}

					for (int i = 0; i < getAnimauxTot()/3; i++) {
						int x = (int) (getTaille()* Math.random());
						int y = (int) (getTaille()* Math.random());
						if (Grille.getCase(x, y).getEstVide() == true) {
							Condor condor = new Condor(0, Grille.getCase(x, y), true, true, i);
							condor.getEmplacement().setEstVide(false);
							siberieGes.addAnimal(condor);
						}
					}
					JFrame window = new JFrame("Simulation d'ecosysteme : " + nomSimu + ", Sibérie");
					window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					window.getContentPane().add(new AffichageGrille(sib));
					window.setBounds(1200,1200,1200,1200);
					window.setVisible(true);
					
					siberieGes.jeu();
				}

				if (environnementChoisi.equals("Montagnes")){
					//System.out.println("coucou");
					Gestionnaire montagneGes = new Gestionnaire();
					MassifMontagneux massif = new MassifMontagneux(getTaille());
					massif.creationGrille();
					//System.out.println(getAnimauxTot());
					for (int i = 0; i < getAnimauxTot()/3; i++) {
						int x = (int) (getTaille()* Math.random());
						int y = (int) (getTaille()* Math.random());
						if (Grille.getCase(x, y).getEstVide() == true) {
							Bouquetin bouquetin = new Bouquetin(0, MassifMontagneux.getCase(x, y), true, true, 10);
							bouquetin.getEmplacement().setEstVide(false);
							//System.out.println("coucou" + bouquetin.toString());
							montagneGes.addAnimal(bouquetin);
							//System.out.println(bouquetin.getEmplacement().toString());
						}
					}

					for (int i = 0; i < getAnimauxTot()/3; i++) {
						int x = (int) (getTaille()* Math.random());
						int y = (int) (getTaille()* Math.random());
						if (Grille.getCase(x, y).getEstVide() == true) {
							Loup loup = new Loup(0, massif.getCase(x, y), true, true, i);
							loup.getEmplacement().setEstVide(false);
							montagneGes.addAnimal(loup);
						}
					}

					for (int i = 0; i < getAnimauxTot()/3; i++) {
						int x = (int) (getTaille()* Math.random());
						int y = (int) (getTaille()* Math.random());
						if (Grille.getCase(x, y).getEstVide() == true) {
							Vautour vautour = new Vautour(0, massif.getCase(x, y), true, true, i);
							vautour.getEmplacement().setEstVide(false);
							montagneGes.addAnimal(vautour);
						}
					}
					JFrame window = new JFrame("Simulation d'ecosysteme : " + nomSimu + ", Montagnes");
					
					
					window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					window.getContentPane().add(new AffichageGrille(massif));
					window.setBounds(1200,1200,1200,1200);
					window.setVisible(true);
					montagneGes.jeu();
					//System.out.println(montagne.getAnimaux());
					//System.out.println(massif.toString());
				}

				if (environnementChoisi.equals("Steppes")){
					Gestionnaire steppeGes = new Gestionnaire();
					Steppe steppe = new Steppe (getTaille());
					steppe.creationGrille();
					for (int i = 0; i < getAnimauxTot()/3; i++) {
						int x = (int) (getTaille()* Math.random());
						int y = (int) (getTaille()* Math.random());
						Cheval cheval = new Cheval(0, Grille.getCase(x, y), true, true, i);
						steppeGes.addAnimal(cheval);
					}

					for (int i = 0; i < getAnimauxTot()/3; i++) {
						int x = (int) (getTaille()* Math.random());
						int y = (int) (getTaille()* Math.random());
						Renard renard = new Renard(0, Grille.getCase(x, y), true, true, i);
						steppeGes.addAnimal(renard);
					}

					for (int i = 0; i < getAnimauxTot()/3; i++) {
						int x = (int) (getTaille()* Math.random());
						int y = (int) (getTaille()* Math.random());
						Mouche mouche = new Mouche(0, Grille.getCase(x, y), true, true, i);
						steppeGes.addAnimal(mouche);
					}
					JFrame window = new JFrame("Simulation d'ecosysteme : " + nomSimu + ", Steppes");
					window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					window.getContentPane().add(new AffichageGrille(steppe));
					window.setBounds(1200,1200,1200,1200);
					window.setVisible(true);
					steppeGes.jeu();
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

	public boolean isOkclique() {
		return okclique;
	}  
}