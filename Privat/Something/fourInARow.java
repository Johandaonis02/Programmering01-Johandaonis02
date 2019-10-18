import java.util.Scanner;

public class fourInARow {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int player=1;
		
		int x1y1=0;
		int x2y1=0;
		int x3y1=0;
		int x4y1=0;
		int x5y1=0;
		int x6y1=0;
		int x7y1=0;
		
		int x1y2=0;
		int x2y2=0;
		int x3y2=0;
		int x4y2=0;
		int x5y2=0;
		int x6y2=0;
		int x7y2=0;
		
		int x1y3=0;
		int x2y3=0;
		int x3y3=0;
		int x4y3=0;
		int x5y3=0;
		int x6y3=0;
		int x7y3=0;
		
		int x1y4=0;
		int x2y4=0;
		int x3y4=0;
		int x4y4=0;
		int x5y4=0;
		int x6y4=0;
		int x7y4=0;
		
		int x1y5=0;
		int x2y5=0;
		int x3y5=0;
		int x4y5=0;
		int x5y5=0;
		int x6y5=0;
		int x7y5=0;
	
		int x1y6=0;
		int x2y6=0;
		int x3y6=0;
		int x4y6=0;
		int x5y6=0;
		int x6y6=0;
		int x7y6=0;
		
		while(1 < 2){
		
			System.out.println(x1y1 + " " + x2y1 + " " + x3y1 + " " + x4y1 + " " + x5y1 + " " + x6y1 + " " + x7y1);
			System.out.println(x1y2 + " " + x2y2 + " " + x3y2 + " " + x4y2 + " " + x5y2 + " " + x6y2 + " " + x7y2);
			System.out.println(x1y3 + " " + x2y3 + " " + x3y3 + " " + x4y3 + " " + x5y3 + " " + x6y3 + " " + x7y3);
			System.out.println(x1y4 + " " + x2y4 + " " + x3y4 + " " + x4y4 + " " + x5y4 + " " + x6y4 + " " + x7y4);
			System.out.println(x1y5 + " " + x2y5 + " " + x3y5 + " " + x4y5 + " " + x5y5 + " " + x6y5 + " " + x7y5);
			System.out.println(x1y6 + " " + x2y6 + " " + x3y6 + " " + x4y6 + " " + x5y6 + " " + x6y6 + " " + x7y6);
			
			int x = input.nextInt();
			
			if(x == 1) {
				if(x1y6==0) {
					x1y6 = player;
				}
				else if(x1y5==0) {
					x1y5 = player;
				}
				else if(x1y4==0) {
					x1y4 = player;
				}
				else if(x1y3==0) {
					x1y3 = player;
				}
				else if(x1y2==0) {
					x1y2 = player;
				}
				else if(x1y1==0) {
					x1y1 = player;
				}
			}
			
			if(x == 2) {
				if(x2y6==0) {
					x2y6 = player;
				}
				else if(x2y5==0) {
					x2y5 = player;
				}
				else if(x2y4==0) {
					x2y4 = player;
				}
				else if(x2y3==0) {
					x2y3 = player;
				}
				else if(x2y2==0) {
					x2y2 = player;
				}
				else if(x2y1==0) {
					x2y1 = player;
				}
			}
			
			if(x == 3) {
				if(x3y6==0) {
					x3y6 = player;
				}
				else if(x3y5==0) {
					x3y5 = player;
				}
				else if(x3y4==0) {
					x3y4 = player;
				}
				else if(x3y3==0) {
					x3y3 = player;
				}
				else if(x3y2==0) {
					x3y2 = player;
				}
				else if(x3y1==0) {
					x3y1 = player;
				}
			}
			
			if(x == 4) {
				if(x4y6==0) {
					x4y6 = player;
				}
				else if(x4y5==0) {
					x4y5 = player;
				}
				else if(x4y4==0) {
					x4y4 = player;
				}
				else if(x4y3==0) {
					x4y3 = player;
				}
				else if(x4y2==0) {
					x4y2 = player;
				}
				else if(x4y1==0) {
					x4y1 = player;
				}
			}
			
			if(x == 5) {
				if(x5y6==0) {
					x5y6 = player;
				}
				else if(x5y5==0) {
					x5y5 = player;
				}
				else if(x5y4==0) {
					x5y4 = player;
				}
				else if(x5y3==0) {
					x5y3 = player;
				}
				else if(x5y2==0) {
					x5y2 = player;
				}
				else if(x5y1==0) {
					x5y1 = player;
				}
			}
			
			if(x == 6) {
				if(x6y6==0) {
					x6y6 = player;
				}
				else if(x6y5==0) {
					x6y5 = player;
				}
				else if(x6y4==0) {
					x6y4 = player;
				}
				else if(x6y3==0) {
					x6y3 = player;
				}
				else if(x6y2==0) {
					x6y2 = player;
				}
				else if(x6y1==0) {
					x6y1 = player;
				}
			}
			
			if(x == 7) {
				if(x7y6==0) {
					x7y6 = player;
				}
				else if(x7y5==0) {
					x7y5 = player;
				}
				else if(x7y4==0) {
					x7y4 = player;
				}
				else if(x7y3==0) {
					x7y3 = player;
				}
				else if(x7y2==0) {
					x7y2 = player;
				}
				else if(x7y1==0) {
					x7y1 = player;
				}
			}
			
			int p = player;
			
			if((p==x1y6&&p==x2y6&&p==x3y6&&p==x4y6)
			||(p==x2y6&&p==x3y6&&p==x4y6&&p==x5y6)
			||(p==x3y6&&p==x4y6&&p==x5y6&&p==x6y6)
			||(p==x4y6&&p==x5y6&&p==x6y6&&p==x7y6)
			
			||(p==x1y5&&p==x2y5&&p==x3y5&&p==x4y5)
			||(p==x2y5&&p==x3y5&&p==x4y5&&p==x5y5)
			||(p==x3y5&&p==x4y5&&p==x5y5&&p==x6y5)
			||(p==x4y5&&p==x5y5&&p==x6y5&&p==x7y5)
			
			||(p==x1y4&&p==x2y4&&p==x3y4&&p==x4y4)
			||(p==x2y4&&p==x3y4&&p==x4y4&&p==x5y4)
			||(p==x3y4&&p==x4y4&&p==x5y4&&p==x6y4)
			||(p==x4y4&&p==x5y4&&p==x6y4&&p==x7y4)

			||(p==x1y3&&p==x2y3&&p==x3y3&&p==x4y3)
			||(p==x2y3&&p==x3y3&&p==x4y3&&p==x5y3)
			||(p==x3y3&&p==x4y3&&p==x5y3&&p==x6y3)
			||(p==x4y3&&p==x5y3&&p==x6y3&&p==x7y3)

			||(p==x1y2&&p==x2y2&&p==x3y2&&p==x4y2)
			||(p==x2y2&&p==x3y2&&p==x4y2&&p==x5y2)
			||(p==x3y2&&p==x4y2&&p==x5y2&&p==x6y2)
			||(p==x4y2&&p==x5y2&&p==x6y2&&p==x7y2)

			||(p==x1y1&&p==x2y1&&p==x3y1&&p==x4y1)
			||(p==x2y1&&p==x3y1&&p==x4y1&&p==x5y1)
			||(p==x3y1&&p==x4y1&&p==x5y1&&p==x6y1)
			||(p==x4y1&&p==x5y1&&p==x6y1&&p==x7y1)
			
			
			||(p==x1y6&&p==x1y5&&p==x1y4&&p==x1y3)
			||(p==x1y5&&p==x1y4&&p==x1y3&&p==x1y2)
			||(p==x1y4&&p==x1y3&&p==x1y2&&p==x1y1)
			
			||(p==x2y6&&p==x2y5&&p==x2y4&&p==x2y3)
			||(p==x2y5&&p==x2y4&&p==x2y3&&p==x2y2)
			||(p==x2y4&&p==x2y3&&p==x2y2&&p==x2y1)
			
			||(p==x3y6&&p==x3y5&&p==x3y4&&p==x3y3)
			||(p==x3y5&&p==x3y4&&p==x3y3&&p==x3y2)
			||(p==x3y4&&p==x3y3&&p==x3y2&&p==x3y1)
			
			||(p==x4y6&&p==x4y5&&p==x4y4&&p==x4y3)
			||(p==x4y5&&p==x4y4&&p==x4y3&&p==x4y2)
			||(p==x4y4&&p==x4y3&&p==x4y2&&p==x4y1)
			
			||(p==x5y6&&p==x5y5&&p==x5y4&&p==x5y3)
			||(p==x5y5&&p==x5y4&&p==x5y3&&p==x5y2)
			||(p==x5y4&&p==x5y3&&p==x5y2&&p==x5y1)
			
			||(p==x6y6&&p==x6y5&&p==x6y4&&p==x6y3)
			||(p==x6y5&&p==x6y4&&p==x6y3&&p==x6y2)
			||(p==x6y4&&p==x6y3&&p==x6y2&&p==x6y1)
			
			||(p==x7y6&&p==x7y5&&p==x7y4&&p==x7y3)
			||(p==x7y5&&p==x7y4&&p==x7y3&&p==x7y2)
			||(p==x7y4&&p==x7y3&&p==x7y2&&p==x7y1)
			
			
			
			||(p==x1y6&&p==x2y5&&p==x3y4&&p==x4y3)
			||(p==x2y6&&p==x3y5&&p==x4y4&&p==x5y3)
			||(p==x3y6&&p==x4y5&&p==x5y4&&p==x6y3)
			||(p==x4y6&&p==x5y5&&p==x6y4&&p==x7y3)
			
			||(p==x1y5&&p==x2y4&&p==x3y3&&p==x4y2)
			||(p==x2y5&&p==x3y4&&p==x4y3&&p==x5y2)
			||(p==x3y5&&p==x4y4&&p==x5y3&&p==x6y2)
			||(p==x4y5&&p==x5y4&&p==x6y3&&p==x7y2)
			
			||(p==x1y4&&p==x2y3&&p==x3y2&&p==x4y1)
			||(p==x2y4&&p==x3y3&&p==x4y2&&p==x5y1)
			||(p==x3y4&&p==x4y3&&p==x5y2&&p==x6y1)
			||(p==x4y4&&p==x5y3&&p==x6y2&&p==x7y1)
			
			
			||(p==x7y6&&p==x6y5&&p==x5y4&&p==x4y3)
			||(p==x6y6&&p==x5y5&&p==x4y4&&p==x3y3)
			||(p==x5y6&&p==x4y5&&p==x3y4&&p==x2y3)
			||(p==x4y6&&p==x3y5&&p==x2y4&&p==x1y3)
			
			||(p==x7y5&&p==x6y4&&p==x5y3&&p==x4y2)
			||(p==x6y5&&p==x5y4&&p==x4y3&&p==x3y2)
			||(p==x5y5&&p==x4y4&&p==x3y3&&p==x2y2)
			||(p==x4y5&&p==x3y4&&p==x2y3&&p==x1y2)
			
			||(p==x7y4&&p==x6y3&&p==x5y2&&p==x4y1)
			||(p==x6y4&&p==x5y3&&p==x4y2&&p==x3y1)
			||(p==x4y4&&p==x3y3&&p==x2y2&&p==x1y1)
			||(p==x5y4&&p==x4y3&&p==x3y2&&p==x2y1)
			) {
				System.out.println("Spelare " + player + " vann!");
			}
			
			if(player == 1) {
				player += 1;
			}
			else {
				player = 1;
			}
		}
	}
}
