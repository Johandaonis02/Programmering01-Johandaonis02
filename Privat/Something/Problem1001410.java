
public class Problem1001410 {
	static int base = 5;
	
	public static void main(String[] args) {
		int stepRecord = 0;
		for (int i = 1; i < 2000000000; i++) {
			
//			if(i % 1000000 == 0) {
//				System.out.println(i);
//			}
			
			boolean loop = false;
			int step = 0;
			int[] numberInSequence = new int[6];
			numberInSequence[0] = i;
			int newNumber = i;
			while(!loop) {
				
				step++;
				newNumber = numberOfDigits(newNumber) * digitSum(newNumber) * 2;
				loop = numberInArray(numberInSequence,newNumber);
				numberInSequence[step] = newNumber;
				if(loop) {
					if(step > stepRecord) {
						stepRecord = step;
						System.out.println(step + " new record " + i);
					}
				}
				
			}
			
			for (int j = 0; j < numberInSequence.length; j++) {
				numberInSequence[j] = 0;
			}
		}
		System.out.println("Done");
	
//		int a = 89;
//		System.out.println((Math.floor(java.lang.Math.log10(a)) + 1) * digitSum(a) * 2);
	}
	
	public static boolean numberInArray(int[] array, int number) {
		
		
		for (int i = 0; i < array.length; i++) {
			if(array[i] == number) {
				return true;
			}
		}
		return false;
	}
	
	public static int numberOfDigits(int a) {
		int returnNumber = 0;
		while(a != 0) {
			a -= a % base;
			a /= base;
			returnNumber++;
		}
		return returnNumber;
	}
	
	public static int digitSum(int a){
		int returnNumber = 0;
		while(a != 0) {
			returnNumber += a % base;
			a /= base;
		}
		return returnNumber;
	}
}
