
public class FindBrak {
	public static void main(String[] args) {
		double number = 4.33012701892;
		double diff = 1000000000;
		double t = 1;
		double n = 1;
		
		for (double tloop = 1; tloop < 1000; tloop++) {
			for (double nloop = 1; nloop < 1000; nloop++) {
				if(diff > Math.abs(number - tloop/nloop)) {
					t = tloop;
					n = nloop;
					diff = Math.abs(number - tloop/nloop);
				}
			}
		}
		System.out.println(t + " / " + n);
	}	
}
