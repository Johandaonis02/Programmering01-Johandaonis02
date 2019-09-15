import java.util.Scanner;

public class L‰xa {
	
	public static void main(String[] args) {
		
		System.out.println("Vad heter du?");
		Scanner input = new Scanner(System.in);
		String stringNamn = input.nextLine();
		System.out.println("Hej " + stringNamn);
		System.out.println(stringNamn + " hur gammal ‰r du?");
		String string≈r = input.nextLine();
		System.out.println(stringNamn + " ge mig din adress?");
		String stringAdress = input.nextLine();
		System.out.println(stringNamn + " postnummer?");
		String stringPost = input.nextLine();
		System.out.println(stringNamn + " vilken stad bor du i?");
		String stringstad = input.nextLine();
		System.out.println(stringNamn + " vad ‰r ditt telefonnummer?");
		String stringTele = input.nextLine();
	}
}
