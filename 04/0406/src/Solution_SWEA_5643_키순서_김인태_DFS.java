import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_5643_키순서_김인태_DFS {

	static int N, M, cnt, adj[][], radj[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			adj = new int[N+1][N+1];
			radj = new int[N+1][N+1];
			
			StringTokenizer st = null;
			for(int i=1; i<=M; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				adj[r][c] = 1;
				radj[c][r] = 1;
			}
			
			int res=0;
			for(int i=1; i<=N; i++) {
				cnt=0;
				DFS(i, adj, new boolean[N+1]);
				DFS(i, radj, new boolean[N+1]);
				if(cnt == N-1) res++;
			}
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}	

	private static void DFS(int s, int[][] adj, boolean[] visited) {
		visited[s] = true;
		for(int i=1;i<=N;i++) {
			if(adj[s][i]==1 && !visited[i]) {
				cnt++;
				DFS(i, adj, visited);
			}
		}
	}
}
