
public class OldChildhoodPuzzle2 {
	static int[][] color = {{1,2,4,4},{1,3,1,2},{2,3,1,3},{4,2,4,1},{1,3,4,2},{1,2,4,3},{4,3,2,1},{4,3,1,2},{4,2,4,3}};
	static char[][] shape = {{'h','b','b','h'},{'b','b','h','h'},{'b','b','h','h'},{'h','b','b','h'},{'b','b','h','h'},{'b','b','h','h'},{'h','b','b','h'},{'b','b','h','h'},{'b','b','h','h'}};


	static int[] position = new int[9];
	static int[] rotation = new int[9];
	
	public static void main(String[] args) {
		int[][] resultColor = new int[9][4];
		int[][] resultShape = new int[9][4];
		
		
	
	}
	
	public static void nextTest(int[][] resultColor, int[][] resultShape) {
		
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
