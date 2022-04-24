import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * 방법1. 플로이드워셜
 *
 */
public class Solution_SWEA_1249_보급로_D4_김인태_168ms {

	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		for(int tc = 1;tc<=TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N]; 
			for(int i=0;i<N;i++) {
				String s = br.readLine();
				for(int j=0;j<N;j++) {
					map[i][j] = s.charAt(j)-'0';
				}
			}
			
			int[][] dp = new int[N][N];
			for(int i=0;i<N;i++) {
				Arrays.fill(dp[i], Integer.MAX_VALUE);
			}
			dp[0][0]=0;
			Queue<int[]> q = new LinkedList<int[]>();
			q.offer(new int[] {0,0});
			
			while(!q.isEmpty()) {
				int x = q.peek()[0];
				int y = q.peek()[1];
				q.poll();
				
				for(int i=0;i<4;i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
					int time = dp[x][y] + map[nx][ny];
					if(dp[nx][ny] > time) {
						dp[nx][ny] = time;
						q.add(new int[] {nx, ny});
					}
				}
				System.out.println("=========================");
				for(int i=0;i<N;i++) {
					System.out.println(Arrays.toString(dp[i]));
				}
			}
			sb.append("#").append(tc).append(" ").append(dp[N-1][N-1]).append("\n");
		}
		System.out.println(sb);
	}

}
