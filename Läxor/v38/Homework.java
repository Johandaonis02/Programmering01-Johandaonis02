import java.util.Scanner;

import javax.print.DocFlavor.INPUT_STREAM;

public class Homework {
	
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		System.out.println("Säg 10 tal");
		int y = 0; //Y håller bara summan av talen ett tag för att hitta genomsnittet.
		int B = -2147000000; //Sätter den nära -(2^31) så inte startvärdet blir det största värdet.
		int S = 2147000000; //Sätter den nära 2^31 så inte startvärdet blir det minsta värdet.
		for(int i = 0; i<10; i++){
			
			int x = input.nextInt();
			y = x + y;
			
			if(x > B){
				B = x;
			}
			else if(x < S){
				S = x;
			}
		}
		
		System.out.println("Genomsnitt: " + (float)y/10);
		System.out.println("Störst värdet: " + B);
		System.out.println("minsta värdet: " + S);
	}
}
