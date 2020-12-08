
public class ThreeInARowAI2 {
	public static void main(String[] args) {
		char[] cell0 = new char [3];
		char[] cell1 = new char [3];
		char[] cell2 = new char [3];
		int round = 0;
		
		for (int i = 0; i <= 2; i++) {
			cell0[i] = '_';
			cell1[i] = '_';
			cell2[i] = '_';
		}
		display(cell0, cell1, cell2);
		System.out.println(ai(round, cell0.clone(), cell1.clone(), cell2.clone()));
	}
	
	public static int ai(int round, char cell0[], char cell1[], char cell2[]) {
		int place = -1;
		
		if(round == 9) {
			return(0);
		}
		
		if(round % 2 == 0){
			int returnNumber = 2;
			
			for (int i = 0; i <= 2; i++) {
				if(cell0[i] == '_') {
					cell0[i] = 'X';
					
					display(cell0, cell1, cell2);
					
					if(WhoWon(cell0, cell1, cell2) == 'X') {
						return(-1);
					}
					if(ai(round + 1, cell0.clone(), cell1.clone(), cell2.clone()) < returnNumber) {
						returnNumber = ai(round + 1, cell0.clone(), cell1.clone(), cell2.clone());
						place = 3 * i;
					}
					cell0[i] = '_';
					
					display(cell0, cell1, cell2);
					System.out.println("test");
				}
			}
			
			for (int i = 0; i <= 2; i++) {
				if(cell1[i] == '_') {
					cell1[i] = 'X';
					
					display(cell0, cell1, cell2);
					
					if(WhoWon(cell0, cell1, cell2) == 'X') {
						return(1);
					}
					if(ai(round + 1, cell0.clone(), cell1.clone(), cell2.clone()) < returnNumber) {
						returnNumber = ai(round + 1, cell0.clone(), cell1.clone(), cell2.clone());
						place = 3 * i + 1;
					}
					cell1[i] = '_';
					
					display(cell0, cell1, cell2);
					System.out.println("test");
				}
			}
			
			for (int i = 0; i <= 2; i++) {
				if(cell2[i] == '_') {
					cell2[i] = 'X';
					
					display(cell0, cell1, cell2);
					
					if(WhoWon(cell0, cell1, cell2) == 'X') {
						return(1);
					}
					if(ai(round + 1, cell0.clone(), cell1.clone(), cell2.clone()) < returnNumber) {
						returnNumber = ai(round + 1, cell0.clone(), cell1.clone(), cell2.clone());
						place = 3 * i + 2;
					}
					cell2[i] = '_';
					
					display(cell0, cell1, cell2);
					System.out.println("test");
				}
			}
			
			
			System.out.println("place: " + place);
				
			return(returnNumber);
		}
		
		if(round % 2 == -1){
			int returnNumber = -2;
			
			for (int i = 0; i <= 2; i++) {
				if(cell0[i] == '_') {
					cell0[i] = 'O';
					
					display(cell0, cell1, cell2);
					
					if(WhoWon(cell0, cell1, cell2) == 'O') {
						return(1);
					}
					if(ai(round + 1, cell0.clone(), cell1.clone(), cell2.clone()) > returnNumber) {
						returnNumber = ai(round + 1, cell0.clone(), cell1.clone(), cell2.clone());
						place = 3 * i;
					}
					cell0[i] = '_';
					
					display(cell0, cell1, cell2);
					System.out.println("test");
				}
			}
			
			for (int i = 0; i <= 2; i++) {
				if(cell1[i] == '_') {
					cell1[i] = 'O';
					
					display(cell0, cell1, cell2);
					
					if(WhoWon(cell0, cell1, cell2) == 'O') {
						return(-1);
					}
					if(ai(round + 1, cell0.clone(), cell1.clone(), cell2.clone()) > returnNumber) {
						returnNumber = ai(round + 1, cell0.clone(), cell1.clone(), cell2.clone());
						place = 3 * i + 1;
					}
					cell1[i] = '_';
					
					display(cell0, cell1, cell2);
					System.out.println("test");
				}
			}
			
			for (int i = 0; i <= 2; i++) {
				if(cell2[i] == '_') {
					cell2[i] = 'O';
					
					display(cell0, cell1, cell2);
					
					if(WhoWon(cell0, cell1, cell2) == 'O') {
						return(-1);
					}
					if(ai(round + 1, cell0.clone(), cell1.clone(), cell2.clone()) > returnNumber) {
						returnNumber = ai(round + 1, cell0.clone(), cell1.clone(), cell2.clone());
						place = 3 * i + 2;
					}
					cell2[i] = '_';
					
					display(cell0, cell1, cell2);
					System.out.println("test");
				}
			}
			
			
			System.out.println("place: " + place);
				
			return(returnNumber);
		}
		
		System.out.println("Test");
		return(10);
	}
	
	public static char WhoWon(char cell0[], char cell1[], char cell2[]) {
		for (int i = 0; i <= 2; i++) {
			if(cell0[i] == cell1[i] && cell1[i] == cell2[i]) {
				return(cell0[i]);
			}
		}
		
		if(cell0[0] == cell0[1] && cell0[1] == cell0[2]) {
			return(cell0[0]);
		}
		if(cell1[0] == cell1[1] && cell1[1] == cell1[2]) {
			return(cell1[0]);
		}
		if(cell2[0] == cell2[1] && cell2[1] == cell2[2]) {
			return(cell2[0]);
		}
		
		
		if(cell0[0] == cell1[1] && cell1[1] == cell2[2]) {
			return(cell0[0]);
		}
		if(cell0[2] == cell1[1] && cell1[1] == cell2[0]) {
			return(cell0[2]);
		}
		
		return('_');
	}
	
	public static void display(char cell0[], char cell1[], char cell2[]) {
		for (int i = 0; i <= 2; i++) {
			System.out.print(cell0[i]);
		}
		System.out.println("");
		for (int i = 0; i <= 2; i++) {
			System.out.print(cell1[i]);
		}
		System.out.println("");
		for (int i = 0; i <= 2; i++) {
			System.out.print(cell2[i]);
		}
		System.out.println("");
	}
}
