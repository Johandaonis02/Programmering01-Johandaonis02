
public class BankCardProblem {
	public static void main(String[] args) {
		for (int i = 0; i < 10000; i++) {
			int numberOfNumbersWithOneDigInCom = 0;
			if(numbersInCommon(i,5726) == 1) {
				numberOfNumbersWithOneDigInCom++;
			}
			if(numbersInCommon(i,7358) == 1) {
				numberOfNumbersWithOneDigInCom++;
			}
			if(numbersInCommon(i,1191) == 1) {
				numberOfNumbersWithOneDigInCom++;
			}
			if(numbersInCommon(i,7628) == 1) {
				numberOfNumbersWithOneDigInCom++;
			}
			if(numbersInCommon(i,4882) == 1) {
				numberOfNumbersWithOneDigInCom++;
			}
			if(numbersInCommon(i,9307) == 1) {
				numberOfNumbersWithOneDigInCom++;
			}
			
			if(numberOfNumbersWithOneDigInCom == 6) {
				System.out.println(i);
			}
		}
	}
	public static int numbersInCommon(int num1, int num2) {
		int nic = 0;
		while(num1 != 0 || num2 != 0) {
			if(num1 % 10 == num2 % 10) {
				nic++;
			}
			num1 -= num1 % 10;
			num2 -= num2 % 10;
			num1 /= 10;
			num2 /= 10;
		}
		return nic;
	}
}
