package biome;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import biome.Grille;

public class AffichageGrille extends JPanel {

	private JPanelPersonnalise[] buttons;

	public AffichageGrille(Grille grille)  {
		System.out.println(grille.toString());
		setLayout(new GridLayout(grille.getTaille(),grille.getTaille()));
		buttons = new JPanelPersonnalise[(int)Math.pow(grille.getTaille(),2)];

		// création des couleurs de l'environnement (R,G,B,A)
		Color herbe = new Color(87, 213, 59, 250);
		Color buisson = new Color(58, 137, 35, 250);
		Color eau = new Color(0, 127, 255, 250);
		Color foret = new Color(0, 86, 27, 250);
		Color sable = new Color(224, 205, 169, 250);
		Color neige = new Color(240, 240, 240, 250);
		Color terrainNu = new Color(167, 103, 38, 250);
		Color montagne = new Color(132, 132, 132, 250);

		for(int i = 0; i <= grille.getTaille()-1; i++)
		{
			for(int j = 0; j <= grille.getTaille()-1; j++)
			{
				int occupation = grille.getCase(i,j).getTypeOccupation();

				//if (grille.getCase(i, j).getEstVide() == true) {
				
				//System.out.println(grille.getCase(i, j).getEstVide() == false);

				buttons[j] = new JPanelPersonnalise(grille, i, j);
				
				//buttons[j].setX(i);
				//buttons[j].setY(j);

				if (occupation == 0) {
					buttons[j].setBackground(herbe);
				}
				if (occupation == 1) {
					buttons[j].setBackground(buisson);
				}
				if (occupation == 2) {					
					buttons[j].setBackground(eau);
				}
				if (occupation == 3) {					
					buttons[j].setBackground(foret);
				}
				if (occupation == 4) {					
					buttons[j].setBackground(sable);
				}
				if (occupation == 5) {					
					buttons[j].setBackground(neige);
				}
				if (occupation == 6) {					
					buttons[j].setBackground(terrainNu);
				}
				if (occupation == 7) {					
					buttons[j].setBackground(montagne);
					buttons[j].toString();
					//System.out.println(i);
				}
				//} //else {
				//buttons[j] = new JPanelPersonnalise(grille);
				//buttons[j].toString();
				//}

				add(buttons[j]); 
				//adds this button to JPanel (note: no need for JPanel.add(...)
				//because this whole class is a JPanel already           
			}
		}
	} 

}
