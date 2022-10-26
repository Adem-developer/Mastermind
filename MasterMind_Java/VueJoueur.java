import javax.swing.*;
import java.awt.*;

public class VueJoueur extends JPanel {

    private VueCouleur blue = new VueCouleur(Color.BLUE);
    private VueCouleur green = new VueCouleur(Color.GREEN);
    private VueCouleur magenta = new VueCouleur(Color.MAGENTA);
    private VueCouleur orange = new VueCouleur(Color.ORANGE);
    private VueCouleur red = new VueCouleur(Color.RED);
    private VueCouleur pink = new VueCouleur(Color.PINK);
    private VueCouleur darkGray = new VueCouleur(Color.darkGray);
    private VueCouleur yellow = new VueCouleur(Color.YELLOW);

    public VueJoueur(Controleur contr){

        
        GridLayout gestionnaire = new GridLayout(2, 1);
        this.setLayout(gestionnaire);

        JPanel panel = new JPanel();
        GridLayout gestionnaire2 = new GridLayout(2, 4);
        panel.setLayout(gestionnaire2);
        
        
        blue.addMouseListener(contr);
        panel.add(this.blue);

        green.addMouseListener(contr);
        panel.add(this.green);
 
        magenta.addMouseListener(contr);
        panel.add(this.magenta);

        orange.addMouseListener(contr);
        panel.add(this.orange);

        red.addMouseListener(contr);
        panel.add(this.red);

        pink.addMouseListener(contr);
        panel.add(this.pink);

        darkGray.addMouseListener(contr);
        panel.add(this.darkGray);

        yellow.addMouseListener(contr);
        panel.add(this.yellow);

        this.add(panel);

        JPanel btn= new JPanel();

        JButton Valider = new JButton("Valider");
        JButton Effacer = new JButton("Effacer");
        JButton Aleatoire = new JButton("Aleatoire");

        Valider.addActionListener(contr);
        Effacer.addActionListener(contr);
        Aleatoire.addActionListener(contr);

        btn.add(Valider);
        btn.add(Effacer);
        btn.add(Aleatoire);

        this.add(btn);
        
    }

    public JComponent getColor(int indice)
    {
        if(indice == 1)
        {
            return this.blue;
        }

        if(indice == 2)
        {
            return this.green;
        }

        if(indice == 3)
        {
            return this.magenta;
        }

        if(indice == 4)
        {
            return this.orange;
        }

        if(indice == 5)
        {
            return this.red;
        }

        if(indice == 6)
        {
            return this.pink;
        }

        if(indice == 7)
        {
            return this.darkGray;
        }

        if(indice == 8)
        {
            return this.yellow;
        }
        return this.red;
    }

    

}
