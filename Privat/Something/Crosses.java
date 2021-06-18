
public class Crosses {
	public static void main(String[] args) {
		int[][] cells = new int[7][7];
		
		int c = 0;
		
		for (int i = 0; i < 33554432; i++) {
			//int i = 1708089;
			
			int a = i;
			int b = 0;
			
			for (int row = 0; row < 5; row++) {
				for (int column = 0; column < 5; column++) {
					if(a % 2 == 1) {
						cells[row + 1][column + 1] = 1;
						b++;
						a--;
					}
					else {
						cells[row + 1][column + 1] = 0;
					}
					a /= 2;
				}
			}
			
			boolean bool = true;
			
			for (int row = 0; row < 5; row++) {
				for (int column = 0; column < 5; column++) {
					if(cells[row + 1][column + 1] == 0) {
						int numberOfX = 0;
						for (int rowOff = -1; rowOff <= 1; rowOff++) {
							for (int columnOff = -1; columnOff <= 1; columnOff++) {
								if(((rowOff == 0) || (columnOff == 0)) && !((rowOff == 0) && (columnOff == 0))) {
									if(cells[row + rowOff + 1][column + columnOff + 1] == 1) {
										numberOfX++;
										//System.out.println(numberOfX);
										if(numberOfX > 1) {
											bool = false;
										}
									}
								}
								
							}
						}
						if(numberOfX == 0) {
							bool = false;
						}
					}
				}
			}
			
			if(bool && b == 8) {
				c++;
				for (int row = 0; row < 5; row++) {
					for (int column = 0; column < 5; column++) {
						System.out.print(cells[row + 1][column + 1]);
					}
					System.out.println();
				}
				System.out.println(b);
				
				//System.out.println("test" + i);
			}
			
		}
		System.out.println("Done" + c);
	}
}
