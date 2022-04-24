import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 다익스트라 : 한 정점에서 -> 나머지 정점까지 최단거리 (음이 아닌 가중치)
 * 벨만포드  : 한 정점에서 -> 나머지 정점까지 최단거리  (음의 가중치도 포함)
 * 플로이드 워샬 : 모든 정점 -> 모든 정점 최단거리 n^3
 * 125*125 = 15625 정점의 개수
 * 인접행렬? : 244140625칸, 메모리 부족, 시간도 비효율적
 * 간선의 배열? : x
 * 
 * dfs : 시간초과
 * bfs : 최적화 시 시간안에 가능
 * @author kit938639
 *
 */


public class Main_BOJ_4485_녹색옷을입은애가젤다지_G4_김인태_252ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc=1;
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			int ans = 0;
			
			int[][] map = new int[n][n];
			for(int i=0; i<n;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			ans = bfs(map, n);
			sb.append("Problem ").append(tc++).append(": ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

	public static int bfs(int[][] map, int n) {
		int[] dy = {-1,0,1,0};
		int[] dx = {0,1,0,-1};
		
		int[][] dist = new int[n][n];
		
		for(int i=0;i<n;i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {0,0});
		
		dist[0][0] = map[0][0];
		while(!q.isEmpty()) {
			int y = q.peek()[0];
			int x = q.peek()[1];
			q.poll();
			
			for(int i=0; i<4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(0<=nx && nx<n && 0<=ny && ny<n) {
					if(dist[ny][nx] > dist[y][x] + map[ny][nx]) {
						dist[ny][nx] = dist[y][x] + map[ny][nx];
						q.offer(new int[] {ny, nx});
					}
				}
			}
			
		}

		return dist[n-1][n-1];
	}	//	end of bfs

}
