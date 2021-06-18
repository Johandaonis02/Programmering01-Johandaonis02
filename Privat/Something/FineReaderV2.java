import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FineReaderV2 {
	public static void main(String[] args) throws FileNotFoundException {
		//File file = new File("/Users/johan.daun/Documents/GitHub/Programmering01-Johandaonis02/Privat/ShapezShapes.txt");
		char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		
		WriteWord("w..d");
		
		
		/*
		for (int i = 0; i < alphabet.length; i++) {
			System.out.println(String.valueOf(alphabet[i]));
			for (int i2 = 0; i2 <  alphabet.length; i2++) {
				
				String word1 = '.' + String.valueOf(alphabet[i]) + String.valueOf(alphabet[i2]) + String.valueOf(alphabet[i]);
				
				String word2 = '.' + String.valueOf(alphabet[i]) + '.' + String.valueOf(alphabet[i]) + 'm' + '.' + '.' + 'n' + String.valueOf(alphabet[i2]);
				
				if(returnWord(word2) && returnWord(word1)) {
					System.out.println("Yes! " + word1 + " " + word2);
					WriteWord(word1);
					WriteWord(word2);
				}
			}
		}
		
		*/
		
		System.out.println("done");
	}
	
	public static boolean returnWord(String string) throws FileNotFoundException {
		
		File file = new File("/Users/johan.daun/Desktop/TestFile.txt");
		Scanner scan = new Scanner(file);
		
		int b = 0;
		
		String a = scan.nextLine();
		String word = "";
		for (int i = 0; i < a.length(); i++) {
			if(a.charAt(0) == ',') {								
				for (int j = 0; j < string.length(); j++) {
					if(string.length() != word.length()) {
						break;
					}
					if(string.charAt(j) != '.') {
						
						if(string.charAt(j) != word.charAt(j)) {
							break;
						}
					}
					if(j == string.length() - 1) {
						//System.out.println(word);
						return true;
						
					}
				}
				
				i++;
				a = a.substring(1);
				word = "";
			}
			word += a.charAt(0);
			a = a.substring(1);
		}
		
		return false;
		//return("hej");
	}
	
	
	
	
	public static void WriteWord(String string) throws FileNotFoundException {
		
		File file = new File("/Users/johan.daun/Desktop/TestFile.txt");
		Scanner scan = new Scanner(file);
		
		int b = 0;
		
		String a = scan.nextLine();
		String word = "";
		for (int i = 0; i < a.length(); i++) {
			if(a.charAt(0) == ',') {								
				for (int j = 0; j < string.length(); j++) {
					if(string.length() != word.length()) {
						break;
					}
					if(string.charAt(j) != '.') {
						
						if(string.charAt(j) != word.charAt(j)) {
							break;
						}
					}
					if(j == string.length() - 1) {
						System.out.println(word);
					}
				}
				
				i++;
				a = a.substring(1);
				word = "";
			}
			word += a.charAt(0);
			a = a.substring(1);
		}
		
		//return("hej");
	}
}
