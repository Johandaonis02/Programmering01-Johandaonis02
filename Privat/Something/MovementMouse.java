import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class MovementMouse {
	public static void main(String[] args) throws AWTException, InterruptedException{
		int x = 500;
		int y = 400;
		Robot robot = new Robot();
		for (int i = 0; i < 5; i++) {
			x += 100;
			robot.mouseMove(x, y);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			Thread.sleep(300);
		}
		
		int a = 0;
		
		a = a + 1;
		a++;
		a -=- 1;     
		a += (a -=-- a);
		
		
		System.out.println(a);
	}
}
