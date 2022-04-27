import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_BOJ_2538_영역구하기 {

	private static int M, N, K, sum;
	private static int[][] map;
	private static int[] dx={-1,0,1,0};
	private static int[] dy={0,1,0,-1};
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		for(int i=0;i<M;i++) {
			Arrays.fill(map[i], 1);
		}
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			
			for(int x=x1; x<x2; x++) {
				for(int y=y1; y<y2; y++) {
					if(x<0 || x>=M || y<0 || y>=N) continue;
					if(map[x][y]==0) continue;
					map[x][y]=0;
				}
			}
		}
		
//		for(int i=0; i<M; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		int cnt=0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		visited = new boolean[M][N];
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					cnt++;
					sum=0;
					dfs(i, j);
					list.add(sum);
				}
			}
		}
		Collections.sort(list);
		
		System.out.println(cnt);
		for (Integer i : list) {
			System.out.print(i + " ");
		}
	}	//	end of main

	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		sum++;
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx<0 || nx>=M || ny<0 || ny>=N) continue;
			if(!visited[nx][ny] && map[nx][ny] == 1) {
				dfs(nx, ny);
			}
		}
	}
	
}
