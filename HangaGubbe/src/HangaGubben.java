import java.util.Scanner;
import java.util.ArrayList;

public class HangaGubben {

	//Ord 1-3: l�tt, 4-6: mellan, 7-9: sv�r.
	static String[] words = {"KAN", "FYR", "EK", "AFTON", "LJUD", "BIBLIOTEK", "ORANGE", "ULL", "INNAN"}; 
	static char[] fullWord;
	static char[] partWord;
	static ArrayList<Character> guessedLetters = new ArrayList<Character>();

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		char guessedLetter;
		int numberOfGuessesLeft;
		boolean isPlaying = true;
		
		//Denna while loopen k�rs till spelaren inte vill k�ra mer.
		while(isPlaying) {
			Welcome();
			
			int difficulty = AskPlayerDifficulty();
			
			int numberOfGuessesStart = 5 - difficulty;
			
			String dummyWord = words[(int)(3*(Math.random() + difficulty))];
			fullWord = new char[dummyWord.length()];
			partWord = new char[dummyWord.length()];
			
			for (int i = 0; i < fullWord.length; i++) {
				fullWord[i] = dummyWord.charAt(i);
				partWord[i] = '*';
			}
			
			//Denna for loopen k�rs om varje runda.
			for (numberOfGuessesLeft = numberOfGuessesStart; numberOfGuessesLeft > 0 && !TestIfPartWordEqualsFullWord(); numberOfGuessesLeft = numberOfGuessesLeft) {
				AsciiAndWordDisplay(numberOfGuessesLeft);
				
				for (int i = 0; i < partWord.length; i++) {
					System.out.print(partWord[i]);
				}
				System.out.println();
				
				AskPlayerToPickLetter(numberOfGuessesLeft, difficulty);
				
				//denna while loop har jag f�r att spelaren ska skriva en bokstav som �r till�ten.
				while(true) {
					String dummyString = input.nextLine().toUpperCase();	
					
					if(dummyString.length() == 1) {
						guessedLetter = dummyString.charAt(0);
						if(!Character.isDigit(guessedLetter)) {
							if(TestIfLetterBeenGuessedBefore(guessedLetter)) {
								System.out.println("Du har redan valt denna bokstav");
							}
							else {
								guessedLetters.add(guessedLetter);
								break;
							}
						}
						else {
							System.out.println("Du m�ste v�lja en bokstav");
						}
					}
					else {
						System.out.println("Du beh�ver skriva enbart en bokstav.");
					}	
				}
	
				
				if(TestIfLetterInFullWord(guessedLetter)) {
					AddToPartWord(guessedLetter);
					System.out.println(guessedLetter + " finns med i ordet.");
				}
				else {
					numberOfGuessesLeft = RemoveOneGuess(numberOfGuessesLeft);
					//numberOfGuessesLeft = RemoveOneGuess(numberOfGuessesLeft);
					System.out.println(guessedLetter + " finns inte med i ordet");
				}
			}
			
			isPlaying = TestIfPlayerWantRestart(numberOfGuessesLeft);
			
			for (int i = guessedLetters.size() - 1; i >= 0; i--) {
				guessedLetters.remove(i);
			}
		}
	}
	
	/**
	 * Testar om bokstaven spelaren gissade p� (guessedLetter) finns i ordet (fullWord).
	 * @param guessedLetter (bokstaven spelaren gissade p�)
	 * @return true om guessedLetter �r i fullWord. False om inte. 
	 */
	public static boolean TestIfLetterInFullWord(char guessedLetter) {
		
		for (int i = 0; i < fullWord.length; i++) {
			if(fullWord[i] == guessedLetter) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Testar om man har hittat alla bokst�ver i ordet.
	 * @return true om partWord = fullWord och false om partWord =/= fullWord
	 */
	public static boolean TestIfPartWordEqualsFullWord() {
		for (int i = 0; i < fullWord.length; i++) {
			if(fullWord[i] != partWord[i]) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * L�gger till bokstaven spelaren gissade p� i ordet spelaren ser.
	 * @param guessedLetter �r bokstaven spelaren gissade p�.
	 */
	public static void AddToPartWord(char guessedLetter) {
		for (int i = 0; i < fullWord.length; i++) {
			if(fullWord[i] == guessedLetter) {
				partWord[i] = guessedLetter;
			}
		}
	}
	
	/**
	 * L�gg till bokstaven spelare gissade p� i listan av bokst�ver spelaren har gissat p�.
	 * @param guessedLetter
	 */
	public static void AddToGuessedLetter(char guessedLetter) {
		guessedLetters.add(guessedLetter);
	}
	
	/**
	 * S�ger till spelaren att den ska gissa p� en bokstav.
	 * @param numberOfGuessesLeft �r antalet gissningar kvar.
	 * @param difficulty �r sv�righeten.
	 */
	public static void AskPlayerToPickLetter(int numberOfGuessesLeft, int difficulty) {
		if(numberOfGuessesLeft == 5 - difficulty) {
			System.out.println("Skriv en bokstav");
		}
		else {
			System.out.println("Skriv en bokstav som du inte skrivit innan");
		}
	}
	
	/**
	 * Tar bort ett fr�n numberOfGuessesLeft
	 * @param numberOfGuessesLeft �r antalet gissningar spelaren har kvar.
	 * @return antalet gissningar spelaren ska ha.
	 */
	public static int RemoveOneGuess(int numberOfGuessesLeft) {
		return numberOfGuessesLeft - 1;
	}
	
	/**
	 * S�ger till spelaren att v�lja en sv�righetsgrad.
	 * @return sv�righetsgraden i int form.
	 */
	public static int AskPlayerDifficulty() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Vilken sv�righetsgrad vill du ha? (L�tt, mellan eller sv�r)");
		while (true) {
			String dummyString = input.nextLine();
			
			if(dummyString.toUpperCase().equals("L�TT")) {
				return 0;
			}
			if(dummyString.toUpperCase().equals("MELLAN")) {
				return 1;
			}
			if(dummyString.toUpperCase().equals("SV�R")) {
				return 2;
			}
			System.out.println("Du m�ste skriva l�tt, mellan eller sv�r");
		}
	}
	
	/**
	 * V�lkomnar spelaren
	 */
	public static void Welcome() {
		System.out.println("Detta spelet �r h�nga gubben. Du f�r ett svenskt ord och du ska gissa bokstav efter bokstav. Om du gissar r�tt s� visar bokstaven sig medans om du gissar fel s� kommer du ett steg n�rmre att f�rlora.");
	}
	
	/**
	 * Testar om spelaren vill k�ra om spelet.
	 * @param numberOfGuessesLeft �r antalet gissningar kvar.
	 * @return true om spelaren vill k�ra om spelet och false om inte.
	 */
	public static boolean TestIfPlayerWantRestart(int numberOfGuessesLeft) {
        Scanner input = new Scanner(System.in);
        
        if(numberOfGuessesLeft == 0) {
            System.out.println("Du f�rlorade");
        }
        else {
            System.out.println("Du vann!");
        }
        System.out.println("vill du k�ra igen?");
        
        while(true) {
	        String dummyString = input.nextLine().toUpperCase();
	       
	        if(dummyString.equals("JA")) {
	            return true;
	        }
	        else if(dummyString.equals("NEJ")) {
	        	return false;
	        }
	        System.out.println("Du beh�ver skriva ja eller nej");
        }
    }
    
	/**
	 * Testar om bokstaven spelaren gissar har blivit gissad p� innan.
	 * @param guessedLetter �r bokstaven spelaren gissade p�.
	 * @return true om bokstaven har blivit gissad p� innan och false om inte.
	 */
    public static boolean TestIfLetterBeenGuessedBefore(char guessedLetter) {
        for (int i = 0; i < guessedLetters.size(); i++) {
        	if(guessedLetters.get(i) == guessedLetter) {
            	return true;
            }
		}
        return false;
    }
	
    /**
     * Skriver ut h�nga gubben ascii displayen.
     * @param numberOfGuessesLeft �r antalet gissningar spelaren har kvar.
     */
	public static void AsciiAndWordDisplay(int numberOfGuessesLeft) {
        System.out.println(" +---+");
        System.out.println(" |   |");

        //Denna while loop har jag f�r att man ska kunna hoppa ur n�r man har hittat r�tt tal s� man inte beh�ver testa mer �n n�dv�ndigt.
        while(true) {
            if(numberOfGuessesLeft == 5) {
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                break;
            }

            System.out.println(" O   |");
            if(numberOfGuessesLeft == 4) {
                System.out.println(" |   |");
            }
            else if(numberOfGuessesLeft == 3) {
                System.out.println("V|   |");
            }
            if(numberOfGuessesLeft == 3 || numberOfGuessesLeft == 4) {
                System.out.println("     |");
                System.out.println("     |");
                break;
            }

            System.out.println("V|V  |");
            if(numberOfGuessesLeft == 2) {
                System.out.println("     |");
            }
            else if(numberOfGuessesLeft == 1) {
                System.out.println("I    |");
            }
            else if(numberOfGuessesLeft == 0) {
                System.out.println("I I  |");
            }
            System.out.println("     |");
            break;
        }
    }
}
