import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_11047_동전0_S3 {

	private static int N, K;
	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int ans = 0;
		for(int i=N; i>=1; i--) {
			if(K==0) break;
			if(arr[i]<=K) {
				ans += K / arr[i];
				K = K % arr[i];
			}
		}
		System.out.println(ans);
	}

}
