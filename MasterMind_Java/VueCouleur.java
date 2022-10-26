import java.awt.*;
import javax.swing.*;


public class VueCouleur extends JComponent
{
    private Color coul;

    public VueCouleur(Color c)
    {
        super();
        this.coul = c;
    }

    public Color getColor()
    {
        return this.coul;
    }

    @Override
    public void paintComponent(Graphics g) {

        g.setColor(getColor());
        g.fillOval(50, 50, 50, 50);
    }

}
