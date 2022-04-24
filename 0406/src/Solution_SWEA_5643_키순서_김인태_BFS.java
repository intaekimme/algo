import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_5643_키순서_김인태_BFS {

	static int N, M, gtCnt, ltCnt, adj[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			adj = new int[N+1][N+1];
			
			StringTokenizer st = null;
			for(int i=1; i<=M; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				adj[r][c] = 1;
			}
			
			int res=0;
			for(int i=1; i<=N; i++) {
				gtCnt=ltCnt=0;
				gtBFS(i);
				ltBFS(i);
				if(gtCnt + ltCnt == N-1) res++;
			}
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}

	private static void gtBFS(int s) {
		Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        q.add(s);
        visited[s] = true;
        
        while(!q.isEmpty()) {
        	int k = q.poll();
        	for(int i=1; i<=N; i++) {
        		if(adj[k][i]==1 && !visited[i]) {
        			q.add(i);
        			visited[i] = true;
        			gtCnt++;
        		}
        	}
        }
		

	}

	private static void ltBFS(int s) {
		Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        q.add(s);
        visited[s] = true;
        
        while(!q.isEmpty()) {
        	int k = q.poll();
        	for(int i=1; i<=N; i++) {
        		if(adj[i][k]==1 && !visited[i]) {
        			q.add(i);
        			visited[i] = true;
        			ltCnt++;
        		}
        	}
        }
	}


}
