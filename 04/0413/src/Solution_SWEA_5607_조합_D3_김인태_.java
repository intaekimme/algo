import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_5607_조합_D3_김인태_ {

	private static int N;
	private static int R;
	private static final long P = 1234567891L;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int tc=1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			
			System.out.println("#"+tc+" "+nCr(N, R, P));
		}
	}	// end of main
	
	static long nCr(int n, int r, long p) {
		if(r==0) return 1L;
		long[] fac = new long[n+1];
		fac[0] = 1;
		
		for(int i=1; i <= n; i++) {
			fac[i] = fac[i-1] * i % p;
		}
		return(fac[n] % p * power(fac[r],p-2,p) % p * power(fac[n-r], p-2,p) % p) % p;
	}

	private static long power(long x, long y, long p) {
		long res = 1L;
		x = x % p;
		while(y>0) {
			if(y%2==1) {
				res = (res * x) % p;
			}
			y = y >> 1;
			x = (x * x) % p;
		}
		return res;
	}

}
