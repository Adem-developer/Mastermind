import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//TODO : ne pas oublier les éventuels import

public class Controleur extends JPanel implements MouseListener, ActionListener {

//TODO: ajouter les attributs du controleur
	
	private Combinaison combi = new Combinaison();
	private Combinaison defaultcombi = new Combinaison();
	private Combinaison combirep = new Combinaison();
	private Combinaison defaultcombirep = new Combinaison();
	private Combinaison[] combi10 = new Combinaison[10];
	private Combinaison[] combirep10 = new Combinaison[10];
	private Defenseur Def = new Defenseur();
	
	private VueJoueur vj = new VueJoueur(this);
	private VuePlateau vp = new VuePlateau(this.combi10, this.combirep10);

	int nbCombi = 0;
	

	public Controleur(){
		super();
		GridLayout ForControl = new GridLayout(1,2);
		this.setLayout(ForControl);
		this.add(vj);
		this.add(vp);

		for(int i = 0; i < 5; i++)
		{
			this.defaultcombi.add(Color.lightGray);
			this.defaultcombirep.add(Color.lightGray);
		}
		System.out.println(defaultcombi);

		for(int i = 0; i < 10; i++)
		{
			this.combi10[i] = this.defaultcombi;
			this.combirep10[i] = this.defaultcombirep;
		}
		

	}


	//proposer s'appelle quand on valide une combinaison, elle la teste et affiche la réponse.
	//C'est également là que le controleur détermine s'il y a un gagnant. 
	private void proposer(Combinaison essaie){
		this.combirep = this.Def.comparer(essaie);
		this.combirep10[this.nbCombi] = this.combirep;
		this.vp.repaint();



		if (this.combirep10[this.nbCombi].choix[0] == Color.BLACK && 
        this.combirep10[this.nbCombi].choix[1] == Color.BLACK &&
        this.combirep10[this.nbCombi].choix[2] == Color.BLACK &&
        this.combirep10[this.nbCombi].choix[3] == Color.BLACK &&
        this.combirep10[this.nbCombi].choix[4] == Color.BLACK) {

			this.combi.gagner();
            JFrame fenetre = new JFrame();
        
            JOptionPane.showMessageDialog(fenetre, "Bien joue, j'ai toujours cru en vous !");
            System.exit(0);
        }

        else if 
            ( nbCombi == 9 ){

            JFrame fenetre2 = new JFrame();
        
            JOptionPane.showMessageDialog(fenetre2, "Dommage ! Vous etiez presque, reessayez !");

            System.exit(0);

        }
	}


	public void mouseClicked(MouseEvent e){
		this.combi10[nbCombi] = this.combi;
		if(e.getComponent().equals(vj.getColor(1))){
			System.out.println("Blue");
			combi.add(Color.BLUE);
			this.repaint();
		}
		if(e.getComponent().equals(vj.getColor(2))){
			System.out.println("Green");
			combi.add(Color.GREEN);
			this.repaint();
		}	
		if(e.getComponent().equals(vj.getColor(3))){
			System.out.println("Magenta");
			combi.add(Color.MAGENTA);
			this.repaint();
		}
		if(e.getComponent().equals(vj.getColor(4))){
			System.out.println("Orange");
			combi.add(Color.ORANGE);
			this.repaint();

		}
		if(e.getComponent().equals(vj.getColor(5))){
			System.out.println("Red");
			combi.add(Color.RED);
			this.repaint();
		}
		if(e.getComponent().equals(vj.getColor(6))){
			System.out.println("Pink");
			combi.add(Color.PINK);
			this.repaint();
		}
		if(e.getComponent().equals(vj.getColor(7))){
			System.out.println("darkGray");
			combi.add(Color.darkGray);
			this.repaint();
		}
		if(e.getComponent().equals(vj.getColor(8))){
			System.out.println("Yellow");
			combi.add(Color.YELLOW);
			this.repaint();
		}
	}

	

	public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}

	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand() == "Valider")
		{
			int index = this.combi.getIndex();

			if(index < 5)
			{
				System.out.println("Pas assez de couleurs");
			}
			else
			{
				System.out.println("Val");
				this.proposer(this.combi10[nbCombi]);
				this.combi = new Combinaison();
				nbCombi++;
			}

		}

		if(e.getActionCommand() == "Effacer")
		{
			this.combi.setIndex(0);
			for(int i = 0; i < 5; i++)
			{
				this.combi.choix[i] = Color.lightGray;
			}
			this.combi10[nbCombi]= combi;
			this.repaint();
		}

		if(e.getActionCommand() == "Aleatoire")
		{
			this.combi.random();
			this.combi10[nbCombi] = combi;
			this.repaint();
		}
	}

	public static void main(String[] args)
	{
		JFrame fenetre = new JFrame();
        fenetre.setSize(1000,700);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Controleur Control = new Controleur();
        fenetre.add(Control);

        fenetre.setVisible(true);

	}
}
