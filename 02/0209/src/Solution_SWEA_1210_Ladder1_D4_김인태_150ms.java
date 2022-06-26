import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_1210_Ladder1_D4_김인태_150ms {

	static int[][] map;
	static int r, c;
	static int N = 100;
	static boolean[][] visited;
	static int result;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		for(int testCase=1; testCase<=10; testCase++) {
			short garbage = Short.parseShort(br.readLine());		//	안 쓰는 값	
			
			map = new int[N][];
			visited = new boolean[N][N];
			StringTokenizer st;
			
//			st = new StringTokenizer(br.readLine());
//			map[0] = new int[N];
//			for(int i=0; i<N;i++) {
//				map[0][i] = 100000+i*Integer.parseInt(st.nextToken());
//			}
//			
//			for(int i=1; i<N; i++) {
//				map[i]=map[0].clone();
//			}
			
			// map 생성
			for(int i=0; i<N; i++) {
				map[i] = new int[N];
				st = new StringTokenizer(br.readLine());
//				int tmp = Integer.parseInt(st.nextToken());	//	col 0
				for(int j=0; j<N; j++) {
					int n = Integer.parseInt(st.nextToken());
					if(i==0)
						map[i][j] = 100000+n*j;
					else if(i<N-1 && j==0)
						map[i][j] = 100001;
					else {
						if(n==1) {
							map[i][j] = i*100000 + j;
						}else if(n==0) {
							map[i][j]=0;
						}else {
							map[i][j]=2;
							r=i;
							c=j;
						}	
					}
				}
//				tmp = Integer.parseInt(st.nextToken()); // col N-1
			}	//	end of for
			
			
//			for(int i=0; i<N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			
			
			//System.out.println(r+", "+c);
			sol(r,c);
			//System.out.println(result);
			result %= 100000;
			//System.out.println(result);
			sb.append("#").append(testCase).append(" ").append(result).append("\n");
		}	//	end of testCase
		System.out.println(sb);
		
	}	// end of main
	
	
	public static void sol(int r, int c) {
		if(r==0) {
			result = map[r][c];
			return;
		}else {
			int[] dr = {0,0,-1};	//	좌, 우, 상
			int[] dc = {-1,1,0};
			
			for(int i=0; i<3; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				//	범위를 넘지 않는 곳에서만
				if(0<=nr && nr<N && 0<=nc && nc<N && map[nr][nc] > 100000 && visited[nr][nc]==false) {
					visited[r][c] = true;
					sol(nr, nc);
					return;
				}
			}
		}	
	}	//	end of sol

}	// end of class

















//			map[0] = new int[100];
//			//	사다리의 첫 줄 첫줄에 1이 마지막줄까지 이어지므로 마지막 줄만 새로 입력 받을 것이므로 
//			for(int i=0;i<100;i++) {
//				map[0][i]=Integer.parseInt(st.nextToken());
//			}
//			//	사다리 복사
//			for(int i=1;i<100;i++) {
//				map[i] = map[0].clone();
//			}
//			
//			for(int i=0;i<100;i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}