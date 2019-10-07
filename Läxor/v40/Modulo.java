import java.util.Scanner;

public class Modulo {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int c = 0;
		int a = 1;
		for(int i = 0; i<10; i++) {
			int b = input.nextInt();
			if((b%42)%a==0) {
				c++;
				a=a*(b%42);
			}
		}
		System.out.println(c);
	}	
}
