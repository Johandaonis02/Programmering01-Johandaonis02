
public class Apa {
	public static void main(String[] args) {
		
		int[] number = new int [10];
		
		number[0] = 9;
		
		for (int i = 1; i < number.length; i++) {
			number[i] = 0;
		}
		
		
		int[] number2 = new int [10];
		
		for (int i = 0; i < number2.length; i++) {
			number2[i] = 0;
		}
		
		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < number2.length; i++) {
				number2[i] = 0;
			}
			
			for (int i = 0; i < number.length; i++) {
				System.out.print(number[i] + " ");
				number2[number[i]]++;
			}
			
			System.out.println();
			
			for (int i = 0; i < number.length; i++) {
				number[i] = 0;
			}
			
			for (int i = 0; i < number2.length; i++) {
				System.out.print(number2[i] + " ");
				number[number2[i]]++;
			}
			
			System.out.println();
		}
	}
}
