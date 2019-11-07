
public class CollatzConjecture {
	public static void main(String[] args) {
		int steps;
		int record = 0;
		for(int i = 1; i <= 1000000000; i++) {
			steps = 0;
			long numberToTest = i;
			while (numberToTest != 1) {
				if(numberToTest % 2 == 0) {
					numberToTest = numberToTest / 2;
					steps += 1;
				}
				else {
					numberToTest = 3 * numberToTest + 1;
					steps += 1;
				}
			}
			if (steps > record) {
				System.out.println(i + "-" + steps);
				record = steps;
			}
		}
	}
}
