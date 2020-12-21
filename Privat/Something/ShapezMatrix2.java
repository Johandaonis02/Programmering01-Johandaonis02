import javax.swing.text.StyledEditorKit.ForegroundAction;

public class ShapezMatrix2 {
	public static void main(String[] args) {
		int dimensions = 5;
		int matrixIndex = 0;
		int numberOfMatrix = 0;
		
		boolean[][][] matrix = new boolean [dimensions][dimensions][10000000];
		boolean[][] tempMatrix = new boolean [dimensions][dimensions];
		
		for (double i = 0; i < Math.pow(2, dimensions*dimensions - 1); i += 2) {
			
//			if(i % 20000000 == 0) {
//				System.out.println(100 * i / Math.pow(2, dimensions*dimensions) + "%");
//			}
				
			double tempI = i;
			
			for (int x = 0; x < dimensions; x++) {
				for (int y = 0; y < dimensions; y++) {
					if(tempI % 2 == 1) {
						tempMatrix[x][y] = true;
						
						tempI -= 1;
					}
					else {
						tempMatrix[x][y] = false;
					}
					tempI /= 2;
				}
			}
			

			
//				if(i % 1 == 0) {
//					for (int row = 0; row < dimensions; row++) {
//						for (int column = 0; column < dimensions; column++) {
//							if(tempMatrix[row][column]) {
//								System.out.print(1 + " ");
//							}
//							else {
//								System.out.print(0 + " ");
//							}
//						}
//						System.out.println();
//					}
//				}
				
			
			
			if(twoPerRow(tempMatrix, dimensions)) {
				if(twoPerColumn(tempMatrix, dimensions)) {
					if(testMainDiagonal(tempMatrix, dimensions)) {
						
						for (int row = 0; row < dimensions; row++) {
							for (int column = 0; column < dimensions; column++) {
								matrix[row][column][matrixIndex] = tempMatrix[row][column];
							}
						}
						matrixIndex++;
						numberOfMatrix = matrixIndex;
						System.out.println(matrixIndex);
					}
				}
			}
		}
		
		for (int j = 0; j < numberOfMatrix; j++) {
			for (int row = 0; row < dimensions; row++) {
				for (int column = 0; column < dimensions; column++) {
					if(matrix[row][column][j]) {
						System.out.print(1 + " ");
					}
					else {
						System.out.print(0 + " ");
					}
				}
				System.out.println();
			}
			System.out.println();
		}
			
		boolean tempValue;
		boolean isTheSame = true;
		int numberOfFalseMatrix = 0;
		
		for (int matrix1 = 0; matrix1 < numberOfMatrix; matrix1++) {
			
			for (int i = 0; i < dimensions; i++) {
				for (int j = i + 1; j < dimensions; j++) {
					
					
					for (int row = 0; row < dimensions; row++) {
						
						tempValue = matrix[row][i][matrix1];
						matrix[row][i][matrix1] = matrix[row][j][matrix1];
						matrix[row][j][matrix1] = tempValue;
					}
					for (int column = 0; column < dimensions; column++) {
						
						tempValue = matrix[i][column][matrix1];
						matrix[i][column][matrix1] = matrix[j][column][matrix1];
						matrix[j][column][matrix1] = tempValue;
					}
					
					
					boolean someMatrixIsTheSame = false;
					
					for (int matrix2 = matrix1 + 1; matrix2 < numberOfMatrix; matrix2++) {
						isTheSame = true;
						
						for (int row = 0; row < dimensions; row++) {
							for (int column = 0; column < dimensions; column++) {
								if(matrix[row][column][matrix1] != matrix[row][column][matrix2]) {
									isTheSame = false;
								}
							}
						}
						
						if(isTheSame) {
							someMatrixIsTheSame = true;
							//System.out.println(matrix1 + " " + matrix2);
							break;
						}
					}
					
					for (int row = 0; row < dimensions; row++) {
						
						tempValue = matrix[row][i][matrix1];
						matrix[row][i][matrix1] = matrix[row][j][matrix1];
						matrix[row][j][matrix1] = tempValue;
					}
					for (int column = 0; column < dimensions; column++) {
						
						tempValue = matrix[i][column][matrix1];
						matrix[i][column][matrix1] = matrix[j][column][matrix1];
						matrix[j][column][matrix1] = tempValue;
					}
					
					if(someMatrixIsTheSame) {
						i = dimensions;
						j = dimensions;
						numberOfFalseMatrix++;
					}
				}
			}
		}
		System.out.println(numberOfMatrix);
		System.out.println(numberOfFalseMatrix);
		System.out.println(numberOfMatrix - numberOfFalseMatrix);
		
	}
	
	public static boolean testMainDiagonal(boolean matrix[][], int dimensions) {
		for (int i = 0; i < dimensions; i++) {
			if(matrix[i][i]) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean twoPerColumn(boolean matrix[][], int dimensions) {
		for (int column = 0; column < dimensions; column++) {
			
			int NumberPerColumn = 0;
			for (int row = 0; row < dimensions; row++) {
				if(matrix[row][column] == true) {
					NumberPerColumn++;
				}
			}
			
			if(NumberPerColumn != 2) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean twoPerRow(boolean matrix[][], int dimensions) {
		for (int row = 0; row < dimensions; row++) {
			
			int NumberPerRow = 0;
			for (int column = 0; column < dimensions; column++) {
				if(matrix[row][column] == true) {
					NumberPerRow++;
				}
			}
			
			if(NumberPerRow != 2) {
				return false;
			}
		}
		
		return true;
	}
}
