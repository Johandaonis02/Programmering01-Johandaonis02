import java.util.concurrent.TimeUnit;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
import java.util.Locale;
import java.lang.Math;

public class SandpilesCanvasAWTv6 extends JFrame {
	
	static int[][] cells = new int [1001][1001];
	static int[][] newCells = new int [1001][1001];
	
	private MyCanvas canvas = new MyCanvas();
	
	public static void main(String[] args) {
		SandpilesCanvasAWTv6 fr = new SandpilesCanvasAWTv6();
	}
	
	public SandpilesCanvasAWTv6() {
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
			
			
			//2^30
			cells[500][500] = 100000;
			TestIfTooBig(500, 500, 0);
			
			//boolean bigpile = true;
			
			/*
			while(bigpile) {
				bigpile = false;
				for(int x = 0; x < 1001; x++) {
					for(int y = 0; y < 1001; y++) {
						
						if(cells[x][y] > 3) {
							int stacks = (cells[x][y] / 4);
							
							//System.out.println("test");
							bigpile = true;
							
							cells[x][y] -= 4 * stacks;
//							g.setColor(Color.getHSBColor((float)(1 - cells[x][y] * 0.3), (float)1, (float)0.5));
//							g.fillRect(x, y, 1, 1);
						
							cells[x + 1][y + 1] += stacks;
//							g.setColor(Color.getHSBColor((float)(1 - cells[x + 1][y + 1] * 0.3), (float)1, (float)0.5));
//							g.fillRect(x + 1, y + 1, 1, 1);
							
							cells[x - 1][y + 1] += stacks;
//							g.setColor(Color.getHSBColor((float)(1 - cells[x - 1][y + 1] * 0.3), (float)1, (float)0.5));
//							g.fillRect(x - 1, y + 1, 1, 1);
							
							cells[x + 1][y - 1] += stacks;
//							g.setColor(Color.getHSBColor((float)(1 - cells[x + 1][y - 1] * 0.3), (float)1, (float)0.5));
//							g.fillRect(x + 1, y - 1, 1, 1);
							
							cells[x - 1][y - 1] += stacks;
//							g.setColor(Color.getHSBColor((float)(1 - cells[x - 1][y - 1] * 0.3), (float)1, (float)0.5));
//							g.fillRect(x - 1, y - 1, 1, 1);
							
							
						}
						
					}
				}
			}
			*/
			
			/*
			 * for (int i = 0; bigpile; i++) {
					bigpile = false;
					for(int x = 0; x < 1001; x++) {
						for(int y = 0; y < 1001; y++) {
							if(cells[x][y] > 3) {
								bigpile = true;
								cells[x][y] -= 4;
								for (int x1 = -1; x1 < 2; x1 += 2) {
									for (int y1 = -1; y1 < 2; y1 += 2) {
										if((x + x1) > 0 && (y + y1) > 0) {
											cells[x + x1][y + y1]++;
										}
									}
								}
							}
						}
					}
					
				}
			 */
			
			for(int x = 0; x < 1001; x++) {
				for(int y = 0; y < 1001; y++) {
					
					//g.setColor(new Color(255, 255, 255));
					
					g.setColor(Color.getHSBColor((float)(1 - cells[x][y] * 0.3), (float)1, (float)0.5));
					
					/*
					if(cells[x][y] == 1) {
						g.setColor(new Color(0, 0, 0));
						
					}
					*/
					
					g.fillRect(x, y, 1, 1);
					
				}
			}
			
			System.out.println("done");
		}
	}
	
	public static void TestIfTooBig(int x, int y, int depth) {
		depth++;
		if(depth >= 200) {
			System.out.println(cells[x][y]);
		}
		if(cells[x][y] > 3 && depth < 200) {
			int i = cells[x][y]/4; 
			cells[x][y] -= 4*i;
			for (int x1 = -1; x1 <= 1; x1 += 2) {
				for (int y1 = -1; y1 <= 1; y1 += 2) {
					if((x + x1) >= 0 && (x + x1) < 1001 && (y + y1) >= 0 && (y + y1) < 1001) {
						cells[x + x1][y + y1] += i;
						TestIfTooBig(x + x1, y + y1, depth);
					}
				}
			}
		}
	}
}


