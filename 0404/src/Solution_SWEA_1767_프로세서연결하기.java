import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_1767_프로세서연결하기 {

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0,0,-1,1};
	static int min, size;
	static int[][] map;
	static int N;
	static boolean[] chk;
	static Point[] core;
	
	static class Point{
		int x=0;
		int y=0;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		chk = new boolean[12];
		StringTokenizer st = null;
		for(int tc=1; tc<=TC; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			reset(map, chk);
			for(int i=0;i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}	//	맵 입력
			
			core = new Point[12];
			size = 0;
			for(int i=1; i<N-1; i++) {
				for(int j=1; j<N-1; j++) {
					if(map[i][j]==1) {
						core[size++]=new Point(i,j);
					}
				}
			}
			
			min = Integer.MAX_VALUE;
			for(int i=size; i>=0; i--) {
				combination(0,0,i);
				if(min < Integer.MAX_VALUE) break;
			}
			
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
		
	}

	public static void reset(int[][] map, boolean[] chk) {
		for(int i=0;i<N;i++) {
			Arrays.fill(map[i], 0);
		}
		Arrays.fill(chk, false);
	}
	
	
	public static void combination(int idx, int cnt, int R) {
		if(cnt == R) {
			dfs(0,0);
			return;
		}
		for(int i=idx; i<size; i++) {
			chk[i] = true;
			combination(i+1, cnt+1, R);
			chk[i] = false;
		}
	}
	
	
	public static void dfs(int idx, int cnt) {
		if(idx == size) {
			min = Math.min(min, cnt);
		}
		if(!chk[idx]) {
			dfs(idx+1, cnt);
			return;
		}
		for(int i=0; i<4; i++) {
			int x = core[idx].x;
			int y = core[idx].y;
			int tmp = 0;	//	전선 길이 
			boolean success = false;
			while(true) {
				x += dx[i];	y += dy[i];		//	1방향으로 끝까지 탐색
				if(x<0 || x>=N || y<0 || y>=N) {	//	전선이 전원부에 도착
					success = true;
					break;
				}
				if(map[x][y]==0) {
					map[x][y] = 2;	// 빈칸에 왔으면 탐색한 칸이 빈칸이기게 전선 추가
					tmp++;					
				}
				else if(map[x][y]!=0) break; 	// 진행도중 전선을 만나면 탐색 중단
			}
			if(success) dfs(idx + 1, cnt + tmp);
			while(true) {
				x -= dx[i]; y -= dy[i];
				if(x == core[idx].x && y == core[idx].y) break;
				map[x][y] = 0;
			}
		}
	}
}
