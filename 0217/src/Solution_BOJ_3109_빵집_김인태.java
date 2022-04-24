import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 모든 파이프라인은 첫째 열에서 시작, 마지막 열에서 끝
 * 각 칸은 오른쪽, 오른쪽 위 대각선, 오른쪽 아래 대각선으로 연결
 * 파이프라인을 여러 개 설치, 이 경로는 겹칠 수 없고, 서로 접할 수도 없다
 * 파이프라인의 최대 개수를 구하기
 * @author kit938639
 *
 */


public class Solution_BOJ_3109_빵집_김인태 {

//	static char[][]
	
	static int[] dr = {-1,0,1};
	
	static int R, C;
	static char[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][];
		
		for(int i=0; i<R; i++) {
			map[i]=br.readLine().toCharArray();
		}
		
		int cnt=0;
		for(int r=0;r<R;r++) {
			if(go(r,0)) {
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}
	
	
//	public static void sol(int row, int col, int R, int C, char[][]map) {
//		if(row==R)	return;
//		if(col==C) {
//			cnt++;
//		}
//		while(row!=R) {
//			for(int i=0;i<3;i++) {
//				int nr = row+dr[i];
//				int nc = col+1;
//				if(0<=nr && nr<R && nc<C && map[nr][nc]!='x') {
//					map[row][col]='x';
//					sol(nr,nc,R,C,map);
//				}
//			}
//			map[row][col]='x';
//			row++;
//			col=0;
//		} 
//	}
	
	
	public static boolean go(int r, int c) {
		map[r][c]='x';
		
		if(c==C-1) {
			return true;
		}
		
		boolean isConnect = false;
		int nr = r-1, nc = c+1;
		if(0<=nr  && map[nr][nc] == '.') {
			isConnect=go(nr,nc);
		}
		if(isConnect)	return true;
		
		nr=r;
		if(			 map[nr][nc] == '.') {
			isConnect = go(nr,nc);
		}
		if(isConnect)	return true;
		
		nr=r+1;
		if(nr<R  && map[nr][nc] == '.') {
			isConnect=go(nr,nc);
		}		
		return isConnect;
	}

}
