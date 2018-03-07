
public class Poudari {

	public static void main(String[] args) {
		poudari("zadnja novica");
		poudari_zvezdica("Zadnja *novica* danes!");
	}
	
	public static String poudari(String stavek){
		String rezultat = "";
		for(int i = 0; i < stavek.length(); i++){
			rezultat += Character.toUpperCase(stavek.charAt(i));
			}
		System.out.println(rezultat);
		return rezultat;
		}
		

	public static String poudari_zvezdica(String stavek){
		String rezultat = "";
		boolean flag = false;
		for (int i = 0; i < stavek.length(); i++){
			char c = stavek.charAt(i);
			if ( c == '*'){ //primerjava, npr. pri pogojih, se pise z dvema ==
				flag = !flag;
			} else {
				if (flag==false){
					rezultat += c;
				} else{
					rezultat += Character.toUpperCase(c);
				}
			}
		}
		System.out.println(rezultat);
		return rezultat;
	}

}
