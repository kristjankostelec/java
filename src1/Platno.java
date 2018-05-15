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
	protected final Color barvaOznacenih = Color.BLUE;
	protected final Color barvaPovezav = Color.MAGENTA;
	private int prejsnjiX;
	private int prejsnjiY;
	
	public Platno (int visina, int sirina){
		this.visina = visina;
		this.sirina = sirina;
		graf = null;
		addMouseListener(this);
		addKeyListener(this);
		addMouseMotionListener(this);
		setFocusable(true);
		requestFocusInWindow();
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
		super.paintComponent(g);
		
		//g.fillRect(0, 0, visina, sirina); samo trenutna resitev, ampak tud dobr zgleda
		
		for (Tocka t1 : graf.tocke.values()){
			g.setColor(barvaPovezav);
			for (Tocka t2 : t1.sosedi){
				g.drawLine(round(t1.x), round(t1.y),round(t2.x),round(t2.y));
			}

		}
		
		for (Tocka t : graf.tocke.values()){
			
			if (t == aktivna){
				g.setColor(barvaIzbrane);
			} else if (izbrane.contains(t)){
				g.setColor(barvaOznacenih);
			} else{
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
	public void mousePressed(MouseEvent e) {
		prejsnjiX = e.getX();
		prejsnjiY = e.getY();
		
		for (Tocka tocka : graf.tocke.values()){
			if (e.getPoint().distance(tocka.x, tocka.y) < polmer){
				if (!izbrane.contains(tocka)){
					izbrane.add(tocka);
				} else{
					izbrane.remove(tocka);
				}
			}
		}
		
		for (Tocka tocka : graf.tocke.values()){
			if (e.getPoint().distance(tocka.x, tocka.y) < polmer){
				aktivna = tocka;
			}
		}
		repaint();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (aktivna == null) {
			int j = graf.tocke.size() + 1;
			Tocka t1 = new Tocka (j);
			t1.x = e.getX();
			t1.y = e.getY();
			graf.dodajTocko(t1);
			for (Tocka t2 : izbrane) {
				graf.dodajPovezavo(t1, t2);
			}
			if (izbrane.contains(t1)) {
				izbrane.remove(t1);
			}
		} 
		aktivna = null;
		repaint();
		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		
		if (aktivna != null){
			aktivna.x += (e.getX()- prejsnjiX);
			aktivna.y += (e.getY()- prejsnjiY);
			if (izbrane.contains(aktivna)) {
				izbrane.remove(aktivna);
			} 			
		} else {
			for (Tocka t : izbrane){
				t.x += (e.getX()- prejsnjiX);
				t.y += (e.getY()- prejsnjiY);
				
			}
		}
		
		prejsnjiX = e.getX();
		prejsnjiY = e.getY();
		
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_A) {
			for (Tocka t : graf.tocke.values()) {
				izbrane.add(t);
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_N) {
			for (Tocka t : graf.tocke.values()) {
				izbrane.remove(t);
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			for (Tocka t : izbrane) {
				graf.tocke.remove(t.ime);
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_F) {
			for (Tocka t1 : izbrane) {
				for (Tocka t2: izbrane) {
					graf.dodajPovezavo(t1, t2);
				}
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_X) {
			for (Tocka t1 : izbrane) {
				for (Tocka t2: izbrane) {
					graf.odstraniPovezavo(t1, t2);
				}
			}
		}
		repaint();
		
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
	@Override
	public void mouseClicked(MouseEvent e) {}
}
