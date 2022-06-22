import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_2606_바이러스_S3 {

	private static int N, P;
	private static int[][] map;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		P = Integer.parseInt(br.readLine());
		
		map = new int[101][101];
		visited = new boolean[101];
		StringTokenizer st = null;
		for(int i=0; i<P; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map[from][to] = map[to][from] = 1;
		}
		
		
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(1);
		visited[1] = true;
		int ans = 0;
		
		while(!que.isEmpty()) {
			int from = que.poll();
			
			for(int i=1; i<=100; i++) {
				if(!visited[i] && map[from][i] == 1) {
					visited[i] = true;
					que.add(i);
					ans++;
				}
			}
		}
		
		System.out.println(ans);
	}	

}
