	import java.io.BufferedReader;
import java.io.FileInputStream;
//import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.stream.Collectors;

public class StetjeBesed {
		
	public static void main(String[] args) throws IOException{
		//poklice tisto, ki naredi vektor, in ga izpise
		// potem pa v istem vrstnem redu izpisuje besede in frekvence pojavitev ob vsaki
		//ArrayList<String> izjemee = izjeme("ignore.txt");
		//preveri(izjemee);
		Map<String,Integer> stejem = stetje("cankar.txt","testOut.txt");
		Vector<String> vektor = uredi(stejem);
		System.out.println(vektor);
		izpisi(stejem, vektor);
	}
	
	public static ArrayList<String> izjeme (String vhodna) throws IOException{
				
		BufferedReader vhod = new BufferedReader(new InputStreamReader(new FileInputStream(vhodna), "UTF-8"));
		ArrayList<String> ignore = new ArrayList<String>();
		
		while (vhod.ready()) {
			String vrstica = vhod.readLine().trim();
			ignore.add(vrstica);
		}
		vhod.close();
		//String[] simple = new String[ignore.size()];
		return ignore;
	}
	
	public static Map<String,Integer> stetje (String vhodna, String izhodna) throws IOException{
			Map<String,Integer> slovar = new HashMap<String,Integer>(); // ali pa HashTree
			slovar.put("a", 1);
			ArrayList<String> izjeme = izjeme("ignore.txt");
			
			BufferedReader vhod = new BufferedReader(new InputStreamReader(new FileInputStream(vhodna), "UTF-8"));
			PrintWriter izhod = new PrintWriter(new FileWriter(izhodna));
			while(vhod.ready()) {
				String[] vrstica = vhod.readLine().trim().split(" +");
				for (String beseda: vrstica) {
					beseda = beseda.replaceAll("[^a-zA-ZèæšžðÈŠÆŽÐ]", "").toLowerCase();
				
					if (!izjeme.contains(beseda)) {
						if (slovar.containsKey(beseda)) {
							slovar.put(beseda, slovar.get(beseda) + 1);
						} else {
							slovar.put(beseda, 1);
						}
					}
				}
			}
			for (String beseda : slovar.keySet()) {
				izhod.println(beseda + ":" + slovar.get(beseda));
			}
			
		vhod.close();
		izhod.close();
		return slovar;
	}
	
	public static Vector<String> uredi (Map<String,Integer> slovar) {
		Vector<String> vec = new Vector<String>();
		Map<String,Integer> urejen = slovar
				.entrySet()
				.stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.collect(
						Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,
				                LinkedHashMap::new));
		for (String beseda: urejen.keySet()) {
			vec.add(beseda);
			//System.out.println(beseda);
			}
		return vec;
	}
	
	public static void izpisi (Map<String,Integer> slovar, Vector<String> vec) {
		for(String beseda: vec) {
			System.out.println(beseda + ":" + slovar.get(beseda).toString());
		}
	}
	
	/**
	 * metoda preveri, ce smo pravilno napisali funkcijo, ki vrne seznam besed, 
	 * ki jih v glavni funkciji ignoriramo
	 * @param izjeme
	 */
	public static void preveri (ArrayList<String> izjeme) {
		for (String beseda : izjeme) {
			System.out.println(beseda);
		}
	}

}
