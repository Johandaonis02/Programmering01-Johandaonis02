package enums;

public class PhysicsLibrary {
	
	static double g = 9.81;
	static double G = 6.674E-11;
	static double R = 8.3145;
	static double p_0 = 1013.25;
	static double c = 299792458;
	
	public static void main(String[] args) {
		//1
		System.out.println(volumeToMass(SolidTable.IRON,60) + " g");
		//2
		System.out.println(svtDistance(2.7, 50*60) + " m");
		//3 INTE KLAR
		//4
		System.out.println(pressureUnderWater(75) + " Pa");
		
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
	public static double fluidPressure(FluidTable fluid, double deep) {
		return(deep * g * fluid.density);
	}
	
	//made question 4 before question 3
	//4
	/**
	 * Calculates the pressure that water acts on a mass with the acceleration g and at a depth.
	 * @param deep
	 * @return pressure in pa
	 */
	public static double pressureUnderWater(double deep) {
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
	 * @returnThe potential energy on an object.
	 */
	public static double potentialEnergy(double mass, double height) {
		return(mass * height * g);
	}
	
	//7
	/**
	 * The speed of an object when colliding with the ground when dropped from a height.
	 * @param height
	 * @return The speed of an object when dropped by a height.
	 */
	public static double fallSpeed(double height) {
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
	
	//11
	/**
	 * Mass of a solid object that has a volume and a density as an input.
	 * @param solid
	 * @param volume
	 * @return mass
	 */
	public static double volumeToMass(SolidTable solid, double volume) {
		return(solid.density * volume);
	}
	
	//12
	/**
	 * The distance an object and the time it took to move to a place is given. Output is the velocity of the object.
	 * @param distance
	 * @param time
	 * @return velocity
	 */
	public static double svtVelocity(double distance, double time) {
		return(distance / time);
	}
	
	//13
	/**
	 * The velocity an object and the time it took to move to a place is given. Output is the distance of the object after the given time.
	 * @param velocity
	 * @param time
	 * @return distance
	 */
	public static double svtDistance(double velocity, double time) {
		return(velocity * time);
	}
	
	//14
	/**
	 * The time an object took to get to a distance with the given imputs: velocity and distance.
	 * @param The distance between a start and an end.
	 * @param The velocity of the object
	 * @return The time it took for the object to go to the end
	 */
	public static double svtTime(double distance, double velocity) {
		return(velocity / distance);
	}
	
	//15
	/**
	 * The work it took to move an object a fixed distance with a force.
	 * @param force
	 * @param distance
	 * @return work
	 */
	public static double work(double force, double distance) {
		return(force * distance);
	}
	
	//16
	/**
	 * The power needed to move an object a fixed time and a fixed work.
	 * @param work
	 * @param time
	 * @return
	 */
	public static double power(double work, double time) {
		return(work / time);
	}
	
//	//17 Inte klar
//	/**
//	 * 
//	 * @param solid
//	 * @param mass
//	 * @param deltaT
//	 * @return
//	 */
//	public static double heat(SolidTable solid, double mass, double deltaT) {
//		
//	}
	
	//20
	/**
	 * The maximum height of an object with the start position 0 meters and with a given velocity.
	 * @param velocity
	 * @return height
	 */
	public static double velocityToHeight(double velocity) {
		return(velocity * velocity / (2 * g));
	}
}