import java.util.Scanner;

/**
 * 피보나치수열, 모듈러 합동
 * @author kit938639
 *
 */
public class Main_BOJ_11726_2n타일링_S3_120ms {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n==1) {
			System.out.println(1);
			System.exit(0);
		}
		if(n==2) {
			System.out.println(2);
			System.exit(0);
		}
		
		int[] dp = new int[n+1];
		dp[0]=0;
		dp[1]=1;
		dp[2]=2;
		for(int i=3; i<=n; i++) {
			dp[i] = (dp[i-1]%10007 + dp[i-2]%10007) % 10007;
		}
		System.out.println(dp[n]);
	}

}
