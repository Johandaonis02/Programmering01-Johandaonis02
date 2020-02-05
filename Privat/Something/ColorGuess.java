import java.util.Scanner;

public class ColorGuess {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//rgb Red Green Blue
		String[][][] color = new String[256][256][256];
		int[][][] length = new int[256][256][256];
		
		for (int redLoop = 0; redLoop < 256; redLoop++) {
			for (int greenLoop = 0; greenLoop < 256; greenLoop++) {
				for (int blueLoop = 0; blueLoop < 256; blueLoop++) {
					color[redLoop][greenLoop][blueLoop] = "null";
				}
			}
		}
		
		for (int redLoop = 0; redLoop < 256; redLoop++) {
			for (int greenLoop = 0; greenLoop < 256; greenLoop++) {
				for (int blueLoop = 0; blueLoop < 256; blueLoop++) {
					length[redLoop][greenLoop][blueLoop] = 1000000000;
				}
			}
		}
		
		for (int i = 0; true; i++) {
			int newColorValue = 0;
			
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			
			if(i != 0) {
				for (int redLoop = 0; redLoop < 256; redLoop++) {
					for (int greenLoop = 0; greenLoop < 256; greenLoop++) {
						for (int blueLoop = 0; blueLoop < 256; blueLoop++) {
							if(length[redLoop][greenLoop][blueLoop] > newColorValue) {
								newColorValue = length[redLoop][greenLoop][blueLoop];
								red = redLoop;
								green = greenLoop;
								blue = blueLoop;
							}
						}
					}
				}
			}
			
			int guessValue = 1000000000;
			String guessColor = "";
			
			if(i != 0) {
				for (int redLoop = 0; redLoop < 256; redLoop++) {
					for (int greenLoop = 0; greenLoop < 256; greenLoop++) {
						for (int blueLoop = 0; blueLoop < 256; blueLoop++) {
							
							if(color[redLoop][greenLoop][blueLoop] != "null") {
								if((redLoop - red) * (redLoop - red) + (greenLoop - green) * (greenLoop - green) + (blueLoop - blue) * (blueLoop - blue) < guessValue) {
									guessValue = (redLoop - red) * (redLoop - red) + (greenLoop - green) * (greenLoop - green) + (blueLoop - blue) * (blueLoop - blue);
									guessColor = color[redLoop][greenLoop][blueLoop];
								}
							}
							
						}
					}
				}
			}
			
			System.out.println("red: " + red + ", green: " + green + " and blue: " + blue);
			System.out.println((i / Math.pow(2, 24)) + "%" + " (" + i + " / " + (int)Math.pow(2, 24) + ")");
			if(i != 0) {
				System.out.println("length: " + Math.sqrt(length[red][green][blue]));
				System.out.println("guess: " + guessColor);
			}
			
			color[red][green][blue] = input.nextLine(); 
			
			for (int redLoop = 0; redLoop < 256; redLoop++) {
				for (int greenLoop = 0; greenLoop < 256; greenLoop++) {
					for (int blueLoop = 0; blueLoop < 256; blueLoop++) {
						if(length[redLoop][greenLoop][blueLoop] > (redLoop - red) * (redLoop - red) + (greenLoop - green) * (greenLoop - green) + (blueLoop - blue) * (blueLoop - blue)) {
							length[redLoop][greenLoop][blueLoop] = (redLoop - red) * (redLoop - red) + (greenLoop - green) * (greenLoop - green) + (blueLoop - blue) * (blueLoop - blue);
						}
					}
				}
			}
		}
	}
}
