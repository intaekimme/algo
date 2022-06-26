import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_17143_낚시왕_G2 {

	static class Shark{
		int r;
		int c;
		int s;
		int d;
		int z;
		
		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;	//	속력
			this.d = d;	//	방향
			this.z = z;	//	크기
		}
		
	}
	
	private static int R, C, M, totalSize;
	private static ArrayList<Shark>[][] map;
	private static int[] dr = {0,-1,1,0,0};
	private static int[] dc = {0,0,0,1,-1};

	public static void main(String[] args) throws IOException {
		init();
		process();
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new ArrayList[R+2][C+2];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			map[r][c] = new ArrayList<Shark>();
			map[r][c].add(new Shark(r,c,s,d,z));
		}
	}
	
//	낚시왕은 처음의 1번 열의 한 칸 왼쪽에서 가장 오른쪽 열의 오른쪽 칸까지 이동하고 도착하면 이동을 멈춘다
//	낚시왕이 있는 열에 있는 상어 중에서 땅과 제일 가까운 상어를 잡는다. 상어를 잡으면 격자판에서 잡은 상어가 사라진다.
	public static void process() {
		for(int i=1; i<=C; i++) {	// 오른쪽 한 칸 이동
			hunt(i);	//	 상어 잡기
//			sharkMove();	//	상어 이동
		}
	}
	
	public static void hunt(int c) {
		for(int i=1; i<=R; i++) {
			if(map[i][c] != null) {
				int sharkSize = map[i][c].get(0).z;
//				System.out.println(sharkSize);
				totalSize += sharkSize;	//	낚시왕이 잡은 상어의 합
				map[i][c] = null;	//	상어를 잡으면 상어가 사라진다.
				break;
			}
		}
	}
	
	public static void sharkMove() {
		for(int i=1; i<=R; i++) {
			for(int j=1; j<=C; j++) {
				if(map[i][j] != null) {
					Shark s = map[i][j].get(0);
					
				}
			}
		}
	}
}
