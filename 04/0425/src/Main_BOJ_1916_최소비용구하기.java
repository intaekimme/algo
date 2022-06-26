import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_1916_최소비용구하기 {

	static class Node implements Comparable<Node>{
		int to;
		int weight;
		
		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
		
		
	}
	
	static final int INF = 987_654_321;
	static int N, M;
	static int[] d;
	static boolean[] v;
	static List<Node>[] list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		d = new int[N+1];
		Arrays.fill(d, INF);
		v = new boolean[N+1];
		
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<Node>();
		}
		
		StringTokenizer st = null;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[from].add(new Node(to, weight));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		dijk(start);
		System.out.println(d[end]);
	}
	
	public static void dijk(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.add(new Node(start, 0));
		d[start] = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int to = node.to;
			
			if(v[to]) continue;
			v[to] = true;
			
			for(Node next : list[to]) {
				if(d[next.to] >= d[to] + next.weight) {
					d[next.to] = d[to] + next.weight;
					System.out.println(Arrays.toString(d));
					pq.add(new Node(next.to, d[next.to]));
				}
			}
		}
		
	}

}
