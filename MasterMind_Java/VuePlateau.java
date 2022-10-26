import javax.swing.*;
import java.awt.*;

public class VuePlateau extends JComponent {

    private Combinaison[] proposition = new Combinaison[10] ;
    private Combinaison[] reponse = new Combinaison[10];

    public VuePlateau(Combinaison prop[], Combinaison rep[]){
        super();
        this.proposition = prop;
        this.reponse = rep;
    }

    @Override
    public void paintComponent(Graphics g) {
    
    
    for(int j = 0; j < 10; j++){
        for(int i = 0; i < 10 ; i++)
        {
            if(i < 5)
            {
                g.setColor(this.proposition[j].choix[i]);
                g.fillOval(50*i, 50*j, 50, 50);
            }
            else
            {
                g.setColor(this.reponse[j].choix[i-5]);
                g.fillOval(i*50, 50*j, 30, 30);
            }
        }
    }
    }
}
