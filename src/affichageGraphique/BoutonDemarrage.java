package affichageGraphique;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BoutonDemarrage extends JFrame{
  private JPanel pan = new JPanel();
  private JButton bouton = new JButton("Démarrer !");

  public BoutonDemarrage(){
    this.setTitle("Démarrage");
    this.setSize(300, 150);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    //Ajout du bouton à notre content pane
    pan.add(bouton);
    this.setContentPane(pan);
    this.setVisible(true);
  }       
}