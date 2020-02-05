import java.util.Scanner;

public class siffersumman {
	public static void main(String[] args) {
			
		Scanner input = new Scanner(System.in);
		
		int x = input.nextInt();
		int sum = 0;
		
		while(x > 0) {
			sum += x % 10;
			x /= 10;
		}
		System.out.println(sum);
		
//		for(int i = 0; i<10; i++) {
//			x = sum;
//			sum = 0;
//			
//			while(x > 0) {
//				sum += x % 10;
//				x /= 10;
//			}
//			System.out.println(sum);
//		}
	}	
}
