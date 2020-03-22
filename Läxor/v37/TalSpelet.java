import java.util.Scanner;

public class TalSpelet {
	public static void main(String[] args) {
		//difficultyInt 0 = lätt, 1 = mellan, 2 = svår and 3 = omöjlig. 
		int difficultyInt;
		int numberOfGuesses;
		int treasurerPosition;
		boolean playerHasLost = false;
		boolean playerHasWon = false;
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
				numberOfGuesses = 5;
				treasurerPosition = (int)(Math.random() * 16);
				break;
			}
			else if (difficultyString.toUpperCase().equals("MELLAN")) {
				System.out.println("I jakten på juvelerna från Atlantis får du en ledtråd per gissning.");
				difficultyInt = 1;
				numberOfGuesses = 7;
				treasurerPosition = (int)(Math.random() * 51);
				break;
			}
			else if (difficultyString.toUpperCase().equals("SVÅR")) {
				System.out.println("Harald Blåtand var en listig människa och ville missleda de som letade efter hans rikedomar. Därför får du en fel och två rätta ledtrådar varje gång du gissar.");
				difficultyInt = 2;
				numberOfGuesses = 10;
				treasurerPosition = (int)(Math.random() * 201);
				break;
			}
			else if (difficultyString.toUpperCase().equals("OMÖJLIG")) {
				System.out.println("Mansa Moussa var en försiktig man. För varje gissning du gör får du två rätta och en fel ledtråd.");
				difficultyInt = 3;
				numberOfGuesses = 10;
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
		int playerGuess = PlayerGuessing(difficultyInt);
		numberOfGuesses--;
		
		while(playerHasLost == false && playerHasWon == false){
			RandomClues(difficultyInt, playerGuess, treasurerPosition);
			System.out.println(numberOfGuesses);
			System.out.println(treasurerPosition);
			playerGuess = PlayerGuessing(difficultyInt);
			numberOfGuesses--;
			if(numberOfGuesses == 0) {
				playerHasLost = true;
			}
			if(playerGuess == treasurerPosition) {
				playerHasLost = false;
				playerHasWon = true;
			}
		}
	}
		
	public static void RandomClues(int difficultyInt, int playerGuess, int treasurerPosition) {
		int falseClue = -1;
		
		boolean oneFalse = false;
		int clues = 3;
		
		if(difficultyInt == 2 || difficultyInt == 3) {
			oneFalse = true;
		}
		
		if(difficultyInt == 1) {
			clues = 1; 
		}
		
		if(oneFalse) {
			falseClue = (int)(Math.random() * clues + 1);
		}
		
		for (int i = 0; i < clues; i++) {
			
			int selectClue = -1;
			
			if(difficultyInt == 0) {
				while(selectClue != 3 && selectClue != 4 && selectClue != 6 && selectClue != 8) {
					selectClue = (int)(Math.random() * 8 + 1);
				}
			}
			else if(difficultyInt == 1) {
				while(selectClue != 1 && selectClue != 2 && selectClue != 3 && selectClue != 4 && selectClue != 5 && selectClue != 6 && selectClue != 7) {
					selectClue = (int)(Math.random() * 8 + 1);
				}
			}
			else if(difficultyInt == 2) {
				while(selectClue != 1 && selectClue != 2 && selectClue != 4 && selectClue != 5 && selectClue != 6 && selectClue != 7) {
					selectClue = (int)(Math.random() * 8 + 1);
				}
			}
			else {
				while(selectClue != 4 && selectClue != 5 && selectClue != 6 && selectClue != 7) {
					selectClue = (int)(Math.random() * 8 + 1);
				}
			}
			
			if(selectClue == 1) {
				if(TestIfAIsAFactorOfB(treasurerPosition, playerGuess) && i != falseClue || !TestIfAIsAFactorOfB(treasurerPosition, playerGuess) && i == falseClue) {
					System.out.println("Talet du letar efter är en faktor av talet du gissa");
				}
				else {
					System.out.println("Talet du letar efter är INTE en faktor av talet du gissa");
				}
			}
			else{
				System.out.println("Jag är inte klar");
			}
		}
	}
	
	public static boolean TestIfAIsAFactorOfB(int a, int b) {
		if(((int)(b/a)) * a == b) {
			return true;
		}
		else {
			return false;
		}
	}

	public static int PlayerGuessing(int difficultyInt) {
		Scanner input = new Scanner(System.in);
		while(true) {
			try {
				int playerGuess = input.nextInt();
				
				if(difficultyInt == 0) {
					if(1 <= playerGuess && playerGuess <= 15) { 
						return playerGuess;
					}
					else {
						System.out.println("Gissningen måste vara mellan 1 och 15");
					}
				}
				else if(difficultyInt == 1) {
					if(1 <= playerGuess && playerGuess <= 50) { 
						return playerGuess;
					}
					else {
						System.out.println("Gissningen måste vara mellan 1 och 50");
					}
				}
				else if(difficultyInt == 2) {
					if(1 <= playerGuess && playerGuess <= 200) { 
						return playerGuess;
					}
					else {
						System.out.println("Gissningen måste vara mellan 1 och 200");
					}
				}
				else {
					if(1 <= playerGuess && playerGuess <= 1000) { 
						return playerGuess;
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
