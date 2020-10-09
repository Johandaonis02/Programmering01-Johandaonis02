
public class BestToProblem {
	static int numberOfGames = 0;
	static int bestTo = 4;
	static int numberOfPlayers = 4;
	
	public static void main(String[] args) {
		int[] wins = new int[numberOfPlayers];
		for (int i = 0; i < numberOfPlayers; i++) {
			wins[i] = 0;
		}
		winThingy(wins);
		System.out.println(numberOfGames);
	}
	
	
	static void winThingy(int[] wins) {
		
		for (int i = 0; i <= numberOfPlayers; i++) {
			
			if(i == numberOfPlayers) {
				for (int j = 0; j < numberOfPlayers; j++) {
					wins[j]++;
					winThingy(wins);
					wins[j]--;
				}
				break;
			}
			
			if(wins[i] >= bestTo) {
				numberOfGames++;
				break;
			}	
		}
	}
}
