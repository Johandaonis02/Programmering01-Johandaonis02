
public class MatteFusk {
	public static void main(String[] args) {
		int a = 10000;
		long[][] box = new long[a][a];
		int max = 0;
		
		for (int k = 2; k < 10000; k++) {
			int b = 0;
			
			for (int i = 0; i < a; i++) {
				box[i][0] = 1;
				box[i][i] = 1;
			}
			for (int i = 0; i < a-1; i++) {
				for (int j = 0; j < a-1; j++) {
					box[i + 1][j + 1] = box[i][j] + box[i][j+1];
					if(box[i+1][j+1] == k) {
						b++;
					}
				}
			}
			System.out.println(k + ": " + b);

			if(b >= max) {
				max = b;
				//System.out.println(k + ": " + max);
				
			}
		}
		
	} 
}
