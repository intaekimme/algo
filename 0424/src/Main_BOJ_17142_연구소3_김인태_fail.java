import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_17142_연구소3_김인태_fail {

	static class Virus implements Comparable<Virus> {
		int x;
		int y;
		int zeroCnt;
		
		public Virus(int x, int y, int zeroCnt) {
			this.x = x;
			this.y = y;
			this.zeroCnt = zeroCnt;
		}

		@Override
		public int compareTo(Virus o) {
			return o.zeroCnt - this.zeroCnt;
		}

		@Override
		public String toString() {
			return "Virus [x=" + x + ", y=" + y + ", zeroCnt=" + zeroCnt + "]";
		}
		
		
	}
	static ArrayList<Virus> vList;
	static ArrayList<Integer> done;
	static int N, M, minTime, zero, zero2, doneSize;
	static int[][] originMap, map;
	static boolean[][] visited;
	static int[] nums;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 N  = Integer.parseInt(st.nextToken());
		 M  = Integer.parseInt(st.nextToken());
		 
		 originMap = new int[N][N];
		 map = new int[N][N];
		 vList = new ArrayList<Virus>();
		 
		 
		 for(int i=0; i<N; i++) {
			 st = new StringTokenizer(br.readLine());
			 for(int j=0; j<N; j++) {
				 int val = Integer.parseInt(st.nextToken());
				 if(val==2) {
					 vList.add(new Virus(i, j, 0));
				 }
				 if(val == 0) zero++;
				 originMap[i][j] = val;
			 }
		 }
		 
		 int vSize = vList.size();
		 for(int i=0; i<vSize; i++) {
			 Virus v = vList.get(i);
			 int x = v.x;
			 int y = v.y;
			 
			 for(int j=0; j<4; j++) {
				 int nx = x + dx[j];
				 int ny = y + dy[j];
				 
				 if(round(nx, ny) && originMap[nx][ny] == 0) {
					 v.zeroCnt++;
				 }
			 }
		 }
		 
//		 vList.sort(null);
		 
		 done = new ArrayList<Integer>();
		 nums = new int[M];
		 visited = new boolean[N][N];
		 minTime = 3000;
		 doneSize = 0;
		 if(zero==0) System.out.println(0);
		 else {
			 comb(0,0);
//			 System.out.println(done.toString());
			 if(doneSize == done.size()) System.out.println(-1);
			 else System.out.println(minTime);
		 }
		 
		 
	}	//	end of main
	
	public static void bfs() {
		init();
		int time = 0;
		zero2 = zero;
		Queue<Virus> que = new LinkedList<Virus>();
		for(int i=0; i<M; i++) {
			que.add(vList.get(nums[i]));
		}
		
		while(!que.isEmpty()) {
			int qSize = que.size();
			if(zero2==0) break;
			for(int i=0; i<qSize; i++) {
				Virus v = que.poll();
				
				int x = v.x;
				int y = v.y;
				visited[x][y] = true;
				
				for(int j=0; j<4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					if(round(nx, ny) && !visited[nx][ny]) {
						if(map[nx][ny]==0) {
							map[nx][ny]=2;
							zero2--;
							que.add(new Virus(nx, ny, 0));							
						}
						if(map[nx][ny] == 2) {
							que.add(new Virus(nx, ny, 0));
						}
					}
				}
			}
//			printMap();
			time++;
//			System.out.println(time);
		}
		
		if(zero2==0 && time<minTime) minTime = time;
	}
	
	public static void comb(int start, int cnt) {
		if(cnt==M) {
//			System.out.println(Arrays.toString(nums));
//			printPoint();
//			printOriginMap();
			bfs();
			if(zero2>0) doneSize++;
			done.add(zero2);
//			System.out.println(minTime);
//			System.out.println();
			return;
		}
		
		for(int i=start; i<vList.size(); i++) {
			nums[cnt] = i;
			comb(i+1, cnt+1);
		}
	}
	
	public static boolean round(int nx, int ny) {
		return nx>=0 && nx<N && ny>=0 && ny<N;
	}

	public static void init() {
		for(int i=0; i<N; i++) {
			Arrays.fill(visited[i], false);
		}
		
		for(int i=0; i<N; i++) {
			System.arraycopy(originMap[i], 0, map[i], 0, N);
		}
		
	}
	
	
//	public static void printPoint() {
//		for(int i=0; i<M; i++) {
//			System.out.println(vList.get(nums[i]));
//		}
//	}
//	
//	public static void printMap() {
//		for(int i=0; i<N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
//		System.out.println("----------------------");
//	}
//	
//	public static void printOriginMap() {
//		for(int i=0; i<N; i++) {
//			System.out.println(Arrays.toString(originMap[i]));
//		}
//		System.out.println("----------------------");
//	}
}
