import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 말은 상하좌우로 인접한 네 칸 중의 한 칸으로 이동할 수 있는데, 
 * 새로 이동한 칸에 적혀 있는 알파벳은 지금까지 지나온 모든 칸에 적혀 있는 알파벳과는 달라야 한다. 
 * 즉, 같은 알파벳이 적힌 칸을 두 번 지날 수 없다.
 * 
 * ABCDEFGHIJKLMNOPQRSTUVWXYZ
 * 10100000000000000000000000
 * @author kit938639
 *
 */



public class Solution_BOJ_1987_알파벳_G4_872ms {

	//static char[][] map;
	static int R, C;
	static int[] dr = {-1,0,1,0};	//	4방탐색
	static int[] dc = {0,1,0,-1};	
	static int cnt=1;	//	경로별 카운트
	static int ans=1;	//	정답
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[R][];
		for(int i=0;i<R;i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		boolean[] visited = new boolean[26];
		// 0 1 2 3 4...24 25
		// A(65) B C D E...Y  Z(90)
		
		// 0,0 부터 시
		dfs(0, 0, map, visited);				
		
		System.out.println(ans);
		
	}	//	end of main
	
	public static void dfs(int r, int c, char[][] map, boolean[] visited) {
		//	다시 방문 하지 않게 true
		visited[map[r][c]-65] = true;
		
		// inductive part
		for(int i=0; i<4; i++) {		
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(0<=nr && nr<R && 0<=nc && nc < C && !visited[map[nr][nc]-65]) {	//	map 범위내, 방문하지 않은곳
				ans = Math.max(++cnt, ans);	//	새로 찾은 경로가 이전까지의 경로크기보다 크면 갱신
				dfs(nr, nc, map, visited);	//	새로운 지점부터 탐색 시작
			}
		}
		//	더이상 탐색이 안되서 되돌아감
		--cnt;
		visited[map[r][c]-65] = false;
	}	//	end of dfs

}	//	end of class

