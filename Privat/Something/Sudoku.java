import java.util.Scanner;

public class Sudoku {
	public static void main(String[] args) {
		//[x][y][number]
		boolean[][][] cells = new boolean[9][9][9];
		Scanner input = new Scanner(System.in);
		
		
		for (int i = 0; i < 1; i++) {
			int x = input.nextInt();
			int y = input.nextInt();
			int number = input.nextInt();
			cells[x][y][number] = true;
		}
		
		
		//Display
		for (int xLoop = 0; xLoop < cells.length; xLoop++) {
			for (int yLoop = 0; yLoop < cells.length; yLoop++) {
				for (int numberLoop = 0; numberLoop < cells.length; numberLoop++) {
					if(cells[xLoop][yLoop][numberLoop]) {
						System.out.print(numberLoop + " ");
						break;
					}
					else {
						System.out.print("0 ");
						break;
					}
				}
			}
			System.out.println("");
		}
	}
}
