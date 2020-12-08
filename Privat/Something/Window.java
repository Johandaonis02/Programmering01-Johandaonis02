
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import java.util.ArrayList;

public class Window extends JFrame implements MouseListener {
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createGUI();
			}
		});
	}
	public static void createGUI() {
		Window canvas = new Window();
	}
	
	private MyCanvas m_canvas = new MyCanvas();
	public Window() {
		setLayout(new BorderLayout());
		setSize(1000, 1000);
		setTitle("ball");
		add("Center", m_canvas);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Another way to center the screen.
		setLocationRelativeTo(null);
		
		setVisible(true);
		
		//addMouseListener(this);
		
		while(true) {
			m_canvas.repaint();
			try {
				Thread.sleep(16);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	private class Ball{
		double radius = 50;
		double a = 0.1;
		double vx = 2;
		double vy = 0;
		double x = 500;
		double y = 500;
	}
	
	private class MyCanvas extends Canvas {
		ArrayList<Ball> balls = new ArrayList<Ball>();
		
		public MyCanvas() {
			balls.add(new Ball());
			//balls.add(new Ball());
			//balls.get(1).y = 100;
		}
		
		@Override
		public void paint(Graphics g) {
			for(int i = 0; i < balls.size(); i++) {
				Ball ball = balls.get(i);
				ball.x += ball.vx;
				ball.y += ball.vy;
				ball.vy += ball.a;
//				if(ball.y < 0) {
//					ball.vy = -ball.vy;
//				}
//				else if(ball.y > getHeight() - 1 * ball.radius - 50) {
//					ball.vy = -ball.vy;
//				}
//				if(ball.x < 0) {
//					ball.vx = -ball.vx;
//				}
//				else if(ball.x > getHeight() - 1 * ball.radius - 22) {
//					ball.vx = -ball.vx;
//				}
				g.setColor(Color.BLACK);
				g.drawOval((int)ball.x, (int)ball.y, 2 * (int)ball.radius, 2 * (int)ball.radius);
			}
			g.setColor(Color.BLACK);
			g.drawOval((int)500, (int)500, 2 * (int)100, 2 * (int)100);
			
			invalidate();
		}
	}

//	@Override
//	public void mouseClicked(MouseEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println("hej");
//	}
//
//	@Override
//	public void mouseEntered(MouseEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println("hej");		
//	}
//
//	@Override
//	public void mouseExited(MouseEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println("hej");
//	}
//
//	@Override
//	public void mousePressed(MouseEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println("hej");
//	}
//
//	@Override
//	public void mouseReleased(MouseEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println("hej");
//	}
}

