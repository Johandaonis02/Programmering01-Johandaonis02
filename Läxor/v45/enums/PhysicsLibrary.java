package enums;

public class PhysicsLibrary {
	
	static double g = 9.81;
	static double G = 6.674E-11;
	static double R = 8.3145;
	static double p_0 = 1013.25;
	static double c = 299792458;
	
	public static void main(String[] args) {
		//1
		System.out.println(volumeToMass(SolidTable.IRON,60)/1000 + " kg");
		//2
		System.out.println(svtDistance(2.7, 50*60) + " m");
		//3
		System.out.println(heat(FluidTable.WATER, 4, 100 - 22) + " j");
		//4
		System.out.println(pressureUnderWater(75) + " Pa");
		//5
		System.out.println(1.8 + velocityToHeight(60 / 3.6) + " m");
		//6 INTE KLAR
		//7
		// 0.99 ^ x * g * 12 * 1 = g * 0.5 * 1 (=)  0.99 ^ x = 0.5 / 12
		System.out.println((int)(Math.log10(potentialEnergy(1,0.5) / potentialEnergy(1,12)) / Math.log10(0.99)) + " times");
	}
	
	//1
	/**
	 * Takes a Fahrenheit and calculates the responding Celsius value.
	 * @param Fahrenheit input in fahrenheit
	 * @return Celsius output in celsius
	 */
	public static double fahrenheitToCelsius(double fahrenheit) {
		return((fahrenheit - 32) / 1.8);
	}
	
	//2
	/**
	 * Takes a Kelvin and calculates the responding Celsius value.
	 * @param Kelvin input in kelvin
	 * @return Celsius output in celsius
	 */
	public static double elsiusToKelvin(double kelvin) {
		return(kelvin - 272.15);
	}
	
	//3
	/**
	 * Calculates the pressure that the fluid acts on a mass with the acceleration g and at a depth.
	 * @param fluid what kind of fluid is it
	 * @param deep how deep you are calculating the pressure
	 * @return pressure in pa
	 */
	public static double fluidPressure(FluidTable fluid, double deep) {
		return(deep * g * fluid.density);
	}
	
	//made question 4 before question 3
	//4
	/**
	 * Calculates the pressure that water acts on a mass with the acceleration g and at a depth.
	 * @param deep how deep you are calculating the pressure
	 * @return pressure in pa
	 */
	public static double pressureUnderWater(double deep) {
		return(deep * g * 1000);
	}
	
	//5
	/**
	 * Calculates the kinetic energy in the system with the kinetic formula.
	 * @param mass of an object
	 * @param velocity of an object
	 * @return The kinetic energy in the system.
	 */
	public static double kineticEnergy(double mass, double velocity) {
		return(mass * Math.pow(velocity, 2) / 2);
	}
	
	//6
	/**
	 * Calculates the potential energy in the system with the potential formula.
	 * @param mass of an object
	 * @param height above the ground
	 * @returnThe potential energy on an object.
	 */
	public static double potentialEnergy(double mass, double height) {
		return(mass * height * g);
	}
	
	//7
	/**
	 * The speed of an object when colliding with the ground when dropped from a height.
	 * @param height above the ground
	 * @return The speed of an object when dropped by a height.
	 */
	public static double fallSpeed(double height) {
		return(Math.sqrt(2*height*g));
	}
	
	//8
	/**
	 * the different between last and first to calculate delta.
	 * @param first is the first value
	 * @param last is the second value
	 * @return the different (delta)
	 */
	public static double delta(double first, double last) {
		return(last - first);
	}
	
	//9
	/**
	 * Mass of a fluid that has a volume and a density as an input.
	 * @param fluid what kind of fluid is it?
	 * @param volume volume of the fluid
	 * @return mass mass of the fluid
	 */
	public static double volumeToMass(FluidTable fluid, double volume) {
		return(fluid.density * volume);
	}
	
	//10
	/**
	 * Mass of a gas that has a volume and a density as an input.
	 * @param gas what kind of gas is it?
	 * @param volume volume of the gas
	 * @return mass mass of the gas
	 */
	public static double volumeToMass(GasTable gas, double volume) {
		return(gas.density * volume);
	}
	
	//11
	/**
	 * Mass of a solid object that has a volume and a density as an input.
	 * @param solid what kind of solid is it?
	 * @param volume volume of the solid
	 * @return mass mass of the solid
	 */
	public static double volumeToMass(SolidTable solid, double volume) {
		return(solid.density * volume);
	}
	
	//12
	/**
	 * The distance an object and the time it took to move to a place is given. Output is the velocity of the object.
	 * @param distance between start and end
	 * @param time it took for the object to get to the end
	 * @return velocity of the object
	 */
	public static double svtVelocity(double distance, double time) {
		return(distance / time);
	}
	
	//13
	/**
	 * The velocity an object and the time it took to move to a place is given. Output is the distance of the object after the given time.
	 * @param velocity of the object
	 * @param time it took for the object to get to the end
	 * @return distance between start and end
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
	 * @param force it took to move an object
	 * @param distance you moved the object
	 * @return the work it took
	 */
	public static double work(double force, double distance) {
		return(force * distance);
	}
	
	//16
	/**
	 * The power needed to move an object a fixed time and a fixed work.
	 * @param the work it took
	 * @param the time it took
	 * @return the power spent
	 */
	public static double power(double work, double time) {
		return(work / time);
	}
	
	//17
	/**
	 * Calculates the required energy to heat a material using the mass of the material, heat capacity and difference in temperature.
	 * @param the solid material the object is made of
	 * @param mass of the material
	 * @param deltaT difference between the temperatures
	 * @return the needed energy
	 */
	public static double heat(SolidTable solid, double mass, double deltaT) {
    return(solid.heatCapacity * mass * deltaT);
	}
	
	//18
	/**
	 * Calculates the required energy to heat a fluid using the mass of the fluid, heat capacity and difference in temperature.
	 * @param the fluid the object is made of
	 * @param mass of the fluid
	 * @param deltaT difference between the temperatures
	 * @return the needed energy
	 */
	public static double heat(FluidTable fluid, double mass, double deltaT) {
    return(fluid.heatCapacity * mass * deltaT);
	}
	
	//19
	/**
	 * Calculates the required energy to heat a gas using the mass of the gas, heat capacity and difference in temperature.
	 * @param the gas the object is made of
	 * @param mass of the fluid
	 * @param deltaT difference between the temperatures
	 * @return the needed energy
	 */
	public static double heat(GasTable gas, double mass, double deltaT) {
    return(gas.heatCapacity * mass * deltaT);
	}
	
	//20
	/**
	 * The maximum height of an object with the start position 0 meters and with a given velocity.
	 * @param velocity of the object at time = 0
	 * @return height it will get up to
	 */
	public static double velocityToHeight(double velocity) {
		return(velocity * velocity / (2 * g));
	}
	
	//1
	/**
	 * Calculates the number of meters in a number of feet.
	 * @param number of feet
	 * @return number of meters
	 */
	public static double feetToMeters(double foot) {
		return(foot / 3.28);
	}
	
	//2
	/**
	 * Calculates the distance an object moved when you have the acceleration, start speed and time.
	 * @param the acceleration the object had.
	 * @param the speed the object started with
	 * @param time it took to go to the end of the line
	 * @return the distance between start and end
	 */
	public static double distance(double acceleration, double startSpeed, double time) {
		return(startSpeed * time + time * time * acceleration / 2);
	}
	
	//3
	/**
	 * Calculates how many cubic centimeters there are in a fixed number of liters
	 * @param number of liters
	 * @return number of cubic centimeters
	 */
	public static double litersToCubeCentimeters(double liter) {
		return(liter * 1000);
	}
	
	//4
	/**
	 * Calculates the weight of an object after a fixed time.
	 * @param kilo of the object
	 * @param halveringstid of the material the object is made of
	 * @param The time you waited for the object to break down
	 * @return the resulting kg amount of an object after a while
	 */
	public static double kiloAfterTime(double kilo, double halveringstid, double time) {
		return(kilo / (Math.pow(2, time / halveringstid)));
	}
	
	//5
	/**
     * Calculates the energy needed to lift an object with a fixed mass to a certain height.
     * @param mass The mass of the object
     * @param height The height that the object will be lifted to
     * @return Returns the energy required
     */
    public static double energyNeeded(double mass, double height) {
        return(mass * g * height);
    }
    
    //6
    /**
     * Calculates on of the x values to x^2 + p*x + q = 0.
     * @param p the confession of the x^1 term in a quadratic equation
     * @param q the confession of the x^0 term in a quadratic equation
     * @return the highest x value to make the equation true
     */
    public static double pqFormula(double p, double q) {
        return(- p/2 + Math.sqrt((p/2) * (p/2) - q));
    }
    
    //7
    /**
     * Calculates the time it took for an object to move a fixed distance with a start speed and a fixed acceleration.
     * @param the acceleration of the object
     * @param the speed at time = 0
     * @param the distance the object should move
     * @return the time it took for the object to move
     */
    public static double accelerationAndSpeedToTime(double acceleration, double startSpeed, double distance) {
        //(acceleration / 2) * time^2 + startSpeed * time - distance = 0
    	return(pqFormula(2 * startSpeed / acceleration,- 2 * distance / acceleration));
    }
    
    //8
    /**
     * Calculates how many cube meters there are in a number of cube feet.
     * @param number of cube feet
     * @return number of cube meters
     */
    public static double cubeFeetToCubeMeters(double cubeFoot) {      
    	return(Math.pow(feetToMeters(Math.pow(cubeFoot, 1/3)), 3));
    }
    
    //9
    /**
     * Calculates how many cube feet there are in a number of cube meters.
     * @param number of cube meters
     * @return number of cube feet
     */
    public static double cubeMetersToCubeFeet(double cubeMeter) {      
    	return(Math.pow(Math.pow(cubeMeter, 1/3) * 3.28, 3));
    }
    
    //10
    /**
     * Calculates the pressure acted on an object.
     * @param the area of the object
     * @param the force acting
     * @return the pressure
     */
    public static double pressure(double area, double force) {      
    	return(force / area);
    }
}