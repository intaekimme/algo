import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1520_내리막길 {

	private static int M, N;
	private static int[][] map, dp;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[M+1][N+1];
		dp = new int[M+1][N+1];
//		for(int i=0;i<M;i++) {
//			Arrays.fill(dp[i], -1);
//		}
		
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= N; j++) {
				dp[i][j] = -1;
			}
		}
		
		int res = search(1,1);
		
//		for(int i=0; i<=M; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
		System.out.println(res);
		
	}

	private static int search(int x, int y) {
		
		System.out.println("-------------------");
		for(int i=0; i<=M; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		
		if(x==M && y==N) {
			return 1;
		}
		
		if (dp[x][y] != -1) {
			return dp[x][y];
		}
		
		dp[x][y] = 0;
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
//			if (nx < 1 || ny < 1 || nx > M || ny > N) {
//				continue;
//			}
			
			if (round(nx,ny) && map[x][y] > map[nx][ny]) {
				dp[x][y] += search(nx, ny);
			}
			
		}
		return dp[x][y];
	}

	private static boolean round(int nx, int ny) {
		return !(nx < 1 || ny < 1 || nx > M || ny > N);	
	}
}
