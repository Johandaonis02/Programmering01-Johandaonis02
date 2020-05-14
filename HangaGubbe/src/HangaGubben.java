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
}
