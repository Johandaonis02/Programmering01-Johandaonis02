public class Prime_factor {
	
	public static void main(String[] args){

		long timeBefore = System.nanoTime();
		
		double a = 737;
			for(int i=2; a != 1; i++) {
				if(a % i == 0) {
					a = a/i;
					System.out.println(i);
					i = i-1;
				}
			}
			
		double timeElapsed =  System.nanoTime() - timeBefore;
		System.out.println(timeElapsed / 1000000.0 + " millisec");
	}
}

//import java.util.Scanner;
//
//public class Prime_factor {
//	
//	public static void main(String[] args){
//		
//		Scanner input = new Scanner(System.in);
//		
//		int b = 0;
//		long a = input.nextLong();
//		for(int i=2; a >= i; i++) {
//			if(a % i == 0) {
//				a = a/i;
//				b++;
//				System.out.println(i);
//			}
//		}
//		System.out.println(b);
//	}
//}

