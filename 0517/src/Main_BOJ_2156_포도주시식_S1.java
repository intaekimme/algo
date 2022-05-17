import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * DP
 * 
 * @author kit938639
 *
 */
public class Main_BOJ_2156_포도주시식_S1 {

	private static int N;
	private static int[] arr;
	private static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
//		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[3][N];
		int idx=1;
		while(st.hasMoreTokens()) {
			arr[idx++] = Integer.parseInt(st.nextToken());
		}
		
//		for(int i=1; i<=N; i++) {
//			arr[i] = Integer.parseInt(br.readLine());
//		}
		
		for(int i=0; i<3; i++) {
			for(int j=1; j<=N; j++) {
				if(i==0) {
					if(j%3!=0) {
						dp[i][j] = dp[i][j-1] + arr[j];
					}else {
						dp[i][j] = dp[i][j-1];
					}
					continue;
				}
				if(i==1) {
					if(j%3!=2) {
						dp[i][j] = dp[i][j-1] + arr[j];
					}else {
						dp[i][j] = dp[i][j-1];
					}
					continue;
				}
				if(i==2) {
					if(j%3!=1) {
						dp[i][j] = dp[i][j-1] + arr[j];
					}else {
						dp[i][j] = dp[i][j-1];
					}
					continue;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<=N; i++) {
			sb.append(arr[i]).append("\t");
		}
		sb.append("\n");
		for(int i=0; i<3; i++) {
			for(int j=0; j<=N; j++) {
				sb.append(dp[i][j]).append("\t");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		System.out.println(Math.max(Math.max(dp[0][N],dp[1][N]), dp[2][N]));
		
	}

}
