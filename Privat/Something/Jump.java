
public class Jump {
	public static void main(String[] args) {
		double s = 10;
		double numberOfJumps = 0; 
		
		for (int i = 0; i < 1000000; i++) {
			double place = 0;
			
			while(place < s) {
				numberOfJumps++;
				place += Math.floor((s - place) * Math.random()) + 1;
//				System.out.println("Place:" + place);
			}
		}
		System.out.println(numberOfJumps / 1000000);
	}
}
