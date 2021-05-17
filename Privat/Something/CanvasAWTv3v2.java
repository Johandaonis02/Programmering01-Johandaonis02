
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
import java.util.Locale;
import java.lang.Math;

public class CanvasAWTv3v2 extends JFrame {
	
	private MyCanvas canvas = new MyCanvas();
	
	public static void main(String[] args) {
		CanvasAWTv3v2 fr = new CanvasAWTv3v2();
	}
	
	public CanvasAWTv3v2() {
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
			
			int turns = 1000;
			
			for(int x = 1; x < 1050; x++) {
				for(int y = 1; y < 1050; y++) {
					int color = testColor(x, y, turns);
					
					if(color == -1) {
						g.setColor(new Color(0, 0, 0));
						g.fillRect(x, y, 1, 1);
					}
					else {
						boolean border = false;
						
						for (int xOff = -1; xOff < 1; xOff++) {
							for (int yOff = -1; yOff < 1; yOff++) {
								if(xOff != 0 || yOff != 0) {
									if(testColor(x + xOff, y + yOff, turns) != color) {
										g.setColor(new Color(0, 0, 0));
										g.fillRect(x, y, 1, 1);
										
										border = true;
									}
								}
							}
						}
						
						if(!border) {
							g.setColor(Color.getHSBColor((float)(1 - color * 0.2), (float)1, (float)0.5));
							g.fillRect(x, y, 1, 1);
						}
					}
					
					/**
					double newX = 0;
					double newY = 0;
					for(int i = 2; i <= turns; i++) {
						if((newX * newX + newY * newY < 4)) {
							double newy = newY;
							newY = 2 * newX * newY + ((double)y-500)/250;
							newX = newX * newX - newy * newy + ((double)x-500)/250;
							
							if(i == turns - 1) {
								g.setColor(new Color(0, 0, 0));
								g.fillRect(x, y, 1, 1);
							}
						}
						else {
							g.setColor(Color.getHSBColor((float)(1 - i * 0.2), (float)1, (float)0.5));
							g.fillRect(x, y, 1, 1);
							break;
						}
					}
					*/
				}
			}
		}
	}
	
	public static int testColor(int x, int y, int turns) {
		double newX = 0;
		double newY = 0;
		for(int i = 2; i <= turns; i++) {
			if((newX * newX + newY * newY < 4)) {
				double newy = newY;
				newY = 2 * newX * newY + ((double)y-500)/250;
				newX = newX * newX - newy * newy + ((double)x-500)/250;
				
				if(i == turns - 1) {
					return(-1);
				}
			}
			else {
				return(i);
			}
		}
		
		return(404);
	}
}


