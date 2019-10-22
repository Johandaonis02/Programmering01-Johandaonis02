import java.lang.Math;

public class Metoder {
	public static void main(String[] args) {
		double radius = 1;
		System.out.println(volume(radius));
		String str = "nahoJ";
		System.out.println(reverse(str));
		char c = 'a';
		System.out.println(count(str, c));
		
	}
	
	/**
	 * Calculating volume on a sphere with radius as input
	 * @param radius
	 * @return Volume
	 */
	public static double volume(double radius) {
		return(Math.PI * Math.pow(radius, 3.) * 4. / 3.);
	}
	
	/**
	 * Reversing strings
	 * @param str
	 * @return String backwards
	 */
	public static String reverse(String str) {
		String reverseStr = "";
		for(int i = str.length() - 1; i >= 0; i--) {
			reverseStr += str.charAt(i);
		}
		return(reverseStr);
	}
	
	/**
	 * Calculating how many characters there are in a string
	 * @param str
	 * @param c
	 * @return How many characters there are in the string.
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
}
