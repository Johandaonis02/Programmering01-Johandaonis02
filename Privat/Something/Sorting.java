
public class Sorting {
	public static void main(String[] args) {
//		int[] numbers = {5, 1, 2, 4, 9, 6};
		int[] numbers = new int[64];
		int[] numbersTwo = new int[64];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int)(Math.random() * 1000);
		}
		
		
//      Bubble sort
		
		boolean done = false;
		while(!done) {
			done = true;
			for(int c = 0; c < numbers.length - 1; c++) {
				if(numbers[c] > numbers[c+1]) {
					int previousNumber = numbers[c];
					numbers[c] = numbers[c+1];
					numbers[c+1] = previousNumber;
					done = false;
				}
			}
		}
		
//		for (int b = numbers.length - 1; b > 0; b--){
//			for(int c = 0; c < b; c++) {
//				if(numbers[c] > numbers[c+1]) {
//					int previousNumber = numbers[c];
//					numbers[c] = numbers[c+1];
//					numbers[c+1] = previousNumber;
//				}
//			}
//		}
		
		
		
//		Insertion sort
		
//		for(int c = 1; c < numbers.length; c++) {
//			for (int i = c; i > 0 ; i--) {
//				if(numbers[i - 1] > numbers[i]) {
//					int previousNumber = numbers[i - 1];
//					numbers[i - 1] = numbers[i];
//					numbers[i] = previousNumber;
//					
//					for (int i = 0; i < numbers.length; i++) {
//						System.out.print(numbers[i] + " ");
//					}
//				}
//				else {
//					break;
//				}
//			}
//		}
		
//		Merge sort
		
//		int numberOne;
//		int numberTwo;
//		int a;
//		
//		
//		for (int i = 0; i <= numbers.length - 2; i += 2) {
//			if(numbers[i + 1] < numbers[i]) {
//				int previousNumber = numbers[i];
//				numbers[i] = numbers[i + 1];
//				numbers[i + 1] = numbers[i];
//			}
//		}
//		
//		for (int i = 0; i <= numbers.length - 4; i += 4) {
//			numberOne = 0;
//			numberTwo = 2;
//			a = i;
//			while(a < i + 4) {
//				if(numberOne < numberTwo) {
//					numbersTwo[a] = numbers[numberOne + i];
//					numberOne++;
//					a++;
//				}
//				else {
//					numbersTwo[a] = numbers[numberTwo + i];
//					numberTwo++;
//					a++;
//				}
//			}
//		}
		
		
		
		for (int i : numbers) {
			System.out.print(i + " ");
		}
		
		System.out.println("");
		
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
	}
}
