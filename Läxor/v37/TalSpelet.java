import java.util.Scanner;

public class TalSpelet {
	public static void main(String[] args) {
		//difficultyInt 0 = lätt, 1 = mellan, 2 = svår and 3 = omöjlig. 
		int difficultyInt;
		int NumberOfGuesses;
		int treasurerPosition;
		Scanner input = new Scanner(System.in);
		
		//Text about the game.
		System.out.println("Du är en utforskare som försöker hitta en dyrbar skatt. Till din hjälp har du ett visst antal upptäcktsresande som kommer säga allt de hittar till dig om vad skattens koordinater är.");
		System.out.println("Med denna informationen kommer det vara ditt jobb att hitta skatten. Frågan är nu vilken skatt du vill försöka hitta.");	
		System.out.println();
		System.out.println("Om du vill vara med på din kunsin Kalle Perssons skattjakt skriver du lätt");
		System.out.println("Om du vill hitta de fantastiska juvelerna från Atlantis skriver du mellan");
		System.out.println("Om du vill hitta Harald Blåtands rikedomar skriver du svår");
		System.out.println("Om du vill hitta Mansa Moussa 2 ton 24 karat guld skriver du omöjlig");
		
		//Player selecting difficulty.
		while(true) {	
			String difficultyString = input.nextLine();
			
			if (difficultyString.toUpperCase().equals("LÄTT")) {
				System.out.println("På skattjakten får du tre ledar per gissning.");
				difficultyInt = 0;
				NumberOfGuesses = 5;
				treasurerPosition = (int)(Math.random() * 16);
				break;
			}
			else if (difficultyString.toUpperCase().equals("MELLAN")) {
				System.out.println("I jakten på juvelerna från Atlantis får du en ledtråd per gissning.");
				difficultyInt = 1;
				NumberOfGuesses = 7;
				treasurerPosition = (int)(Math.random() * 51);
				break;
			}
			else if (difficultyString.toUpperCase().equals("SVÅR")) {
				System.out.println("Harald Blåtand var en listig människa och ville missleda de som letade efter hans rikedomar. Därför får du en fel och två rätta ledtrådar varje gång du gissar.");
				difficultyInt = 2;
				NumberOfGuesses = 10;
				treasurerPosition = (int)(Math.random() * 201);
				break;
			}
			else if (difficultyString.toUpperCase().equals("OMÖJLIG")) {
				System.out.println("Mansa Moussa var en försiktig man. För varje gissning du gör får du två rätta och en fel ledtråd.");
				difficultyInt = 3;
				NumberOfGuesses = 10;
				treasurerPosition = (int)(Math.random() * 1001);
				break;
			}
			else {
				System.out.println(difficultyString + " är inte giltig. Skriv lätt, mellan, svår eller omöjlig.");
			}
		}
		
		//Text about where the treasure is located.
		System.out.print("Skatten ligger mellan talen ");
		if (difficultyInt == 0) {
			System.out.println("1 och 15");
			System.out.println();
			System.out.print("Din första steget för att hitta ");
			System.out.print("din kusins skatt ");
			System.out.print("är att skriva en vild gissning mellan talen ");
			System.out.println("1 och 15");
		}
		else if (difficultyInt == 1) {
			System.out.println("1 och 50");
			System.out.print("Din första steget för att hitta ");
			System.out.print("juvelerna från Atlantis ");
			System.out.print("är att skriva en vild gissning mellan talen ");
			System.out.println("1 och 50");
		}
		else if (difficultyInt == 2) {
			System.out.println("1 och 200");
			System.out.println();
			System.out.print("Din första steget för att hitta ");
			System.out.print("Harald Blåtands rikedomar ");
			System.out.print("är att skriva en vild gissning mellan talen ");
			System.out.println("1 och 200");
		}
		else {
			System.out.println("1 och 1000");
			System.out.println();
			System.out.print("Din första steget för att hitta ");
			System.out.println("Moussas guld ");
			System.out.print("är att skriva en vild gissning mellan talen ");
			System.out.println("1 och 1000");
		}
		
		//Player selecting first guess.
		while(true) {
			try {
				int playerGuess = input.nextInt();
				
				if(difficultyInt == 0) {
					if(1 <= playerGuess && playerGuess <= 15) { 
						break;
					}
					else {
						System.out.println("Gissningen måste vara mellan 1 och 15");
					}
				}
				else if(difficultyInt == 1) {
					if(1 <= playerGuess && playerGuess <= 50) { 
						break;
					}
					else {
						System.out.println("Gissningen måste vara mellan 1 och 50");
					}
				}
				else if(difficultyInt == 2) {
					if(1 <= playerGuess && playerGuess <= 200) { 
						break;
					}
					else {
						System.out.println("Gissningen måste vara mellan 1 och 200");
					}
				}
				else {
					if(1 <= playerGuess && playerGuess <= 1000) { 
						break;
					}
					else {
						System.out.println("Gissningen måste vara mellan 1 och 1000");
					}
				}
			}
			catch (Exception notAnInt) {
				System.out.println("Din gissning måste vara ett heltal. Du kan inte skriva " + input.nextLine());
			}
		}
	}
}
