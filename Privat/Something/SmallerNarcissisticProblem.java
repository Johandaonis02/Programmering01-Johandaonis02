
public class SmallerNarcissisticProblem {
	public static void main(String[] args) {
		int x = 5;
		int maxNumber = 54748;
		
		for (int i = 0; i < maxNumber; i++) {
			int number = i;
			int sum = 0;
			
			while(number != 0) {
				sum += Math.pow(number % 10, x);
				number -= number % 10;
				number /= 10;
			}
			
			
			if(sum == i) {
				System.out.println(i);
			}
		}
	}
}
