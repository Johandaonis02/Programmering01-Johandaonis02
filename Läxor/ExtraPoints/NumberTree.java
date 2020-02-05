
import java.util.Scanner;

public class NumberTree {
	public static void main(String[] args) {
		//Den h�r �r lite sv�r att f�rklara men jag ska g�ra mitt b�sta.
		
		//F�rst g�r jag om tr�det till detta:
		//                    1
		//           10              11
		//       100    101       110    111
		//(Skriver det i bin�rt s� det blir l�ttare att se).
		//Alla dessa tal �r Math.pow(2, treeHight + 1) - orginaltalen.
		//Det g�r jag f�r att jag ska kan jag multiplicera med tv� varje g�ng jag g�r ner och 
		//addera ett varje g�ng jag g�r �t h�ger. Sist g�r jag tillbaka till orginalsiffrorna.
		
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
