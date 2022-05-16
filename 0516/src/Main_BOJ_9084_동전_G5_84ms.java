import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 2294 동전 2와 유사한 문제
 * @author kit938639
 *
 */
public class Main_BOJ_9084_동전_G5_84ms {

	private static int N, M;
	private static int[] arr, dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=TC; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[10001];
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			M = Integer.parseInt(br.readLine());
			
			dp = new int[10001];

			dp[0] = 0;
			
			for(int i=1; i<=N; i++) {
				dp[arr[i]] += 1;
				for(int j=arr[i]; j<=M; j++) {
					dp[j] = dp[j] + dp[j-arr[i]];
				}
			}
//			System.out.println(Arrays.toString(dp));
			System.out.println(dp[M]);
		}
	}

}
