import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_18352_특정거리의도시찾기 {

	static class Node{
		int v;
		Node link;
		
		public Node(int v, Node link) {
			this.v = v;
			this.link = link;
		}

		@Override
		public String toString() {
			return "Node [v=" + v + ", link=" + link + "]";
		}
		
	}
	
	private static int N, M, K, X;
	private static Node[] adjList;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		adjList = new Node[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjList[from] = new Node(to, adjList[from]);
		}
		
		ArrayList<Integer> ans = new ArrayList<Integer>();
		Queue<Node> que = new LinkedList<Node>();
		int cnt = 0;
		
		Node node = adjList[X];
		System.out.println(node);
		while(node.link != null) {
			que.add(node);
			node = node.link;
		}
		
		// 링크로 하니까 찾는 과정에서 막히고 너무 복잡한거 같
		while(true) {
			if(cnt==K) {
				Node end = adjList[que.poll().v];
				while(end.link != null) {
					ans.add(end.link.v);
					end = end.link;
				}
				break;
			}
			Node cur = que.poll();
			while(cur.link != null) {
				que.add(cur.link);
				cur = cur.link;
			}
			cnt++;
		}
		
		
		Collections.sort(ans);
		
		System.out.println(ans.toString());
		
		
	}

}
