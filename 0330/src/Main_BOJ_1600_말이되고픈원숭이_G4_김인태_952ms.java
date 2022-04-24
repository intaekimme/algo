import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_1600_말이되고픈원숭이_G4_김인태_952ms {
	static int K, W, H;
	static int[][] map;
	static boolean[][][] visit;

	static class Pair{
		int x;
		int y;
		int cnt;
		int k;
		
		Pair(int x, int y, int cnt, int k){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.k = k;
		}
	}
    
	static int[] dx = {1,-1, 0, 0};
	static int[] dy = {0, 0, 1, -1}; 
	static int[] hx = {-2, -2, 2, 2, 1, -1, 1, -1};
	static int[] hy = {1, -1, 1, -1, 2, 2, -2, -2};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		visit = new boolean[H][W][31];
		for(int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visit[0][0][0] = true;
		bfs();
		
	}
	
	private static void bfs() {
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(0,0,0,K));
		
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			int curX = cur.x;
			int curY = cur.y;
			int cnt = cur.cnt;
			int curK = cur.k;
			
			if(curX == W-1 && curY == H-1) {
				System.out.println(cnt);
				return;
			}
			
			if(curX >= W || curY >= H || curX < 0 || curY < 0) continue;
			if(map[curY][curX] == 1) continue;
			if(visit[curY][curX][curK]) continue;
			visit[curY][curX][curK] = true;
			
			for(int i = 0; i < 4; i++) {
				int nextX = curX + dx[i];
				int nextY = curY + dy[i];
				
				q.offer(new Pair(nextX, nextY, cnt+1,  curK));
				
			}
			
			if(curK == 0) continue;
			for(int i = 0; i < 8; i++) {
				int nextX = curX + hx[i];
				int nextY = curY + hy[i];
				
				q.offer(new Pair(nextX, nextY, cnt+1, curK-1));
				
			}
				
			
		}
		System.out.println("-1");
		return;
		
	}

}
