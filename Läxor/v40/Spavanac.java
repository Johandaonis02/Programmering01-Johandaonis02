import java.util.Scanner;

public class Spavanac {
	public static void main(String[] args) {
			
		Scanner input = new Scanner(System.in);
		int hours = input.nextInt();
		int minutes = input.nextInt();
		minutes = minutes-45;
		if(minutes<0) {
			hours--;
			minutes = 60 + minutes; 
		}
		if(hours<0) {
			hours = 24 + hours; 
		}
		System.out.println(hours);
		System.out.println(minutes);
	}	
}
