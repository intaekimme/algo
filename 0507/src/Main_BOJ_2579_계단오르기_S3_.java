import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main_BOJ_2579_계단오르기_S3_ {

	private static int N;
	private static int[] arr, dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		dp = new int[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = arr[1];
		if(N==1) {
			System.out.println(dp[1]);
			System.exit(0);
		}
		dp[2] = arr[1] + arr[2];
		if(N==2) {
			System.out.println(dp[2]);
			System.exit(0);
		}
		for(int i=3; i<=N; i++) {
			dp[i] = Math.max(dp[i-3] + arr[i-1] + arr[i], dp[i-2] + arr[i]);
		}
		
		System.out.println(dp[N]);
	}

}
