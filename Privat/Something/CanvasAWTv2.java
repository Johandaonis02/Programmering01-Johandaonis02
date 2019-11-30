import java.awt.*;
import javax.swing.JFrame;

public class CanvasAWTv2 extends JFrame {
	public CanvasAWTv2() {
		JFrame f = new JFrame("Canvas Example");
		f.add(new MyCanvas());
		f.setLayout(null);
		f.setSize(1000, 1000);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new CanvasAWTv2();
	}
}

class MyCanvas extends Canvas{
	public MyCanvas() {
		setBackground(Color.WHITE);
		setSize(1000, 1000);
	}
	public void paint(Graphics g) {
		
		int turns = 10000;
		double a = 1;
		double b = 1;
		
		for(int x = 1; x < 1000; x++) {
			for(int y = 1; y < 1000; y++) {
				double newX = 0;
				double oldY = 0;
				for(int i = 0; i < turns; i++) {
					double newY = oldY;
					oldY = 2 * newY * newX + b;
					newX = oldY * oldY - newX * newX + a;
					if(oldY * oldY + newX * newX > 4) {
						g.setColor(Color.getHSBColor((float)(1 - i * 0.01), (float)1, (float)0.5));
						g.fillRect(x, y, 1, 1);
						break;	
					}
					if(i == turns - 1) {
						g.setColor(Color.BLACK));
						g.fillRect(x, y, 1, 1);
					}
				}
			}
		}
	}
}