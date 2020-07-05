
public class birthday {
	static boolean[] dagar = new boolean[365];
	
	
	public static void main(String[] args) {
		double tru = 0;
		double tot = 0;
		double test = 5000000;
		//double per = 3240;
		
		for (int per = 3230; per < 3240; per++) {
			for (int i = 0; i < test; i++) {
				for (int j = 0; j < dagar.length; j++) {
					dagar[j] = false;
				}
				for (int j = 0; j < per; j++) {
					dagar[(int)(Math.random()*365)] = true;
				}
				if(testDagar()) {
					tru++;
				}
			}
			System.out.println(per + ": " + tru / test);
			tru = 0;
		}
			
	}
	
	public static boolean testDagar() {
		for (int i = 0; i < dagar.length; i++) {
			if(dagar[i] == false) {
				return false;
			}
		}
		return true;
	}
}
