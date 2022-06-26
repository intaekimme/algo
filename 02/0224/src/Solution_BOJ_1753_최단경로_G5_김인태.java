import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class Solution_BOJ_1753_최단경로_G5_김인태 {

	static class Node{
		int vertex;
		int weight;
		Node link;
		
		public Node(int vertex, Node link, int weight) {
			this.vertex = vertex;
			this.link = link;
			this.weight = weight;
		}
		
		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", weight=" + weight + ", link=" + link +"]";
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		
		int start = Integer.parseInt(br.readLine())-1;
		
		Node[] adjList = new Node[V];		// 정점 개수만큼 생성, 입력된 정점은 -1을 해줘서 맞춰준다.
				
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[from-1] = new Node(to-1, adjList[from-1], weight);
		}
		
		for(Node head : adjList) {
			System.out.println(head);
		}
		
		int[] distance = new int[V];	//	출발지에서 자신으로 오는 최소비용
		boolean[] visited = new boolean[V];	//	최소비용 확정여부
		
		PriorityQueue<Node> pQueue = new PriorityQueue<Node>();
//		
//		
//		Arrays.fill(distance, Integer.MAX_VALUE);
//		distance[start]=0;	//	시작점 0으로
//		pQueue.offer(new Vertex(start, distance[start]));
//		
//		while(!pQueue.isEmpty()) {
//			//	단계1 : 최소비용이 확정되지 않은 정점중 최소비용의 정점 선택
//			Vertex current = pQueue.poll();
//			
//			if(visited[current.no])	continue;	
//			// 같은 정점의 다른 최소비용이 나오면 최소비용을 업데이트하는 아래 과정을 해도 업데이트 되지 않음
//			// 이미 최소이기 때문에 하지만 시간이 오래 걸릴 수 있음. 시간초과가 나기 싫다면 해주자.
//			visited[current.no] = true;			
//			
//			// 단계2 : 선책된 정점을 경유지로 하여 아직 최소비용이 확정되지 않은 다른정점의 최소비용을 고려
//			for (int j = 0; j < V; j++) {
//				if(!visited[j] && adjMatrix[current.no][j] != 0 && 
//						distance[j] > distance[current.no] + adjMatrix[current.no][j]) {
//					distance[j] = distance[current.no] + adjMatrix[current.no][j];
//					pQueue.offer(new Vertex(j, distance[j]));	//	그냥 넣기, 공간 복잡도는 불리하지만 시간적으로는 불리하지 않음
//				}
//			}
//		}
//		
//		StringBuilder sb = new StringBuilder();
//		for(int i=0;i<V;i++) {
//			if(distance[i] == Integer.MAX_VALUE)
//				sb.append("INF").append("\n");
//			else
//				sb.append(distance[i]).append("\n");
//		}
//		System.out.println(sb);
	}

}
