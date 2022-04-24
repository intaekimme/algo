import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 * 그래프 문제인데 인접리스트로 푸는 문제
 * 처음에 깊이를 따지지 않고 했다가 오래걸림
 * 
 * @author kit938639
 *
 */


public class Solution_SWEA_1238_Contact_D4_김인태_117ms {
	
	static class Node{
		int vertex;
		Node link;
		
		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			
			Node[] adjList = new Node[N+1];	//	인덱스 : from, 값 : to
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				//	유향이므로 간선 하나로 단방향 처리
				adjList[from]= new Node(to, adjList[from]);
			}
			
//			for(Node head : adjList) {
//				System.out.println(head);
//			}
			
			sb.append("#").append(tc).append(" ").append(bfs(N, adjList, start)).append("\n");
		}	//	end of testCase
		
		System.out.print(sb);
	}	//end of main
	
	public static int bfs(int N, Node[] adjList, int start) {
		Queue<int[]> queue = new LinkedList<int[]>();	//	vertex, depth	
		boolean[] visited = new boolean[N+1];
		
		queue.offer(new int[] {start, 0});
		visited[start] = true;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// depth 가 같다면 vertex가 큰 순서대로, 아니라면 depth가 큰 순서대로
				return o1[1] == o2[1] ? -(o1[0] - o2[0]) : -(o1[1] - o2[1]);
			}

		});
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			pq.offer(current);
			
			int depth = current[1];
//			System.out.println(current);
			
			//	current 정점의 인접정점 처리(단, 방문하지 않은 인접정점만)
			for(Node temp=adjList[current[0]]; temp !=null; temp=temp.link) {
				if(!visited[temp.vertex]){
					queue.offer(new int[] {temp.vertex, depth+1});
					visited[temp.vertex] = true;
				}
			}

		}	//	end of while
		
		return pq.poll()[0];
	}	//	end of bfs
	

}	//	end of class
