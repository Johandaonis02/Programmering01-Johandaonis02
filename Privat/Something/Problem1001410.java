
public class Problem1001410 {
	public static void main(String[] args) {
		
		
		int stepRecord = 1;
		for (int i = 1; i < 1000000000; i++) {
			boolean loop = false;
			int step = 0;
			int[] numberInSequence = new int[20];
			numberInSequence[0] = i;
			int newNumber = i;
			while(!loop) {
				if(step >= 10) {
					stepRecord = step;
					System.out.println(step + 1 + " new re " + i);
				}
				step++;
				newNumber = ((int)java.lang.Math.log10((double)newNumber) + 1) * digitSum(newNumber) * 2;
				loop = numberInArray(numberInSequence,newNumber);
				numberInSequence[step] = newNumber;
				
				
			}
			
			for (int j = 0; j < numberInSequence.length; j++) {
				numberInSequence[j] = 0;
			}
		}
		System.out.println("klar");
	
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
	
	public static int digitSum(int a){
		int returnNumber = 0;
		while(a != 0) {
			returnNumber += a % 10;
			a /= 10;
		}
		return returnNumber;
	}
}
