import javax.print.DocFlavor.INPUT_STREAM;

public class IWantToTry {
	
	public static void main(String[] args){
		int k = 0;
		int a = 0;
		int i;
		for(i = 2; i<=10; i++) {
			for(int j = 2; j<i; j++) {
				if(i % j == 0) {
					//System.out.println(i + " not prime" );
					k = 1;
					break;
				}
			}
			if(k == 0) {
				System.out.println(i + " prime" );
				a++;
			}
		k = 0;	
		}
	System.out.println(a + " under " + (i-1));
	
	}
}