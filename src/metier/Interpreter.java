package metier;

import java.util.Scanner;

public class Interpreter {
	private Scanner sc;
	
	public Interpreter(){
		sc = new Scanner(System.in);
	}
	
	public int getInt() {
		System.out.println("entrez un entier : ");
		return Integer.parseInt(sc.nextLine());
	}
	
	public float getFloat() {
		System.out.println("entrez un decimal : ");
		return Float.parseFloat(sc.nextLine());
	}
	
	public String getString() {
		System.out.println("entrez une chaine de caractère : ");
		return sc.nextLine();
	}
	
	public String[] getArticle() {
		String[] s = new String[4];
		s[0] = "0";
		System.out.println(">.entrez le nom de l'article : ");
		s[1] = sc.nextLine();
		System.out.println(">.entrez le prix de l'article : ");
		s[2] = sc.nextLine();
		System.out.println(">.entrez l'article dans la bdd ? 1 oui 2 non : ");
		s[3] = sc.nextLine();
		return s;
	}
	
	
}
