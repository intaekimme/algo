import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_9663_NQueen_G5_김인태 {

	static int[] dr = {1, 1, 0, -1, -1, -1, 0, 1}; // 우, 우하, 하, 좌하, 좌, 좌상, 상, 우상
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	static int N, cnt = 0;
	private static int[][] map;
	private static boolean[][] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 퀸의 갯수 겸 map의 크기
		
		map = new int[N][N];
		visited = new boolean[N][N];
		 
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				dfs(r,c, N);
			}
		}
		System.out.println(cnt);
	}

	private static void dfs(int r, int c, int N) {
		
		if(r<0 || r>=N || c<0 || c>=N) return; // 탐색하는 좌표가 테두리 밖이면 탐색 중단
		if(visited[r][c]) return;	//	이미 방문했으면 탐색 중단
		if(!visited[r][c]) {
			visited[r][c] = true;
			N--;
		}
		
		if(N < 0) {	//	 기저조건, 더 이상 확인할 퀸이 없으면 탐색 중지
			cnt++;
			return;	
		}
		
		int nr = r;
		int nc = c;
		for(int i=0; i<8; i++) {
			while(true) {
				nr += dr[i];
				nc += dc[i];
				if(nr<0 || nr>=N || nc<0 || nc>= N) break;
				visited[nr][nc] = true;
			}
		}
		
		return;
	
	}

}
