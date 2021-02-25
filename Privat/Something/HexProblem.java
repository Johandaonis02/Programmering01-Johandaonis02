
public class HexProblem {
	public static void main(String[] args) {
		int[] groupOfCells = new int [6];
		
		int test = 0;
		
		for (int i = 0; i < Math.pow(2,24); i++) {
			int number = i;
			
			int numberOfPoints = 0;
			
			
			for (int j = 0; j < groupOfCells.length; j++) {
				groupOfCells[j] = 0;
			}
			
			for (int j = 0; j < groupOfCells.length; j++) {
				for (int j2 = 0; j2 < 2; j2++) {
					if(number%2 == 1) {
						numberOfPoints++;
					}
					
					groupOfCells[j] += number%2;
					if(j == 0) {
						groupOfCells[j + 5] += number%2;
					}
					else {
						groupOfCells[j - 1] += number%2;
					}
					number /= 2;
				}
				
				for (int j2 = 0; j2 < 2; j2++) {
					if(number%2 == 1) {
						numberOfPoints++;
					}
					
					groupOfCells[j] += number%2;
					number /= 2;
				}
			}
			
			
//			System.out.print(i + "   ");
//			for (int j = 0; j < groupOfCells.length; j++) {
//				System.out.print(j + " " + groupOfCells[j] + "  ");
//			}
//			System.out.println("");
			
			boolean noIsTheSame = true;
			
			for (int j = 0; j < groupOfCells.length; j++) {
				for (int j2 = j + 1; j2 < groupOfCells.length; j2++) {
					if(groupOfCells[j] == groupOfCells[j2]) {
						noIsTheSame = false;
						j = groupOfCells.length;
						j2 = groupOfCells.length;
					}
				}
			}
			
			for (int j = 0; j < groupOfCells.length; j++) {
				if(groupOfCells[j] == 0) {
					noIsTheSame = false;
				}
			}
			
			
			
			if(noIsTheSame) {
				if(numberOfPoints == 16) {
					System.out.println(i + " :)  " + numberOfPoints);
					test++;
				}
				
			}
			
		}
		
		System.out.println(test);
	}
}
