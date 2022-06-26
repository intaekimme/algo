import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * 출발지점에서부터 나이트가 이동가능한 경로의 끝까지 탐색한다. (DFS) ---> BFS
 * 목표경로와 동일하면 카운트 값을 출력한다.	
 *
 */

// 380ms
public class Solution_BOJ_7562_나이트의이동_김인태 {
	
	static int I;
	static int tx, ty;		// 목표 x, 목표 y
	static int minCnt = Integer.MAX_VALUE;		//	출력할 내용
	static int cnt=0;	//	경로별 카운트
	
	
	static boolean[][] visited;		//	방문확인,	false: 방문 안함,	true: 방문함
	
	static int[] dx = {1,2,2,1,-1,-2,-2,-1};	//	12시 방향부터 시계방향
	static int[] dy = {2,1,-1,-2,-2,-1,1,2};
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			int cx, cy;		// 현재 x, 현재 y
			I = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			Point p = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			st = new StringTokenizer(br.readLine());
			tx = Integer.parseInt(st.nextToken());
			ty = Integer.parseInt(st.nextToken());
			
			sol(p);
			
		}	//	end of for
		
	}	//	end of main

	
	public static void sol(Point p) {
		visited = new boolean[I][I];
		int[][] map = new int[I][I];
		Queue<Point> queue = new LinkedList<Point>();
		
		queue.add(p);
		
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			int cx = cur.x;
			int cy = cur.y;
			if(cx==tx && cy==ty) {	//	목표지점에 도달하면 종
				System.out.println(map[tx][ty]);
			}else {
				for(int i=0;i<8;i++) {
					int nx = cx + dx[i];
					int ny = cy + dy[i];
					if(0<=nx && nx<I && 0<=ny && ny<I && !visited[nx][ny]) {
						visited[nx][ny]=true;
						map[nx][ny] = map[cx][cy]+1;
						queue.add(new Point(nx, ny));
					}
				}
			}
		}
	}
	
	private static class Point{
		int x;
		int y;
		
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
		
	}
}
