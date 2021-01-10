
public class HidingCatPuzzle {
	public static void main(String[] args) {
		int nights = 6;
		int boxes = 5;
		boolean[] box = new boolean [boxes];
		boolean[] boxNew = new boolean [boxes];
		
		
		for (int sequence = 0; sequence < Math.pow(boxes, nights); sequence++) {
			
			int sequenceNumber = sequence;
			
			for (int i = 0; i < box.length; i++) {
				box[i] = true;
			}
			
			for (int night = 0; night < nights; night++) {
				
//				if(sequence == 438) {
//					System.out.println("test1 " + sequenceNumber + " " + night);
//					for (int i = 0; i < box.length; i++) {
//						if(box[i]) {
//							System.out.print(1 + " ");
//						}
//						else {
//							System.out.print(0 + " ");
//						}
//					}
//					System.out.println();
//				}
				
				
				box[sequenceNumber % boxes] = false;
				sequenceNumber -= sequenceNumber % boxes;
				sequenceNumber /= boxes;
				
//				if(sequence == 438) {
//					System.out.println("test2 " + sequenceNumber + " " + night);
//					for (int i = 0; i < box.length; i++) {
//						if(box[i]) {
//							System.out.print(1 + " ");
//						}
//						else {
//							System.out.print(0 + " ");
//						}
//					}
//					System.out.println();
//				}
				
				
				for (int i = 0; i < boxNew.length; i++) {
					boxNew[i] = false;
				}
				
				
				for (int b = 0; b < box.length; b++) {
					if(box[b]) {
						if(b - 1 >= 0) {
							boxNew[b - 1] = true;
						}
						if(b + 1 < boxes) {
							boxNew[b + 1] = true;
						}
					}
				}
				
				for (int i = 0; i < boxNew.length; i++) {
					box[i] = boxNew[i];
				}
				
			}
			
			boolean allCatsAreGone = true;
			for (int i = 0; i < box.length; i++) {
				if(box[i] == true) {
					allCatsAreGone = false;
					break;
				}
			}
			
			if(allCatsAreGone) {
				sequenceNumber = sequence;
				
				System.out.print(sequenceNumber);
				
				for (int night = 0; night < nights; night++) {
					System.out.print(" " + sequenceNumber % boxes);
					sequenceNumber -= sequenceNumber % boxes;
					sequenceNumber /= boxes;
				}
				
				System.out.println();
				}
		}
	}
}
