
public class ThreeInARowAIV3 {	
	static int win1 = 0;
	static int win2 = 0;
	static int draw = 0;
	
	public static void main(String[] args) {
		int[][] cell = new int [3][3];
		
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				cell[i][j] = 0;
			}
		}
		System.out.println(1);
		int numberOfPieces = 0;
		
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				if(cell[i][j] != 0) {
					numberOfPieces++;
				}
			}
		} 
		
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				if(cell[i][j] == 0) {
					if(numberOfPieces % 2 == 0) {
						cell[i][j] = 1;
					}
					else {
						cell[i][j] = -1;
					}
					
					if(WhoWon(cell) == -1) {
						System.out.print(numberOfPieces - 9);
					}
					else if(WhoWon(cell) == 1) {
						System.out.print(9 - numberOfPieces);
					}
					else {
						System.out.print(bot(numberOfPieces + 1, cell) + " ");
					}
					cell[i][j] = 0;
				}
				else {
					System.out.print("[" + cell[i][j] + "]");
				}
			}
			System.out.println();
		}
		
		System.out.println(win1);
		System.out.println(win2);
		System.out.println(draw);
		System.out.println(win1 + win2 + draw);
		System.out.println("done");
	}
	public static int bot(int depth, int[][] cell)
    {		
		if(depth > 9) {
			System.out.println("AAAAA");
			
		}
		
//		System.out.println(":)" + depth);
//		display(cell);
		
		if(depth == 9 && WhoWon(cell) == 0) {
			draw++;
			return(0);
		}
		
		int best;
		
		if(depth % 2 == 0) {			
			if(WhoWon(cell) == -1) {
				//System.out.println("-1 won (1) " + (depth - 10));
				win2++;
				return(depth - 10);
			}
			else if(WhoWon(cell) == 1) {
				
				System.out.println("1 won (1) AAAAAAAAAAA");
				return(10 - depth);
			}
			
			best = -10000;
			
			for (int i = 0; i <= 2; i++) {
				for (int j = 0; j <= 2; j++) {
					if(cell[i][j] == 0) {
						
						cell[i][j] = 1;
						//display(cell);
						int c = bot(depth + 1, cell);
						if(c > best) {
							best = c; //bot(depth + 1, cell)
						}
						cell[i][j] = 0;
					}
				}
			}
			if(best == -10000) {
				System.out.println("AAAAA");
			}
			return(best);
		}
		else {
			
			if(WhoWon(cell) == -1) {
				System.out.println("-1 won (-1) AAAAAAAAAAAA");
				return(depth - 10);
			}
			else if(WhoWon(cell) == 1) {
				//System.out.println("1 won (-1) " + (10 - depth));
				win1++;
				return(10 - depth);
			}			
			
			best = 10000;
			
			for (int i = 0; i <= 2; i++) {
				for (int j = 0; j <= 2; j++) {
					if(cell[i][j] == 0) {
						
						cell[i][j] = -1;
						//display(cell);
						int c = bot(depth + 1, cell);
						if(c < best) {
							best = c; //bot(depth + 1, cell)
						}
						cell[i][j] = 0;
					}
				}
			}
			if(best == 10000) {
				System.out.println("AAAAA2");
			}
			return(best);
		}        
    }
	
	public static int WhoWon(int cell[][]) {
		
		for (int i = 0; i <= 2; i++) {
			
			if(cell[0][i] == cell[1][i] && cell[1][i] == cell[2][i]) {
				if(cell[0][i] != 0) {
					return(cell[0][i]);
				}
			}
			if(cell[i][0] == cell[i][1] && cell[i][1] == cell[i][2]) {
				if(cell[i][0] != 0) {
					return(cell[i][0]);
				}
			}
		}
		
		if(cell[0][0] == cell[1][1] && cell[1][1] == cell[2][2]) {
			if(cell[0][0] != 0) {
				return(cell[0][0]);
			}
		}
		if(cell[0][2] == cell[1][1] && cell[1][1] == cell[2][0]) {
			if(cell[0][2] != 0) {
				return(cell[0][2]);
			}
		}
		
		return(0);
	}

	public static void display(int cell[][]) {
		System.out.println("");
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				System.out.print(cell[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
