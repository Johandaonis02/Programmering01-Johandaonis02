import java.lang.Math;

public class Metoder {
	public static void main(String[] args) {
		double radius = 1;
		System.out.println(volume(radius));
		String str = "Johan";
		System.out.println(reverse(str));
		char c = 'a';
		System.out.println(count(str, c));
		System.out.println(sjorovare(str));
	}
	
	/**
	 * Sphere's volume
	 * @param radius
	 * @return Calculating volume on a sphere with radius as input
	 */
	public static double volume(double radius) {
		return(Math.PI * Math.pow(radius, 3.) * 4. / 3.);
	}
	
	/**
	 * Reversing strings
	 * @param str
	 * @return string backwards
	 */
	public static String reverse(String str) {
		String reverseStr = "";
		for(int i = str.length() - 1; i >= 0; i--) {
			reverseStr += str.charAt(i);
		}
		return(reverseStr);
	}
	
	/**
	 * Calculating how many characters c there are in the string
	 * @param str
	 * @param c
	 * @return How many characters c there are in the string.
	 */
	public static int count(String str, char c) {
		int numberOfOccurances = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == c) {
				numberOfOccurances++;
			}
		}
		return(numberOfOccurances);
	}
	/**
	 * Translate from swedish to rövarspråket
	 * @param str
	 * @return The letters in the input string get replaced by two of the same letter with a o in the middle of them if the letters isn't vowel. The letter doesn't get effected if the letter is a vowel
	 */
	public static String sjorovare(String str) {
		char vowels[] = {'e','a','o','i','u','å','y','ä','ö'};
		boolean testIfCharIsVowel;
		String rovarspraketWord = "";
		for(int i = 0; i < str.length(); i++) {
			testIfCharIsVowel = false;
			for(int j = 0; j < vowels.length; j++) {
				if(str.charAt(i) == vowels[j]) {
					testIfCharIsVowel = true;
					break;
				}
			}
			if(testIfCharIsVowel == false) {
				rovarspraketWord += str.charAt(i) + "o" + str.charAt(i);
			}
			else {
				rovarspraketWord += str.charAt(i);
			}
		}
		return(rovarspraketWord);
	}
}
