import java.util.Scanner;
import java.util.ArrayList;

// INTE KLAR
public class Everywhere {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<String> cities = new ArrayList<String>();
		
		for (int i = 0; i < 100; i++) {
			boolean newCity = true;
			String nextCity = input.nextLine();
			for (int j = 0; j < cities.size(); j++) {
				if(cities.get(j) == nextCity) {
					newCity = false;
					break;
				}
				if(newCity) {
					cities.add(nextCity);
				}
			}
		}
		System.out.println(cities.size());
		
	}
}
