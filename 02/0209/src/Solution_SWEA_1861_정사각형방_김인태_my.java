import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



//	28464,	135
public class Solution_SWEA_1861_정사각형방_김인태_my {
	
	static int N;
	static int[][] mem;	//	room, move_cnt;
	static int room = Integer.MAX_VALUE;
	static int cnt;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			int[][] map = new int[N][N];
			mem = new int[N][N];
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}	// end of inner for - create map
			
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					int val = sol(map, r, c);
					System.out.println(Arrays.toString(mem[r]));
					if(cnt < val || (cnt == val && room > map[r][c])) {
						room = map[r][c];
						cnt = val;
					}
				}
				System.out.println("------------------------");
			}	// end of inner for - sol
			System.out.println();
			
			sb.append("#").append(tc).append(" ").append(room).append(" ").append(cnt).append("\n");
			
			room = Integer.MAX_VALUE;
			cnt=0;
			
		}	// end of outter for - tc
		
		System.out.println(sb);
		
	}	//	end of main
	
	public static int sol(int[][] map, int r, int c) {
		if(mem[r][c]!=0) {
			return mem[r][c];
		}
		
		mem[r][c]=1;
		int tmp = map[r][c];
		
		int[] dr = {-1,0,0,1};	//	상, 우, 좌, 하
		int[] dc = {0,1,-1,0};
		
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(0<=nr && nr<N && 0<=nc && nc<N && tmp+1 == map[nr][nc]) {
				mem[r][c]+=sol(map, nr, nc);
				break;
			}
		}
		return mem[r][c];
	}	//	end of sol
	

}	//	end of class







//	34654,	149
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Solution_SWEA_1861_정사각형방_김인태_my {
//	
//	static int N;
//	static int[][] mem;	//	room, move_cnt;
//	static int room = Integer.MAX_VALUE;
//	static int cnt;
//	
//
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		
//		int T = Integer.parseInt(br.readLine());
//		
//		for(int tc=1; tc<=T; tc++) {
//			N = Integer.parseInt(br.readLine());
//			
//			int[][] map = new int[N+2][N+2];
//			mem = new int[N+2][N+2];
//			
//			for(int i=1; i<N+1; i++) {
//				StringTokenizer st = new StringTokenizer(br.readLine());
//				for(int j=1; j<N+1; j++) {
//					map[i][j] = Integer.parseInt(st.nextToken());
//				}
//			}	// end of inner for - create map
//			
//			
//			for(int r=1; r<N+1; r++) {
//				for(int c=1; c<N+1; c++) {
//					int val = sol(map, r, c);
//					if(cnt < val || (cnt == val && room > map[r][c])) {
//						room = map[r][c];
//						cnt = val;
//					}
//				}
//			}	// end of inner for - sol
//			
//			sb.append("#").append(tc).append(" ").append(room).append(" ").append(cnt).append("\n");
//			
//			room = Integer.MAX_VALUE;
//			cnt=0;
//			
//		}	// end of outter for - tc
//		
//		System.out.println(sb);
//		
//	}	//	end of main
//	
//	public static int sol(int[][] map, int r, int c) {
//		if(mem[r][c]!=0) {
//			return mem[r][c];
//		}
//		
//		mem[r][c]=1;
//		int tmp = map[r][c];
//		
//		int[] dr = {-1,0,0,1};	//	상, 우, 좌, 하
//		int[] dc = {0,1,-1,0};
//		
//		for(int i=0; i<4; i++) {
//			int nr = r + dr[i];
//			int nc = c + dc[i];
//			
//			if(map[nr][nc]!=0 && tmp+1 == map[nr][nc]) {
//				mem[r][c]+=sol(map, nr, nc);
//				break;
//			}
//		}
//		return mem[r][c];
//	}	//	end of sol
//	
//
//}	//	end of class

