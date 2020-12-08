
public class Test {
	public static void main(String[] args) {
		char[][] cell = new char [3][3];
		char[][][] cell1 = new char [3][3];
		
		int round = 0;
		
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				cell[i][j] = '_';
			}
		}
		
		display(cell);
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				cell1[i][j] = cell[i][j];
			}
		}
		System.out.println(ai(round, cell.clone()));
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				cell[i][j] = cell1[i][j];
			}
		}
		display(cell);
	}
	
	public static int ai(int round, char cell[][]) {
		cell[1][1] = 'x';
		return(1);
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
