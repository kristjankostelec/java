import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Stetje {

	public static void main(String[] args) throws IOException{
		//poklice tisto, ki naredi vektor, in ga izpise
		// potem pa v istem vrstnem redu izpisuje besede in frekvence pojavitev ob vsaki
		String[] izjemee = izjeme("ignore.txt");
		preveri(izjemee);

	}
	
	public static String[] izjeme (String vhodna) throws IOException{
		
		BufferedReader vhod = new BufferedReader(new FileReader(vhodna));
		ArrayList<String> ignore = new ArrayList<String>();
		
		while (vhod.ready()) {
			String vrstica = vhod.readLine().trim();
			ignore.add(vrstica);
		}
		vhod.close();
		String[] simple = new String[ignore.size()];
		return (ignore.toArray(simple));
	}
	
	public static Map<String, Integer> stetje (String vhodna, String izhodna) throws IOException{
			Map<String,Integer> slovar = new HashMap<String,Integer>(); // ali pa HashTree
			slovar.put("a", 1);
			
			//BufferedReader vhod = new BufferedReader(new FileReader(vhodna));
			//PrintWriter izhod = new PrintWriter(new FileWriter(izhodna));
			//String vrstica = vhod.readLine().trim();
		return slovar;
	}
	
	
	
	/**
	 * metoda preveri, ce smo pravilno napisali funkcijo, ki vrne seznam besed, 
	 * ki jih v glavni funkciji ignoriramo
	 * @param izjeme
	 */
	public static void preveri (String[] izjeme) {
		for (String beseda : izjeme) {
			System.out.println(beseda);
		}
	}

}
