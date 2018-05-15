public class Prastevilo {
	
	public static void main(String[] args) {
		deli(10,5);
		System.out.println(jePrastevilo(10));
		System.out.println(jePrastevilo(29));		

	}
	
	public static boolean deli (int n, int m) {
		if (n%m==0) {
			System.out.println("true");
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean jePrastevilo (int n) {
		for (int i = 2; i <= Math.sqrt((double) n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
