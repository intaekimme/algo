import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_11060_점프점프_S2 {

	private static int N;
	private static int[] arr, dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr = new int[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[14];
		System.out.println(Arrays.toString(dp));
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = 0;
		System.out.println(Arrays.toString(dp));
		System.out.println("===========");
        for (int i = 1; i <= N; i++) {
        	System.out.println(Arrays.toString(dp));
            if (dp[i] >= Integer.MAX_VALUE) continue;
            for (int j = 1; j <= arr[i]; j++) {
                dp[i+j] = Math.min(dp[i+j], dp[i]+1);
                System.out.println(Arrays.toString(dp));
                System.out.println("-----------------");
            }
        }
        if (dp[N] >= Integer.MAX_VALUE) {
            System.out.print(-1);
        } else {
            System.out.print(dp[N]);
        }
		
	}

}
