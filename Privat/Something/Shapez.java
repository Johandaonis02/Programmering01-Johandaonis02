import java.util.Scanner;

public class Shapez {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String shape1;
		String shape2;
		
		while(true) {
			System.out.println("Tell me the code for the left shape (It should look something like this: CrRg--Sb:----WySp:CpRpWpSp)");
			shape1 = input.nextLine();
			
			if(testIfStringIsOk(shape1)) {
				break;
			}
			
			System.out.println("Sorry, that code it incorrect");
		}
		
		while(true) {
			System.out.println("Tell me the code for the right shape (It should look something like this: CrRg--Sb:----WySp:CpRpWpSp)");
			shape2 = input.nextLine();
			
			if(testIfStringIsOk(shape2)) {
				break;
			}
			
			System.out.println("Sorry, that code it incorrect");
		}
		
		while(shape1.length() != 35) {
			shape1 = shape1 + ":--------";
		}
		
		while(shape2.length() != 35) {
			shape2 = shape2 + ":--------";
		}
		
		for (int layer1 = 0; layer1 <= 3; layer1++) {
			for (int layer2 = 0; layer2 <= 3; layer2++) {
				boolean replace = true;
				for (int corner = 0; corner <= 3; corner++) {
					if(!((shape1.charAt(2 * corner + 9 * layer1) == '-') || (shape2.charAt(2 * corner + 9 * layer2) == '-'))){
						replace = false;
						break;
					}
				}
				if(replace) {
					for (int corner = 0; corner <= 3; corner++) {
						if((shape1.charAt(2 * corner + 9 * layer1) != '-')) {
							shape2 = changeCharInPosition(2 * corner + 9 * layer2, shape1.charAt(2 * corner + 9 * layer1), shape2);
							shape2 = changeCharInPosition(2 * corner + 9 * layer2 + 1, shape1.charAt(2 * corner + 9 * layer1 + 1), shape2);
						}
					}
					break;
				}	
			}
		}
		
		System.out.println(shape2);
	}
	
	public static String changeCharInPosition(int position, char ch, String str){
	    char[] charArray = str.toCharArray();
	    charArray[position] = ch;
	    return new String(charArray);
	}
	
	public static boolean testIfStringIsOk(String shape) {
		boolean stringIsOk = false;
		
		if(shape.length() % 9 == 8 && shape.length() <= 35) {
			stringIsOk = true;
			for (int layer = 0; layer <= (shape.length() - 8) / 9 ; layer++) {
				for (int corner = 0; corner <= 3 ; corner++) {
					
					if(shape.charAt(2 * corner + 9 * layer) == '-' && shape.charAt(2 * corner + 9 * layer + 1) == '-') {
						break;
					}
					
					char cornerShape = shape.charAt(2 * corner + 9 * layer);
					if(!(cornerShape == 'C' || cornerShape == 'R' || cornerShape == 'W' || cornerShape == 'S')) {
						stringIsOk = false;
						layer = 1337;
						break;
					}
					
					char cornerColor = shape.charAt(2 * corner + 9 * layer + 1);
					if(!(cornerColor == 'r' || cornerColor == 'g' || cornerColor == 'b' || cornerColor == 'y' ||
					     cornerColor == 'p' || cornerColor == 'c' || cornerColor == 'u' || cornerColor == 'w')) {
						stringIsOk = false;
						layer = 1337;
						break;
					}	
				}
				
				if(layer != 0) {
					if(!(shape.charAt(9 * layer - 1) == ':')) {
						stringIsOk = false;
						layer = 1337;
						break;
					}
				}
			}
		}
		
		return(stringIsOk);
	}
}
