
public class BedrockFinder {
	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				getBedrock();
			}
		}
	}
	
	public static int getBedrock(int x, int y, int z, long a, long b)
	{
		if (y == 0) return 1;
		if (y < 0 || y > 4) return 0;
		int precomp_ind = precompChunkIndCalcNormal(x & 15, y - 1, z & 15, 0);
		return (rand5(rawSeedFromChunk(x >> 4, z >> 4), a[precomp_ind], b[precomp_ind]) >= y) ? 1 : 0;
	}
	
	public static int precompChunkIndCalcNormal(int x, int y, int z, int nether)
	{
		return ((z * 16 + x) * (nether == 1 ? 8 : 4) + ((nether == 1 ? 7 : 3) - y));
	}
	
	public static long rawSeedFromChunk(int x, int z)
	{
		return (((long)x * 341873128712L + (long)z * 132897987541L) ^ 0x5DEECE66DL) & (((long)1 << 48) - 1);
	}
}
