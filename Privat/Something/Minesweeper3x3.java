
public class Minesweeper3x3 {
	public static void main(String[] args) {
		int[] cells = new int [16];
		int[] test1 = new int [100];
		int test = 0;
		
		for (int number0 = 1; number0 <= 5; number0++) {
			for (int number1 = 1; number1 <= 3; number1++) {
				for (int number2 = 1; number2 <= 5; number2++) {
					for (int number3 = 1; number3 <= 3; number3++) {
						for (int number4 = 1; number4 <= 5; number4++) {
							for (int number5 = 1; number5 <= 3; number5++) {
								for (int number6 = 1; number6 <= 5; number6++) {
									for (int number7 = 1; number7 <= 3; number7++) {
										
										test1[test] += 1;
										
										test = 0;
										
										for (int bomb = 0; bomb < Math.pow(2, 16); bomb++) {
											
											for (int j = 0; j < 16; j++) {
												if(cells[j] == 1) {
													cells[j] = 0;
												}
												else {
													cells[j] = 1;
													break;
												}
											}
											
											
											
											int correct = 0;
											
											if(cells[14] + cells[15] + cells[0] + cells[1] + cells[2] == number0) {
												correct++;
											}
											if(cells[1] + cells[2] + cells[3] == number1) {
												correct++;
											}
											if(cells[2] + cells[3] + cells[4] + cells[5] + cells[6] == number2) {
												correct++;
											}
											if(cells[5] + cells[6] + cells[7] == number3) {
												correct++;
											}
											if(cells[6] + cells[7] + cells[8] + cells[9] + cells[10] == number4) {
												correct++;
											}
											if(cells[9] + cells[10] + cells[11] == number5) {
												correct++;
											}
											if(cells[10] + cells[11] + cells[12] + cells[13] + cells[14] == number6) {
												correct++;
											}
											if(cells[13] + cells[14] + cells[15] == number7) {
												correct++;
											}
											
											/**
											if(correct == 8) {
												System.out.println(number0 + " " + number1 + " " + number2 + " " + number3 + " " + number4 + " " + number5 + " " + number6 + " " + number7);
											}
											*/
											
											if(correct == 8) {
												/**
												System.out.println(test);
												System.out.println(cells[0] + " " + cells[1] + " " + cells[2] + " " + cells[3] + " " + cells[4]);
												System.out.println(cells[15] + " " + number0 + " " + number1 + " " + number2 + " " + cells[5]);
												System.out.println(cells[14] + " " + number7 + " " + 'x' + " " + number3 + " " + cells[6]);
												System.out.println(cells[13] + " " + number6 + " " + number5 + " " + number4 + " " + cells[7]);
												System.out.println(cells[12] + " " + cells[11] + " " + cells[10] + " " + cells[9] + " " + cells[8]);
												*/
												test++;
											}
										}
										
									}
								}
							}
						}
					}
				}
			}
		}
		
		for (int i = 0; i < 100; i++) {
			System.out.println(i + " " + test1[i]);
		}

	}
}
