
public class Balancer {
	public static void main(String[] args) {
		int[] balancersNeeded = new int[1024];
		int[] balancersNeededOld = new int[1024];
		
		balancersNeeded[2] = 1;
		balancersNeededOld[2] = 1;
		
		for (int i = 3; i < balancersNeeded.length; i++) {
			balancersNeeded[i] = 10000;
			balancersNeededOld[i] = 10000;
		}
		
		
		int a = 0;
		boolean exit = false;
		
		while(!exit) {
			System.out.println(a);
			a++;
			for (int i = 2; i < balancersNeeded.length; i++) {
				for (int j = 2; j < balancersNeeded.length; j++) {
					if(j*i < 1024) {
						if(balancersNeeded[i*j] >= j * balancersNeeded[i] + i * balancersNeeded[j]) {
							balancersNeeded[i*j] = j * balancersNeeded[i] + i * balancersNeeded[j];
							for (int k = i*j - 1; k > 2 ; k--) {
								if(balancersNeeded[k] >= j * balancersNeeded[i] + i * balancersNeeded[j]) {
									balancersNeeded[k] = j * balancersNeeded[i] + i * balancersNeeded[j];
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
		
		for (int i = 2; i < 128; i++) {
			System.out.println(i + " " + balancersNeeded[i]);
		}
	}
}
