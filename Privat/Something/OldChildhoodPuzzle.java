
public class OldChildhoodPuzzle {
//	static int[][] color = {{1,2,4,4},{1,3,1,2},{2,3,1,3},{4,2,4,1},{1,3,4,2},{1,2,4,3},{4,3,2,1},{4,3,1,2},{4,2,4,3}};
//	static char[][] shape = {{'h','b','b','h'},{'b','b','h','h'},{'b','b','h','h'},{'h','b','b','h'},{'b','b','h','h'},{'b','b','h','h'},{'h','b','b','h'},{'b','b','h','h'},{'b','b','h','h'}};
	
	static int[][] color = {{1,2,3,4},{3,4,2,1},{4,2,1,3},{1,4,3,2},{3,1,2,4},{2,3,1,1},{1,2,3,4},{3,4,2,1},{2,1,4,3}};
	static char[][] shape = {{'b','b','b','h'},{'h','b','b','b'},{'h','h','h','b'},{'b','b','h','b'},{'b','h','h','h'},{'b','b','h','h'},{'h','h','b','h'},{'h','b','b','h'},{'h','b','h','h'}};


	static int[] position = new int[9];
	static int[] rotation = new int[9];
	
	public static void main(String[] args) {
		int c = 0;
		while(true) {
			c++;
			if(c%100000000 == 0) {
				System.out.println(c);
			}
			for (int i = 0; i < 9; i++) {
				position[i] = -1;
			}
			for (int i = 0; i < 9; i++) {
				while(true) {
					int positionCandidate = (int)(Math.random()*9);
					if(position[positionCandidate] == -1) {
						position[positionCandidate] = i;
						break;
					}
				}
			}		
			for (int i = 0; i < 9; i++) {
				rotation[i] = (int)(Math.random()*4);
			}
			
			if(t(0,1,1,3) && t(1,1,2,3) && t(3,1,4,3) && t(4,1,5,3) && t(6,1,7,3) && t(7,1,8,3)) {
				if(t(0,2,3,0) && t(1,2,4,0) && t(2,2,5,0) && t(3,2,6,0) && t(4,2,7,0) && t(5,2,8,0)) {
					System.out.println();
					for (int i = 0; i < 9; i++) {
						System.out.println(position[i] + " " + rotation[i]);
					}
				}
			} 
		}
	}
	
	/**
	testIfTwoPFit
	*/
	public static boolean t(int shape1, int rotation1, int shape2, int rotation2) {
		if(color[position[shape1]][(rotation1 + rotation[shape1])%4] != color[position[shape2]][(rotation2 + rotation[shape2])%4]) {
			return false;
		}
		if(shape[position[shape1]][(rotation1 + rotation[shape1])%4] == shape[position[shape2]][(rotation2 + rotation[shape2])%4]) {
			return false;
		}
		return true;
	}
}
