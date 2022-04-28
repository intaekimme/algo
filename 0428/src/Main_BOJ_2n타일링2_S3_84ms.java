import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 점화식, 모듈러 합동
 *
 */
public class Main_BOJ_2n타일링2_S3_84ms {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		if(n==1) {
			System.out.println(1);
			System.exit(0);
		}
		if(n==2) {
			System.out.println(3);
			System.exit(0);
		}
		int[] dp = new int[n+1];
		dp[1]=1;
		dp[2]=3;
		for(int i=3; i<=n; i++) {
			dp[i] = (dp[i-1] + 2*dp[i-2])%10007;
		}
		System.out.println(dp[n]);
	}

}
