import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 그래프로 접근? 무리문제 union find문제처럼 그룹을 만들어야 하는데
 * 이건 감이 안잡힌다.
 * 일단 bfs, dfs로 접근해보자
 * R=1, G(적록색약=1, 정상=2) , B=3;
 * @author kit938639
 *
 */



public class Solution_BOJ_10026_적록색약_G5_김인태_124ms {
	static int cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] normal = new int[N+2][];
		int[][] abnormal = new int[N+2][];
		
		normal[0] = new int[N+2];
		abnormal[0] = new int[N+2];
		
		normal[N+1] = new int[N+2];
		abnormal[N+1] = new int[N+2];
		
		
		for(int i=1;i<=N;i++) {
			String s = br.readLine();
			normal[i] = new int[N+2];
			abnormal[i] = new int[N+2];
			for(int j=1;j<=N;j++) {
				switch (s.charAt(j-1)) {
				case 'R':
					normal[i][j]=abnormal[i][j]=1;
					break;
				case 'G':
					abnormal[i][j]=1;
					normal[i][j]=2;
					break;
				case 'B':
					normal[i][j]=abnormal[i][j]=3;
					break;
				}
			}
		}

		
		StringBuilder sb = new StringBuilder();
		
		// 정상
		boolean[][] visited = new boolean[N+2][N+2];
		cnt=N*N;
		for(int r=1;r<=N;r++) {
			for(int c=1;c<=N;c++) {
				dfs(normal, N, r, c, visited);
			}
		}
		sb.append(cnt).append(" ");
		
		//	비정상
		cnt=N*N;
		visited = new boolean[N+2][N+2];
		for(int r=1;r<=N;r++) {
			for(int c=1;c<=N;c++) {
				dfs(abnormal, N, r, c, visited);
			}
		}
		sb.append(cnt);
		
		System.out.println(sb);
	}	//	end of main
	
	public static void dfs(int[][] map, int N, int r, int c, boolean[][] visited) {
		if(visited[r][c]) {
			cnt--;
			return;
		}
		
		int[] dr = {-1,0,1,0};	//	상, 우, 하, 좌
		int[] dc = {0,1,0,-1};	
		
		visited[r][c]=true;
		for(int i=0;i<4;i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(!visited[nr][nc] && map[r][c]!=0 && map[r][c]==map[nr][nc]) {
				dfs(map, N, nr, nc, visited);
			}
		}
	}
}
