package affichageGraphique;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import biome.Grille;
import gestion.Gestionnaire;

public class BoutonDemarrage extends JFrame{
	private JPanel pan = new JPanel();
	private JLabel icon;
	JFrame window = new JFrame();
	Gestionnaire ges = new Gestionnaire();
	Grille grille;
	int tpsInt;
	String animal1;	
	String animal2;
	String animal3;

	public BoutonDemarrage(){
		this.setTitle("Démarrage");
		this.setSize(300, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		//Ajout du bouton à notre content pane
		this.initComponent();
		this.setContentPane(pan);
		this.setVisible(true);
	}      

	public void importDonnees(JFrame window, Gestionnaire ges, Grille steppe, int tpsInt, String animal1, String animal2, String animal3) {
		this.window = window;
		this.ges = ges;
		this.grille = grille;
		this.tpsInt = tpsInt;
		this.animal1 = animal1;	
		this.animal2 = animal2;
		this.animal3 = animal3;

	}

	private void initComponent(){
		JButton demarrage = new JButton("Démarrer");
		JLabel animal1 = new JLabel(this.animal1);
		JLabel animal2 = new JLabel(this.animal2);
		JLabel animal3 = new JLabel(this.animal3);

		demarrage.setLocation(150, 50);
		demarrage.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				ges.lancerJeu(window, grille, tpsInt);
			}
		});
		pan.add(demarrage);
		pan.add(animal1);
		pan.add(animal2);
		pan.add(animal3);
	}
}

