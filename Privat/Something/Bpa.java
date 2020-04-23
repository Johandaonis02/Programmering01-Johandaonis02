
public class Bpa {
	public static void main(String[] args) {
		int n0 = 0;
		int n1 = 0;
		int n2 = 0;
		int n3 = 0;
		int n4 = 0;
		int n5 = 0;
		int n6 = 0;
		int n7 = 0;
		int n8 = 0;
		int n9 = 0;
		
		for (int i = 0; i < 1000000000; i++) {
			int number = i;
			int number2 = 0;
			while(number > 10) {
				number2 += number % 10;
				number -= number % 10;
				number /= 10;
				number = number2;
			}
			if (number == 0) {
				n0++;
			}
			else if (number == 1) {
				n1++;
			}
			else if (number == 2) {
				n2++;
			}
			else if (number == 3) {
				n3++;
			}
			else if (number == 4) {
				n4++;
			}
			else if (number == 5) {
				n5++;
			}
			else if (number == 6) {
				n6++;
			}
			else if (number == 7) {
				n7++;
			}
			else if (number == 8) {
				n8++;
			}
			else {
				n9++;
			}
		}
		System.out.println("0: " + n0);
		System.out.println("1: " + n1);
		System.out.println("2: " + n2);
		System.out.println("3: " + n3);
		System.out.println("4: " + n4);
		System.out.println("5: " + n5);
		System.out.println("6: " + n6);
		System.out.println("7: " + n7);
		System.out.println("8: " + n8);
		System.out.println("9: " + n9);
	}
}
