
public class Razcep {

	public static void main(String[] args) {
		cepi(5761665);
		cepi(-1);

	}
	
	public static void cepi(int stevilo){
		try {
			char op = '=';
			System.out.print(stevilo);
			int del = 2;
			
			while (stevilo != 1) {
				int eks = 0;
				while (stevilo % del == 0){
					eks += 1;
					stevilo /= del;
				}
				
				if (eks == 0){
				} else if (eks == 1){
					System.out.print(" " + op + ' ' + del);
					op = '*';
				} else {
					System.out.print(" " + op + ' ' + del + '^' + eks);
					op = '*';
				}
				del +=1;
					}
		
		}
		
		catch (Exception e) {
			System.out.println("nekaj ni v redu...");
		}
//CE SE TI KODA PONAVLJA, NPR. DA NEKAJ IZPISUJES VECKRAT, POMISLI NA POENOSTAVITEV!
	}
}

//NAUCI SE KAKO SE PRAVILNO NAREDI EXCEPTION, NA PRIMER NA TEM PRIMERU