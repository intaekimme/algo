import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 미생물격리_sol_me {

	static int[] dr = {-1, 1, 0, 0};	// 상, 우, 좌, 하
	static int[] dc = {0, 0, -1, 1};	//	1, 2, 3, 4
	static ArrayList<mi> mrr;
	static int N,M,K, map[][];
	
	static class mi{
		int r, c, num, dir;

		public mi(int r, int c, int num, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.num = num;
			this.dir = dir;
		}		
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int tc = 0; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				map[0][i] = -1;
				map[N-1][i] = -1;
				map[i][0] = -1;
				map[N-1][i] = -1;
			} // 테두리 설정	
			
			mrr = new ArrayList<mi>(K);
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());				
				int c = Integer.parseInt(st.nextToken());				
				int num = Integer.parseInt(st.nextToken());				
				int dir = Integer.parseInt(st.nextToken());	
				mrr.add(new mi(r,c,num,dir));
				
				map[r][c]=num;
			}
			
			// 시뮬레이션 시작
			for(int t=M; t>0; t--) {
				process();
			}
		}
	}


	private static void process() {
		for (int i = 0; i < K; i++) {
			go(mrr.get(i));
		}
		
	}

	// micro go 구현이 너무 까다로운데;;;	
	private static void go(미생물격리_sol_me.mi mi) {
		int nr = mi.r + dr[mi.dir-1];
		int nc = mi.c + dc[mi.dir-1];
		
//		map[mi.r][mi.c]=0;
//		mi.r = nr;
//		mi.c = nc;
		if(map[nr][nc]>=0) {	//	테두리가 아닌 경우
			if(map[nr][nc] > mi.num) {	//	새로 가는 곳의 군집이 나보다 큰 경우
				mi micro = find(nr, nc);
				micro.num += mi.num;
				mi.num=0;
			}else {	//	새로 가는 곳의 군집이 나보다 작은경우
				mi micro = find(nr, nc);
				mi.num += micro.num;
				
			}
		}
		map[nr][nc] = mi.num;
		
	}


	private static mi find(int nr, int nc) {
		for(int i=0; i<mrr.size(); i++) {
			mi micro = mrr.get(i);
			int r = micro.r;
			int c = micro.c;
			if(r==nr && c==nc) return micro;
		}
		return null;
	}

}
