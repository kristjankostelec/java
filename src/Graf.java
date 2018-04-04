import java.util.*;

public class Graf {
	protected Map<Object,Tocka> tocke;
	
	public Graf(){
		tocke = new HashMap<Object,Tocka>();
	}
	
	public boolean povezava (Tocka t1, Tocka t2){
		return (t2.sosedi.contains(t1.ime));
	}
	
	public void dodajTocko (Tocka tocka){
		if (!tocke.containsKey(tocka.ime)){
			tocke.put(tocka.ime,tocka);
		}
	}
	
	public void dodajPovezavo (Tocka t1, Tocka t2){
		if (!(t1==t2) && !(t2.sosedi.contains(t1))){
			t2.sosedi.add(t1);
			t1.sosedi.add(t2);
		}
	}
	
	public void odstraniPovezavo (Tocka t1, Tocka t2){
		if (t1.sosedi.contains(t2)){
			t1.sosedi.remove(t2);
			t2.sosedi.remove(t1);
		}
	}
	
	public void odstraniTocko (Tocka tocka){
		for (Tocka t : tocka.sosedi){
			t.sosedi.remove(tocka);
		}
		tocke.remove(tocka.ime);
	}
	
	public static Graf prazen (int n){
		Graf novGraf = new Graf();
		for (int i = 0; i < n; i++){
		novGraf.dodajTocko(new Tocka(i));
		//ali pa: novGraf.tocke.put(i, new Tocka(i));
		}
		return novGraf;
	}
	
	public static Graf cikel (int n){
		Graf g = prazen(n);
		/*AL PA PAC NA DOLGO:
		 * 
		Graf g = new Graf();
		for (int i = 0; i < n; i++){
			Tocka tocka = new Tocka(i);
			g.dodajTocko(tocka);
		}
		*/
		g.dodajPovezavo(g.tocke.get(n-1), g.tocke.get(0));
		for (int i = 1; i < n; i++){
			g.dodajPovezavo(g.tocke.get(i), g.tocke.get(i-1));
		}
		return g;
	}
	
	public static Graf poln (int n){
		Graf g = prazen(n);
		for (int i = 1; i < n; i++){
			for (int j = 0; j < n; j ++)
				g.dodajPovezavo(g.tocke.get(i), g.tocke.get(j));
		}
		/*
		for (Tocka t1 : g.tocke.values()){
			for (Tocka t2 : t1.sosedi){
				g.dodajPovezavo(t1,t2);
			}
		}
		*/
		return g;
	}
	
	public static Graf polnDvodelen (int n, int m){
		Graf g = prazen (n + m);
		for (int i = 0; i < n; i++){
			for (int j = n; j < n + m; j++){
				g.dodajPovezavo(g.tocke.get(i), g.tocke.get(j));
			}
		}
		return g;
	}
	
	public void razporedi (int r, int a, int b){
		int n = tocke.size();
		int i = 0;
		for (Tocka t : tocke.values()){
			t.x = a + r * Math.cos(2*Math.PI*i/n);
			t.y = b + r * Math.sin(2*Math.PI*((double)i/(double)n));
			// i/n ne dela, ker mas cela stevila. narejeno je na dva razlicna nacina (ena pri cos in ena pri sin)
			i ++;
		}
	}
	

}
