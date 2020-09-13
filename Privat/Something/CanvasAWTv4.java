
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
import java.util.Locale;
import java.lang.Math;

public class CanvasAWTv4 extends JFrame {
	
	private MyCanvas canvas = new MyCanvas();
	
	public static void main(String[] args) {
		CanvasAWTv4 fr = new CanvasAWTv4();
	}
	
	public CanvasAWTv4() {
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
			double zoom = 6.25;
			double lookStartX = -100;
			double lookStartY = -100;
			int turns = 1000;
			
			for(int x = 1; x < 1000; x++) {
				for(int y = 1; y < 1000; y++) {
					double newX = 0;
					double newY = 0;
					for(int i = 2; i <= turns; i++) {
						if((newX * newX + newY * newY < 4)) {
							double newy = newY;
							newY = 2 * newX * newY + (y * zoom * 0.4 + lookStartY * 2) / 100;
							newX = newX * newX - newy * newy + (x * zoom * 0.4 + lookStartX * 2) / 100;
							
							if(i == turns - 1) {
								g.setColor(new Color(0, 0, 0));
								for (int x2 = 0; x2 < 7; x2++) {
									for (int y2 = 0; y2 < 7; y2++) {
										g.fillRect((int)(6.25 * x + x2), (int)(6.25 * y + y2), 1, 1);
									}
								}
							}
						}
						//test
						else {
							if(i > 0) {
								g.setColor(Color.getHSBColor((float)(1 - (i % 3) * 0.4), (float)1, (float)0.5));
								
							}
							else {
								if(i == -1) {
									g.setColor(Color.getHSBColor((float)(1 - i * 0.4), (float)1, (float)0.5));
								}
								else {
								g.setColor(new Color(0, 0, 0));
								}
							}
							
							for (int x2 = 0; x2 < 7; x2++) {
								for (int y2 = 0; y2 < 7; y2++) {
									g.fillRect((int)(6.25 * x + x2), (int)(6.25 * y + y2), 1, 1);
								}
							}
							break;
						}
					}
				}
			}
		}
	}
}


