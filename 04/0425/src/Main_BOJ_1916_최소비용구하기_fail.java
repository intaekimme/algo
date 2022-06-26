import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1916_최소비용구하기_fail {

	private static final int INF = 987_654_321;
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
			map[i][i]=0;
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
		
		dijk(start);
//		System.out.println(Arrays.toString(d));
		System.out.println(d[end]);
	}
	
	public static int getSmallnum() {
		int min = INF;
		int idx = 0;
		for(int i=0; i<N; i++) {
			if(!v[i] && d[i] < min) {
				 min = d[i];
				 idx = i;
			}
		}
		return idx;
	}
	
	public static void dijk(int start) {
		
		for(int i=0; i<N; i++) {
			d[i] = map[start][i];
		}
//		System.out.println(Arrays.toString(d));		
		v[start] = true;
		
		for(int i=0; i<N-2; i++) {
			int cur = getSmallnum();
//			System.out.println(cur);
			v[cur] = true;
			for(int j=0; j<N; j++) {
				if(!v[j]) {
					if(d[cur] + map[cur][j] < d[j]) {
						d[j] = d[cur] + map[cur][j];
//						System.out.println(Arrays.toString(d));
					}
				}
			}
		}
		
	}

}
