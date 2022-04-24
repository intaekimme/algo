import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_3238_이항계수구하기_D5 {

	static long N, R; 
	static int P;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = null;
		for(int tc=1; tc<=TC; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Long.parseLong(st.nextToken());
			R = Long.parseLong(st.nextToken());
			P = Integer.parseInt(st.nextToken());
			
			if (R == 0 || N == R) {
				sb.append(1).append("\n");
				continue;
			} else if (R == 1 || R == N - 1) {
				sb.append(N % P).append("\n");
				continue;
			}
			
			long[] fac = new long[P+1];
			fac[0]=1;
			for(int i=1; i<=P; i++) {
				fac[i] = (fac[i-1] * i) % P;
			}
			
			long ret = 1;
			if (N < P) {
				ret = (ret * fac[(int) N]) % P;
				ret = (ret * power(fac[(int) (N - R)], P - 2, P)) % P;
				ret = (ret * power(fac[(int) R], P - 2, P)) % P;
			} else {
				// 뤼카의 정리
				while (N > 0 || R > 0) {
					long a = N % P;
					long b = R % P;

					if (b > a) {
						ret = 0;
						break;
					}

					// 페르마의 소정리
					ret = (ret * fac[(int) a]) % P;
					ret = (ret * power(fac[(int) (a - b)], P - 2, P)) % P;
					ret = (ret * power(fac[(int) b], P - 2, P)) % P;

					N /= P;
					R /= P;
				}
			}
			
			sb.append(ret % P).append("\n");
		}
		System.out.println(sb);
	}
	
	private static long power(long a, int x, long p) {
		if(x==0) {
			return 1;
		}
		
		long half = power(a, x / 2, p);
		long calc = (half * half) % p;
		if (x % 2 == 0) {
			return calc;
		} else {
			return (calc * a) % p;
		}
	}
	

}
