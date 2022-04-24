import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 구멍과 겉 테두리를 판단해서 기록해야함.
 * 그래야 구멍과 맞닿은 치즈는 바로 안지우고 테두리부터 지울 수 있음
 * 테두리를 한 번 지우고 난 후에는 구멍과 접촉한 부분의 치즈도 계속 지우기 시작
 * 치즈의 갯수가 0이되면 0이 되기 전 숫자가 모두 녹기 1시간 전 치즈 숫자
 * 
 * 구멍과 테두리를 그러면 어떻게 판단하고 기록할 것인가?
 * @author kit938639
 *
 */


public class Solution_BOJ_2638_치즈_G4_김인태_344ms {
	static final int rel_blank = 3;
	static final int cheese = 1;
	static final int blank = 0;
	static final int melt = 5;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int n, m, time;
	static int[][] map = new int [101][101];
	static int[][] visit = new int [101][101];
	
	static class Point{
		int x;
		int y;
		
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		search();
		System.out.println(time);
	}
	
	public static void bfs() {
		Queue<Point> q = new LinkedList<Point>();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				visit[i][j]=0;
			}
		}
		
		Point p = new Point(0,0);
		q.offer(p);
		
		visit[0][0] = 1;
		while(!q.isEmpty()) {
			Point t = q.poll();
			int r = t.x;
			int c = t.y; 
			
			for(int i=0; i<4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(0<=nr && nr <n && 0<=nc && nc<m && 
						visit[nr][nc] == 0 && map[nr][nc]!=cheese) {
					visit[nr][nc]=1;
					map[nr][nc] = rel_blank;
					q.offer(new Point(nr, nc));
				}
			}

		}
	}
	
	public static void search() {
		boolean flag = false;
		while(true) {
			
			bfs();
			
			flag = false;
			for(int r=0; r<n; r++) {
				for(int c=0; c<m; c++) {
					if(map[r][c] == cheese) {
						int cnt=0;
						for(int i=0; i<4; i++) {
							int nr = r + dr[i];
							int nc = c + dc[i];
							if(0<=nr && nr <n && 0<=nc && nc<m && 
									 map[nr][nc]==rel_blank) {
								flag = true;
								cnt++;
							}
						}
						
						if(cnt>=2) map[r][c]=melt;		
					}
				}
			}
			
			if(flag) {
				for(int r=0; r<n; r++) {
					for(int c=0; c<m; c++) {
						if(map[r][c]==melt) {
							map[r][c] = rel_blank;
						}
					}
				}
			}
			time++;
			
			flag = false;
			
			for(int r=0; r<n; r++) {
				for(int c=0; c<m; c++) {
					if(map[r][c]==cheese) {
						flag = true;
					}
				}
			}
			
			if(!flag) break;
		}	//	end of while
		
	}	//	end of search
	
}	//	end of class
