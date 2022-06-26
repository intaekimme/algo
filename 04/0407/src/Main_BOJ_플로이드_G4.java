import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_플로이드_G4 {

	static final int INF = 9999999;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], INF);
		}
		for (int i = 0; i < N; i++) {
			map[i][i]=0;
		}
		int M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			if(map[from][to] > w) {
				map[from][to] = w;
			}
		}
		
		// 경 출 도
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				if(i==k) continue;
				for(int j=0; j<N; j++) {
					if(i==j || k==j) continue;
					if(map[i][j] > map[i][k]+map[k][j]) {
						map[i][j] = map[i][k]+map[k][j];
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();	
		for(int i=0;i<N;i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] >= INF) sb.append("0").append(" ");
				else sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}

}
