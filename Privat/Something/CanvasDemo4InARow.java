import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
import java.util.Locale;
import java.lang.Math;

public class CanvasDemo4InARow extends JFrame {
	
	private MyCanvas canvas = new MyCanvas();
	
	public static void main(String[] args) {
		CanvasDemo4InARow fr = new CanvasDemo4InARow();
	}
	
	public CanvasDemo4InARow() {
		setLayout(new BorderLayout());
		setSize(1000, 1000);
		setTitle("4 in a row");
		add("Center", canvas);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Another way to center the screen.
		setLocationRelativeTo(null);
		
		setVisible(true);
	}
	
	private class MyCanvas extends Canvas {
		
		@Override
		public void paint(Graphics g) {
			Scanner input = new Scanner(System.in);
			int width = 7;
			int height = 6;
			int side = 50;
			double spaceBetween = 0.2;
			int length = (int)((getWidth() - 2 * side) / (width + spaceBetween * (width - 1)));
			int[][] cells = new int [width][height];
			int player = 1;
			boolean hasWon = false;
			int numberOfPlayers = 2;
			boolean botActivate = false;
			int turn = 1;
			
			for(int x = 0; x < width; x++) {
				for(int y = 0; y < height; y++) {
					cells[x][y] = 0;
				}
			}
			
			System.out.println("Bot?");
			String askIfBot = input.nextLine();
			if(askIfBot.toLowerCase().equals("yes")) {
				botActivate = true;
			}
			
			for(hasWon = false; !hasWon && turn <= height * width; turn++)  {
				if(player == 1) {
					g.setColor(new Color(0xf0f0f0));
					g.fillRect(0,0, getWidth(), 50);
					g.setColor(Color.black);
					g.drawString("red's turn", (int)(0.5 * getWidth() - 30), 20);
					System.out.println("red's turn");
				}
				else {
					if(botActivate == false) {
						g.setColor(new Color(0xf0f0f0));
						g.fillRect(0,0, getWidth(), 50);
						g.setColor(Color.black);
						g.drawString("blue's turn", (int)(0.5 * getWidth() - 30), 20);
						System.out.println("blue's turn");
					}
				}
				
				for(int x = 0; x < width; x++) {
					for(int y = 0; y < height; y++) {
						if(cells[x][y] == 0) {
							g.drawOval(50 + (int)(((1 + spaceBetween) * length) * x), 50 + (int)(((1 + spaceBetween) * length) * y), length, length);
						}
						else if(cells[x][y] == 1) {
							g.setColor(Color.red);
							g.fillOval(50 + (int)(((1 + spaceBetween) * length) * x), 50 + (int)(((1 + spaceBetween) * length) * y), length, length);
							g.setColor(Color.black);
						}
						else if(cells[x][y] == 2) {
							g.setColor(Color.blue);
							g.fillOval(50 + (int)(((1 + spaceBetween) * length) * x), 50 + (int)(((1 + spaceBetween) * length) * y), length, length);
							g.setColor(Color.black);
						}
					}
				}
				
				int newCellX = 0;
				int newCellY = height - 1;
				
				while(true) {
					if(player == 2 && botActivate == true) {
						newCellX = (int)(Math.random() * width);
					}
					else {
						newCellX = input.nextInt() - 1;
					}
					if(0 <= newCellX && newCellX < width) {
						if(cells[newCellX][0] == 0) {
							break;
						}
						else {
							g.setColor(new Color(0xf0f0f0));
							g.fillRect(0,0, getWidth(), 50);
							g.setColor(Color.black);
							g.drawString("This column is full", (int)(0.5 * getWidth() - 50), 20);
							System.out.println("This column is full");
						}
					}
					else {
						g.setColor(new Color(0xf0f0f0));
						g.fillRect(0,0, getWidth(), 50);
						g.setColor(Color.black);
						g.drawString(newCellX + 1 + " isn't a valid number. Pick a number between 1 and " + width, (int)(0.5 * getWidth() - 50), 20);
						System.out.println(newCellX + 1 + " isn't a valid number. Pick a number between 1 and " + width);
					}
				}
				
				while(newCellY >= 0) {
					if(cells[newCellX][newCellY] == 0) {
						cells[newCellX][newCellY] = player;
						break;
					}
					newCellY--;
				}
				
				if(turn >= numberOfPlayers * 3 + 1) {
					//diagonals
					for(int j = -1; j <= 1; j += 2) {
						for(int i = -3; i <= 3; i++) {
							if(0 <= newCellX + i &&  newCellX + i + 3 <= width - 1 && 0 <= newCellY + i * j && newCellY + 3 + i * j <= height - 1) {
								if((cells[newCellX + i][newCellY + i * j] == player) && (cells[newCellX + i + 1][newCellY + 1 +  i * j] == player) && (cells[newCellX + i + 2][newCellY + 2 + i * j] == player) && (cells[newCellX + i + 3][newCellY + 3 + i * j] == player)) {
									hasWon = true;
									break;
								}
							}
						}
					}
					//vertical
					for(int i = -3; i <= 3; i++) {
						if(0 <= newCellY + i && newCellY + i + 3 <= height - 1) {
							if(cells[newCellX][newCellY + i] == player && cells[newCellX][newCellY + i + 1] == player && cells[newCellX][newCellY + i + 2] == player && cells[newCellX][newCellY + i + 3] == player) {
								hasWon = true;
								break;
							}
						}
					}
					//horizontal
					for(int i = -3; i <= 3; i++) {
						if(0 <= newCellX + i && newCellX + i + 3 <= width - 1) {
							if(cells[newCellX + i][newCellY] == player && cells[newCellX + i + 1][newCellY] == player && cells[newCellX + i + 2][newCellY] == player && cells[newCellX + i + 3][newCellY] == player) {
								hasWon = true;
								break;
							}
						}
					}
				}
				if(hasWon == false) {
					player = (player % numberOfPlayers) + 1;
				}
			}
			
			for(int x = 0; x < width; x++) {
				for(int y = 0; y < height; y++) {
					if(cells[x][y] == 0) {
						g.drawOval(50 + (int)(((1 + spaceBetween) * length) * x), 50 + (int)(((1 + spaceBetween) * length) * y), length, length);
					}
					else if(cells[x][y] == 1) {
						g.setColor(Color.red);
						g.fillOval(50 + (int)(((1 + spaceBetween) * length) * x), 50 + (int)(((1 + spaceBetween) * length) * y), length, length);
						g.setColor(Color.black);
					}
					else if(cells[x][y] == 2) {
						g.setColor(Color.blue);
						g.fillOval(50 + (int)(((1 + spaceBetween) * length) * x), 50 + (int)(((1 + spaceBetween) * length) * y), length, length);
						g.setColor(Color.black);
					}
				}
			}
			
			if(hasWon == true) {
				if(player == 1) {
					g.setColor(new Color(0xf0f0f0));
					g.fillRect(0,0, getWidth(), 50);
					g.setColor(Color.black);
					g.drawString("The red player won", (int)(0.5 * getWidth() - 55), 20);
					System.out.println("The red player won");
				}
				else if(player == 2) {
					if(botActivate == false) {
						g.setColor(new Color(0xf0f0f0));
						g.fillRect(0,0, getWidth(), 50);
						g.setColor(Color.black);
						g.drawString("The blue player won", (int)(0.5 * getWidth() - 55), 20);
						System.out.println("The blue player won");
					}
					else {
						g.setColor(new Color(0xf0f0f0));
						g.fillRect(0,0, getWidth(), 50);
						g.setColor(Color.black);
						g.drawString("The bot won", (int)(0.5 * getWidth() - 20), 20);
						System.out.println("The bot won");
					}
				}
			}
			else {
				g.setColor(new Color(0xf0f0f0));
				g.fillRect(0,0, getWidth(), 50);
				g.setColor(Color.black);
				g.drawString("Its a draw", (int)(0.5 * getWidth() - 20), 20);
				System.out.println("Its a draw");
			}
		}
	}
}

