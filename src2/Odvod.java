public class Odvod {

	public static void main(String[] args){
		/*
		double [] p =  new double [args.length];
		for (int j=0; j < args.length; j++){
			p[j] = Integer.parseInt(args[j]);
		}
		
		double[] rezultat = odvod(p,1);
		
		for (int i = 0; i < rezultat.length; i++){
			System.out.print(rezultat[i]);
		}
		*/
		
		double [] test = odvod(new double[] {1,1,1,1,1,1}, 2);
		System.out.print((int) (test[0]) + "x^" + (test.length));
		for (int i = 1; i < test.length; i++){
					System.out.print( " + " + (int) (test[i]) + "x^" + (test.length - i));
		}
	}
	
	public static int fakulteta (int n) {	
	//izracunamo n! za lazje dolocanje koeficienta
		int koeficient = 1;
			for (int i=1; i <= n; i++){
				koeficient *= i;
			}
			return koeficient;
	}
	
	//double[] je tabela realnih stevil. niz.length(), tabela.length.
	
	public static double[] odvod (double[] p, int n){
		int dolzina = p.length;
		int koeficient = 1;
		
		koeficient = fakulteta(p.length - 1) / fakulteta (dolzina - n - 1 );
		
		System.out.println(koeficient);
		System.out.println(fakulteta(p.length));
		System.out.println(fakulteta(dolzina - n));

		
		double [] rezultat = new double [dolzina - n]; //dolzina doubla je podana v oglatih oklepajih
				
		//v tabeli prvega polinoma delamo s tistimi, ki so na koncu razlicni od 0
		for (int i = 0; i < (dolzina - n); i++){
			rezultat[i] = p[n+i] * koeficient;
			koeficient /= (dolzina - i - 1); //ce sta obe stevili celi, bo to deljenje delovalo v redu.
			koeficient *= (dolzina - n - i -1);
			
		}
		return rezultat;
	}

}
