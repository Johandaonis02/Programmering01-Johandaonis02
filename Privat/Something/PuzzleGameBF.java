import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class PuzzleGameBF {
	public static void main(String[] args) throws AWTException, InterruptedException{
		
		Robot robot = new Robot();
		
		int delay = 100;
		
		//start
		robot.mouseMove(1000, 500);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(500);
		
		
		for (int i = 0; i < Math.pow(4, 3); i++) {
			Thread.sleep(20);
			robot.mouseMove(1240, 370);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			Thread.sleep(10);
			
			int turns = 0;
			int moves = i;
			while(turns < 3) {
				switch(moves % 4) {
				case (0):
					//up
					robot.keyPress(KeyEvent.VK_W);
					robot.keyRelease(KeyEvent.VK_W);
					
//					robot.mouseMove(1000, 500);
//					robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//					robot.mouseMove(1000, 400);
//					robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				case (1):
					//right
					robot.keyPress(KeyEvent.VK_D);
					robot.keyRelease(KeyEvent.VK_D);
					
//					robot.mouseMove(1000, 500);
//					robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//					robot.mouseMove(1100, 500);
//					robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				case (2):
					//down
					robot.keyPress(KeyEvent.VK_S);
					robot.keyRelease(KeyEvent.VK_S);
					
//					robot.mouseMove(1000, 500);
//					robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//					robot.mouseMove(1000, 600);
//					robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				case (3):
					//left
					robot.keyPress(KeyEvent.VK_A);
					robot.keyRelease(KeyEvent.VK_A);
					
//					robot.mouseMove(1000, 500);
//					robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//					robot.mouseMove(900, 500);
//					robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				}
				Thread.sleep(delay);
				turns++;
				moves -= moves % 4;
				moves /= 4;
			}
		}

		
		
	}
}
