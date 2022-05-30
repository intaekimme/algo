import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * DP, 페르마 소정리를 사용하려 했으나 n과r이 충분히 작을 경우엔 O(nr)의 시간과 공간 복잡도로 계산이 가능하다.
 * n		n-1			n-1
 * r	=	r-1		+	r
 * 을 이용해 계산 가능
 *
 * 처음에 long을 썼으나 범위를 벗어나기에 BigInteger 사용
 * @author kit938639
 *
 */
public class Main_BOJ_2407_조합_S3_92ms {

	private static int N, M;
	private static BigInteger[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new BigInteger[101][101];
		Arrays.fill(map[1], 0, 101, BigInteger.valueOf(1));
		for(int i=1; i<101; i++) {
			map[i][0] = BigInteger.valueOf(1);
		}
		
//		for(int i=0; i<101; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		for(int i=2; i<101; i++) {
			for(int j=1; j<101; j++) {
				map[i][j] = map[i-1][j].add(map[i][j-1]);
			}
		}
//		for(int i=0; i<101; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		if(N==M) {
			System.out.println(map[1][N]);
		}
		else {
			System.out.println(map[N-M+1][M]);
		}
	}

}
