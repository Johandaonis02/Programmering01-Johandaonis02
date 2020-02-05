import java.util.Scanner;
 //INTE KLAR
public class Wdtfs {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int numberOfIterations = input.nextInt();
		while(numberOfIterations != 0) {
			if(input.nextLine() == "what does the fox say?") {
				System.out.println("wa pa pa pa pa pa pow");
				numberOfIterations--;
			}	
		}
	}
}
