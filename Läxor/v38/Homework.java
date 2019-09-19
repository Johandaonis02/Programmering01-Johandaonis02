import java.util.Scanner;

import javax.print.DocFlavor.INPUT_STREAM;

public class Homework {
	
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		System.out.println("Säg 10 tal");
		int y = 0;
		int Big = -2147000000;
		int Small = 2147000000;
		for(int i = 0; i<10; i++){
			
			int x = input.nextInt();
			y = x + y;
		}
		
		System.out.println((float)y/10);
	}
}
