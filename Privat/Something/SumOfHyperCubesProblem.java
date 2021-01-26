
public class SumOfHyperCubesProblem {
	public static void main(String[] args) {
		int m = 35;
		int n = 3;
		
		System.out.println(Math.pow(3, 35));
		
		long number = 0;
		
		for (int i = 1; i <= n; i++) {
			number += Math.pow(i, m);
		}
		
		if(number % (n*(n+1)/2) != 0) {
			System.out.println(n + " " + m);
		}
		
		if(n == 3 && m == 35) {
			System.out.println(number);
			System.out.println(number % 6);
			System.out.println(Long.MAX_VALUE);
		}
		
		
		
//		for (int n = 1; n < 100; n++) {
//			for (int m = 1; m < 100; m += 2) {
//				
//				long number = 0;
//				
//				for (int i = 1; i <= n; i++) {
//					number += Math.pow(i, m);
//				}
//				
//				if(number % (n*(n+1)/2) != 0) {
//					System.out.println(n + " " + m);
//				}
//				
//				if(n == 3 && m == 35) {
//					System.out.println(number);
//					System.out.println(number % 6);
//					System.out.println(Long.MAX_VALUE);
//				}
//				
//			}
//		}
	}
}
