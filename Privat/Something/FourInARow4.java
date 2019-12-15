import java.util.Random;
import java.util.Scanner;

public class FourInARow4 {
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
			int x = 0;
			while(true) {
				if(names[player - 1].equals("Bot")) {
					x = (int)(Math.random() * width);
					
//					for(int j = 1; j > -2; j--) {
//						for(int i = 0; i < width; i++) {
//							if(bestMove(height, width, numberOfPlayers, player, turn, cells, 0, i) == j) {
//								x = i;
//								j = -2;
//								break;
//							}
//							else if(j == -1) {
//								x = (int)(Math.random() * width);
//								j = -2;
//								break;
//							}
//						}
//					}
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
			int y = place(x, height - 1, cells);
			cells[x][y] = player;
			
			if(turn <= numberOfPlayers * 3 + 1) {
				hasWon = checkWinner(cells, player, height, width, x, y);
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
	
	public static int bestMove(int height, int width, int numberOfPlayers, int player, int turn, int cells[][], int depth, int i) {
		System.out.println(depth);
		if(cells[i][0] == 0) {
			int y = place(i, height - 1, cells);
			cells[i][y] = player;
			turn++;
			player = (player % numberOfPlayers) + 1;
			
			if(depth < 4) {
				for(int x = 0; x < width; x++) {
					if(cells[x][0] == 0) {
						int y = place(x, height - 1, cells);
						cells[x][y] = player;
						turn++;
						player = (player % numberOfPlayers) + 1;
						if(checkWinner(cells, player, height, width, x, y)) {
							if(depth % numberOfPlayers == 0) {
								if(width % numberOfPlayers == 0) {
									return 1;
								}
								else {
									return -1;
								}
							}
						}
						else {
							if(bestMove(height, width, numberOfPlayers, player, turn, cells, depth + 1, i) == 1) {
								return 1;
							}
							else if(depth % numberOfPlayers != 0) {
								if(bestMove(height, width, numberOfPlayers, player, turn, cells, depth + 1, i) == -1) {
									return -1;
								}
							}
						}
						cells[x][y] = 0;
						turn--;
						if(player == 0) {
							player = numberOfPlayers - 1;
						}
						else {
							player--;
						}
						
					}
				}
			}
			else {
				for(int x = 0; x < width; x++) {
					if(cells[x][0] == 0) {
						int y = place(x, height - 1, cells);
						cells[x][y] = player;
						turn++;
						player = (player % numberOfPlayers) + 1;
						if(checkWinner(cells, player, height, width, x, y)) {
							return 1;
						}
						
						cells[x][y] = 0;
						turn--;
						if(player == 0) {
							player = numberOfPlayers - 1;
						}
						else {
							player--;
						}
					}
				}
			}
			return -1;
		}
		return -2;	
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

	public static int place(int x, int y, int cells[][]) {
		while(true) {
			if(cells[x][y] == 0) {
				break;
			}
			y--;
		}
		return y;
	}
	
	public static boolean checkWinner(int cells[][], int player, int height, int width, int x, int y) {
		//diagonal up left
		if(0 <= x - 3 && 0 <= y - 3) {
			if(cells[x - 3][y - 3] == player && cells[x - 2][y - 2] == player && cells[x - 1][y - 1] == player) {
				return true;
			}
		}
		if(0 <= x - 2 && x + 1 < width && 0 <= y - 2 && y + 1 < height) {
			if(cells[x - 2][y - 2] == player && cells[x - 1][y - 1] == player && cells[x + 1][y + 1] == player) {
				return true;
			}
		}
		if(0 <= x - 1 && x + 2 < width && 0 <= y - 1 && y + 2 < height) {
			if(cells[x - 1][y - 1] == player && cells[x + 1][y + 1] == player && cells[x + 2][y + 2] == player) {
				return true;
			}
		}
		if(x + 3 <  width && y + 3 < height) {
			if(cells[x + 1][y + 1] == player && cells[x + 2][y + 2] == player && cells[x + 3][y + 3] == player) {
				return true;
			}
		}
		
		//diagonal up right
		if(0 <= x - 3 && y + 3 < height) {
			if(cells[x - 3][y + 3] == player && cells[x - 2][y + 2] == player && cells[x - 1][y + 1] == player) {
				return true;
			}
		}
		if(0 <= x - 2 && x + 1 < width && 0 <= y - 1 && y + 2 < height) {
			if(cells[x - 2][y + 2] == player && cells[x - 1][y + 1] == player && cells[x + 1][y - 1] == player) {
				return true;
			}
		}
		if(0 <= x - 1 && x + 2 < width && 0 <= y - 2 && y + 1 < height) {
			if(cells[x - 1][y + 1] == player && cells[x + 1][y - 1] == player && cells[x + 2][y - 2] == player) {
				return true;
			}
		}
		if(x + 3 < width && 0 <= y - 3) {
			if(cells[x + 1][y - 1] == player && cells[x + 2][y - 2] == player && cells[x + 3][y - 3] == player) {
				return true;
			}
		}		
		
		
		//vertical
		if(0 <= y - 3) {
			if(cells[x][y - 3] == player && cells[x][y - 2] == player && cells[x][y - 1] == player) {
				return true;
			}
		}
		if(0 <= y - 2 && y + 1 < height) {
			if(cells[x][y - 2] == player && cells[x][y - 1] == player && cells[x][y + 1] == player) {
				return true;
			}
		}
		if(0 <= y - 1 && y + 2 < height) {
			if(cells[x][y - 1] == player && cells[x][y + 1] == player && cells[x][y + 2] == player) {
				return true;
			}
		}
		if(y + 3 < height) {
			if(cells[x][y + 1] == player && cells[x][y + 2] == player && cells[x][y + 3] == player) {
				return true;
			}
		}
		
		//horizontal
		if(0 <= x - 3) {
			if(cells[x - 3][y] == player && cells[x - 2][y] == player && cells[x - 1][y] == player) {
				return true;
			}
		}
		if(0 <= x - 2 && x + 1 < width) {
			if(cells[x - 2][y] == player && cells[x - 1][y] == player && cells[x + 1][y] == player) {
				return true;
			}
		}
		if(0 <= x - 1 && x + 2 < width) {
			if(cells[x - 1][y] == player && cells[x + 1][y] == player && cells[x + 2][y] == player) {
				return true;
			}
		}
		if(x + 3 <  width) {
			if(cells[x + 1][y] == player && cells[x + 2][y] == player && cells[x + 3][y] == player) {
				return true;
			}
		}
		
		return false;
	}
}
