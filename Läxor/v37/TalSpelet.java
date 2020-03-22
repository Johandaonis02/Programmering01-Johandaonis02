import java.util.Scanner;

public class TalSpelet {
	public static void main(String[] args) {
		//difficultyInt 0 = l�tt, 1 = mellan, 2 = sv�r and 3 = om�jlig. 
		int difficultyInt;
		int numberOfGuesses;
		int treasurerPosition;
		boolean playerHasLost = false;
		boolean playerHasWon = false;
		Scanner input = new Scanner(System.in);
		
		//Text about the game.
		System.out.println("Du �r en utforskare som f�rs�ker hitta en dyrbar skatt. Till din hj�lp har du ett visst antal uppt�cktsresande som kommer s�ga allt de hittar till dig om vad skattens koordinater �r.");
		System.out.println("Med denna informationen kommer det vara ditt jobb att hitta skatten. Fr�gan �r nu vilken skatt du vill f�rs�ka hitta.");	
		System.out.println();
		System.out.println("Om du vill vara med p� din kunsin Kalle Perssons skattjakt skriver du l�tt");
		System.out.println("Om du vill hitta de fantastiska juvelerna fr�n Atlantis skriver du mellan");
		System.out.println("Om du vill hitta Harald Bl�tands rikedomar skriver du sv�r");
		System.out.println("Om du vill hitta Mansa Moussa 2 ton 24 karat guld skriver du om�jlig");
		
		//Player selecting difficulty.
		while(true) {	
			String difficultyString = input.nextLine();
			
			if (difficultyString.toUpperCase().equals("L�TT")) {
				System.out.println("P� skattjakten f�r du tre ledar per gissning.");
				difficultyInt = 0;
				numberOfGuesses = 5;
				treasurerPosition = (int)(Math.random() * 16);
				break;
			}
			else if (difficultyString.toUpperCase().equals("MELLAN")) {
				System.out.println("I jakten p� juvelerna fr�n Atlantis f�r du en ledtr�d per gissning.");
				difficultyInt = 1;
				numberOfGuesses = 7;
				treasurerPosition = (int)(Math.random() * 51);
				break;
			}
			else if (difficultyString.toUpperCase().equals("SV�R")) {
				System.out.println("Harald Bl�tand var en listig m�nniska och ville missleda de som letade efter hans rikedomar. D�rf�r f�r du en fel och tv� r�tta ledtr�dar varje g�ng du gissar.");
				difficultyInt = 2;
				numberOfGuesses = 10;
				treasurerPosition = (int)(Math.random() * 201);
				break;
			}
			else if (difficultyString.toUpperCase().equals("OM�JLIG")) {
				System.out.println("Mansa Moussa var en f�rsiktig man. F�r varje gissning du g�r f�r du tv� r�tta och en fel ledtr�d.");
				difficultyInt = 3;
				numberOfGuesses = 10;
				treasurerPosition = (int)(Math.random() * 1001);
				break;
			}
			else {
				System.out.println(difficultyString + " �r inte giltig. Skriv l�tt, mellan, sv�r eller om�jlig.");
			}
		}
		
		//Text about where the treasure is located.
		System.out.print("Skatten ligger mellan talen ");
		if (difficultyInt == 0) {
			System.out.println("1 och 15");
			System.out.println();
			System.out.print("Din f�rsta steget f�r att hitta ");
			System.out.print("din kusins skatt ");
			System.out.print("�r att skriva en vild gissning mellan talen ");
			System.out.println("1 och 15");
		}
		else if (difficultyInt == 1) {
			System.out.println("1 och 50");
			System.out.print("Din f�rsta steget f�r att hitta ");
			System.out.print("juvelerna fr�n Atlantis ");
			System.out.print("�r att skriva en vild gissning mellan talen ");
			System.out.println("1 och 50");
		}
		else if (difficultyInt == 2) {
			System.out.println("1 och 200");
			System.out.println();
			System.out.print("Din f�rsta steget f�r att hitta ");
			System.out.print("Harald Bl�tands rikedomar ");
			System.out.print("�r att skriva en vild gissning mellan talen ");
			System.out.println("1 och 200");
		}
		else {
			System.out.println("1 och 1000");
			System.out.println();
			System.out.print("Din f�rsta steget f�r att hitta ");
			System.out.println("Moussas guld ");
			System.out.print("�r att skriva en vild gissning mellan talen ");
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
					System.out.println("Talet du letar efter �r en faktor av talet du gissa");
				}
				else {
					System.out.println("Talet du letar efter �r INTE en faktor av talet du gissa");
				}
			}
			else{
				System.out.println("Jag �r inte klar");
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
						System.out.println("Gissningen m�ste vara mellan 1 och 15");
					}
				}
				else if(difficultyInt == 1) {
					if(1 <= playerGuess && playerGuess <= 50) { 
						return playerGuess;
					}
					else {
						System.out.println("Gissningen m�ste vara mellan 1 och 50");
					}
				}
				else if(difficultyInt == 2) {
					if(1 <= playerGuess && playerGuess <= 200) { 
						return playerGuess;
					}
					else {
						System.out.println("Gissningen m�ste vara mellan 1 och 200");
					}
				}
				else {
					if(1 <= playerGuess && playerGuess <= 1000) { 
						return playerGuess;
					}
					else {
						System.out.println("Gissningen m�ste vara mellan 1 och 1000");
					}
				}
			}
			catch (Exception notAnInt) {
				System.out.println("Din gissning m�ste vara ett heltal. Du kan inte skriva " + input.nextLine());
			}
		}
	}
}
