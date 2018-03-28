import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Okno  extends JFrame{
	protected Platno platno;
	
	public Okno (String title, Platno platno){
		this.setTitle(title);
		this.platno = platno;
		add(platno);
	}
}
