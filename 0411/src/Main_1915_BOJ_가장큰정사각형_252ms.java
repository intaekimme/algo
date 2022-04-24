import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1915_BOJ_가장큰정사각형_252ms {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		
		for(int i=0;i<n;i++) {
			char[] ch = br.readLine().toCharArray();
			for(int j=0; j<m; j++) {
				map[i][j] = ch[j] - '0';
			}
		}
		
		// 맵 초기화
		int[][] dp = new int[n][m];
//		System.arraycopy(map[0], 0, dp[0], 0, m);
		int result = 0;
		for(int i=0; i<m; i++) {
			dp[0][i] = map[0][i];
			if(dp[0][i]>result) result = dp[0][i];
		}
		for(int i=0; i<n;i++) {
			dp[i][0] = map[i][0];
			if(dp[i][0]>result) result = dp[i][0];
		}
		
		
//		for(int i=0;i<n;i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
	
		
		for(int i=1; i<n; i++) {
			for(int j=1; j<m; j++) {
				if(map[i][j]==1) {	// map[i][j]==0 이면 크기가 없으므로 논외
//					현재 위치에서 위, 왼쪽, 좌측대각의 값중 최솟값 + 1이 가능한 정사각형의 길이
//					예를들어, 0이 있다면 정사각형이 안되므로 크기가 1이된다.
					dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
				}
				if(dp[i][j]>result) result = dp[i][j];
			}
		}
//		System.out.println();
//		for(int i=0;i<n;i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
		
		System.out.println(result*result);
	}

}
