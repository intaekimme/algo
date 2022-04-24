import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_4014_활주로건설 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][N];
			int[][] rmap = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					int val = Integer.parseInt(st.nextToken());
					map[i][j] = val;
					rmap[j][i] = val;			
				}
			}
			
			int cnt=0;
			for(int i=0; i<N; i++) {
				if(checkRow(map[i], X, N)) cnt++;
				if(checkRow(rmap[i], X, N)) cnt++;
			}
			System.out.println(cnt);
		}
	}

	private static boolean checkRow(int[] map, int x, int n) {
		boolean[] visited = new boolean[n];
		for(int i=0; i<n; i++) {
			int next = i+1;
			if(next<n && !visited[i]) {
				if(map[i] == map[next]-1) { //  / 형태 경사로

					isPossible(i, x, n, 1, map, visited);
				}
				else if(map[i] == map[next]+1) {	//	\ 형태 경사로

					isPossible(i, x, n, 2, map, visited);
				}
				else if(map[i] == map[next]) {
					visited[next] = true;
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			if(visited[i]==false) return false;
		}
		return true;
	}

	/*
	 * 활주로를 놓을때 고려해야할 점
	 * 1. 테두리 범위 내
	 * 2. 활주로 길이 동안 높이 같아야함
	 * 3. 높이 차이 1이어야만함.
	 */
	private static void isPossible(int i, int x, int n, int type, int[] map, boolean[] visited) {
		if(type==1) {	//  / 형태 경사로
			if(i-x<0) return;	//	테두리 범위 내
			int l = map[i-1];
			for(int k=i-x; k<i; k++) {
				if(map[k]==l) visited[k] = true;
			}
		}
		if(type==2) {	//	\ 형태 경사로
			if(i+x>n) return;	// 테두리 범위 내
			int l = map[i+1];
			for(int k=i; k<i+x; k++) {
				if(map[k]==l) visited[k] = true;
			}
		}
	
	}


}
