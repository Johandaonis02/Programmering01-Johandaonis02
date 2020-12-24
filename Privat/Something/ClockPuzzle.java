
public class ClockPuzzle {
	public static void main(String[] args) {
		
		boolean[] beenAt = new boolean[16];
		int[] hourNumbers = {3,4,7,1,3,3,1,3,6,7,5,3,8,2,8,3};
		char[] walk = new char[16];
		
		for (int i = 0; i < beenAt.length; i++) {
			beenAt[i] = false;
		}
		
		beenAt[1] = true;
		int pos = 1;
		
		int depth = 0;
		
		walk[depth + 1] = 'R';
		clock(pos, depth, walk.clone(), hourNumbers.clone(), beenAt.clone());
		walk[depth + 1] = 'L';
		clock(pos, depth, walk.clone(), hourNumbers.clone(), beenAt.clone());
	}
	
	public static void clock(int pos, int depth, char walk[], int hourNumbers[], boolean beenAt[]) {
		depth++;
		
		if(walk[depth] == 'R') {
			pos = (pos + hourNumbers[pos]) % 16;
		}
		else {
			if(pos - hourNumbers[pos] < 0) {
				pos = pos - hourNumbers[pos] + 16;
			}
			else {
				pos = pos - hourNumbers[pos];
			}
		}
		
		if(!beenAt[pos]) {
			
			beenAt[pos] = true;
			
			if(depth == 15) {
				//System.out.println("done!");
				for (int i = 0; i < walk.length; i++) {
					System.out.print(walk[i]);
				}
				System.out.println();
			}
			else {
				walk[depth + 1] = 'R';
				clock(pos, depth, walk.clone(), hourNumbers.clone(), beenAt.clone());
				walk[depth + 1] = 'L';
				clock(pos, depth, walk.clone(), hourNumbers.clone(), beenAt.clone());
			}
		}
	}
}
