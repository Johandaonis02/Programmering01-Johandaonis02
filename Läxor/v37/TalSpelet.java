import java.util.Scanner;

public class TalSpelet {
	public static void main(String[] args) {
		int difficultyInt;
		
		Scanner input = new Scanner(System.in);
		System.out.println("Du �r en utforskare som f�rs�ker hitta en dyrbar skatt. Till din hj�lp har du ett visst antal uppt�cktsresande som kommer s�ga allt de hittar till dig om vad skattens koordinater �r.");
		System.out.println("Med denna informationen kommer det vara ditt jobb att hitta skatten. Fr�gan �r nu vilken skatt du vill f�rs�ka hitta.");	
		System.out.println();
		System.out.println("Om du vill vara med p� din kunsin Kalle Perssons skattjakt skriver du l�tt");
		System.out.println("Om du vill hitta de fantastiska juvelerna fr�n Atlantis skriver du mellan");
		System.out.println("Om du vill hitta Harald Bl�tands rikedomar skriver du sv�r");
		System.out.println("Om du vill hitta Mansa Moussa 2 ton 24 karat guld skriver du om�jlig");
		
		while(true) {	
			String difficultyString = input.nextLine();
			
			if (difficultyString.toUpperCase().equals("L�TT")) {
				System.out.println("P� skattjakten f�r du tre ledar per gissning.");
				difficultyInt = 0;
				break;
			}
			else if (difficultyString.toUpperCase().equals("MELLAN")) {
				System.out.println("I jakten p� juvelerna fr�n Atlantis f�r du en ledtr�d per gissning.");
				difficultyInt = 1;
				break;
			}
			else if (difficultyString.toUpperCase().equals("SV�R")) {
				System.out.println("Harald Bl�tand var en listig m�nniska och ville missleda de som letade efter hans rikedomar. D�rf�r f�r du en fel och tv� r�tta ledtr�dar varje g�ng du gissar.");
				difficultyInt = 2;
				break;
			}
			else if (difficultyString.toUpperCase().equals("OM�JLIG")) {
				System.out.println("Mansa Moussa var en f�rsiktig man. F�r varje gissning du g�r f�r du tv� r�tta och en fel ledtr�d.");
				difficultyInt = 3;
				break;
			}
			else {
				System.out.println(difficultyString + " �r inte giltig. Skriv l�tt, mellan, sv�r eller om�jlig.");
			}
		}
		
	}
}
