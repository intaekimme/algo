import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DijkstraTest2_PQ {

	static class Vertex implements Comparable<Vertex>{	//	정점번호, 출발지에서 자신으로의 최소비용
		int no, minDistance;

		public Vertex(int no, int minDistance) {
			super();
			this.no = no;
			this.minDistance = minDistance;
		}
			
		@Override
		public int compareTo(Vertex o) {
			return this.minDistance - o.minDistance;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int V = Integer.parseInt(in.readLine());
		
		int[][] adjMatrix = new int[V][V];
		int start = 0;
		
		
		StringTokenizer st = null;
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < V; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] distance = new int[V];	//	출발지에서 자신으로 오는 최소비용
		boolean[] visited = new boolean[V];	//	최소비용 확정여부
		PriorityQueue<Vertex> pQueue = new PriorityQueue<Vertex>();
		
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start]=0;	//	시작점 0으로
		pQueue.offer(new Vertex(start, distance[start]));
		
		while(!pQueue.isEmpty()) {
			//	단계1 : 최소비용이 확정되지 않은 정점중 최소비용의 정점 선택
			Vertex current = pQueue.poll();
			
			if(visited[current.no])	continue;	
			// 같은 정점의 다른 최소비용이 나오면 최소비용을 업데이트하는 아래 과정을 해도 업데이트 되지 않음
			// 이미 최소이기 때문에 하지만 시간이 오래 걸릴 수 있음. 시간초과가 나기 싫다면 해주자.
			visited[current.no] = true;			
			
			// 단계2 : 선책된 정점을 경유지로 하여 아직 최소비용이 확정되지 않은 다른정점의 최소비용을 고려
			for (int j = 0; j < V; j++) {
				if(!visited[j] && adjMatrix[current.no][j] != 0 && 
						distance[j] > distance[current.no] + adjMatrix[current.no][j]) {
					distance[j] = distance[current.no] + adjMatrix[current.no][j];
					pQueue.offer(new Vertex(j, distance[j]));	//	그냥 넣기, 공간 복잡도는 불리하지만 시간적으로는 불리하지 않음
				}
			}
		}
		System.out.println(Arrays.toString(distance));
	}

}
