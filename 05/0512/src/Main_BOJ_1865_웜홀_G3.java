import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1865_웜홀_G3 {

	private static int N, M, W;
	private static int[][] adj;
	static final int INF = 987_654_321;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			adj = new int[N][N];
			for(int i=0; i<N; i++) {
				Arrays.fill(adj[i], INF);
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(i==j) adj[i][j] = 0;
				}
			}
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken())-1;
				int to = Integer.parseInt(st.nextToken())-1;
				int weight = Integer.parseInt(st.nextToken());
				adj[from][to] = adj[to][from] = weight;
			}
			for(int i=0; i<W; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken())-1;
				int to = Integer.parseInt(st.nextToken())-1;
				int weight = Integer.parseInt(st.nextToken());
				adj[from][to] = -weight;
			}

			
			// 경 출 도
			boolean chk = false;
			here: for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
//					if(i==j) continue;		// 출발지 = 경유지 제외
					for(int k=0; k<N; k++) {
						// 출발지에서 도착지까지 바로 가는 거리보다 경유지를 거쳐가는 것이 더 빠르면 갱신
//						if(i==k&& j==k) continue;	//	도착지 = 경유지 제외
						if(adj[j][k] > adj[j][i] + adj[i][k]) {	
							adj[j][k] = adj[j][i] + adj[i][k];
							if(j == k && adj[j][k]<0) {
								System.out.println("YES");
								chk = true;
								break here;
							}
						}
					}
				}
			}
			if(chk) continue;
			System.out.println("NO");
			
		}
	}

}
