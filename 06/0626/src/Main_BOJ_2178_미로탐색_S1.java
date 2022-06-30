import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_2178_미로탐색_S1 {

	private static int N, M;
	private static char[][] map;
	private static int[][] res;
	private static boolean[][] visited;
	
	private static int[] dr = {0, 1, 0, -1};
	private static int[] dc = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		
		res = new int[N][M];
		visited = new boolean[N][M];
		Queue<int[]> que = new LinkedList<int[]>();
		
		que.add(new int[] {0,0});
		res[0][0] = 1;
		visited[0][0] = true;
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int r = cur[0];
			int c = cur[1];
			int cnt = res[r][c];
			
			for(int i=0; i<4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
				if(map[nr][nc] != '0' && !visited[nr][nc]) {
					visited[nr][nc] = true;
					res[nr][nc] = cnt + 1;
					que.add(new int[] {nr, nc});
				}
			}
		}	//	end of while
		
		System.out.println(res[N-1][M-1]);
	}

}
