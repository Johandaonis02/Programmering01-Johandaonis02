
public class OldChildhoodProblemV3 {
	static int[] position = new int[9];
	static int[] rotation = new int[9];
	
	static int[][] color = {{1,2,3,4},{3,4,2,1},{4,2,1,3},{1,4,3,2},{3,1,2,4},{2,3,1,1},{1,2,3,4},{3,4,2,1},{2,1,4,3}};
	static char[][] shape = {{'b','b','b','h'},{'h','b','b','b'},{'h','h','h','b'},{'b','b','h','b'},{'b','h','h','h'},{'b','b','h','h'},{'h','h','b','h'},{'h','b','b','h'},{'h','b','h','h'}};
	static int c = 0;
	public static void main(String[] args) {
		for (int i = 0; i < 9; i++) {
			position[i] = -1;
			rotation[i] = -1;
		}
		
		for (int card = 0; card < 9; card++) {
			for (int rotation1 = 0; rotation1 < 4; rotation1++) {
				position[0] = card;
				rotation[0] = rotation1;
				addCard(1);
			}
		}
		System.out.println("done");
	}
	
	public static void addCard(int depth) {
		//c++;
		//System.out.println(c);
		if(depth == 9) {
			System.out.println();
			for (int i = 0; i < 9; i++) {
				System.out.println(position[i] + " " + rotation[i]);
			}			
		}
		else {
			for (int card = 0; card < 9; card++) {
				for (int rotation1 = 0; rotation1 < 4; rotation1++) {
					boolean a = false;
					for (int cards = 0; cards < depth; cards++) {
						if(position[cards] == card) {
							a = true;
						}
					}
					if(a) {
						break;
					}
					
					position[depth] = card;
					rotation[depth] = rotation1;
					
					if(t(0,1,1,3) && t(1,1,2,3) && t(3,1,4,3) && t(4,1,5,3) && t(6,1,7,3) && t(7,1,8,3)) {
						if(t(0,2,3,0) && t(1,2,4,0) && t(2,2,5,0) && t(3,2,6,0) && t(4,2,7,0) && t(5,2,8,0)) {
							addCard(depth + 1);
						}
					}

					position[depth] = -1;
					rotation[depth] = -1;
				}
			}	 
		}
	}
	
	public static boolean t(int shape1, int rotation1, int shape2, int rotation2) {
		if(position[shape1] == -1 || position[shape2] == -1 || position[rotation1] == -1 || position[rotation2] == -1) {
			return true;
		}
		
		if(color[position[shape1]][(rotation1 + rotation[shape1])%4] != color[position[shape2]][(rotation2 + rotation[shape2])%4]) {
			return false;
		}
		if(shape[position[shape1]][(rotation1 + rotation[shape1])%4] == shape[position[shape2]][(rotation2 + rotation[shape2])%4]) {
			return false;
		}
		return true;
	}
}
