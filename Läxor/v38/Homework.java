import java.util.Scanner;

import javax.print.DocFlavor.INPUT_STREAM;

public class Homework {
	
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		System.out.println("S�g 10 tal");
		int y = 0; //Y h�ller bara summan av talen ett tag f�r att hitta genomsnittet.
		int B = -2147000000; //S�tter den n�ra -(2^31) s� inte startv�rdet blir det st�rsta v�rdet.
		int S = 2147000000; //S�tter den n�ra 2^31 s� inte startv�rdet blir det minsta v�rdet.
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
		System.out.println("St�rst v�rdet: " + B);
		System.out.println("minsta v�rdet: " + S);
	}
}
