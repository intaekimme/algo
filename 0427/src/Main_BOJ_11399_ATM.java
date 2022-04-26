import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_11399_ATM {

	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int[] dp = new int[N];
		dp[0] = arr[0];
		int sum = dp[0];
		for(int i=1; i<N; i++) {
			dp[i] = arr[i] + dp[i-1];
			sum+=dp[i];
		}
//		System.out.println(Arrays.toString(dp));
		System.out.println(sum);
	}

}
