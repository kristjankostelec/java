public class Collatz {

	public static void main(String[] args) {
		int a = dolzina(60);
		System.out.println(a);
		int b = najvecji(201);
		System.out.println(b);
		vsiCleni(6);

	}
	
	public static int novClen (int x) {
		if ((x % 2) == 0) {
			return x /= 2;
		} else {
			return x * 3 + 1;
			
		}
	}
	
	public static int dolzina (int prvi) {
		int i = 1;
		while (prvi != 1) {
			prvi = novClen(prvi);
			i++;
		}
		
		return i;
	}
	
	//funkcija, ki izpise najvecji clen v zaporedju ki se zacne s stevilom n
	public static int najvecji (int n) {
		int maks = n;
		while (n != 1) {
			if (novClen(n) > maks) {
				maks = novClen(n);
			}
			n = novClen(n);
		}
		return maks;
		
	}
	
	//funkcjia, ki izpise vse clene zaporedja
	public static void vsiCleni (int n) {
		while (n !=1) {
			System.out.print(n + " ");
			n = novClen(n);
			
		}
	}

}