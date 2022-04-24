import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * 
 * 방법1. 플로이드워셜
 *
 */
public class Solution_SWEA_1249_보급로_D4_김인태3_131ms {

	static int N = 0, INF = Integer.MAX_VALUE;
	static int[][] map;
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			
			for(int i=0;i<N; ++i) {
				char[] ch = br.readLine().toCharArray();
				for(int j=0;j<N;++j) {
					map[i][j]=ch[j]-'0';
				}
			}
			sb.append("#").append(tc).append(" ").append(dijkstra(0, 0)).append("\n");
		}
		System.out.println(sb);
	}
	
	private static int dijkstra(int startR, int startC) {
		boolean[][] visited = new boolean[N][N];
		int[][] minTime = new int[N][N]; //dp
		
		for(int i=0;i<N;i++) {
			Arrays.fill(minTime[i], Integer.MAX_VALUE);
		}
		
		PriorityQueue<int[]> pQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
			
		});
		
		minTime[startR][startC] = 0;
		pQueue.offer(new int[] {startR, startC, minTime[startR][startC]});
		
		int r,c,minCost, nr,nc,current[];
		
		while(true) {
			current = pQueue.poll();
			r = current[0];
			c = current[1];
			minCost = current[2];
			
			if(visited[r][c]) continue;
			visited[r][c] = true;
			
			if(r==N-1 && c==N-1) return minCost;
			
			for(int d=0; d<4; d++) {
				nr = r+ dr[d];
				nc = c+ dc[d];
				if(nr>=0 && nr<N && nc>=0 && nc<N &&
					!visited[nr][nc] && 
					minTime[nr][nc] > minCost + map[nr][nc]) {
					minTime[nr][nc] = minCost + map[nr][nc];
					pQueue.offer(new int[] {nr,nc,minTime[nr][nc]});
				}
			}
			
			
		}

	}	// end of dijk

}
