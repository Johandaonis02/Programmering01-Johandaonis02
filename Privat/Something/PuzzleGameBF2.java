import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class PuzzleGameBF2 {
	public static void main(String[] args) throws AWTException, InterruptedException{
		
		Robot robot = new Robot();
		
		int delay = 10;
		
		//start
		robot.mouseMove(640, 270);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(1000);
		
		//010
		for (int i = 0; i < 1000; i++) {
			Thread.sleep(1300);
//			robot.mouseMove(740, 370);
//			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//			Thread.sleep(1000);
			
			int turns = 0;
			int moves = i;
			while(turns < 3) {
				switch(moves % 10) {
				case (0):
					robot.keyPress(KeyEvent.VK_0);
					robot.keyRelease(KeyEvent.VK_0);
					break;
				case (1):
					robot.keyPress(KeyEvent.VK_1);
					robot.keyRelease(KeyEvent.VK_1);
					break;
				case (2):
					robot.keyPress(KeyEvent.VK_2);
					robot.keyRelease(KeyEvent.VK_2);
					break;
				case (3):
					robot.keyPress(KeyEvent.VK_3);
					robot.keyRelease(KeyEvent.VK_3);
					break;
				case (4):
					robot.keyPress(KeyEvent.VK_4);
					robot.keyRelease(KeyEvent.VK_4);
					break;
				case (5):
					robot.keyPress(KeyEvent.VK_5);
					robot.keyRelease(KeyEvent.VK_5);
					break;
				case (6):
					robot.keyPress(KeyEvent.VK_6);
					robot.keyRelease(KeyEvent.VK_6);
					break;
				case (7):
					robot.keyPress(KeyEvent.VK_7);
					robot.keyRelease(KeyEvent.VK_7);
					break;
				case (8):
					robot.keyPress(KeyEvent.VK_8);
					robot.keyRelease(KeyEvent.VK_8);
					break;
				case (9):
					robot.keyPress(KeyEvent.VK_9);
					robot.keyRelease(KeyEvent.VK_9);
					break;
				}
				Thread.sleep(delay);
				turns++;
				moves -= moves % 10;
				moves /= 10;
			}
		}

		
		
	}
}
