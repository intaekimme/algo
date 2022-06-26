import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Solution_기지국2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		
		for (int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			char[][] map = new char[N][];
			
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			int nr,nc;
			//	기지국 찾기
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {	//	기지국이면
					
					//	기지국 주변 4방 탐색(4방향을 1칸, 2칸, 3칸 넓혀서 탐색)	
					if(map[r][c] >= 'A' && map[r][c]<='C') {
						for (int k = 1; k <= (map[r][c]-'A')+1 ; k++) {
							//	기지국의 유형만큼 칸을 탐색
							for (int d = 0; d < 4; d++) {
								nr = r + k*dr[d];
								nc = c + k*dc[d];
								if(0<=nr&& nr<N && 0<=nc && nc<N && map[nr][nc]=='H') {
									map[nr][nc] = 'X';
								}
							}
						}	//	end of 4방
					}	// end of if 기지국
				}	//	end of for 기지국찾기 c
			}	//	end of for 기지국찾기 r
			int hCnt = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(map[r][c] == 'H')	hCnt++;
				}
			}
			System.out.println("#"+tc+" "+hCnt);
			
		}	//	end of TC
	}	//	end of main

}	//	end of class
