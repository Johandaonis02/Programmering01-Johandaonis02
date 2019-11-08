package enums;

public class PhysicsLibrary {
	public static void main(String[] args) {
		
	}
	
	/**
	 * Takes a Fahrenheit and calculates the responding Celsius value
	 * @param Fahrenheit 
	 * @return Celsius
	 */
	public static double fahrenheitToCelsius(double fahrenheit) {
		return((fahrenheit - 30) / 1.8);
	}
	
	
	/**
	 * Takes a Kelvin and calculates the responding Celsius value
	 * @param Kelvin
	 * @return Celsius
	 */
	public static double elsiusToKelvin(double kelvin) {
		return(kelvin + 272.15);
	}
}