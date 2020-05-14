import java.util.Iterator;
import java.util.Scanner;

public class HangaGubben {
	
	static String[] words = {"KAN", "FYR", "EK", "AFTON", "LJUD", "BIBLIOTEK", "ORANGE", "ULL", "INNAN"};
	
	public static void main(String[] args) {
		Welcome();
		
		int difficulty = AskPlayerDifficulty();
		
		String dummyWord = words[(int)(3*(Math.random() + difficulty))];
		char[] fullWord = new char[dummyWord.length()];
		char[] partWord = new char[dummyWord.length()];
		
		for (int i = 0; i < fullWord.length; i++) {
			fullWord[i] = dummyWord.charAt(i);
			partWord[i] = '_';
		}
		
		
	}
	
	public static int RemoveOneGuess(int numberOfGuessesLeft) {
		return numberOfGuessesLeft--;
	}
	
	public static int AskPlayerDifficulty() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Vilken sv�righetsgrad vill du ha? (L�tt, mellan eller sv�r)");
		while (true) {
			String dummyString = input.nextLine();
			
			if(dummyString.toUpperCase().equals("L�TT")) {
				return 0;
			}
			if(dummyString.toUpperCase().equals("MELLAN")) {
				return 1;
			}
			if(dummyString.toUpperCase().equals("SV�R")) {
				return 2;
			}
			System.out.println("Du m�ste skriva l�tt, mellan eller sv�r");
		}
	}
	
	public static void Welcome() {
		System.out.println("Detta spelet �r h�nga gubben. Du f�r ett svenskt ord och du ska gissa bokstav efter bokstav. Om du gissar r�tt s� visar bokstaven sig medans om du gissar fel s� kommer du ett steg n�rmre att f�rlora.");
	}
}
