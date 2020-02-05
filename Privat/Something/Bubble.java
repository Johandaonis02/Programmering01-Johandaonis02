
public class Bubble {
	public static void main(String[] args) {
		
		int[] numbers = new int[100];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int)(Math.random() * 1000);
		}
		
		
		
		for (int a = numbers.length - 1; a > 0; a--) {
			for (int i = 0; i < a; i++) {
				if(numbers[i] > numbers[i+1]) {
					int previousNumber = numbers[i];
					numbers[i] = numbers[i+1];
					numbers[i+1] = previousNumber;
				}
			}
		}
		
		
		
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
	}
}
