
public class KortProblemet {
	public static void main(String[] args) {
		double random;
		double numberOfWrongs = 0;
		double fixedWrong = 6;
		double fixedRight = 5;
		double numberOfTrys = 1000000;
		
		for(int i = 0; i < numberOfTrys; i++) {
			double wrong = fixedWrong;
			double right = fixedRight;
			
			while(right > 0) {
				random = Math.random();
				if(random < (right/(right+wrong))) {
					right--;
				}
				else {
					wrong--;
					numberOfWrongs++;
				}
			}
		}
		System.out.println(numberOfWrongs/numberOfTrys);
		System.out.println(fixedWrong*fixedRight/(fixedRight+1));
	}
}
