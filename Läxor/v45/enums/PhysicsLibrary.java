package enums;

public class PhysicsLibrary {
	public static void main(String[] args) {
		double g = 9.81;
	}
	
	//1
	/**
	 * Takes a Fahrenheit and calculates the responding Celsius value
	 * @param Fahrenheit 
	 * @return Celsius
	 */
	public static double fahrenheitToCelsius(double fahrenheit) {
		return((fahrenheit - 30) / 1.8);
	}
	
	//2
	/**
	 * Takes a Kelvin and calculates the responding Celsius value
	 * @param Kelvin
	 * @return Celsius
	 */
	public static double elsiusToKelvin(double kelvin) {
		return(kelvin + 272.15);
	}
	
	//made question 4 before question 3
	//4
	/**
	 * Calculates the pressure under water with the gravitation constant and depth under water
	 * @param deep
	 * @param g
	 * @return Pa
	 */
	public static double pressureUnderWater(double deep, double g) {
		return(deep * g * 1000);
	}
	
}