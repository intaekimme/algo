import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 단순 그리디라 생각하면 틀린다. 백트래킹을 가미해야 한다.
 * go2 함수와 같이 불린형을 함수를 이용해 백트래킹하는 것을 생각해봐야 함.
 * @author kit938639
 *
 */

public class Main_BOJ_3109_빵집 {

	private static char[][] map;
	private static int R, C, cnt;
	
	private static int[] dx = {-1,0,1};
	private static int[] dy = {1,1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for(int r=0; r<R; r++) {
			map[r] = br.readLine().toCharArray();
		}
//		for(int r=0; r<R; r++) {
//			System.out.println(Arrays.toString(map[r]));
//		}
		
		cnt=0;
//		for(int i=0; i<R; i++) {
//			go(i,0);
//		}
		
		for(int i=0; i<R; i++) {
			cnt+=go2(i,0);
		}
		
		System.out.println(cnt);
	}

	private static void go(int x, int y) {
		for(int i=0; i<3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(round(nx, ny) && map[nx][ny]=='.') {
				if(y==C-1) {
//			map[x][y]='x';
					cnt++;
//			System.out.println(cnt);
					return;
				}
				map[x][y]='x';
//				print();
				go(nx, ny);
				return;
			}
		}
	}
	
	
	private static int go2(int x, int y) {
		if(x<0 || x>=R) return 0;
		if(map[x][y]=='x') return 0;
		map[x][y]='x';
		if(y==C-1) return 1;	//	
		if(go2(x-1, y+1)==1) return 1;	//	우상
		if(go2(x, y+1)==1) return 1;	// 우
		if(go2(x+1, y+1)==1) return 1;	// 우하
		return 0;
	}

	private static boolean round(int x, int y) {
		return x>=0 && x<R && y>=0 && y<C;
	}
	
	private static void print() {
		for(int i=0; i<R; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println("----------------");
	}
}
