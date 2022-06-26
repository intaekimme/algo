import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_20058_마법사상어와파이어스톰_G4_508ms {

	private static int N, Q, mSize;
	private static int[] ml = {1,2,4,8,16,32,64};
	private static int[][] map;
	private static boolean[][] visited, isMelt;
	private static int[] dx = {-1,0,1,0};
	private static int[] dy = {0,1,0,-1};	

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		mSize = ml[N];
		map = new int[mSize][mSize];
		
		for(int i=0; i<mSize; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<mSize; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<Q; i++) {
			spell(Integer.parseInt(st.nextToken())); 
		}
		
		print();
		
	}

	private static void spell(int L) {
		int jump = (int) Math.pow(2, L);
		
		for(int i=0; i<mSize; i+=jump) {
			for(int j=0; j<mSize; j+=jump) {
				rotate(i,j,jump);
			}
		}
		melt();
	}
	
	public static void rotate(int x, int y, int size) {

		int[][] copyMap = new int[size][size];
		int[][] rotateMap = new int[size][size];
		
		int xSize = x + size;
		for(int i=x, j=0; i<xSize; i++, j++) {
			System.arraycopy(map[i], y, copyMap[j], 0, size);
		}

		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				rotateMap[j][size-1-i] = copyMap[i][j];
			}
		}
		
		for(int i=0, j=x; i<size; i++, j++) {
			System.arraycopy(rotateMap[i], 0, map[j], y, size);
		}
		
	}
	
	public static void melt() {
		isMelt = new boolean[mSize][mSize];
		for(int i=0; i<mSize; i++) {
			for(int j=0; j<mSize; j++) {
				isMelt[i][j] = checkMelt(i,j);
			}
		}
		for(int i=0; i<mSize; i++) {
			for(int j=0; j<mSize; j++) {
				if(isMelt[i][j] && map[i][j]>0) map[i][j]--;
			}
		}		
	}
	public static boolean checkMelt(int x, int y) {
		int cnt=0;
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx<0 || nx>=mSize || ny<0 || ny>=mSize) continue;
			if(map[nx][ny]>0) cnt++;
		}
		if(cnt<3) return true;
		return false;
	}
	
	public static int bfs(int x, int y) {
		int localArea=0;
		Queue<int[]> que = new LinkedList<int[]>();
		
		que.add(new int[] {x,y});
		visited[x][y] = true;
		
		while(!que.isEmpty()) {
			int[] curP = que.poll();
			int curX = curP[0];
			int curY = curP[1];
			localArea++;
			for(int i=0; i<4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				if(nx<0 || nx>=mSize || ny<0 || ny>=mSize) continue;
				if(!visited[nx][ny] && map[nx][ny]>0) {
					visited[nx][ny] = true;
					que.add(new int[] {nx, ny});
				}
			}
		}
		
		return localArea;
		
	}
	
	public static void print() {
		int sum=0;
		int area=0;
		visited = new boolean[mSize][mSize];
		for(int i=0; i<mSize; i++) {
			for(int j=0; j<mSize; j++) {
				if(!visited[i][j] && map[i][j]>0) {
					int res = bfs(i,j);
					area = area < res ? res : area;
				}
				sum+=map[i][j];
			}
		}
		
//		for(int k=0; k<mSize; k++) {
//			System.out.println(Arrays.toString(map[k]));
//		}
//		System.out.println("========================");
		System.out.println(sum);
		System.out.println(area);
	}

}
