import java.awt.*;
import java.util.*;

public class Combinaison {
	//choix contient les pions de la combinaison
	protected Color[] choix;
	//index contient le nombre de pions ajoutés à la combinaison
	protected int index;

	public Combinaison(){
	this.index = 0;
	this.choix = new Color[5];

	for(int i = 0; i < 5; i++)
	{
		this.choix[i] = Color.lightGray;
	}
	}


	public Combinaison(Combinaison c)
	{
		this.index = 0;
		this.choix = new Color[5];

		for(int i = 0; i < 5; i++)
		{	
			this.choix[i] = Color.lightGray;
		}

		for(int i = 0; i < 5; i++ )
		{
			this.add(c.choix[i]);
		}
		
	}

	//add ajoute une couleur à la combinaison
	public void add (Color c){


		if(this.index >= 5)
		{
			System.out.println("Trop de couleur");
		}
		else
		{
			this.choix[index] = c;
			this.index++;
		}
		
	}

	//int trouveur;

	// comparer compare la combinaison avec une autre donnée en argument. 
	// Elle renvoie la réponse, càd une combinaison contenant des couleurs noires, blancs ou grisclair. 
	public Combinaison comparer(Combinaison c){
		Combinaison combirep = new Combinaison();
		Combinaison seconde = new Combinaison(this);

		for(int i = 0; i < 5; i++)
		{
			if(this.choix[i].equals(c.choix[i]))
			{
				combirep.choix[i] = Color.BLACK;
				seconde.choix[i] = Color.lightGray;
			}
		}

		for(int i = 0; i <5; i++)
		{
			for(int j =0; j < 5; j++)
			{
				if(c.choix[i].equals(seconde.choix[j]))
				{
						combirep.choix[i] = Color.WHITE;
						seconde.choix[j] =Color.lightGray;
						break;
				}
			}
		}

		return combirep;
	}

	public void random()
	{	
		for(int i = 0; i < 5; i++)
		{
		Random r = new Random();
		int n = r.nextInt(7);
		if(n == 0)
		{
			this.add(Color.BLUE);
		}
		else if(n == 1)
		{
			this.add(Color.RED);
		}
		else if(n == 2)
		{
			this.add(Color.ORANGE);
		}
		else if(n==3)
		{
			this.add(Color.darkGray);
		}
		else if(n==4)
		{
			this.add(Color.PINK);
		}
		else if(n==5)
		{
			this.add(Color.MAGENTA);
		}
		else if(n==6)
		{
			this.add(Color.YELLOW);

		}
		else if(n==7)
		{
			this.add(Color.GREEN);
		}
		}
		this.setIndex(5);
	}

	public void effacer()
	{

	}


	//TODO gagner test si une combinaison réponse (obtenue via comparer) est gagnante
	public boolean gagner(){
		System.out.println("Gagné");
		return true;
	}

	public int getIndex(){
			return this.index;
		}

	public void setIndex(int index)
	{
		this.index = index;
	}


	public String toString(){
		String s="Combinaison : ";
		for(int i=0;i<index;i++){
		if(choix[i].equals(Color.blue)){s+="Bleu, ";}
		if(choix[i].equals(Color.green)){s+="Vert, ";}
		if(choix[i].equals(Color.magenta)){s+="Magenta, ";}
		if(choix[i].equals(Color.orange)){s+="Orange, ";}
		if(choix[i].equals(Color.red)){s+="Rouge, ";}
		if(choix[i].equals(Color.pink)){s+="Rose, ";}
		if(choix[i].equals(Color.yellow)){s+="Jaune, ";}
		if(choix[i].equals(Color.darkGray)){s+="Gris, ";}
		if(choix[i].equals(Color.black)){s+="Bien placé, ";}
		if(choix[i].equals(Color.white)){s+="Mal placé, ";}
		if(choix[i].equals(Color.lightGray)){s+="Absent, ";}
		}
		return s;
	}
}
