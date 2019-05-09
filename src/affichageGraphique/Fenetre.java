package affichageGraphique;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Classe gérant l'affichage de la première fenêtre de dialogue
 * @author Paul,Armand et Louise
 *
 */
public class Fenetre extends JFrame {

	/**
	 * Constructeur
	 */
	public Fenetre(){      {
		ZDialog zd = new ZDialog(null, "Choix des options", true);
		String environnementChoisi = (String) zd.getEcostme().getSelectedItem();
		ZDialogInfo zInfo = zd.showZDialogI();
  
		this.setVisible(true);      
	}
 
}}