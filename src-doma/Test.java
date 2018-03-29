
public class Test {

	public static void main(String[] args) {
		//Graf g = Graf.prazen(10);
		//System.out.println(g.tocke);
		
		
		Platno platno = new Platno(1000,1000);
		Okno okno = new Okno("naslov", platno);
		
		Graf graf = Graf.poln(15);
		graf.razporedi(300,600, 350);
		platno.narisi(graf);
		
		okno.pack();
		okno.setVisible(true);
		
	}

}

