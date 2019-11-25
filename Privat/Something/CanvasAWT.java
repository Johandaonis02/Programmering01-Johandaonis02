import java.awt.*;
import javax.swing.JFrame;

public class CanvasAWT extends JFrame {
	public CanvasAWT() {
		JFrame f = new JFrame("Canvas Example");
		f.add(new MyCanvas());
		f.setLayout(null);
		f.setSize(1000, 1000);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new CanvasAWT();
	}
}

class MyCanvas extends Canvas{
	public MyCanvas() {
		setBackground(Color.WHITE);
		setSize(1000, 1000);
	}
	public void paint(Graphics g) {
		double zoom = 0.000000001;
		double lookStartX = -29.01002;
		double lookStartY = -24.44;
		int turns = 5000;
		double zExponent = 2;
		
		for(int x = 1; x < 1000; x++) {
			for(int y = 1; y < 1000; y++) {
				double newX = 0;
				double newY = 0;
				for(int i = 2; i <= turns; i++) {
					if((newX * newX + newY * newY < 4)) {
						double newy = newY;
						newY = 2 * newX * newY + (y * zoom * 0.4 + lookStartY * 2) / 100;
						newX = newX * newX - newy * newy + (x * zoom * 0.4 + lookStartX * 2) / 100;
						
//						newY = 3 * newX * newX * newY - newY * newY * newY + (y * zoom * 0.4 + lookStartY * 2) / 100;
//						newX = newX * newX * newX - 3 * newX * newy * newy + (x * zoom * 0.4 + lookStartX * 2) / 100;
						//(a + bi)^3 = a^3 + 3a^2bi - 3ab^2 - b^3i
						
//						if(newX != 0) {
//						newY = Math.pow(newy * newy + newX * newX, zExponent / 2) * Math.sin(zExponent * Math.atan(newy / newX)) + (y * zoom * 0.4 + lookStartY * 2) / 100;
//						newX = Math.pow(newy * newy + newX * newX, zExponent / 2) * Math.cos(zExponent * Math.atan(newy / newX)) + (x * zoom * 0.4 + lookStartX * 2) / 100;
//						}
//						else {
//							if(y > 0) {
//								newY = Math.pow(newy * newy + newX * newX, zExponent / 2) * Math.sin(zExponent * Math.PI / 2) + (y * zoom * 0.4 + lookStartY * 2) / 100;
//								newX = Math.pow(newy * newy + newX * newX, zExponent / 2) * Math.cos(zExponent * Math.PI / 2) + (x * zoom * 0.4 + lookStartX * 2) / 100;
//							}
//							else {
//								newY = Math.pow(newy * newy + newX * newX, zExponent / 2) * Math.sin(zExponent * 3 * Math.PI / 2) + (y * zoom * 0.4 + lookStartY * 2) / 100;
//								newX = Math.pow(newy * newy + newX * newX, zExponent / 2) * Math.cos(zExponent * 3 * Math.PI / 2) + (x * zoom * 0.4 + lookStartX * 2) / 100;
//							}
//						}
						if(i == turns - 1) {
							g.setColor(new Color(0, 0, 0));
							g.fillRect(x, y, 1, 1);
						}
					}
					else {
						g.setColor(Color.getHSBColor((float)(1 - i * 0.01), (float)1, (float)0.5));
//						if(i % 3 == 0) {g.setColor(new Color(0xf0f0f0));}
//						else if(i % 3 == 1) {g.setColor(new Color(0xd0f0f0));}
//						else if(i % 3 == 2) {g.setColor(new Color(0xb0f0f0));}
						g.fillRect(x, y, 1, 1);
						break;
					}
				}
			}
		}
	}
}