import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution_SWEA_16926_배열돌리기1_김인태 {

	static int[][] map;
	static int N;
	static int M;
	static int R;
	
	static int[] dr = {0,1,0,-1};	//	우, 상, 좌, 하	
	static int[] dc = {1,0,-1,0};
	
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	// 가로
		M = Integer.parseInt(st.nextToken());	// 세로
		R = Integer.parseInt(st.nextToken());	// 회전수(반시계)
		
		map = new int[N][];
		map[0]= new int[M];
		//	map 생성
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			map[r] = new int[M+1];
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
//		map 정상입력 확인 test
//		for(int r=0; r<N; r++) {
//			System.out.println(Arrays.toString(map[r]));
//		}
		
		int group = Math.min(N, M) / 2;
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<group;j++) {
				int r = j;
				int c = j;
				
				int tmp = map[r][c];
				
				int idx = 0;
				while(idx<4) {
					int nr = r + dr[idx];
					int nc = c + dc[idx];
					
					if(j<=nr && nr<N-j && j<=nc && nc<M-j) {
						map[r][c] = map[nr][nc];
						r = nr;
						c = nc;
					}
					
					else	idx++;
				}
				map[j+1][j] = tmp;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				sb.append(map[i][j]+" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}	//	end of main
	
}	//	end of class
