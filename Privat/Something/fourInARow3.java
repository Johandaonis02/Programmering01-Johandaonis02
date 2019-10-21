import java.util.Random;
import java.util.Scanner;

public class fourInARow3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int width = 7;
		int height = 6;
		int numberOfPlayers = 2;
		
		boolean hasWon;
		int player = 1;
		int turn = 1;
		int[][] cells = new int [width][height];
		String[] names = new String [numberOfPlayers];
		
		for(int y = 0; y<height; y++) {
			for(int x = 0; x<width; x++) {
				cells[x][y] = 0;
			}
		}
		
		for(int i = 0; i < numberOfPlayers; i++) {
			System.out.println("Tell me player " + (i + 1) + "'s name");
			names[i] = input.nextLine();
		}
		
		for(hasWon = false; hasWon == false && turn <= height * width; turn++) {
			//display
			System.out.println(names[player - 1] + "'s turn");
			display(height, width, cells);

			//play
			//test column and number
			int y = height - 1;
			int x;
			while(2 > 1) {
				if(names[player - 1].equals("Bot")) {
					x = (int)(Math.random() * width);
				}
				else {
					x = input.nextInt() - 1;
				}
				if(0 <= x && x < width) {
					if(cells[x][0] == 0) {
						break;
					}
					else {
						System.out.println("This column is full");
					}
				}
				else {
					System.out.println(x + 1 + " isn't a valid number. Pick a number between 1 and " + width);
				}
			}
			
			//place
			while(y >= 0) {
				if(cells[x][y] == 0) {
					cells[x][y] = player;
					break;
				}
				y--;
			}
			
			if(turn >= 7) {
				//diagonals
				for(int j = -1; j <= 1; j += 2) {
					for(int i = -3; i <= 3; i++) {
						if(0 <= x + i &&  x + i + 3 <= width - 1 && 0 <= y + i * j && y + 3 + i * j <= height - 1) {
							if((cells[x + i][y + i * j] == player) && (cells[x + i + 1][y + 1 +  i * j] == player) &&
							(cells[x + i + 2][y + 2 + i * j] == player) && (cells[x + i + 3][y + 3 + i * j] == player)) {
								hasWon = true;
								break;
							}
						}
					}
				}
				//vertical
				for(int i = -3; i <= 3; i++) {
					if(0 <= y + i && y + i + 3 <= height - 1) {
						if(cells[x][y + i] == player && cells[x][y + i + 1] == player && cells[x][y + i + 2] == player && 
						cells[x][y + i + 3] == player) {
							hasWon = true;
							break;
						}
					}
				}
				//horizontal
				for(int i = -3; i <= 3; i++) {
					if(0 <= x + i && x + i + 3 <= width - 1) {
						if(cells[x + i][y] == player && cells[x + i + 1][y] == player && cells[x + i + 2][y] == player && 
						cells[x + i + 3][y] == player) {
							hasWon = true;
							break;
						}
					}
				}
			}
			
			//next player
			if(hasWon == false) {
				player = (player % numberOfPlayers) + 1;
			}
		}
		
		if(hasWon == true) {
			System.out.println(names[player - 1] + " won");
			display(height, width, cells);
		}
		else {
			System.out.println("Draw");
			display(height, width, cells);
		}
	}
	
	/**
	 * Input = status in numbers and output = display the board
	 * @param height
	 * @param width
	 * @param cells 
	 */
	public static void display(int height, int width, int cells[][]) {
		for(int y = 0; y<height; y++) {
			for(int x = 0; x<width; x++) {
				System.out.print(cells[x][y] + " " );
			}
			System.out.println();
		}
	}
}
