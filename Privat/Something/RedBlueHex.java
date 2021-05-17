
public class RedBlueHex {
	public static void main(String[] args) {
		int[][] CellNumber = new int[7][7];
		char[][] color = new char[7][7];
		int[][] place = new int[7][7];
		
		int b = 0;
		
		for (int row = 0; row <= 3; row++) {
			for (int column = 0; column < row + 4; column++) {
				place[row][column] = b;
				b++;
			}
		}
		for (int row = 4; row <= 6; row++) {
			for (int column = 0; column < 10 - row; column++) {
				place[row][column] = b;
				b++;
			}
		}
		
		
		
		
		
		
		int best = 0;
		
		//Math.pow(2, 37)
		//25769803766L 
		for (long i = 4294967296L; i < Math.pow(2, 37); i++) {
			if(i %  Math.pow(2, 30) == 0) {
				System.out.println(i);
			}
			
			for (int row = 0; row < 7; row++) {
				for (int column = 0; column < 7; column++) {
					color[row][column] = 'c';
					CellNumber[row][column] = 0;
				}
			}
			
			
			long a = i;
			
			for (int row = 0; row <= 3; row++) {
				for (int column = 0; column < row + 4; column++) {
					if(a % 2 == 1) {
						color[row][column] = 'b';
					}
					else {
						color[row][column] = 'r';
					}
					a /= 2;
				}
			}
			for (int row = 4; row <= 6; row++) {
				for (int column = 0; column < 10 - row; column++) {
					if(a % 2 == 1) {
						color[row][column] = 'b';
					}
					else {
						color[row][column] = 'r';
					}
					a /= 2;
				}
			}
			
			for (int row = 0; row < 7; row++) {
				for (int column = 0; column < 7; column++) {
					if(color[row][column] == 'b') {
						CellNumber[row][column] = 2;
						
						
						
						for (int rowOff = -1; rowOff <= 1; rowOff++) {
							for (int columnOff = -1; columnOff <= 1; columnOff++) {
								if(!(columnOff == 1 && (rowOff == -1 || rowOff == 1))) {
									if(row + rowOff >= 0 && row + rowOff < 7 && column + columnOff >= 0 && column + columnOff < 7) {
										
										if(color[row + rowOff][column + columnOff] == 'r') {
											//System.out.println(row + " " + rowOff + " " + column + " " + columnOff);
											CellNumber[row][column] += 1;
										}
										
									}
								}
							}
						}	
					}
				}
			}

			
			
//			System.out.println(i);
//			for (int row = 0; row < 7; row++) {
//				for (int column = 0; column < 7; column++) {
//					System.out.print(CellNumber[row][column] + " ");
//					//System.out.print(color[row][column] + " " + CellNumber[row][column] + " ");
//				}
//				System.out.println();
//			}
			
			
			int sum = 0;
			
			for (int row = 0; row < 7; row++) {
				for (int column = 0; column < 7; column++) {
					sum += CellNumber[row][column];
				}
			}
			
			if(sum > best) {
				System.out.println(sum);
				best = sum;
				
				for (int row = 0; row < 7; row++) {
					for (int column = 0; column < 7; column++) {
						System.out.print(CellNumber[row][column] + " ");
						//System.out.print(color[row][column] + " " + CellNumber[row][column] + " ");
					}
					System.out.println();
				}
				System.out.println();
				
			}
			
//			System.out.println("test");
//			for (int row = 0; row < 7; row++) {
//				for (int column = 0; column < 7; column++) {
//					System.out.print(CellNumber[row][column] + " ");
//					//System.out.print(color[row][column] + " " + CellNumber[row][column] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
		}
		System.out.println("done");
	}
}



/*
 * 
public class RedBlueHex {
	public static void main(String[] args) {
		int[][] CellNumber = new int[7][7];
		char[][] color = new char[7][7];
		int[][] place = new int[7][7];
		
		int b = 0;
		
		for (int row = 0; row <= 3; row++) {
			for (int column = 0; column < row + 4; column++) {
				place[row][column] = b;
				b++;
			}
		}
		for (int row = 4; row <= 6; row++) {
			for (int column = 0; column < 10 - row; column++) {
				place[row][column] = b;
				b++;
			}
		}
		
		
		
		
		
		
		int best = 0;
		
		//Math.pow(2, 37)
		for (long i = 0; i < Math.pow(2, 37); i++) {
			if(i %  Math.pow(2, 30) == 0) {
				System.out.println(i);
			}
			
			for (int row = 0; row < 7; row++) {
				for (int column = 0; column < 7; column++) {
					color[row][column] = 'c';
					CellNumber[row][column] = 0;
				}
			}
			
			
			long a = i;
			
			for (int row = 0; row <= 3; row++) {
				for (int column = 0; column < row + 4; column++) {
					if(a % 2 == 1) {
						color[row][column] = 'b';
					}
					else {
						color[row][column] = 'r';
					}
					a /= 2;
				}
			}
			for (int row = 4; row <= 6; row++) {
				for (int column = 0; column < 10 - row; column++) {
					if(a % 2 == 1) {
						color[row][column] = 'b';
					}
					else {
						color[row][column] = 'r';
					}
					a /= 2;
				}
			}
			
			boolean cont = true;
			
			for (int row = 1; row < 4; row++) {
				for (int column = 1; column < row + 4; column++) {
					if(color[row-1][column-1] == 'r' && color[row-1][column] == 'r' &&  
					   color[row][column-1] == 'r' && color[row][column] == 'r' && color[row][column+1] == 'r' &&
					   color[row+1][column-1] == 'r' && color[row+1][column] == 'r') 
					{
						long d = i;
						i -= (i % Math.pow(2, place[row - 1][column -1]));
						i += Math.pow(2, place[row - 1][column -1]) + 1;
						
						System.out.println(place[row - 1][column -1]);
						
						row = 100000;
						cont = false;
						break;
					}
				}
			}
			for (int row = 4; row < 6 && cont; row++) {
				for (int column = 1; column < 8 - row; column++) {
					if(color[row-1][column-1] == 'r' && color[row-1][column] == 'r' &&  
							   color[row][column-1] == 'r' && color[row][column] == 'r' && color[row][column+1] == 'r' &&
							   color[row+1][column-1] == 'r' && color[row+1][column] == 'r') 
							{
								long d = i;
								i -= (i % Math.pow(2, place[row - 1][column -1]));
								i += Math.pow(2, place[row - 1][column -1]) + 1;
								
								System.out.println(place[row - 1][column -1]);
								
								row = 100000;
								cont = false;
								break;
							}
				}
			}
			
			while(cont) {
				for (int row = 0; row < 7; row++) {
					for (int column = 0; column < 7; column++) {
						if(color[row][column] == 'b') {
							CellNumber[row][column] = 2;
							
							
							
							for (int rowOff = -1; rowOff <= 1; rowOff++) {
								for (int columnOff = -1; columnOff <= 1; columnOff++) {
									if(!(columnOff == 1 && (rowOff == -1 || rowOff == 1))) {
										if(row + rowOff >= 0 && row + rowOff < 7 && column + columnOff >= 0 && column + columnOff < 7) {
											
											if(color[row + rowOff][column + columnOff] == 'r') {
												//System.out.println(row + " " + rowOff + " " + column + " " + columnOff);
												CellNumber[row][column] += 1;
											}
											
										}
									}
								}
							}
							
							
						}
						
							
							
							//System.out.print(color[row][column] + " ");
					}
				}
			
			
			
	//			System.out.println(i);
	//			for (int row = 0; row < 7; row++) {
	//				for (int column = 0; column < 7; column++) {
	//					System.out.print(CellNumber[row][column] + " ");
	//					//System.out.print(color[row][column] + " " + CellNumber[row][column] + " ");
	//				}
	//				System.out.println();
	//			}
				
				
				int sum = 0;
				
				for (int row = 0; row < 7; row++) {
					for (int column = 0; column < 7; column++) {
						sum += CellNumber[row][column];
					}
				}
				
				if(sum > best) {
					System.out.println(sum);
					best = sum;
					
					for (int row = 0; row < 7; row++) {
						for (int column = 0; column < 7; column++) {
							System.out.print(CellNumber[row][column] + " ");
							//System.out.print(color[row][column] + " " + CellNumber[row][column] + " ");
						}
						System.out.println();
					}
					System.out.println();
					
				}
				
				System.out.println("test");
				for (int row = 0; row < 7; row++) {
					for (int column = 0; column < 7; column++) {
						System.out.print(CellNumber[row][column] + " ");
						//System.out.print(color[row][column] + " " + CellNumber[row][column] + " ");
					}
					System.out.println();
				}
				System.out.println();
				
	//			int b = 1;
	//			for (int j = 0; j < 10000000; j++) {
	//				b += (int)Math.sqrt(j);
	//			}
	//			System.out.println(b);
				
				int c = 0;
				for (int j = 0; j < 100000000; j++) {
					c += Math.sqrt(j);
				}
				System.out.println(c);
			}
		}
		
		System.out.println("done");
	}
}

 */