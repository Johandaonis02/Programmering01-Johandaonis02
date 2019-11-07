
public class CreatureCardIdleWip {
	public static void main(String[] args) {
		//0: 640 / s 1: +2400%
		int[][] card = new int[4][4];
		int[][] record = new int[4][4];
		int bordMoney = 0;
		int recordMoney = 0;
		int moneyPerSec = 640;
		int multiplier  = 24;
		for(int testAll = 0; testAll < Math.pow(2, 16); testAll++) {
			bordMoney = 0;
			for(int y = 0; y < 4; y++) {
				for(int x = 0; x < 4; x++) {
					card[x][y] = (int)((testAll % Math.pow(2, y * 4 + x + 1)) / Math.pow(2, y * 4 + x));
				}
			}
			
			for(int y = 0; y < 4; y++) {
				for(int x = 0; x < 4; x++) {
					if(card[x][y] == 0) {
						bordMoney += moneyPerSec;
						
						if(y + 1 >= 0 && y + 1 < 4) {
							if(x + 1 >= 0 && x + 1 < 4) {
								if(card[x + 1][y + 1] == 1) {
									bordMoney += moneyPerSec * multiplier;
								}
							}
						}
						
						if(y >= 0 && y < 4) {
							if(x + 1 >= 0 && x + 1 < 4) {
								if(card[x + 1][y] == 1) {
									bordMoney += moneyPerSec * multiplier;
								}
							}
						}
						
						if(y - 1 >= 0 && y - 1 < 4) {
							if(x + 1 >= 0 && x + 1 < 4) {
								if(card[x + 1][y - 1] == 1) {
									bordMoney += moneyPerSec * multiplier;
								}
							}
						}
						
						if(y - 1 >= 0 && y - 1 < 4) {
							if(x >= 0 && x < 4) {
								if(card[x][y - 1] == 1) {
									bordMoney += moneyPerSec * multiplier;
								}
							}
						}
						
						if(y - 1 >= 0 && y - 1 < 4) {
							if(x - 1 >= 0 && x - 1 < 4) {
								if(card[x - 1][y - 1] == 1) {
									bordMoney += moneyPerSec * multiplier;
								}
							}
						}
						
						if(y - 1 >= 0 && y - 1 < 4) {
							if(x - 1 >= 0 && x - 1 < 4) {
								if(card[x - 1][y - 1] == 1) {
									bordMoney += moneyPerSec * multiplier;
								}
							}
						}
						
						if(y - 1 >= 0 && y - 1 < 4) {
							if(x >= 0 && x < 4) {
								if(card[x][y - 1] == 1) {
									bordMoney += moneyPerSec * multiplier;
								}
							}
						}
						
						if(y - 1 >= 0 && y - 1 < 4) {
							if(x + 1 >= 0 && x + 1 < 4) {
								if(card[x + 1][y - 1] == 1) {
									bordMoney += moneyPerSec * multiplier;
								}
							}
						}
						
						if(y >= 0 && y < 4) {
							if(x + 1 >= 0 && x + 1 < 4) {
								if(card[x + 1][y] == 1) {
									bordMoney += moneyPerSec * multiplier;
								}
							}
						}
					}
				}
			}
			
			if(bordMoney > recordMoney) {
				recordMoney = bordMoney;
				for(int y = 0; y < 4; y++) {
					for(int x = 0; x < 4; x++) {
						record[x][y] = card[x][y];
					}
				}
			}
		}	
		for(int y = 0; y < 4; y++) {
			for(int x = 0; x < 4; x++) {
				if(x == 0) {
					System.out.println();
				}
				System.out.print(record[x][y]);
			}
		}
		System.out.println();
		System.out.println();
		System.out.println(recordMoney);
	}
}