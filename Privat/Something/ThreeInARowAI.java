
public class ThreeInARowAI {
	public static void main(String[] args) {
		char[][] cell = new char [3][3];
		int round = 0;
		
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				cell[i][j] = '_';
			}
		}
		System.out.println(ai(round, cell));
	}
	
	public static int ai(int round, char cell[][]) {
		int place = -1;
		
		if(round == 9) {
			return(0);
		}
		
		if(round % 2 == 0){
			int returnNumber = 2;
			for (int i = 0; i <= 2; i++) {
				for (int j = 0; j <= 2; j++) {
					if(cell[i][j] == '_') {
						cell[i][j] = 'X';
						
						display(cell);
						
						if(WhoWon(cell) == 'X') {
							return(-1);
						}
						if(ai(round + 1, cell) < returnNumber) {
							returnNumber = ai(round + 1, cell);
							place = 3 * i + j;
						}
						cell[i][j] = '_';
					}
				}
			}
			if(round == 0) {
				System.out.println("place: " + place);
			}
			return(returnNumber);
		}
		
		if(round % 2 == 1){
			int returnNumber = -2;
			for (int i = 0; i <= 2; i++) {
				for (int j = 0; j <= 2; j++) {
					if(cell[i][j] == '_') {
						cell[i][j] = 'O';
						
						display(cell);
						
						if(WhoWon(cell) == 'O') {
							return(1);
						}
						if(ai(round + 1, cell) > returnNumber) {
							returnNumber = ai(round + 1, cell);
							place = 3 * i + j;
						}
						cell[i][j] = '_';
					}
				}
			}
			return(returnNumber);
		}
		
		System.out.println("TEst");
		return(10);
	}
	
	public static char WhoWon(char cell[][]) {
		for (int i = 0; i <= 2; i++) {
			if(cell[0][i] == cell[1][i] && cell[1][i] == cell[2][i]) {
				return(cell[0][i]);
			}
			if(cell[i][0] == cell[i][1] && cell[i][1] == cell[i][2]) {
				return(cell[0][i]);
			}
		}
		
		if(cell[0][0] == cell[1][1] && cell[1][1] == cell[2][2]) {
			return(cell[0][0]);
		}
		if(cell[0][2] == cell[1][1] && cell[1][1] == cell[2][0]) {
			return(cell[0][2]);
		}
		
		return('_');
	}
	
	public static void display(char cell[][]) {
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				System.out.print(cell[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}
}
