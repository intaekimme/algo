import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_4041_활주로건설_sol {

	private static int N;
	private static int L;
	private static int[][] ma;
	private static int[][] mb;
	private static int[] check;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC  = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			ma = new int[N][N];
			mb = new int[N][N];
			
			for(int i = 0;i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					ma[i][j] = mb[j][i] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0;
			check = new int[N];
			for(int i = 0;i < N; i++) {
				if(go(ma, i)) cnt++;
				if(go(mb, i)) cnt++;
			}
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}	//	end of main


	private static boolean go(int[][] map, int r) {
		Arrays.fill(check, 0);
		for(int c = 0; c < N-1; c++) {
			if(Math.abs(map[r][c] - map[r][c+1]) >= 2) {
				return false;
			}
			else if(map[r][c] - map[r][c+1] == 1){ // 차이가 1이면 내리막길
				if(!checkDown(map, r, c)) {
					return false;
				}
			} else if(map[r][c] - map[r][c+1] == -1){ // 차이가 -1 이면 오르막길
				if(!checkUp(map, r,c)) {
					return false;
				}
			}
			// 차이가 0이면 ok 넘어가기
		}
		return true;
	}
	/** 오르막길, (r,c) 위치도 포함해서 경사로를 놓음*/
	private static boolean checkUp(int[][] map, int r, int c) {
		int temp = c - L + 1;
		if(temp < 0) return false;// 낮은칸에 경사로를 놓을 공간이 있어야 한다.
		for(int i = c; i >= temp; i--){ 
			if(map[r][c] != map[r][i] || check[i] == 1) {	// 경사로를 놓을 곳은 같은 높이여야한다. 경사로가 이미 놓여있으면 안된다.
				return false;
			}
		}
		for(int i = c; i >= temp; i--) {
			check[i] = 1;
		}
		return true;
	}


	/** 내리막길, (r,c) 위치는 미포함해서 경사로를 놓음*/
	private static boolean checkDown(int[][] map, int r, int c) {
		int temp = c + L;
		if(temp >= N) return false;	// 낮은칸에 경사로를 놓을 공간이 있어야 한다.
		for(int i = c + 1; i <= temp; i++) {
			if(map[r][c+1] != map[r][i] || check[i] == 1) { // 경사로를 놓을 곳은 같은 높이여야한다. 경사로가 이미 놓여있으면 안된다.
				return false;
			}
		}
		
		for(int i = c + 1; i <= temp; i++) {
			check[i] = 1;
		}
		return true;
	}

}
