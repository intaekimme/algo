import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1051_숫자정사각형_S4_ {

	private static int N, M;
	private static int[][] map;
	private static int[] dr = {0, 1, 1};
	private static int[] dc = {1, 1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				map[i][j] = tmp[j]-'0';
			}
		}

		
		int start = Math.min(N, M)-1;
		int max = 0;
		
		for(int i=start; i>=0; i--) {
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					int pivot = map[r][c];
					int cnt = 0;
					if(i>0) {
						for(int j=0; j<3; j++) {
							int nr = r + i * dr[j];
							int nc = c + i * dc[j];
							if(nr>=N || nc>=M) break;
							if(map[nr][nc] != pivot) break;
							cnt++;
						}
						if(cnt==3) {
							System.out.println((i+1)*(i+1));
							System.exit(0);;
						}
					}else {
						System.out.println(1);
						System.exit(0);
					}
				}
			}			
		}
	}

}
