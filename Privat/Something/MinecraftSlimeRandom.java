import java.util.Random; 

public class MinecraftSlimeRandom{ 

    public static void main(String args[]) 
    { 
    	int a = 1000;
    	int b = 0;
    	int c = 0;
    	
        // the seed from /seed as a 64bit long literal
        long seed = 12345L;
        for (int xPosition = 0; xPosition < a; xPosition++) {
        	for (int zPosition = 0; zPosition < a; zPosition++) {
        		Random rnd = new Random(
                        seed +
                        (int) (xPosition * xPosition * 0x4c1906) +
                        (int) (xPosition * 0x5ac0db) +
                        (int) (zPosition * zPosition) * 0x4307a7L +
                        (int) (zPosition * 0x5f24f) ^ 0x3ad8025fL
                );

                if(rnd.nextInt(10) == 0) {
                	b++;
                }
                else {
                	c++;
                }
//                System.out.println(rnd.nextInt(10) == 0);
    		}
		}
        
        System.out.println(b + " " + c);
        
    } 
}