import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1012_유기농배추 {

	private static int TC, M, N, K;
	private static int[][] map, coord;
	private static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		TC = Integer.parseInt(br.readLine());
		for(int tc=0; tc<TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			visited = new boolean[N][M];
			coord = new int[K][2];
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				
				map[x][y] = 1;
				coord[i][0] = x;
				coord[i][1] = y;
//				coord[i][2] = 0; 방문 확인용, 0 미방문, 1 방문
			}
			
//			for(int i=0; i<N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			
			int baechu = K;
			int zirunge = 0;
			for(int i=0; i<K; i++) {
				if(baechu==0) break;
				int x = coord[i][0];
				int y = coord[i][1];
				if(!visited[x][y]) {
					dfs(x, y, baechu);
					zirunge++;
				}
			}
			System.out.println(zirunge);
		}	//	end of TC
		
	}	//	end of main
	
	public static void dfs(int x, int y, int baechu) {
		if(baechu==0) return;
		
		visited[x][y] = true;
		baechu--;
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
			if(!visited[nx][ny] && map[nx][ny]==1) {
				dfs(nx, ny, baechu);
			}
		}
	}
}
