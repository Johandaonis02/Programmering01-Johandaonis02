import java.lang.Math;

public class Metoder {
	public static void main(String[] args) {
		double radius = 1;
		System.out.println(volume(radius));
		String str = "nahoJ";
		System.out.println(reverse(str));
		
		
	}
	
	public static double volume(double radius) {
		return(Math.PI * Math.pow(radius, 3.) * 4. / 3.);
	}
	
	public static String reverse(String str) {
		String reverseStr = "";
		for(int i = str.length() - 1; i >= 0; i--) {
			reverseStr += str.charAt(i);
		}
		return(reverseStr);
	}
}
