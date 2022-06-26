import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_1861_정사각형방_김인태 {
	
	static int N;
	static int cnt = 0;
	static int max;
	static int room=1000000;
	
	static int[][] map;
	static int[][] result;
	
	
	
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int testCase = 1; testCase <= TC; testCase++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			result = new int[N][N];
			
			//	배열 채우
			for(int j=0; j<N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k=0; k<N; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());				
				}
			}
			sb = new StringBuilder();
			sb.append("#").append(testCase).append(" ");
			
			for(int r=0;r<N;r++) {
				for(int c=0;c<N;c++) {
					search(r,c);					
				}
			}
			
			
			for(int i =0; i<result.length;i++) {
				System.out.println(Arrays.toString(result[i]));
			}
			System.out.println("==============================");
			
			
			subTotal(result);
			for(int i =0; i<result.length;i++) {
				System.out.println(Arrays.toString(result[i]));
			}
			
			findRoom(map, result);
			
			System.out.println(sb);
			max=0;
			room=1000000;
		}

	}	//	end of main
	
	public static int search(int r, int c) {
		
		if(result[r][c] != 0) {
			return result[r][c];
		}
		
		int[] dr = {0,1,0,-1};	//	우, 하, 좌, 상
		int[] dc = {1,0,-1,0};
		
		int tmp = map[r][c];
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(0<=nr && nr<N && 0<=nc && nc < N) {
				if(tmp + 1 == map[nr][nc]) {
					result[r][c] += search(nr, nc);
					break;
				}
			}
		}
		return result[r][c];
	}	//	end of search
	
	
	public static void subTotal(int[][] result) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int s = result[i][j];	// 	기준값
				
				for(int r=i+1;r<N;r++) {	//	행 부분합 탐색
					if(result[r][j]==s && result[r][j]==1)
						result[i][j]++;
					else	break;
				}
				
				for(int c=j+1;c<N;c++) {	//	열 부분합 탐색
					if(result[i][c]==s && result[i][c]==1)
						result[i][j]++;
					else	break;
				}
			}
		}
	}	//	end of sub total
	
	
	public static void findRoom(int[][] map, int[][] result) {
		for(int i=0;i<N;i++) {
			for(int j=0; j<N; j++) {
				int max_t = max;
				int room_t = room;
				if(result[i][j]>max_t || (result[i][j]==max_t && map[i][j]<=room_t)) {
					max=result[i][j];
					room=map[i][j];
				}
			}
		}
		sb.append(room).append(" ").append(max);
	}	// end of findRoom
	
	
}	// end of class



//for(int r=row; r<N; r++) {
//for(int c=col; c<N; c++) {
//	for(int i = 0; i < 4; i++) {
//		int nr = r + dr[i];
//		int nc = c + dc[i];
//		if(r<=nr && nr<N && c<=nc && nc < N) {
//			if(map[r][c] < map[nr][nc]) {
//				cnt++;
//				sol(map,nr,nc);
//			}
//			if(max < cnt) {
//				room = map[r][c];
//				max = cnt;
//				cnt = 0;
//			}
//			else {
//				sb.append(room).append(" ").append(max).append("\n");
//				max = 0;
//				return;
//			}
//		}
//	}
//}
//}


//재귀 풀이...
//for(int i=0;i<4;i++) {
//int nr = r + dr[i];
//int nc = c + dc[i];
//
//if(r<=nr && nr<N && c<=nc && nc < N) { // 	범위 넘어가지 않기	
//	if(map[r][c] < map[nr][nc]) {	//	나보다 크면 내 값+1하고 새로이 탐색
//		result[r][c]++;				
//		sol(map, result, nr, nc);
//	}				
//}
//}	//	end of for
//