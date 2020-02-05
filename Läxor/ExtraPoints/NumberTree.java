
import java.util.Scanner;

public class NumberTree {
	public static void main(String[] args) {
		//Den här är lite svår att förklara men jag ska göra mitt bösta.
		
		//Först gör jag om trädet till detta:
		//                    1
		//           10              11
		//       100    101       110    111
		//(Skriver det i binärt så det blir lättare att se).
		//Alla dessa tal är Math.pow(2, treeHight + 1) - orginaltalen.
		//Det gör jag för att jag ska kan jag multiplicera med två varje gång jag går ner och 
		//addera ett varje gång jag går åt höger. Sist går jag tillbaka till orginalsiffrorna.
		
		Scanner input = new Scanner(System.in);
		
		int treeHight = input.nextInt();
		String commands = input.nextLine();
		int output = 1;
		
		
		for (int i = 1; i < commands.length(); i++) {
			output *= 2;
			if(commands.charAt(i) == 'R') {
				output++;
			}
		}
		System.out.println((int)(Math.pow(2, treeHight + 1) - output));
	}
}
