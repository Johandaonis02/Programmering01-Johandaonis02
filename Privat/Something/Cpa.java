import java.awt.*;
import javax.swing.JFrame;

public class Cpa extends JFrame {
	public Cpa() {
		JFrame f = new JFrame("Canvas Example");
		f.add(new MyCpa());
		f.setLayout(null);
		f.setSize(560, 560);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Cpa();
	}
}

class MyCpa extends Canvas{
	public MyCpa() {
		setBackground(Color.ORANGE);
		setSize(560, 560);
	}
	public void paint(Graphics g) {
		int a = 0;
		int b = (int)Math.pow(2,a);	
		
		for(int x = 0; x < 512; x += b) {
			for(int y = 0; y < 512; y += b) {
				if(Color(x, y)) {
					g.setColor(Color.BLACK);
					g.fillRect(x + 10, y + 10, b, b);
				}
				else {
					g.setColor(Color.WHITE);
					g.fillRect(x + 10, y + 10, b, b);
				}
			}
		}
	}
	
	public static boolean Color(int x,int y) {
		if(x == 0 && y == 0){
			return true;
		}
		else {
			if((int)(Math.log(x) / Math.log(2)) > (int)(Math.log(y) / Math.log(2))) {
				return (Color(x - (int)Math.pow(2, (int)(Math.log(x) / Math.log(2))) ,y));
			}
			if((int)(Math.log(x) / Math.log(2)) < (int)(Math.log(y) / Math.log(2))) {
				return (Color(x,y - (int)Math.pow(2,(int)(Math.log(y) / Math.log(2)))));
			}
			else {
				return (!Color(x - (int)Math.pow(2,(int)(Math.log(x) / Math.log(2))) ,y - (int)Math.pow(2,(int)(Math.log(y) / Math.log(2)))));
			}
		}
	}
}

