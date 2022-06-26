import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_16236_아기상어_G3 {

	static class fish{
		int x, y, distance;

		public fish(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
		
	}
	
	private static int N, age, size=0, cnt=0, time=0;
	private static int[][] map;
	private static int[] dx = {-1,1,0,0};
	private static int[] dy = {0,0,-1,1};
	
	private static PriorityQueue<fish> feed = new PriorityQueue<fish>(new Comparator<fish>() {

		@Override
		public int compare(fish o1, fish o2) {
			if(o1.distance==o2.distance) {
				if(o1.x==o2.x) return o1.y-o2.y;
				else return o1.x-o2.x;
			}
			return o1.distance-o2.distance;
		}
	});
	
	static Queue<fish> shark = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int val = Integer.parseInt(st.nextToken());
				map[i][j] = val;
				if(val==9) {
					shark.add(new fish(i,j,0));
					map[i][j]=0;
				}
			}
		}
		
		age = 2;
		find();

	}

	public static void find() {
		boolean[][] visited = new boolean[N][N];
		while(true) {
			for(int i=0;i<N;i++)
				Arrays.fill(visited[i], false);
			while(!shark.isEmpty()) {
				fish temp = shark.poll();
				visited[temp.x][temp.y] = true;
				
				for(int i=0;i<4;i++) {
					int nx = temp.x + dx[i];
					int ny = temp.y + dy[i];
					if(range(nx, ny) && !visited[nx][ny]) {
						if(0<map[nx][ny] && map[nx][ny] <7) {
							if(map[nx][ny]<age) {
								feed.add(new fish(nx, ny, temp.distance+1));	// dx, dy 거리 1차이
								shark.add(new fish(nx, ny, temp.distance+1));
								visited[nx][ny] = true;
							}
							else if(map[nx][ny]==age) {
								shark.add(new fish(nx, ny, temp.distance+1));
								visited[nx][ny] = true;
							}
						}
						else if(map[nx][ny]==0){
							shark.add(new fish(nx, ny, temp.distance+1));
							visited[nx][ny] = true;
						}
					}
				}
			}
			
			if(!feed.isEmpty()) eat();
			else break;
		}
		System.out.println(time);
	}
	

	public static boolean range(int x, int y) {
		return x>=0 && x<N && y>=0 && y<N;
	}
	
	private static void eat() {
		fish pray = feed.poll();
		
		cnt++;
		if(cnt==age) {
			age++;
			cnt=0;
		}
		
		shark.add(new fish(pray.x, pray.y, 0));
		time+=pray.distance;
		map[pray.x][pray.y]=0;
		feed.clear();
	}
	
}
