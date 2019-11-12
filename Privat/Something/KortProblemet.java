
public class KortProblemet {
	public static void main(String[] args) {
		double random;
		double result = 0;
		int a = 1000000;
		int b = 3;
		for(int i = 0; i < a; i++) {
			for(int j = b; true; j--) {
				random = Math.random();
				if(random < 1. / j) {
					result += b - j;
					break;
				}
			}
		}
		System.out.println(result / a);
	}
}
