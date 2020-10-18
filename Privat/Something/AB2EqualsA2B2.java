
public class AB2EqualsA2B2 {
	public static void main(String[] args) {
		for (long a = 1; a < 10000; a++) {
			for (long b = 1; b < 10000; b++) {
//				if(combineTwoNumbers(a*a,b*b) < combineTwoNumbers(a,b) * combineTwoNumbers(a,b)) {
//					System.out.println(a + " " + b);
//				}
				
				if(combineTwoNumbers(a*a,b*b) == combineTwoNumbers(a,b) * combineTwoNumbers(a,b)) {
					System.out.println(a + " " + b);
				}
			}
		}
	}
	
	public static long combineTwoNumbers(long numberOne, long numberTwo) {
		long powOfTen = 0;
		long returnNumber = 0;
		
		while(numberTwo != 0) {
			returnNumber += (numberTwo % 10) * Math.pow(10, powOfTen);
			numberTwo -= numberTwo % 10;
			numberTwo /= 10;
			powOfTen++;
		}
		while(numberOne != 0) {
			returnNumber += (numberOne % 10) * Math.pow(10, powOfTen);
			numberOne -= numberOne % 10;
			numberOne /= 10;
			powOfTen++;
		}
		
		return returnNumber;
	}
}
