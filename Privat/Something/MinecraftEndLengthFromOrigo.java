
public class MinecraftEndLengthFromOrigo {
	public static void main(String[] args) {
		
		double avgLengthFromPoint = 0;
		double best = 100000000;
		long a = 3000000000L;
		double b = 1/(double)a;
		//1280 - 2816
		
		for (double lengthFromOrigo = 2009; lengthFromOrigo <= 2018; lengthFromOrigo++) {
			avgLengthFromPoint = 0;
			for (long i = 0; i < a; i++) {
				/**
				if(i%1000000000 == 0) {
					System.out.println(i);
				}
				*/
				
				double ang = Math.random()*Math.PI/8;
				double length = 1280 + Math.random() * 1536;
				
				avgLengthFromPoint += b * Math.sqrt( Math.pow((length * Math.cos(ang) - lengthFromOrigo * Math.cos(Math.PI/16)), 2)    +   Math.pow((length * Math.sin(ang) - lengthFromOrigo * Math.sin(Math.PI/16)), 2)) ;
			}
			
			System.out.println(lengthFromOrigo + " " + avgLengthFromPoint);
			
			if(avgLengthFromPoint < best) {
				best = avgLengthFromPoint;
				System.out.println(lengthFromOrigo + " New Best " + best);
			}
		}
		
		System.out.println("Done!");
	}
}
