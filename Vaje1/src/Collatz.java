
public class Collatz {

	public static void main(String[] args) {
		int a = dolzina(60);
		System.out.println(a);

	}
	
	public static int dolzina (int prvi) {
		int i = 1;
		while (prvi != 1) {
			if ((prvi % 2) == 0) {
				i++;
				prvi /= 2;
			} else {
				i++;
				prvi = prvi * 3 + 1;
				
			}
		}
		
		return i;
	}

}
