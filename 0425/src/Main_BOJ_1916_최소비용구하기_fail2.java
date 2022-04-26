import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1916_최소비용구하기_fail2 {

	private static final int INF = Integer.MAX_VALUE;
	private static int N, M;
	private static int[][] map;
	private static int[] d;
	private static boolean[] v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		map = new int [N][N];
		
		for(int i=0; i<N; i++) {
			Arrays.fill(map[i], INF);
		}
		StringTokenizer st = null;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			
			map[from][to] = weight;
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken())-1;
		int end = Integer.parseInt(st.nextToken())-1;
				
		d = new int[N];
		v = new boolean[N];
		
		Arrays.fill(d, INF);
		d[start] = 0;
		
		for(int i=0; i<N; i++) {
			int min = INF, cur = 0;
			
			for(int j=0; j<N; j++) {
				if(!v[j] && d[j] < min) {
					min = d[j];
					cur = j;
				}
			}
			
			v[cur] = true;
			
			for(int j=0; j<N; j++) {
				if(!v[j]) {
					if(map[cur][j] != INF && d[j] > d[cur] + map[cur][j]) {
						d[j] = d[cur] + map[cur][j];
						System.out.println(Arrays.toString(d));
					}
				}
			}
		}
		
		System.out.println(d[end]);
	}
	
	

}
