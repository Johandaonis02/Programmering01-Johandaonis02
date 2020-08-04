import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.lang.*;

public class FindingPrimeNumbers2 {
	public static void main(String[] args) {
		 try {
			  File file = new File("Primes.txt");
		      
		  if (!file.exists()) {
			  file.createNewFile();
		  }
		  PrintWriter pw = new PrintWriter(file);
		  
		  
		  ArrayList<Integer> primes = new ArrayList<Integer>();
			primes.add(2);
			pw.println(2);
			for (int testNumber = 3; testNumber < 100; testNumber += 2) {
				boolean isPrime = true;
				for (int i = 1; i < primes.size(); i++) {
					if (testNumber % primes.get(i) == 0) {
						isPrime = false;
						break;
					}
				}
				if (isPrime) {
					primes.add(testNumber);
					pw.println(testNumber);
				}
			}
		  
		  pw.close();
		  System.out.println("done");
		  }
		  catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Error");
		  }
	}
}