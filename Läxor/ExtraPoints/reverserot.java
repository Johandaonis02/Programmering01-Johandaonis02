import java.util.Scanner;

public class reverserot {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//H�r �r en lista p� alla bokst�ver
		char[] letters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','_','.'};
		
		while(true) {
			String outputString = "";
			int rotate = input.nextInt();
			if(rotate == 0) {
				break;
			}
			String strings = input.nextLine();
			//Jag tar siffror bakifr�n f�r att v�nda p� ordet.
			for (int i = strings.length() - 1; i > 0; i--) {
				int charAt = 0;
				//I den h�r forloopen f�rs�ker jag hitta vilken platts bokstaven p� plattsen i och 
			    //sedan l�gger jag till rotate m�ngden f�r att f� den r�tte bokstaven.
				for (int j = 0; j < letters.length; j++) {
					if(strings.charAt(i) == letters[j]) {
						
						charAt = (j + rotate) % 28;
						break;
					}
				}
				outputString += letters[charAt];
			}
			System.out.println(outputString);
		}
	}
}
