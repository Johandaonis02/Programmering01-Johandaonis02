import java.util.Scanner;

public class L�xa {
	
	public static void main(String[] args) {
		
		System.out.println("Vad heter du?");
		Scanner input = new Scanner(System.in);
		String string = input.nextLine();
		System.out.println("Hej " + string);
	}
}
