import java.lang.Math;

public class Metoder {
	public static void main(String[] args) {
		double radius = 1;
		System.out.println(volume(radius));
		
		
	}
	
	public static double volume(double radius) {
		return(Math.PI * Math.pow(radius, 3.) * 4. / 3.);
	}
}
