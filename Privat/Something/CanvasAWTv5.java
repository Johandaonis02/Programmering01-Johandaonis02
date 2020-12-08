
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
import java.util.Locale;
import java.lang.Math;

public class CanvasAWTv5 extends JFrame {
	
	private MyCanvas canvas = new MyCanvas();
	
	public static void main(String[] args) {
		CanvasAWTv5 fr = new CanvasAWTv5();
	}
	
	public CanvasAWTv5() {
		setLayout(new BorderLayout());
		setSize(1050, 1050);
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
			boolean[][] black = new boolean [1024][1024];
			
			for(int x = 0; x < 1024; x++) {
				for(int y = 0; y < 1024; y++) {
					black[x][y] = false;
					
				}
			}
			
			for(int x = 1024/4; x < 3*1024/4; x++) {
				for(int y = 1024/4; y < 3*1024/4; y++) {
					black[x][y] = true;
				}
			}
			
			for (int turn = 8; turn >= 3; turn--) {
				if(turn % 4 == 0 || turn % 4 == 3 || turn % 4 == 1) {
					for(int x = 1023; x >= 0; x--) {
						for(int y = 1023; y >= 0; y--) {
							if(turn % 4 == 0) {
								if(y % (2*(int)Math.pow(2, turn)) >= (int)Math.pow(2, turn)) {
									if(x + (int)Math.pow(2, turn) < 1024) {
										black[x + (int)Math.pow(2, turn)][y] = black[x][y];
										black[x][y] = false;
									}
								}
							}
							else if(turn % 4 == 3  || turn % 4 == 1) {
								if(x % (2*(int)Math.pow(2, turn)) >= (int)Math.pow(2, turn)) {
									if(y + (int)Math.pow(2, turn) < 1024) {
										black[x][y + (int)Math.pow(2, turn)] = black[x][y];
										black[x][y] = false;
									}
								}
							}
						}
					}
				}
				else {
					for(int x = 0; x < 1024; x++) {
						for(int y = 0; y < 1024; y++) {
							if(turn % 4 == 2) {
								if(y % (2*(int)Math.pow(2, turn)) >= (int)Math.pow(2, turn)) {
									if(x - (int)Math.pow(2, turn) >= 0) {
										black[x - (int)Math.pow(2, turn)][y] = black[x][y];
										black[x][y] = false;
									}
								}
							}
							else if(turn % 4 == 1) {
								if(x % (2*(int)Math.pow(2, turn)) >= (int)Math.pow(2, turn)) {
									if(y - (int)Math.pow(2, turn) >= 0) {
										black[x][y - (int)Math.pow(2, turn)] = black[x][y];
										black[x][y] = false;
									}
								}
							}
						}
					}
				}
			}
			
			
			for(int x = 0; x < 1024; x++) {
				for(int y = 0; y < 1024; y++) {
					
					g.setColor(new Color(0, 0, 0));
					
					if(black[x][y]) {
						g.fillRect(x, y, 1, 1);
					}
					
				}
			}
			
			System.out.println("done");
		}
	}
}


