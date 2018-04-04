import java.util.*;
// * ti importa vse, da ne rabis stokrat eno in isto importat

public class Tocka {
	protected Object ime;
	protected Set<Tocka> sosedi;
	//ce je private moras narest getter, da lahko dostopas do vrednosti
	protected double x;
	protected double y;
	
	
	public Tocka (Object ime){
		this.ime = ime;
		this.sosedi = new HashSet<Tocka>();
		x = 0;
		y = 0;
	
	}
	
	//ni 'Integer', ker pac mislm, ane
	public int stopnja () {
		// ne das static, ker klices komponente posamezne tocke, ki niso staticne
		return sosedi.size();
	}
	
	//metoda main ne spada v class
	
}
