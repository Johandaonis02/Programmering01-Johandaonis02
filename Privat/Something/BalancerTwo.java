
public class BalancerTwo {
	public static void main(String[] args) {
		int[] balancersNeeded = new int[1024];
		int[] balancersNeededOld = new int[1024];
		
		balancersNeeded[2] = 1;
		balancersNeededOld[2] = 1;
		
		for (int i = 3; i < balancersNeeded.length; i++) {
			balancersNeeded[i] = 10000;
			balancersNeededOld[i] = 10000;
		}
		
		boolean exit = false;
		
		while(!exit) {

			for (int i = 2; i < balancersNeeded.length; i++) {
				for (int j = 2; j < balancersNeeded.length; j++) {
					if(j*i < 1024) {
						if(balancersNeeded[i*j] >= j * balancersNeeded[i] + i * balancersNeeded[j]) {
							balancersNeeded[i*j] = j * balancersNeeded[i] + i * balancersNeeded[j];
							for (int k = i*j - 1; k > 2 ; k--) {
								if(balancersNeeded[k] >= j * balancersNeeded[i] + i * balancersNeeded[j] - (int)((i*j - k)/2)) {
									balancersNeeded[k] = j * balancersNeeded[i] + i * balancersNeeded[j] - (int)((i*j - k)/2);
								}
							}
						}
					}
				}
			}
			
			exit = true;
			for (int i = 3; i < balancersNeeded.length; i++) {
				if(balancersNeeded[i] != balancersNeededOld[i]) {
					exit = false;
				}
				balancersNeededOld[i] = balancersNeeded[i];
			}
		}
		
//		for (int i = 2; i < 510; i++) {
//			if(balancersNeeded[2 * i] != 2 * balancersNeeded[i] + i) {
//				System.out.println("n:" + i + " f(n):" + balancersNeeded[i] + " 2n:" + 2 * i + " 2f(n):" + balancersNeeded[2 * i]);
//			}
//		}
		
		
		System.out.println(0 + " " + 0);
		System.out.println(1 + " " + 0);
		for (int i = 2; i < 256; i++) {
			System.out.println(i + " " + balancersNeeded[i]);
		}
	}
}
