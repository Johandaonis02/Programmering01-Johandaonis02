
public class Problem1001410V2 {
	static int base = 10;
	
	public static void main(String[] args) {
		int stepRecord = 0;
		for (long i = 1L; i < Long.MAX_VALUE; i++) {
			
//			if(i % 1000000 == 0) {
//				System.out.println(i);
//			}
			
			boolean loop = false;
			int step = 0;
			long[] numberInSequence = new long[100];
			numberInSequence[0] = i;
			long newNumber = i;
			while(!loop) {
				
				step++;
				newNumber = numberOfDigits(newNumber) * digitSum(newNumber) * 2L;
				loop = numberInArray(numberInSequence,newNumber);
				numberInSequence[step] = newNumber;
				if(loop) {
					if(newNumber != 24 && newNumber != 36 && newNumber != 48 && newNumber != 12 && newNumber != 16 && newNumber != 28 && newNumber != 40) {
						System.out.println(newNumber);
					}
					if(step > stepRecord) {
						stepRecord = step;
						System.out.println(step + " new record " + i);
					}
				}
				
			}
			
			for (int j = 0; j < numberInSequence.length; j++) {
				numberInSequence[j] = 0L;
			}
		}
		System.out.println("Done");
	

	}
	
	public static boolean numberInArray(long[] array, long number) {
		
		
		for (int i = 0; i < array.length; i++) {
			if(array[i] == number) {
				return true;
			}
		}
		return false;
	}
	
	public static int numberOfDigits(long a) {
		int returnNumber = 0;
		while(a != 0) {
			a -= a % base;
			a /= base;
			returnNumber++;
		}
		return returnNumber;
	}
	
	public static int digitSum(long a){
		int returnNumber = 0;
		while(a != 0) {
			returnNumber += a % base;
			a /= base;
		}
		return returnNumber;
	}
}
