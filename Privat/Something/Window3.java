
import java.util.concurrent.TimeUnit;

import java.util.Scanner;
import java.awt.*;
import javax.swing.*;

import Window.Ball;

import java.util.Locale;
import java.lang.Math;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.ArrayList;

public class Window3 extends JFrame {
	
	private MyCanvas canvas = new MyCanvas();
	
	public static void main(String[] args) {
		Window3 fr = new Window3();
	}
	
	public Window3() {
		setLayout(new BorderLayout());
		setSize(1000, 1000);
		setTitle("Window");
		add("Center", canvas);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Another way to center the screen.
		setLocationRelativeTo(null);
		
		setVisible(true);
	}
	
	private class Ball{
		double lastX = 0;
		double lastY = 0;
		double radius = 50;
		double vx = 2;
		double vy = 0;
		double x = 500;
		double y = 500;
		double mass = 0.001;
	}
	
	private class MyCanvas extends Canvas {
		
		@Override
		public void paint(Graphics g) {
			ArrayList<Ball> balls = new ArrayList<Ball>();
			
			for (int i = 0; i < 4; i++) {
				balls.add(new Ball());	
			}	
			
			for (int i = 0; i < balls.size(); i++) {
				balls.get(i).vx = (Math.random()-0.5)*6;
				balls.get(i).vy = (Math.random()-0.5)*6;
				balls.get(i).x = Math.random()*(getHeight() - 100);
				balls.get(i).y = Math.random()*(getHeight() - 100);
			}
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, 1000, 1000);
			while(true) {				
			
				for (int i = 0; i < balls.size(); i++) {
					Ball ball = balls.get(i);
					ball.x += ball.vx;
					ball.y += ball.vy;
					
					for (int j = 0; j < balls.size(); j++) {
						double a = Math.sqrt(Math.pow((balls.get(j).x - ball.x),2.) + Math.pow((balls.get(j).x - ball.x),2.)) * balls.get(j).mass;
						
						ball.vx += a * Math.cos(Math.atan2(balls.get(j).y - ball.y, balls.get(j).x - ball.x));
						ball.vy += a * Math.sin(Math.atan2(balls.get(j).y - ball.y, balls.get(j).x - ball.x));
					}
							
					
					
					if(ball.y < 0) {
					ball.vy = -ball.vy;
					}
					else if(ball.y > getHeight() - 1 * ball.radius - 50) {
						ball.vy = -ball.vy;
					}
					if(ball.x < 0) {
						ball.vx = -ball.vx;
					}
					else if(ball.x > getHeight() - 1 * ball.radius - 22) {
						ball.vx = -ball.vx;
					}
					
					for (int j = 0; j < balls.size(); j++) {
						for (int k = 0; k < balls.size() && k != j; k++) {
							if(Math.pow((balls.get(j).y - balls.get(k).y),2) + Math.pow((balls.get(j).x - balls.get(k).x),2) < Math.pow(balls.get(j).radius + balls.get(j).radius,2)) {
								balls.get(j).vx = -balls.get(j).vx;
								balls.get(j).vy = -balls.get(j).vy;
								balls.get(k).vx = -balls.get(k).vx;
								balls.get(k).vy = -balls.get(k).vy;
							}
						}
					}
					
					g.setColor(Color.WHITE);
					g.drawOval((int)ball.lastX, (int)ball.lastY, 2 * (int)ball.radius, 2 * (int)ball.radius);
					
					g.setColor(Color.BLACK);
					g.drawOval((int)ball.x, (int)ball.y, 2 * (int)ball.radius, 2 * (int)ball.radius);
					
					ball.lastX = ball.x;
					ball.lastY = ball.y;
					
					try{
					    Thread.sleep(16);
					}
					catch(InterruptedException ex){
					    Thread.currentThread().interrupt();
					}
				}
			}
		}
	}
}


