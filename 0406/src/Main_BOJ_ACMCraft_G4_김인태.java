import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main_BOJ_ACMCraft_G4_김인태 {

	static class Node{
		int vertex;
		int conTime;
		Node link;
		
		public Node(int vertex, int conTime, Node link) {
			this.vertex = vertex;
			this.conTime = conTime;
			this.link = link;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", conTime=" + conTime + ", link=" + link + "]";
		}
		
		
	}
	
	static int V, E, W;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		Node[] adjList = new Node[V+1];
		int[] conTime = new int[V+1];
		st = new StringTokenizer(br.readLine());
		
		for(int i=1;i<=V;i++) {
			conTime[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(Arrays.toString(conTime));
		for(int i=1; i<=E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjList[from] = new Node(to, conTime[from], adjList[from]);
		}
		
		for(Node head : adjList) {
			System.out.println(head);
		}
		
		W = Integer.parseInt(br.readLine());
		
	}

}
