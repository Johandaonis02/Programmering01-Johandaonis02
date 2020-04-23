
public class EightDigitProblem {
	public static void main(String[] args) {
		for (int power = 1; power < 100; power++) {
			for (int i = (int)Math.pow(10, power-1); i < Math.pow(10, power); i++) {
				int number = i;
				int sum = 0;
				while(number != 0){
					sum += Math.pow(number % 10, power);
					number -= number % 10;
					number /= 10;
				}
				if(sum == i) {
					System.out.println(power + ": " + i);
				}
			}
			System.out.println("klar med " + power);
		}
	}
}
