import java.util.Iterator;
import java.util.Scanner;

public class HangaGubben {
	
	static String[] words = {"KAN", "FYR", "EK", "AFTON", "LJUD", "BIBLIOTEK", "ORANGE", "ULL", "INNAN"};
	
	public static void main(String[] args) {
		Welcome();
		
		int difficulty = AskPlayerDifficulty();
		
		String dummyWord = words[(int)(3*(Math.random() + difficulty))];
		char[] fullWord = new char[dummyWord.length()];
		char[] partWord = new char[dummyWord.length()];
		
		for (int i = 0; i < fullWord.length; i++) {
			fullWord[i] = dummyWord.charAt(i);
			partWord[i] = '_';
		}
		
		
	}
	
	public static int RemoveOneGuess(int numberOfGuessesLeft) {
		return numberOfGuessesLeft--;
	}
	
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
	
	public static void Welcome() {
		System.out.println("Detta spelet �r h�nga gubben. Du f�r ett svenskt ord och du ska gissa bokstav efter bokstav. Om du gissar r�tt s� visar bokstaven sig medans om du gissar fel s� kommer du ett steg n�rmre att f�rlora.");
	}
	
	public static boolean TestIfPlayerWantRestart(int numberOfGuessesLeft) {
        Scanner input = new Scanner(System.in);
        
        if(numberOfGuessesLeft == 0) {
            System.out.println("Du f�rlorade");
        }
        else {
            System.out.println("Du vann!");
        }
        System.out.println("vill du k�ra igen?");
        
        String dummyString = input.nextLine();
        if(dummyString.toUpperCase() == "YES") {
            return true;
        }
        return false;
    }
    
    public static boolean TestIfLetterBeenGuessedBefore(char guessedLetter) {
        for (int i = 0; i < fullWord.length; i++) {
            if(fullWord[i] == guessedLetter) {
                return true;
            }
        }
        return false;
    }
	
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
