import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_11401_이항계수3 {

	static final long p = 1_000_000_007L;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		System.out.println(nCr(n, k, p));
		
	}

	private static long nCr(int n, int k, long p2) {
		if(k==0) {
			return 1L;
		}
		
		long[] fac = new long[n+1];
		fac[0]=1;
		
//		n!에 해당
		for(int i=1; i<=n; i++) {
			fac[i] = fac[i-1] * i % p;
		}
		
		return(fac[n]* (power(fac[k], p-2, p) % p * power(fac[n-k], p-2, p) % p) % p);
		
		
		
	}

	private static long power(long a, long b, long p) {
		long res = 1L;
		
		while(b>0) {
			if(b%2==1) {
				res = (res * a) % p;
			}
			b = b >> 1;
			a = a * a % p;
		}
		
		return res;
		
	}

}
