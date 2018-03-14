import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Golovec {

	public static void main(String[] args) throws IOException{
		System.out.println(80f / 3.6 );
		kazni("test.txt", "kaznjenci.txt");

	}
	
	public static Integer kazni(String vhodna, String izhodna) throws IOException{
		
		BufferedReader vhod = new BufferedReader(new FileReader(vhodna));
		PrintWriter izhod = new PrintWriter(new FileWriter(izhodna));
		Integer stevec = 1;
		
		DecimalFormatSymbols symbol = new DecimalFormatSymbols();
		symbol.setDecimalSeparator('.');
		DecimalFormat df = new DecimalFormat("0.00",symbol);
		df.setRoundingMode(RoundingMode.HALF_UP);
		
		while (vhod.ready()){
			
			String vrstica = vhod.readLine();
			if (vrstica.equals(" ")) continue;
			String[] podatki = vrstica.split(" ");			
			
			float hitrost = 622f / (Integer.parseInt(podatki[1])
								- Integer.parseInt(podatki[0]));
			
			if (hitrost > (80f / 3.6 )) {
				izhod.println(podatki[2] + " " + df.format(hitrost * 3.6));
				stevec += 1;
				
			}
		}
		vhod.close();
		izhod.close();
		System.out.println(stevec); //a je rezultat pravilen?
		return stevec;
		
	}
	

}
