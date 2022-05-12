import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_2294_동전2 {

	private static int N, K;
	private static int[] arr, dp;
	static final int INF = 10_001;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		dp = new int[K+1];
		Arrays.fill(dp, INF);
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i]<=10_000)
				dp[arr[i]] = 1;
		}
		
		Arrays.sort(arr);
		
		for(int i=1; i<=K; i++) {
			for(int j=N-1; j>0; j--) {
				if(i % arr[j]==0) {
					dp[i] = i / arr[j];
					break;
				}
			}
			if(dp[i] == INF) {
				dp[i] = Math.min(dp[i], dp[i-1]+1);
			}
		}
//		System.out.println(Arrays.toString(dp));
		System.out.println(dp[K-1] != INF ? dp[K-1] : "-1");
	}

}
