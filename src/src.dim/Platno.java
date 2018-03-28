import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashSet;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Platno extends JPanel implements MouseMotionListener, MouseListener, KeyListener{
	protected int visina;
	protected int sirina;
	protected Graf graf;
	protected HashSet<Tocka> izbrane;
	protected final int polmer;
	protected Tocka aktivna;
	protected final Color barvaVseh = Color.cyan;
	protected final Color barvaIzbrane = Color.ORANGE;
	private int prejsnjiX;
	private int prejsnjiY;
	
	public Platno (int visina, int sirina){
		this.visina = visina;
		this.sirina = sirina;
		graf = null;
		addMouseListener(this);
		addKeyListener(this);
		addMouseMotionListener(this);
		izbrane = new HashSet<Tocka>();
		polmer = 10;
		aktivna = null;
		prejsnjiX = 0;
		prejsnjiY = 0;
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
			
			if (t == aktivna){
				g.setColor(barvaIzbrane);
			} else {
				g.setColor(barvaVseh);
			}
			
			g.fillOval(round(t.x) - polmer, round(t.y) - polmer, 2 * polmer, 2 * polmer);
			
			// za visino in sirino imamo definirano konstanto polmer
			
			// zdaj mu pa se narisemo rob
			g.setColor(Color.ORANGE);
			g.drawOval(round(t.x) - polmer, round(t.y) - polmer, 2 * polmer, 2 * polmer);

		}
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		for (Tocka tocka : graf.tocke.values()){
			if (e.getPoint().distance(tocka.x, tocka.y) < polmer){
				izbrane.add(tocka);
			}
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		prejsnjiX = e.getX();
		prejsnjiY = e.getY();
		for (Tocka tocka : graf.tocke.values()){
			if (e.getPoint().distance(tocka.x, tocka.y) < polmer){
				aktivna = tocka;
			}
		}
		repaint();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		aktivna = null;
		repaint();
		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if (aktivna != null){
			aktivna.x += (e.getX()- prejsnjiX);
			aktivna.y += (e.getY()- prejsnjiY);
			prejsnjiX = e.getX();
			prejsnjiY = e.getY();
		}
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {}
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mouseMoved(MouseEvent e){}
}
