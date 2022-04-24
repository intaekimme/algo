import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_14502_연구소_388ms {

	static int N, M, max, num[], input[], arr[][], origin[][];
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static ArrayList<int[]> virus;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		max=0;	//	최대 안전구역 갯수
		
		arr = new int [N*M][];	// 맵의 1차원 배열에 해당. [N*M][2]로 좌상단 우하단 방향순으로 좌표값이 들어가 있다.	
		input = new int[N*M];	// 경우의 수를 뽑기위한 배열, arr과 1:1 대응
		
		origin = new int [N][M];	//	원본 맵 배열
		virus = new ArrayList<int[]>();	//	바이러스 배열, 바이러스의 위치 정보 들어가있다.
		
		int idx=0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				input[idx] = idx;
				arr[idx++] = new int[] {i,j};
				
				int val = Integer.parseInt(st.nextToken());
				if(val==2)
					virus.add(new int[] {i,j});
				origin[i][j] = val;
			}
		}
		
		process(arr, origin);
		
		System.out.println(max);
	}


	private static void process(int[][] arr, int[][] origin) {
		num = new int [3];
		comb(0, 0, N*M);	//	조합으로 경우의수를 센다.
		
	}	

	/**
	 * N*M의 2차원 맵을 1차원 배열로 보고 N*M개 중 3개를 뽑는 경우의 수를 구한다.
	 * 
	 * @param cnt
	 * @param start
	 * @param len
	 */
	private static void comb(int cnt, int start, int len) {
		if(cnt==3) {
//			System.out.println(Arrays.toString(num));
			int m =bfs(num);
			if(max<m) max=m;
			return;
		}
		for(int i = start; i<len; i++) {
			num[cnt] = input[i];	//	number[ , , ]
			//	다음수 뽑으러 가기
			comb(cnt+1, i+1, len);
		}
	}

/**
 * 
 * @param num2 벽을 넣을 경우의 수, 조합
 * @return
 */
	private static int bfs(int[] num2) {
		int[][] map = copy();
		boolean[][] visited = new boolean[N][M];
		for(int i=0; i<3; i++) {
			int x = arr[num2[i]][0];
			int y = arr[num2[i]][1];
			if(map[x][y]!=0) return 0;	//	2일때도 바이러스를 넣었어서 틀려서 수정했다.
			else map[x][y] = 1;
		} // 벽 세우기
		
		Queue<int[]> q = new LinkedList<int[]>();
		for(int i=0; i<virus.size(); i++) {
			int[] e = virus.get(i);
			q.offer(e);
		}
		
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			visited[x][y] = true;
			q.poll();
			
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
				if(!visited[nx][ny] && map[nx][ny]==0) {
					map[nx][ny]=2;
					q.offer(new int[] {nx, ny});
				}
			}
		}
		
		
		int cnt=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) cnt++;
			}
		}
		
		return cnt;
	}

	
/**
 * 배열 복사
 * @return
 */
	private static int[][] copy() {
		int[][] map = new int [N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j] = origin[i][j];
			}
		}
		return map;
	}
}
