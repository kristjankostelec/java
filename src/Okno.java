import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.*;
//tko vse naenkrat importas


@SuppressWarnings("serial")
public class Okno  extends JFrame implements ActionListener{
	protected Platno platno;
	protected JMenuItem open = new JMenuItem("Open");
	protected JMenuItem prazen = new JMenuItem("Prazen");
	protected JMenuItem cikel = new JMenuItem("Cikel");
	protected JMenuItem poln = new JMenuItem("Poln");
	protected JMenuItem polnD = new JMenuItem("Pol dvodelen");
	protected JMenuItem rdeca = new JMenuItem("Rdeèa");
	
	
	public Okno (String title, Platno platno){
		this.setTitle(title);
		this.platno = platno;
		add(platno);
	
	JMenuBar mb = new JMenuBar();
	JMenu file = new JMenu("File");
	JMenu grafi = new JMenu("Graph type");
	JMenu barve = new JMenu("Barve!");
	JMenu izhod = new JMenu("Exit");
	
	JMenuItem open = new JMenuItem("Open");
	JMenuItem prazen = new JMenuItem("Prazen");
	JMenuItem cikel = new JMenuItem("Cikel");
	JMenuItem poln = new JMenuItem("Poln");
	JMenuItem polnD = new JMenuItem("Pol dvodelen");
	JMenuItem rdeca = new JMenuItem("Rdeèa");

	
	file.add(open);
	grafi.add(prazen);
	grafi.add(cikel);
	grafi.add(poln);
	grafi.add(polnD);
	barve.add(rdeca);	
	
	open.addActionListener(this);
	prazen.addActionListener(this);
	cikel.addActionListener(this);
	poln.addActionListener(this);
	polnD.addActionListener(this);
	rdeca.addActionListener(this);

	
	file.addSeparator();
	mb.add(file);
	mb.add(grafi);
	mb.add(barve);
	mb.add(izhod);
	setJMenuBar(mb);
	//vse to je znotraj konstruktorja
	
	}
			
	@Override
	public void actionPerformed(ActionEvent e) {
		Object a = e.getSource();
		if (a == this.prazen){
			platno.narisi(Graf.prazen(10));
		}
		
		
		String n = JOptionPane.showInputDialog("Vnesi stevilo vozlisc :)");
		Graf g = Graf.poln(Integer.parseInt(n));
		g.razporedi(100, 150, 150);
		platno.narisi(g);
		
		Color barva = JColorChooser.showDialog(this, "Izberi barvo tocke :)", platno.barvaVseh);
		if (barva != null){
			platno.barvaVseh = barva;
			platno.repaint();
			}
		//to za vse mozne barve
		
		dispatchEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING));
		
		
	}
}
