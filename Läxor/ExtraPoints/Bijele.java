import java.util.Scanner;

public class Bijele {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//Hur m�nga det ska vara
		int chessPieces[] = {1, 1, 2, 2, 2, 8};
		for (int i = 0; i < chessPieces.length; i++) {
			//j�mf�r s� man f�r skillnaden
			System.out.print(chessPieces[i] - input.nextInt() + " ");
		}
	}
}
