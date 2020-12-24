
public class Tan {
	public static void main(String[] args) {
		double best = 0;
		for (int i = 1; i < 1000000; i++) {
			if(Math.abs(Math.tan(i)) > best) {
//				if(i < Math.tan(i)) {
					System.out.println(i + " " + Math.tan(i));
//				}
				best = Math.abs(Math.tan(i));
			}
		}
	}
}
