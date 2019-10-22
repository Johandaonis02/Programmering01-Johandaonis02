import java.util.Random;
import java.util.Scanner;

public class fourInARow3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int width = 7;
		int height = 6;
		System.out.println("Number of players: ");
		int numberOfPlayers = input.nextInt();
		input.nextLine();
		
		boolean hasWon;
		int player = 1;
		int turn = 1;
		int[][] cells = new int [width][height];
		String[] names = new String [numberOfPlayers];
		char[] playerObject = new char [numberOfPlayers + 1];
		
		for(int i = 0; i <= numberOfPlayers; i++) {
			if(i == 0) {
				playerObject[i] = '-';
			}
			else if(i == 1) {
				playerObject[i] = 'X';
			}
			else if(i == 2) {
				playerObject[i] = 'O';
			}
			else if(i == 3) {
				playerObject[i] = 'Y';
			}
			else {
				playerObject[i] = (char)(i - 3 + '0');
			}
		}
		
		for(int y = 0; y<height; y++) {
			for(int x = 0; x<width; x++) {
				cells[x][y] = 0;
			}
		}
		
		for(int i = 0; i < numberOfPlayers; i++) {
			System.out.println("Tell me player " + (i + 1) + "'s name");

			names[i] = input.nextLine();				
		}
		
		for(hasWon = false; !hasWon && turn <= height * width; turn++) {
			//display
			System.out.println(names[player - 1] + "'s turn (" + playerObject[player] + ")");
			display(playerObject, height, width, cells);

			//play
			//test column and number
			int y = height - 1;
			int x;
			while(true) {
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
			
			if(turn >= numberOfPlayers * 3 + 1) {
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
		}
		else {
			System.out.println("Draw");
		}
		display(playerObject, height, width, cells);
	}
	
	/**
	 * Input = status in numbers and output = display the board
	 * @param height
	 * @param width
	 * @param cells 
	 */
	public static void display(char playerObject[], int height, int width, int cells[][]) {
		for(int y = 0; y<height; y++) {
			for(int x = 0; x<width; x++) {
				System.out.print(playerObject[cells[x][y]] + " " );
			}
			System.out.println();
		}
	}
}
