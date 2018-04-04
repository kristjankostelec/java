
public class Test {

	public static void main(String[] args) {
		//Graf g = Graf.prazen(10);
		//System.out.println(g.tocke);
		
		
		Platno platno = new Platno(500,500);
		Okno okno = new Okno("naslov", platno);
		
		//Graf graf = Graf.polnDvodelen(5,5);
		//graf.razporedi(100, 150, 150);
		//platno.narisi(graf);
		
		okno.pack();
		okno.setVisible(true);
		
	}

}

