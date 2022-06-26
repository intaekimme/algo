import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1: 익은 토마토
 * 0: 익지 않은 토마토
 * -1: 토마토가 들어있지 않은 칸
 * 메모리 제한 : 256MB = 268435456
 * 1000 * 1000 * 4 =    4000000
 * 
 * 4방탐색 bfs완탐?
 * @author kit938639
 *
 */



public class Solution_BOJ_7576_토마토_G5_김인태_636ms {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	//	2 ≤ M,N ≤ 1,000
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[M][];
		
		Queue<int[]> q = new LinkedList<int[]>();
		
		int unripe = 0;
		for(int i=0;i<M;i++) {
			map[i] = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int val = Integer.parseInt(st.nextToken());
				if(val==1) {
					q.offer(new int[] {i,j});
				}
				else if(val==0) {
					unripe++;
				}
				map[i][j] = val;
			}
		}
		if(unripe==0) {
			System.out.println(0);
			return;
		}
		
//		for (int i = 0; i < M; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		
		int[] dr = {-1,0,1,0};	//시계방향
		int[] dc = {0,1,0,-1};
		
		int day = -1;
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(size-->0) {
				int[] cur = q.poll();
				int r = cur[0];
				int c = cur[1];
				
				for(int i=0;i<4;i++) {
					int nr = r + dr[i];
					int nc = c +dc[i];
					
					if(0<=nr && nr<M && 0<=nc && nc<N && map[nr][nc]==0) {
						map[nr][nc]=1;
						unripe--;
						q.offer(new int[] {nr,nc});
					}
				}
			}
			day++;
		}
		
		if(unripe>0) {
			System.out.println(-1);
		}else {
			System.out.println(day);
		}
	}

}
