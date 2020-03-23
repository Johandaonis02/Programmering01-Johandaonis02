import java.util.Scanner;

public class TalSpelet {
	public static void main(String[] args) {
		//difficultyInt 0 = l�tt, 1 = medel, 2 = sv�rt and 3 = om�jligt. 
		int difficultyInt;
		int numberOfGuesses;
		int treasurePosition;
		
		Scanner input = new Scanner(System.in);
		
		//The while loop is there to restart the same if needed
		while(playerIsPlaying) {
			boolean playerIsPlaying = true;
			boolean playerHasLost = false;
			boolean playerHasWon = false;
			
			//Text about the game.
			System.out.println("Du �r en utforskare som f�rs�ker hitta en dyrbar skatt. Till din hj�lp har du ett visst antal uppt�cktsresande som kommer rapportera allt de hittar till dig, samt ge ledtr�dar kring skattens koordinater.");
			System.out.println("Med denna information kommer det vara ditt jobb att hitta skatten. Fr�gan �r nu vilken skatt du vill f�rs�ka hitta.");	
			System.out.println();
			System.out.println("Om du vill vara med p� din kunsin Kalle Perssons skattjakt skriver du L�tt");
			System.out.println("Om du vill hitta de fantastiska juvelerna fr�n Atlantis skriver du Medel");
			System.out.println("Om du vill hitta Harald Bl�tands rikedomar skriver du Sv�rt");
			System.out.println("Om du vill hitta Mansa Moussa 2 ton 24 karat guld skriver du Om�jligt");
			
			//Player selecting difficulty.
			while(true) {	
				String difficultyString = input.nextLine();
				
				if (difficultyString.toUpperCase().equals("L�TT")) {
					System.out.println("P� skattjakten f�r du tre ledar per gissning.");
					difficultyInt = 0;
					numberOfGuesses = 5;
					treasurePosition = (int)(Math.random() * 16);
					break;
				}
				else if (difficultyString.toUpperCase().equals("MEDEL")) {
					System.out.println("I jakten p� juvelerna fr�n Atlantis f�r du en ledtr�d per gissning.");
					difficultyInt = 1;
					numberOfGuesses = 7;
					treasurePosition = (int)(Math.random() * 51);
					break;
				}
				else if (difficultyString.toUpperCase().equals("SV�RT")) {
					System.out.println("Harald Bl�tand var en listig m�nniska och ville missleda de som letade efter hans rikedomar. D�rf�r f�r du en fel och tv� r�tta ledtr�dar varje g�ng du gissar.");
					difficultyInt = 2;
					numberOfGuesses = 10;
					treasurePosition = (int)(Math.random() * 201);
					break;
				}
				else if (difficultyString.toUpperCase().equals("OM�JLIGT")) {
					System.out.println("Mansa Moussa var en f�rsiktig man. F�r varje gissning du g�r f�r du tv� r�tta och en fel ledtr�d.");
					difficultyInt = 3;
					numberOfGuesses = 10;
					treasurePosition = (int)(Math.random() * 1001);
					break;
				}
				else {
					System.out.println(difficultyString + " �r inte giltig. Skriv l�tt, medel, sv�rt eller om�jligt.");
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
			
			//Here is most of the gameplay. The player gets a hind, they guess and the code test if they got it or not.
			while(playerHasLost == false && playerHasWon == false){
				System.out.println("Ledtr�dar:");
				RandomClues(difficultyInt, playerGuess, treasurePosition);
				
				System.out.println();
				System.out.println("Du har " + numberOfGuesses + " antal gissningar kvar");
				playerGuess = PlayerGuessing(difficultyInt);
				
				numberOfGuesses--;
				if(numberOfGuesses == 0) {
					playerHasLost = true;
				}
				if(playerGuess == treasurePosition) {
					playerHasLost = false;
					playerHasWon = true;
				}
			}
			
			//Winning / loosing text
			if(playerHasWon) {
				System.out.println("Du vann! Du klarade spelet med " + numberOfGuesses + " gissningar kvar! Om du vill k�ra om spelet skriver du omstart" );
			}
			else {
				System.out.println("Du f�rlorade! Talet var " + treasurePosition + " Om du vill k�ra om spelet skriver du omstart");
			}

			if(!input.nextLine().toUpperCase().equals("OMSTART")) {
				playerIsPlaying = false;
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
			
			//This is made so that different difficulties to get different clues. Easy gets clue 3, 4, 6, 8 and so on.
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
				if(TestIfNumber1IsAFactorOfNumber2(treasurerPosition, playerGuess) && i != falseClue || !TestIfNumber1IsAFactorOfNumber2(treasurerPosition, playerGuess) && i == falseClue) {
					System.out.println("Talet du letar efter �r en faktor av talet du gissa");
				}
				else {
					System.out.println("Talet du letar efter �r INTE en faktor av talet du gissa");
				}
			}
			else if(selectClue == 2) {
				if(TestIfNumber1IsAFactorOfNumber2(playerGuess, treasurerPosition) && i != falseClue || !TestIfNumber1IsAFactorOfNumber2(playerGuess, treasurerPosition) && i == falseClue) {
					System.out.println("Det talet du gissa �r en faktor av talet du letar efter");
				}
				else {
					System.out.println("Det talet du gissa �r INTE en faktor av talet du letar efter");
				}
			}
			else if(selectClue == 3) {
				if(TestIfNumber1CloseToNumber2(playerGuess, treasurerPosition) && i != falseClue || !TestIfNumber1CloseToNumber2(playerGuess, treasurerPosition) && i == falseClue) {
					System.out.println("Talet du letar efter �r n�ra din gissning");
				}
				else {
					System.out.println("Talet du letar efter �r INTE n�ra din gissning");
				}
			}
			else if(selectClue == 4) {
				if(TestIfNumber1IsGreaterThanNumber2(playerGuess, treasurerPosition) && i != falseClue || !TestIfNumber1IsGreaterThanNumber2(playerGuess, treasurerPosition) && i == falseClue) {
					System.out.println("Din gissning �r st�rre �n talet du letar efter");
				}
				else {
					System.out.println("Din gissning �r mindre �n talet du letar efter");
				}
			}
			else if(selectClue == 5) {
				if(TestIfNumber1HasACommonDigitWithNumber2(playerGuess, treasurerPosition) && i != falseClue || !TestIfNumber1HasACommonDigitWithNumber2(playerGuess, treasurerPosition) && i == falseClue) {
					System.out.println("Din gissning och talet du letar efter har en gemensam siffra");
				}
				else {
					System.out.println("Din gissning och talet du letar efter har INTE en gemensam siffra");
				}
			}
			else if(selectClue == 6) {
				if(TestIfNumberIsPrime(treasurerPosition) && i != falseClue || !TestIfNumberIsPrime(treasurerPosition) && i == falseClue) {
					System.out.println("Talet du letar efter �r ett primtal");
				}
				else {
					System.out.println("Talet du letar efter �r INTE ett primtal");
				}
			}
			else if(selectClue == 7) {
				if(TestIfNumberIsASquareNumber(treasurerPosition) && i != falseClue || !TestIfNumberIsASquareNumber(treasurerPosition) && i == falseClue) {
					System.out.println("Talet du letar efter �r en perfekt kvadrat");
				}
				else {
					System.out.println("Talet du letar efter �r INTE en perfekt kvadrat");
				}
			}
			else {
				if(TestIfNumberIsEven(treasurerPosition) && i != falseClue || !TestIfNumberIsEven(treasurerPosition) && i == falseClue) {
					System.out.println("Talet du letar efter �r j�mnt");
				}
				else {
					System.out.println("Talet du letar efter �r oj�mnt");
				}
			}
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
	
	/**
	 * This method returns true if number1 is a factor of number2 and false if not.
	 * @param number1 is the first input integer you want to test
	 * @param number2 is the second input integer you want to test
	 * @return true if number1 is a factor of number2
	 */
	public static boolean TestIfNumber1IsAFactorOfNumber2(int number1, int number2) {
		if(((int)(number2/number1)) * number1 == number2) {
			return true;
		}
		else {
			return false;
		}
	}

	public static boolean TestIfNumber1CloseToNumber2(int number1, int number2) {
		if(Math.abs(number1 - number2) < 10) {
			return true;
		}
		return false;
	}

	public static boolean TestIfNumber1IsGreaterThanNumber2(int number1, int number2) {
		if(number1 > number2) {
			return true;
		}
		return false;
	}

	public static boolean TestIfNumber1HasACommonDigitWithNumber2(int number1, int number2) {
		while(number1 != 0 && number2 != 0) {
			if(number1 % 10 == number2 % 10) {
				return true;
			}
			//number1 / 10 is the same thing as Math.floor(number1 / 10) because number1 is an integer
			number1 = number1 / 10;
			number2 = number2 / 10;
		}
		return false;
	}

	public static boolean TestIfNumberIsPrime(int number) {
		for (int i = 2; i <= Math.ceil(Math.sqrt(number)); i++) {
			if(TestIfNumber1IsAFactorOfNumber2(i, number)) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean TestIfNumberIsASquareNumber(int number) {
		if(number == Math.pow(Math.sqrt(number), 2)) {
			return true;
		}
		return false;
	}

	public static boolean TestIfNumberIsEven(int number) {
		if(TestIfNumber1IsAFactorOfNumber2(2, number)) {
			return true;
		}
		return false;
	}
}
