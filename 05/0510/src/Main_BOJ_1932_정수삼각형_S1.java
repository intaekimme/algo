import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * dp
 * @author kit938639
 *
 */
public class Main_BOJ_1932_정수삼각형_S1 {

	private static int N;
	private static int[][] arr, dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		dp = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int j=0;
			while(st.hasMoreTokens()) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(j==0) {
					if(i==0) {
						dp[0][0] = arr[0][0];
					}else {
						dp[i][j] = dp[i-1][j] + arr[i][j];						
					}
				}
				j++;
			}
		}
		
		for(int i=1; i<N; i++) {
			for(int j=1; j<N; j++) {
				if(i==j) {
					dp[i][j] = dp[i-1][j-1] + arr[i][j];
				}else {
					dp[i][j] = Math.max(dp[i-1][j-1]+arr[i][j], dp[i-1][j]+arr[i][j]);
				}
			}
		}
		
		int ans=0;
		for(int i=0; i<N; i++) {
			if(ans<dp[N-1][i]) ans = dp[N-1][i];
		}
		System.out.println(ans);
	}

}
