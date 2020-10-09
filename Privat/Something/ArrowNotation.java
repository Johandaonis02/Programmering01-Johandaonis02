
public class ArrowNotation {
	public static void main(String[] args) {
//		System.out.println(multiplication2(3,6));
		
		System.out.println(ArrowNotationGeneral(3,3,4));
	}
	
	public static int ArrowNotationGeneral(int firstNumber, int secondNumber, int arrowNotationIndex) {
		int returnNumber = 1;
		for (int i = 0; i < secondNumber; i++) {
			if(arrowNotationIndex == 3) {
				returnNumber = multiplication2(firstNumber, returnNumber);
			}
			else {
				returnNumber = ArrowNotationGeneral(firstNumber,returnNumber, arrowNotationIndex - 1) ;
			}
		}
		return returnNumber;
	}
	
//	public static int ArrowNotation4(int firstNumber, int secondNumber) {
//		int returnNumber = 1;
//		for (int i = 0; i < secondNumber; i++) {
//			returnNumber = ArrowNotation3(firstNumber,returnNumber) ;
//		}
//		return returnNumber;
//	}

//	public static int ArrowNotation3(int firstNumber, int secondNumber) {
//		int returnNumber = 1;
//		for (int i = 0; i < secondNumber; i++) {
//			returnNumber = multiplication2(firstNumber, returnNumber);
//		}
//		return returnNumber;
//	}
	
	public static int multiplication2(int firstNumber, int secondNumber) {
		int returnNumber = 0;
		for (int i = 0; i < secondNumber; i++) {
			returnNumber = addition1(firstNumber,returnNumber);
		}
		return returnNumber;
	}
	
	public static int addition1(int firstNumber, int secondNumber) {
		int returnNumber = firstNumber;
		for (int i = 0; i < secondNumber; i++) {
			returnNumber++;
		}
		return returnNumber;
	}
}
