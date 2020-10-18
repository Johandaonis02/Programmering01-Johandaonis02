
public class ArrowNotation {
	public static void main(String[] args) {
//		System.out.println(multiplication2(3,6));
		System.out.println(ArrowNotationGeneral(3,3,4));
	}
	
	
	
	public static long ArrowNotationGeneral(long firstNumber, long secondNumber, long arrowNotationIndex) {
		long returnNumber = 1;
		for (int i = 0; i < secondNumber; i++) {
			if(arrowNotationIndex == 3) {
				//returnNumber = multiplication2(firstNumber, returnNumber);
				returnNumber = firstNumber * returnNumber;
			}
			else {
				returnNumber = ArrowNotationGeneral(firstNumber,returnNumber, arrowNotationIndex - 1) ;
			}
		}
		return returnNumber;
	}
	
	public static long multiplication2(long firstNumber, long secondNumber) {
		long returnNumber = 0;
		for (int i = 0; i < secondNumber; i++) {
			returnNumber = addition1(firstNumber,returnNumber);
		}
		return returnNumber;
	}
	
	public static long addition1(long firstNumber, long secondNumber) {
		long returnNumber = firstNumber;
		for (int i = 0; i < secondNumber; i++) {
			returnNumber++;
		}
		return returnNumber;
	}
}
