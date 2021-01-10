
public class GuessGame {
	public static void main(String[] args) {
		int max = 795;
		int min = 491;
		
		System.out.println(NumberOfGuessesNeeded((double)(max - min + 1)));
	}
	
	public static double NumberOfGuessesNeeded(double NumberOfElements) {
		
		if(NumberOfElements == 1) {
			return(1);
		}
		else if(NumberOfElements == 2) {
			return(1.5);
		}
		
		return(1/NumberOfElements + ((Math.ceil(NumberOfElements / 2) - 1) / NumberOfElements) * (1 + NumberOfGuessesNeeded(Math.ceil(NumberOfElements / 2) - 1)) + (Math.floor(NumberOfElements / 2) / NumberOfElements) * (1 + NumberOfGuessesNeeded(Math.floor(NumberOfElements / 2))));
		
	}
}
