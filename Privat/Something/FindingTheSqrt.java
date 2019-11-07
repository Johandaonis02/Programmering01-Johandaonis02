import java.lang.Math;
import java.util.Scanner;

public class FindingTheSqrt {
	public static void main(String[] args) {
		System.out.println(sqrt());
		System.out.println(polynom());
	}
	
	public static double sqrt() { 
	double input = 1000000;
		double output = input;
	    for(int i = 0; i < 10; i++) {
	    	output = output - ((Math.pow(output, 2) - input)/(2 * output));
	    }
	    return(output);
	}
	
	public static double polynom() {
		//poly[n] = pn (p0 + p1x + p2x^2 + ... + pnx^n)
		double poly[] = {-3,0,1,0,0,0};
		double output = 1.7;
		double function = 0;
		double derivative = 0;
	    for(int i = 0; i < 1000000; i++) {
	    	for(int j = 0; j < poly.length; j++) {
	    		function += Math.pow(output, j) * poly[j];
	    		derivative += j * Math.pow(output, (j - 1)) * poly[j];
	    	}
	    	output -= (function/derivative);
	    }
	    return(output);
	}
}