package enums;

public class PhysicsLibrary {
	public static void main(String[] args) {
		double g = 9.81;
	}
	
	//1
	/**
	 * Takes a Fahrenheit and calculates the responding Celsius value.
	 * @param Fahrenheit 
	 * @return Celsius
	 */
	public static double fahrenheitToCelsius(double fahrenheit) {
		return((fahrenheit - 30) / 1.8);
	}
	
	//2
	/**
	 * Takes a Kelvin and calculates the responding Celsius value.
	 * @param Kelvin
	 * @return Celsius
	 */
	public static double elsiusToKelvin(double kelvin) {
		return(kelvin + 272.15);
	}
	
	//3
	/**
	 * Calculates the pressure that the fluid acts on a mass with the acceleration g and at a depth.
	 * @param fluid
	 * @param deep
	 * @return pressure in pa
	 */
	public static double fluidPressure(FluidTable fluid, double deep, double g) {
		return(deep * g * fluid.density);
	}
	
	//made question 4 before question 3
	//4
	/**
	 * Calculates the pressure that water acts on a mass with the acceleration g and at a depth.
	 * @param deep
	 * @param g
	 * @return pressure in pa
	 */
	public static double pressureUnderWater(double deep, double g) {
		return(deep * g * 1000);
	}
	
	
}