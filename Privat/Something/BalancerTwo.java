
public class BalancerTwo {
	public static void main(String[] args) {
		
		int[] balancersNeeded = new int[1000];
		int[] balancersNeededOld = new int[1000];
		
		balancersNeeded[2] = 1;
		balancersNeededOld[2] = 1;
		
		for (int i = 3; i < balancersNeeded.length; i++) {
			balancersNeeded[i] = 2147483647;
			balancersNeededOld[i] = 2147483647;
		}
		
		boolean exit = false;
		
		while(!exit) {

			for (int i = 2; i < balancersNeeded.length; i++) {
				for (int j = 2; j < balancersNeeded.length; j++) {
					if(j*i < 999) {
						if(balancersNeeded[i*j] >= j * balancersNeeded[i] + i * balancersNeeded[j]) {
							for (int k = i*j; k > 2 ; k--) {
								if(balancersNeeded[k] >= j * balancersNeeded[i] + i * balancersNeeded[j] - loopingNumber(i*j - k)) {
									balancersNeeded[k] = j * balancersNeeded[i] + i * balancersNeeded[j] - loopingNumber(i*j - k);
//									if(k == 825) {
//										System.out.println(i + " " + j + " " + balancersNeeded[k]);
//									}
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
		
		//examples of f(2n) != 2f(n) + n 
//		for (int i = 2; i < 9999; i++) {
//			if(balancersNeeded[2 * i] != 2 * balancersNeeded[i] + i) {
//				System.out.println("n:" + i + " f(n):" + balancersNeeded[i] + " 2n:" + 2 * i + " 2f(n):" + balancersNeeded[2 * i]);
//			}
//		}
		
		System.out.println(0 + " " + 0);
		System.out.println(1 + " " + 0);
		for (int i = 2; i < 1000; i++) {
			System.out.println(i + " " + balancersNeeded[i]);
		}
	}
	
	public static int loopingNumber(int diff) {
		int returnNumber = 0;
		
		for (int i = 1; i <= Math.ceil(Math.log(diff)/Math.log(2)); i++) {
			returnNumber += Math.floor(diff / Math.pow(2, i));
		}
		
		return returnNumber;
	}
}
