import java.util.*;
import java.lang.*;

public class FindingPrimeNumbers {
	public static void main(String[] args) {
//		ArrayList<Integer> primes = new ArrayList<Integer>();
//		primes.add(2);
//		System.out.println(2);
//		for (int testNumber = 3; testNumber < 10; testNumber += 2) {
//			boolean isPrime = true;
//			for (int i = 1; i < primes.size(); i++) {
//				if (testNumber % primes.get(i) == 0) {
//					isPrime = false;
//					break;
//				}
//			}
//			if (isPrime) {
//				primes.add(testNumber);
//				System.out.println(testNumber);
//			}
//		}
		
		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		System.out.println(1 + " " + 2);
		primes.add(3);
		System.out.println(2 + " " + 3);
		for (int testNumber = 6; testNumber < 10000000; testNumber += 6) {
			boolean isPrimeMinus = true;
			boolean isPrimePlus = true;
			for (int i = 2; i < primes.size(); i++) {
				if (isPrimeMinus && (testNumber - 1) % primes.get(i) == 0) {
					isPrimeMinus = false;
					if (!isPrimePlus) {
						break;
					}
				}
				if (isPrimePlus && (testNumber + 1) % primes.get(i) == 0) {
					isPrimePlus = false;
					if (!isPrimeMinus) {
						break;
					}
				}
			}
			if (isPrimeMinus) {
				primes.add(testNumber - 1);
				if (primes.size() % Math.pow(10, (int)Math.log10(primes.size())) == 0) {
					System.out.println(primes.size() + " " + (testNumber - 1));
				}
			}
			if (isPrimePlus) {
				primes.add(testNumber + 1);
				if (primes.size() % Math.pow(10, (int)Math.log10(primes.size())) == 0) {
					System.out.println(primes.size() + " " + (testNumber + 1));
				}
			}
		}
	}
}
