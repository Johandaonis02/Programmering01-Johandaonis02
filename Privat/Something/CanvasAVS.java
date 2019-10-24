
import java.awt.*;
import javax.swing.*;

public class CanvasAVS extends JFrame {
	
	private MyCanvas canvas = new MyCanvas();
	
	public static void main(String[] args) {
		CanvasAVS fr = new CanvasAVS();
	}
	
	public CanvasAVS() {
		setLayout(new BorderLayout());
		setSize(1000, 1000);
		setTitle("4 in a row");
		add("Center", canvas);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Another way to center the screen.
		setLocationRelativeTo(null);
		
		setVisible(true);
		
		while(true) {
			canvas.repaint();
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private class MyCanvas extends Canvas {
		double radius = 50;
		double a = 0.1;
		double vx = 2;
		double vy = 0;
		double x = 450;
		double y = 450;
		@Override
		public void paint(Graphics g) {
			
			g.drawString("Pick a number", 450, 20);
			
			g.drawOval((int)x, (int)y, 2 * (int)radius, 2 * (int)radius);
			vy += a;
			x += vx;
			y += vy;
			
			if(x >  getWidth() - radius) {
				x = 2*getWidth() - x - 2 * radius;
				vx = -vx;
			}
			else if(x - radius < 0) {
				x = -x + radius;
				vx = -vx;
			}
			if(y > getHeight() - radius) {
				y = 2*getHeight() - y - 2 * radius;
				vy = -vy;
			}
			else if(y - radius < 0) {
				y = - y + radius;
				vy = -vy;
			}
			invalidate();
		}
	}
}

