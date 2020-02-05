import java.util.Scanner;

public class reverserot {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//Här är en lista på alla bokstäver
		char[] letters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','_','.'};
		
		while(true) {
			String outputString = "";
			int rotate = input.nextInt();
			if(rotate == 0) {
				break;
			}
			String strings = input.nextLine();
			//Jag tar siffror bakifrån för att vända på ordet.
			for (int i = strings.length() - 1; i > 0; i--) {
				int charAt = 0;
				//I den här forloopen försöker jag hitta vilken platts bokstaven på plattsen i och 
			    //sedan lägger jag till rotate mängden för att få den rätte bokstaven.
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
