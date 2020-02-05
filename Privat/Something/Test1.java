import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int f = 1;
		while(f>0) {
			if(n >= 1000) {
				n -= 3;
				f--;
			}
			else {
				n += 5;
				f++;
			}
		}
		System.out.println(n);
	}
	
	
}