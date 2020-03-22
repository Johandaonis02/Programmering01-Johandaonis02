import java.util.Scanner;

public class TalSpelet {
	public static void main(String[] args) {
		int difficultyInt;
		
		Scanner input = new Scanner(System.in);
		System.out.println("Du är en utforskare som försöker hitta en dyrbar skatt. Till din hjälp har du ett visst antal upptäcktsresande som kommer säga allt de hittar till dig om vad skattens koordinater är.");
		System.out.println("Med denna informationen kommer det vara ditt jobb att hitta skatten. Frågan är nu vilken skatt du vill försöka hitta.");	
		System.out.println();
		System.out.println("Om du vill vara med på din kunsin Kalle Perssons skattjakt skriver du lätt");
		System.out.println("Om du vill hitta de fantastiska juvelerna från Atlantis skriver du mellan");
		System.out.println("Om du vill hitta Harald Blåtands rikedomar skriver du svår");
		System.out.println("Om du vill hitta Mansa Moussa 2 ton 24 karat guld skriver du omöjlig");
		
		while(true) {	
			String difficultyString = input.nextLine();
			
			if (difficultyString.toUpperCase().equals("LÄTT")) {
				System.out.println("På skattjakten får du tre ledar per gissning.");
				difficultyInt = 0;
				break;
			}
			else if (difficultyString.toUpperCase().equals("MELLAN")) {
				System.out.println("I jakten på juvelerna från Atlantis får du en ledtråd per gissning.");
				difficultyInt = 1;
				break;
			}
			else if (difficultyString.toUpperCase().equals("SVÅR")) {
				System.out.println("Harald Blåtand var en listig människa och ville missleda de som letade efter hans rikedomar. Därför får du en fel och två rätta ledtrådar varje gång du gissar.");
				difficultyInt = 2;
				break;
			}
			else if (difficultyString.toUpperCase().equals("OMÖJLIG")) {
				System.out.println("Mansa Moussa var en försiktig man. För varje gissning du gör får du två rätta och en fel ledtråd.");
				difficultyInt = 3;
				break;
			}
			else {
				System.out.println(difficultyString + " är inte giltig. Skriv lätt, mellan, svår eller omöjlig.");
			}
		}
		
	}
}
