import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1238_파티 {

	private static int N, M, X;
	private static int[][] map;
	static int[] d, rd;
	static boolean[] v;
	static final int INF = 987_654_321;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];

		
		d = new int[N+1];
		rd = new int [N+1];
		v = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			map[from][to] = weight;
		}
		int ans=Integer.MIN_VALUE;
		
		
		dijk(rd, X);
		
		for(int i=1; i<=N; i++) {
			int res = 0;
			dijk(d, i);
			res = d[X] + rd[i];
			System.out.println(Arrays.toString(d));
			System.out.println(Arrays.toString(rd));
			System.out.println(res);
			System.out.println("----------------------");
			if(ans<res) ans = res;
		}
		System.out.println(ans);
	}
	
	
	public static void dijk(int[] arr, int start) {
		Arrays.fill(arr, INF);
		Arrays.fill(v, false);
		arr[start] = 0;
		
		for(int j=1; j<=N; j++) {
			int min = INF, cur = 0;
			
			for(int k=1; k<=N; k++) {
				if(!v[k] && arr[k] < min) {
					min = arr[k];
					cur = k;
				}
			}
			
			v[cur] = true;
			
			for(int k=1; k<=N; k++) {
				if(!v[k]) {
					if(map[cur][k] != 0 && arr[k] > arr[cur] + map[cur][k]) {
						arr[k] = arr[cur] + map[cur][k];
					}
				}
			}
			
		}
	}	//	end of dijk

}
//4 8 2
//1 2 4
//1 3 2
//1 4 7
//2 1 1
//2 3 5
//3 1 2
//3 4 4
//4 2 3