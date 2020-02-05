import java.util.Scanner;

public class Speedlimit {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int numberOfSpeeds = input.nextInt();
		int sumOfSpeeds = 0;
		int time = 0;
		while(numberOfSpeeds != -1) {
			sumOfSpeeds = 0;
			//Denna for loop loopar genom alla rader och adderar upp alla sträckor 
			for (int i = 0; i < numberOfSpeeds; i++) {
				int miles = input.nextInt();
				//timeBefore sparar tiden till senare
				int timeBefore = time;
				//timeBetween är tiden emellan tiderna de mäter hastigheten
				int timeBetween = (input.nextInt() - time);
				//sumOfSpeeds är summan av alla sträckor
				sumOfSpeeds += (miles * timeBetween);
				time = timeBefore + timeBetween;
			}
			System.out.println(sumOfSpeeds + " miles");
			numberOfSpeeds = input.nextInt();
			time = 0;
		}
	}
}
