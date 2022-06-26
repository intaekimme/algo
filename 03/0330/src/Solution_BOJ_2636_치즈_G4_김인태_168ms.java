import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_BOJ_2636_치즈_G4_김인태_168ms {
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	static int n, m;
	static int[][] map = new int [101][101];
	static boolean[][] visit = new boolean[101][101];
	static boolean[][] help = new boolean[101][101];
	
	static class Point{
		int y;
		int x;
		
		Point(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int count = 0;
		int answer = 0;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp==1) {
					map[i][j] = 1;
					count++;				
				}
				help[i][j]=true;
			}
		}
		
		int hour = 0;
		while(count > 0) {
			hour++;
			Queue<Point> q = new LinkedList<Point>();
			
			q.offer(new Point(0,0));
			visit[0][0] = true;
			help[0][0] = false;
			
			while(!q.isEmpty()) {
				Point t = q.poll();
				int y = t.y;
				int x = t.x;
				
				for(int i=0; i<4; i++) {
					int ny = y + dy[i];
					int nx = x + dx[i];
					
					if(ny >= 0 && ny < n && nx >= 0 && nx < m && !visit[ny][nx] && map[ny][nx] == 0) {
						visit[ny][nx] = true;
						help[ny][nx] = false;
						q.offer(new Point(ny, nx));
					}
				}
			}
			List<Point> v = new ArrayList<Point>();
			int removing = 0;
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					visit[i][j] = false;
					if(map[i][j] == 1) {
						for(int k=0; k<4; k++) {
							int ny = i + dy[k];
							int nx = j + dx[k];
							
							if(ny >= 0 && ny < n && nx >= 0 && nx < m && !help[ny][nx]) {
								v.add(new Point(i,j));
								break;
							}
						}
					}
				}
			}
			
			removing = v.size();
			for(int r = 0; r < removing; r++) {
				int y = v.get(r).y;
				int x = v.get(r).x;
				help[y][x] = false;
				map[y][x] = 0;
			}
			
			if(count - removing == 0) {
				answer = removing;
			}
			count -= removing;
		}
		
		System.out.println(hour);
		System.out.println(answer);
		
	}
	
}
