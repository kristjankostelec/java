import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Platno extends JPanel{
	protected int visina;
	protected int sirina;
	protected Graf graf;
	
	public Platno (int visina, int sirina){
		this.visina = visina;
		this.sirina = sirina;
		graf = null;
	}
	
	public void narisi (Graf g){
		graf = g;
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(visina, sirina);
	}
	
	//pomozna funkcija, da lahko risemo te like
	public static int round (double x){
		return (int)(x + 0.5);
	}
	
	public void paintComponent(Graphics g){
		// najprej narisemo vse povezave, nato se vsa vozlisca
		
		for (Tocka t1 : graf.tocke.values()){
			for (Tocka t2 : t1.sosedi){
				g.drawLine(round(t1.x), round(t1.y),round(t2.x),round(t2.y));
			}

		}
		
		for (Tocka t : graf.tocke.values()){
			g.setColor(Color.cyan);
			g.fillOval(round(t.x) - 10, round(t.y) - 10, 21, 21);
			
			// za visino in sirino izberemo pac neke vrednosti
			
			// zdaj mu pa se narisemo rob
			g.setColor(Color.ORANGE);
			g.drawOval(round(t.x) - 10, round(t.y) - 10, 21, 21);

		}
	}

}
