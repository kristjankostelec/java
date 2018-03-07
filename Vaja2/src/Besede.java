import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;

public class Besede {

	public static void main(String[] args) throws IOException{
		prestej(args[0],args[1]);
	}
	
	public static Integer prestej(String vhodna, String izhodna) throws IOException{ //tip execption izjema, jo pac dodas
		// IZOGIBAJ SE vrstica==""
		// ne pozabi datotek zapret za sabo
		BufferedReader vhod = new BufferedReader(new FileReader(vhodna));
		PrintWriter izhod = new PrintWriter(new FileWriter(izhodna));
		Hashtable<String, Integer> slovarBesed = new Hashtable<String, Integer>();
				
		while (vhod.ready()){
			String vrstica = vhod.readLine().trim().toLowerCase(); //trim pobere ven konec vrstice; tolowercase kar cel string, ne rabis vsake besede posebej
			if (vrstica.equals(" ")) continue;
			String[] besede = vrstica.split(" +");
						
			for (String beseda : besede){  // enakovredno for (Int i; i < besede.lenth; i++){String beseda = besede[i];}
				if (slovarBesed.contains(beseda)){
					slovarBesed.put(beseda, slovarBesed.get(beseda) + 1);
				} else{
					slovarBesed.put(beseda,1);
				}
				
			}
			
		}
			
			izhod.println("stevilo besed v datoteki:" + Integer.toString(slovarBesed.size()));
			
			for (String beseda : slovarBesed.keySet() ){
				izhod.println(beseda);	
			}
				
		vhod.close();
		izhod.close();
		return slovarBesed.size();	

}
	
}

// za tretjo nalogo: StringTokenizer - isto kot split, samo da mu nastejes vse znake, s katerimi locuje. Vraca vsako besedo posebej