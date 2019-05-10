package biome;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import affichageGraphique.ZDialog;

/** 
 * Classe définissant les images associées à chaque animal
 * @author Paul, Armand et Louise
 *
 */
public class JPanelPersonnalise extends JPanel {
	/**
	 * Grille sur laquelle est positionné l'ecosystème sans les animaux
	 */
	private Grille grille;
	/**
	 * Position de l'animal en abscisse
	 */
	private int x;
	/**
	 * Position de l'animal en ordonnée
	 */
	private int y;

	/**
	 * Constructeur
	 * @param grille : Grille sur laquelle est positionné l'ecosystème sans les animaux
	 * @param x : Position de l'animal en abscisse
	 * @param y : Position de l'animal en ordonnée
	 */
	public JPanelPersonnalise(Grille grille, int  x, int y) {
		this.grille = grille;
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Récupération des images
	 */
	ImageIcon bouquetin = new ImageIcon("ressources/bouquetin.png");
	ImageIcon chacal = new ImageIcon("ressources/chacal.png");
	ImageIcon cheval = new ImageIcon("ressources/cheval.png");
	ImageIcon crocodile = new ImageIcon("ressources/crocodile.png");
	ImageIcon girafe = new ImageIcon("ressources/girafe.png");
	ImageIcon hyene = new ImageIcon("ressources/hyene.png");
	ImageIcon loup = new ImageIcon("ressources/loup.png");
	ImageIcon mammouth = new ImageIcon("ressources/mammouth.png");
	ImageIcon mouche = new ImageIcon("ressources/mouche.png");
	ImageIcon ours = new ImageIcon("ressources/ours.png");
	ImageIcon renard = new ImageIcon("ressources/renard.png");
	ImageIcon singe = new ImageIcon("ressources/singe.png");
	ImageIcon tigre = new ImageIcon("ressources/tigre.png");
	ImageIcon vautour = new ImageIcon("ressources/vautour.png");

	/**
	 * Setters
	 * @param x
	 */
	public void setX(int x){
		this.x = x;
	}

	public void setY(int y){
		this.y = y;
	}

	/**
	 * Méthode affichant l'image correspondante pour chaque animal
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		int tailleCaseEnPixel = 1200 / ZDialog.getTaille();
		//System.out.println(Grille.getCase(x, y).getEstVide());
		if(Grille.getCase(x, y).getEstVide() == false) {
			//System.out.println("2"+Grille.getCase(x, y).getAnimal());
			//System.out.println("1"+Grille.getCase(x, y).getAnimal().getClass());
			if (Grille.getCase(x, y).getAnimal().getEspece().equals("Bouquetin")) {
				Image bouquetinImaged = bouquetin.getImage();
				g2d.drawImage(bouquetinImaged, 0, 0, tailleCaseEnPixel, tailleCaseEnPixel, null);
			}
			if (Grille.getCase(x, y).getAnimal().getEspece().equals("Chacal")) {
				Image chacalImaged = chacal.getImage();
				g2d.drawImage(chacalImaged, 0, 0, tailleCaseEnPixel, tailleCaseEnPixel, null);
			}
			if (Grille.getCase(x, y).getAnimal().getEspece().equals("Cheval")) {
				Image chevalImaged = cheval.getImage();
				g2d.drawImage(chevalImaged, 0, 0, tailleCaseEnPixel, tailleCaseEnPixel, null);
			}
			if (Grille.getCase(x, y).getAnimal().getEspece().equals("Crocodile")) {
				Image crocodileImaged = crocodile.getImage();
				g2d.drawImage(crocodileImaged, 0, 0, tailleCaseEnPixel, tailleCaseEnPixel, null);
			}
			if (Grille.getCase(x, y).getAnimal().getEspece().equals("Girafe")) {
				Image girafeImaged = girafe.getImage();
				g2d.drawImage(girafeImaged, 0, 0, tailleCaseEnPixel, tailleCaseEnPixel, null);
			}
			if (Grille.getCase(x, y).getAnimal().getEspece().equals("Hyene")) {
				Image hyeneImaged = hyene.getImage();
				g2d.drawImage(hyeneImaged, 0, 0, tailleCaseEnPixel, tailleCaseEnPixel, null);
				
			}
			if (Grille.getCase(x, y).getAnimal().getEspece().equals("Loup")) {
				Image loupImaged = loup.getImage();
				g2d.drawImage(loupImaged, 0, 0, tailleCaseEnPixel, tailleCaseEnPixel, null);
			}
			if (Grille.getCase(x, y).getAnimal().getEspece().equals("Mammouth")) {
				Image mammouthImaged = mammouth.getImage();
				g2d.drawImage(mammouthImaged, 0, 0, tailleCaseEnPixel, tailleCaseEnPixel, null);
			}
			if (Grille.getCase(x, y).getAnimal().getEspece().equals("Mouche")) {
				Image moucheImaged = mouche.getImage();
				g2d.drawImage(moucheImaged, 0, 0, tailleCaseEnPixel, tailleCaseEnPixel, null);
			}
			if (Grille.getCase(x, y).getAnimal().getEspece().equals("Ours")) {
				Image oursImaged = ours.getImage();
				g2d.drawImage(oursImaged, 0, 0, tailleCaseEnPixel, tailleCaseEnPixel, null);
			}
			if (Grille.getCase(x, y).getAnimal().getEspece().equals("Renard")) {
				Image renardImaged = renard.getImage();
				g2d.drawImage(renardImaged, 0, 0, tailleCaseEnPixel, tailleCaseEnPixel, null);
			}
			if (Grille.getCase(x, y).getAnimal().getEspece().equals("Singe")) {
				Image singeImaged = singe.getImage();
				g2d.drawImage(singeImaged, 0, 0, tailleCaseEnPixel, tailleCaseEnPixel, null);
			}
			if (Grille.getCase(x, y).getAnimal().getEspece().equals("Tigre")) {
				Image tigreImaged = tigre.getImage();
				g2d.drawImage(tigreImaged, 0, 0, tailleCaseEnPixel, tailleCaseEnPixel, null);
			}
			if (Grille.getCase(x, y).getAnimal().getEspece().equals("Vautour")) {
				Image vautourImaged = vautour.getImage();
				g2d.drawImage(vautourImaged, 0, 0, tailleCaseEnPixel, tailleCaseEnPixel, null);
			}
		}
	}
}

