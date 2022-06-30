import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_18352_특정거리의도시찾기_S2_1348ms {
	
	private static int N, M, K, X;
	private static ArrayList<ArrayList<Integer>> adjList;
	private static int[] dist;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		dist = new int[300001];
		adjList = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0; i<=N; i++) {
			adjList.add(new ArrayList<Integer>());
			dist[i] = -1;
		}
		
		dist[X] = 0;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjList.get(from).add(to);
		}
		
		
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(X);
		
		while(!que.isEmpty()) {
			int element = que.poll();
			ArrayList<Integer> elementList = adjList.get(element); 
			int elementListSize = elementList.size();
			
			for(int i=0; i<elementListSize; i++) {
				int next = elementList.get(i);
				
//				방문한 적이 없음
				if(dist[next] == -1) {
					dist[next] = dist[element] + 1;
					que.add(next);
				}
			}
		}
		
		boolean chk = false;
		for(int i=1; i<=N; i++) {
			if(dist[i] == K) {
				System.out.println(i);
				chk = true;
			}
		}
		if(!chk) System.out.println(-1);
	}

}
