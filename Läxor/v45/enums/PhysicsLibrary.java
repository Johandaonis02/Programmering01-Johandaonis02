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
		return((fahrenheit - 32) / 1.8);
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
	
	//5
	/**
	 * Calculates the kinetic energy in the system with the kinetic formula.
	 * @param mass
	 * @param velocity
	 * @return The kinetic energy in the system.
	 */
	public static double kineticEnergy(double mass, double velocity) {
		return(mass * Math.pow(velocity, 2) / 2);
	}
	
	//6
	/**
	 * Calculates the potential energy in the system with the potential formula.
	 * @param mass
	 * @param height
	 * @param g
	 * @returnThe potential energy on an object.
	 */
	public static double potentialEnergy(double mass, double height, double g) {
		return(mass * height * g);
	}
	
	//7
	/**
	 * The speed of an object when colliding with the ground when dropped from a height.
	 * @param height
	 * @param g
	 * @return The speed of an object when dropped by a height.
	 */
	public static double fallSpeed(double height, double g) {
		return(Math.sqrt(2*height*g));
	}
	
	//8
	/**
	 * the different between last and first to calculate delta.
	 * @param first
	 * @param last
	 * @return the different (delta)
	 */
	public static double delta(double first, double last) {
		return(last - first);
	}
	
	//9
	/**
	 * Mass of a fluid that has a volume and a density as an input.
	 * @param fluid
	 * @param volume
	 * @return mass
	 */
	public static double volumeToMass(FluidTable fluid, double volume) {
		return(fluid.density * volume);
	}
	
	//10
	/**
	 * Mass of a gas that has a volume and a density as an input.
	 * @param gas
	 * @param volume
	 * @return mass
	 */
	public static double volumeToMass(GasTable gas, double volume) {
		return(gas.density * volume);
	}
}