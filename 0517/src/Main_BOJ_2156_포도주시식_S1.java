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
	private static int[] arr, dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		N = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
//		int idx=1;
//		while(st.hasMoreTokens()) {
//			arr[idx++] = Integer.parseInt(st.nextToken());
//		}
		
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		if(N<=3) {
			int ans = 0;
			for(int i=1; i<=N; i++) {
				ans += arr[i];;
			}
			System.out.println(ans);
			return;
		}
		dp = new int[N+1];
		dp[1] = arr[1];
		dp[2] = dp[1] + arr[2];
		dp[3] = Math.max(dp[2], Math.max(arr[2] + arr[3], dp[1] + arr[3]));
		
//		StringBuilder sb = new StringBuilder();
//		for(int i=0; i<=N; i++) {
//			sb.append(arr[i]).append("\t");
//		}
//		sb.append("\n");
		
		for(int i=3; i<=N; i++) {
			dp[i] = Math.max(dp[i-3] + arr[i-1] + arr[i], dp[i-2]+arr[i]);
			dp[i] = Math.max(dp[i-1], dp[i]);
		}
//		for(int j=0; j<=N; j++) {
//			sb.append(dp[j]).append("\t");
//		}
//		
//		System.out.println(sb);
		System.out.println(dp[N]);

		
	}

}
