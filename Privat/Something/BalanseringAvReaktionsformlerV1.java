
public class BalanseringAvReaktionsformlerV1 {
	public static void main(String[] args) {
		//X(C_c0O_o0H_h0) + Y(C_c1O_o1H_h1) = Z(C_c2O_o2H_h2) + W(C_c3O_o3H_h3)
	
		int[] c = {1,0,1,0};
		int[] o = {2,1,0,2};
		int[] h = {0,2,3,0};
		
		int y = ((h[3] * c[0] - c[3] * h[0]) * (o[2] * h[0] - h[2] * o[0]) - (h[3] * o[0] - o[3] * h[0]) * (c[2] * h[0] - h[2] * c[0]));
		int w = ((o[1] * h[0] - h[1] * o[0]) * (c[2] * h[0] - h[2] * c[0]) - (o[1] * h[0] - h[1] * o[0]) * (c[2] * h[0] - h[2] * c[0]));
		
		int z = w * (h[3] * o[0] - o[3] * h[0]) + y * (o[1] * h[0] - h[1] * o[0]);
		
		System.out.println(y + " = " + z + " " + w);
		
		y *= (o[2] * h[0] - h[2] * o[0]);
		w *= (o[2] * h[0] - h[2] * o[0]);
		
		int x = z * c[2] + w * c[3] - y * c[1];
		
		System.out.println(x + " " + y + " = " + z + " " + w);
		
		y *= c[0];
		w *= c[0];
		z *= c[0];
		
		System.out.println(x + " " + y + " = " + z + " " + w);
		if(x < 0) {
			x = -x;
			y = -y;
			z = -z;
			w = -w;
		}
		
		for (int i = 1; i < 1000; i++) {
			if(x % i == 0 && y % i == 0 && z % i == 0 && w % i == 0) {
				x /= i;
				y /= i;
				z /= i;
				w /= i;
			}
		}
		
		System.out.println(x + " " + y + " = " + z + " " + w);
		
//		System.out.println(x * c[0] + y * c[1] + " " + z * c[2] + w * c[3]);
//		System.out.println(x * o[0] + y * o[1] + " " + z * o[2] + w * o[3]);
//		System.out.println(x * h[0] + y * h[1] + " " + z * h[2] + w * h[3]);
		
	}
}
