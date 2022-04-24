import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author kit938639
 *
 */
public class Main_BOJ_10217_KCMTravel_G1 {

	private static int N, M, K;
	private static int[][][] map;
	private static final int INF = 1_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int tc=1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	//	공항 수
			M = Integer.parseInt(st.nextToken());	//	총 지원비용
			K = Integer.parseInt(st.nextToken());	//	티켓정보 수
			
			map = new int[N+1][N+1][2];	//	1<= u, v <= N
			for(int i=0; i<N+1; i++) {
				for(int j=0; j<N+1; j++) {
					map[i][j][1] = INF;
				}
			}
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());	//	from, 출발공항
				int v = Integer.parseInt(st.nextToken());	//	to, 도착공항
				int c = Integer.parseInt(st.nextToken());	//	비용
				int d = Integer.parseInt(st.nextToken());	//	소요시간

				map[u][v][0] = c;	//	u -> v로 가는 비용
				map[u][v][1] = d;	//	u -> v로 걸리는 시간
			}
			
			// 경출도
			for(int k=1; k<N+1; k++) {
				for(int i=1; i<N+1; i++) {
					if(i==k) continue;	//	출발지 경유지 같은 것은 제외
					for(int j=1; j<N+1; j++) {
						if(i==j || j==k) continue;	//	출발지 도착지 동일, 도착지 경유지 동일 제외
						
						if(map[i][j][1] > map[i][k][1] + map[k][j][1]) {
							map[i][j][1] = map[i][k][1] + map[k][j][1];
							map[i][j][0] = map[i][k][0] + map[k][j][0];
						}
							
					}
				}
			}
//			for(int i=0; i<N+1; i++) {
//				for(int j=0; j<N+1; j++) {
//					System.out.print(map[i][j][0]+" ");		//	비용
//				}
//				System.out.println();
//			}
//			System.out.println("=============================");
//			for(int i=0; i<N+1; i++) {
//				for(int j=0; j<N+1; j++) {
//					System.out.print(map[i][j][1]+" ");		//	소요시간
//				}
//				System.out.println();
//			}
			
//			int min = INF;
//			for(int i=1; i<N+1; i++) {
//				for(int j=1; j<N+1; j++) {
//					if(map[i][j][0]<=M && map[i][j][1] < min) {
//						min = map[i][j][1];
//					}
//				}
//			}
			
			if(map[1][N][1]<INF && map[1][N][0]<=M) {
				System.out.println(map[1][N][1]);
			}
			else {
				System.out.println("Poor KCM");
			}
			
		}
		
		
	}

}
